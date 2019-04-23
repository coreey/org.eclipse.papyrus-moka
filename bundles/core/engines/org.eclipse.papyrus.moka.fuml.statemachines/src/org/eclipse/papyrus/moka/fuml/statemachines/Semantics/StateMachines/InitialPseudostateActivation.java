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
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IRegionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.ITransitionActivation;

public class InitialPseudostateActivation extends PseudostateActivation{
	
	public void enter(ITransitionActivation enteringTransition, IEventOccurrence eventOccurrence, IRegionActivation leastCommonAncestor) {
		// If there is an outgoing transition then this outgoing transition is fired.
		// If there is a guard or a trigger associated with this initial pseudo state then
		// they are not taken into account. If there is no outgoing transitions then the model
		// is considered as being ill-formed, similar interpretation occurs if there are more than
		// an single outgoing transition for the initial pseudo state.
		super.enter(enteringTransition, eventOccurrence, null);
		if(this.outgoingTransitionActivations.size()==1){
			this.outgoingTransitionActivations.get(0).fire(eventOccurrence);	
		}
	}
}
