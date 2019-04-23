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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IForkNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IForkedToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.debug.Debug;

public class ForkNodeActivation extends ControlNodeActivation implements IForkNodeActivation {

	@Override
	public void fire(List<IToken> incomingTokens) {
		// Create forked tokens for all incoming tokens and offer them on all
		// outgoing edges.
		if (this.getNode() == null) {
			Debug.println("[fire] Anonymous fork node.");
		} else {
			Debug.println("[fire] Fork node " + this.getNode().getName() + "...");
		}
		List<IActivityEdgeInstance> outgoingEdges = this.getOutgoingEdges();
		int outgoingEdgeCount = outgoingEdges.size();
		List<IToken> forkedTokens = new ArrayList<IToken>();
		for (int i = 0; i < incomingTokens.size(); i++) {
			IToken token = incomingTokens.get(i);
			IForkedToken forkedToken = new ForkedToken();
			forkedToken.setBaseToken(token);
			forkedToken.setRemainingOffersCount(outgoingEdgeCount);
			forkedToken.setBaseTokenWithDrawn(false);
			forkedTokens.add(forkedToken);
		}
		this.addTokens(forkedTokens);
		this.sendOffers(forkedTokens);
	}

	@Override
	public void terminate() {
		// Remove any offered tokens and terminate.
		this.clearTokens();
		super.terminate();
	}
}
