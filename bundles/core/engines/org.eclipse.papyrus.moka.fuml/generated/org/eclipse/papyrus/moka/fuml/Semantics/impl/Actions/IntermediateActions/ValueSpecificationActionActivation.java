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
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;
import org.eclipse.uml2.uml.ValueSpecificationAction;

public class ValueSpecificationActionActivation extends ActionActivation {

	@Override
	public void doAction() {
		// Evaluate the value specification for the action and place the result
		// on the result pin of the action.
		ValueSpecificationAction action = (ValueSpecificationAction) (this.node);
		IValue value = this.getExecutionLocus().getExecutor().evaluate(action.getValue());
		this.putToken(action.getResult(), value);
	}
}
