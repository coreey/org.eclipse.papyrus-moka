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
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.engine.uml.debug.data.values.UMLDebugElement;
import org.eclipse.papyrus.moka.engine.uml.debug.data.values.UMLValueAdapter;
import org.eclipse.papyrus.moka.engine.uml.debug.data.values.UMLValueAdapterFactory;

public abstract class UMLVariableAdapter<VariableType> extends UMLDebugElement implements IVariable {

	/**
	 * The value that is currently associated to this variable
	 */
	protected UMLValueAdapter<?> value;

	/**
	 * Variable that is adapted as an IVariable
	 */
	protected VariableType variable;
	
	public UMLVariableAdapter(IDebugTarget debugTarget, VariableType var) {
		super(debugTarget);
		variable = var;
	}
	
	@Override
	public IValue getValue() throws DebugException {
		// Getting the value corresponding to a variable may require more sophisticated
		// computations however the common approach is to directly requests from
		// the value adapter factory if an adapter already exist for the value
		// associated to the variable.
		if(this.value == null) {
			this.value = UMLValueAdapterFactory.getInstance().instantiate(variable, getDebugTarget());
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
	
	public VariableType getAdapted() {
		// Return the object being adapted as a variable
		return variable;
	}
	
	@Override
	public String getName() throws DebugException {
		return "";
	}
	
}
