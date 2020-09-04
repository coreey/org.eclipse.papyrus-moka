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
package org.eclipse.papyrus.moka.kernel.process;

import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.kernel.engine.EngineConfiguration;
import org.eclipse.papyrus.moka.kernel.engine.IExecutionEngine;

public class ExecutionEngineProcess extends BaseProcess<ExecutionEngineJob>
		implements IJobChangeListener, IExecutionEngineContainer {

	public ExecutionEngineProcess(ILaunch launch, IExecutionEngine engine,
			EngineConfiguration<? extends EObject> config) {
		super(launch);
		process = new ExecutionEngineJob(engine, config);
		process.addJobChangeListener(this);
	}

	/**
	 * @see {@link IProcess#canTerminate()}
	 * 
	 *      The process can be terminated if the job is running
	 */
	@Override
	public boolean canTerminate() {
		return getStatus().equals(MokaProcessStatus.RUNNING);
	}

	/**
	 * @see {@link IProcess#isTerminated()}
	 * 
	 *      The process is considered as done when its status is terminated
	 */
	@Override
	public boolean isTerminated() {
		return getStatus().equals(MokaProcessStatus.TERMINATED);
	}

	/**
	 * @see {@link IProcess#terminate()}
	 * 
	 *      Request the process to be canceled. Cancellation may only work if the
	 *      process supports cancellation (i.e., it checks for cancellation)
	 *      requests
	 */
	@Override
	public void terminate() throws DebugException {
		process.cancel();
	}

	@Override
	public IStreamsProxy getStreamsProxy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getExitValue() throws DebugException {
		// Throws debug exception if the engine job is not done
		// Otherwise 0 is returned if the termination is normal -1
		// conversely
		if (!isTerminated()) {
			throw new DebugException(Status.CANCEL_STATUS);
		}
		return process.getResult().getCode();
	}

	@Override
	public void run() {
		// Run the engine job. This operation may return
		// before the process is started
		if (process != null) {
			process.setPriority(Job.SHORT);
			process.schedule();
		}
	}

	@Override
	public void aboutToRun(IJobChangeEvent event) {
		// Not an information of interest
	}

	@Override
	public void awake(IJobChangeEvent event) {
		// Not an information of interest
	}

	@Override
	public void done(IJobChangeEvent event) {
		setStatus(MokaProcessStatus.TERMINATED);
		fireTerminateEvent();
	}

	@Override
	public void running(IJobChangeEvent event) {
		setStatus(MokaProcessStatus.RUNNING);
	}

	@Override
	public void scheduled(IJobChangeEvent event) {
		// Not an information of interest
	}

	@Override
	public void sleeping(IJobChangeEvent event) {
		// Not an information of interest
	}

	@Override
	public IExecutionEngine getExecutionEngine() {
		if (process != null) {
			return process.getExecutionEngine();
		}
		return null;
	}

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		// No adaptation is supported hence null is always returned
		return null;
	}

	private void fireTerminateEvent() {
		DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] { new DebugEvent(this, DebugEvent.TERMINATE) });
	}
}
