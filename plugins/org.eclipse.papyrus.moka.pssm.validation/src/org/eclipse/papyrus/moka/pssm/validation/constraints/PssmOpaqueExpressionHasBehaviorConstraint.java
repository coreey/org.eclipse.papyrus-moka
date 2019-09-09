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
import org.eclipse.uml2.uml.OpaqueExpression;

/**
 * pssm_opaque_expression_has_behavior
 * 
 * The OpaqueExpression must have a behavior.
 * context UML::Values::OpaqueExpression inv:
 * self.behavior <> null
 */
public class PssmOpaqueExpressionHasBehaviorConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		OpaqueExpression opaqueExpression = (OpaqueExpression) ctx.getTarget();
		Boolean expression = opaqueExpression.getBehavior() != null;
		if (!expression) {
			return ctx.createFailureStatus("OpaqueExpression - The OpaqueExpression must have a behavior.");
		}
		return ctx.createSuccessStatus();
	}
}