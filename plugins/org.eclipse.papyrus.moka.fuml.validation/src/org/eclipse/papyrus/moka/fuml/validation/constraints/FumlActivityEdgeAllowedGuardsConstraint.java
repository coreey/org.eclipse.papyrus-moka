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
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.LiteralBoolean;

/**
 * fUML_allowed_guards
 * 
 * A guard is only allowed if the source of the edge is a DecisionNode.
 * self.guard->notEmpty() implies self.source.oclIsKindOf(DecisionNode)
 */
public class FumlActivityEdgeAllowedGuardsConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		ActivityEdge activityEdge = (ActivityEdge) ctx.getTarget();
		if (activityEdge.getGuard() != null) {
			// by default papyrus add a guard which is a literalBoolean equals to true, this
			// case must not be detected
			if(activityEdge.getGuard() instanceof LiteralBoolean && ((LiteralBoolean)activityEdge.getGuard()).booleanValue()) {
				return ctx.createSuccessStatus();
			}
			
			if (false == activityEdge.getSource() instanceof DecisionNode) {
				return ctx.createFailureStatus(
						"ActivityEdge - A guard is only allowed if the source of the edge is a DecisionNode.");
			}
		}
		return ctx.createSuccessStatus();
	}
}