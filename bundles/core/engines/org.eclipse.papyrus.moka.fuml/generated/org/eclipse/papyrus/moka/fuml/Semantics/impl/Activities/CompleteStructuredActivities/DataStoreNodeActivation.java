/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
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

package org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.CompleteStructuredActivities;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.CentralBufferNodeActivation;

public class DataStoreNodeActivation extends CentralBufferNodeActivation{
	
	@Override
	public void addToken(IToken token) {
		// Add the given token to the data store only if it is unique,
		// that is, if its value is not the same as the value of
		// another token already held in the data store.
		IValue value = token.getValue();
		boolean isUnique = true;
		if (value != null) {
			List<IToken> heldTokens = this.getTokens();
			int i = 1;
			while (isUnique & i <= heldTokens.size()) {
				isUnique = !heldTokens.get(i-1).getValue().equals(value);
				i = i + 1;
			}
		}
		if (isUnique) {
			super.addToken(token);
		}
	}
	
	@Override
	public Integer removeToken(IToken token) {
		// Remove the given token from the data store, but then immediately 
		// add a copy back into the data store and offer it (unless the
		// node activation has already been terminated).
		int i = super.removeToken(token);
		if (this.isRunning()) {
			super.addToken(token.copy());
			this.sendUnofferedTokens();
		}
		return i;
	}
	
}
