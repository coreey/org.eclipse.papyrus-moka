/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.moka.engine.uml.debug.data.variables;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.fuml.actions.IActionActivation;
import org.eclipse.papyrus.moka.fuml.actions.IPinActivation;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.InputPin;

public class ActionActivationValueAdapter<T extends IActionActivation> extends ActivityNodeActivationValueAdapter<T>{

	public ActionActivationValueAdapter(IDebugTarget debugTarget, T visitor) {
		super(debugTarget, visitor);
	}
	
	@Override
	public IVariable[] getVariables() throws DebugException {
		// For each input pin create a variable. This variable provides access
		// to the tokens held by the pin activations attached to adapted activation
		// for an action.
		if(this.variables.isEmpty()) {
			Action action = (Action) value.getNode();
			for(InputPin pin : action.getInputs()) {
				IPinActivation pinActivation = value.getPinActivation(pin);
				if(pinActivation != null) {
					this.variables.add(new ObjectNodeActivationVariableAdapter(getDebugTarget(), pinActivation));
				}
			}
		}
		return this.variables.toArray(new IVariable[0]);
	}
	
}
