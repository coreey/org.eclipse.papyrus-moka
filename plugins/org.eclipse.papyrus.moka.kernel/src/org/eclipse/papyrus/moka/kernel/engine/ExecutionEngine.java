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
package org.eclipse.papyrus.moka.kernel.engine;

import java.util.Collection;
import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.ITerminate;
import org.eclipse.papyrus.moka.kernel.service.IExecutionEngineService;
import org.eclipse.papyrus.moka.kernel.service.ServiceOperatingMode;
import org.eclipse.papyrus.moka.kernel.service.ServiceRegistry;

public abstract class ExecutionEngine implements IExecutionEngine {

	/**
	 * Initialization task message
	 */
	private static final String INITIALIZATION_TASK = "Initialize execution engine resources";
	
	/**
	 * Dispose task message
	 */
	private static final String DISPOSE_TASK = "Dispose execution engine resources";
	
	/**
	 * Engine ID
	 */
	protected String identifier;
	
	/**
	 * Configuration used to parameterize the engine
	 */
	protected EngineConfiguration configuration;
	
	/**
	 * Status associated with this engine
	 */
	protected ExecutionEngineStatus status;
	
	/**
	 * Enable safe access and update of the status
	 */
	protected ReentrantLock statusLock;

	public ExecutionEngine() {
		status = ExecutionEngineStatus.NONE;
		statusLock = new ReentrantLock(true);
	}
	
	@Override
	public void setID(String id) {
		identifier = id;
	}
	
	@Override
	public String getID() {
		return identifier;
	}
	
	protected void setStatus(ExecutionEngineStatus s) {
		statusLock.lock();
		status = s;
		statusLock.unlock();
	}
	
	protected ExecutionEngineStatus getStatus() {
		ExecutionEngineStatus s = null;
		statusLock.lock();
		s = status;
		statusLock.unlock();
		return s;
	}
	
	public EngineConfiguration getConfiguration() {
		return configuration;
	}

	/**
	 * @see {@link IExecutionEngine#run(EngineConfiguration, SubMonitor)}
	 * 
	 * Initialize, start and dispose the execution engine.
	 * 
	 * Clients are not intended to override this operation.
	 */
	@Override
	public void run(final EngineConfiguration configuration, SubMonitor monitor) {
		setStatus(ExecutionEngineStatus.INITIALIZING);
		init(configuration, monitor);
		setStatus(ExecutionEngineStatus.RUNNING);
		start(monitor);
		setStatus(ExecutionEngineStatus.DISPOSING);
		dispose(monitor);
		setStatus(ExecutionEngineStatus.TERMINATED);
	}

	/**
	 * Initialize resources (e.g., services) used by the execution engine.
	 * 
	 * @param configuration of this engine
	 * 
	 * @param monitor to report progress
	 */
	protected void init(final EngineConfiguration configuration, SubMonitor monitor) {
		this.configuration = configuration;
		if (configuration.getMode().equals(ServiceOperatingMode.NORMAL)) {
			ServiceRegistry registry = ServiceRegistry.getInstance();
			registry.loadServices(this);
			Collection<IExecutionEngineService<IExecutionEngine>> services = registry.getAllServices();
			SubMonitor progress = monitor.split(services.size());
			progress.subTask(INITIALIZATION_TASK);
			for (IExecutionEngineService<IExecutionEngine> service : services) {
				service.init(this);
				progress.worked(1);
			}
		}
	}

	/**
	 * Start the execution engine. 
	 * 
	 * Clients are intended to override this operation.
	 * 
	 * Clients are not intended to call this operation directly.
	 * 
	 * @param monitor to report progress
	 */
	protected abstract void start(SubMonitor monitor);

	/**
	 * Stop the execution engine
	 * 
	 * Clients may override this operation.
	 * 
	 * Clients are not intended to call this operation directly.
	 * 
	 * @param monitor to report progress
	 */
	protected void dispose(SubMonitor monitor) {
		if (configuration.getMode().equals(ServiceOperatingMode.NORMAL)) {
			ServiceRegistry registry = ServiceRegistry.getInstance();
			Collection<IExecutionEngineService<IExecutionEngine>> services = registry.getAllServices();
			SubMonitor progress = monitor.split(services.size());
			progress.subTask(DISPOSE_TASK);
			for (IExecutionEngineService<IExecutionEngine> service : services) {
				service.dispose(this);
				progress.worked(1);
			}
			registry.clear();
		}
	}

	/**
	 * see {@link ITerminate#canTerminate()}
	 * 
	 * Base implementation does not allow the engine to be terminated.
	 * 
	 * Clients may override this operation
	 */
	@Override
	public boolean canTerminate() {
		return false;
	}
	
	/**
	 * see {@link ITerminate#isTerminated()}
	 */
	@Override
	public boolean isTerminated() {
		return getStatus().equals(ExecutionEngineStatus.TERMINATED);
	}
	
	/**
	 * see {@link ITerminate#terminate()}
	 */
	@Override
	public void terminate() throws DebugException {
		// Default implementation does nothing
	}

}
