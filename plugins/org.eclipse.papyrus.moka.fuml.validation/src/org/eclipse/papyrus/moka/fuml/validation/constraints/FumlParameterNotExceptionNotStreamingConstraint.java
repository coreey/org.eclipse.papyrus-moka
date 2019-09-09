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
import org.eclipse.uml2.uml.Parameter;

/**
 * fuml_parameter_not_exception_not_streaming
 * 
 * isException and isStream must be false
 * not self.isException and not self.isStream
 */
public class FumlParameterNotExceptionNotStreamingConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		Parameter parameter = (Parameter) ctx.getTarget();
		if (parameter.isException() || parameter.isStream()) {
			return ctx.createFailureStatus("Parameter - isException and isStream must be false");
		}
		return ctx.createSuccessStatus();
	}
}