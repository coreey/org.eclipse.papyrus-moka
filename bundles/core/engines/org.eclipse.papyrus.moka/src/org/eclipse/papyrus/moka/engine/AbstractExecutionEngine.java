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
import org.eclipse.debug.core.ILaunch;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.service.IMokaService;
import org.eclipse.papyrus.moka.service.MokaServiceRegistry;

public abstract class AbstractExecutionEngine implements IExecutionEngine {

	// Model element used as execution entry point
	protected EObject executionEntryPoint;

	// Arguments provided to the execution engine
	protected String[] executionArgs;

	// Debug session in which is executed the execution engine.
	protected ILaunch launch;
	
	// Engine operating mode 
	protected OperatingMode mode;

	@Override
	public void init(ILaunch launch, EObject executionEntryPoint, String[] executionArgs, OperatingMode mode) {
		this.launch = launch;
		this.executionEntryPoint = executionEntryPoint;
		this.executionArgs = executionArgs;
		this.mode = mode;
	}

	public void start(IProgressMonitor monitor) {
		if(!mode.equals(OperatingMode.QUIET)){
			// Initialize every service with the parameters of this particular run
			MokaServiceRegistry registry = MokaServiceRegistry.getInstance();
			registry.loadServices();
			for (IMokaService service : registry.getAllServices()) {
				service.init(this.launch, executionEntryPoint);
			}
		}
	}

	@Override
	public void stop(IProgressMonitor monitor) {
		if(!mode.equals(OperatingMode.QUIET)){
			// Enable all services to dispose the resources they use.
			MokaServiceRegistry registry = MokaServiceRegistry.getInstance();
			monitor.subTask("Dispose Moka services");
			for (IMokaService service : registry.getAllServices()) {
				service.dispose();
			}
		}
	}

	public abstract void initializeArguments(String[] args);
}
