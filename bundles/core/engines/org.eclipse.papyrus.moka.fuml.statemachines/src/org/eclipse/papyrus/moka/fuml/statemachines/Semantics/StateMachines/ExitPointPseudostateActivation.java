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

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1.ChoiceStrategy;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IRegionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.ITransitionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.TransitionMetadata;

public class ExitPointPseudostateActivation extends ConnectionPointActivation {

	@Override
	public boolean isEnterable(ITransitionActivation enteringTransition, boolean staticCheck) {
		// Determine if this exit point satisfied its requirement to be exited.
		// The requirement is: all incoming transitions must have been fired once
		// if they originate from sub-states located in orthogonal regions
		int i = 0;
		boolean isReady = super.isEnterable(enteringTransition, staticCheck);
		while (isReady && i < this.incomingTransitionActivations.size()) {
			ITransitionActivation transitionActivation = this.incomingTransitionActivations.get(i);
			if(enteringTransition!=transitionActivation){
				isReady = transitionActivation.isTraversed(staticCheck);
			}
			i++;
		}
		return isReady;
	}

	@Override
	public boolean canPropagateExecution(ITransitionActivation enteringTransition, IEventOccurrence eventOccurrence, IRegionActivation leastCommonAncestor) {
		// If the exit point cannot be entered (see isEnterable(...) operation) then the propagation returns true.
		// If the exit poitn can be entered guards of its outgoing transitions are evaluated. Among the set of
		// fireable transitions, at least one of them must be able to accept the propagation.
		enteringTransition.setAnalyticalStatus(TransitionMetadata.TRAVERSED);
		boolean propagate = true;
		if(this.isEnterable(enteringTransition, true)){
			this.evaluateAllGuards(eventOccurrence);
			if(this.outgoingTransitionActivations.size() > 0){
				propagate = false;
				if(this.fireableTransitions.size() > 0){
					int i = 0;
					while(!propagate && i < this.fireableTransitions.size()){
						propagate = this.fireableTransitions.get(i).canPropagateExecution(eventOccurrence);
						i++;
					}	
				}
			}
			this.tagIncomingTransitions(TransitionMetadata.NONE, true);
		}
		return propagate;
	}
	
	public void enter(ITransitionActivation enteringTransition, IEventOccurrence eventOccurrence, IRegionActivation leastCommonAncestor) {
		// When the ExitPoint is entered then the state on which it is placed is exited.
		// One outgoing transition is chosen non-deterministically in set of transition
		// that can be used to leave the ExitPoint. This transition is fired.
		if (this.fireableTransitions.size() > 0) {
			ITransitionActivation selectedTransitionActivation = null;
			if (this.fireableTransitions.size() == 1) {
				selectedTransitionActivation = this.fireableTransitions.get(0);
			}else{
				ChoiceStrategy choiceStrategy = (ChoiceStrategy) this.getExecutionLocus().getFactory().getStrategy("choice");
				int chosenIndex = choiceStrategy.choose(this.fireableTransitions.size());
				selectedTransitionActivation = this.fireableTransitions.get(chosenIndex - 1);
			}
			// When the exit point is entered that does not imply recursive entry of its parent
			super.enter(enteringTransition, eventOccurrence, null);
			VertexActivation vertexActivation = this.getParentVertexActivation();
			if (vertexActivation != null) {
				// Only the state that owns the exit point is exited.
				vertexActivation.exit(enteringTransition, eventOccurrence, null);
			}
			selectedTransitionActivation.fire(eventOccurrence);
		}
	}
	
}
