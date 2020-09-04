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
package org.eclipse.papyrus.moka.engine.uml.debug.service;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.papyrus.moka.debug.engine.DebugServiceHelper;
import org.eclipse.papyrus.moka.debug.engine.IDebuggableExecutionEngineThread;
import org.eclipse.papyrus.moka.debug.service.DebugService;
import org.eclipse.papyrus.moka.fuml.loci.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.profiling.listeners.ISemanticVisitorExecutionListener;
import org.eclipse.papyrus.moka.fuml.profiling.listeners.IValueLifecyleListener;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IValue;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IObject_;
import org.eclipse.papyrus.moka.kernel.SuspensionReasons;
import org.eclipse.papyrus.moka.kernel.assistant.Suspension;

public class UMLDebugService extends DebugService<IObject_, ISemanticVisitor>
		implements ISemanticVisitorExecutionListener, IValueLifecyleListener {

	protected Set<String> debugAssistants = new HashSet<String>();

	/**
	 * Called each time a model element is executed by the execution engine. It
	 * enables the execution engine to : (1) account for requests received from the
	 * debug target (2) advise the debug target that a thread suspension occurred
	 */
	@Override
	public void nodeVisited(ISemanticVisitor visitor) {
		IObject_ context = DebugServiceUtils.getExecutionContext(visitor);
		IDebuggableExecutionEngineThread<IObject_, ISemanticVisitor> debuggableThread = null;
		if (context != null) {
			debuggableThread = engine.getThread(context.getIdentifier());
			if (debuggableThread != null) {
				debuggableThread.setSuspensionContext(visitor);
			}
			if (shouldEngineSuspend()) {
				// (1) Suspend execution engine
				engineSuspendRequestLock.lock();
				enginSuspendRequest = false;
				engineSuspendRequestLock.unlock();
				suspendEngine();
			} else if (shouldEngineTerminate()) {
				// (2) Terminate execution engine
				engineTerminateRequestLock.lock();
				engineTerminateRequest = false;
				engineTerminateRequestLock.unlock();
				terminateEngine();
			} else {
				if (debuggableThread != null) {
					if (DebugServiceHelper.INSTANCE.hasBreakpoint(visitor)) {
						// (3) Suspend the thread executing this model element
						client.fireSuspendThreadEvent(context, visitor, SuspensionReasons.BREAKPOINT);
						suspendThread(debuggableThread);
					} else {
						threadSuspendRequestLock.lock();
						Boolean flag = threadSuspendRequest.get(context.getIdentifier());
						if (flag != null && flag) {
							// (4) Suspend the thread executing this model element
							// since it was requested by the debug target
							threadSuspendRequestLock.unlock();
							suspendThread(debuggableThread);
						} else {
							threadSuspendRequestLock.unlock();
							threadTerminateRequestLock.lock();
							if (threadTerminateRequest.contains(context.getIdentifier())) {
								// (5) Terminate engine thread executing this model
								// element since it was requested by the debug target
								terminateThread(debuggableThread);
							}
							threadTerminateRequestLock.unlock();
						}

					}
				}
			}
		}
	}

	@Override
	public void nodeSuspended(ISemanticVisitor visitor, Suspension suspension) {
		IObject_ context = DebugServiceUtils.getExecutionContext(visitor);
		if (context != null) {
			client.fireSuspendThreadEvent(context, visitor, suspension.getSuspensionReason());
			IDebuggableExecutionEngineThread<IObject_, ISemanticVisitor> thread = engine
					.getThread(context.getIdentifier());
			if (thread != null) {
				thread.setSuspensionContext(visitor);
				suspendThread(thread);
			}
		}
	}

	@Override
	public void nodeLeft(ISemanticVisitor visitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void valueCreated(IValue value) {
		if (value instanceof IObject_ && DebugServiceUtils.isActive((IObject_) value)) {
			engine.addDebugThread(new UMLDebuggableExecutionEngineThread((IObject_) value));
			client.fireNewThreadEvent((IObject_) value);
		}
	}

	@Override
	public void valueDestroyed(IValue value) {
		if (value instanceof IObject_ && DebugServiceUtils.isActive((IObject_) value)) {
			engine.removeDebugThread(new UMLDebuggableExecutionEngineThread((IObject_) value));
			client.fireTerminateThreadEvent((IObject_) value);
		}
	}

	@Override
	protected void initDebugAssistant() {
		debugAssistants.add("org.eclipse.papyrus.moka.fuml.profiling.debug.NullStructuredValueProfiler");
		debugAssistants.add("org.eclipse.papyrus.moka.fuml.profiling.debug.NullTokenPropagationProfiler");
		debugAssistants.add("org.eclipse.papyrus.moka.pscs.profiling.debug.NullStructuredValueProfiler");
	}

	@Override
	public boolean shouldContinueInDebugAssistant(String assistantID) {
		return debugAssistants.contains(assistantID);
	}

}
