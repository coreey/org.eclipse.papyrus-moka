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

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * possible_classifiers
 * 
 * Either all the classifiers are classes, or there is one classifier that is a
 * data type.
 * self.classifier->forAll(oclIsKindOf(Class)) or
 * self.classifier->size() = 1 and self.classifier->forAll(oclIsKindOf(DataType))
 * 
 * FIXME what's happen when the classifier is empty (currently it is invalid)
 */
public class FumlInstanceSpecificationPossibleClassifiersConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		InstanceSpecification instanceSpecification = (InstanceSpecification) ctx.getTarget();
		List<Classifier> classifiers = instanceSpecification.getClassifiers();
		boolean allAreClasses = classifiers.stream()
				.allMatch(c -> c instanceof Class);
		if (!allAreClasses || classifiers.isEmpty()) {
			if (classifiers.size() != 1) {
				boolean allAreDataType = classifiers.stream()
						.allMatch(c -> c instanceof DataType);
				if (!allAreDataType || classifiers.isEmpty()) {
					return ctx.createFailureStatus(
							"InstanceSpecification - Either all the classifiers are classes, or there is one classifier that is a data type.");
				}
			}

		}
		return ctx.createSuccessStatus();
	}
}