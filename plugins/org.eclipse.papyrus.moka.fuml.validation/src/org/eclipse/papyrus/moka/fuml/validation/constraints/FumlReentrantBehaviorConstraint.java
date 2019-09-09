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
import org.eclipse.uml2.uml.Behavior;

/**
 * fUML_reentrant_behavior
 * 
 * In this specification, a fUML instance model must have Behavior.isReentrant.
 * self.isReentrant
 */
public class FumlReentrantBehaviorConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		Behavior behavior = (Behavior) ctx.getTarget();
		if (!behavior.isReentrant()) {
			return ctx.createFailureStatus("Behavior - In this specification, a fUML instance model must have Behavior.isReentrant.");
		}
		return ctx.createSuccessStatus();
	}
}