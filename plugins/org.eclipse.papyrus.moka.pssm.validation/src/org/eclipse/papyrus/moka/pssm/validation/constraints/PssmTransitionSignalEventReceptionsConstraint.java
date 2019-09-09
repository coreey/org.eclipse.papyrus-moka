/*****************************************************************************
 * Copyright (c) 2019 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier:EPL-2.0 
 *
 * Contributors:
 *  Pauline DEVILLE (CEA LIST) pauline.deville@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.pssm.validation.constraints;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;

/**
 * pssm_transition_signal_event_receptions
 * 
 * The Signals of any SignalEvents on the triggers of a Transition must have matching Receptions that are owned or
 * inherited by the context of the containing StateMachine of the Transition.
 * 
 * context UML::StateMachines::Transition inv:
 * let stateMachine = self.containingStateMachine() in
 * let context_ =
 * if stateMachine._'context' = null then stateMachine
 * else stateMachine._'context'
 * endif in
 * context_.allFeatures()->select(oclIsKindOf(UML::SimpleClassifiers::Reception)).
 * oclAsType(UML::SimpleClassifiers::Reception).signal->includesAll(
 * self.trigger->select(oclIsKindOf(UML::CommonBehavior::SignalEvent)).
 * oclAsType(UML::CommonBehavior::SignalEvent).signal
 * )
 */
public class PssmTransitionSignalEventReceptionsConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		Transition transition = (Transition) ctx.getTarget();
		StateMachine stateMachine = transition.containingStateMachine();
		BehavioredClassifier context = stateMachine.getContext();
		if (context == null) {
			context = stateMachine;
		}
		// create a list with all signal of reception present in the allFeature feature
		List<Signal> receptionSignals = context.allFeatures().stream()
				.filter(f -> f instanceof Reception)
				.map(Reception.class::cast)
				.map(r -> r.getSignal())
				.collect(Collectors.toList());
		// create a list with all signal of signalEvent of triggers
		List<Signal> triggersSignals = transition.getTriggers().stream()
				.map(t -> t.getEvent())
				.filter(e -> e instanceof SignalEvent)
				.map(SignalEvent.class::cast)
				.map(se -> se.getSignal())
				.collect(Collectors.toList());
		Boolean expression = receptionSignals.containsAll(triggersSignals);
		if (!expression) {
			return ctx.createFailureStatus(
					"Transition - The Signals of any SignalEvents on the triggers of a Transition must have matching Receptions that are owned or  inherited by the context of the containing StateMachine of the Transition.");
		}
		return ctx.createSuccessStatus();
	}
}