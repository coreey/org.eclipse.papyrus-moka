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
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.ExtraStructuredActivities;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Activities.ExtraStructuredActivities.IExpansionNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.ObjectNodeActivation;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.uml2.uml.ExpansionNode;
import org.eclipse.uml2.uml.ExpansionRegion;

public class ExpansionNodeActivation extends ObjectNodeActivation implements IExpansionNodeActivation {

	@Override
	public void fire(List<IToken> incomingTokens) {
		// Take tokens from all incoming edges.
		Debug.println("[fire] Expansion node " + this.node.getName() + "...");
		this.addTokens(incomingTokens);
	}

	@Override
	public void receiveOffer() {
		// Forward the offer on to the expansion region.
		this.getExpansionRegionActivation().receiveOffer();
	}

	@Override
	public Boolean isReady() {
		// An expansion node is always fired by its expansion region.
		return false;
	}

	public ExpansionRegionActivation getExpansionRegionActivation() {
		// Return the expansion region activation corresponding to this
		// expansion node, in the context of the activity node activation group
		// this expansion node activation is in.
		ExpansionNode node = (ExpansionNode) (this.node);
		ExpansionRegion region = node.getRegionAsInput();
		if (region == null) {
			region = node.getRegionAsOutput();
		}
		return (ExpansionRegionActivation) (this.group.getNodeActivation(region));
	}
}
