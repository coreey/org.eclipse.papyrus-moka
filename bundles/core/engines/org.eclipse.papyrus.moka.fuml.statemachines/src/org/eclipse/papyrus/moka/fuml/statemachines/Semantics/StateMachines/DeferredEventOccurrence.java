/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications.EventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IDeferredEventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IStateActivation;
import org.eclipse.uml2.uml.Trigger;

public class DeferredEventOccurrence extends EventOccurrence implements IDeferredEventOccurrence{
	
	// The state activation that was constraint the event occurrence 
	// to remain deferred.
	public IStateActivation constrainingStateActivation;
	
	// The event occurrence that is actually deferred
	public IEventOccurrence deferredEventOccurrence;

	@Override
	public boolean match(Trigger trigger) {
		// Delegate to the match operation of the encapsulated event
		// occurrence which is the one being deferred.
		boolean match = false;
		if(this.deferredEventOccurrence != null){
			match = this.deferredEventOccurrence.match(trigger);
		}
		return match;
	}
	
	@Override
	public List<IParameterValue> getParameterValues() {
		// Delegate to the getParameterValues operation of the encapsulated event
		// occurrence which is the one being deferred.
		List<IParameterValue> parameterValues = new ArrayList<IParameterValue>();
		if(this.deferredEventOccurrence != null){
			parameterValues = this.deferredEventOccurrence.getParameterValues();
		}
		return parameterValues;
	}
	
	@Override
	public IStateActivation getConstrainingStateActivation() {
		return this.constrainingStateActivation;
	}

	@Override
	public void setConstrainingStateActivation(IStateActivation constrainingState) {
		this.constrainingStateActivation = constrainingState;
	}

	@Override
	public IEventOccurrence getDeferredEventOccurrence() {
		return this.deferredEventOccurrence;
	}

	@Override
	public void setDeferredEventOccurrence(IEventOccurrence deferredEvent) {
		this.deferredEventOccurrence = deferredEvent;
	}

}
