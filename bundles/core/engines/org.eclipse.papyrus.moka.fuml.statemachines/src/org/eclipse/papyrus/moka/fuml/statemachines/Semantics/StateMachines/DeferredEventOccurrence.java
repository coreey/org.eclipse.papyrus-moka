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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications.EventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.CommonBehavior.ISM_ObjectActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IDeferredEventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IStateActivation;
import org.eclipse.uml2.uml.Trigger;

public class DeferredEventOccurrence extends EventOccurrence implements IDeferredEventOccurrence {

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
		if (this.deferredEventOccurrence != null) {
			match = this.deferredEventOccurrence.match(trigger);
		}
		return match;
	}

	@Override
	public List<IParameterValue> getParameterValues() {
		// Delegate to the getParameterValues operation of the encapsulated event
		// occurrence which is the one being deferred.
		List<IParameterValue> parameterValues = new ArrayList<IParameterValue>();
		if (this.deferredEventOccurrence != null) {
			parameterValues = this.deferredEventOccurrence.getParameterValues();
		}
		return parameterValues;
	}

	public void register(IStateActivation stateActivation) {
		// Register this deferred event occurrence in the deffered
		// event pool of the context object.
		this.constrainingStateActivation = stateActivation;
		ISM_ObjectActivation objectActivation = (ISM_ObjectActivation) stateActivation
				.getExecutionContext().getObjectActivation();
		objectActivation.register(this);
	}

	@Override
	public void sendTo(IReference target) {
		// Do nothing - the deferred event is not sent to a target.
		// It is registered during the RTC step of the active object that
		// entered the state from which it was generated.
	}

	@Override
	public void doSend() {
		// Do nothing - the deferred event is not sent to a target.
		// It is registered during the RTC step of the active object that
		// entered the state from which it was generated.
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
