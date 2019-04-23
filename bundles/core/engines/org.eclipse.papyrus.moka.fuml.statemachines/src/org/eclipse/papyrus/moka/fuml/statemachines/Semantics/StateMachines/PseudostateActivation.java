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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IPseudostateActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IRegionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.ITransitionActivation;

public abstract class PseudostateActivation extends VertexActivation implements IPseudostateActivation{
	
	// Transitions that were fireable at the time which the pseudo-state was evaluated.
	protected List<ITransitionActivation> fireableTransitions;
	
	public PseudostateActivation(){
		this.fireableTransitions = new ArrayList<ITransitionActivation>();
	}
	
	public void evaluateAllGuards(IEventOccurrence eventOccurrence){
		// Evaluate all guards of outgoing transitions of the pseudo-state.
		// Guard evaluation populate the set of fireable transitions with
		// transitions whith guard evaluating to true. Not that this evaluation
		// is not done at the time the where this pseudo-state is entered. Instead
		// it is done statically when the compound transition leading to this
		// pseudo-state is evaluated.
		this.fireableTransitions.clear();
		for(int i=0; i < this.outgoingTransitionActivations.size(); i++){
			ITransitionActivation transitionActivation = this.outgoingTransitionActivations.get(i);
			if(transitionActivation.evaluateGuard(eventOccurrence)){
				this.fireableTransitions.add(transitionActivation);
			}
		}
	}
	
	
	public boolean canPropagateExecution(ITransitionActivation enteringTransition, IEventOccurrence eventOccurrence, IRegionActivation leastCommonAncestor) {
		// Static analysis is propagated to the parent vertex. If the parent accepts the propagation and the
		// pseudo-state can be entered then it  must be possible to propagate the execution through at least
		// one of the outgoing transitions of the pseudo-state. If it is not possible false is returned. Not that
		// in case where the pseudo-state cannot be entered true is returned.
		boolean propagate = super.canPropagateExecution(enteringTransition, eventOccurrence, leastCommonAncestor);
		if(propagate && this.isEnterable(enteringTransition, true)){
			if(this.outgoingTransitionActivations.size() > 0){
				this.evaluateAllGuards(eventOccurrence);
				propagate = false;
				if(this.fireableTransitions.size() > 0){
					int i = 0;
					while(!propagate && i < this.fireableTransitions.size()){
						propagate = this.fireableTransitions.get(i).canPropagateExecution(eventOccurrence);
						i++;
					}
				}
			}
		}
		return propagate;
	}
	
}
