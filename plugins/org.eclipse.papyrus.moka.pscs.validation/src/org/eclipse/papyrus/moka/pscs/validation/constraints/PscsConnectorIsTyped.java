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
package org.eclipse.papyrus.moka.pscs.validation.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Connector;

/**
 * pscs_connector_is_typed 
 * type <> null
 */
public class PscsConnectorIsTyped extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		Connector connector = (Connector) ctx.getTarget();
		boolean expression = connector.getType() != null;
		if (!expression) {
			return ctx.createFailureStatus("Connector - A Connector must be typed");
		}
		return ctx.createSuccessStatus();
	}

}
