/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
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

import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.fuml.activities.IActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.activities.IForkedToken;
import org.eclipse.papyrus.moka.fuml.activities.IObjectToken;
import org.eclipse.papyrus.moka.fuml.activities.IToken;

public class ActivityEdgeInstanceValueAdapter extends VisitorValueAdapter<IActivityEdgeInstance> {

	public ActivityEdgeInstanceValueAdapter(IDebugTarget target, IActivityEdgeInstance visitor) {
		super(target, visitor);
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		if(this.variables.isEmpty()) {
			 List<IToken> tokens = value.getSource().getTokens();
			 if(tokens.size() == 1) {
				 IToken token = tokens.iterator().next(); 
				 if(token instanceof IObjectToken
						 || token instanceof IForkedToken) {
					 IObjectToken objectToken = null;
					 if(token instanceof IForkedToken) {
						objectToken = (IObjectToken)((IForkedToken)token).getBaseToken();
					 }else {
						objectToken = (IObjectToken) token;
					 }
					 this.variables.add(new ObjectTokenVariableValueAdapter(getDebugTarget(), objectToken.getValue()));
				 }
			 }else {
				 this.variables.add(new TokensVariableAdapter(getDebugTarget(), tokens));
			 }
		}
		return this.variables.toArray(new IVariable[0]);
	}
}
