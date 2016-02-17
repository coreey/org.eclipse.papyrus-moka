/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.debug;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.moka.MokaConstants;
import org.eclipse.papyrus.moka.communication.event.isuspendresume.Suspend_Event;
import org.eclipse.papyrus.moka.communication.request.isuspendresume.Resume_Request;
import org.eclipse.papyrus.moka.communication.request.isuspendresume.Suspend_Request;
import org.eclipse.papyrus.moka.communication.request.iterminate.Terminate_Request;
import org.eclipse.papyrus.moka.debug.MokaBreakpoint;
import org.eclipse.papyrus.moka.debug.MokaStackFrame;
import org.eclipse.papyrus.moka.debug.MokaThread;
import org.eclipse.papyrus.moka.engine.AbstractExecutionEngine;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.ActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.ActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.presentation.FUMLPresentationUtils;
import org.eclipse.papyrus.moka.services.animation.IAnimatedModelListener;
import org.eclipse.papyrus.moka.services.animation.events.AnimationEvent;

public class ControlDelegate implements IAnimatedModelListener{

	/**
	 * The execution engine associated with this ControlDelegate object
	 */
	protected AbstractExecutionEngine engine;

	/**
	 * The animation manager that is attached to this delegate
	 */
	
	/**
	 * The list of threads implied by current execution
	 */
	protected List<FUMLThread> threads;

	/**
	 * Determines if execution is suspended
	 */
	protected boolean suspended = false;

	/**
	 * The reason for suspending execution
	 */
	protected int reasonForSuspending = -1;

	/**
	 * The reason for resuming execution
	 */
	protected int reasonForResuming = -1;

	/**
	 * The execution mode (i.e., Debug or Run)
	 */
	protected String mode;

	/**
	 * Semantic elements associated with a breakpoint
	 */
	protected Set<EObject> elementsWithBreakpoints;

	public ControlDelegate(AbstractExecutionEngine engine) {
		this.engine = engine;
		this.mode = this.engine.getDebugTarget().getLaunch().getLaunchMode();
		this.elementsWithBreakpoints = new HashSet<EObject>();
		//this.manager = RenderHandler.getInstance();
	}

	/**
	 * Manages addition of a breakpoint in the course of execution
	 *
	 * @param breakpoint
	 *            The added breakpoint
	 */
	public void addBreakpoint(MokaBreakpoint breakpoint) {
		EObject modelElement = breakpoint.getModelElement();
		if (modelElement != null) {
			if (modelElement.eIsProxy()) {
				//modelElement = AnimationManager.resolve(modelElement);
			}
			this.elementsWithBreakpoints.add(modelElement);
		}
	}

	/**
	 * Manages removal of a breakpoint in the course of execution
	 *
	 * @param breakpoint
	 *            The removed breakpoint
	 */
	public void removeBreakpoint(MokaBreakpoint breakpoint) {
		EObject modelElement = breakpoint.getModelElement();
		if (modelElement != null) {
			if (modelElement.eIsProxy()) {
				//modelElement = AnimationManager.resolve(modelElement);
			}
			this.elementsWithBreakpoints.remove(modelElement);
		}
	}

	/**
	 * Manages resuming of execution
	 *
	 * @param request
	 *            The request underlying this resume
	 */
	public void resume(Resume_Request request) {
		this.suspended = false;
		this.reasonForResuming = request.getResumeDetail();
		if (reasonForResuming != DebugEvent.CLIENT_REQUEST) {
			reasonForResuming = DebugEvent.STEP_OVER;
		}
		this.getThreads()[0].setSuspended(false);
		synchronized (this) {
			notify();
			this.threads.get(0).setStackFrames(new IStackFrame[] {});
		}
	}

	/**
	 * Manages suspension of execution
	 *
	 * @param request
	 *            The request underlying this suspension
	 */
	public void suspend(Suspend_Request request) {
		this.suspended = true;
		this.reasonForSuspending = DebugEvent.CLIENT_REQUEST;
	}

	/**
	 * Manages termination of execution
	 *
	 * @param request
	 *            The request underlying this termination
	 */
	public void terminate(Terminate_Request request) {
		engine.setIsTerminated(true);
		synchronized (this) {
			notify();
		}
		//RenderHandler.getInstance().clean();
	}

	/**
	 * Return the stack of the given thread
	 *
	 * @param thread
	 *            The thread from which a stack has to be retrieved
	 * @return The stack of the given thread
	 */
	public IStackFrame[] getStackFrames(IThread thread) {
		// Never called in this implementation
		// When the debug is notified, threads are already constructed with appropriate stack frames.
		return null;
	}

	/**
	 * Returns the threads underlying this execution
	 *
	 * @return The threads underlying this execution
	 */
	public MokaThread[] getThreads() {
		if (this.threads == null) {
			this.threads = new ArrayList<FUMLThread>();
			if (this.engine.getDebugTarget().getLaunch().getLaunchMode().equals(ILaunchManager.DEBUG_MODE)) {
				FUMLThread thread = new FUMLThread(this.engine.getDebugTarget());
				thread.setName("Main Thread");
				thread.setStackFrames(new IStackFrame[] {});
				this.threads.add(thread);
			}
		}
		return threads.toArray(new MokaThread[threads.size()]);
	}

	/**
	 * Method that can be called by a particular execution engine to delegate control of execution flow.
	 *
	 * @param object
	 *            An object from the execution flow from which control has to be delegated
	 * @return False if execution shall stop, True if execution shall continue
	 */
	public boolean control(Object object) {
		if (this.engine.isTerminated()) {
			return false;
		}

		// Retrieves the semantic element
		EObject semanticElement = null;
		if (object instanceof ActivityNodeActivation) {
			semanticElement = ((ActivityNodeActivation) object).node;
		} else if (object instanceof ActivityEdgeInstance) {
			semanticElement = ((ActivityEdgeInstance) object).edge;
		} else {
			Activator.log.error(new Exception("Unexpected element in ControlDelegate::control"));
			this.engine.setIsTerminated(true);
			return false;
		}

		if (semanticElement != null && MokaConstants.MOKA_AUTOMATIC_ANIMATION && this.mode.equals(ILaunchManager.DEBUG_MODE)) {
			this.animate(semanticElement);
		}

		if (this.suspended) { /* Client request */
			try {
				synchronized (this) {
					this.getThreads(); // To make sure that this.threads is neither null nor empty
					FUMLThread mainThread = this.threads.get(0);
					mainThread.setSuspended(true);
					MokaStackFrame stackFrame = FUMLPresentationUtils.getMokaStackFrame(object);
					stackFrame.setThread(mainThread);
					mainThread.setStackFrames(new IStackFrame[] { stackFrame });
					Suspend_Event suspendEvent = new Suspend_Event(mainThread, DebugEvent.CLIENT_REQUEST, this.getThreads());
					engine.sendEvent(suspendEvent);
					wait();
				}
			} catch (InterruptedException e) {
				Activator.log.error(e);
			}
		} else { // Tries to check if a breakpoint applies
			if (this.elementsWithBreakpoints.contains(semanticElement) || this.reasonForResuming == DebugEvent.STEP_OVER) {
				if ((object instanceof ActivityNodeActivation && ((ActivityNodeActivation) object).group != null) || (object instanceof ActivityEdgeInstance && ((ActivityEdgeInstance) object).group != null)) {
					try {
						synchronized (this) {
							this.getThreads(); // To make sure that this.threads is neither null nor empty
							FUMLThread mainThread = this.threads.get(0);
							mainThread.setSuspended(true);
							mainThread.setSuspensionPoint(semanticElement);
							MokaStackFrame stackFrame = FUMLPresentationUtils.getMokaStackFrame(object);
							stackFrame.setThread(mainThread);
							mainThread.setStackFrames(new IStackFrame[] { stackFrame });
							Suspend_Event suspendEvent = new Suspend_Event(mainThread, DebugEvent.BREAKPOINT, this.getThreads());
							engine.sendEvent(suspendEvent);
							wait();
						}
					} catch (InterruptedException e) {
						Activator.log.error(e);
					}
				}
			}
		}
		return !this.engine.isTerminated();
	}

	protected void animate(Object target) {
		// Animate the object given as parameter
		/*RenderHandler animationManager = RenderHandler.getInstance();
		if(target instanceof SemanticVisitor){
			((SemanticVisitor)target).animate(animationManager);
		}else if(target instanceof ActivityEdgeInstance){
			if(((ActivityEdgeInstance)target).source instanceof PinActivation){
				((ActivityEdgeInstance)target).source.animate(animationManager);
			}
			((ActivityEdgeInstance)target).animate(animationManager);
		}	*/
	}

	public void waitForTermination() {
		// Nothing to do
	}

	/**
	 * @see org.eclipse.papyrus.moka.services.animation.IAnimatedModelListener#nodeVisited(org.eclipse.papyrus.moka.services.animation.events.AnimationEvent)
	 *
	 * @param event
	 */
	public void nodeVisited(AnimationEvent event) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see org.eclipse.papyrus.moka.services.animation.IAnimatedModelListener#nodeLeft(org.eclipse.papyrus.moka.services.animation.events.AnimationEvent)
	 *
	 * @param event
	 */
	public void nodeLeft(AnimationEvent event) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see org.eclipse.papyrus.moka.services.animation.IAnimatedModelListener#valueCreated(org.eclipse.papyrus.moka.services.animation.events.AnimationEvent)
	 *
	 * @param event
	 */
	public void valueCreated(AnimationEvent event) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see org.eclipse.papyrus.moka.services.animation.IAnimatedModelListener#valueDestroyed(org.eclipse.papyrus.moka.services.animation.events.AnimationEvent)
	 *
	 * @param event
	 */
	public void valueDestroyed(AnimationEvent event) {
		// TODO Auto-generated method stub
		
	}
}
