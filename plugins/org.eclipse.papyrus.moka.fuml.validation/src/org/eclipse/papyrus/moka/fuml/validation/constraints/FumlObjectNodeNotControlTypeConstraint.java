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
import org.eclipse.uml2.uml.ObjectNode;

/**
 * fuml_object_node_not_control_type
 * 
isControlType must be false
not self.isControlType
 */
public class FumlObjectNodeNotControlTypeConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		ObjectNode objectNode = (ObjectNode) ctx.getTarget();
		if (objectNode.isControlType()) {
			return ctx.createFailureStatus("ObjectNode - isControlType must be false");
		}
		return ctx.createSuccessStatus();
	}
}