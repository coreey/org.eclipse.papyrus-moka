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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.DebugException;
import org.eclipse.papyrus.moka.kernel.engine.EngineConfiguration;
import org.eclipse.papyrus.moka.kernel.engine.IExecutionEngine;

public class ExecutionEngineJob extends Job implements IExecutionEngineContainer{

	/** 
	 * The execution engine used to realize the model execution
	 */
	protected IExecutionEngine engine;
		
	/**
	 * The configuration passed to the engine
	 */
	protected EngineConfiguration configuration;
	
	/**
	 * job name
	 */
	private final static String EXECUTION_ENGINE_JOB_NAME = "Execution Engine Job";
	
	public ExecutionEngineJob(IExecutionEngine e, EngineConfiguration c) {
		super(EXECUTION_ENGINE_JOB_NAME);
		engine = e;
		configuration = c;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		// Run the engine over the provided configuration
		// Note that the model execution takes place on a
		// dedicated thread of execution
		if(engine != null && configuration != null) {
			monitor.beginTask("Run execution engine", IProgressMonitor.UNKNOWN);
			engine.run(configuration, SubMonitor.convert(monitor));
			monitor.done();
		}
		return Status.OK_STATUS;
	}
	
	@Override
	protected void canceling() {
		if(engine.canTerminate()) {
			try {
				engine.terminate();
			} catch (DebugException e) {
				e.printStackTrace();
			}
		}
	}
	
	public IExecutionEngine getExecutionEngine(){
		return engine;
	}

}
