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
package org.eclipse.papyrus.moka.pssm.validation.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.Operation;

/**
 * pssm_call_event_operation_has_no_method
 * 
 * The operation of the CallEvent must not have any methods.
 * context UML::CommonBehavior::CallEvent inv:
 * self.operation.method->isEmpty()
 * 
 * TODO this constraint seems conflicting with pssm_operation_has_at_most_one_method
 */
public class PssmCallEventOperationHasNoMethodConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		CallEvent callEvent = (CallEvent) ctx.getTarget();
		Operation callEventOperation = callEvent.getOperation();
		if (callEventOperation != null) {
			Boolean expression = callEventOperation.getMethods().isEmpty();
			if (!expression) {
				return ctx.createFailureStatus("CallEvent - The operation of the CallEvent must not have any methods.");
			}
		}
		return ctx.createSuccessStatus();
	}
}