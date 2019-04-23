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

package org.eclipse.papyrus.moka.debug.model.data.mapping.values;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.debug.engine.MokaDebugElement;
import org.eclipse.papyrus.moka.debug.engine.MokaDebugTarget;

public abstract class MokaValueAdapter<T> extends MokaDebugElement implements IValue {

	// The object that is adapted through this adapter
	protected T adaptedObject;
	
	// The list of variables that can be accessed through the adapted object
	protected List<IVariable> variables;

	public MokaValueAdapter(MokaDebugTarget debugTarget, T adaptedObject) {
		super(debugTarget);
		this.adaptedObject = adaptedObject;
		this.variables = new ArrayList<IVariable>();
	}

	@Override
	public String getReferenceTypeName() throws DebugException {
		// No value adapter could handle the object to be adapted.
		// Hence the default value adapter is used.
		return "<no reference type>";
	}
	
	@Override
	public boolean isAllocated() throws DebugException {
		// An adapted object is always considered as being allocated
		return true;
	}

	@Override
	public boolean hasVariables() throws DebugException {
		// A value adapter has variables if the array returned
		// by the getVariable method is not empty
		return this.getVariables().length > 0;
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		// Return the list of variables as an array
		return this.variables.toArray(new IVariable[0]);
	}
	
	public T getAdapted() {
		// Return a reference on the adapted object
		return this.adaptedObject;
	}
}
