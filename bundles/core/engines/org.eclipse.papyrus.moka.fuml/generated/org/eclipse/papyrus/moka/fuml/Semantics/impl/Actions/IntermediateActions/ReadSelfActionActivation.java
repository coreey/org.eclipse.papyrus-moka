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

import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Reference;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.ReadSelfAction;

public class ReadSelfActionActivation extends ActionActivation {

	@Override
	public void doAction() {
		// Get the context object of the activity execution containing this
		// action activation and place a reference to it on the result output
		// pin.
		// Debug.println("[ReadSelfActionActivation] Start...");
		Reference context = new Reference();
		context.referent = this.getExecutionContext();
		// Debug.println("[ReadSelfActionActivation] context object = " +
		// context.referent);
		OutputPin resultPin = ((ReadSelfAction) (this.node)).getResult();
		this.putToken(resultPin, context);
	}
}
