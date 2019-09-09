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
import org.eclipse.papyrus.moka.kernel.engine.EngineConfiguration;
import org.eclipse.papyrus.moka.kernel.engine.ExecutionEngine;
import org.eclipse.papyrus.moka.kernel.engine.ExecutionEngineStatus;
import org.eclipse.papyrus.moka.kernel.engine.IExecutionEngine;
import org.eclipse.papyrus.moka.kernel.scheduling.control.ExecutionController;
import org.eclipse.papyrus.moka.kernel.scheduling.control.ExecutionLoop;
import org.eclipse.papyrus.moka.kernel.scheduling.control.IExecutionController;
import org.eclipse.papyrus.moka.kernel.service.IExecutionEngineService;
import org.eclipse.papyrus.moka.kernel.service.ServiceRegistry;

public abstract class DebuggableExecutionEngine<T, C> extends ExecutionEngine
		implements IDebuggableExecutionEngine<T, C> {

	/**
	 * Controller in charge of the execution task management
	 */
	protected IExecutionController controller;

	/**
	 * Map of thread for which debugging is enabled;
	 */
	protected Map<String, IDebuggableExecutionEngineThread<T, C>> debuggableThread;

	/**
	 * Enable safe access and modification of the thread map.
	 */
	protected ReentrantLock debuggableThreadLock;

	public DebuggableExecutionEngine() {
		super();
		debuggableThread = new HashMap<String, IDebuggableExecutionEngineThread<T, C>>();
		debuggableThreadLock = new ReentrantLock(true);
	}

	@Override
	public void init(EngineConfiguration configuration, SubMonitor monitor) {
		super.init(configuration, monitor);
		controller = createController();
	}

	public void run(final EngineConfiguration configuration, SubMonitor monitor) {
		setStatus(ExecutionEngineStatus.INITIALIZING);
		init(configuration, monitor);
		setStatus(ExecutionEngineStatus.RUNNING);
		start(monitor);
		fireTerminateExecutionEvent();
		setStatus(ExecutionEngineStatus.DISPOSING);
		dispose(monitor);
		setStatus(ExecutionEngineStatus.TERMINATED);
	}

	/**
	 * @see {@link IDebuggableExecutionEngine#createController()}
	 */
	@Override
	public IExecutionController createController() {
		IExecutionController controller = new ExecutionController();
		controller.setExecutionLoop(new ExecutionLoop());
		return controller;
	}

	/**
	 *  @see {@link IDebuggableExecutionEngine#addDebugThread(IDebuggableExecutionEngineThread)}
	 */
	public boolean addDebugThread(IDebuggableExecutionEngineThread<T, C> t) {
		boolean added = false;
		if(t != null) {
			if(!debuggableThreadLock.isHeldByCurrentThread()) {
				debuggableThreadLock.lock();
			}
			debuggableThread.put(t.getID(), t);
			added = debuggableThread.containsKey(t.getID());
			if(debuggableThreadLock.isHeldByCurrentThread()) {
				debuggableThreadLock.unlock();
			}
		}
		return added;
	}
	
	/**
	 *  @see {@link IDebuggableExecutionEngine#removeDebugThread(IDebuggableExecutionEngineThread)}
	 */
	public boolean removeDebugThread(IDebuggableExecutionEngineThread<T, C> t) {
		boolean removed = false;
		if(t != null) {
			if(!debuggableThreadLock.isHeldByCurrentThread()) {
				debuggableThreadLock.lock();
			}
			removed = debuggableThread.remove(t.getID()) != null;
			if(debuggableThreadLock.isHeldByCurrentThread()) {
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
		controller.getExecutionLoop().suspend();
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
		controller.getExecutionLoop().resume();
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
		controller.getExecutionLoop().terminate();
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
		IDebugService<T, C> service = getDebugService();
		if (service != null) {
			service.fireTerminateEngineEvent();
		}
	}

	@SuppressWarnings("unchecked")
	public final IDebugService<T, C> getDebugService() {
		// Note: an execution engine has at most a single debug service
		IDebugService<T, C> debugService = null;
		Iterator<IExecutionEngineService<IExecutionEngine>> it = ServiceRegistry.getInstance()
				.getService(IDebugService.class).iterator();
		if (it.hasNext()) {
			debugService = (IDebugService<T, C>) it.next();
		}
		return debugService;
	}

}
