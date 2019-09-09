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
 * fuml_class_abstract_class
 * 
 * Only an abstract class may have abstract behavioral features.
 * self.member->select(oclIsKindOf(BehavioralFeature))->exists(isAbstract) implies self.isAbstract
 */
public class FumlClassAbstractClassConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		org.eclipse.uml2.uml.Class clazz = (Class) ctx.getTarget();
		boolean hasBehavioralFeatureAbstract = clazz.getMembers().stream()
				.filter(c -> c instanceof BehavioralFeature)
				.map(c-> BehavioralFeature.class.cast(c))
				.anyMatch(bf -> bf.isAbstract());
		if (hasBehavioralFeatureAbstract && !clazz.isActive()) {
			return ctx.createFailureStatus("Class - Only an abstract class may have abstract behavioral features.");
		}
		return ctx.createSuccessStatus();
	}
}