/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Sahar Guermazi
 *  CEA LIST Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.timedfuml.semantics;

import java.util.List;

import org.eclipse.papyrus.moka.discreteevent.DEScheduler;
import org.eclipse.papyrus.moka.discreteevent.Event;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IEvaluation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IRealValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.CompleteActions.AcceptEventActionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.Values.ISM_OpaqueExpressionEvaluation;
import org.eclipse.papyrus.moka.timedfuml.actions._sendAcceptEventOfferAction;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.TimeEvent;
import org.eclipse.uml2.uml.Trigger;

public class Timed_AcceptEventActionActivation extends AcceptEventActionActivation {

	public Timed_AcceptEventActionActivation() {
		super();
	}

	@Override
	public void fire(List<IToken> incomingTokens) {
		// Register an event in the DEScheduler (clock manager) and suspend this action.
		// Note: UML 2.5 does not put any restrictions on the number of triggers with a
		// time event that may be referenced by a single accept event action.
		double relativeDate = 0;
		double absoluteDate = 0;
		double currentTime = 0;
		for (Trigger trigger : ((AcceptEventAction) node).getTriggers()) {
			if (trigger.getEvent() instanceof TimeEvent) {
				boolean isMissed = false;
				TimeEvent timeEvent = (TimeEvent) trigger.getEvent();
				IEvaluation evaluation = null;
				if (timeEvent.getWhen() != null && timeEvent.getWhen().getExpr() != null) {
					evaluation = this.getExecutionLocus().getFactory().createEvaluation(timeEvent.getWhen().getExpr());
					if(evaluation instanceof ISM_OpaqueExpressionEvaluation){
						((ISM_OpaqueExpressionEvaluation)evaluation).setContext(this.getExecutionContext()) ;
					}
					if (timeEvent.isRelative()) {
						relativeDate = ((IRealValue) evaluation.evaluate()).getValue();
					} else {
						absoluteDate = ((IRealValue) evaluation.evaluate()).getValue();
						currentTime = DEScheduler.getInstance().getCurrentTime();
						if (absoluteDate < currentTime) {
							isMissed = true;
							System.err.println("Time Event is missed, absoluteTime = " + absoluteDate + " > currentTime = "
									+ currentTime);
						} else {
							relativeDate = absoluteDate - currentTime;
						}
					}
					if (!isMissed) {
						_sendAcceptEventOfferAction sendOfferAction = new _sendAcceptEventOfferAction(this);
						DEScheduler.getInstance().pushEvent(new Event(relativeDate, sendOfferAction));
						this.waiting = true;
						this.firing = false;
						this.suspend();
					}
				}
			}
		}
	}

	@Override
	public void accept(IEventOccurrence eventOccurrence) {
		// There is no acceptance of "time event occurrence". The accepted event
		// occurrence
		// will always be null at this point.
		this.sendOffers();
		this.waiting = false;
		this.receiveOffer();
		this.resume();
	}
}
