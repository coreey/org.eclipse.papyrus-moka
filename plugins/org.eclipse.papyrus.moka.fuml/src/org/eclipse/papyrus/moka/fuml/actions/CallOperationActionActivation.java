/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.actions;

import org.eclipse.papyrus.moka.fuml.commonbehavior.IExecution;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IValue;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IReference;
import org.eclipse.uml2.uml.CallOperationAction;

public class CallOperationActionActivation extends CallActionActivation {

	@Override
	public IExecution getCallExecution() {
		// If the value on the target input pin is a reference, dispatch the
		// operation to it and return the resulting execution object.
		CallOperationAction action = (CallOperationAction) (this.node);
		IValue target = this.takeTokens(action.getTarget()).get(0);
		IExecution execution;
		if (target instanceof IReference) {
			execution = ((IReference) target).dispatch(action.getOperation());
		} else {
			execution = null;
		}
		return execution;
	}
}
