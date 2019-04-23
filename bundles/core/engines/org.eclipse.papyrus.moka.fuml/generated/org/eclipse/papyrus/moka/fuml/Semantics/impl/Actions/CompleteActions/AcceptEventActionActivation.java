/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
 *  CEA LIST - Initial API and implementation
 *  Jeremie TATIBOUET (CEA LIST) - Animation refactoring and improvements
 *  Jeremie Tatibouet (CEA LIST) - Apply fix for Issue FUML12-20 Feature values need to be created for private structural features of parent classifiers
 *  Jeremie Tatibouet (CEA LIST) - Apply fix for Issue FUML12-10 certain boolean flags are not properly initialized in come cases 
 *  Jeremie Tatibouet (CEA LIST) - Apply fix for Issue FUML12-34 AcceptEventActionActivation::match should match instances of descendants of a trigger's signal
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.CompleteActions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Actions.CompleteActions.IAcceptEventActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.CompleteActions.IAcceptEventActionEventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivationGroup;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ISignalInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications.SignalEventOccurrence;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.OutputPin;

public class AcceptEventActionActivation extends ActionActivation implements IAcceptEventActionActivation {

	/*
	 * If the accept event action activation is waiting for an event, then this
	 * is the accepter it has registered for the event.
	 */
	public IAcceptEventActionEventAccepter eventAccepter;

	public Boolean waiting;

	@Override
	public void run() {
		// Create an event accepter and initialize waiting to false.
		super.run();
		this.eventAccepter = new AcceptEventActionEventAccepter();
		this.eventAccepter.setAcceptEventActionActivation(this);
		this.waiting = false;
	}

	public void initialize(ActivityNode node, IActivityNodeActivationGroup group) {
		// Initialize this accept event action activation to be not waiting for an event.

		// FUML12-10 certain boolean flags are not properly initialized in come cases

		super.initialize(node, group);
		this.waiting = false;
	}

	@Override
	public void fire(List<IToken> incomingTokens) {
		// Register the event accepter for this accept event action activation
		// with the context object of the enclosing activity execution
		// and wait for an event to be accepted.
		Debug.println("[fire] Action " + this.node.getName() + "...");
		this.getExecutionContext().register(this.eventAccepter);
		this.waiting = true;
		this.firing = false;
		this.suspend();
	}

	@Override
	public Boolean isReady() {
		// An accept event action activiation is ready to fire only if it is not
		// already waiting for an event.
		boolean ready;
		if (this.isWaiting()) { // CHANGED "this.waiting" to "this.isWaiting()".
			ready = false;
		} else {
			ready = super.isReady();
		}
		return ready;
	}

	// ADDED:
	public Boolean isWaiting() {
		return this.waiting == null ? false : this.waiting;
	}

	//

	@Override
	public void doAction() {
		// Do nothing. [This will never be called.]
		return;
	}

	public void accept(IEventOccurrence eventOccurrence) {
		// Accept the given event occurrence.
		// If the action does not unmarshall, then, if the event occurrence is
		// a signal event occurrence, place the signal instance of the signal
		// event occurrence on the result pin, if any.
		// If the action does unmarshall, then get the parameter values of the
		// event occurrence, and place the values for each parameter on the
		// corresponding output pin.
		// Concurrently fire all output pins while offering a single control
		// token.
		// If there are no incoming edges, then re-register this accept event
		// action execution with the context object.
		AcceptEventAction action = (AcceptEventAction) (this.node);
		List<OutputPin> resultPins = action.getResults();
		if (this.running) {
			if (!action.isUnmarshall()) {
				if (eventOccurrence instanceof SignalEventOccurrence) {
					ISignalInstance signalInstance = ((SignalEventOccurrence)eventOccurrence).signalInstance;
					List<IValue> result = new ArrayList<IValue>();
					result.add(signalInstance);
					if (resultPins.size() > 0) {
						this.putTokens(resultPins.get(0), result);
					}
				}
			} else {
				List<IParameterValue> parameterValues = eventOccurrence.getParameterValues();
				for (int i = 0; i < parameterValues.size(); i++) {
					IParameterValue parameterValue = parameterValues.get(i);
					OutputPin resultPin = resultPins.get(i);
					this.putTokens(resultPin, parameterValue.getValues());
				}
			}
			this.sendOffers();
			this.waiting = false;
			this.receiveOffer();
			this.resume();
		}
	}

	public Boolean match(IEventOccurrence eventOccurrence) {
		// Return true if the given event occurrence matches a trigger of the
		// accept event action of this activation.
		AcceptEventAction action = (AcceptEventAction) (this.node);
		return eventOccurrence.matchAny(action.getTriggers());
	}

	@Override
	public void terminate() {
		// Terminate this action and unregister its event accepter.
		super.terminate();
		if (this.isWaiting()) { // CHANGED "this.waiting" to "this.isWaiting()".
			this.getExecutionContext().unregister(this.eventAccepter);
			this.waiting = false;
		}
	}

	public IAcceptEventActionEventAccepter getEventAccepter() {
		return this.eventAccepter;
	}

}
