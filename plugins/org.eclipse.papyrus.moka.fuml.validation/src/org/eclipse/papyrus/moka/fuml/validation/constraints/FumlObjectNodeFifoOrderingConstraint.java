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
import org.eclipse.uml2.uml.ObjectNodeOrderingKind;

/**
 * fuml_object_node_fifo_ordering
 * 
 * ordering must be FIFO
 * self.ordering = ObjectNodeOrderingKind::FIFO
 */
public class FumlObjectNodeFifoOrderingConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		ObjectNode objectNode = (ObjectNode) ctx.getTarget();
		if (objectNode.getOrdering() != ObjectNodeOrderingKind.FIFO_LITERAL) {
			return ctx.createFailureStatus("ObjectNode - ordering must be FIFO");
		}
		return ctx.createSuccessStatus();
	}
}
