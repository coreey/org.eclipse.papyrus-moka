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

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IProcess;

public abstract class BaseProcess<ProcessType> implements IProcess {

	/**
	 * Process name
	 */
	private static final String MOKA_PROCESS_NAME = "Moka Process";

	/**
	 * Process status
	 */
	protected MokaProcessStatus status;
	
	/**
	 * Enable safe access and modification of the process status
	 */
	protected ReentrantLock statusLock;
	
	/**
	 * The launcher that spawned the execution
	 */
	protected ILaunch launch;

	/**
	 * The concrete process / thread / job on which the execution effectively takes
	 * place
	 */
	protected ProcessType process;

	/**
	 * Enable attributes to be define for the process
	 */
	protected Map<String, String> attributes;

	public BaseProcess(ILaunch l) {
		status = MokaProcessStatus.NONE;
		statusLock = new ReentrantLock(true);
		launch = l;
		process = null;
		attributes = new HashMap<>();
	}
	
	protected void setStatus(MokaProcessStatus s) {
		statusLock.lock();
		status = s;
		statusLock.unlock();
	}

	protected MokaProcessStatus getStatus() {
		MokaProcessStatus s = null;
		statusLock.lock();
		s = status;
		statusLock.unlock();
		return s;
	}
	
	public ProcessType getProcess() {
		return process;
	}
	
	@Override
	public ILaunch getLaunch() {
		return launch;
	}

	@Override
	public String getLabel() {
		return MOKA_PROCESS_NAME;
	}

	@Override
	public void setAttribute(String key, String value) {
		if (key != null && !key.isEmpty()) {
			attributes.put(key, value);
		}
	}

	@Override
	public String getAttribute(String key) {
		return attributes.get(key);
	}

	public abstract void run();
}
