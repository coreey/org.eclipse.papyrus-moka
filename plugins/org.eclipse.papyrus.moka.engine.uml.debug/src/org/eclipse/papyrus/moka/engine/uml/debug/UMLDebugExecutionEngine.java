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
package org.eclipse.papyrus.moka.engine.uml.debug;

import java.util.ArrayList;

import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.debug.engine.AbstractDebuggableExecutionEngine;
import org.eclipse.papyrus.moka.engine.uml.IUMLExecutionEngine;
import org.eclipse.papyrus.moka.engine.uml.scheduling.UMLTaskExecutionFactory;
import org.eclipse.papyrus.moka.fuml.actions.DefaultCreateObjectActionStrategy;
import org.eclipse.papyrus.moka.fuml.actions.DefaultGetAssociationStrategy;
import org.eclipse.papyrus.moka.fuml.commonbehavior.FIFOGetNextEventStrategy;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IParameterValue;
import org.eclipse.papyrus.moka.fuml.loci.FirstChoiceStrategy;
import org.eclipse.papyrus.moka.fuml.loci.ILocus;
import org.eclipse.papyrus.moka.fuml.loci.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IObject_;
import org.eclipse.papyrus.moka.fuml.tasks.IUMLRootTaskExecution;
import org.eclipse.papyrus.moka.fuml.tasks.IUMLTaskExecutionFactory;
import org.eclipse.papyrus.moka.kernel.engine.EngineConfiguration;
import org.eclipse.papyrus.moka.kernel.engine.ExecutionEngineException;
import org.eclipse.papyrus.moka.kernel.scheduling.control.Scheduler;
import org.eclipse.papyrus.moka.pscs.actions.additions.CS_NotNormativeDefaultConstructStrategy;
import org.eclipse.papyrus.moka.pscs.loci.CS_Executor;
import org.eclipse.papyrus.moka.pscs.structuredclassifiers.CS_DefaultRequestPropagationStrategy;
import org.eclipse.papyrus.moka.pscs.structuredclassifiers.CS_DispatchOperationOfInterfaceStrategy;
import org.eclipse.papyrus.moka.pscs.structuredclassifiers.CS_NameBased_StructuralFeatureOfInterfaceAccessStrategy;
import org.eclipse.papyrus.moka.pssm.loci.SM_ExecutionFactory;
import org.eclipse.papyrus.moka.pssm.loci.SM_Locus;
import org.eclipse.uml2.uml.Element;

public class UMLDebugExecutionEngine extends AbstractDebuggableExecutionEngine<IObject_, ISemanticVisitor>
		implements IUMLExecutionEngine {

	/**
	 * Virtual machine on which the execution takes place
	 */
	protected ILocus locus;

	/**
	 * Factory enabling the creation of the appropriate root task for this engine
	 */
	protected IUMLTaskExecutionFactory rootTaskFactory;

	/**
	 * Behave as the super class. In addition, instantiate the locus and
	 * parameterize it with the appropriate execution factory and executor. Finally,
	 * built in types, libraries and semantic strategies are installed at the locus
	 */
	@Override
	public void init(EngineConfiguration<? extends EObject> configuration, SubMonitor monitor) {
		super.init(configuration, monitor);
		locus = createLocus();
		rootTaskFactory = createUMLTaskFactory();
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
	 * Start the execution. This is technically realized by adding the the root
	 * execution to the execution queue controlled by the execution controller
	 */
	@Override
	public void start(SubMonitor monitor) throws ExecutionEngineException {
		EObject executionSource = configuration.getExecutionSource();
		if (executionSource instanceof Element) {
			Element source = (Element) executionSource;
			if (locus != null && source != null) {
				IUMLRootTaskExecution<?> rootExecution = rootTaskFactory.createRootExecution(source);
				if (rootExecution != null) {
					rootExecution.setLocus(locus);
					rootExecution.setInputParameterValues(new ArrayList<IParameterValue>());
					if (rootExecution.canExecute()) {
						controller.getExecutionLoop().init(rootExecution, new Scheduler());
						SubMonitor progress = monitor.split(1);
						progress.subTask("Run model"); //$NON-NLS-1$
						controller.start();
						progress.worked(1);
					} else {
						throw new ExecutionEngineException(identifier, status,
								"Could not start the execution from the specified model element"); //$NON-NLS-1$
					}
				} else {
					throw new ExecutionEngineException(identifier, status,
							"Could not instantiate an execution from the specified element"); //$NON-NLS-1$
				}
			}
		} else {
			throw new IllegalArgumentException("ExecutionSource in configuration must be instanceOf UML::Element");
		}
	}

	/**
	 * Create and parameterize the locus
	 */
	@Override
	public ILocus createLocus() {
		ILocus locus = new SM_Locus();
		locus.setExecutor(new CS_Executor());
		locus.setFactory(new SM_ExecutionFactory());
		return locus;
	}

	/**
	 * Register UML primitive types
	 */
	@Override
	public void installBuiltInTypes() {
		UMLDebugExecutionEngineHelper.installBuiltInTypes(configuration, locus);
	}

	/**
	 * Install all registered libraries (e.g., the FUML Library)
	 */
	@Override
	public void installLibraries() {
		UMLDebugExecutionEngineHelper.installLibraries(configuration, locus);
	}

	/**
	 * Install semantic strategies used to realized the execution
	 */
	@Override
	public void installSemanticStrategies() {
		if (locus != null) {
			locus.getFactory().setStrategy(new FirstChoiceStrategy());
			locus.getFactory().setStrategy(new FIFOGetNextEventStrategy());
			locus.getFactory().setStrategy(new CS_DispatchOperationOfInterfaceStrategy());
			locus.getFactory().setStrategy(new CS_NameBased_StructuralFeatureOfInterfaceAccessStrategy());
			locus.getFactory().setStrategy(new CS_DefaultRequestPropagationStrategy());
			locus.getFactory().setStrategy(new CS_NotNormativeDefaultConstructStrategy());
			locus.getFactory().setStrategy(new DefaultGetAssociationStrategy());
			locus.getFactory().setStrategy(new DefaultCreateObjectActionStrategy());
		}
	}

}
