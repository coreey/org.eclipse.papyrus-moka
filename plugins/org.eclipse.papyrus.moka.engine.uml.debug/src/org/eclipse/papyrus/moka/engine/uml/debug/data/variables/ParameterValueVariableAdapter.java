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
import org.eclipse.papyrus.moka.engine.uml.debug.data.values.DefaultValueAdapter;
import org.eclipse.papyrus.moka.engine.uml.debug.data.values.MokaValueAdapterList;
import org.eclipse.papyrus.moka.engine.uml.debug.data.values.UMLValueAdapterFactory;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IParameterValue;

public class ParameterValueVariableAdapter extends UMLVariableAdapter<IParameterValue> {
	
	// User defined name
	protected String parameterName;

	public ParameterValueVariableAdapter(IDebugTarget debugTarget, IParameterValue parameterValue) {
		super(debugTarget, parameterValue);
	}
	
	public ParameterValueVariableAdapter(IDebugTarget debugTarget, IParameterValue parameterValue, String parameterName) {
		this(debugTarget, parameterValue);
		this.parameterName = parameterName;
	}

	@Override
	public IValue getValue() throws DebugException {
		// Return the value adapter required to display the value associated
		// to the parameter
		if (this.value == null) {
			if (this.variable.getValues().size() == 1) {
				value = UMLValueAdapterFactory.getInstance()
						.instantiate(variable.getValues().iterator().next(), getDebugTarget());
			} else if (variable.getValues().size() > 1) {
				MokaValueAdapterList valueList = new MokaValueAdapterList(getDebugTarget());
				for (org.eclipse.papyrus.moka.fuml.simpleclassifiers.IValue currentValue : variable
						.getValues()) {
					valueList.add(currentValue);
				}
				this.value = valueList;
			} else {
				this.value = new DefaultValueAdapter(getDebugTarget(), null);
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
		}else if(variable.getParameter() != null
				&& variable.getParameter().getName() != null
				&& variable.getParameter().getName().isEmpty()) {
			return variable.getParameter().getName();
		}
		return super.getName();
	}

}
