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
 *  Jeremie TATIBOUET (CEA LIST) - Animation refactoring and improvements
 *  Jeremie Tatibouet (CEA LIST) - Apply fix fUML12-10 certain boolean flags are not properly initialized in come cases
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivationGroup;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1.SemanticVisitor;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.uml2.uml.ActivityNode;

public abstract class ActivityNodeActivation extends SemanticVisitor implements IActivityNodeActivation {

	/*
	 * The group that contains this activity node activation.
	 */
	public IActivityNodeActivationGroup group;

	/*
	 * The activity node being activated by this activity node activation. The
	 * node must be owned by the activity (type) of the activity execution of
	 * this node activation. [This is optional, to allow for fork node edge
	 * queues and implicit fork and join node activations for actions to not
	 * have nodes in the model.]
	 */
	public ActivityNode node;

	/*
	 * The set of activity edge instances for the incoming edges of the node.
	 */
	public List<IActivityEdgeInstance> incomingEdges = new ArrayList<IActivityEdgeInstance>();

	/*
	 * The set of activity edge instances for the outgoing edges of the node.
	 */
	public List<IActivityEdgeInstance> outgoingEdges = new ArrayList<IActivityEdgeInstance>();

	/*
	 * If true, this node activation is enabled for execution once all its other
	 * prerequisites are satisfied.
	 */
	public Boolean running;

	public List<IToken> heldTokens = new ArrayList<IToken>();

	public void run() {
		// Run the activation of this node.
		if (this.node != null) {
			Debug.println("[run] node = " + this.node.getName());
		} else {
			Debug.println("[run] Anonymous activation of type " + this.getClass().getName());
		}
		this.running = true;
	}

	public void receiveOffer() {
		// Receive an offer from an incoming edge.
		// Check if all prerequisites have been satisfied. If so, fire.
		Debug.println("[receiveOffer] " + (this.node == null ? "..." : "node = " + this.node.getName()));
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

	public List<IToken> takeOfferedTokens() {
		// Get tokens from all incoming edges.
		List<IToken> allTokens = new ArrayList<IToken>();
		List<IActivityEdgeInstance> incomingEdges = this.incomingEdges;
		for (int i = 0; i < incomingEdges.size(); i++) {
			IActivityEdgeInstance incomingEdge = incomingEdges.get(i);
			List<IToken> tokens = incomingEdge.takeOfferedTokens();
			for (int j = 0; j < tokens.size(); j++) {
				IToken token = tokens.get(j);
				allTokens.add(token);
			}
		}
		return allTokens;
	}

	public abstract void fire(List<IToken> incomingTokens);

	public void sendOffers(List<IToken> tokens) {
		// Send offers for the given set of tokens over all outgoing edges (if
		// there are any tokens actually being offered).
		if (tokens.size() > 0) {
			// *** Send all outgoing offers concurrently. ***
			List<IActivityEdgeInstance> outgoingEdges = this.outgoingEdges;
			for (Iterator<IActivityEdgeInstance> i = outgoingEdges.iterator(); i.hasNext();) {
				IActivityEdgeInstance outgoingEdge = i.next();
				// Debug.println("[sendOffers] Sending offer to " +
				// outgoingEdge.target.node.getName() + ".");
				outgoingEdge.sendOffer(tokens);
			}
		}
	}

	public void terminate() {
		// Terminate the activation of this node.
		if (this.running) {
			if (this.node != null) {
				Debug.println("[terminate] node = " + this.node.getName());
			} else {
				Debug.println("[terminate] Anonymous activation of type " + this.getClass().getName());
			}
		}
		this.running = false;
	}

	public Boolean isReady() {
		// Check if all the prerequisites for this node have been satisfied.
		// By default, check that this node is running.
		return this.isRunning();
	}

	public Boolean isRunning() {
		// Test whether this node activation is running.
		return this.running;
	}

	public void addOutgoingEdge(IActivityEdgeInstance edge) {
		// Add an activity edge instance as an outgoing edge of this activity
		// node activation.
		edge.setSource(this);
		this.getOutgoingEdges().add(edge);
	}

	public void addIncomingEdge(IActivityEdgeInstance edge) {
		// Add an activity edge instance as an incoming edge of this activity
		// node activation.
		edge.setTarget(this);
		this.getIncomingEdges().add(edge);
	}

	public void createNodeActivations() {
		// Create node activations for any subnodes of the node for this
		// activation.
		// For most kinds of nodes, this does nothing.
		return;
	}

	public void createEdgeInstances() {
		// Create edge instances for any edge instances owned by the node for
		// this activation.
		// For most kinds of nodes, this does nothing.
		return;
	}

	public Boolean isSourceFor(IActivityEdgeInstance edgeInstance) {
		// Check if this node activation is the effective source for the given
		// edge instance.
		return edgeInstance.getSource() == this;
	}

	public IActivityExecution getActivityExecution() {
		// Return the activity execution that contains this activity node
		// activation, directly or indirectly.
		return this.getGroup().getActivityExecution();
	}

	public IObject_ getExecutionContext() {
		// Get the context object for the containing activity execution.
		return this.getActivityExecution().getContext();
	}

	public ILocus getExecutionLocus() {
		// Get the locus of the containing activity execution.
		return this.getActivityExecution().getLocus();
	}

	public IActivityNodeActivation getNodeActivation(ActivityNode node) {
		// Get the activity node activation corresponding to the given activity
		// node, in the context of this activity node activation.
		// By default, return this activity node activation, if it is for the
		// given node, otherwise return nothing.
		ActivityNodeActivation activation = null;
		if (node == this.getNode()) {
			activation = this;
		}
		return activation;
	}

	public void addToken(IToken token) {
		// Transfer the given token to be held by this node.
		if (this.node == null) {
			Debug.println("[addToken] ...");
		} else {
			Debug.println("[addToken] node = " + this.node.getName());
		}
		IToken transferredToken = token.transfer(this);
		// Debug.println("[addToken] Adding token with value = " +
		// transferredToken.get());
		this.heldTokens.add(transferredToken);
	}

	public Integer removeToken(IToken token) {
		// Remove the given token, if it is held by this node activation.
		// Return the position (counting from 1) of the removed token (0 if
		// there is none removed).
		boolean notFound = true;
		int i = 1;
		while (notFound & i <= this.heldTokens.size()) {
			if (this.heldTokens.get(i - 1) == token) {
				if (this.node == null) {
					Debug.println("[removeToken] ...");
				} else {
					Debug.println("[removeToken] node = " + this.node.getName());
				}
				this.heldTokens.remove(i - 1);
				notFound = false;
			}
			i = i + 1;
		}
		if (notFound) {
			i = 0;
		} else {
			i = i - 1;
		}
		return i;
	}

	public void addTokens(List<IToken> tokens) {
		// Transfer the given tokens to be the held tokens for this node.
		// if (this.node == null) {
		// Debug.println("[addTokens] ...");
		// } else {
		// Debug.println("[addTokens] node = " + this.node.getName());
		// }
		for (int i = 0; i < tokens.size(); i++) {
			IToken token = tokens.get(i);
			this.addToken(token);
		}
	}

	public List<IToken> takeTokens() {
		// Take the tokens held by this node activation.
		List<IToken> tokens = this.getTokens();
		this.clearTokens();
		return tokens;
	}

	public void clearTokens() {
		// Remove all held tokens.
		while (this.heldTokens.size() > 0) {
			this.heldTokens.get(0).withdraw();
		}
	}

	public List<IToken> getTokens() {
		// Get the tokens held by this node activation.
		// Debug.println("[getTokens] node = " + this.node.getName());
		List<IToken> tokens = new ArrayList<IToken>();
		List<IToken> heldTokens = this.heldTokens;
		for (int i = 0; i < heldTokens.size(); i++) {
			IToken heldToken = heldTokens.get(i);
			// Debug.println("[getTokens] token value = " +
			// heldTokens.get());
			tokens.add(heldToken);
		}
		return tokens;
	}

	public void initialize(ActivityNode node, IActivityNodeActivationGroup group) {
		// Initialize this node activation.

		// fUML12-10 certain boolean flags are not properly initialized in come cases

		this.setNode(node);
		this.setGroup(group);
		this.running = false;
	}

	public void suspend() {
		// Suspend this activation within the activation group that contains it.
		this.getGroup().suspend(this);
	}

	public void resume() {
		// Resume this activation within the activation group that contains it.
		this.getGroup().resume(this);
	}

	public void setNode(ActivityNode node) {
		this.node = node;
	}

	public ActivityNode getNode() {
		return this.node;
	}

	public void setGroup(IActivityNodeActivationGroup group) {
		this.group = group;
	}

	public IActivityNodeActivationGroup getGroup() {
		return this.group;
	}

	public List<IActivityEdgeInstance> getIncomingEdges() {
		return this.incomingEdges;
	}

	public List<IActivityEdgeInstance> getOutgoingEdges() {
		return this.outgoingEdges;
	}

	public void setRunning(Boolean status) {
		this.running = status;
	}

	/*
	 * public void animate(IRender animationManager){
	 * // An activity node is animated for the period indicated by the MOKA_ANIMATION_DELAY
	 * if(animationManager!=null){
	 * this.animationManager = animationManager;
	 * animationManager.render(this.node, AnimationKind.ANIMATED, MokaConstants.MOKA_ANIMATION_DELAY);
	 * }
	 * }
	 */
}
