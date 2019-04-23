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

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Object_;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;

public abstract class Execution extends Object_ implements IExecution {

	/*
	 * The object that provides the context for this execution. The type of the
	 * context of the execution must be the context of the type (behavior) of
	 * the execution.
	 */
	public IObject_ context;

	/*
	 * The parameterValues for this execution. All parameterValues must have a
	 * parameter that is a parameter of the type of this execution. The values
	 * of all input (in and in-out) parameters must be set before the execution
	 * is executed.
	 */
	public List<IParameterValue> parameterValues = new ArrayList<IParameterValue>();

	public abstract void execute();

	public void terminate() {
		// Terminate an ongoing execution. By default, do nothing.
		return;
	}

	@Override
	public IValue copy() {
		// Create a new execution that has the same behavior and parameterValues
		// as this execution.
		// Debug.println("[Copy] execution = " + this);
		IExecution newValue = (IExecution) (super.copy());
		newValue.setContext(this.getContext());
		List<IParameterValue> parameterValues = this.getParameterValues();
		for (int i = 0; i < parameterValues.size(); i++) {
			IParameterValue parameterValue = parameterValues.get(i);
			newValue.getParameterValues().add(parameterValue.copy());
		}
		// Debug.println("[Copy] Done.");
		return newValue;
	}

	@Override
	public abstract IValue new_();

	public void setParameterValue(IParameterValue parameterValue) {
		// Set the given parameter value for this execution.
		// If a parameter value already existed for the parameter of the given
		// parameter value, then replace its value.
		// Debug.println("[setParameterValue] parameter = " +
		// parameterValue.parameter.name + " with " +
		// parameterValue.values.size() + " values");
		IParameterValue existingParameterValue = this.getParameterValue(parameterValue.getParameter());
		if (existingParameterValue == null) {
			this.getParameterValues().add(parameterValue);
		} else {
			existingParameterValue.setValues(parameterValue.getValues());
		}
	}

	public IParameterValue getReturnParameterValue() {
		IParameterValue value = null;
		int i = 0;
		while (value == null && i < this.getParameterValues().size()) {
			Parameter parameter = this.getParameterValues().get(i).getParameter();
			if (parameter.getDirection() == ParameterDirectionKind.RETURN_LITERAL) {
				value = this.getParameterValues().get(i);
			}
			i++;
		}
		return value;
	}

	public IParameterValue getParameterValue(Parameter parameter) {
		// Get the parameter value of this execution corresponding to the given
		// parameter (if any).
		IParameterValue parameterValue = null;
		int i = 1;
		while (parameterValue == null & i <= this.getParameterValues().size()) {
			if (this.getParameterValues().get(i - 1).getParameter() == parameter) {
				parameterValue = this.getParameterValues().get(i - 1);
			}
			i = i + 1;
		}
		return parameterValue;
	}

	public List<IParameterValue> getOutputParameterValues() {
		// Return the parameter values for output (in-out, out and return)
		// parameters.
		List<IParameterValue> outputs = new ArrayList<IParameterValue>();
		List<IParameterValue> parameterValues = this.getParameterValues();
		for (int i = 0; i < parameterValues.size(); i++) {
			IParameterValue parameterValue = parameterValues.get(i);
			Parameter parameter = parameterValue.getParameter();
			if ((parameter.getDirection() == ParameterDirectionKind.INOUT_LITERAL) | (parameter.getDirection() == ParameterDirectionKind.OUT_LITERAL) | (parameter.getDirection() == ParameterDirectionKind.RETURN_LITERAL)) {
				outputs.add(parameterValue);
			}
		}
		return outputs;
	}

	public Behavior getBehavior() {
		// Get the behavior that is the type of this execution.
		return (Behavior) (this.getTypes().get(0));
	}

	public void setContext(IObject_ context) {
		this.context = context;
	}

	public IObject_ getContext() {
		return this.context;
	}

	public List<IParameterValue> getParameterValues() {
		return this.parameterValues;
	}
}
