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

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.uml2.uml.ActivityNode;

public interface IActivityNodeActivation extends ISemanticVisitor {

	public void run();

	public void receiveOffer();

	public List<IToken> takeOfferedTokens();

	public void fire(List<IToken> incomingTokens);

	public void sendOffers(List<IToken> tokens);

	public void terminate();

	public Boolean isReady();

	public Boolean isRunning();

	public void addOutgoingEdge(IActivityEdgeInstance edge);

	public void addIncomingEdge(IActivityEdgeInstance edge);

	public void createNodeActivations();

	public void createEdgeInstances();

	public Boolean isSourceFor(IActivityEdgeInstance edgeInstance);

	public IActivityExecution getActivityExecution();

	public IObject_ getExecutionContext();

	public ILocus getExecutionLocus();

	public IActivityNodeActivation getNodeActivation(ActivityNode node);

	public void addToken(IToken token);

	public Integer removeToken(IToken token);

	public void addTokens(List<IToken> tokens);

	public List<IToken> takeTokens();

	public void clearTokens();

	public List<IToken> getTokens();

	public void initialize(ActivityNode node, IActivityNodeActivationGroup group);

	public void suspend();

	public void resume();

	public void setNode(ActivityNode node);

	public ActivityNode getNode();

	public void setGroup(IActivityNodeActivationGroup group);

	public IActivityNodeActivationGroup getGroup();

	public List<IActivityEdgeInstance> getIncomingEdges();

	public List<IActivityEdgeInstance> getOutgoingEdges();

	public void setRunning(Boolean status);
}
