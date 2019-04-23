/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
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

package org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Activities.CompleteStructuredActivities.IStructuredActivityNodeActivation;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;

public interface IActivityNodeActivationGroup {

	public void run(List<IActivityNodeActivation> activations);

	public Boolean checkIncomingEdges(List<IActivityEdgeInstance> incomingEdges, List<IActivityNodeActivation> activations);

	public void runNodes(List<ActivityNode> nodes);

	public void activate(List<ActivityNode> nodes, List<ActivityEdge> edges);

	public void terminateAll();

	public void createNodeActivations(List<ActivityNode> nodes);

	public IActivityNodeActivation createNodeActivation(ActivityNode node);

	public IActivityNodeActivation getNodeActivation(ActivityNode node);

	public void createEdgeInstances(List<ActivityEdge> edges);

	public IActivityExecution getActivityExecution();

	public void setActivityExecution_(IActivityExecution execution);
	
	public IActivityExecution getActivityExecution_();

	public List<IActivityParameterNodeActivation> getOutputParameterNodeActivations();

	public Boolean hasSourceFor(IActivityEdgeInstance edgeInstance);

	public Boolean isSuspended();

	public void suspend(IActivityNodeActivation activation);

	public void resume(IActivityNodeActivation activation);

	public void setContainingActivation(IStructuredActivityNodeActivation activation);

	public IStructuredActivityNodeActivation getContainingActivation();

	public List<IActivityNodeActivation> getActivityNodeActivations();

}
