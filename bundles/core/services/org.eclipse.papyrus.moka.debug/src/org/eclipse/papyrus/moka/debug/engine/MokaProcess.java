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

import java.util.HashMap;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;
import org.eclipse.papyrus.moka.debug.MokaDebugPlugin;
import org.eclipse.papyrus.moka.utils.constants.MokaConstants;

public class MokaProcess implements IProcess {

	protected HashMap<String, String> attributes;

	// The launch configuration from which the process was created
	protected ILaunch launch;

	// The job at which the execution takes place
	protected Job executionEngineJob;

	private IStatus jobStatus;

	public MokaProcess(ILaunch launch, Job executionEngineJob) {
		this.attributes = new HashMap<String, String>();
		this.launch = launch;
		this.jobStatus = null;
		this.executionEngineJob = executionEngineJob;
	}

	public void schedule(int priority) {
		this.executionEngineJob.setName(MokaConstants.EXECUTION_ENGINE_JOB_NAME);
		this.executionEngineJob.setPriority(priority);
		this.executionEngineJob.schedule();
	}


	@Override
	public boolean canTerminate() {
		// The process cannot be terminated directly. The termination of
		// the process only occur by the termination of the debug session.
		return this.launch.getDebugTarget() == null && !this.isTerminated();
	}

	@Override
	public boolean isTerminated() {
		return this.jobStatus != null && (this.jobStatus.getSeverity() == IStatus.OK |
				this.jobStatus.getSeverity() == IStatus.CANCEL |
				this.jobStatus.getSeverity() == IStatus.ERROR);
	}

	@Override
	public void terminate() throws DebugException {
		if (this.executionEngineJob != null) {
			if (!this.executionEngineJob.cancel()) {
				try {
					this.executionEngineJob.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.jobStatus = this.executionEngineJob.getResult();
			DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] { new DebugEvent(this, DebugEvent.TERMINATE) });
		}
	}

	@Override
	public String getLabel() {
		return "Moka process";
	}

	@Override
	public ILaunch getLaunch() {
		return this.launch;
	}

	@Override
	public IStreamsProxy getStreamsProxy() {
		return null;
	}

	@Override
	public int getExitValue() throws DebugException {
		if (this.isTerminated()) {
			return this.jobStatus.getSeverity();
		}
		throw new DebugException(new Status(IStatus.ERROR, MokaDebugPlugin.PLUGIN_ID, "Moka execution process is still running"));
	}


	@Override
	public void setAttribute(String key, String value) {
		String keyValue = this.attributes.get(key);
		if (keyValue != null) {
			if (!value.equals(keyValue)) {
				keyValue = value;
			}
		} else {
			this.attributes.put(key, value);
		}

	}

	@Override
	public String getAttribute(String key) {
		return this.attributes.get(key);
	}

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		// TODO Auto-generated method stub
		return null;
	}


}
