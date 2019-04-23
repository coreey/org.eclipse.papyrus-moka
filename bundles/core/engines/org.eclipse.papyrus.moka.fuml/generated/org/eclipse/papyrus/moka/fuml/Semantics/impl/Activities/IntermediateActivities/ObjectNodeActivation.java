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

import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IObjectNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;

public abstract class ObjectNodeActivation extends ActivityNodeActivation implements IObjectNodeActivation {

	/*
	 * The number of held tokens that have already been offered.
	 */
	public Integer offeredTokenCount;

	@Override
	public void run() {
		// Initialize the offered token count to zero.
		super.run();
		this.offeredTokenCount = 0;
	}

	@Override
	public void sendOffers(List<IToken> tokens) {
		// If the set of tokens to be sent is empty, then offer a null token
		// instead.
		// Otherwise, offer the given tokens as usual.
		if (tokens.size() == 0) {
			ObjectToken token = new ObjectToken();
			token.holder = this;
			tokens.add(token);
		}
		super.sendOffers(tokens);
	}

	@Override
	public void terminate() {
		// Terminate the node activation and remove any held tokens.
		super.terminate();
		this.clearTokens();
	}

	@Override
	public void addToken(IToken token) {
		// Transfer the given token to be held by this node only if it is a
		// non-null object token.
		// If it is a control token or a null token, consume it without holding
		// it.
		if (token.getValue() == null) {
			token.withdraw();
		} else {
			super.addToken(token);
		}
	}

	@Override
	public Integer removeToken(IToken token) {
		// Remove the given token, if it is held by this node activation.
		int i = super.removeToken(token);
		if (i > 0 & i <= this.offeredTokenCount) {
			this.offeredTokenCount = this.offeredTokenCount - 1;
		}
		return i;
	}

	@Override
	public void clearTokens() {
		// Remove all held tokens.
		super.clearTokens();
		this.offeredTokenCount = 0;
	}

	public Integer countOfferedValues() {
		// Count the total number of non-null object tokens being offered to
		// this node activation.
		int totalValueCount = 0;
		int i = 1;
		while (i <= this.incomingEdges.size()) {
			totalValueCount = totalValueCount + this.incomingEdges.get(i - 1).countOfferedValues();
			i = i + 1;
		}
		return totalValueCount;
	}

	public void sendUnofferedTokens() {
		// Send offers over all outgoing edges, if there are any tokens to be
		// offered.
		List<IToken> tokens = this.getUnofferedTokens();
		this.offeredTokenCount = this.offeredTokenCount + tokens.size();
		this.sendOffers(tokens);
	}

	public Integer countUnofferedTokens() {
		// Return the number of unoffered tokens that are to be offered next.
		// (By default, this is all unoffered tokens.)
		if (this.heldTokens.size() == 0) {
			this.offeredTokenCount = 0;
		}
		return this.heldTokens.size() - this.offeredTokenCount;
	}

	public List<IToken> getUnofferedTokens() {
		// Get the next set of unoffered tokens to be offered and return it.
		// [Note: This effectively treats all object flows as if they have
		// weight=*, rather than the weight=1 default in the current
		// superstructure semantics.]
		List<IToken> tokens = new ArrayList<IToken>();
		int i = 1;
		while (i <= this.countUnofferedTokens()) {
			tokens.add(this.heldTokens.get(this.offeredTokenCount + i - 1));
			i = i + 1;
		}
		return tokens;
	}

	public List<IToken> takeUnofferedTokens() {
		// Take the next set of unoffered tokens to be offered from this node
		// activation and return them.
		List<IToken> tokens = this.getUnofferedTokens();
		for (int i = 0; i < tokens.size(); i++) {
			IToken token = tokens.get(i);
			token.withdraw();
		}
		return tokens;
	}
}
