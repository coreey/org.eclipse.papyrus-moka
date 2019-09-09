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
import org.eclipse.uml2.uml.ReclassifyObjectAction;

/**
 * fUML_old_new_classes
 * 
 * All the old and new classifiers must be classes.
 * self.oldClassifier->forAll(oclIsKindOf(Class)) and self.newClassifier->forAll(oclIsKindOf(Class))
 */
public class FumlReclassifyObjectActionOldNewClassesConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		ReclassifyObjectAction reclassifyObjectAction = (ReclassifyObjectAction) ctx.getTarget();
		boolean constraint = reclassifyObjectAction.getOldClassifiers().stream()
				.allMatch(c -> c instanceof Class);
		constraint &= reclassifyObjectAction.getNewClassifiers().stream()
				.allMatch(c -> c instanceof Class);
		if (!constraint) {
			return ctx.createFailureStatus("ReclassifyObjectAction - All the old and new classifiers must be classes.");
		}
		return ctx.createSuccessStatus();
	}
}