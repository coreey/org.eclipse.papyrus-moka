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

import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;

public abstract class Token implements IToken {

	public IActivityNodeActivation holder;

	public IToken transfer(IActivityNodeActivation holder) {
		// if this token does not have any holder, make the given holder its
		// holder.
		// Otherwise, remove this token from its holder and return a copy of it
		// transfered to a new holder.
		IToken token = this;
		if (this.getHolder() != null) {
			this.withdraw();
			token = this.copy();
		}
		token.setHolder(holder);
		return token;
	}

	public void withdraw() {
		// Remove this token from its holder, withdrawing any offers for it.
		if (!this.isWithdrawn()) {
			// Debug.println("[withdraw] Taking token with value = " +
			// this.getValue());
			this.getHolder().removeToken(this);
			this.setHolder(null);
		}
	}

	public abstract Boolean equals(IToken other);

	public abstract IToken copy();

	public Boolean isWithdrawn() {
		// Test if this token has been withdrawn.
		return this.getHolder() == null;
	}

	public abstract Boolean isControl();

	public abstract IValue getValue();

	public void setHolder(IActivityNodeActivation holder) {
		this.holder = holder;
	}

	public IActivityNodeActivation getHolder() {
		return this.holder;
	}
}
