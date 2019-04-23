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
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.debug.engine.MokaDebugElement;
import org.eclipse.papyrus.moka.debug.engine.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.model.data.mapping.values.MokaValueAdapter;
import org.eclipse.papyrus.moka.debug.model.data.mapping.values.MokaValueAdapterFactory;

public abstract class MokaVariableAdapter<V> extends MokaDebugElement implements IVariable {

	// The value that is currently associated to this variable
	protected MokaValueAdapter<?> value;

	// The variable that is actually represented
	protected V adaptedVariable;
	
	public MokaVariableAdapter(MokaDebugTarget debugTarget, V adaptedVariable) {
		super(debugTarget);
		this.adaptedVariable = adaptedVariable;
	}
	
	@Override
	public IValue getValue() throws DebugException {
		// Getting the value corresponding to a variable may require more sophisticated
		// computations however the common approach is to directly requests from
		// the value adapter factory if an adapter already exist for the value
		// associated to the variable.
		if(this.value == null) {
			this.value = MokaValueAdapterFactory.getInstance().instantiate(this.adaptedVariable, this.debugTarget);
		}
		return this.value;
	}
	
	@Override
	public String getReferenceTypeName() throws DebugException {
		// By default the reference type of the variable is
		// considered to unknown.
		return "<no reference type>";
	}

	@Override
	public boolean hasValueChanged() throws DebugException {
		// By default no change on the variable is allowed.
		return false;
	}

	@Override
	public void setValue(String expression) throws DebugException {
		// By default it is not allowed to change a variable
		// value through the evaluation of an expression
	}

	@Override
	public void setValue(IValue value) throws DebugException {
		// By default it is not allowed to substitute the
		// variable value with another value
	}

	@Override
	public boolean supportsValueModification() {
		// By default no modification of the variable value
		// is allowed
		return false;
	}

	@Override
	public boolean verifyValue(String expression) throws DebugException {
		// By default its not allowed to change the variable value.
		// Hence it is not required to be able to verify the specified
		// change.
		return false;
	}

	@Override
	public boolean verifyValue(IValue value) throws DebugException {
		// By default its not allowed to change the variable value.
		// Hence it is not required to be able to verify the specified
		// change.
		return false;
	}
	
	public V getAdapted() {
		// Return the object being adapted as a variable
		return this.adaptedVariable;
	}
	
}
