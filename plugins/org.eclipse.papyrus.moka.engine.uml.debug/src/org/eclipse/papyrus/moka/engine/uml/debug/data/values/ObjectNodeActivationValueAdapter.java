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

package org.eclipse.papyrus.moka.engine.uml.debug.data.values;

import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.engine.uml.debug.data.variables.ObjectTokenVariableValueAdapter;
import org.eclipse.papyrus.moka.engine.uml.debug.data.variables.TokensVariableAdapter;
import org.eclipse.papyrus.moka.fuml.activities.IForkedToken;
import org.eclipse.papyrus.moka.fuml.activities.IObjectNodeActivation;
import org.eclipse.papyrus.moka.fuml.activities.IObjectToken;
import org.eclipse.papyrus.moka.fuml.activities.IToken;

public class ObjectNodeActivationValueAdapter extends ActivityNodeActivationValueAdapter<IObjectNodeActivation>{

	public ObjectNodeActivationValueAdapter(IDebugTarget target, IObjectNodeActivation value) {
		super(target, value);
	}
	
	@Override
	public IVariable[] getVariables() throws DebugException {
		if(this.variables.isEmpty()) {
			 List<IToken> tokens = this.getTokens();
			 if(tokens.size() == 1) {
				 IToken token = tokens.iterator().next(); 
				 IObjectToken objectToken = null;
				 if(token instanceof IForkedToken) {
					objectToken = (IObjectToken)((IForkedToken)token).getBaseToken();
				 }else {
					objectToken = (IObjectToken) token;
				 }
				 this.variables.add(new ObjectTokenVariableValueAdapter(getDebugTarget(), objectToken.getValue()));
			 }else {
				 this.variables.add(new TokensVariableAdapter(getDebugTarget(), tokens));
			 }
		}
		return this.variables.toArray(new IVariable[0]);
	}
	
	public List<IToken> getTokens() {
		// By default try to get tokens from the offer attached to the
		// adapted activation
		return value.getTokens();
	}

}
