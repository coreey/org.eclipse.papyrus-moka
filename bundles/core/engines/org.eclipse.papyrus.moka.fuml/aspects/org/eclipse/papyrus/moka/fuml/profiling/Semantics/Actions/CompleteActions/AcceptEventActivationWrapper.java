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

package org.eclipse.papyrus.moka.fuml.profiling.Semantics.Actions.CompleteActions;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IPinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.CompleteActions.IAcceptEventActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.CompleteActions.IAcceptEventActionEventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivationGroup;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IBooleanValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.ILink;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.fuml.profiling.Semantics.CommonBehaviors.Communications.TriggeredVisitorWrapper;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Pin;

public class AcceptEventActivationWrapper extends TriggeredVisitorWrapper implements IAcceptEventActionActivation{

	protected IAcceptEventActionActivation acceptEventActivation;
	
	public AcceptEventActivationWrapper(IAcceptEventActionActivation acceptEventActivation, IEventOccurrence eventOccurrence) {
		super(eventOccurrence);
		this.acceptEventActivation = acceptEventActivation;
	}

	@Override
	public void doAction() {
		this.acceptEventActivation.doAction();
	}

	@Override
	public void sendOffers() {
		this.acceptEventActivation.sendOffers();
	}

	@Override
	public void addPinActivation(IPinActivation pinActivation) {
		this.acceptEventActivation.addPinActivation(pinActivation);
	}

	@Override
	public IPinActivation getPinActivation(Pin pin) {
		return this.acceptEventActivation.getPinActivation(pin);
	}

	@Override
	public void putToken(OutputPin pin, IValue value) {
		this.acceptEventActivation.putToken(pin, value);
	}

	@Override
	public void putTokens(OutputPin pin, List<IValue> values) {
		this.acceptEventActivation.putTokens(pin, values);
	}

	@Override
	public List<IValue> getTokens(InputPin pin) {
		return this.acceptEventActivation.getTokens(pin);
	}

	@Override
	public List<IValue> takeTokens(InputPin pin) {
		return this.acceptEventActivation.takeTokens(pin);
	}

	@Override
	public Boolean valueParticipatesInLink(IValue value, ILink link) {
		return this.acceptEventActivation.valueParticipatesInLink(value, link);
	}

	@Override
	public IBooleanValue makeBooleanValue(Boolean value) {
		return this.acceptEventActivation.makeBooleanValue(value);
	}

	@Override
	public void run() {
		this.acceptEventActivation.run();
	}

	@Override
	public void receiveOffer() {
		this.acceptEventActivation.receiveOffer();
	}

	@Override
	public List<IToken> takeOfferedTokens() {
		return this.acceptEventActivation.takeOfferedTokens();
	}

	@Override
	public void fire(List<IToken> incomingTokens) {
		this.acceptEventActivation.fire(incomingTokens);		
	}

	@Override
	public void sendOffers(List<IToken> tokens) {
		this.acceptEventActivation.sendOffers(tokens);
	}

	@Override
	public void terminate() {
		this.acceptEventActivation.terminate();
	}

	@Override
	public Boolean isReady() {
		return this.acceptEventActivation.isReady();
	}

	@Override
	public Boolean isRunning() {
		return this.acceptEventActivation.isRunning();
	}

	@Override
	public void addOutgoingEdge(IActivityEdgeInstance edge) {
		this.acceptEventActivation.addOutgoingEdge(edge);
	}

	@Override
	public void addIncomingEdge(IActivityEdgeInstance edge) {
		this.acceptEventActivation.addIncomingEdge(edge);
	}

	@Override
	public void createNodeActivations() {
		this.acceptEventActivation.createNodeActivations();
	}

	@Override
	public void createEdgeInstances() {
		this.acceptEventActivation.createEdgeInstances();
	}

	@Override
	public Boolean isSourceFor(IActivityEdgeInstance edgeInstance) {
		return this.acceptEventActivation.isSourceFor(edgeInstance);
	}

	@Override
	public IActivityExecution getActivityExecution() {
		return this.acceptEventActivation.getActivityExecution();
	}

	@Override
	public IObject_ getExecutionContext() {
		return this.acceptEventActivation.getExecutionContext();
	}

	@Override
	public ILocus getExecutionLocus() {
		return this.acceptEventActivation.getExecutionLocus();
	}

	@Override
	public IActivityNodeActivation getNodeActivation(ActivityNode node) {
		return this.acceptEventActivation.getNodeActivation(node);
	}

	@Override
	public void addToken(IToken token) {
		this.acceptEventActivation.addToken(token);
	}

	@Override
	public Integer removeToken(IToken token) {
		return this.acceptEventActivation.removeToken(token);
	}

	@Override
	public void addTokens(List<IToken> tokens) {
		this.acceptEventActivation.addTokens(tokens);
	}

	@Override
	public List<IToken> takeTokens() {
		return this.acceptEventActivation.takeTokens();
	}

	@Override
	public void clearTokens() {
		this.acceptEventActivation.clearTokens();
	}

	@Override
	public List<IToken> getTokens() {
		return this.acceptEventActivation.getTokens();
	}

	@Override
	public void initialize(ActivityNode node, IActivityNodeActivationGroup group) {
		this.acceptEventActivation.initialize(node, group);
	}

	@Override
	public void suspend() {
		this.acceptEventActivation.suspend();
	}

	@Override
	public void resume() {
		this.acceptEventActivation.resume();
	}

	@Override
	public void setNode(ActivityNode node) {
		this.acceptEventActivation.setNode(node);
	}

	@Override
	public ActivityNode getNode() {
		return this.acceptEventActivation.getNode();
	}

	@Override
	public void setGroup(IActivityNodeActivationGroup group) {
		this.acceptEventActivation.setGroup(group);
	}

	@Override
	public IActivityNodeActivationGroup getGroup() {
		return this.acceptEventActivation.getGroup();
	}

	@Override
	public List<IActivityEdgeInstance> getIncomingEdges() {
		return this.acceptEventActivation.getIncomingEdges();
	}

	@Override
	public List<IActivityEdgeInstance> getOutgoingEdges() {
		return this.acceptEventActivation.getOutgoingEdges();
	}

	@Override
	public void setRunning(Boolean status) {
		this.acceptEventActivation.setRunning(status);
	}

	@Override
	public void _endIsolation() {
		this.acceptEventActivation._endIsolation();
	}

	@Override
	public void _beginIsolation() {
		this.acceptEventActivation._beginIsolation();
	}

	@Override
	public void accept(IEventOccurrence eventOccurrence) {
		this.acceptEventActivation.accept(eventOccurrence);
	}

	@Override
	public Boolean match(IEventOccurrence eventOccurrence) {
		return this.acceptEventActivation.match(eventOccurrence);
	}

	@Override
	public IAcceptEventActionEventAccepter getEventAccepter() {
		return this.acceptEventActivation.getEventAccepter();
	}

}
