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
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IValue;

public class ObjectTokenVariableValueAdapter extends UMLVariableAdapter<IValue> {

	private final String NAME = "value";
	
	public ObjectTokenVariableValueAdapter(IDebugTarget target, IValue heldValue) {
		super(target, heldValue);
	}

	@Override
	public String getName() throws DebugException {
		// Return the variable name
		return NAME;
	}

}
