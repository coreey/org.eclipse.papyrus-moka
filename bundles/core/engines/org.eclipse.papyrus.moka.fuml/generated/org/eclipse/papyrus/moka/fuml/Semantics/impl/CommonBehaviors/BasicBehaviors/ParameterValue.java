/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;

import org.eclipse.uml2.uml.Parameter;

public class ParameterValue implements IParameterValue {

	public Parameter parameter;

	/*
	 * The values of for the parameter. Zero or more values are possible, as
	 * constrained by the multiplicity of the parameter.
	 */
	public List<IValue> values = new ArrayList<IValue>();

	public IParameterValue copy() {
		// Create a new parameter value for the same parameter as this parameter
		// value, but with copies of the values of this parameter value.
		ParameterValue newValue = new ParameterValue();
		newValue.parameter = this.parameter;
		List<IValue> values = this.values;
		for (int i = 0; i < values.size(); i++) {
			IValue value = values.get(i);
			newValue.values.add(value.copy());
		}
		return newValue;
	}

	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}

	public Parameter getParameter() {
		return this.parameter;
	}

	public List<IValue> getValues() {
		return this.values;
	}

	public void setValues(List<IValue> values) {
		this.values = values;
	}
}
