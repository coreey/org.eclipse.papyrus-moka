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
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.Class;

/**
 * fUML_active_context
 * 
 * The context of the containing activity of the accept event action must be an
 * active class.
 * self.context.oclAsType(Class).isActive
 */
public class FumlAcceptEventActionActiveContextConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		AcceptEventAction acceptEventAction = (AcceptEventAction) ctx.getTarget();
		boolean constraint = acceptEventAction.getContext() instanceof org.eclipse.uml2.uml.Class
				&& ((Class) acceptEventAction.getContext()).isActive();
		if (!constraint) {
			return ctx.createFailureStatus(
					"AcceptEventAction - The context of the containing activity of the accept event action must be an active class.");
		}
		return ctx.createSuccessStatus();
	}
}