/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.moka.composites.Semantics.impl.Actions.IntermediateActions;

import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_Object;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_Reference;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions.ReadSelfActionActivation;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.ReadSelfAction;


public class CS_ReadSelfActionActivation extends ReadSelfActionActivation {

	@Override
	public void doAction() {
		// Get the context object of the activity execution containing this
		// action activation and place a reference to it on the result output
		// pin.
		// Extends fUML semantics in the sense that the reference placed on
		// the result pin is a CS_Reference, not a Reference

		// Debug.println("[ReadSelfActionActivation] Start...");

		ICS_Reference context = new CS_Reference();
		context.setReferent(this.getExecutionContext());
		if (context.getReferent() instanceof CS_Object) {// i.e. alternatively, it can be an execution
			context.setCompositeReferent((CS_Object) context.getReferent());
		}

		// Debug.println("[ReadSelfActionActivation] context object = " +
		// context.referent);

		OutputPin resultPin = ((ReadSelfAction) (this.node)).getResult();
		this.putToken(resultPin, context);
	}
}
