/*****************************************************************************
 * Copyright (c) 2019 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  CEA LIST - Bug 551906
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.debug.target;

import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.papyrus.moka.kernel.SuspensionReasons;

public class ExecutionEngineThread extends ExecutionEngineDebugElement implements IExecutionEngineThread {

	/**
	 * ID of the UML debug model
	 */
	public static final String MODEL_ID = "org.eclipse.papyrus.moka.kernel.debug.model";

	/**
	 * ID of the thread running the active object
	 */
	private String id;

	/**
	 * The suspension reason
	 */
	private SuspensionReasons suspensionReason;

	/**
	 * The stack frame of the thread
	 */
	private ExecutionEngineStackFrame stackFrame;

	public ExecutionEngineThread(IDebugTarget target) {
		super(target);
		status = DebugElementStatus.RUNNING;
		statusLock = new ReentrantLock(true);
		stackFrame = new ExecutionEngineStackFrame(this);
	}

	/**
	 * @see IDebugTarget#canResume()
	 * 
	 *      A thread can only be resumed if it has the suspended state
	 */
	@Override
	public boolean canResume() {
		return getStatus().equals(DebugElementStatus.SUSPENDED);
	}

	/**
	 * @see IThread#resume()
	 * 
	 *      Resume the corresponding execution engine thread
	 * 
	 *      An explicit call to resume always occurs as a client (i.e., the user
	 *      hits the resume button)
	 */
	@Override
	public void resume() throws DebugException {
		IExecutionEngineDebugTarget target = (IExecutionEngineDebugTarget) getDebugTarget();
		if (target != null) {
			IExecutionEngineDebugTargetClient client = target.getClient();
			if (client != null) {
				client.fireResumeThreadEvent(this);
				this.suspensionReason = SuspensionReasons.NONE;
			}
		}
	}

	/**
	 * @see IDebugTarget#canSuspend()
	 * 
	 *      A thread can only be suspended if it has the running state
	 */
	@Override
	public boolean canSuspend() {
		return getStatus().equals(DebugElementStatus.RUNNING);
	}

	/**
	 * @see IExecutionEngineThread#isSuspended()
	 * 
	 *      A thread is suspended if it has the suspended state
	 */
	@Override
	public boolean isSuspended() {
		return getStatus().equals(DebugElementStatus.SUSPENDED);
	}

	/**
	 * @see IThread#suspend()
	 * 
	 *      Suspend the corresponding execution engine thread
	 * 
	 *      An explicit call to suspend always occurs as a client request (i.e., the
	 *      user hits the pause button in the interface)
	 */
	@Override
	public void suspend() throws DebugException {
		IExecutionEngineDebugTarget target = (IExecutionEngineDebugTarget) getDebugTarget();
		if (target != null) {
			IExecutionEngineDebugTargetClient client = target.getClient();
			if (client != null) {
				client.fireSuspendThreadEvent(this);
				setStatus(DebugElementStatus.SUSPENDED);
			}
		}
	}

	/**
	 * @see IThread#suspend()
	 * 
	 *      Handle an execution engine request specifying that the thread was
	 *      suspended.
	 */
	@Override
	public void handleSuspendEvent(int supensionDetail) {
		if (canSuspend()) {
			setStatus(DebugElementStatus.SUSPENDED);
			fireSuspendEvent(supensionDetail);
		}
	}

	/**
	 * @see IDebugTarget#canTerminate()
	 * 
	 *      A thread can terminate if it either running or suspended
	 */
	@Override
	public boolean canTerminate() {
		return getStatus().equals(DebugElementStatus.RUNNING) || getStatus().equals(DebugElementStatus.SUSPENDED);
	}

	/**
	 * @see IDebugTarget#isTerminated()
	 * 
	 *      A thread is terminated when it has the terminated state
	 */
	@Override
	public boolean isTerminated() {
		return getStatus().equals(DebugElementStatus.TERMINATED);
	}

	/**
	 * @see IDebugTarget#terminate()
	 * 
	 *      Terminate the corresponding execution engine thread. If the thread is
	 *      suspended then it is resumed before termination.
	 * 
	 *      An explicit call to terminate always occurs as a client request (i.e.,
	 *      the user hits the pause button in the interface)
	 */
	@Override
	public void terminate() throws DebugException {
		IExecutionEngineDebugTarget target = (IExecutionEngineDebugTarget) getDebugTarget();
		if (target != null) {
			IExecutionEngineDebugTargetClient client = target.getClient();
			if (client != null) {
				if (isSuspended()) {
					resume();
				}
				client.fireTerminateThreadEvent(this);
			}
		}
	}

	@Override
	public boolean canStepInto() {
		return false;
	}

	@Override
	public boolean canStepOver() {
		return false;
	}

	@Override
	public boolean canStepReturn() {
		return false;
	}

	@Override
	public boolean isStepping() {
		return false;
	}

	@Override
	public void stepInto() throws DebugException {

	}

	@Override
	public void stepOver() throws DebugException {

	}

	@Override
	public void stepReturn() throws DebugException {

	}

	@Override
	public String getModelIdentifier() {
		return MODEL_ID;
	}

	/**
	 * 
	 */
	@Override
	public IStackFrame[] getStackFrames() throws DebugException {
		if (isSuspended()) {
			return new IStackFrame[] { stackFrame };
		}
		return new IStackFrame[0];
	}

	/**
	 * {@link IThread#hasStackFrames()}
	 * 
	 * A thread can only have stack frames when it is suspended
	 */
	@Override
	public boolean hasStackFrames() throws DebugException {
		return isSuspended();
	}

	/**
	 * {@link IThread#getTopStackFrame()}
	 * 
	 * @return the top stack frame if the thread is suspended and false otherwise
	 */
	@Override
	public IStackFrame getTopStackFrame() throws DebugException {
		IStackFrame top = null;
		if (isSuspended()) {
			top = stackFrame;
		}
		return top;
	}

	@Override
	public int getPriority() throws DebugException {
		return 0;
	}

	@Override
	public String getName() throws DebugException {
		return id;
	}

	@Override
	public IBreakpoint[] getBreakpoints() {
		return null;
	}

	@Override
	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public SuspensionReasons getSuspensionReason() {
		return suspensionReason;
	}

	public void setSuspensionReason(SuspensionReasons suspensionReason) {
		this.suspensionReason = suspensionReason;
	}

}
