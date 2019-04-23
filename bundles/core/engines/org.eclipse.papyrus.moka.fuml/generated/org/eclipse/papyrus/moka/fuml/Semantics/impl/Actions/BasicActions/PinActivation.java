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
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IPinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.ObjectNodeActivation;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.uml2.uml.Pin;

public abstract class PinActivation extends ObjectNodeActivation implements IPinActivation {

	/*
	 * The activation of the action that owns the pin for this pin activation.
	 */
	public IActionActivation actionActivation;

	@Override
	public void fire(List<IToken> incomingTokens) {
		// Add all incoming tokens to the pin.
		Debug.println("[fire] Pin " + (this.node == null ? "" : this.node.getName() + "..."));
		this.addTokens(incomingTokens);
	}

	@Override
	public List<IToken> takeOfferedTokens() {
		// Take only a number of tokens only up to the limit allowed by
		// the multiplicity upper bound of the pin for this activation.
		int count = this.countUnofferedTokens();
		int upper = -1;
		// Note: A pin activation used in an expansion activation group
		// will have this.node == null.
		if (this.node != null) {
			upper = ((Pin) (this.node)).getUpper();
		}
		List<IToken> tokens = new ArrayList<IToken>();
		// Note: upper < 0 indicates an unbounded upper multiplicity.
		if (upper < 0 | count < upper) {
			List<IActivityEdgeInstance> incomingEdges = this.incomingEdges;
			for (int i = 0; i < incomingEdges.size(); i++) {
				IActivityEdgeInstance edge = incomingEdges.get(i);
				int incomingCount = edge.countOfferedValues();
				List<IToken> incomingTokens = new ArrayList<IToken>();
				if (upper < 0 | incomingCount < upper - count) {
					incomingTokens = edge.takeOfferedTokens();
					count = count + incomingCount;
				} else if (count < upper) {
					incomingTokens = edge.takeOfferedTokens(upper - count);
					count = upper;
				}
				for (int j = 0; j < incomingTokens.size(); j++) {
					IToken token = incomingTokens.get(j);
					tokens.add(token);
				}
			}
		}
		return tokens;
	}

	public IActionActivation getActionActivation() {
		return this.actionActivation;
	}

	public void setActionActivation(IActionActivation actionActivation) {
		this.actionActivation = actionActivation;
	}
}
