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
import org.eclipse.papyrus.moka.externalcontrol.controller.AbstractExternallyControlledVisitor;
import org.eclipse.papyrus.moka.externalcontrol.controller.ExternalController;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IPinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivationGroup;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IBooleanValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.ILink;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ConditionalNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.LoopNode;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Pin;

public abstract class AbstractExternallyControlledActionActivation<T extends IActionActivation> extends AbstractExternallyControlledVisitor<T> implements IActionActivation {


	public AbstractExternallyControlledActionActivation(T visitor, ExternalController controller, List<IControllerAdvice> advices) {
		super(visitor, controller, advices);
	}

	@Override
	public void fire(List<IToken> incomingTokens) {
		Debug.println("[fire] Action " + this.getNode().getName() + "...");
		Debug.println("[event] Fire activity=" + this.getActivityExecution().getBehavior().getName() + " action=" + this.getNode().getName());

		suspendedTokens = incomingTokens;
		this.suspendForControl();
		this.suspend();
	}
	
	
	

	@SuppressWarnings("unchecked")
	@Override
	public AbstractExternallyControlledVisitor<? extends ISemanticVisitor> getStackParent() {
		IActivityExecution execution = getActivityExecution();
		if (execution instanceof  AbstractExternallyControlledVisitor<? >){
			return (AbstractExternallyControlledVisitor<? extends ISemanticVisitor>) execution;
		}
		
		return null;
	}
	

	


	@Override
	public void run() {
		delegatedVisitor.run();
	}

	@Override
	public void receiveOffer() {
		// Receive an offer from an incoming edge.
		// Check if all prerequisites have been satisfied. If so, fire.
		Debug.println("[receiveOffer] " + (this.getNode() == null ? "..." : "node = " + this.getNode().getName()));
		_beginIsolation();
		boolean ready = this.isReady();
		List<IToken> tokens = new ArrayList<IToken>();
		if (ready) {
			Debug.println("[receiveOffer] Firing.");
			tokens = this.takeOfferedTokens();
		}
		_endIsolation();
		if (ready) {
			this.fire(tokens);
		}
	}

	@Override
	public List<IToken> takeOfferedTokens() {
		return delegatedVisitor.takeOfferedTokens();
	}


	@Override
	public void sendOffers(List<IToken> tokens) {
		delegatedVisitor.sendOffers(tokens);
	}

	@Override
	public void terminate() {
		delegatedVisitor.terminate();

	}

	@Override
	public Boolean isReady() {
		return delegatedVisitor.isReady();
	}

	@Override
	public Boolean isRunning() {

		return delegatedVisitor.isRunning();
	}

	@Override
	public void addOutgoingEdge(IActivityEdgeInstance edge) {
		// Add an activity edge instance as an outgoing edge of this activity
		// node activation.
		edge.setSource(this);
		this.getOutgoingEdges().add(edge);

	}

	@Override
	public void addIncomingEdge(IActivityEdgeInstance edge) {

		edge.setTarget(this);
		this.getIncomingEdges().add(edge);

	}

	@Override
	public void createNodeActivations() {

		// Create node activations for the input and output pins of the action
		// for this activation.
		// [Note: Pins are owned by their actions, not by the enclosing activity
		// (or group), so they must be activated through the action activation.]
		Action action = (Action) (this.getNode());
		List<ActivityNode> inputPinNodes = new ArrayList<ActivityNode>();
		List<InputPin> inputPins = getInputs(action); // CHANGED from: action.getInputs();
		for (int i = 0; i < inputPins.size(); i++) {
			InputPin inputPin = inputPins.get(i);
			inputPinNodes.add(inputPin);
		}
		this.getGroup().createNodeActivations(inputPinNodes);
		for (int i = 0; i < inputPinNodes.size(); i++) {
			ActivityNode node = inputPinNodes.get(i);
			this.addPinActivation((IPinActivation) (this.getGroup().getNodeActivation(node)));
		}
		List<ActivityNode> outputPinNodes = new ArrayList<ActivityNode>();
		List<OutputPin> outputPins = getOutputs(action); // CHANGED from: action.getOutputs();
		for (int i = 0; i < outputPins.size(); i++) {
			OutputPin outputPin = outputPins.get(i);
			outputPinNodes.add(outputPin);
		}
		this.getGroup().createNodeActivations(outputPinNodes);
		for (int i = 0; i < outputPinNodes.size(); i++) {
			ActivityNode node = outputPinNodes.get(i);
			this.addPinActivation((IPinActivation) (this.getGroup().getNodeActivation(node)));
		}
	}

	@Override
	public void createEdgeInstances() {
		delegatedVisitor.createEdgeInstances();
	}

	@Override
	public Boolean isSourceFor(IActivityEdgeInstance edgeInstance) {
		return delegatedVisitor.isSourceFor(edgeInstance);
	}

	@Override
	public IActivityExecution getActivityExecution() {

		return delegatedVisitor.getActivityExecution();
	}

	@Override
	public IObject_ getExecutionContext() {

		return delegatedVisitor.getExecutionContext();
	}

	@Override
	public ILocus getExecutionLocus() {

		return delegatedVisitor.getExecutionLocus();
	}

	@Override
	public IActivityNodeActivation getNodeActivation(ActivityNode node) {

		// Get the activity node activation corresponding to the given activity
		// node, in the context of this activity node activation.
		// By default, return this activity node activation, if it is for the
		// given node, otherwise return nothing.
		IActivityNodeActivation activation = null;
		if (node == this.getNode()) {
			activation = this;
		}
		return activation;
	}

	@Override
	public void addToken(IToken token) {
		delegatedVisitor.addToken(token);

	}

	@Override
	public Integer removeToken(IToken token) {
		return delegatedVisitor.removeToken(token);
	}

	@Override
	public void addTokens(List<IToken> tokens) {
		delegatedVisitor.addTokens(tokens);
	}

	@Override
	public List<IToken> takeTokens() {
		return delegatedVisitor.takeOfferedTokens();
	}

	@Override
	public void clearTokens() {
		delegatedVisitor.clearTokens();
	}

	@Override
	public List<IToken> getTokens() {
		return delegatedVisitor.getTokens();
	}

	@Override
	public void initialize(ActivityNode node, IActivityNodeActivationGroup group) {
		delegatedVisitor.initialize(node, group);
	}

	@Override
	public void suspend() {
		delegatedVisitor.suspend();

	}

	@Override
	public void resume() {
		delegatedVisitor.resume();
	}

	@Override
	public void setNode(ActivityNode node) {
		delegatedVisitor.setNode(node);
	}

	@Override
	public ActivityNode getNode() {
		return delegatedVisitor.getNode();
	}

	@Override
	public void setGroup(IActivityNodeActivationGroup group) {
		delegatedVisitor.setGroup(group);
	}

	@Override
	public IActivityNodeActivationGroup getGroup() {
		return delegatedVisitor.getGroup();
	}

	@Override
	public List<IActivityEdgeInstance> getIncomingEdges() {

		return delegatedVisitor.getIncomingEdges();
	}

	@Override
	public List<IActivityEdgeInstance> getOutgoingEdges() {
		return delegatedVisitor.getOutgoingEdges();
	}

	@Override
	public void setRunning(Boolean status) {
		delegatedVisitor.setRunning(status);
	}

	@Override
	public void _endIsolation() {
		delegatedVisitor._endIsolation();

	}

	@Override
	public void _beginIsolation() {
		delegatedVisitor._beginIsolation();

	}

	@Override
	public void doAction() {
		delegatedVisitor.doAction();
	}

	@Override
	public void sendOffers() {
		delegatedVisitor.sendOffers();

	}

	@Override
	public void addPinActivation(IPinActivation pinActivation) {
		// Add a pin activation to this action activation.
		this.delegatedVisitor.addPinActivation(pinActivation);
		pinActivation.setActionActivation(this);
	}

	@Override
	public IPinActivation getPinActivation(Pin pin) {
		return delegatedVisitor.getPinActivation(pin);
	}

	@Override
	public void putToken(OutputPin pin, IValue value) {
		delegatedVisitor.putToken(pin, value);

	}

	@Override
	public void putTokens(OutputPin pin, List<IValue> values) {
		delegatedVisitor.putTokens(pin, values);

	}

	@Override
	public List<IValue> getTokens(InputPin pin) {
		return delegatedVisitor.getTokens(pin);
	}

	@Override
	public List<IValue> takeTokens(InputPin pin) {
		return delegatedVisitor.takeTokens(pin);
	}

	@Override
	public Boolean valueParticipatesInLink(IValue value, ILink link) {
		return delegatedVisitor.valueParticipatesInLink(value, link);
	}

	@Override
	public IBooleanValue makeBooleanValue(Boolean value) {
		return delegatedVisitor.makeBooleanValue(value);
	}

	// ADDED:
	protected static List<InputPin> getInputs(Action action) {
		return action instanceof LoopNode ? ((LoopNode) action).getLoopVariableInputs() : action.getInputs();
	}

	protected static List<OutputPin> getOutputs(Action action) {
		return action instanceof LoopNode ? ((LoopNode) action).getResults() : action instanceof ConditionalNode ? ((ConditionalNode) action).getResults() : action.getOutputs();
	}



}
