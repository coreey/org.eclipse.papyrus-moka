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

import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;

/**
 * pssm_transition_call_event_operations
 * 
 * The Operations of any CallEvents on the triggers of a Transition must be owned or inherited by the context of the
 * containing StateMachine.
 * context UML::StateMachines::Transition inv:
 * let stateMachine = self.containingStateMachine() in
 * let context_ =
 * if stateMachine._'context' = null then stateMachine
 * else stateMachine._'context'
 * endif in
 * context_.allFeatures()->includesAll(
 * self.trigger->select(oclIsKindOf(UML::CommonBehavior::CallEvent)).
 * oclAsType(UML::CommonBehavior::CallEvent).operation
 * )
 */
public class PssmTransitionCallEventOperationsConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		Transition transition = (Transition) ctx.getTarget();
		StateMachine stateMachine = transition.containingStateMachine();
		BehavioredClassifier context = stateMachine.getContext();
		if (context == null) {
			context = stateMachine;
		}
		Boolean expression = context.allFeatures().containsAll(
				transition.getTriggers().stream()
						.map(t -> t.getEvent()) // get all events (referenced by triggers)
						.filter(e -> e instanceof CallEvent)
						.map(CallEvent.class::cast) // keep only callEvent
						.map(ce -> ce.getOperation()) // extract operations from all callEvent
						.collect(Collectors.toList()));
		if (!expression) {
			return ctx.createFailureStatus(
					"Transition - The Operations of any CallEvents on the triggers of a Transition must be owned or inherited by the context of the  containing StateMachine.");
		}
		return ctx.createSuccessStatus();
	}
}