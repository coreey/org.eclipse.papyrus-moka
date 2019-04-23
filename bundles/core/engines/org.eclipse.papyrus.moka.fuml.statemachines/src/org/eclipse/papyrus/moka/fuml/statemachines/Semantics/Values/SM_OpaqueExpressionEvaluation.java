/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
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
 *  Jeremie Tatibouet (CEA LIST)
 *  Arnaud Cuccuru (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Values;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.composites.Semantics.impl.Classes.Kernel.CS_OpaqueExpressionEvaluation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ICallEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications.SignalEventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.Values.ISM_OpaqueExpressionEvaluation;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Parameter;

public class SM_OpaqueExpressionEvaluation extends CS_OpaqueExpressionEvaluation implements ISM_OpaqueExpressionEvaluation {

	// The context is basically the execution context of the state-machine.
	// This provides the possibility for the behavior associated to the evaluated
	// opaque expression to access features available at the context.
	public IObject_ context;

	// Input parameters for the execution of the behavior
	protected List<IParameterValue> parameterValues;
	
	public SM_OpaqueExpressionEvaluation() {
		this.context = null;
		this.parameterValues = new ArrayList<IParameterValue>();
	}
	
	public void initialize(IEventOccurrence eventOccurrence){
		// The event occurrence that is about or is currently dispatched can
		// have data. In such situation if the behavior that is associated
		// to the OpaqueExpression input conforms with the proposed signal
		// event occurrence or the input parameters of the call event occurrence
		// then event occurrence data are passed to this behavior and used
		// to produce the guard verdict.
		this.parameterValues.clear();
		OpaqueExpression expression = (OpaqueExpression)this.specification;
		if(expression.getBehavior().getOwnedParameters().size() > 0){
			Behavior behavior = expression.getBehavior();
			if(eventOccurrence instanceof SignalEventOccurrence){
				SignalEventOccurrence signalEventOccurrence = (SignalEventOccurrence) eventOccurrence;
				if(behavior.inputParameters().size() == 1){
					Parameter parameter = behavior.inputParameters().get(0);
					IParameterValue parameterValue = new ParameterValue();
					parameterValue.setParameter(parameter);
					List<IValue> values = new ArrayList<IValue>();
					values.add(signalEventOccurrence.signalInstance);
					parameterValue.setValues(values);
					this.setParameterValue(parameterValue);
				}
			}else if(eventOccurrence instanceof ICallEventOccurrence){
				ICallEventOccurrence callEventOccurrence = (ICallEventOccurrence) eventOccurrence;
				List<Parameter> behaviorInputParameters = behavior.inputParameters();
				List<IParameterValue> inputParameterValues = callEventOccurrence.getCallEventExecution().getInputParameterValues();
				if(behaviorInputParameters.size() == inputParameterValues.size()){
					int i = 1;
					while(i <= behaviorInputParameters.size()){
						IParameterValue parameterValue = new ParameterValue();
						parameterValue.setParameter(behaviorInputParameters.get(i - 1));
						parameterValue.setValues(inputParameterValues.get(i - 1).getValues());
						this.setParameterValue(parameterValue);
						i++;
					}
				}
			}
		}
	}
	
	@Override
	public List<IValue> executeExpressionBehavior() {
		// An opaque expression can have an associated behavior. If this is the case
		// this behavior is executed. Values produced by the execution of the behavior
		// are the result of the evaluation of the opaque expression 
		List<IValue> evaluation = new ArrayList<IValue>();
		OpaqueExpression expression = (OpaqueExpression)this.specification;
		Behavior behavior = expression.getBehavior();
		if(behavior != null) {
			List<IParameterValue> results = this.locus.getExecutor().execute(behavior, context, this.parameterValues);
			for(int i = 0; i < results.size(); i++) { // results.size should be 1
				IParameterValue parameterValue = results.get(i);
				List<IValue> values = parameterValue.getValues();
				for(int j = 0; j < values.size(); j++) {
					evaluation.add(values.get(j));
				}
			}
		}
		return evaluation;
	}
	
	public void setParameterValue(IParameterValue parameterValue){
		// If this parameter value does not exist then it is added
		// to the list parameter values
		if(this.getParameterValue(parameterValue.getParameter()) == null){
			this.parameterValues.add(parameterValue);
		}
	}
	
	public IParameterValue getParameterValue(Parameter parameter){
		// Return the parameter value corresponding to the given parameter.
		// Null is returned if no parameter value associated with the parameter
		// is found.
		int i = 0;
		IParameterValue parameterValue = null;
		while(parameterValue == null && i < this.parameterValues.size()){
			if(this.parameterValues.get(i).getParameter() == parameter){
				parameterValue = this.parameterValues.get(i);
			}
			i++;
		}
		return parameterValue;
	}

	@Override
	public void setContext(IObject_ context) {
		this.context = context;
	}

	@Override
	public IObject_ getContext() {
		return this.context;
	}
}
