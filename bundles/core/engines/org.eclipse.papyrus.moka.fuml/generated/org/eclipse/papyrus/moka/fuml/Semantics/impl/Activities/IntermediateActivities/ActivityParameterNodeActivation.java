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
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityParameterNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.Parameter;

public class ActivityParameterNodeActivation extends ObjectNodeActivation implements IActivityParameterNodeActivation {

	@Override
	public void fire(List<IToken> incomingTokens) {
		// If there are no incoming edges, this is an activation of an input
		// activity parameter node.
		// Get the values from the input parameter indicated by the activity
		// parameter node and offer those values as object tokens.
		if (this.getNode().getIncomings().size() == 0) {
			Debug.println("[fire] Input activity parameter node " + this.getNode().getName() + "...");
			Parameter parameter = ((ActivityParameterNode) (this.getNode())).getParameter();
			IParameterValue parameterValue = this.getActivityExecution().getParameterValue(parameter);
			// Debug.println("[fire] parameter = " + parameter.name);
			if (parameterValue != null) {
				Debug.println("[fire] Parameter has " + parameterValue.getValues().size() + " value(s).");
				// List<Token> tokens = new ArrayList<Token>();
				List<IValue> values = parameterValue.getValues();
				for (int i = 0; i < values.size(); i++) {
					IValue value = values.get(i);
					ObjectToken token = new ObjectToken();
					token.value = value;
					this.addToken(token);
				}
				this.sendUnofferedTokens();
			}
		}
		// If there are one or more incoming edges, this is an activation of an
		// output activity parameter node.
		// Take the tokens offered on incoming edges and add them to the set of
		// tokens being offered.
		// [Note that an output activity parameter node may fire multiple times,
		// accumulating tokens offered to it.]
		else {
			Debug.println("[fire] Output activity parameter node " + this.node.getName() + "...");
			this.addTokens(incomingTokens);
		}
	}

	@Override
	public void clearTokens() {
		// Clear all held tokens only if this is an input parameter node.
		if (this.node.getIncomings().size() == 0) {
			super.clearTokens();
		}
	}
}
