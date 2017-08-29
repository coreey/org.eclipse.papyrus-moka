/*****************************************************************************
 * 
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.fmu.engine;

import org.eclipse.papyrus.moka.composites.Semantics.impl.CommonBehaviors.Communications.CS_DispatchOperationOfInterfaceStrategy;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CommonBehaviors.Communications.CS_NameBased_StructuralFeatureOfInterfaceAccessStrategy;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.InvocationActions.CS_DefaultRequestPropagationStrategy;
import org.eclipse.papyrus.moka.composites.Semantics.impl.Loci.LociL3.CS_Executor;
import org.eclipse.papyrus.moka.discreteevent.DEScheduler;
import org.eclipse.papyrus.moka.discreteevent.Event;
import org.eclipse.papyrus.moka.fmu.control.queue.FMIRootExecution;
import org.eclipse.papyrus.moka.fmu.engine.control.FMUControlService;
import org.eclipse.papyrus.moka.fmu.engine.de.FMIPushPullStrategy;
import org.eclipse.papyrus.moka.fmu.engine.de.FMUStepEnd;
import org.eclipse.papyrus.moka.fmu.engine.semantics.FMUConstructStrategy;
import org.eclipse.papyrus.moka.fmu.engine.semantics.FMUExecutionFactory;
import org.eclipse.papyrus.moka.fmu.engine.semantics.FMULocus;
import org.eclipse.papyrus.moka.fmu.engine.utils.FMUEngineUtils;
import org.eclipse.papyrus.moka.fmu.json.JSONSocketClient;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions.DefaultCreateObjectActionStrategy;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions.DefaultGetAssociationStrategy;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.RedefinitionBasedDispatchStrategy;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications.FIFOGetNextEventStrategy;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1.FirstChoiceStrategy;
import org.eclipse.papyrus.moka.fuml.control.queue.ExecutionController;
import org.eclipse.papyrus.moka.timedfuml.TimedUmlExecutionEngine;
import org.eclipse.papyrus.moka.timedfuml.control.queue.TimedExecutionLoop;
import org.eclipse.uml2.uml.Class;

public class MokaEngineForFMUExport extends TimedUmlExecutionEngine {

	Thread mainThread = null;
	
	@Override
	protected void initDEScheduler() {
		// initialize scheduler
		DEScheduler.init(-1.0, new FMIPushPullStrategy());
	}
	
	protected void doPreRunActions() {
		// Add an event at time 0.0
		FMUStepEnd stepEnd = new FMUStepEnd();
		DEScheduler.getInstance().pushEvent(new Event(0.0, stepEnd));
	}
	
	@Override
	public ILocus initializeLocus() {
		this.locus = new FMULocus();
		locus.setExecutor(new CS_Executor());
		locus.setFactory(new FMUExecutionFactory());
		return this.locus;
	}
	
	@Override
	protected void run_() {
		ExecutionController.getInstance().setExecutionLoop(new TimedExecutionLoop());
		FMUControlService controlService = FMUEngineUtils.getFMUControlService();
		controlService.setRootExecution(
				new FMIRootExecution((Class) this.executionEntryPoint, this.executionArguments, this.locus));
		Runnable execution = new Runnable() {
			public void run() {
				JSONSocketClient client = FMUEngineUtils.getJsonSocketClient();
				client.setFmu(FMUEngineUtils.getFMUControlService());
				client.start();
				FMUEngineUtils.getFMUControlService().waitForTermination();
			}
		};
		mainThread = new Thread(execution, "Moka - Main thread");
		mainThread.start();
	}
	
	
	public void waitForTermination() throws InterruptedException{
		if (mainThread != null){
			mainThread.join();
		}
	}

	// Register semantic strategies available in the environment
		@Override
		protected void registerSemanticStrategies(ILocus locus) {
			locus.getFactory().setStrategy(new FirstChoiceStrategy());
			locus.getFactory().setStrategy(new FIFOGetNextEventStrategy());
			locus.getFactory().setStrategy(new RedefinitionBasedDispatchStrategy());
			locus.getFactory().setStrategy(new DefaultCreateObjectActionStrategy());
			locus.getFactory().setStrategy(new DefaultGetAssociationStrategy());
			locus.getFactory().setStrategy(new CS_DispatchOperationOfInterfaceStrategy());
			locus.getFactory().setStrategy(new CS_NameBased_StructuralFeatureOfInterfaceAccessStrategy());
			locus.getFactory().setStrategy(new CS_DefaultRequestPropagationStrategy());
			locus.getFactory().setStrategy(new FMUConstructStrategy());
		}
	
}
