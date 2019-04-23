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

public class ChoicePseudostateActivation extends ConditionalPseudostateActivation {
	
	@Override
	public boolean canPropagateExecution(ITransitionActivation enteringTransition, IEventOccurrence eventOccurrence, IRegionActivation leastCommonAncestor) {
		// When a choice pseudo-state activation is reached, the static analysis is propagated to parent
		// vertex if required. If the propagation to the parent returns true then it is also the result
		// of the propagation on the choice pseudo-state. In other word the propagation stops after the
		// pseudo-state activation is reached.
		boolean propagate = true;
		if(leastCommonAncestor != null){
			IRegionActivation parentRegionActivation = this.getOwningRegionActivation();
			if(leastCommonAncestor!=parentRegionActivation){
				VertexActivation vertexActivation = (VertexActivation) parentRegionActivation.getParent();
				if(vertexActivation != null){
					propagate = vertexActivation.canPropagateExecution(enteringTransition, eventOccurrence, leastCommonAncestor);
				}
			}
		}
		return propagate;
		
	}
	
	public void enter(ITransitionActivation enteringTransition, IEventOccurrence eventOccurrence, IRegionActivation leastCommonAncestor) {
		// When an choice pseudo-state is reached then guards placed are evaluated [dynamically] (i.e. at the time were
		// the entry) is performed. If more than a guard evaluates to true then the selected transition is selected using
		// using the first choice semantic strategy
		super.enter(enteringTransition, eventOccurrence, leastCommonAncestor);
		this.evaluateAllGuards(eventOccurrence);
		ITransitionActivation selectedTransition = null;
		if(this.fireableTransitions.size() > 0){
			if (this.fireableTransitions.size() == 1) {
				selectedTransition = this.fireableTransitions.get(0);
			} else{
				ChoiceStrategy strategy =  (ChoiceStrategy)this.getExecutionContext().getLocus().getFactory().getStrategy("choice");
				selectedTransition = this.fireableTransitions.get(strategy.choose(this.fireableTransitions.size()-1));
			}
			// Note: Force a static analysis from the selected (maybe compound) transition.
			// The rationale is that it forces evaluation of downstream guards.
			selectedTransition.canPropagateExecution(eventOccurrence);
			selectedTransition.fire(eventOccurrence);
		}
	}

}
