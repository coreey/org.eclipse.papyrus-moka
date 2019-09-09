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
 * pssm_state_machine_extends_at_most_one
 * 
 * A StateMachine must not have more than one extendedStateMachine.
 * context UML::StateMachines::StateMachine inv:
 * self.extendedStateMachine->size() <= 1
 */
public class PssmStateMachineExtendsAtMostOneConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		StateMachine stateMachine = (StateMachine) ctx.getTarget();
		Boolean expression = stateMachine.getExtendedStateMachines().size() <= 1;
		if (!expression) {
			return ctx.createFailureStatus("StateMachine - A StateMachine must not have more than one extendedStateMachine.");
		}
		return ctx.createSuccessStatus();
	}
}