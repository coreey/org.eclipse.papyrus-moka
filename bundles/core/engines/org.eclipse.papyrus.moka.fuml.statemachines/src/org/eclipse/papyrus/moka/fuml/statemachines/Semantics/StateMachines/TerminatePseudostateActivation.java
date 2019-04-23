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

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IRegionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.ITransitionActivation;

public class TerminatePseudostateActivation extends PseudostateActivation {

	public void enter(ITransitionActivation enteringTransition, IEventOccurrence eventOccurrence, IRegionActivation leastCommonAncestor) {
		// When a terminate pseudo state is entered the state-machine executing terminates its execution.
		// This termination occurs without exiting "exit" behaviors of state(s) that are currently
		// registered in the state-machine configuration.
		// 
		// Note: the termination of the current state-machine execution leads
		// to the destruction of its context object. This means the object
		// will be stopped and consequently no any other event will be dispatched
		// and the object will finally be removed from the locus.
		super.enter(enteringTransition, eventOccurrence, leastCommonAncestor);
		IExecution stateMachineExecution = this.getStateMachineExecution();
		stateMachineExecution.terminate();
		stateMachineExecution.getContext().destroy();
		super.exit(null, null, null);
	}
}
