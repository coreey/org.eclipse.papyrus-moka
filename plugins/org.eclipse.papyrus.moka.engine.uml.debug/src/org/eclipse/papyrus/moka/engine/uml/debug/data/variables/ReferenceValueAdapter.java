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

package org.eclipse.papyrus.moka.engine.uml.debug.data.variables;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IReference;

public class ReferenceValueAdapter extends UMLValueAdapter<IReference> {

	public ReferenceValueAdapter(IDebugTarget debugTarget, IReference adaptedObject) {
		super(debugTarget, adaptedObject);
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		// Create a value adapter for the referent object and return
		// that variables that can be accessed through this latter.
		UMLValueAdapter<?> adapter = UMLValueAdapterFactory.getInstance().instantiate(value.getReferent(), getDebugTarget());
		return adapter.getVariables();
	}
	
	@Override
	public String getValueString() throws DebugException {
		// The representation of the value as string is given by the identifier
		// of the referent object.
		if(value.getReferent() != null) {
			return value.getReferent().getIdentifier();
		}
		return "";
	}

}
