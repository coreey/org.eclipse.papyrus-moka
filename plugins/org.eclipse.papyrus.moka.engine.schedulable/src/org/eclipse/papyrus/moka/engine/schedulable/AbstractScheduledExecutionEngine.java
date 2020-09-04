/*****************************************************************************
 * Copyright (c) 2020 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.moka.engine.schedulable;

import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.kernel.engine.AbstractExecutionEngine;
import org.eclipse.papyrus.moka.kernel.engine.EngineConfiguration;
import org.eclipse.papyrus.moka.kernel.scheduling.control.ExecutionController;
import org.eclipse.papyrus.moka.kernel.scheduling.control.ExecutionLoop;
import org.eclipse.papyrus.moka.kernel.scheduling.control.IExecutionController;

public abstract class AbstractScheduledExecutionEngine extends AbstractExecutionEngine
		implements IScheduledExecutionEngine {

	/**
	 * Controller in charge of the execution task management
	 */
	protected IExecutionController controller;

	@Override
	protected void init(EngineConfiguration<? extends EObject> configuration, SubMonitor monitor) {
		super.init(configuration, monitor);
		controller = createController();
	}

	/**
	 * @see {@link IDebuggableExecutionEngine#createController()}
	 */
	public IExecutionController createController() {
		IExecutionController controller = new ExecutionController();
		controller.setExecutionLoop(new ExecutionLoop());
		return controller;
	}

	@Override
	public IExecutionController getController() {
		return controller;
	}

}
