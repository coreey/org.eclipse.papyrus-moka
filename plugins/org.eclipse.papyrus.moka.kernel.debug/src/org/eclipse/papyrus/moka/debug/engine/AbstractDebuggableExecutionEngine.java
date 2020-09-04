/*****************************************************************************
 * Copyright (c) 2019, 2020 CEA LIST.
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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.debug.core.DebugException;
import org.eclipse.papyrus.moka.debug.service.IDebugService;
import org.eclipse.papyrus.moka.engine.schedulable.AbstractScheduledExecutionEngine;
import org.eclipse.papyrus.moka.kernel.engine.EngineConfiguration;
import org.eclipse.papyrus.moka.kernel.engine.ExecutionEngineException;
import org.eclipse.papyrus.moka.kernel.engine.ExecutionEngineStatus;
import org.eclipse.papyrus.moka.kernel.engine.IExecutionEngine;
import org.eclipse.papyrus.moka.kernel.service.IExecutionEngineService;
import org.eclipse.papyrus.moka.kernel.service.ServiceRegistry;

public abstract class AbstractDebuggableExecutionEngine<ThreadType, ContextType>
		extends AbstractScheduledExecutionEngine implements IDebuggableExecutionEngine<ThreadType, ContextType> {

	/**
	 * Map of thread for which debugging is enabled;
	 */
	protected Map<String, IDebuggableExecutionEngineThread<ThreadType, ContextType>> debuggableThread;

	/**
	 * Enable safe access and modification of the thread map.
	 */
	protected ReentrantLock debuggableThreadLock;

	public AbstractDebuggableExecutionEngine() {
		super();
		debuggableThread = new HashMap<String, IDebuggableExecutionEngineThread<ThreadType, ContextType>>();
		debuggableThreadLock = new ReentrantLock(true);
	}

	public void run(final EngineConfiguration<?> configuration, SubMonitor monitor) throws ExecutionEngineException {
		setStatus(ExecutionEngineStatus.INITIALIZING);
		init(configuration, monitor);
		setStatus(ExecutionEngineStatus.RUNNING);
		try {
			start(monitor);
		} finally {
			fireTerminateExecutionEvent();
			setStatus(ExecutionEngineStatus.DISPOSING);
			dispose(monitor);
			setStatus(ExecutionEngineStatus.TERMINATED);
		}
	}

	/**
	 * @see {@link IDebuggableExecutionEngine#addDebugThread(IDebuggableExecutionEngineThread)}
	 */
	public boolean addDebugThread(IDebuggableExecutionEngineThread<ThreadType, ContextType> t) {
		boolean added = false;
		if (t != null) {
			if (!debuggableThreadLock.isHeldByCurrentThread()) {
				debuggableThreadLock.lock();
			}
			debuggableThread.put(t.getID(), t);
			added = debuggableThread.containsKey(t.getID());
			if (debuggableThreadLock.isHeldByCurrentThread()) {
				debuggableThreadLock.unlock();
			}
		}
		return added;
	}

	/**
	 * @see {@link IDebuggableExecutionEngine#removeDebugThread(IDebuggableExecutionEngineThread)}
	 */
	public boolean removeDebugThread(IDebuggableExecutionEngineThread<ThreadType, ContextType> t) {
		boolean removed = false;
		if (t != null) {
			if (!debuggableThreadLock.isHeldByCurrentThread()) {
				debuggableThreadLock.lock();
			}
			removed = debuggableThread.remove(t.getID()) != null;
			if (debuggableThreadLock.isHeldByCurrentThread()) {
				debuggableThreadLock.unlock();
			}
		}
		return removed;
	}

	/**
	 * Check if the execution engine is in the suspended state. The check is thread
	 * safe. True is returned if the engine is suspended and false otherwise
	 */
	@Override
	public boolean isSuspended() {
		return getStatus().equals(ExecutionEngineStatus.SUSPENDED);
	}

	/**
	 * Check if the execution engine can be suspended. The check is is thread safe.
	 * True is returned if the engine can be suspended and false otherwise.
	 */
	@Override
	public boolean canSuspend() {
		return getStatus().equals(ExecutionEngineStatus.RUNNING);
	}

	/**
	 * Suspend controller execution loop and assign the suspended status.
	 */
	@Override
	public void suspend() throws DebugException {
		getController().getExecutionLoop().suspend();
		setStatus(ExecutionEngineStatus.SUSPENDED);
	}

	/**
	 * Check if the execution engine can be resumed. The check is is thread safe.
	 * True is returned if the engine can be resumed and false otherwise.
	 */
	@Override
	public boolean canResume() {
		return getStatus().equals(ExecutionEngineStatus.SUSPENDED);
	}

	/**
	 * Resume controller execution loop and assign the running status
	 */
	@Override
	public void resume() throws DebugException {
		getController().getExecutionLoop().resume();
		setStatus(ExecutionEngineStatus.RUNNING);
	}

	/**
	 * The execution engine may terminate if it is not already terminated or
	 * suspended
	 */
	@Override
	public boolean canTerminate() {
		return !isTerminated() || isSuspended();
	}

	/**
	 * The execution engine is terminated if it has the terminated status
	 */
	@Override
	public boolean isTerminated() {
		return getStatus().equals(ExecutionEngineStatus.TERMINATED);
	}

	/**
	 * Terminate controller execution loop and assign the terminated status
	 */
	@Override
	public void terminate() throws DebugException {
		getController().getExecutionLoop().terminate();
		if (!debuggableThreadLock.isHeldByCurrentThread()) {
			debuggableThreadLock.lock();
		}
		debuggableThread.clear();
		if (debuggableThreadLock.isHeldByCurrentThread()) {
			debuggableThreadLock.unlock();
		}
		setStatus(ExecutionEngineStatus.TERMINATED);
	}

	private void fireTerminateExecutionEvent() {
		IDebugService<ThreadType, ContextType> service = getDebugService();
		if (service != null) {
			service.fireTerminateEngineEvent();
		}
	}

	@SuppressWarnings("unchecked")
	public final IDebugService<ThreadType, ContextType> getDebugService() {
		// Note: an execution engine has at most a single debug service
		IDebugService<ThreadType, ContextType> debugService = null;
		Iterator<IExecutionEngineService<IExecutionEngine>> it = ServiceRegistry.getInstance()
				.getService(IDebugService.class).iterator();
		if (it.hasNext()) {
			debugService = (IDebugService<ThreadType, ContextType>) it.next();
		}
		return debugService;
	}

	/**
	 * @see {@link IDebuggableExecutionEngine#suspendThread(Object)}
	 */
	@Override
	public IDebuggableExecutionEngineThread<ThreadType, ContextType> getThread(String identifier) {
		IDebuggableExecutionEngineThread<ThreadType, ContextType> thread = null;
		if (!debuggableThreadLock.isHeldByCurrentThread()) {
			debuggableThreadLock.lock();
		}
		thread = debuggableThread.get(identifier);
		if (debuggableThreadLock.isHeldByCurrentThread()) {
			debuggableThreadLock.unlock();
		}
		return thread;
	}

	/**
	 * @see {@link IDebuggableExecutionEngine#suspendThread(Object)}
	 * 
	 *      Execution of this active object is suspended
	 */
	public void suspendThread(IDebuggableExecutionEngineThread<ThreadType, ContextType> debuggableThread) {
		controller.getExecutionLoop().suspend(new IsTargetThreadCondition<ThreadType>(debuggableThread.getThread()));
	}

	/**
	 * @see {@link IDebuggableExecutionEngine#resumeThread(Object)}
	 * 
	 *      Execution of this active object is resumed
	 */
	public void resumeThread(IDebuggableExecutionEngineThread<ThreadType, ContextType> debuggableThread) {
		controller.getExecutionLoop().resume(new IsTargetThreadCondition<ThreadType>(debuggableThread.getThread()));
	}

	/**
	 * @see {@link IDebuggableExecutionEngine#terminateThread(Object)}
	 * 
	 *      Execution of this active object is terminated
	 */
	public void terminateThread(IDebuggableExecutionEngineThread<ThreadType, ContextType> debuggableThread) {
		controller.getExecutionLoop().terminate(new IsTargetThreadCondition<ThreadType>(debuggableThread.getThread()));
	}

}
