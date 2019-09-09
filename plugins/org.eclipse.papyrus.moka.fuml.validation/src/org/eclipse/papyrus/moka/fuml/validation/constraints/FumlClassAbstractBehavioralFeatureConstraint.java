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
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Class;

/**
 * abstract_class
 * 
 * Only an abstract class may have abstract behavioral features.
 * self.member->select(oclIsKindOf(BehavioralFeature))->exists(isAbstract)
 * implies self.isAbstract
 * 
 * WARNING : this constraint is not implement exactly as the OCL constraint 
 * (getMembers is replaced by getOwnedElements) since get member get also inherited 
 * element
 */
public class FumlClassAbstractBehavioralFeatureConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		org.eclipse.uml2.uml.Class clazz = (Class) ctx.getTarget();
		if (!clazz.isAbstract()) {
			boolean isOneOwnedBehavioralFeatureAbstract = clazz.getOwnedElements().stream()
					.filter(c -> c instanceof BehavioralFeature) // keep only BehavioralFeature
					.map(c -> (BehavioralFeature) c) // cast on BehavioralFeature
					.anyMatch(c -> c.isAbstract()); // check if at least one of these BehavioralFeature are abstract
			if (isOneOwnedBehavioralFeatureAbstract) {
				return ctx.createFailureStatus("Class - Only an abstract class may have abstract behavioral features.");
			}
		}
		return ctx.createSuccessStatus();
	}
}