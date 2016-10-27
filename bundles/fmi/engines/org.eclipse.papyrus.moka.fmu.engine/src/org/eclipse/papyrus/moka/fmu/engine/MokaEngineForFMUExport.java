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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CommonBehaviors.Communications.CS_DispatchOperationOfInterfaceStrategy;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CommonBehaviors.Communications.CS_NameBased_StructuralFeatureOfInterfaceAccessStrategy;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.InvocationActions.CS_DefaultRequestPropagationStrategy;
import org.eclipse.papyrus.moka.composites.Semantics.impl.Loci.LociL3.CS_Executor;
import org.eclipse.papyrus.moka.discreteevent.DEScheduler;
import org.eclipse.papyrus.moka.fmi.profile.util.FMIProfileUtil;
import org.eclipse.papyrus.moka.fmu.engine.de.FMIPushPullStrategy;
import org.eclipse.papyrus.moka.fmu.engine.semantics.FMUConstructStrategy;
import org.eclipse.papyrus.moka.fmu.engine.semantics.FMUExecutionFactory;
import org.eclipse.papyrus.moka.fmu.engine.semantics.FMULocus;
import org.eclipse.papyrus.moka.fmu.engine.semantics.FMUObject;
import org.eclipse.papyrus.moka.fmu.engine.utils.FMUEngineUtils;
import org.eclipse.papyrus.moka.fmu.json.JSONSocketClient;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions.CreateObjectActionStrategy;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions.DefaultCreateObjectActionStrategy;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions.DefaultGetAssociationStrategy;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.RedefinitionBasedDispatchStrategy;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications.FIFOGetNextEventStrategy;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1.FirstChoiceStrategy;
import org.eclipse.papyrus.moka.service.IMokaService;
import org.eclipse.papyrus.moka.service.MokaServiceRegistry;
import org.eclipse.papyrus.moka.timedfuml.TimedUmlExecutionEngine;
import org.eclipse.uml2.uml.Class;

public class MokaEngineForFMUExport extends TimedUmlExecutionEngine {

	Thread mainThread=null;
	
	@Override
	public void start(IProgressMonitor monitor) {
		if(!mode.equals(OperatingMode.QUIET)){
			// Initialize every service with the parameters of this particular run
			MokaServiceRegistry registry = MokaServiceRegistry.getInstance();
			registry.loadServices();
			for (IMokaService service : registry.getAllServices()) {
				service.init(this.launch, executionEntryPoint);
			}
		}
		Runnable execution = new Runnable() {
			public void run() {
				Class fmuClass = FMUEngineUtils.getFMUControlService().getFmuClass() ; 
				if (fmuClass != null) {
					startFMU(fmuClass);
					DEScheduler.init(-1.0, new FMIPushPullStrategy());
					JSONSocketClient client = FMUEngineUtils.getJsonSocketClient();
					client.setFmu(FMUEngineUtils.getFMUControlService());
					client.start();
					FMUEngineUtils.getFMUControlService().waitForTermination();
				}
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

	public void startFMU(Class fmuClass) {
		if (fmuClass != null && FMIProfileUtil.isCS_FMU(fmuClass)) {
			// creates the locus, executor and execution factory
			this.locus = new FMULocus();
			locus.setExecutor(new CS_Executor());
			locus.setFactory(new FMUExecutionFactory());

			// initializes built-in primitive types
			this.initializeBuiltInPrimitiveTypes(locus);

			// Initializes opaque behavior executions
			this.registerOpaqueBehaviorExecutions(locus);
			
			// Initializes semantic strategies
			this.registerSemanticStrategies(locus);
			
			// Initializes system services
			this.registerSystemServices(locus);

			// Finally instantiate the fmu object
			CreateObjectActionStrategy strategy = (CreateObjectActionStrategy)this.locus.getFactory().getStrategy("CreateObjectActionStrategy") ;
			//FMUObject fmuObject = (FMUObject)this.locus.instantiate(fmuClass) ;
			FMUObject fmuObject = (FMUObject)strategy.instantiate(fmuClass, locus) ;
			FMUEngineUtils.getFMUControlService().setFmuObject(fmuObject);

			
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
