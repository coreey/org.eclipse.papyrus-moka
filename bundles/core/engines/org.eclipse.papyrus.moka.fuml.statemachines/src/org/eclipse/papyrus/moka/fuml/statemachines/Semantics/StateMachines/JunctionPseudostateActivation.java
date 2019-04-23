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

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1.ChoiceStrategy;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IRegionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.ITransitionActivation;

public class JunctionPseudostateActivation extends ConditionalPseudostateActivation{
	
	@Override
	public void enter(ITransitionActivation enteringTransition, IEventOccurrence eventOccurrence, IRegionActivation leastCommonAncestor) {
		// When entered the junction pseudo-state the set of fireable transition (calculated during static
		// analysis) is used to determine which transition will actually be fired. The transition selected
		// to be fired is determined using the choice semantic strategy.
		super.enter(enteringTransition, eventOccurrence, leastCommonAncestor);
		ITransitionActivation selectedTransition = null;
		if(this.fireableTransitions.size() == 1){
			selectedTransition = this.fireableTransitions.get(0);
		}else{
			ChoiceStrategy choiceStrategy = (ChoiceStrategy) this.getExecutionLocus().getFactory().getStrategy("choice");
			int index = choiceStrategy.choose(this.fireableTransitions.size()) - 1;
			selectedTransition = this.fireableTransitions.get(index);
		}
		if(selectedTransition != null){
			selectedTransition.fire(eventOccurrence);
		}
	}
	
}
