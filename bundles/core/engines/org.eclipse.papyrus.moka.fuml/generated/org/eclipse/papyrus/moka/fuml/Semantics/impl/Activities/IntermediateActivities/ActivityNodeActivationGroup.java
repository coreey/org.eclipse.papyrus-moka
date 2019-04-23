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
 *  Jeremie Tatibouet (CEA LIST) - Apply fix fUML12-10 certain boolean flags are not properly initialized in come cases 
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Activities.CompleteStructuredActivities.IStructuredActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.ExtraStructuredActivities.IExpansionNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivationGroup;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityParameterNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IPinActivation;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.Pin;

public class ActivityNodeActivationGroup implements IActivityNodeActivationGroup {

	/*
	 * The set of activity edge instances for this group.
	 */
	public List<IActivityEdgeInstance> edgeInstances = new ArrayList<IActivityEdgeInstance>();

	/*
	 * The set of activity node executions for this group.
	 */
	public List<IActivityNodeActivation> nodeActivations = new ArrayList<IActivityNodeActivation>();

	/*
	 * The activity execution to which this group belongs. (This will be empty
	 * if the group is for a structured activity node activation.)
	 */
	public IActivityExecution activityExecution;

	/*
	 * The structured activity node activation to which this group belongs.
	 * (This will be empty if the group is for an activity execution.)
	 */
	public IStructuredActivityNodeActivation containingNodeActivation;

	/*
	 * Activity node activations in this activation group that are suspended
	 * waiting for an event occurrence. If an activation group has a containing
	 * node activation and any suspended activations, then the containing node
	 * activation will also be suspended.
	 */
	public List<IActivityNodeActivation> suspendedActivations = new ArrayList<IActivityNodeActivation>();

	public void run(List<IActivityNodeActivation> activations) {
		// Run the given node activations. 
		// Then concurrently send offers to all input activity parameter node activations (if any). 
		// Finally, concurrently send offers to all activations of other kinds of nodes that have 
		// no incoming edges with the given set (if any).
		for (int i = 0; i < activations.size(); i++) {
			IActivityNodeActivation activation = activations.get(i);
			activation.run();
		}
		Debug.println("[run] Checking for enabled nodes...");
		List<IActivityNodeActivation> enabledParameterNodeActivations = new ArrayList<IActivityNodeActivation>();
		List<IActivityNodeActivation> enabledOtherActivations = new ArrayList<IActivityNodeActivation>();
		for (int i = 0; i < activations.size(); i++) {
			IActivityNodeActivation activation = activations.get(i);
			Debug.println("[run] Checking node " + activation.getNode().getName() + "...");
			if (!(activation instanceof IPinActivation |activation instanceof IExpansionNodeActivation)) {
				boolean isEnabled = this.checkIncomingEdges(activation.getIncomingEdges(), activations);
				// For an action activation, also consider incoming edges to
				// input pins
				if (isEnabled & activation instanceof IActionActivation) {
					List<InputPin> inputPins = ((Action) activation.getNode()).getInputs();
					int j = 1;
					while (j <= inputPins.size() & isEnabled) {
						InputPin inputPin = inputPins.get(j - 1);
						List<IActivityEdgeInstance> inputEdges = ((IActionActivation) activation).getPinActivation(inputPin).getIncomingEdges();
						isEnabled = this.checkIncomingEdges(inputEdges, activations);
						j = j + 1;
					}
				}
				if (isEnabled) {
					Debug.println("[run] Node " + activation.getNode().getName() + " is enabled.");
					if (activation instanceof ActivityParameterNodeActivation) {
					    enabledParameterNodeActivations.add(activation);
					} else {
					    enabledOtherActivations.add(activation);
					}
				}
			}
		}
		// *** Send offers to all enabled activity parameter nodes concurrently. ***
		for (Iterator<IActivityNodeActivation> i = enabledParameterNodeActivations.iterator(); i.hasNext();) {
		    IActivityNodeActivation activation = (IActivityNodeActivation) i.next();
		    activation.receiveOffer();
		}
		// Debug.println("[run] " + enabledActivations.size() +
		// " node(s) are enabled.");
		// *** Send offers to all other enabled nodes concurrently. ***
		for (Iterator<IActivityNodeActivation> i = enabledOtherActivations.iterator(); i.hasNext();) {
			IActivityNodeActivation activation = i.next();
			Debug.println("[run] Sending offer to node " + activation.getNode().getName() + ".");
			activation.receiveOffer();
		}
	}

	public Boolean checkIncomingEdges(List<IActivityEdgeInstance> incomingEdges, List<IActivityNodeActivation> activations) {
		// Check if any incoming edges have a source in a given set of
		// activations.
		int j = 1;
		boolean notFound = true;
		while (j <= incomingEdges.size() & notFound) {
			int k = 1;
			while (k <= activations.size() & notFound) {
				if (activations.get(k - 1).isSourceFor(incomingEdges.get(j - 1))) {
					notFound = false;
				}
				k = k + 1;
			}
			j = j + 1;
		}
		return notFound;
	}

	public void runNodes(List<ActivityNode> nodes) {
		// Run the node activations associated with the given nodes in this
		// activation group.
		List<IActivityNodeActivation> nodeActivations = new ArrayList<IActivityNodeActivation>();
		for (int i = 0; i < nodes.size(); i++) {
			ActivityNode node = nodes.get(i);
			IActivityNodeActivation nodeActivation = this.getNodeActivation(node);
			if (nodeActivation != null) {
				nodeActivations.add(nodeActivation);
			}
		}
		this.run(nodeActivations);
	}

	public void activate(List<ActivityNode> nodes, List<ActivityEdge> edges) {
		// Activate and run the given set of nodes with the given set of edges,
		// within this activation group.
		this.createNodeActivations(nodes);
		this.createEdgeInstances(edges);
		this.run(this.nodeActivations);
		// Debug.println("[activate] Exiting.");
	}

	public void terminateAll() {
		// Terminate all node activations in the group.
		List<IActivityNodeActivation> nodeActivations = this.nodeActivations;
		for (int i = 0; i < nodeActivations.size(); i++) {
			IActivityNodeActivation nodeActivation = nodeActivations.get(i);
			nodeActivation.terminate();
		}
		this.suspendedActivations.clear();
	}

	public void createNodeActivations(List<ActivityNode> nodes) {
		// Add activity node activations for the given set of nodes to this
		// group and create edge instances between them.
		for (int i = 0; i < nodes.size(); i++) {
			ActivityNode node = nodes.get(i);
			Debug.println("[createNodeActivations] Creating a node activation for " + node.getName() + "...");
			this.createNodeActivation(node);
		}
	}

	public IActivityNodeActivation createNodeActivation(ActivityNode node) {
		// Create an activity node activation for a given activity node in this
		// activity node activation group.

		// fUML12-10 certain boolean flags are not properly initialized in come cases

		IActivityNodeActivation activation = (IActivityNodeActivation) (this.getActivityExecution().getLocus().getFactory().instantiateVisitor(node));
		activation.initialize(node, this);
		this.nodeActivations.add(activation);
		activation.createNodeActivations();
		return activation;
	}

	public IActivityNodeActivation getNodeActivation(ActivityNode node) {
		// Return the node activation (if any) in this group,
		// or any nested group, corresponding to the given activity node.
		// If this is a group for a structured activity node activation,
		// also include the pin activations for that node activation.
		IActivityNodeActivation activation = null;
		if (this.containingNodeActivation != null && node instanceof Pin) {
			activation = this.containingNodeActivation.getPinActivation((Pin) node);
		}
		if (activation == null) {
			int i = 1;
			while (activation == null & i <= this.nodeActivations.size()) {
				activation = this.nodeActivations.get(i - 1).getNodeActivation(node);
				i = i + 1;
			}
		}
		return activation;
	}

	public void createEdgeInstances(List<ActivityEdge> edges) {
		// Create instance edges for the given activity edges, as well as for
		// edge instances within any nodes activated in this group.

		// fUML12-10 certain boolean flags are not properly initialized in come cases

		for (int i = 0; i < edges.size(); i++) {
			ActivityEdge edge = edges.get(i);
			Debug.println("[createEdgeInstances] Creating an edge instance from " + edge.getSource().getName() + " to " + edge.getTarget().getName() + ".");
			// Note creation of visitors for edge instance is made by the execution factory
			IActivityEdgeInstance edgeInstance = (IActivityEdgeInstance) (this.getActivityExecution().getLocus().getFactory().instantiateVisitor(edge));
			edgeInstance.setEdge(edge);
			edgeInstance.setGroup(this);
			this.edgeInstances.add(edgeInstance);
			this.getNodeActivation(edge.getSource()).addOutgoingEdge(edgeInstance);
			this.getNodeActivation(edge.getTarget()).addIncomingEdge(edgeInstance);
			// Debug.println("[createEdgeInstances] Edge instance created...");
		}
		List<IActivityNodeActivation> nodeActivations = this.nodeActivations;
		for (int i = 0; i < nodeActivations.size(); i++) {
			IActivityNodeActivation nodeActivation = nodeActivations.get(i);
			nodeActivation.createEdgeInstances();
		}
		// Debug.println("[createEdgeInstances] Done creating edge instances.");
	}

	public IActivityExecution getActivityExecution() {
		// Return the activity execution to which this group belongs, directly
		// or indirectly.
		IActivityExecution activityExecution = this.activityExecution;
		if (activityExecution == null) {
			activityExecution = this.containingNodeActivation.getGroup().getActivityExecution();
		}
		// Debug.println("[getActivityExecution] activityExecution = " +
		// activityExecution);
		return activityExecution;
	}

	public List<IActivityParameterNodeActivation> getOutputParameterNodeActivations() {
		// Return the set of all activations in this group of activity parameter
		// nodes for output (inout, out and return) parameters.
		List<IActivityParameterNodeActivation> parameterNodeActivations = new ArrayList<IActivityParameterNodeActivation>();
		List<IActivityNodeActivation> nodeActivations = this.nodeActivations;
		for (int i = 0; i < nodeActivations.size(); i++) {
			IActivityNodeActivation activation = nodeActivations.get(i);
			if (activation instanceof IActivityParameterNodeActivation) {
				if (activation.getIncomingEdges().size() > 0) {
					parameterNodeActivations.add((IActivityParameterNodeActivation) activation);
				}
			}
		}
		return parameterNodeActivations;
	}

	public Boolean hasSourceFor(IActivityEdgeInstance edgeInstance) {
		// Returns true if this activation group has a node activation
		// corresponding to the source of the given edge instance.
		boolean hasSource = false;
		List<IActivityNodeActivation> activations = this.nodeActivations;
		int i = 1;
		while (!hasSource & i <= activations.size()) {
			hasSource = activations.get(i - 1).isSourceFor(edgeInstance);
			i = i + 1;
		}
		return hasSource;
	}

	public Boolean isSuspended() {
		// Check if this activitation group has any suspended activations and
		// is,
		// therefore, itself suspended.
		return this.suspendedActivations.size() > 0;
	}

	public void suspend(IActivityNodeActivation activation) {
		// Suspend the given activation in this activation group. If this is
		// the only suspended activation, and the activation group has a
		// containing node activation, then suspend that containing activation.
		Debug.println("[suspend] node=" + (activation.getNode() == null ? "null" : activation.getNode().getName()));
		if (!this.isSuspended()) {
			IStructuredActivityNodeActivation containingNodeActivation = this.containingNodeActivation;
			if (containingNodeActivation != null) {
				containingNodeActivation.suspend();
			}
		}
		this.suspendedActivations.add(activation);
	}

	public void resume(IActivityNodeActivation activation) {
		// Resume the given activation by removing it from the suspended
		// activation list for this activation group. If this is the last
		// suspended activation, and the activation group has a containing
		// node activation, then resume that containing activation.
		Debug.println("[resume] node=" + (activation.getNode() == null ? "null" : activation.getNode().getName()));
		boolean found = false;
		int i = 1;
		while (!found & i <= this.suspendedActivations.size()) {
			if (this.suspendedActivations.get(i - 1) == activation) {
				this.suspendedActivations.remove(i - 1);
				found = true;
			}
			i = i + 1;
		}
		if (!this.isSuspended()) {
			IStructuredActivityNodeActivation containingNodeActivation = this.containingNodeActivation;
			if (containingNodeActivation != null) {
				containingNodeActivation.resume();
			}
		}
	}

	public void setContainingActivation(IStructuredActivityNodeActivation activation) {
		this.containingNodeActivation = activation;
	}

	public IStructuredActivityNodeActivation getContainingActivation() {
		return this.containingNodeActivation;
	}

	public List<IActivityNodeActivation> getActivityNodeActivations() {
		return this.nodeActivations;
	}

	public void setActivityExecution_(IActivityExecution execution) {
		this.activityExecution = execution;
		
	}

	public IActivityExecution getActivityExecution_() {
		return this.activityExecution;
	}
}
