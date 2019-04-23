/*****************************************************************************
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
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.profiling.Semantics.Actions.BasicActions;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Profiling.IObjectNodeActivationWrapper;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivationGroup;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IObjectNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.uml2.uml.ActivityNode;

public class ObjectNodeActivationWrapper implements IObjectNodeActivationWrapper{

	// The activation receiving the offer
	protected IObjectNodeActivation activation;
	
	// Token set offered to the activation
	protected List<IToken> offeredTokens;

	public ObjectNodeActivationWrapper(IObjectNodeActivation activation, List<IToken> offeredTokens) {
		this.activation = activation;
		this.offeredTokens = offeredTokens;
	}
	
	@Override
	public Integer countOfferedValues() {
		return this.activation.countOfferedValues();
	}

	@Override
	public void sendUnofferedTokens() {
		this.activation.sendUnofferedTokens();
	}

	@Override
	public Integer countUnofferedTokens() {
		return this.activation.countUnofferedTokens();
	}

	@Override
	public List<IToken> getUnofferedTokens() {
		return this.activation.getUnofferedTokens();
	}

	@Override
	public List<IToken> takeUnofferedTokens() {
		return this.activation.takeUnofferedTokens();
	}

	@Override
	public void run() {
		this.activation.run();
	}

	@Override
	public void receiveOffer() {
		this.activation.receiveOffer();
	}

	@Override
	public List<IToken> takeOfferedTokens() {
		return this.activation.takeOfferedTokens();
	}

	@Override
	public void fire(List<IToken> incomingTokens) {
		this.activation.fire(incomingTokens);
	}

	@Override
	public void sendOffers(List<IToken> tokens) {
		this.activation.sendOffers(tokens);
	}

	@Override
	public void terminate() {
		this.activation.terminate();
	}

	@Override
	public Boolean isReady() {
		return this.activation.isReady();
	}

	@Override
	public Boolean isRunning() {
		return this.activation.isRunning();
	}

	@Override
	public void addOutgoingEdge(IActivityEdgeInstance edge) {
		this.activation.addOutgoingEdge(edge);
	}

	@Override
	public void addIncomingEdge(IActivityEdgeInstance edge) {
		this.activation.addIncomingEdge(edge);
	}

	@Override
	public void createNodeActivations() {
		this.activation.createNodeActivations();
	}

	@Override
	public void createEdgeInstances() {
		this.activation.createEdgeInstances();
	}

	@Override
	public Boolean isSourceFor(IActivityEdgeInstance edgeInstance) {
		return this.activation.isSourceFor(edgeInstance);
	}

	@Override
	public IActivityExecution getActivityExecution() {
		return this.activation.getActivityExecution();
	}

	@Override
	public IObject_ getExecutionContext() {
		return this.activation.getExecutionContext();
	}

	@Override
	public ILocus getExecutionLocus() {
		return this.activation.getExecutionLocus();
	}

	@Override
	public IActivityNodeActivation getNodeActivation(ActivityNode node) {
		return this.activation.getNodeActivation(node);
	}

	@Override
	public void addToken(IToken token) {
		this.activation.addToken(token);
	}

	@Override
	public Integer removeToken(IToken token) {
		return this.activation.removeToken(token);
	}

	@Override
	public void addTokens(List<IToken> tokens) {
		this.activation.addTokens(tokens);
	}

	@Override
	public List<IToken> takeTokens() {
		return this.activation.takeTokens();
	}

	@Override
	public void clearTokens() {
		this.activation.clearTokens();
	}

	@Override
	public List<IToken> getTokens() {
		return this.activation.getTokens();
	}

	@Override
	public void initialize(ActivityNode node, IActivityNodeActivationGroup group) {
		this.activation.initialize(node, group);
	}

	@Override
	public void suspend() {
		this.activation.suspend();
	}

	@Override
	public void resume() {
		this.activation.suspend();
	}

	@Override
	public void setNode(ActivityNode node) {
		this.activation.setNode(node);
	}

	@Override
	public ActivityNode getNode() {
		return this.activation.getNode();
	}

	@Override
	public void setGroup(IActivityNodeActivationGroup group) {
		this.activation.setGroup(group);
	}

	@Override
	public IActivityNodeActivationGroup getGroup() {
		return this.activation.getGroup();
	}

	@Override
	public List<IActivityEdgeInstance> getIncomingEdges() {
		return this.activation.getIncomingEdges();
	}

	@Override
	public List<IActivityEdgeInstance> getOutgoingEdges() {
		return this.activation.getOutgoingEdges();
	}

	@Override
	public void setRunning(Boolean status) {
		this.activation.setRunning(status);
	}

	@Override
	public void _endIsolation() {
		this.activation._endIsolation();
	}

	@Override
	public void _beginIsolation() {
		this.activation._beginIsolation();
	}

	@Override
	public List<IToken> getOffer() {
		return this.offeredTokens;
	}
	

}
