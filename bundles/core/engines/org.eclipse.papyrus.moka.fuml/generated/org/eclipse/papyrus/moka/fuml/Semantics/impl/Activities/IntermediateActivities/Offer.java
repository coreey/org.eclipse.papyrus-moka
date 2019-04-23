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

import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IOffer;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;

public class Offer implements IOffer {

	public List<IToken> offeredTokens = new ArrayList<IToken>();

	public Integer countOfferedValues() {
		// Return the number of values being offered on object tokens.
		// Remove any tokens that have already been withdrawn and don't include
		// them in the count.
		this.removeWithdrawnTokens();
		int count = 0;
		for (int i = 0; i < this.offeredTokens.size(); i++) {
			if (this.offeredTokens.get(i).getValue() != null) {
				count = count + 1;
			}
		}
		return count;
	}

	public List<IToken> getOfferedTokens() {
		// Get the offered tokens, removing any that have been withdrawn.
		this.removeWithdrawnTokens();
		List<IToken> tokens = new ArrayList<IToken>();
		List<IToken> offeredTokens = this.offeredTokens;
		for (int i = 0; i < this.offeredTokens.size(); i++) {
			IToken offeredToken = offeredTokens.get(i);
			// Debug.println("[getOfferedTokens] token value = " +
			// offeredToken.getValue());
			tokens.add(offeredToken);
		}
		return tokens;
	}

	public void removeOfferedValues(Integer count) {
		// Remove the given number of non-null object tokens from those in this
		// offer.
		int n = count;
		int i = 1;
		while (n > 0) {
			if (this.offeredTokens.get(i - 1).getValue() != null) {
				this.offeredTokens.remove(i - 1);
			} else {
				i = i + 1;
			}
			n = n - 1;
		}
	}

	public void removeWithdrawnTokens() {
		// Remove any tokens that have already been consumed.
		// List<Token> offeredTokens = this.offeredTokens;
		int i = 1;
		while (i <= this.offeredTokens.size()) {
			if (this.offeredTokens.get(i - 1).isWithdrawn()) {
				this.offeredTokens.remove(i - 1);
				i = i - 1;
			}
			i = i + 1;
		}
	}

	public Boolean hasTokens() {
		// Check whether this offer has any tokens that have not been withdrawn.
		this.removeWithdrawnTokens();
		return this.offeredTokens.size() > 0;
	}

	public List<IToken> getTokens() {
		// Convenience operation to access the list of offered tokens
		return this.offeredTokens;
	}
}
