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
import org.eclipse.papyrus.moka.debug.model.data.mapping.values.MokaValueAdapterFactory;
import org.eclipse.papyrus.moka.debug.model.data.mapping.values.MokaValueAdapterList;
import org.eclipse.papyrus.moka.debug.model.data.mapping.values.DefaultValueAdapter;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;

public class ParameterValueVariableAdapter extends MokaVariableAdapter<IParameterValue> {
	
	// User defined name
	protected String parameterName;

	public ParameterValueVariableAdapter(MokaDebugTarget debugTarget, IParameterValue parameterValue) {
		super(debugTarget, parameterValue);
	}
	
	public ParameterValueVariableAdapter(MokaDebugTarget debugTarget, IParameterValue parameterValue, String parameterName) {
		this(debugTarget, parameterValue);
		this.parameterName = parameterName;
	}

	@Override
	public IValue getValue() throws DebugException {
		// Return the value adapter required to display the value associated
		// to the parameter
		if (this.value == null) {
			if (this.adaptedVariable.getValues().size() == 1) {
				this.value = MokaValueAdapterFactory.getInstance()
						.instantiate(this.adaptedVariable.getValues().iterator().next(), debugTarget);
			} else if (this.adaptedVariable.getValues().size() > 1) {
				MokaValueAdapterList valueList = new MokaValueAdapterList(debugTarget);
				for (org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue currentValue : this.adaptedVariable
						.getValues()) {
					valueList.add(currentValue);
				}
				this.value = valueList;
			} else {
				this.value = new DefaultValueAdapter(debugTarget, null);
			}
		}
		return this.value;
	}

	@Override
	public String getName() throws DebugException {
		// If the user defined parameter name is set then return it.
		// If the user defined parameter name is not set the return
		// the name of the parameter attached to the parameter value.
		// If no name could be returned then the string '<empty>' is returned
		if(this.parameterName != null && !this.parameterName.isEmpty()) {
			return this.parameterName;
		}else if(this.adaptedVariable.getParameter() != null
				&& adaptedVariable.getParameter().getName() != null
				&& !adaptedVariable.getParameter().getName().isEmpty()) {
			return this.adaptedVariable.getParameter().getName();
		}
		return "<empty>";
	}

}
