/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
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
 *  Jeremie Tatibouet (CEA LIST)
 *
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines;

import java.util.Iterator;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IHistoryPseudostateActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IRegionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IStateActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IStateMachineExecution;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.ITransitionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IVertexActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.StateMetadata;
import org.eclipse.uml2.uml.State;

public abstract class HistoryPseudostateActivation extends PseudostateActivation implements IHistoryPseudostateActivation{

	public boolean hasDefaultTransition(){
		// Determine if the history pseudo-state activation has default transition.
		// Returns true if it has one, false otherwise
		boolean defaultTransition = false;
		if(this.outgoingTransitionActivations.size()==1){
			defaultTransition = true;
		}
		return defaultTransition;
	}
	
	@Override
	public void enter(ITransitionActivation enteringTransition, IEventOccurrence eventOccurrence, IRegionActivation leastCommonAncestor) {
		// When entering an history pseudo-state two distinct situations can occur:
		// 1. The region has no history and the history pseudo-state has no default
		//    transition to force entry of a particular vertex. In such situation
		//    there is no other possibility than to perform a default entry for the
		//    state hierarchy in which the history pseudo-state is nested. Note that
		//    if the pseudo-state is placed directly in a region owned by the state
		//    machine then the region in which it is placed performs a default entry.
		// 2. The region already has an history or at least has a default transition
		//    to force entry to in a particular vertex. In such situation, the state
		//    hierarchy of the parent state of the history pseudo-state is entered.
		//    Next the containing state is restored (the result of the restoration
		//    process is dependent of the type of the history). Note that if the history
		//    is placed in a region directly owned by the state-machine then the
		//    restoration process starts from the region.
		IVertexActivation parentVertexActivation = this.getParentVertexActivation();
		if(parentVertexActivation != null){
			IRegionActivation owningRegionActivation = this.getOwningRegionActivation();
			if(owningRegionActivation.getHistory() == null && !this.hasDefaultTransition()){
				super.enter(enteringTransition, eventOccurrence, leastCommonAncestor);
			}else{
				parentVertexActivation = (IStateActivation) parentVertexActivation;
				parentVertexActivation.setStatus(StateMetadata.ACTIVE);
				super.enter(enteringTransition, eventOccurrence, leastCommonAncestor);
				this.restore((IStateActivation)parentVertexActivation, enteringTransition, eventOccurrence);
			}
		}else{
			IRegionActivation owningRegionActivation = this.getOwningRegionActivation();
			if(owningRegionActivation.getHistory() == null && !this.hasDefaultTransition()){
				owningRegionActivation.enter(enteringTransition, eventOccurrence);
			}else{
				this.restore(owningRegionActivation, enteringTransition, eventOccurrence);
			}
		}
		if(this.isActive()){
			this.exit(null, null, null);
		}
	}
	
	public void restore(IStateActivation stateActivation, ITransitionActivation enteringTransition, IEventOccurrence eventOccurrence){
		// Restore the state. Restoring a state consists in :
		// 1. Registering the state to the state-machine configuration
		// 2. Complete the state if needs to be completed
		// 3. If the state cannot be completed then execute its entry and its doActivity. Finally,
		//    if it has regions then these regions are restored (in parallel).
		State state = (State) stateActivation.getNode();
		stateActivation.setStatus(StateMetadata.ACTIVE);
		IStateMachineExecution smExecution = (IStateMachineExecution)this.getStateMachineExecution();
		smExecution.getConfiguration().register(stateActivation);
		stateActivation.setEntryCompletion(state.getEntry() == null);
		stateActivation.setDoActivityCompletion(state.getDoActivity() == null);
		stateActivation.setExitCompletion(state.getExit() == null);
		if(stateActivation.hasCompleted()){
			stateActivation.complete();
		}else{
			stateActivation.tryExecuteEntry(eventOccurrence);
			stateActivation.tryInvokeDoActivity(eventOccurrence);
			for(Iterator<IRegionActivation> regionActivationsIterator = stateActivation.getRegionActivation().iterator(); regionActivationsIterator.hasNext();){
				this.restore(regionActivationsIterator.next(), enteringTransition, eventOccurrence);
			}
		}
	}
	
	public abstract void restore(IRegionActivation regionActivation, ITransitionActivation enteringTransition, IEventOccurrence eventOccurrence);
	
}
