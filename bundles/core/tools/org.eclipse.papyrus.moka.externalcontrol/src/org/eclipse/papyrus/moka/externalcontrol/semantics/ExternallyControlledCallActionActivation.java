/*****************************************************************************
 * 
 * Copyright (c) 2017 CEA LIST.
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
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.externalcontrol.semantics;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.externalcontrol.advice.IControllerAdvice;
import org.eclipse.papyrus.moka.externalcontrol.controller.ExternalController;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.ICallActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.CallActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.uml2.uml.CallAction;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;

public class ExternallyControlledCallActionActivation extends AbstractExternallyControlledActionActivation<CallActionActivation> implements ICallActionActivation {


	public ExternallyControlledCallActionActivation(CallActionActivation visitor, ExternalController controller, List<IControllerAdvice> advices) {
		super(visitor, controller, advices);
	}

	

	/*
	 * The set of execution object for currently ongoing calls made through this
	 * call action activation.
	 */
	public List<IExecution> callExecutions = new ArrayList<IExecution>();
	
	private IExecution suspendedExecution;
	
	@Override
	protected void doSemanticAction() {
		doAction();
	}

	
	 @Override
	public void doAction() {
		// Get the call execution object, set its input parameters from the
			// argument pins and execute it.
			// Once execution completes, copy the values of the output parameters of
			// the call execution to the result pins of the call action execution,
			// then destroy the execution.
			IExecution callExecution = this.getCallExecution();
			if (callExecution != null) {
				this.callExecutions.add(callExecution);
				
				CallAction callAction = (CallAction) (this.getNode());
				List<InputPin> argumentPins = callAction.getArguments();
				List<Parameter> parameters = callExecution.getBehavior().getOwnedParameters();
				int pinNumber = 1;
				int i = 1;
				while (i <= parameters.size()) {
					Parameter parameter = parameters.get(i - 1);
					if (parameter.getDirection() == ParameterDirectionKind.IN_LITERAL | parameter.getDirection() == ParameterDirectionKind.INOUT_LITERAL) {
						ParameterValue parameterValue = new ParameterValue();
						parameterValue.parameter = parameter;
						parameterValue.values = this.takeTokens(argumentPins.get(pinNumber - 1));
						callExecution.setParameterValue(parameterValue);
						pinNumber = pinNumber + 1;
					}
					i = i + 1;
				}
			
				callExecution.execute();
				suspendedExecution = callExecution;
			}
	}
	
	
	
	@Override
	public void doResumeExecution() {

		
		CallAction callAction = (CallAction) (this.getNode());
		List<OutputPin> resultPins = callAction.getResults();
		List<Parameter> parameters = suspendedExecution.getBehavior().getOwnedParameters();
		List<IParameterValue> outputParameterValues = suspendedExecution.getOutputParameterValues();
		int pinNumber = 1;
		int i = 1;
		while (i <= parameters.size()) {
			Parameter parameter = parameters.get(i - 1);
			if ((parameter.getDirection() == ParameterDirectionKind.INOUT_LITERAL) | (parameter.getDirection() == ParameterDirectionKind.OUT_LITERAL) | (parameter.getDirection() == ParameterDirectionKind.RETURN_LITERAL)) {
				for (int j = 0; j < outputParameterValues.size(); j++) {
					IParameterValue outputParameterValue = outputParameterValues.get(j);
					if (outputParameterValue.getParameter() == parameter) {
						OutputPin resultPin = resultPins.get(pinNumber - 1);
						this.putTokens(resultPin, outputParameterValue.getValues());
					}
				}
				pinNumber = pinNumber + 1;
			}
			i = i + 1;
		}

		suspendedExecution.destroy();
		this.removeCallExecution(suspendedExecution);
		suspendedExecution = null;
		
		// FIXME completeAction should probably move to IActionActivation
		List<IToken> incomingTokens = delegatedVisitor.completeAction();
		if (incomingTokens.size() > 0) {
			this.fire(incomingTokens);
		}
		// TODO clarify if resume should be called before or after complete action...
		this.resume();
		
	}

	@Override
	public IExecution getCallExecution() {
		IExecution execution = delegatedVisitor.getCallExecution();
		callExecutions.add(execution);
		
		if (execution instanceof ExternallyControlledActivityExecution){
			((ExternallyControlledActivityExecution)execution).setStackParent(this);
		}
		return execution; 
				
	}

	@Override
	public void removeCallExecution(IExecution execution) {
		delegatedVisitor.removeCallExecution(execution);
		callExecutions.remove(execution);
		
	}



}
