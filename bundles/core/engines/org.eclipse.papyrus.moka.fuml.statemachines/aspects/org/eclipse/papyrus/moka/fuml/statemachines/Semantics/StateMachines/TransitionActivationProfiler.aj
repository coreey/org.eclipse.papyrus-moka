/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
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
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines;

import org.eclipse.papyrus.moka.engine.MokaExecutionEngineJob;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.profiling.Semantics.Loci.SemanticVisitorProfiler;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.ITransitionActivation;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;

public aspect TransitionActivationProfiler extends SemanticVisitorProfiler{

	public TransitionActivationProfiler(){
		super();
	}
	
	// Define a point cut for each class that implements the exitSource operation
	// declared by ITransitionActivation interface
	pointcut exitSource(ITransitionActivation activation, IEventOccurrence eventOccurrence) : 
		target(activation) &&
		args(eventOccurrence) &&
		call(* ITransitionActivation.exitSource(IEventOccurrence));
	
	// Declare an advice that is triggered after exitSource was executed
	after(ITransitionActivation activation, IEventOccurrence eventOccurrence): exitSource(activation, eventOccurrence){
		IProgressMonitor monitor = MokaExecutionEngineJob.getInstance().getMonitor();
		if(monitor!=null && monitor.isCanceled()){
			throw new OperationCanceledException();
		}
		this.fireNodeVisited(new TransitionActivationWrapper(activation, eventOccurrence));
	}
	
	// Define a point cut for each class that implements the enterTarget operation
	// declared by ITransitionActivation interface.
	pointcut enterTarget(ITransitionActivation activation, IEventOccurrence eventOccurrence) : 
		target(activation) &&
		args(eventOccurrence) &&
		call(* ITransitionActivation.enterTarget(IEventOccurrence));
	
	// Declare an advice that is triggered before enterTarget operation is executed.
	before(ITransitionActivation activation, IEventOccurrence eventOccurrence): enterTarget(activation, eventOccurrence){
		IProgressMonitor monitor = MokaExecutionEngineJob.getInstance().getMonitor();
		if(monitor!=null && monitor.isCanceled()){
			throw new OperationCanceledException();
		}
		this.fireNodeLeft(new TransitionActivationWrapper(activation, eventOccurrence));
	}
}
