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
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.CompleteActions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.ReduceAction;

public class ReduceActionActivation extends ActionActivation {

	/*
	 * The current execution of the reducer behavior.
	 */
	public IExecution currentExecution;

	@Override
	public void doAction() {
		// Get the values of the collection input pin.
		// If the input pin has no values, then do nothing. Otherwise, do the
		// following.
		// Repeatedly invoke the reducer behavior on successive pairs to reduce
		// the collection to a single value, and place that value on the result
		// pin.
		// To invoke the reducer behavior, compile it to create an execution,
		// make the execution the current execution, place the appropriate
		// values on its input parameters, and execute it.
		ReduceAction action = (ReduceAction) (this.node);
		List<IValue> values = this.takeTokens(action.getCollection());
		if (values.size() > 0) {
			List<Parameter> parameters = action.getReducer().getOwnedParameters();
			Parameter input1 = null;
			Parameter input2 = null;
			Parameter output = null;
			int i = 1;
			while (i <= parameters.size()) {
				Parameter parameter = parameters.get(i - 1);
				if (parameter.getDirection() == ParameterDirectionKind.IN_LITERAL) {
					if (input1 == null) {
						input1 = parameter;
					} else {
						input2 = parameter;
					}
				} else if (parameter.getDirection() == ParameterDirectionKind.OUT_LITERAL | parameter.getDirection() == ParameterDirectionKind.RETURN_LITERAL) {
					output = parameter;
				}
				i = i + 1;
			}
			ParameterValue parameterValue1 = new ParameterValue();
			parameterValue1.parameter = input1;
			parameterValue1.values = new ArrayList<IValue>();
			parameterValue1.values.add(values.get(0));
			int j = 2;
			while (j <= values.size()) {
				this.currentExecution = this.getExecutionLocus().getFactory().createExecution(action.getReducer(), this.getExecutionContext());
				this.currentExecution.setParameterValue(parameterValue1);
				ParameterValue parameterValue2 = new ParameterValue();
				parameterValue2.parameter = input2;
				parameterValue2.values = new ArrayList<IValue>();
				parameterValue2.values.add(values.get(j - 1));
				this.currentExecution.setParameterValue(parameterValue2);
				this.currentExecution.execute();
				parameterValue1.values = this.currentExecution.getParameterValue(output).getValues();
				j = j + 1;
				if (parameterValue1.values.isEmpty() & j <= values.size()) {
					parameterValue1.values.add(values.get(j - 1));
					j = j + 1;
				}
			}
			this.putTokens(action.getResult(), parameterValue1.values);
		}
	}

	@Override
	public void terminate() {
		// If there is a current execution, terminate it. Then terminate self.
		if (this.currentExecution != null) {
			this.currentExecution.terminate();
		}
		super.terminate();
	}
}
