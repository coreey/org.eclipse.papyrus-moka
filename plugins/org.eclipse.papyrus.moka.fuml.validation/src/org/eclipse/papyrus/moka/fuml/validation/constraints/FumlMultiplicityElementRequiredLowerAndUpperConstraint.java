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
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.MultiplicityElement;

/**
 * required_lower_and_upper_for_fUML
 * 
 * upperValue must be a LiteralUnlimitedNatural and lowerValue must be a
 * LiteralInteger. Both are required.
 * 
 * self.upperValue->notEmpty() and
 * self.upperValue->asSequence()->first().oclIsKindOf(LiteralUnlimitedNatural)
 * and self.lowerValue->notEmpty() and
 * self.lowerValue->asSequence()->first().oclIsKindOf(LiteralInteger)
 * 
 */
public class FumlMultiplicityElementRequiredLowerAndUpperConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		MultiplicityElement multiplicityElement = (MultiplicityElement) ctx.getTarget();
		boolean areValuesEmpty = multiplicityElement.getUpperValue() == null
				|| multiplicityElement.getLowerValue() == null;
		boolean isUpperNotUnlimitedNatural = false == multiplicityElement.getUpperValue() instanceof LiteralUnlimitedNatural;
		boolean isLowerNotUnlimitedNatural = false == multiplicityElement.getLowerValue() instanceof LiteralInteger;
		if (areValuesEmpty || isUpperNotUnlimitedNatural || isLowerNotUnlimitedNatural) {
			return ctx.createFailureStatus("MultiplicityElement - upperValue must be a LiteralUnlimitedNatural and lowerValue must be a LiteralInteger. Both are required.");
		}
		return ctx.createSuccessStatus();
	}
}