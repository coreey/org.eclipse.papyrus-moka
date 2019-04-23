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
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.ExtraStructuredActivities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IOutputPinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.ExtraStructuredActivities.IExpansionActivationGroup;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.ExtraStructuredActivities.IExpansionRegionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivationGroup;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.OutputPinActivation;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.uml2.uml.ExpansionKind;
import org.eclipse.uml2.uml.ExpansionNode;
import org.eclipse.uml2.uml.ExpansionRegion;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.StructuredActivityNode;

public class ExpansionRegionActivation extends ActionActivation implements IExpansionRegionActivation {

	/*
	 * The set of expansion activation groups for this expansion region
	 * activation. One activation group is created corresponding to each token
	 * held by the first input expansion node activation for the expansion
	 * region.
	 */
	public List<IExpansionActivationGroup> activationGroups = new ArrayList<IExpansionActivationGroup>();

	/*
	 * The tokens taken from each of the input pin activations for this
	 * expansion region activation. These are preserved for initializing the
	 * region inputs of each of the activation groups.
	 */
	public List<TokenSet> inputTokens = new ArrayList<TokenSet>();

	/*
	 * The tokens taken from each of the input expansion node activations for
	 * this expansion region activation. These are preserved for initializing
	 * the group input of each of the activation groups.
	 */
	public List<TokenSet> inputExpansionTokens = new ArrayList<TokenSet>();

	public Integer next;

	@Override
	public List<IToken> takeOfferedTokens() {
		// Take the tokens from the input pin and input expansion node
		// activations and save them.
		super.takeOfferedTokens();
		ExpansionRegion region = (ExpansionRegion) (this.node);
		List<InputPin> inputPins = region.getInputs();
		List<ExpansionNode> inputElements = region.getInputElements();
		this.inputTokens.clear();
		this.inputExpansionTokens.clear();
		for (int i = 0; i < inputPins.size(); i++) {
			InputPin inputPin = inputPins.get(i);
			TokenSet tokenSet = new TokenSet();
			tokenSet.tokens = this.getPinActivation(inputPin).takeTokens();
			this.inputTokens.add(tokenSet);
		}
		int n = this.numberOfValues();
		for (int i = 0; i < inputElements.size(); i++) {
			ExpansionNode inputElement = inputElements.get(i);
			ExpansionNodeActivation expansionNodeActivation = this.getExpansionNodeActivation(inputElement);
			expansionNodeActivation.fire(expansionNodeActivation.takeOfferedTokens());
			List<IToken> tokens = expansionNodeActivation.takeTokens();
			TokenSet tokenSet = new TokenSet();
			int j = 1;
			while (j <= n) {
				tokenSet.tokens.add(tokens.get(j - 1));
				j = j + 1;
			}
			this.inputExpansionTokens.add(tokenSet);
		}
		return new ArrayList<IToken>();
	}

	@Override
	public void doAction() {
		// If the expansion region has mustIsolate=true, then carry out its
		// behavior with isolation.
		// Otherwise just activate it normally.
		if (((StructuredActivityNode) (this.node)).isMustIsolate()) {
			_beginIsolation();
			this.doStructuredActivity();
			_endIsolation();
		} else {
			this.doStructuredActivity();
		}
	}

	public void doStructuredActivity() {
		// Create a number of expansion region activation groups equal to the
		// number of values expanded in the region,
		// setting the region inputs and group inputs for each group.
		// Run the body of the region in each group, either iteratively or in
		// parallel.
		// Add the outputs of each activation group to the corresonding output
		// expansion node activations.
		ExpansionRegion region = (ExpansionRegion) this.node;
		List<InputPin> inputPins = region.getInputs();
		List<ExpansionNode> inputElements = region.getInputElements();
		List<ExpansionNode> outputElements = region.getOutputElements();
		this.activationGroups.clear();
		int n = this.inputExpansionTokens.get(0).tokens.size();
		int k = 1;
		while (k <= n) {
			IExpansionActivationGroup activationGroup = new ExpansionActivationGroup();
			activationGroup.setRegionActivation(this);
			activationGroup.setIndex(k);
			int j = 1;
			while (j <= inputPins.size()) {
				OutputPinActivation regionInput = new OutputPinActivation();
				regionInput.run();
				activationGroup.getRegionInputs().add(regionInput);
				j = j + 1;
			}
			j = 1;
			while (j <= inputElements.size()) {
				OutputPinActivation groupInput = new OutputPinActivation();
				groupInput.run();
				activationGroup.getGroupInputs().add(groupInput);
				j = j + 1;
			}
			j = 1;
			while (j <= outputElements.size()) {
				OutputPinActivation groupOutput = new OutputPinActivation();
				groupOutput.run();
				activationGroup.getGroupOutputs().add(groupOutput); // fUML12-10 certain boolean flags are not properly initialized in come cases
				j = j + 1;
			}
			activationGroup.createNodeActivations(region.getNodes());
			activationGroup.createEdgeInstances(region.getEdges());
			this.activationGroups.add(activationGroup);
			k = k + 1;
		}
		// List<ExpansionActivationGroup> activationGroups =
		// this.activationGroups;
		if (region.getMode() == ExpansionKind.ITERATIVE_LITERAL) {
			Debug.println("[doStructuredActivity] Expansion mode = iterative");
			this.next = 1;
			this.runIterative();
		} else if (region.getMode() == ExpansionKind.PARALLEL_LITERAL) {
			Debug.println("[doStructuredActivity] Expansion mode = parallel");
			this.runParallel();
		}
		this.doOutput();
	}

	public void runIterative() {
		// Run the body of the region iteratively, either until all activation
		// groups have run or until the region is suspended.
		List<IExpansionActivationGroup> activationGroups = this.activationGroups;
		while (this.next <= activationGroups.size() & !this.isSuspended()) {
			IExpansionActivationGroup activationGroup = activationGroups.get(this.next - 1);
			this.runGroup(activationGroup);
			this.next = this.next + 1;
		}
	}

	public void runParallel() {
		// Run the body of the region concurrently.
		List<IExpansionActivationGroup> activationGroups = this.activationGroups;
		// *** Activate all groups concurrently. ***
		for (Iterator<IExpansionActivationGroup> i = activationGroups.iterator(); i.hasNext();) {
			IExpansionActivationGroup activationGroup = i.next();
			this.runGroup(activationGroup);
		}
	}

	public void doOutput() {
		// Place tokens on the output expansion nodes.
		ExpansionRegion region = (ExpansionRegion) this.node;
		List<ExpansionNode> outputElements = region.getOutputElements();
		Debug.println("[doOutput] Expansion region " + region.getName() + " is " + (this.isSuspended() ? "suspended." : "completed."));
		if (!this.isSuspended()) {
			for (int i = 0; i < activationGroups.size(); i++) {
				IExpansionActivationGroup activationGroup = activationGroups.get(i);
				List<IOutputPinActivation> groupOutputs = activationGroup.getGroupOutputs();
				for (int j = 0; j < groupOutputs.size(); j++) {
					IOutputPinActivation groupOutput = groupOutputs.get(j);
					ExpansionNode outputElement = outputElements.get(j);
					this.getExpansionNodeActivation(outputElement).addTokens(groupOutput.takeTokens());
				}
			}
		}
	}

	@Override
	public void terminate() {
		// Terminate the execution of all contained node activations (which
		// completes the performance of the expansion region activation).
		List<IExpansionActivationGroup> activationGroups = this.activationGroups;
		for (int i = 0; i < activationGroups.size(); i++) {
			IExpansionActivationGroup activationGroup = this.activationGroups.get(i);
			List<IOutputPinActivation> groupOutputs = activationGroup.getGroupOutputs();
			_beginIsolation();
			for (int j = 0; j < groupOutputs.size(); j++) {
				IOutputPinActivation groupOutput = groupOutputs.get(j);
				groupOutput.fire(groupOutput.takeOfferedTokens());
			}
			activationGroup.terminateAll();
			_endIsolation();
		}
		super.terminate();
	}

	@Override
	public void sendOffers() {
		// Fire all output expansion nodes and send offers on all outgoing
		// control flows.
		ExpansionRegion region = (ExpansionRegion) (this.node);
		// *** Send offers from all output expansion nodes concurrently. ***
		List<ExpansionNode> outputElements = region.getOutputElements();
		for (Iterator<ExpansionNode> i = outputElements.iterator(); i.hasNext();) {
			ExpansionNode outputElement = i.next();
			this.getExpansionNodeActivation(outputElement).sendUnofferedTokens();
		}
		// Send offers on all outgoing control flows.
		super.sendOffers();
	}

	public void runGroup(IExpansionActivationGroup activationGroup) {
		// Set up the inputs for the group with the given index, run the group
		// and then fire the group outputs.
		if (this.isRunning()) {
			Debug.println("[runGroup] groupInput[0] = " + this.inputExpansionTokens.get(0).tokens.get(activationGroup.getIndex() - 1).getValue());
			List<TokenSet> inputTokens = this.inputTokens;
			for (int j = 0; j < inputTokens.size(); j++) {
				TokenSet tokenSet = inputTokens.get(j);
				IOutputPinActivation regionInput = activationGroup.getRegionInputs().get(j);
				regionInput.clearTokens();
				regionInput.addTokens(tokenSet.tokens);
				regionInput.sendUnofferedTokens();
			}
			List<TokenSet> inputExpansionTokens = this.inputExpansionTokens;
			for (int j = 0; j < inputExpansionTokens.size(); j++) {
				TokenSet tokenSet = inputExpansionTokens.get(j);
				IOutputPinActivation groupInput = activationGroup.getGroupInputs().get(j);
				groupInput.clearTokens();
				if (tokenSet.tokens.size() >= activationGroup.getIndex()) {
					groupInput.addToken(tokenSet.tokens.get(activationGroup.getIndex() - 1));
				}
				groupInput.sendUnofferedTokens();
			}
			activationGroup.run(activationGroup.getActivityNodeActivations());
			this.terminateGroup(activationGroup);
		}
	}

	public void terminateGroup(IExpansionActivationGroup activationGroup) {
		// Terminate the given activation group, after preserving any group
		// outputs.
		if (this.isRunning() & !this.isSuspended()) {
			List<IOutputPinActivation> groupOutputs = activationGroup.getGroupOutputs();
			for (int i = 0; i < groupOutputs.size(); i++) {
				IOutputPinActivation groupOutput = groupOutputs.get(i);
				groupOutput.fire(groupOutput.takeOfferedTokens());
			}
			activationGroup.terminateAll();
		}
	}

	public ExpansionNodeActivation getExpansionNodeActivation(ExpansionNode node) {
		// Return the expansion node activation corresponding to the given
		// expansion node, in the context of the activity node activation group
		// this expansion region activation is in.
		// [Note: Expansion regions do not own their expansion nodes. Instead,
		// they are own as object nodes by the enclosing activity or group.
		// Therefore, they will already be activated along with their expansion
		// region.]
		return (ExpansionNodeActivation) (this.group.getNodeActivation(node));
	}

	public Integer numberOfValues() {
		// Return the number of values to be acted on by the expansion region of
		// this activation, which is the minimum of the number of values offered
		// to each of the input expansion nodes of the activation.
		ExpansionRegion region = (ExpansionRegion) (this.node);
		List<ExpansionNode> inputElements = region.getInputElements();
		int n = this.getExpansionNodeActivation(inputElements.get(0)).countOfferedValues();
		int i = 2;
		while (i <= inputElements.size()) {
			int count = this.getExpansionNodeActivation(inputElements.get(i - 1)).countOfferedValues();
			if (count < n) {
				n = count;
			}
			i = i + 1;
		}
		return n;
	}

	public Boolean isSuspended() {
		// Check if the activation group for this node is suspended.
		boolean suspended = false;
		int i = 1;
		while (i <= this.activationGroups.size() & !suspended) {
			IActivityNodeActivationGroup group = this.activationGroups.get(i - 1);
			suspended = group.isSuspended();
			i = i + 1;
		}
		return suspended;
	}

	public void resume(IExpansionActivationGroup activationGroup) {
		// Resume an expansion region after the suspension of the given
		// activation group. If the region is iterative, then continue with the
		// iteration. If the region is parallel, and there are no more suspended
		// activation groups, then generate the expansion node output.
		ExpansionRegion region = (ExpansionRegion) this.node;
		this.resume();
		this.terminateGroup(activationGroup);
		if (region.getMode() == ExpansionKind.ITERATIVE_LITERAL) {
			this.runIterative();
		}
		this.doOutput();
	}

	public List<IExpansionActivationGroup> getExpansionActivationGroups() {
		return this.activationGroups;
	}
}
