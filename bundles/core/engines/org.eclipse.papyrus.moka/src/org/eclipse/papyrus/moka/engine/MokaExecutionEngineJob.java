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
package org.eclipse.papyrus.moka.engine;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.engine.IExecutionEngine.OperatingMode;
import org.eclipse.papyrus.moka.utils.constants.MokaConstants;

public class MokaExecutionEngineJob extends Job {

	// The execution engine started in the context of this job
	protected IExecutionEngine engine;

	// Model element used as entry point of the execution
	protected EObject executionEntryPoint;

	// True if cancel() has been called on this job
	protected boolean isCanceling = false ;
	
	// Arguments of the execution engine
	protected String[] executionArgs;

	protected IProgressMonitor monitor;

	protected ILaunch launch;

	protected static MokaExecutionEngineJob ENGINE_MAIN_JOB;

	private MokaExecutionEngineJob() {
		super(MokaConstants.EXECUTION_ENGINE_JOB_NAME);
	}

	public static MokaExecutionEngineJob getInstance() {
		if (ENGINE_MAIN_JOB == null) {
			ENGINE_MAIN_JOB = new MokaExecutionEngineJob();
		}
		return ENGINE_MAIN_JOB;
	}
	
	public boolean isCanceling() {
		return this.isCanceling ;
	}
	
	@Override
	protected void canceling() {
		this.isCanceling = true ;
		super.canceling();
	}

	public void initialize(ILaunch launch, IExecutionEngine engine, EObject executionEntryPoint, String[] executionArgs) {
		this.launch = launch;
		this.engine = engine;
		this.executionEntryPoint = executionEntryPoint;
		this.executionArgs = executionArgs;
		this.addJobChangeListener(new MokaExecutionEngineSpy());
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		IStatus jobStatus = new Status(IStatus.OK, "org.eclipse.papyrus.moka", "Execution was successfull");
		this.monitor = monitor;
		this.engine.init(this.launch, this.executionEntryPoint, this.executionArgs, OperatingMode.NORMAL);
		try {
			this.engine.start(monitor);
		} catch (OperationCanceledException cancellationException) {
			jobStatus = new Status(IStatus.CANCEL, "org.eclipse.papyrus.moka", "Execution stopped by user request");
		} catch (Exception e) {
			if (monitor.isCanceled()) {
				jobStatus = new Status(IStatus.CANCEL, "org.eclipse.papyrus.moka", "Execution stopped by user request");
			} else {
				jobStatus = new Status(IStatus.ERROR, "org.eclipse.papyrus.moka", "Execution stopped: unexpected exception", e);
			}
		}
		return jobStatus;
	}

	public IProgressMonitor getMonitor() {
		return this.monitor;
	}

	public IExecutionEngine getEngine() {
		return this.engine;
	}

	class MokaExecutionEngineSpy implements IJobChangeListener {

		public void done(IJobChangeEvent event) {
			// Whatever is the kind of the job termination; each time the
			// execution terminates it must release safely the resources
			// that might have been acquired by the execution engine. It is
			// the responsibility of the execution engine to provide an adequate
			// implementation of the stop operation
			MokaExecutionEngineJob.ENGINE_MAIN_JOB = null;
			Job stop = new StopJob(MokaExecutionEngineJob.this.engine);
			stop.setUser(true);
			stop.schedule(Job.SHORT);
		}

		@Override
		public void aboutToRun(IJobChangeEvent event) {
			// Do nothing
		}

		@Override
		public void awake(IJobChangeEvent event) {
			// Do nothing

		}

		@Override
		public void running(IJobChangeEvent event) {
			// Do nothing

		}

		@Override
		public void scheduled(IJobChangeEvent event) {
			// Do nothing

		}

		@Override
		public void sleeping(IJobChangeEvent event) {
			// Do nothing
		}

	}

	// This job is executed to release the resources that are currently used
	// by the execution engine. The action of releasing the resources consist
	// in the call of the stop operation provided by an IExecutionEngine.
	class StopJob extends Job {

		protected IExecutionEngine engine;

		public StopJob(IExecutionEngine engine) {
			super("Release execution engine resources");
			this.engine = engine;
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			monitor.beginTask("Dispose execution engine resources...", IProgressMonitor.UNKNOWN);
			try {
				this.engine.stop(monitor);
			} catch (Exception e) {
				// TODO: register an error within the error log
			} finally {
				monitor.done();
			}
			return new Status(IStatus.OK, "org.eclipse.papyrus.moka", "Resources release with success");
		}
	}

}
