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
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IDecisionNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.BooleanValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.ObjectFlow;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.ValueSpecification;

public class DecisionNodeActivation extends ControlNodeActivation implements IDecisionNodeActivation {

	/*
	 * The current execution of the decision input behavior (if any).
	 */
	public IExecution decisionInputExecution;

	@Override
	public void fire(List<IToken> incomingTokens) {
		// Get the decision values and test them on each guard.
		// Forward the offer over the edges for which the test succeeds.
		Debug.println("[fire] Decision node " + this.node.getName() + "...");
		// List<Token> incomingTokens = this.takeOfferedTokens();
		List<IToken> removedControlTokens = this.removeJoinedControlTokens(incomingTokens);
		List<IValue> decisionValues = this.getDecisionValues(incomingTokens);
		List<IActivityEdgeInstance> outgoingEdges = this.getOutgoingEdges();
		for (int i = 0; i < outgoingEdges.size(); i++) {
			IActivityEdgeInstance edgeInstance = outgoingEdges.get(i);
			ValueSpecification guard = edgeInstance.getEdge().getGuard();
			List<IToken> offeredTokens = new ArrayList<IToken>();
			for (int j = 0; j < incomingTokens.size(); j++) {
				IToken incomingToken = incomingTokens.get(j);
				IValue decisionValue = decisionValues.get(j);
				if (this.test(guard, decisionValue)) {
					offeredTokens.add(incomingToken);
				}
			}
			if (offeredTokens.size() > 0) {
				for (int j = 0; j < removedControlTokens.size(); j++) {
					IToken removedControlToken = removedControlTokens.get(j);
					offeredTokens.add(removedControlToken);
				}
				edgeInstance.sendOffer(offeredTokens);
			}
		}
	}

	public List<IValue> getDecisionValues(List<IToken> incomingTokens) {
		// If there is neither a decision input flow nor a decision input
		// behavior, then return the set of values from the incoming tokens.
		// [In this case, the single incoming edge must be an object flow.]
		// If there is a decision input flow, but no decision input behavior,
		// then return a list of the decision input values equal in size to the
		// number of incoming tokens.
		// If there is both a decision input flow and a decision input behavior,
		// then execute the decision input behavior once for each incoming token
		// and return the set of resulting values.
		// If the primary incoming edge is an object flow, then the value on
		// each object token is passed to the decision input behavior, along
		// with the decision input flow value, if any.
		// If the primary incoming edge is a control flow, then the decision
		// input behavior only receives the decision input flow, if any.
		IValue decisionInputValue = this.getDecisionInputFlowValue();
		List<IValue> decisionValues = new ArrayList<IValue>();
		for (int i = 0; i < incomingTokens.size(); i++) {
			IToken incomingToken = incomingTokens.get(i);
			IValue value = this.executeDecisionInputBehavior(incomingToken.getValue(), decisionInputValue);
			decisionValues.add(value);
		}
		// Debug.println("[getDecisionValues] " + decisionValues.size() +
		// " decision value(s):");
		for (int i = 0; i < decisionValues.size(); i++) {
			IValue decisionValue = decisionValues.get(i);
			Debug.println("[getDecisionValues] decisionValues[" + i + "] = " + decisionValue);
		}
		return decisionValues;
	}

	public IValue executeDecisionInputBehavior(IValue inputValue, IValue decisionInputValue) {
		// Create the decision input execution from the decision input behavior.
		// If the behavior has input parameter(s), set the input parameter(s) of
		// the execution to the given value(s).
		// Execute the decision input execution and then remove it.
		// Return the value of the output parameter of the execution.
		// If there is no decision input behavior, the decision input value is
		// returned, if one is given, otherwise the input value is used as the
		// decision value.
		Debug.println("[executeDecisionBehavior] inputValue = " + inputValue);
		Behavior decisionInputBehavior = ((DecisionNode) (this.node)).getDecisionInput();
		IValue decisionInputResult = null;
		if (decisionInputBehavior == null) {
			if (decisionInputValue != null) {
				decisionInputResult = decisionInputValue;
			} else {
				decisionInputResult = inputValue;
			}
		} else {
			this.decisionInputExecution = this.getExecutionLocus().getFactory().createExecution(decisionInputBehavior, this.getExecutionContext());
			int i = 1;
			int j = 0;
			while ((j == 0 | (j == 1 & decisionInputValue != null)) & i <= decisionInputBehavior.getOwnedParameters().size()) {
				Parameter parameter = decisionInputBehavior.getOwnedParameters().get(i - 1);
				if (parameter.getDirection().equals(ParameterDirectionKind.IN_LITERAL) | parameter.getDirection().equals(ParameterDirectionKind.INOUT_LITERAL)) {
					ParameterValue inputParameterValue = new ParameterValue();
					inputParameterValue.parameter = parameter;
					j = j + 1;
					if (j == 1 && inputValue != null) {
						inputParameterValue.values.add(inputValue);
					} else {
						inputParameterValue.values.add(decisionInputValue);
					}
					this.decisionInputExecution.setParameterValue(inputParameterValue);
				}
				i = i + 1;
			}
			this.decisionInputExecution.execute();
			List<IParameterValue> outputParameterValues = this.decisionInputExecution.getOutputParameterValues();
			decisionInputExecution.destroy();
			if (outputParameterValues.get(0).getValues().size() == 0) {
				// FIXME Added for connection with debug API
				// When execution stops due to client request, outputParameterValues is empty
				// Just puts true. Execution flow is supposed to stop "by itself" then
				decisionInputResult = new BooleanValue();
				((BooleanValue) decisionInputResult).value = true;
			} else {
				decisionInputResult = outputParameterValues.get(0).getValues().get(0);
			}
		}
		return decisionInputResult;
	}

	@Override
	public void terminate() {
		// Terminate the decision input execution, if any, and then terminate
		// this activation.
		if (this.decisionInputExecution != null) {
			this.decisionInputExecution.terminate();
		}
		super.terminate();
	}

	@Override
	public Boolean isReady() {
		// Check that all incoming edges have sources that are offering tokens.
		// [This should be at most two incoming edges, if there is a decision
		// input flow.]
		int i = 1;
		boolean ready = true;
		while (ready & i <= this.incomingEdges.size()) {
			ready = this.incomingEdges.get(i - 1).hasOffer();
			i = i + 1;
		}
		return ready;
	}

	@Override
	public List<IToken> takeOfferedTokens() {
		// Get tokens from the incoming edge that is not the decision input
		// flow.
		ObjectFlow decisionInputFlow = ((DecisionNode) (this.node)).getDecisionInputFlow();
		List<IToken> allTokens = new ArrayList<IToken>();
		List<IActivityEdgeInstance> incomingEdges = this.getIncomingEdges();
		for (int i = 0; i < incomingEdges.size(); i++) {
			IActivityEdgeInstance edgeInstance = incomingEdges.get(i);
			if (edgeInstance.getEdge() != decisionInputFlow) {
				List<IToken> tokens = edgeInstance.takeOfferedTokens();
				for (int j = 0; j < tokens.size(); j++) {
					allTokens.add(tokens.get(j));
				}
			}
		}
		return allTokens;
	}

	public IValue getDecisionInputFlowValue() {
		// Take the next token available on the decision input flow, if any, and
		// return its value.
		IActivityEdgeInstance decisionInputFlowInstance = this.getDecisionInputFlowInstance();
		IValue value = null;
		if (decisionInputFlowInstance != null) {
			List<IToken> tokens = decisionInputFlowInstance.takeOfferedTokens();
			if (tokens.size() > 0) {
				value = tokens.get(0).getValue();
			}
		}
		return value;
	}

	public IActivityEdgeInstance getDecisionInputFlowInstance() {
		// Get the activity edge instance for the decision input flow, if any.
		ActivityEdge decisionInputFlow = ((DecisionNode) (this.node)).getDecisionInputFlow();
		IActivityEdgeInstance edgeInstance = null;
		if (decisionInputFlow != null) {
			int i = 1;
			while (edgeInstance == null & i <= this.getIncomingEdges().size()) {
				IActivityEdgeInstance incomingEdge = this.getIncomingEdges().get(i - 1);
				if (incomingEdge.getEdge() == decisionInputFlow) {
					edgeInstance = incomingEdge;
				}
				i = i + 1;
			}
		}
		return edgeInstance;
	}

	public Boolean test(ValueSpecification guard, IValue value) {
		// Test if the given value matches the guard. If there is no guard,
		// return true.
		boolean guardResult = true;
		if (guard != null) {
			IValue guardValue = this.getExecutionLocus().getExecutor().evaluate(guard);
			guardResult = guardValue.equals(value);
		}
		return guardResult;
	}

	public List<IToken> removeJoinedControlTokens(List<IToken> incomingTokens) {
		// If the primary incoming edge is an object flow, then remove any
		// control tokens from the incoming tokens and return them.
		// [Control tokens may effectively be offered on an object flow outgoing
		// from a join node that has both control and object flows incoming.]
		List<IToken> removedControlTokens = new ArrayList<IToken>();
		if (this.hasObjectFlowInput()) {
			int i = 1;
			while (i <= incomingTokens.size()) {
				IToken token = incomingTokens.get(i - 1);
				if (token.isControl()) {
					removedControlTokens.add(token);
					incomingTokens.remove(i - 1);
					i = i - 1;
				}
				i = i + 1;
			}
		}
		return removedControlTokens;
	}

	public Boolean hasObjectFlowInput() {
		// Check that the primary incoming edge is an object flow.
		ActivityEdge decisionInputFlow = ((DecisionNode) (this.node)).getDecisionInputFlow();
		boolean isObjectFlow = false;
		int i = 1;
		while (!isObjectFlow & i <= this.incomingEdges.size()) {
			ActivityEdge edge = this.incomingEdges.get(i - 1).getEdge();
			isObjectFlow = edge != decisionInputFlow & edge instanceof ObjectFlow;
			i = i + 1;
		}
		return isObjectFlow;
	}
}
