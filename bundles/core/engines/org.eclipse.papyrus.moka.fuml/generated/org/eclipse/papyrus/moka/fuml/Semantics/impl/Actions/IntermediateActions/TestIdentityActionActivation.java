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
import org.eclipse.uml2.uml.TestIdentityAction;

public class TestIdentityActionActivation extends ActionActivation {

	@Override
	public void doAction() {
		// Get the values from the first and second input pins and test if they
		// are equal. (Note the equality of references is defined to be that
		// they have identical referents.)
		// If they are equal, place true on the pin execution for the result
		// output pin, otherwise place false.
		TestIdentityAction action = (TestIdentityAction) (this.node);
		IValue firstValue = this.takeTokens(action.getFirst()).get(0);
		IValue secondValue = this.takeTokens(action.getSecond()).get(0);
		IValue testResult = this.makeBooleanValue(firstValue.equals(secondValue));
		this.putToken(action.getResult(), testResult);
	}
}
