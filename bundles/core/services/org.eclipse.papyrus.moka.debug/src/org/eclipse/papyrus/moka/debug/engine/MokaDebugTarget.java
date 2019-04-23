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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;


public class MokaDebugTarget extends MokaDebugElement implements IMokaDebugTarget {

	// The launcher from which this debug target was created
	protected ILaunch launcher;

	// The process from which execution events come from
	protected MokaProcess executionEngineProcess;

	// Set of logical threads currently executing the model
	protected Set<IMokaThread> executionThreads;

	// Ensure mutual exclusive access to this object for execution
	// engine threads and debug target thread
	protected ReentrantLock targetLock;

	// The current status of the debug target
	protected MokaDebugTargetState status;

	public MokaDebugTarget(ILaunch launcher) {
		super(null);
		this.launcher = launcher;
		this.executionEngineProcess = null;
		this.executionThreads = new HashSet<IMokaThread>();
		this.targetLock = new ReentrantLock(true);
		this.status = MokaDebugTargetState.RUNNING;
		this.fireCreationEvent();
	}

	public void setProcess(MokaProcess process) {
		this.executionEngineProcess = process;
	}

	@Override
	public ILaunch getLaunch() {
		return this.launcher;
	}

	@Override
	public IDebugTarget getDebugTarget() {
		return this;
	}

	@Override
	public boolean canTerminate() {
		return !this.isTerminated();
	}

	@Override
	public boolean isTerminated() {
		return this.status.equals(MokaDebugTargetState.TERMINATED);
	}
	
	@Override
	public void terminate() throws DebugException {
		for (IMokaThread thread : this.executionThreads) {
			if (thread.isSuspended()) {
				thread.resume();
			}
			thread.terminate();
		}
		this.executionThreads.clear();
		this.executionEngineProcess.terminate();
		this.status = MokaDebugTargetState.TERMINATED;
	}

	@Override
	public boolean canResume() {
		// The debug target can only be resumed if it is suspended
		return this.isSuspended();
	}

	@Override
	public boolean canSuspend() {
		// The debug target can only be suspended if it is currently running
		return this.status.equals(MokaDebugTargetState.RUNNING);
	}

	@Override
	public boolean isSuspended() {
		// The debug target is considered as being suspended only if its status is suspended
		return this.status.equals(MokaDebugTargetState.SUSPENDED);
	}

	@Override
	public void resume() throws DebugException {
		// Resume all thread that are currently suspended
		this.targetLock.lock();
		try {
			for (IMokaThread logicalThread : this.executionThreads) {
				if (logicalThread.isSuspended()) {
					logicalThread.resume();
				}
			}
			this.status = MokaDebugTargetState.RUNNING;
			this.fireResumeEvent(DebugEvent.RESUME);
		} finally {
			this.targetLock.unlock();
		}
	}

	@Override
	public void suspend() throws DebugException {
		// Request suspension for all thread that are known by this debug target
		this.targetLock.lock();
		try {
			for (IMokaThread logicalThread : this.executionThreads) {
				if (!logicalThread.isSuspended()) {
					logicalThread.suspend();
				}
			}
			this.status = MokaDebugTargetState.SUSPENDED;
			this.fireChangeEvent(DebugEvent.SUSPEND);
		} finally {
			this.targetLock.unlock();
		}
	}

	@Override
	public void registerThread(IObject_ object) {
		IMokaThread thread = new MokaThread(this, object);
		this.executionThreads.add(thread);
		thread.registered();
	}

	public boolean isNewThread(IObject_ object) {
		// Determine if the active class instance is already associated with a logical thread.
		// If this is the case the it returns true, false otherwise
		IMokaThread existingThread = null;
		Iterator<IMokaThread> threadIterator = this.executionThreads.iterator();
		while (existingThread == null && threadIterator.hasNext()) {
			existingThread = threadIterator.next();
			if (existingThread.getLogicalThread() != object) {
				existingThread = null;
			}
		}
		return existingThread == null;
	}

	@Override
	public void unregisterThread(IObject_ object) {
		// Remove the thread corresponding this active class instance
		IMokaThread targetThread = null;
		Iterator<IMokaThread> threadIterator = this.executionThreads.iterator();
		while (targetThread == null && threadIterator.hasNext()) {
			targetThread = threadIterator.next();
			if (targetThread.getLogicalThread() == object) {
				threadIterator.remove();
				targetThread.unregistered();
			}else {
				targetThread = null;
			}
		}
	}

	protected IMokaThread getLogicalThread(IObject_ object) {
		IMokaThread targetThread = null;
		Iterator<IMokaThread> threadIterator = this.executionThreads.iterator();
		while (targetThread == null && threadIterator.hasNext()) {
			IMokaThread currentThread = threadIterator.next();
			if (currentThread.getLogicalThread() == object) {
				targetThread = currentThread;
			}
		}
		return targetThread;
	}

	@Override
	public boolean isSuspensionRequired(IObject_ object, ISemanticVisitor nodeVisitor) {
		// There are three cases in which a suspension might be required.
		// 1 - The suspension is requested by the user
		// 2 - The suspension is implied by the presence of a breakpoint on the node that is visited
		// 3 - The logical thread is currently in stepping mode
		IMokaThread thread = this.getLogicalThread(object);
		if (thread != null) {
			if (thread.getSuspensionFlag()) {
				return true;
			} else if (DebugServiceHelper.INSTANCE.hasBreakpoint(nodeVisitor)) {
				try {
					thread.suspend(); // Request a suspension for that thread
				} catch (DebugException e) {
					e.printStackTrace();
				}
				return true;
			} else if (thread.isStepping()) {
				try {
					thread.suspend(); // Request a suspension for that thread
				} catch (DebugException e) {
					e.printStackTrace();
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public void suspend(IObject_ object, ISemanticVisitor nodeVisitor) {
		IMokaThread logicalThread = this.getLogicalThread(object);
		if (logicalThread != null) {
			logicalThread.suspend(nodeVisitor);
		}
	}

	@Override
	public void breakpointAdded(IBreakpoint breakpoint) {
	}

	@Override
	public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
	}

	@Override
	public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
	}

	@Override
	public boolean canDisconnect() {
		// In this implementation the debug target is allowed
		return !this.isDisconnected() && !this.isTerminated();
	}

	@Override
	public void disconnect() throws DebugException {
		// When the debug target gets disconnected from the target program
		// the following set of actions take place:
		// 1 - Threads are removed
		// 2 - The process is not watched anymore
		this.targetLock.lock();
		try {
			for (IMokaThread thread : this.executionThreads) {
				if (thread.isSuspended()) {
					thread.resume();
				}
			}
			this.executionThreads.clear();
			this.status = MokaDebugTargetState.DISCONNECTED;
			this.fireTerminateEvent();
		} finally {
			this.targetLock.unlock();
		}
	}

	@Override
	public boolean isDisconnected() {
		return this.status.equals(MokaDebugTargetState.DISCONNECTED)|| this.isTerminated();
	}

	@Override
	public boolean supportsStorageRetrieval() {
		return false;
	}

	@Override
	public IMemoryBlock getMemoryBlock(long startAddress, long length) throws DebugException {
		return null;
	}

	@Override
	public IProcess getProcess() {
		return this.executionEngineProcess;
	}

	@Override
	public IThread[] getThreads() throws DebugException {
		return this.executionThreads.toArray(new IThread[0]);
	}

	@Override
	public boolean hasThreads() throws DebugException {
		return !this.executionThreads.isEmpty();
	}

	@Override
	public String getName() throws DebugException {
		return "Moka Execution";
	}

	@Override
	public boolean supportsBreakpoint(IBreakpoint breakpoint) {
		return true;
	}

	@Override
	public void update(IObject_ object, ISemanticVisitor visitor) {
		IMokaThread thread = this.getLogicalThread(object);
		if (thread != null) {
			thread.setSuspensionPoint(visitor);
		}
	}

	@Override
	public boolean hasSuspendedThread() {
		boolean hasSuspendedThread = false;
		this.targetLock.lock();
		try {
			Iterator<IMokaThread> threadIterator = this.executionThreads.iterator();
			while (!hasSuspendedThread && threadIterator.hasNext()) {
				hasSuspendedThread = threadIterator.next().isSuspended();
			}
		} finally {
			this.targetLock.unlock();
		}
		return hasSuspendedThread;
	}
}
