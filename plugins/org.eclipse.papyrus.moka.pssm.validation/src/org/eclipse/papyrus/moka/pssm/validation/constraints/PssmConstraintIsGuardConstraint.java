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
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Transition;

/**
 * pssm_constraint_is_guard
 * 
 * A Constraint must be owned as a guard by a Transition and its constrainedElements must be empty.
 * 
 * context UML::CommonStructure::Constraint inv:
 * self.owner.oclIsKindOf(UML::StateMachines::Transition) and
 * self.constrainedElement->isEmpty()
 * 
 * TODO seems strange there is no verification that the constraint is used as a guard of a transition
 */
public class PssmConstraintIsGuardConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		Constraint constraint = (Constraint) ctx.getTarget();
		Boolean expression = constraint.getOwner() instanceof Transition
				&& constraint.getConstrainedElements().isEmpty();
		if (!expression) {
			return ctx.createFailureStatus("Constraint - A Constraint must be owned as a guard by a Transition and its constrainedElements must be empty.");
		}
		return ctx.createSuccessStatus();
	}
}