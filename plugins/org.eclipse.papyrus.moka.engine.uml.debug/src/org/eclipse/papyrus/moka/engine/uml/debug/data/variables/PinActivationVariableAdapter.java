/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.moka.engine.uml.debug.data.variables;

import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.papyrus.moka.engine.uml.debug.data.values.MokaValueAdapterList;
import org.eclipse.papyrus.moka.engine.uml.debug.data.values.UMLValueAdapterFactory;
import org.eclipse.papyrus.moka.fuml.actions.IPinActivation;
import org.eclipse.papyrus.moka.fuml.activities.IToken;
import org.eclipse.uml2.uml.Pin;

public class PinActivationVariableAdapter extends UMLVariableAdapter<IPinActivation> {

	public PinActivationVariableAdapter(IDebugTarget target, IPinActivation variable) {
		super(target, variable);
	}

	@Override
	public IValue getValue() throws DebugException {
		if(this.value == null) {
			List<IToken> heldTokens = variable.getTokens();
			if(heldTokens.size() == 1) {
				this.value = UMLValueAdapterFactory.getInstance().instantiate(heldTokens.iterator().next(), getDebugTarget());
			} else if(heldTokens.size() > 1) {
				MokaValueAdapterList tokenValueAdapterList = new MokaValueAdapterList(getDebugTarget());
				for(IToken token : heldTokens) {
					tokenValueAdapterList.add(token);
				}
			} else {
				this.value = UMLValueAdapterFactory.getInstance().instantiate(null, getDebugTarget());
			}
		}
		return this.value;
	}

	@Override
	public String getName() throws DebugException {
		// The name of the variable is the name of the pin or 'empty'
		// if no pin is attached to the pin activation
		Pin pin = (Pin) variable.getNode();
		if (pin != null) {
			return pin.getName();
		}
		return super.getName();
	}

}
