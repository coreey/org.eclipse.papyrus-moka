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

import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IForkedToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;

public class ForkedToken extends Token implements IForkedToken {

	public IToken baseToken;

	/*
	 * The remaining number of outstanding offers for this token on outgoing
	 * edges of the fork node.
	 */
	public Integer remainingOffersCount;

	/*
	 * Indicates whether withdraw() has been called on the base token.
	 */
	public Boolean baseTokenIsWithdrawn;

	@Override
	public Boolean isControl() {
		// Test if the base token is a control token.
		return this.getBaseToken().isControl();
	}

	@Override
	public void withdraw() {
		// If the base token is not withdrawn, then withdraw it.
		// Decrement the remaining offers count.
		// When the remaining number of offers is zero, then remove this token
		// from its holder.
		if (!this.isBaseTokenWithdrawn() & !this.getBaseToken().isWithdrawn()) {
			this.getBaseToken().withdraw();
			// NOTE: This keeps a base token that is a forked token from being
			// withdrawn more than once, since withdrawing a forked token may
			// not actually remove it from its fork node holder.
			this.setBaseTokenWithDrawn(true);
		}
		if (this.getRemainingOffersCount() > 0) {
			this.setRemainingOffersCount(this.getRemainingOffersCount() - 1);
		}
		if (this.getRemainingOffersCount() == 0) {
			super.withdraw();
		}
	}

	@Override
	public IToken copy() {
		// Return a copy of the base token.
		return this.getBaseToken().copy();
	}

	@Override
	public Boolean equals(IToken otherToken) {
		// Test if this token is equal to another token.
		return this == otherToken;
	}

	@Override
	public IValue getValue() {
		// Return the value of the base token.
		return this.getBaseToken().getValue();
	}

	public void setBaseToken(IToken baseToken) {
		this.baseToken = baseToken;
	}

	public IToken getBaseToken() {
		return this.baseToken;
	}

	public void setRemainingOffersCount(Integer count) {
		this.remainingOffersCount = count;

	}

	public Integer getRemainingOffersCount() {
		return this.remainingOffersCount;
	}

	public void setBaseTokenWithDrawn(Boolean status) {
		this.baseTokenIsWithdrawn = status;
	}

	public Boolean isBaseTokenWithdrawn() {
		return this.baseTokenIsWithdrawn;
	}
}
