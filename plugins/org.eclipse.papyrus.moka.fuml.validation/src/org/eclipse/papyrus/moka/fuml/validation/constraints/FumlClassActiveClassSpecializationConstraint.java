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
import org.eclipse.uml2.uml.Class;

/**
 * active_class_specialization
 * 
 * Only an active class may specialize an active class.
 * self.parents()->exist(isActive) implies self.isActive
 */
public class FumlClassActiveClassSpecializationConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		org.eclipse.uml2.uml.Class clazz = (Class) ctx.getTarget();
		if (!clazz.isActive()) {
			boolean isOneParentActive = clazz.getGenerals().stream()
					.filter(c -> c instanceof Class) // keep only class
					.map(c -> (Class) c) // cast on class
					.anyMatch(c -> c.isActive()); // check if at least one of these class are active
			if (isOneParentActive) {
				return ctx.createFailureStatus("Class - Only an active class may specialize an active class.");
			}
		}
		return ctx.createSuccessStatus();
	}
}