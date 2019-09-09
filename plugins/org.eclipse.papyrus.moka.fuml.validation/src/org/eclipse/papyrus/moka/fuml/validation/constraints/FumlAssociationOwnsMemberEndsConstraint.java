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
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;

/**
 * fuml_association_owns_memberEnds
 * 
 * An association must own all its memberEnds.
 * self.memberEnd->symmetricDifference(self.ownedEnd)->isEmpty()
 */
public class FumlAssociationOwnsMemberEndsConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		Association association = (Association) ctx.getTarget();
		for (Property menberEnd : association.getMemberEnds()) {
			if (!association.getOwnedEnds().contains(menberEnd)) {
				return ctx.createFailureStatus("Association - An association must own all its memberEnds.");
			}
		}
		return ctx.createSuccessStatus();
	}
}