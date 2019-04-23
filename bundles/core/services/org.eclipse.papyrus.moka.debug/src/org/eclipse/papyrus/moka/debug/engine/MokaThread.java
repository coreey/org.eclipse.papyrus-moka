/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.debug.engine;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.animation.engine.rendering.AnimationKind;
import org.eclipse.papyrus.moka.animation.engine.rendering.IAnimation;
import org.eclipse.papyrus.moka.debug.model.data.mapping.MokaStackFrame;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IObjectActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.utils.helper.semantics.SemanticHelper;

public class MokaThread extends MokaDebugElement implements IMokaThread {

	// The active class instance representing the logical execution
	// thread within the execution engine
	protected IObject_ object;

	// Visitor on which the execution is currently suspended
	protected ISemanticVisitor suspensionPoint;

	// Ensure mutual exclusive access to this object for execution
	// engine threads and debug target thread
	protected ReentrantLock threadLock;

	private Condition resumeCondition;

	// Boolean flag materializing a request for this thread to be suspended
	protected boolean suspensionRequired;

	// The current status of this logical thread
	protected MokaThreadState status;

	public MokaThread(MokaDebugTarget debugTarget, IObject_ object) {
		super(debugTarget);
		this.object = object;
		this.threadLock = new ReentrantLock(true);
		this.resumeCondition = this.threadLock.newCondition();
		this.suspensionRequired = false;
		this.status = MokaThreadState.RUNNING;
	}

	@Override
	public boolean canResume() {
		return this.isSuspended();
	}

	@Override
	public boolean canSuspend() {
		return !this.isSuspended();
	}

	@Override
	public boolean isSuspended() {
		return this.status.equals(MokaThreadState.SUSPENDED);
	}

	@Override
	public void resume() throws DebugException {
		this.threadLock.lock();
		try {
			this.setSuspensionFlag(false);
			this.setSuspensionPoint(null);
			this.status = MokaThreadState.RUNNING;
			this.fireChangeEvent(DebugEvent.RESUME);
			this.resumeCondition.signal();
			if (!this.debugTarget.hasSuspendedThread()) {
				this.debugTarget.resume();
			}
		} finally {
			this.threadLock.unlock();
		}
	}

	@Override
	public void suspend() throws DebugException {
		this.threadLock.lock();
		try {
			this.setSuspensionFlag(true);
			this.status = MokaThreadState.SUSPENDED;
			this.fireChangeEvent(DebugEvent.SUSPEND);
		} finally {
			this.threadLock.unlock();
		}
	}

	@Override
	public void suspend(ISemanticVisitor visitor) {
		this.threadLock.lock();
		try {
			if (this.suspensionRequired) {
				this.suspensionRequired = false;
				try {
					IAnimation animationService = DebugServiceHelper.INSTANCE.getAnimationService();
					EObject visitedModelElement = SemanticHelper.getModelElement(visitor);
					if (animationService != null) {
						animationService.renderAs(visitedModelElement, this.object, AnimationKind.SUSPENDED);
					}
					this.resumeCondition.await();
					if (animationService != null) {
						animationService.renderAs(visitedModelElement, this.object, AnimationKind.VISITED);
					}
				} catch (InterruptedException e) {
				}
			}
		} finally {
			this.threadLock.unlock();
		}
	}

	@Override
	public boolean canStepOver() {
		// The step over function only becomes available if the thread
		// is currently suspended
		return false;
	}

	@Override
	public void stepOver() throws DebugException {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean canStepReturn() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isStepping() {
		return this.status.equals(MokaThreadState.STEPPING);
	}

	@Override
	public boolean canStepInto() {
		// Step into action is only available when the thread is suspended
		return this.isSuspended();
	}

	@Override
	public void stepInto() throws DebugException {
		// The current thread is suspended. Requesting a step into
		// consists in releasing the lock on which the current thread
		// is blocked.
		this.threadLock.lock();
		try {
			this.status = MokaThreadState.STEPPING;
			this.resumeCondition.signal();
		} finally {
			this.threadLock.unlock();
		}
	}

	@Override
	public void stepReturn() throws DebugException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean canTerminate() {
		return !this.isTerminated() && !this.isSuspended();
	}

	@Override
	public boolean isTerminated() {
		return this.status.equals(MokaThreadState.TERMINATED);
	}

	@Override
	public void terminate() throws DebugException {
		this.status = MokaThreadState.TERMINATED;
		this.fireTerminateEvent();
		synchronized (this.object) {
			IObjectActivation objectActivation = this.object.getObjectActivation();
			if (objectActivation != null) {
				objectActivation.stop();
				objectActivation.setObject(null);
				this.object.setObjectActivation(null);
			}
		}
	}

	@Override
	public IStackFrame[] getStackFrames() throws DebugException {
		IStackFrame[] stackFrames = new IStackFrame[] {};
		if (this.isSuspended()) {
			stackFrames = new IStackFrame[] { new MokaStackFrame(this.debugTarget, this) };
		}
		return stackFrames;
	}

	@Override
	public boolean hasStackFrames() throws DebugException {
		return this.getStackFrames().length > 0;
	}

	@Override
	public int getPriority() throws DebugException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IStackFrame getTopStackFrame() throws DebugException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() throws DebugException {
		return this.object.getIdentifier();
	}

	@Override
	public IBreakpoint[] getBreakpoints() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogicalThread(IObject_ object) {
		this.object = object;
	}

	@Override
	public IObject_ getLogicalThread() {
		return this.object;
	}

	@Override
	public boolean getSuspensionFlag() {
		return this.suspensionRequired;
	}

	public void setSuspensionFlag(boolean mustSuspend) {
		this.suspensionRequired = mustSuspend;
	}

	@Override
	public ISemanticVisitor getSuspensionPoint() {
		return this.suspensionPoint;
	}

	@Override
	public void setSuspensionPoint(ISemanticVisitor visitor) {
		this.suspensionPoint = visitor;
	}

	@Override
	public void registered() {
		// Notify the debug interface that a new thread was registered
		this.fireCreationEvent();
	}

	@Override
	public void unregistered() {
		// Notify the debug interface that a existing thread was destroyed
		this.fireTerminateEvent();
	}

}
