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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.Transition;

/**
 * pssm_transition_triggers
 * 
 * The triggers of a Transition must all be for CallEvents or SignalEvents.
 * context UML::StateMachines::Transition inv:
 * self.trigger.event->forAll(
 * oclIsKindOf(UML::CommonBehavior::CallEvent) or
 * oclIsKindOf(UML::CommonBehavior::SignalEvent)
 * )
 */
public class PssmTransitionTriggersConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		Transition transition = (Transition) ctx.getTarget();
		Boolean expression = transition.getTriggers().stream()
				.allMatch(t -> t.getEvent() instanceof CallEvent || t.getEvent() instanceof SignalEvent);
		if (!expression) {
			return ctx.createFailureStatus(
					"Transition - The triggers of a Transition must all be for CallEvents or SignalEvents.");
		}
		return ctx.createSuccessStatus();
	}
}