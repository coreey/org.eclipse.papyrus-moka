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
package org.eclipse.papyrus.moka.pscs.validation.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Port;

/**
 * pscs_behavior_port_belongs_to_an_active_class
 * A behavior port can only belong to an active class.
 * 
 * inv: encapsulatedClassifier->notEmpty() and
 * (encapsulatedClassifier.oclIsKindOf(Class) and
 * encapsulatedClassifier.isActive))
 */
public class PscsBehaviorPortBelongsToAnActiveClass extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		Port port = (Port) ctx.getTarget();
		boolean expression = port.getOwner() instanceof Class
				&& ((Class) port.getOwner()).isActive();
		if (!expression) {
			return ctx.createFailureStatus("Port - A behavior port can only belong to an active class.");
		}
		return ctx.createSuccessStatus();
	}

}
