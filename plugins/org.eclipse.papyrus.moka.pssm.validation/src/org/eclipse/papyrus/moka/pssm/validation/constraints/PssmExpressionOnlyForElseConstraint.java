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
import org.eclipse.uml2.uml.Expression;

/**
 * pssm_expression_only_for_else
 * 
 * The Expression must have no operands and its symbol must be “else”.
 * context UML::Values::Expression inv:
 * self.symbol = 'else' and self.operand->isEmpty()
 */
public class PssmExpressionOnlyForElseConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		Expression target = (Expression) ctx.getTarget();
		Boolean expression = target.getSymbol().equals("else") 
				&& target.getOperands().isEmpty();
		if (!expression) {
			return ctx.createFailureStatus("Expression - The Expression must have no operands and its symbol must be “else”.");
		}
		return ctx.createSuccessStatus();
	}
}