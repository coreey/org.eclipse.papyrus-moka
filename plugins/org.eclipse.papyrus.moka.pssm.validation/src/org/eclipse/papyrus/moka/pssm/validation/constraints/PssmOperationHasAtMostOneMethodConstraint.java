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
import org.eclipse.uml2.uml.Operation;

/**
 * pssm_operation_has_at_most_one_method
 * 
 * If an Operation is abstract, it must have no method. Otherwise it must not have more than one method and it must have
 * exactly one method unless owned by an active Class.
 * context UML::Classification::Operation inv:
 * if self.isAbstract then self.method->isEmpty()
 * else
 * self.method->size() <= 1 and
 * ((self.class = null or not self.class.isActive) implies
 * self.method->size() = 1)
 * endif
 */
public class PssmOperationHasAtMostOneMethodConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		Operation operation = (Operation) ctx.getTarget();
		Boolean expression = false;
		if (operation.isAbstract()) {
			expression = operation.getMethods().isEmpty();
		} else {
			expression = operation.getMethods().size() <= 1;
			if (operation.getClass_() == null || !operation.getClass_().isActive()) {
				expression &= operation.getMethods().size() == 1;
			}
		}
		if (!expression) {
			return ctx.createFailureStatus(
					"Operation - If an Operation is abstract, it must have no method. Otherwise it must not have more than one method and it must have  exactly one method unless owned by an active Class.");
		}
		return ctx.createSuccessStatus();
	}
}