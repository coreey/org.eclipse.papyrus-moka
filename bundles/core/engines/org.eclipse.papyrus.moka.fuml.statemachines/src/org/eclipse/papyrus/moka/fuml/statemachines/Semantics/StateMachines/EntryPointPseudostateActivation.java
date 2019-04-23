/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
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
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1.ChoiceStrategy;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IRegionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IStateActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.ITransitionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IVertexActivation;

public class EntryPointPseudostateActivation extends ConnectionPointActivation {

	@Override
	public boolean isExitable(ITransitionActivation exitingTransition, boolean staticCheck) {
		// If the state on which is this pseudostate is placed is not orthogonal (i.e. at least
		// composed of two regions) then no constraints are placed on the triggering of it exit
		// sequence. Otherwise, the constraint is that the entry pseudostate can only be exited
		// when all of its outgoing transitions have been fired.
		int i = 0;
		boolean isExitable = true;
		IVertexActivation parentVertexActivation = this.getParentVertexActivation();
		if(parentVertexActivation != null && ((StateActivation)parentVertexActivation).regionActivation.size() > 1){
			while(isExitable && i < this.outgoingTransitionActivations.size()){
				ITransitionActivation transitionActivation = this.outgoingTransitionActivations.get(i);
				if(transitionActivation != exitingTransition){
					isExitable = transitionActivation.isTraversed(staticCheck);
				}
				i++;
			}
		}
		return isExitable;
	}
	
	@Override
	public boolean canPropagateExecution(ITransitionActivation enteringTransition, IEventOccurrence eventOccurrence, IRegionActivation leastCommonAncestor){
		// Static analysis is propagated to the parents. If the propagation is accepted, then all outgoing transitions
		// guards are evaluated. For the propagation to be accepted through this pseudo-state activation:
		// 
		// 1. If the parent state is orthogonal, all transitions must be fireable and all of them
		// must accept the propagation.
		// 
		// 2. If the parent state is not orthogonal, at least one of the transition must be able
		// to accept the propagation.
		boolean propagate = true;
		VertexActivation vertexActivation = this.getParentVertexActivation();
		if(vertexActivation != null){
			propagate = vertexActivation.canPropagateExecution(enteringTransition, eventOccurrence, leastCommonAncestor);
			if(this.isEnterable(enteringTransition, true) && this.outgoingTransitionActivations.size() > 0){
				this.evaluateAllGuards(eventOccurrence);
				if(((IStateActivation)vertexActivation).getRegionActivation().size() > 1){
					if(this.outgoingTransitionActivations.size() == this.fireableTransitions.size()){
						int i = 0;
						while(propagate && i < this.fireableTransitions.size()){
							propagate = this.fireableTransitions.get(i).canPropagateExecution(eventOccurrence);
							i++;
						}	
					}else{
						propagate = false;
					}
				}else{
					int i = 0;
					propagate = false;
					while(!propagate && i < this.fireableTransitions.size()){
						propagate = this.fireableTransitions.get(i).canPropagateExecution(eventOccurrence);
						i++;
					}
				}
			}
		}
		return propagate;
	}
	
	protected void _enter(ITransitionActivation enteringTransition, IEventOccurrence eventOccurrence, IRegionActivation leastCommonAncestor){
		// When an exit point is entered its owning state is entered. That state maybe located
		// in a nested hierarchy which is not already active. Hence if the hierarchy is not
		// already active then it is entered.
		super.enter(enteringTransition, eventOccurrence, null);
		IVertexActivation vertexActivation = this.getParentVertexActivation();
		if(vertexActivation!=null){
			vertexActivation.enter(enteringTransition, eventOccurrence, leastCommonAncestor);
		}
	}
	
	public void enter(ITransitionActivation enteringTransition, IEventOccurrence eventOccurrence, IRegionActivation leastCommonAncestor) {
		// Enter a state through an entry point. The state on which the entry point is
		// placed can be a deeply nested state. Therefore parent state of that state must
		// be entered before if it is not already the case. Next according to the orthogonality
		// of the parent StateActivation behave like a Fork or a Junction.
		this._enter(enteringTransition, eventOccurrence, leastCommonAncestor);
		VertexActivation parentVertexActivation = this.getParentVertexActivation();
		if(parentVertexActivation != null){
			if(((StateActivation)parentVertexActivation).regionActivation.size() > 1){
				// Behave like a Fork pseudostate - all outgoing transitions must fire concurrently 
				for(Iterator<ITransitionActivation> fireableTransitionsIterator = this.fireableTransitions.iterator(); fireableTransitionsIterator.hasNext();){
					fireableTransitionsIterator.next().fire(eventOccurrence);
				}
			}else{
				// Behave like a Junction pseudostate - on of the outgoing transition is chosen to be fired
				if(fireableTransitions.size() > 0){
					ITransitionActivation selectedTransitionActivation = null;
					if(this.fireableTransitions.size() == 1){
						selectedTransitionActivation = this.fireableTransitions.get(0);
					}else{
						ChoiceStrategy choiceStrategy = (ChoiceStrategy) this.getExecutionLocus().getFactory().getStrategy("choice");
						int chosenIndex = choiceStrategy.choose(this.fireableTransitions.size());
						selectedTransitionActivation = this.fireableTransitions.get(chosenIndex - 1);
					}
					selectedTransitionActivation.fire(eventOccurrence);
				}
			}
		}
	}
	
	@Override
	public void exit(ITransitionActivation exitingTransition, IEventOccurrence eventOccurrence, IRegionActivation leastCommonAncestor) {
		// When the entry point is exited it does not imply exiting parent state.
		// Only the entry point is exited and this has no effect on its parent state.
		super.exit(exitingTransition, eventOccurrence, null);
	}
}
