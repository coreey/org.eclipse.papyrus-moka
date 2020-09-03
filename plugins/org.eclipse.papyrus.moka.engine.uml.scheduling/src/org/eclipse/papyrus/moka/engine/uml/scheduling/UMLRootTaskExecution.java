/*****************************************************************************
 * Copyright (c) 2019, 2020 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.moka.engine.uml.scheduling;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.commonbehavior.IExecution;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IParameterValue;
import org.eclipse.papyrus.moka.fuml.tasks.IUMLRootTaskExecution;
import org.eclipse.papyrus.moka.kernel.scheduling.control.IExecutionLoop;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;

public abstract class UMLRootTaskExecution<RootElementType extends Element> extends UMLTaskExecution implements IUMLRootTaskExecution<RootElementType>{

	/**
	 * Model element from which the execution starts
	 */
	protected RootElementType root;

	/**
	 * Root execution parameter values
	 */
	protected List<IParameterValue> parameterValues;

	public UMLRootTaskExecution(IExecutionLoop loop, RootElementType executionRoot) {
		super(loop);
		root = executionRoot;
		parameterValues = new ArrayList<IParameterValue>();
	}

	@Override
	public RootElementType getRoot() {
		return root;
	}
	
	/***
	 * @see {@link IExecution#setParameterValue(IParameterValue)}
	 * 
	 *      Set the given parameter value for this execution. If a parameter value
	 *      already existed for the parameter of the given parameter value, then
	 *      replace its value.
	 */
	public void setParameterValue(IParameterValue parameterValue) {
		//
		IParameterValue existingParameterValue = this.getParameterValue(parameterValue.getParameter());
		if (existingParameterValue == null) {
			parameterValues.add(parameterValue);
		} else {
			existingParameterValue.setValues(parameterValue.getValues());
		}
	}

	/**
	 * @see {@link IExecution#getReturnParameterValue()}
	 * 
	 *      Return the parameter value for the return parameter (if any)
	 */
	public IParameterValue getReturnParameterValue() {
		IParameterValue value = null;
		int i = 0;
		while (value == null && i < parameterValues.size()) {
			Parameter parameter = parameterValues.get(i).getParameter();
			if (parameter.getDirection() == ParameterDirectionKind.RETURN_LITERAL) {
				value = this.getParameterValues().get(i);
			}
			i++;
		}
		return value;
	}

	/**
	 * @see {@link IExecution#getParameterValue(Parameter)}
	 * 
	 *      Return the value associated with the specified parameter
	 */
	public IParameterValue getParameterValue(Parameter parameter) {
		IParameterValue parameterValue = null;
		int i = 1;
		while (parameterValue == null & i <= parameterValues.size()) {
			if (this.getParameterValues().get(i - 1).getParameter() == parameter) {
				parameterValue = this.getParameterValues().get(i - 1);
			}
			i = i + 1;
		}
		return parameterValue;
	}

	/**
	 * @see {@link IExecution#getOutputParameterValues()}
	 * 
	 *      Return values for output parameters
	 */
	public List<IParameterValue> getOutputParameterValues() {
		List<IParameterValue> outputs = new ArrayList<IParameterValue>();
		for (int i = 0; i < parameterValues.size(); i++) {
			IParameterValue parameterValue = parameterValues.get(i);
			Parameter parameter = parameterValue.getParameter();
			if ((parameter.getDirection() == ParameterDirectionKind.INOUT_LITERAL)
					| (parameter.getDirection() == ParameterDirectionKind.OUT_LITERAL)
					| (parameter.getDirection() == ParameterDirectionKind.RETURN_LITERAL)) {
				outputs.add(parameterValue);
			}
		}
		return outputs;
	}

	/**
	 * @see {@link IExecution#getParameterValues()}
	 * 
	 *      Return parameter values
	 */
	public List<IParameterValue> getParameterValues() {
		return this.parameterValues;
	}

	/**
	 * @see {@link IUMLRootExecution#setInputParameterValues(List)}
	 */
	public void setInputParameterValues(List<IParameterValue> inputParameterValues) {
		for (IParameterValue inputParameterValue : inputParameterValues) {
			setParameterValue(inputParameterValue);
		}
	}
	
	@Override
	public void suspend() {
		// TODO - Wrapped execution shall be suspended
	}
	
	public void terminate() {
		// TODO - Wrapped execution shall be destroyed
	}

	@Override
	public String toString() {
		return "RootExecution()"; //$NON-NLS-1$
	}

}
