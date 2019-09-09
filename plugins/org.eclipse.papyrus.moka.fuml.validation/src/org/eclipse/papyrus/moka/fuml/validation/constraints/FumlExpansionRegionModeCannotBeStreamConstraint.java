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
import org.eclipse.uml2.uml.ExpansionKind;
import org.eclipse.uml2.uml.ExpansionRegion;

/**
 * fUML_mode_cannot_be_stream
 * 
 * mode cannot be stream.
 * self.mode <> ExpansionKind::stream
 */
public class FumlExpansionRegionModeCannotBeStreamConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		ExpansionRegion expansionRegion = (ExpansionRegion) ctx.getTarget();
		if (expansionRegion.getMode() == ExpansionKind.STREAM_LITERAL) {
			return ctx.createFailureStatus("ExpansionRegion - mode cannot be stream.");
		}
		return ctx.createSuccessStatus();
	}
}