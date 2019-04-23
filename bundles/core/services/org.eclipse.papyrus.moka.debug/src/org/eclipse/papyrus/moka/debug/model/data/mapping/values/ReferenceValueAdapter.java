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

package org.eclipse.papyrus.moka.debug.model.data.mapping.values;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.debug.engine.MokaDebugTarget;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;

public class ReferenceValueAdapter extends MokaValueAdapter<IReference> {

	public ReferenceValueAdapter(MokaDebugTarget debugTarget, IReference adaptedObject) {
		super(debugTarget, adaptedObject);
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		// Create a value adapter for the referent object and return
		// that variables that can be accessed through this latter.
		MokaValueAdapter<?> adapter = MokaValueAdapterFactory.getInstance().instantiate(this.adaptedObject.getReferent(), this.debugTarget);
		return adapter.getVariables();
	}
	
	@Override
	public String getValueString() throws DebugException {
		// The representation of the value as string is given by the identifier
		// of the referent object.
		if(this.adaptedObject.getReferent() != null) {
			return this.adaptedObject.getReferent().getIdentifier();
		}
		return "";
	}

}
