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
import org.eclipse.uml2.uml.StateMachine;

/**
 * pssm_state_machine_context
 * 
 * A StateMachine may not be a method and, if it has a context, it must be a classifierBehavior for that context.
 * context UML::StateMachines::StateMachine inv:
 * self.specification = null and
 * self._'context' <> null implies self._'context'.classifierBehavior = self
 */
public class PssmStateMachineContextConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		StateMachine stateMachine = (StateMachine) ctx.getTarget();
		Boolean expression = stateMachine.getSpecification() == null;
		if (stateMachine.getContext() != null) {
			expression &= stateMachine.getContext().getClassifierBehavior() == stateMachine;
		}
		if (!expression) {
			return ctx.createFailureStatus(
					"StateMachine - A StateMachine may not be a method and, if it has a context, it must be a classifierBehavior for that context.");
		}
		return ctx.createSuccessStatus();
	}
}