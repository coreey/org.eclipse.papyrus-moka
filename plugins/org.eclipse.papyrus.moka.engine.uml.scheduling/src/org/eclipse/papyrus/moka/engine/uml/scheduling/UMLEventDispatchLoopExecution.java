/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   CEA LIST - Bug 551906
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.engine.uml.scheduling;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.papyrus.moka.animation.engine.AnimationService;
import org.eclipse.papyrus.moka.animation.engine.rendering.AnimationEngine;
import org.eclipse.papyrus.moka.animation.engine.rendering.DiagramHandler;
import org.eclipse.papyrus.moka.debug.assistant.DebugAssistantException;
import org.eclipse.papyrus.moka.debug.service.IDebugService;
import org.eclipse.papyrus.moka.engine.uml.debug.listeners.UMLSemanticVisitorExecutionListener;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IClassifierBehaviorInvocationEventAccepter;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IObjectActivation;
import org.eclipse.papyrus.moka.fuml.loci.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IValue;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IObject_;
import org.eclipse.papyrus.moka.kernel.SuspensionReasons;
import org.eclipse.papyrus.moka.kernel.assistant.Suspension;
import org.eclipse.papyrus.moka.kernel.engine.IExecutionEngine;
import org.eclipse.papyrus.moka.kernel.scheduling.control.IExecutionLoop;
import org.eclipse.papyrus.moka.kernel.service.IExecutionEngineService;
import org.eclipse.papyrus.moka.kernel.service.ServiceRegistry;
import org.eclipse.uml2.uml.Element;

public class UMLEventDispatchLoopExecution extends UMLTaskExecution implements IUMLEventDispatchLoopExecution {

	/**
	 * The object activation that handles this event dispatch loop
	 */
	protected IObjectActivation dispatchLoop;

	/**
	 * Enable safe access to the dispatch loop
	 */
	protected ReentrantLock dispatchLoopLock;

	/**
	 * Number of signals to be dispatched
	 */
	private int signalCount;

	/**
	 * Enable safe access to the signal count
	 */
	private ReentrantLock signalCountLock;

	public UMLEventDispatchLoopExecution(IExecutionLoop loop) {
		super(loop);
		dispatchLoopLock = new ReentrantLock(true);
		signalCount = 0;
		signalCountLock = new ReentrantLock(true);
	}

	/**
	 * It cannot be executed if a valid dispatch loop is available
	 */
	@Override
	public boolean canExecute() {
		boolean canExecute = false;
		if (!dispatchLoopLock.isHeldByCurrentThread()) {
			dispatchLoopLock.lock();
		}
		canExecute = dispatchLoop != null;
		if (dispatchLoopLock.isHeldByCurrentThread()) {
			dispatchLoopLock.unlock();
		}
		return canExecute;
	}

	/**
	 * @see IUMLEventDispatchLoopExecution#newSignalArrival()
	 */
	public void newSignalArrival() {
		if (!signalCountLock.isHeldByCurrentThread()) {
			signalCountLock.lock();
		}
		signalCount++;
		if (this.signalCount == 1) {
			schedule();
		}
		if (signalCountLock.isHeldByCurrentThread()) {
			signalCountLock.unlock();
		}
	}

	/**
	 * @see IUMLEventDispatchLoopExecution#dispatchNextEvent()
	 */
	public void dispatchNextEvent() {
		if (!dispatchLoopLock.isHeldByCurrentThread()) {
			dispatchLoopLock.lock();
		}
		try {
			dispatchLoop.dispatchNextEvent();
		} catch (DebugAssistantException debugAssistantException) {
			List<IExecutionEngineService<IExecutionEngine>> debugServices = ServiceRegistry.getInstance()
					.getService(IDebugService.class);
			if (!debugServices.isEmpty()) {
				fireErrorDetectionError((IDebugService<?, ?>) debugServices.get(0), debugAssistantException);
			}
			// debugAssistantException.printStackTrace();
		} catch (Exception e) {
			// e.printStackTrace();
		} finally {
			if (dispatchLoopLock.isHeldByCurrentThread()) {
				dispatchLoopLock.unlock();
			}
		}
	}

	protected void fireErrorDetectionError(IDebugService<?, ?> executionEngineService,
			DebugAssistantException debugAssistantException) {
		Suspension suspension = new Suspension(debugAssistantException.getDebugAssistant(),
				SuspensionReasons.ERROR_DETECTION);
		if (executionEngineService.shouldContinueInDebugAssistant(debugAssistantException.getDebugAssistant().getAssistantID())) {
			Element node = debugAssistantException.getVisitorNode();
			ISemanticVisitor visitor = debugAssistantException.getVisitor();
			if (node != null) {
				// Open diagrams
				DiagramHandler diagramManager = getDiagramHandler(debugAssistantException);
				if (diagramManager != null) {
					if (!diagramManager.hasOpenedDiagram(node)) {
						diagramManager.openDiagrams(node);
					} else {
						diagramManager.selectDiagrams(node);
					}
				}

				// Ask to every UMLSemanticVisitorExecution service to suspend
				Collection<IExecutionEngineService<IExecutionEngine>> allServices = ServiceRegistry.getInstance()
						.getAllServices();
				for (IExecutionEngineService<IExecutionEngine> service : allServices) {
					if (service instanceof UMLSemanticVisitorExecutionListener) {
						if (!(service instanceof IDebugService)) {
							((UMLSemanticVisitorExecutionListener) service).nodeSuspended(visitor, suspension);
						}
					}
				}
				// The debug service suspend the thread so it should works in last
				if (executionEngineService instanceof UMLSemanticVisitorExecutionListener) {
					((UMLSemanticVisitorExecutionListener) executionEngineService).nodeSuspended(visitor, suspension);
				}
			}
		}
	}

	private DiagramHandler getDiagramHandler(DebugAssistantException debugAssistantException) {
		List<IExecutionEngineService<IExecutionEngine>> animationServices = ServiceRegistry.getInstance()
				.getService(AnimationService.class);
		if (!animationServices.isEmpty()) {
			AnimationService animationService = (AnimationService) animationServices.get(0);
			AnimationEngine animationEngine = animationService.getEngine();
			if (animationEngine != null) {
				return animationEngine.getDiagramHandler();
			}
		}
		return null;
	}

	/**
	 * Dispatch the next event. If events remain to be dispatched then include this
	 * execution to the loop
	 */
	@Override
	public void execute() {
		dispatchNextEvent();
		if (!signalCountLock.isHeldByCurrentThread()) {
			signalCountLock.lock();
		}
		signalCount--;
		if (signalCount > 0) {
			executionLoop.include(this);
		}
		if (signalCountLock.isHeldByCurrentThread()) {
			signalCountLock.unlock();
		}
	}

	@Override
	public IValue new_() {
		UMLEventDispatchLoopExecution dispatchLoopExecution = new UMLEventDispatchLoopExecution(executionLoop);
		dispatchLoopExecution.dispatchLoop = dispatchLoop;
		return dispatchLoopExecution;
	}

	@Override
	public String toString() {
		return "EventDispatchLoopExecution(" + dispatchLoop + ")";
	}

	@Override
	public void suspend() {
		System.out.println("Suspend -> " + this);
		if (!dispatchLoopLock.isHeldByCurrentThread()) {
			dispatchLoopLock.lock();
		}
		for (IClassifierBehaviorInvocationEventAccepter cbInvocation : dispatchLoop
				.getClassifierBehaviorInvocations()) {
			// TODO - classifier behaviors shall be suspended
			cbInvocation.getExecution();
		}
		if (dispatchLoopLock.isHeldByCurrentThread()) {
			dispatchLoopLock.unlock();
		}
	}

	@Override
	public void resume() {
		System.out.println("Resume -> " + this);
	}

	@Override
	public void terminate() {
		if (!dispatchLoopLock.isHeldByCurrentThread()) {
			dispatchLoopLock.lock();
		}
		dispatchLoopLock.lock();
		IObject_ context = getContext();
		if (context != null) {
			context.destroy();
		}
		dispatchLoop = null;
		if (dispatchLoopLock.isHeldByCurrentThread()) {
			dispatchLoopLock.unlock();
		}
	}

	@Override
	public void setObjectActivation(IObjectActivation objectActivation) {
		if (!dispatchLoopLock.isHeldByCurrentThread()) {
			dispatchLoopLock.lock();
		}
		dispatchLoop = objectActivation;
		if (dispatchLoopLock.isHeldByCurrentThread()) {
			dispatchLoopLock.unlock();
		}
	}

	public IObject_ getContext() {
		IObject_ context = null;
		if (!dispatchLoopLock.isHeldByCurrentThread()) {
			dispatchLoopLock.lock();
		}
		if (dispatchLoop != null) {
			context = dispatchLoop.getObject();
		}
		if (dispatchLoopLock.isHeldByCurrentThread()) {
			dispatchLoopLock.unlock();
		}
		return context;
	}

}
