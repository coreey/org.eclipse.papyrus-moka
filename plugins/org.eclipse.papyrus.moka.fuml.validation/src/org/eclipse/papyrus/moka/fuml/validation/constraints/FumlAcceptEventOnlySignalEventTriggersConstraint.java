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
package org.eclipse.papyrus.moka.fuml.validation.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.AcceptCallAction;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.Trigger;

/**
 * fUML_only_signal_event_triggers
 * 
 * Unless the action is an accept call action, all triggers must be for signal events.
 * not self.oclIsKindOf(AcceptCallAction) implies
 * self.trigger.event->forAll(oclIsKindOf(SignalEvent))
 */
public class FumlAcceptEventOnlySignalEventTriggersConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		AcceptEventAction acceptEventAction = (AcceptEventAction) ctx.getTarget();
		if (false == acceptEventAction instanceof AcceptCallAction) {
			for (Trigger trigger : acceptEventAction.getTriggers()) {
				if (false == trigger.getEvent() instanceof SignalEvent) {
					return ctx.createFailureStatus("AcceptEventAction - Unless the action is an accept call action, all triggers must be for signal events.");
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}