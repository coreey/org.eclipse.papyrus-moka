/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Jeremie Tatibouet (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IRegionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.ITransitionActivation;

public class FinalStateActivation extends StateActivation {

	public void enter(ITransitionActivation enteringTransition, IEventOccurrence eventOccurrence, IRegionActivation leastCommonAncestor) {
		// The final state completes the region in which it is located*/
		IRegionActivation regionActivation = this.getOwningRegionActivation();
		regionActivation.setCompleted(true);
		regionActivation.setHistory(null);
		// If this region is the last of this state to complete through its final
		// state then it leads to the generation of a completion event
		if(regionActivation.getParent() instanceof StateActivation){
			 StateActivation stateActivation = (StateActivation) regionActivation.getParent();
			 if(stateActivation.hasCompleted()){
				 stateActivation.complete();
			 }
		}
	}

}
