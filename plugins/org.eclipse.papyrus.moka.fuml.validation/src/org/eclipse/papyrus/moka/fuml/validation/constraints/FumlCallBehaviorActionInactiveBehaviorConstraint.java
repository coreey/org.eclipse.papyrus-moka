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
import org.eclipse.uml2.uml.CallBehaviorAction;

/**
 * inactive_behavior
 * 
 * The behavior may not be active.
 * not self.behavior.isActive
 */
public class FumlCallBehaviorActionInactiveBehaviorConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		CallBehaviorAction callBehaviorAction = (CallBehaviorAction) ctx.getTarget();
		if (callBehaviorAction.getBehavior() != null) {
			if (callBehaviorAction.getBehavior().isActive()) {
				return ctx.createFailureStatus("CallBehaviorAction - The behavior may not be active.");
			}
		}
		return ctx.createSuccessStatus();
	}
}