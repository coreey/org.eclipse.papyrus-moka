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

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.papyrus.moka.debug.engine.MokaDebugTarget;

public class ItemVariableAdapter extends MokaVariableAdapter<IValue> {

	// Index corresponding to the item
	protected int index;

	public ItemVariableAdapter(MokaDebugTarget debugTarget, int index, IValue value) {
		super(debugTarget, value);
		this.index = index;
	}

	@Override
	public IValue getValue() throws DebugException {
		// The adapted variable is the value associated to the item variable
		return this.adaptedVariable;
	}

	@Override
	public String getName() throws DebugException {
		// Variable name is an of the form [X] where X is an integer
		return "[" + index + "]";
	}

}
