/**
 * Copyright (c) 2017 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0 
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *   CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.moka.debug.model.data.mapping.variables;

import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.papyrus.moka.debug.engine.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.model.data.mapping.values.MokaValueAdapterFactory;
import org.eclipse.papyrus.moka.debug.model.data.mapping.values.MokaValueAdapterList;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IPinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.uml2.uml.Pin;

public class PinActivationVariableAdapter extends MokaVariableAdapter<IPinActivation> {

	public PinActivationVariableAdapter(MokaDebugTarget debugTarget, IPinActivation adaptedVariable) {
		super(debugTarget, adaptedVariable);
	}

	@Override
	public IValue getValue() throws DebugException {
		// TODO Auto-generated method stub
		if(this.value == null) {
			List<IToken> heldTokens = this.adaptedVariable.getTokens();
			if(heldTokens.size() == 1) {
				this.value = MokaValueAdapterFactory.getInstance().instantiate(heldTokens.iterator().next(), this.debugTarget);
			} else if(heldTokens.size() > 1) {
				MokaValueAdapterList tokenValueAdapterList = new MokaValueAdapterList(this.debugTarget);
				for(IToken token : heldTokens) {
					tokenValueAdapterList.add(token);
				}
			} else {
				this.value = MokaValueAdapterFactory.getInstance().instantiate(null, this.debugTarget);
			}
		}
		return this.value;
	}

	@Override
	public String getName() throws DebugException {
		// The name of the variable is the name of the pin or 'empty'
		// if no pin is attached to the pin activation
		Pin pin = (Pin) this.adaptedVariable.getNode();
		if (pin != null) {
			return pin.getName();
		}
		return "<empty>";
	}

}
