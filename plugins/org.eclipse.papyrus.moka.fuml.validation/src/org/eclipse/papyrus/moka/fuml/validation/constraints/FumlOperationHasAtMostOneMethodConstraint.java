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
import org.eclipse.uml2.uml.Operation;

/**
 * zero_or_one_method
 * 
 * If an operation is abstract it must have no method. Otherwise it must have
 * exactly one method.
 * (self.isAbstract and self.method->isEmpty()) xor (not self.isAbstract and self.method->size() = 1)
 */
public class FumlOperationHasAtMostOneMethodConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		Operation operation = (Operation) ctx.getTarget();
		boolean failure = false;
		if (operation.isAbstract()) {
			if (!operation.getMethods().isEmpty()) {
				failure = true;
			}
		} else {
			if (operation.getMethods().size() != 1) {
				failure = true;
			}
		}
		if (failure) {
			return ctx.createFailureStatus("Operation - If an operation is abstract it must have no method. Otherwise it must have exactly one method. ");
		}
		return ctx.createSuccessStatus();
	}
}