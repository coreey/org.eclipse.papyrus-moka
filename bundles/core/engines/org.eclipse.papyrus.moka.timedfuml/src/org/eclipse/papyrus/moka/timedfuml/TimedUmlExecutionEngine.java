/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.timedfuml;

import org.eclipse.papyrus.moka.composites.Semantics.impl.Loci.LociL3.CS_Executor;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.fuml.control.execution.RootExecution;
import org.eclipse.papyrus.moka.fuml.control.queue.ExecutionController;
import org.eclipse.papyrus.moka.fuml.statemachines.StateMachineExecutionEngine;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Loci.SM_Locus;
import org.eclipse.papyrus.moka.timedfuml.control.queue.TimedExecutionLoop;
import org.eclipse.papyrus.moka.timedfuml.semantics.Timed_ExecutionFactory;
import org.eclipse.uml2.uml.Behavior;

public class TimedUmlExecutionEngine extends StateMachineExecutionEngine {

	@Override
	public ILocus initializeLocus() {
		this.locus = new SM_Locus();
		locus.setExecutor(new CS_Executor());
		locus.setFactory(new Timed_ExecutionFactory());
		return this.locus;
	}
	
	@Override
	protected void run_() {
		// Starts the execution loop
		RootExecution rootExecution = new RootExecution((Behavior) this.executionEntryPoint, this.executionArguments, locus);
		ExecutionController.getInstance().setExecutionLoop(new TimedExecutionLoop());
		ExecutionController.getInstance().start(rootExecution);
	}

}
