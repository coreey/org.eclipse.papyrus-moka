/*****************************************************************************
 * Copyright (c) 2019, 2020 CEA LIST and others.
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
package org.eclipse.papyrus.moka.engine.uml;

import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.papyrus.moka.engine.schedulable.AbstractScheduledExecutionEngine;
import org.eclipse.papyrus.moka.engine.uml.scheduling.UMLTaskExecutionFactory;
import org.eclipse.papyrus.moka.fuml.loci.ILocus;
import org.eclipse.papyrus.moka.fuml.tasks.IUMLTaskExecutionFactory;
import org.eclipse.papyrus.moka.kernel.engine.EngineConfiguration;
import org.eclipse.papyrus.moka.kernel.scheduling.control.ExecutionController;
import org.eclipse.papyrus.moka.kernel.scheduling.control.ExecutionLoop;
import org.eclipse.papyrus.moka.kernel.scheduling.control.IExecutionController;

public abstract class AbstractUMLExecutionEngine extends AbstractScheduledExecutionEngine
		implements IUMLExecutionEngine {

	/**
	 * Virtual machine on which the execution takes place
	 */
	protected ILocus locus;

	/**
	 * Factory enabling the creation of the appropriate root task for this engine
	 */
	protected IUMLTaskExecutionFactory rootTaskFactory;

	@Override
	protected void init(EngineConfiguration<?> configuration, SubMonitor monitor) {

		super.init(configuration, monitor);
		locus = createLocus();
		rootTaskFactory = createUMLTaskFactory();
		controller = createController();
		locus.getFactory().setTaskFactory(rootTaskFactory);
		installBuiltInTypes();
		installLibraries();
		installSemanticStrategies();
	}

	/**
	 * Create the UML task factory used by this engine
	 * 
	 * @return the task factory
	 */
	protected IUMLTaskExecutionFactory createUMLTaskFactory() {
		return new UMLTaskExecutionFactory(controller.getExecutionLoop());
	}

	/**
	 * @see {@link IDebuggableExecutionEngine#createController()}
	 */
	public IExecutionController createController() {
		IExecutionController controller = new ExecutionController();
		controller.setExecutionLoop(new ExecutionLoop());
		return controller;
	}

	/**
	 * Create and parameterize the locus
	 */
	@Override
	public ILocus createLocus() {
		return UMLExecutionEngineHelper.createLocus();
	}

	/**
	 * Register UML primitive types
	 */
	@Override
	public void installBuiltInTypes() {
		UMLExecutionEngineHelper.installBuiltInTypes(configuration, locus);
	}

	/**
	 * Install all registered libraries (e.g., the FUML Library)
	 */
	@Override
	public void installLibraries() {

		UMLExecutionEngineHelper.installLibraries(configuration, locus);
	}

	/**
	 * Install semantic strategies used to realized the execution
	 */
	@Override
	public void installSemanticStrategies() {
		UMLExecutionEngineHelper.installSemanticStrategies(locus);
	}

}
