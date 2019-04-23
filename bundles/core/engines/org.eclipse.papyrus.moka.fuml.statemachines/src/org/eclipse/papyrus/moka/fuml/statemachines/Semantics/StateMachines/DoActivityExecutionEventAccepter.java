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
 *  Jeremie Tatibouet (CEA LIST) - Based on Ed Seidewitz remarks
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines;

import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications.EventAccepter;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IDoActivityContextObject;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;

public class DoActivityExecutionEventAccepter extends EventAccepter {

	// The doActivity context object in which this accepter is registered
	public IDoActivityContextObject context;
	
	// The actual event accepter (i.e., the one registered by the doActivity execution)
	public IEventAccepter encapsulatedAccepter;
	
	@Override
	public void accept(IEventOccurrence eventOccurrence) {
		// The event accepted through the state-machine event pool leads
		// to the triggering of a RTC step in the context of the doActivity.
		// As this needs to be realized the execution thread of the doActivity
		// the accepted event occurrence is registered at the event pool of the
		// DoActivityContextObjectActivation. This will trigger a new RTC step
		// that will effectively be realized in the DoActivityContextObject and
		// not in the State Machine context.
		this.context.getObjectActivation().getEvents().add(eventOccurrence);
		this.context.getObjectActivation().notifyEventArrival();
	}

	@Override
	public Boolean match(IEventOccurrence eventOccurrence) {
		// Simply delegates to the match operation of the encapsulated accepter.
		return this.encapsulatedAccepter.match(eventOccurrence);
	}

}
