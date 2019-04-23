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
import org.eclipse.uml2.uml.Class;


/**
 * This class is introduced to check the following constraint:
 * An active class shall have a classifier behavior
 * See 439645: [Moka] [Validation] An active class shall have a classifier behavior https://bugs.eclipse.org/bugs/show_bug.cgi?id=439645
 *
 */
public class ActiveClassHasClassifierBehavior_Constraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		Class clazz = (Class) ctx.getTarget();
		if (clazz.isActive()) {
			if (clazz.getClassifierBehavior() == null) {
				return ctx.createFailureStatus("An active Class shall have a classifier behavior");
			}
		}
		return ctx.createSuccessStatus();
	}

}
