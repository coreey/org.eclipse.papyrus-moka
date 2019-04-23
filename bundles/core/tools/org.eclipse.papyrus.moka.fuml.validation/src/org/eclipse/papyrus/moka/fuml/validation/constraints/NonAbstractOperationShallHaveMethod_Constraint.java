/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.validation.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Stereotype;

/**
 * This class is introduced to check the following constraints:
 * A non-abstract operation shall have a method
 * See 439646: [Moka] [Validation] A non-abstract operation shall have a method https://bugs.eclipse.org/bugs/show_bug.cgi?id=439646
 *
 */
public class NonAbstractOperationShallHaveMethod_Constraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		Operation operation = (Operation) ctx.getTarget();
		if (operation.getMethods().isEmpty()) {
			// if it is empty, need to check that the operation is not a constructor,
			// because PSCS defines semantics for invocation of constructor operations without
			// methods
			for (Stereotype applied : operation.getAppliedStereotypes()) {
				if (applied.getName().equals("Create")) {
					return ctx.createSuccessStatus();
				}
			}
			return ctx.createFailureStatus("A non-abstract Operation shall have a method");
		}
		return ctx.createSuccessStatus();
	}

}
