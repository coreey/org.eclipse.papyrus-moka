/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
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
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IValue;
import org.eclipse.papyrus.moka.kernel.scheduling.control.IExecutionLoop;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.StateMachine;

public class UMLRootExecution extends UMLTaskExecution implements IUMLRootExecution{

	/**
	 * Model element considered as the root of the execution
	 */
	protected Class root;

	/**
	 * Root execution parameter values
	 */
	protected List<IParameterValue> parameterValues;

	public UMLRootExecution(IExecutionLoop loop) {
		super(loop);
		parameterValues = new ArrayList<IParameterValue>();
	}

	/**
	 * 
	 */
	@Override
	public void setRoot(Class r) {
		root = r;
	}

	/**
	 * @see {@linkIExecution#setParameterValue(IParameterValue)}
	 */
	@Override
	public Class getRoot() {
		return root;
	}

	@Override
	public boolean canExecute() {
		if (root != null) {
			if (!root.isAbstract()) {
				if (isBehavior()) {
					if (root instanceof Activity) {
						return true;
					} else
						return root instanceof StateMachine && root.isActive();
				}
			} else if (root instanceof Class) {
				return root.isActive();
			}
		}
		return false;
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

	private boolean isBehavior() {
		return root instanceof Behavior;
	}

	/**
	 * see {@link IExecution#execute()}
	 * 
	 * Execution of the root takes place in two situations: (1) the root is active -
	 * it is either a behavior or a class (2) the root is a behavior Output
	 * parameter values may only be returned if (2) occurs.
	 */
	@Override
	public void execute() {
		if (root != null) {
			if (root.isActive()) {
				locus.getExecutor().start(root, parameterValues);
			} else if (isBehavior()) {
				List<IParameterValue> outputParameterValues = locus.getExecutor().execute((Behavior) root, null,
						parameterValues);
				for (IParameterValue outputParameterValue : outputParameterValues) {
					setParameterValue(outputParameterValue);
				}
			}
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
	public IValue new_() {
		IUMLRootExecution rootExecution = new UMLRootExecution(executionLoop);
		rootExecution.setRoot(root);
		return rootExecution;
	}

	@Override
	public String toString() {
		return "RootExecution()";
	}

}
