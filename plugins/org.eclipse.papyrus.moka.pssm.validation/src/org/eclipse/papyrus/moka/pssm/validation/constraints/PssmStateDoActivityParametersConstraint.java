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
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.State;

/**
 * pssm_state_do_activity_parameters
 * 
 * A doActivity Behavior of a State can only have in parameters.
 * context UML::StateMachines::State inv:
 * self.doActivity <> null implies
 * self.doActivity.ownedParameter->forAll(direction =
 * ParameterDirectionKind::_'in')
 */
public class PssmStateDoActivityParametersConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		State state = (State) ctx.getTarget();
		Boolean expression = true;
		if(state.getDoActivity() != null) {
			expression = state.getDoActivity().getOwnedParameters().stream()
			.allMatch(p -> p.getDirection().equals(ParameterDirectionKind.IN_LITERAL));
		}
		if (!expression) {
			return ctx.createFailureStatus(
					"State - A doActivity Behavior of a State can only have in parameters.");
		}
		return ctx.createSuccessStatus();
	}
}