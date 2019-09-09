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
import org.eclipse.uml2.uml.State;

/**
 * pssm_state_has_no_invariant
 * 
 * A State must not have a stateInvariant.
 * context UML::StateMachines::State inv:
 * self.stateInvariant = null
 */
public class PssmStateHasNoInvariantConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		State state = (State) ctx.getTarget();
		Boolean expression = state.getStateInvariant() == null;
		if (!expression) {
			return ctx.createFailureStatus("State - A State must not have a stateInvariant.");
		}
		return ctx.createSuccessStatus();
	}
}