/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
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

package org.eclipse.papyrus.moka.debug.model.data.mapping.variables;

import java.util.Iterator;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.papyrus.moka.debug.engine.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.model.data.mapping.values.MokaValueAdapterList;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;

public class TokensVariableAdapter extends MokaVariableAdapter<List<IToken>> {

	private final String NAME = "tokens";

	public TokensVariableAdapter(MokaDebugTarget debugTarget, List<IToken> tokens) {
		super(debugTarget, tokens);
	}

	@Override
	public IValue getValue() throws DebugException {
		// The value adapter corresponding to a list of token consist in a list
		// of adapter. Each adapter in the list is an adapter for a token.
		if (this.value == null) {
			MokaValueAdapterList tokensList = new MokaValueAdapterList(debugTarget);
			Iterator<IToken> tokensIterator = this.adaptedVariable.iterator();
			while (tokensIterator.hasNext()) {
				tokensList.add(tokensIterator.next());
			}
			this.value = tokensList;
		}
		return this.value;
	}

	@Override
	public String getName() throws DebugException {
		// Return the variable name
		return this.NAME;
	}

}
