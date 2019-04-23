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
package org.eclipse.papyrus.moka.debug.model.data.mapping.values;

import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.debug.engine.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.model.data.mapping.variables.ObjectTokenVariableValueAdapter;
import org.eclipse.papyrus.moka.debug.model.data.mapping.variables.TokensVariableAdapter;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IForkedToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IObjectToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;

public class ActivityEdgeInstanceValueAdapter extends VisitorValueAdapter<IActivityEdgeInstance> {

	public ActivityEdgeInstanceValueAdapter(MokaDebugTarget debugTarget, IActivityEdgeInstance visitor) {
		super(debugTarget, visitor);
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		if(this.variables.isEmpty()) {
			 List<IToken> tokens = this.adaptedObject.getSource().getTokens();
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
					 this.variables.add(new ObjectTokenVariableValueAdapter(debugTarget, objectToken.getValue()));
				 }
			 }else {
				 this.variables.add(new TokensVariableAdapter(debugTarget, tokens));
			 }
		}
		return this.variables.toArray(new IVariable[0]);
	}
}
