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
 *  Jeremie TATIBOUET (CEA LIST) - Animation refactoring and improvements
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivationGroup;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IOffer;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.uml2.uml.ActivityEdge;

public class ActivityEdgeInstance implements IActivityEdgeInstance {

	/*
	 * The activity edge of which this is an instance. [This is optional to
	 * allow for an implicit fork node execution to be connected to its action
	 * execution by an edge instance which does not have a corresponding node in
	 * the model.]
	 */
	public ActivityEdge edge;

	/*
	 * The activity group that contains this activity edge instance.
	 */
	public IActivityNodeActivationGroup group;

	/*
	 * The source of this activity edge instance. The node of the source must be
	 * the same as the source of the edge of this edge instance.
	 */
	public IActivityNodeActivation source;

	/*
	 * The target of this activity edge instance. The node of the target must be
	 * the same as the target of the edge of this edge instance.
	 */
	public IActivityNodeActivation target;

	public List<IOffer> offers = new ArrayList<IOffer>();

	public void sendOffer(List<IToken> tokens) {
		// Send an offer from the source to the target.
		// Keep the offered tokens until taken by the target.
		// (Note that any one edge should only be handling either all object
		// tokens or all control tokens.)
		IOffer offer = new Offer();
		for (int i = 0; i < tokens.size(); i++) {
			IToken token = tokens.get(i);
			// Debug.println("[sendOffer] token value = " + token.get());
			offer.getTokens().add(token);
		}
		this.offers.add(offer);
		this.target.receiveOffer();
	}

	public Integer countOfferedValues() {
		// Return the number of values being offered in object tokens.
		int count = 0;
		List<IOffer> offers = this.offers;
		for (int i = 0; i < offers.size(); i++) {
			count = count + offers.get(i).countOfferedValues();
		}
		return count;
	}

	public List<IToken> takeOfferedTokens() {
		// Take all the offered tokens and return them.
		List<IToken> tokens = new ArrayList<IToken>();
		while (this.offers.size() > 0) {
			List<IToken> offeredTokens = this.offers.get(0).getOfferedTokens();
			for (int i = 0; i < offeredTokens.size(); i++) {
				tokens.add(offeredTokens.get(i));
			}
			this.offers.remove(0);
		}
		return tokens;
	}

	public List<IToken> takeOfferedTokens(Integer maxCount) {
		// Take all the offered tokens, up to the given maximum count of
		// non-null object tokens, and return them.
		List<IToken> tokens = new ArrayList<IToken>();
		int remainingCount = maxCount;
		while (this.offers.size() > 0 & remainingCount > 0) {
			IOffer offer = this.offers.get(0);
			List<IToken> offeredTokens = offer.getOfferedTokens();
			int count = offer.countOfferedValues();
			if (count <= remainingCount) {
				for (int i = 0; i < offeredTokens.size(); i++) {
					tokens.add(offeredTokens.get(i));
				}
				remainingCount = remainingCount - count;
				this.offers.remove(0);
			} else {
				for (int i = 0; i < remainingCount; i++) {
					IToken token = offeredTokens.get(i);
					if (token.getValue() != null) {
						tokens.add(token);
					}
				}
				offer.removeOfferedValues(remainingCount);
				remainingCount = 0;
			}
		}
		return tokens;
	}

	public List<IToken> getOfferedTokens() {
		// Get the offered tokens (after which the tokens will still be
		// offered).
		List<IToken> tokens = new ArrayList<IToken>();
		List<IOffer> offers = this.offers;
		for (int i = 0; i < offers.size(); i++) {
			List<IToken> offeredTokens = offers.get(i).getOfferedTokens();
			for (int j = 0; j < offeredTokens.size(); j++) {
				tokens.add(offeredTokens.get(j));
			}
		}
		return tokens;
	}

	public Boolean hasOffer() {
		// Return true if there are any pending offers.
		boolean hasTokens = false;
		int i = 1;
		while (!hasTokens & i <= this.offers.size()) {
			hasTokens = this.offers.get(i - 1).hasTokens();
			i = i + 1;
		}
		return hasTokens;
	}

	public void setSource(IActivityNodeActivation source) {
		this.source = source;
	}

	public IActivityNodeActivation getSource() {
		return this.source;
	}

	public void setTarget(IActivityNodeActivation target) {
		this.target = target;
	}

	public IActivityNodeActivation getTarget() {
		return this.target;
	}

	public void setGroup(IActivityNodeActivationGroup group) {
		this.group = group;
	}

	public IActivityNodeActivationGroup getGroup() {
		return this.group;
	}

	public void setEdge(ActivityEdge edge) {
		this.edge = edge;
	}

	public ActivityEdge getEdge() {
		return this.edge;
	}

	public void _endIsolation() {
	}

	public void _beginIsolation() {
	}
}
