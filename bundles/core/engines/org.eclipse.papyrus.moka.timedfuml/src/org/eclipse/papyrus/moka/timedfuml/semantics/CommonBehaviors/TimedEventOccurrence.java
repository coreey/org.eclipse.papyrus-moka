/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.timedfuml.semantics.CommonBehaviors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IEvaluation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IRealValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.RealValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications.EventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.Values.ISM_OpaqueExpressionEvaluation;
import org.eclipse.papyrus.moka.timedfuml.interfaces.semantics.CommonBehaviors.ITimedEventOccurrence;
import org.eclipse.papyrus.moka.timedfuml.interfaces.semantics.CommonBehaviors.ITimedObjectActivation;
import org.eclipse.uml2.uml.TimeEvent;
import org.eclipse.uml2.uml.Trigger;

public class TimedEventOccurrence extends EventOccurrence implements ITimedEventOccurrence {

	// Time at which the clock accounted for the future
	// time event occurrence
	public IRealValue referenceInstant;

	// Instant of time at which this event occurrence
	// was generated
	public IRealValue occurrenceInstant;

	@Override
	public boolean match(Trigger trigger) {
		// Define the rule to match this event occurrence against a trigger
		// This event occurrence matches if the following condition hold:
		// 1] If the trigger is for a TimeEvent
		// 2] If the time expression can be evaluated
		// 3] If the occurrence instant (i.e., the time at which this occurrence
		// occurred) matches the time at which the model element referencing the
		// trigger was expected to fire. Note that the triggering time can either
		// relative or absolute.
		boolean matches = false;
		if (trigger.getEvent() instanceof TimeEvent) {
			TimeEvent timeEvent = (TimeEvent) trigger.getEvent();
			if (timeEvent.getWhen() != null && timeEvent.getWhen().getExpr() != null) {
				IEvaluation evaluation = this.target.getReferent().getLocus().getFactory()
						.createEvaluation(timeEvent.getWhen().getExpr());
				if (evaluation != null) {
					if (evaluation instanceof ISM_OpaqueExpressionEvaluation) {
						((ISM_OpaqueExpressionEvaluation) evaluation).setContext(this.target.getReferent());
					}
					IRealValue evaluatedInstant = (IRealValue) evaluation.evaluate();
					if (timeEvent.isRelative()) {
						matches = this.referenceInstant.getValue()
								+ evaluatedInstant.getValue() == this.occurrenceInstant.getValue();
					} else {
						matches = this.occurrenceInstant.equals(evaluatedInstant);
					}
				}
			}
		}
		return matches;
	}

	@Override
	public List<IParameterValue> getParameterValues() {
		// Return a single parameter value. This latter provides the time
		// at which this event occurrence occurred.
		List<IParameterValue> parameterValues = new ArrayList<IParameterValue>();
		IParameterValue parameterValue = new ParameterValue();
		List<IValue> values = new ArrayList<IValue>();
		values.add(this.occurrenceInstant);
		parameterValue.setValues(values);
		parameterValues.add(parameterValue);
		return parameterValues;
	}

	@Override
	public void sendTo(IReference target) {
		// Do nothing - the timed event is not sent to a target.
		// It is registered by an external clock into the event pool
		// of the active object.
	}

	@Override
	public void doSend() {
		// Do nothing - the timed event is not sent to a target.
		// It is registered by an external clock into the event pool
		// of the active object.
	}

	@Override
	public void _startObjectBehavior() {
		// Do nothing - the classifier behavior of that object is empty
	}

	public void register() {
		// Register this time event occurrence in the event
		// pool of the target object.
		ITimedObjectActivation objectActivation = (ITimedObjectActivation) this.target.getReferent()
				.getObjectActivation();
		if(objectActivation != null) {
			objectActivation.register(this);
		}
	}

	@Override
	public void setReferenceInstant(double instant) {
		// Set the reference time at which the production of this
		// event occurrence was scheduled
		if (this.referenceInstant == null) {
			this.referenceInstant = new RealValue();
		}
		this.referenceInstant.setValue(instant);
	}

	@Override
	public IRealValue getReferenceInstance() {
		// Return the reference time (can be null)
		return this.referenceInstant;
	}

	@Override
	public void setOccurrenceInstant(double instant) {
		// Set the time at which this event occurrence actually
		// occurred.
		if (this.occurrenceInstant == null) {
			this.occurrenceInstant = new RealValue();
		}
		this.occurrenceInstant.setValue(instant);
	}

	@Override
	public IRealValue getOccurrenceInstant() {
		// Return the time at which the occurrence occurred (can be null).
		return this.occurrenceInstant;
	}

}
