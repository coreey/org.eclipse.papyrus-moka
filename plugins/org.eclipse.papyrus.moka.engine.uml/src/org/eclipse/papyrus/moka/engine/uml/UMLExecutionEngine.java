/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
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

import java.util.ArrayList;

import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.papyrus.moka.debug.engine.DebuggableExecutionEngine;
import org.eclipse.papyrus.moka.debug.engine.IDebuggableExecutionEngine;
import org.eclipse.papyrus.moka.debug.engine.IDebuggableExecutionEngineThread;
import org.eclipse.papyrus.moka.engine.uml.libraries.LibraryRegistry;
import org.eclipse.papyrus.moka.engine.uml.scheduling.IUMLRootExecution;
import org.eclipse.papyrus.moka.engine.uml.scheduling.IsTargetThreadCondition;
import org.eclipse.papyrus.moka.engine.uml.scheduling.UMLTaskExecutionFactory;
import org.eclipse.papyrus.moka.fuml.actions.DefaultCreateObjectActionStrategy;
import org.eclipse.papyrus.moka.fuml.actions.DefaultGetAssociationStrategy;
import org.eclipse.papyrus.moka.fuml.commonbehavior.FIFOGetNextEventStrategy;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IParameterValue;
import org.eclipse.papyrus.moka.fuml.loci.FirstChoiceStrategy;
import org.eclipse.papyrus.moka.fuml.loci.ILocus;
import org.eclipse.papyrus.moka.fuml.loci.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IObject_;
import org.eclipse.papyrus.moka.kernel.engine.EngineConfiguration;
import org.eclipse.papyrus.moka.kernel.scheduling.control.Scheduler;
import org.eclipse.papyrus.moka.pscs.actions.additions.CS_NotNormativeDefaultConstructStrategy;
import org.eclipse.papyrus.moka.pscs.loci.CS_Executor;
import org.eclipse.papyrus.moka.pscs.structuredclassifiers.CS_DefaultRequestPropagationStrategy;
import org.eclipse.papyrus.moka.pscs.structuredclassifiers.CS_DispatchOperationOfInterfaceStrategy;
import org.eclipse.papyrus.moka.pscs.structuredclassifiers.CS_NameBased_StructuralFeatureOfInterfaceAccessStrategy;
import org.eclipse.papyrus.moka.pssm.loci.SM_ExecutionFactory;
import org.eclipse.papyrus.moka.pssm.loci.SM_Locus;
import org.eclipse.papyrus.moka.utils.UMLPrimitiveTypesUtils;
import org.eclipse.uml2.uml.Class;

public class UMLExecutionEngine extends DebuggableExecutionEngine<IObject_, ISemanticVisitor>
		implements IUMLExecutionEngine {

	/**
	 * Virtual machine on which the execution takes place
	 */
	protected ILocus locus;

	/**
	 * Behave as the super class. In addition, instantiate the locus and
	 * parameterize it with the appropriate execution factory and executor. Finally,
	 * built in types, libraries and semantic strategies are installed at the locus
	 */
	@Override
	public void init(EngineConfiguration configuration, SubMonitor monitor) {
		super.init(configuration, monitor);
		locus = createLocus();
		installBuiltInTypes();
		installLibraries();
		installSemanticStrategies();
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
	 * Start the execution. This is technically realized by adding the the root
	 * execution to the execution queue controlled by the execution controller
	 */
	@Override
	public void start(SubMonitor monitor) {
		Class source = configuration.getExecutionSource();
		if (locus != null && source != null) {
			UMLTaskExecutionFactory factory = UMLTaskExecutionFactory.getFactory();
			factory.setExecutionLoop(controller.getExecutionLoop());
			IUMLRootExecution rootExecution = factory.createRootExecution();
			rootExecution.setRoot(source);
			rootExecution.setLocus(locus);
			rootExecution.setInputParameterValues(new ArrayList<IParameterValue>());
			controller.getExecutionLoop().init(rootExecution, new Scheduler());
			SubMonitor progress = monitor.split(1);
			progress.subTask("Run model");
			controller.start();
			progress.worked(1);
		}
	}

	/**
	 * Register UML primitive types
	 */
	@Override
	public void installBuiltInTypes() {
		Class source = configuration.getExecutionSource();
		if (locus != null && source != null) {
			locus.getFactory().addBuiltInType(UMLPrimitiveTypesUtils.getReal(source));
			locus.getFactory().addBuiltInType(UMLPrimitiveTypesUtils.getInteger(source));
			locus.getFactory().addBuiltInType(UMLPrimitiveTypesUtils.getBoolean(source));
			locus.getFactory().addBuiltInType(UMLPrimitiveTypesUtils.getString(source));
		}
	}

	/**
	 * Install all registered libraries (e.g., the FUML Library)
	 */
	@Override
	public void installLibraries() {
		Class source = configuration.getExecutionSource();
		if (locus != null && source.eResource() != null && source.eResource().getResourceSet() != null) {
			LibraryRegistry.getInstance().loadLibraryFactories(source.eResource().getResourceSet());
			LibraryRegistry.getInstance().installLibraries(locus);
		}
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

	/**
	 * @see {@link IDebuggableExecutionEngine#suspendThread(Object)}
	 */
	@Override
	public IDebuggableExecutionEngineThread<IObject_, ISemanticVisitor> getThread(String identifier) {
		 IDebuggableExecutionEngineThread<IObject_, ISemanticVisitor> thread = null;
		if(!debuggableThreadLock.isHeldByCurrentThread()) {
			debuggableThreadLock.lock();
		}
		thread = debuggableThread.get(identifier);
		if(debuggableThreadLock.isHeldByCurrentThread()) {
			debuggableThreadLock.unlock();
		}
		return thread;
	}

	/**
	 * @see {@link IDebuggableExecutionEngine#suspendThread(Object)}
	 * 
	 *      Execution of this active object is suspended
	 */
	public void suspendThread(IDebuggableExecutionEngineThread<IObject_, ISemanticVisitor> debuggableThread) {
		controller.getExecutionLoop().suspend(new IsTargetThreadCondition(debuggableThread.getThread()));
	}

	/**
	 * @see {@link IDebuggableExecutionEngine#resumeThread(Object)}
	 * 
	 *      Execution of this active object is resumed
	 */
	public void resumeThread(IDebuggableExecutionEngineThread<IObject_, ISemanticVisitor> debuggableThread) {
		controller.getExecutionLoop().resume(new IsTargetThreadCondition(debuggableThread.getThread()));
	}

	/**
	 * @see {@link IDebuggableExecutionEngine#terminateThread(Object)}
	 * 
	 *      Execution of this active object is terminated
	 */
	public void terminateThread(IDebuggableExecutionEngineThread<IObject_, ISemanticVisitor> debuggableThread) {
		controller.getExecutionLoop().terminate(new IsTargetThreadCondition(debuggableThread.getThread()));
	}

}
