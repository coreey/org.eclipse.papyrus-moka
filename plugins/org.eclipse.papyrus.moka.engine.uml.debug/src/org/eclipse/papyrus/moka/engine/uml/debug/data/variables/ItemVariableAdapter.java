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

package org.eclipse.papyrus.moka.engine.uml.debug.data.variables;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;

public class ItemVariableAdapter extends UMLVariableAdapter<IValue> {

	// Index corresponding to the item
	protected int index;

	public ItemVariableAdapter(IDebugTarget target, int index, IValue value) {
		super(target, value);
		this.index = index;
	}

	@Override
	public IValue getValue() throws DebugException {
		// The adapted variable is the value associated to the item variable
		return variable;
	}

	@Override
	public String getName() throws DebugException {
		// Variable name is of the form [X] where X is an integer
		return "[" + index + "]";
	}

}
