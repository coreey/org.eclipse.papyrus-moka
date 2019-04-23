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
 *	Jeremie Tatibouet (CEA LIST) - Apply fix fUML12-10 certain boolean flags are not properly initialized in come cases 
 *  Jeremie Tatibouet (CEA LIST) - Apply fix fUML12-34 AcceptEventActionActivation::match should match instances of descendants of a trigger's signal
 *  
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IPinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivationGroup;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IObjectToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.ILink;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.ActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.ActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.ControlToken;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.ForkNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.ObjectToken;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.BooleanValue;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ConditionalNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LoopNode;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Pin;
import org.eclipse.uml2.uml.UMLFactory;

public abstract class ActionActivation extends ActivityNodeActivation implements IActionActivation {

	/*
	 * The activations of the pins owned by the action of this action
	 * activation.
	 */
	public List<IPinActivation> pinActivations = new ArrayList<IPinActivation>();

	/*
	 * Whether this action activation is already firing. This attribute is only
	 * used if the action for this action activation has isLocallyReentrant =
	 * false (the default). If isLocallyReentrant=true, then firing always just
	 * remains false.
	 */
	public Boolean firing;

	@Override
	public void run() {
		// Run this action activation and any outoging fork node attached to it.
		super.run();
		if (this.outgoingEdges.size() > 0) {
			this.outgoingEdges.get(0).getTarget().run();
		}
		this.firing = false;
	}

	@Override
	public List<IToken> takeOfferedTokens() {
		// If the action is not locally reentrant, then mark this activation as
		// firing.
		// Take any incoming offers of control tokens, then concurrently fire
		// all input pin activations.
		// Note: This is included here to happen in the same isolation scope as
		// the isReady test.
		this.firing = !((Action) this.node).isLocallyReentrant();
		List<IToken> offeredTokens = new ArrayList<IToken>();
		List<IActivityEdgeInstance> incomingEdges = this.incomingEdges;
		for (int i = 0; i < incomingEdges.size(); i++) {
			IActivityEdgeInstance incomingEdge = incomingEdges.get(i);
			List<IToken> tokens = incomingEdge.takeOfferedTokens();
			for (int j = 0; j < tokens.size(); j++) {
				IToken token = tokens.get(j);
				token.withdraw();
				offeredTokens.add(token);
			}
		}
		Action action = (Action) (this.node);
		// *** Fire all input pins concurrently. ***
		List<InputPin> inputPins = getInputs(action); // CHANGED from: action.getInputs();
		for (Iterator<InputPin> i = inputPins.iterator(); i.hasNext();) {
			InputPin pin = i.next();
			IPinActivation pinActivation = this.getPinActivation(pin);
			List<IToken> tokens = pinActivation.takeOfferedTokens();
			pinActivation.fire(tokens);
			for (int j = 0; j < tokens.size(); j++) {
				IToken token = tokens.get(j);
				offeredTokens.add(token);
			}
		}
		return offeredTokens;
	}

	@Override
	public void fire(List<IToken> incomingTokens) {
		// Do the main action behavior then concurrently fire all output pin
		// activations
		// and offer a single control token. Then activate the action again,
		// if it is still ready to fire and has at least one token actually
		// being
		// offered to it.
		do {
			Debug.println("[fire] Action " + this.node.getName() + "...");
			Debug.println("[event] Fire activity=" + this.getActivityExecution().getBehavior().getName() + " action=" + this.node.getName());
			this.doAction();
			incomingTokens = this.completeAction();
		} while (incomingTokens.size() > 0);
	}

	@Override
	public void terminate() {
		// Terminate this action activation and any outgoing fork node attached
		// to it.
		super.terminate();
		if (this.outgoingEdges.size() > 0) {
			this.outgoingEdges.get(0).getTarget().terminate();
		}
	}

	public List<IToken> completeAction() {
		// Concurrently fire all output pin activations and offer a single
		// control token. Then check if the action should fire again
		// and, if so, return additional incoming tokens for this.
		this.sendOffers();
		Debug.println("[fire] Checking if " + this.node.getName() + " should fire again...");
		_beginIsolation();
		List<IToken> incomingTokens = new ArrayList<IToken>();
		this.firing = false;
		if (this.isReady()) {
			incomingTokens = this.takeOfferedTokens();
			this.firing = this.isFiring() & incomingTokens.size() > 0;
		}
		_endIsolation();
		return incomingTokens;
	}

	@Override
	public Boolean isReady() {
		// In addition to the default condition, check that, if the action has
		// isLocallyReentrant=false, then the activation is not currently
		// firing,
		// and that the sources of all incoming edges (control flows) have
		// offers and all input pin activations are ready.
		// [This assumes that all edges directly incoming to the action are
		// control flows.]
		boolean ready = super.isReady() & (((Action) this.node).isLocallyReentrant() | !this.isFiring());
		int i = 1;
		while (ready & i <= this.incomingEdges.size()) {
			ready = this.incomingEdges.get(i - 1).hasOffer();
			i = i + 1;
		}
		List<InputPin> inputPins = getInputs((Action) this.node); // CHANGED from: ((Action)(this.node)).getInputs();
		int j = 1;
		while (ready & j <= inputPins.size()) {
			ready = this.getPinActivation(inputPins.get(j - 1)).isReady();
			j = j + 1;
		}
		return ready;
	}

	public Boolean isFiring() {
		// Indicate whether this action activation is currently firing or not.
		return this.firing == null ? false : this.firing; // ADDED check for null
	}

	public abstract void doAction();

	public void sendOffers() {
		// Fire all output pins and send offers on all outgoing control flows.
		Action action = (Action) (this.node);
		// *** Send offers from all output pins concurrently. ***
		List<OutputPin> outputPins = getOutputs(action); // CHANGED from: action.getOutputs();
		for (Iterator<OutputPin> i = outputPins.iterator(); i.hasNext();) {
			OutputPin outputPin = i.next();
			IPinActivation pinActivation = this.getPinActivation(outputPin);
			pinActivation.sendUnofferedTokens();
		}
		// Send offers on all outgoing control flows.
		if (this.outgoingEdges.size() > 0) {
			List<IToken> tokens = new ArrayList<IToken>();
			tokens.add(new ControlToken());
			this.addTokens(tokens);
			this.outgoingEdges.get(0).sendOffer(tokens);
		}
	}

	@Override
	public void createNodeActivations() {
		// Create node activations for the input and output pins of the action
		// for this activation.
		// [Note: Pins are owned by their actions, not by the enclosing activity
		// (or group), so they must be activated through the action activation.]
		Action action = (Action) (this.node);
		List<ActivityNode> inputPinNodes = new ArrayList<ActivityNode>();
		List<InputPin> inputPins = getInputs(action); // CHANGED from: action.getInputs();
		for (int i = 0; i < inputPins.size(); i++) {
			InputPin inputPin = inputPins.get(i);
			inputPinNodes.add(inputPin);
		}
		this.group.createNodeActivations(inputPinNodes);
		for (int i = 0; i < inputPinNodes.size(); i++) {
			ActivityNode node = inputPinNodes.get(i);
			this.addPinActivation((IPinActivation) (this.group.getNodeActivation(node)));
		}
		List<ActivityNode> outputPinNodes = new ArrayList<ActivityNode>();
		List<OutputPin> outputPins = getOutputs(action); // CHANGED from: action.getOutputs();
		for (int i = 0; i < outputPins.size(); i++) {
			OutputPin outputPin = outputPins.get(i);
			outputPinNodes.add(outputPin);
		}
		this.group.createNodeActivations(outputPinNodes);
		for (int i = 0; i < outputPinNodes.size(); i++) {
			ActivityNode node = outputPinNodes.get(i);
			this.addPinActivation((IPinActivation) (this.group.getNodeActivation(node)));
		}
	}

	@Override
	public void addOutgoingEdge(IActivityEdgeInstance edge) {
		// If there are no outgoing activity edge instances, create a single
		// activity edge instance with a fork node execution at the other end.
		// Add the give edge to the fork node execution that is the target of
		// the activity edge instance out of this action execution.
		// [This assumes that all edges directly outgoing from the action are
		// control flows, with an implicit fork for offers out of the action.]
		IActivityNodeActivation forkNodeActivation;
		if (this.outgoingEdges.size() == 0) {
			forkNodeActivation = new ForkNodeActivation();
			forkNodeActivation.setRunning(false); // fUML12-10 certain boolean flags are not properly initialized in come cases
			IActivityEdgeInstance newEdge = new ActivityEdgeInstance();
			super.addOutgoingEdge(newEdge);
			forkNodeActivation.addIncomingEdge(newEdge);
		} else {
			forkNodeActivation = this.outgoingEdges.get(0).getTarget();
		}
		forkNodeActivation.addOutgoingEdge(edge);
	}

	public void addPinActivation(IPinActivation pinActivation) {
		// Add a pin activation to this action activation.
		this.pinActivations.add(pinActivation);
		pinActivation.setActionActivation(this);
	}

	public IPinActivation getPinActivation(Pin pin) {
		// Precondition: The given pin is owned by the action of the action
		// activation.
		// Return the pin activation corresponding to the given pin.
		IPinActivation pinActivation = null;
		int i = 1;
		while (pinActivation == null & i <= this.pinActivations.size()) {
			IPinActivation thisPinActivation = this.pinActivations.get(i - 1);
			if (thisPinActivation.getNode() == pin) {
				pinActivation = thisPinActivation;
			}
			i = i + 1;
		}
		return pinActivation;
	}

	public void putToken(OutputPin pin, IValue value) {
		// Precondition: The action execution has fired and the given pin is
		// owned by the action of the action execution.
		// Place a token for the given value on the pin activation corresponding
		// to the given output pin.
		Debug.println("[putToken] node = " + this.node.getName());
		IObjectToken token = new ObjectToken();
		token.setValue(value);
		IPinActivation pinActivation = this.getPinActivation(pin);
		pinActivation.addToken(token);
	}

	public void putTokens(OutputPin pin, List<IValue> values) {
		// Precondition: The action execution has fired and the given pin is
		// owned by the action of the action execution.
		// Place tokens for the given values on the pin activation corresponding
		// to the given output pin.
		// Debug.println("[putTokens] node = " + this.node.getName());
		for (int i = 0; i < values.size(); i++) {
			IValue value = values.get(i);
			this.putToken(pin, value);
		}
	}

	public List<IValue> getTokens(InputPin pin) {
		// Precondition: The action execution has fired and the given pin is
		// owned by the action of the action execution.
		// Get any tokens held by the pin activation corresponding to the given
		// input pin and return them
		// (but leave the tokens on the pin).
		Debug.println("[getTokens] node = " + this.node.getName() + ", pin = " + pin.getName());
		IPinActivation pinActivation = this.getPinActivation(pin);
		List<IToken> tokens = pinActivation.getUnofferedTokens();
		List<IValue> values = new ArrayList<IValue>();
		for (int i = 0; i < tokens.size(); i++) {
			IToken token = tokens.get(i);
			IValue value = ((IObjectToken) token).getValue();
			if (value != null) {
				values.add(value);
			}
		}
		return values;
	}

	public List<IValue> takeTokens(InputPin pin) {
		// Precondition: The action execution has fired and the given pin is
		// owned by the action of the action execution.
		// Take any tokens held by the pin activation corresponding to the given
		// input pin and return them.
		Debug.println("[takeTokens] node = " + this.node.getName() + ", pin = " + pin.getName());
		IPinActivation pinActivation = this.getPinActivation(pin);
		List<IToken> tokens = pinActivation.takeUnofferedTokens();
		List<IValue> values = new ArrayList<IValue>();
		for (int i = 0; i < tokens.size(); i++) {
			IToken token = tokens.get(i);
			IValue value = ((IObjectToken) token).getValue();
			if (value != null) {
				values.add(value);
			}
		}
		return values;
	}

	@Override
	public Boolean isSourceFor(IActivityEdgeInstance edgeInstance) {
		// If this action has an outgoing fork node, check that the fork node is
		// the source of the given edge instance.
		boolean isSource = false;
		if (this.outgoingEdges.size() > 0) {
			isSource = this.outgoingEdges.get(0).getTarget().isSourceFor(edgeInstance);
		}
		return isSource;
	}

	public Boolean valueParticipatesInLink(IValue value, ILink link) {
		// Test if the given value participates in the given link.
		List<IFeatureValue> linkFeatureValues = link.getFeatureValues();
		boolean participates = false;
		int i = 1;
		while (!participates & i <= linkFeatureValues.size()) {
			participates = linkFeatureValues.get(i - 1).getValues().get(0).equals(value);
			i = i + 1;
		}
		return participates;
	}

	public BooleanValue makeBooleanValue(Boolean value) {
		// Make a Boolean value using the built-in Boolean primitive type.
		// [This ensures that Boolean values created internally are the same as
		// the default used for evaluating Boolean literals.]
		LiteralBoolean booleanLiteral = UMLFactory.eINSTANCE.createLiteralBoolean();
		booleanLiteral.setValue(value);
		return (BooleanValue) (this.getExecutionLocus().getExecutor().evaluate(booleanLiteral));
	}

	public void initialize(ActivityNode node, IActivityNodeActivationGroup group) {
		// fUML12-10 certain boolean flags are not properly initialized in come cases
		super.initialize(node, group);
		this.firing = false;
	}

	// ADDED:
	protected static List<InputPin> getInputs(Action action) {
		return action instanceof LoopNode ? ((LoopNode) action).getLoopVariableInputs() : action.getInputs();
	}

	protected static List<OutputPin> getOutputs(Action action) {
		return action instanceof LoopNode ? ((LoopNode) action).getResults() : action instanceof ConditionalNode ? ((ConditionalNode) action).getResults() : action.getOutputs();
	}
}
