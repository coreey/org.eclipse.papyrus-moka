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

package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines;

import java.util.List;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.profiling.Semantics.CommonBehaviors.Communications.TriggeredVisitorWrapper;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IRegionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.ITransitionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IVertexActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.TransitionMetadata;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.NamedElement;

public class TransitionActivationWrapper extends TriggeredVisitorWrapper implements ITransitionActivation {

	// The original activation for the transition
	protected ITransitionActivation transitionActivation;

	public TransitionActivationWrapper(ITransitionActivation activation, IEventOccurrence eventOccurrence) {
		super(eventOccurrence);
		this.transitionActivation = activation;
	}

	@Override
	public void setStatus(TransitionMetadata status) {
		this.transitionActivation.setStatus(status);
	}

	@Override
	public TransitionMetadata getStatus() {
		return this.transitionActivation.getStatus();
	}

	@Override
	public void setAnalyticalStatus(TransitionMetadata status) {
		this.transitionActivation.setAnalyticalStatus(status);
	}

	@Override
	public TransitionMetadata getAnalyticalStatus() {
		return this.transitionActivation.getAnalyticalStatus();
	}

	@Override
	public boolean isReached(boolean staticCheck) {
		return this.transitionActivation.isReached(staticCheck);
	}

	@Override
	public boolean isTraversed(boolean staticCheck) {
		return this.transitionActivation.isTraversed(staticCheck);
	}

	@Override
	public boolean isTriggered() {
		return this.transitionActivation.isTriggered();
	}

	@Override
	public boolean isGuarded() {
		return this.transitionActivation.isTriggered();
	}

	@Override
	public IVertexActivation getSourceActivation() {
		return this.transitionActivation.getSourceActivation();
	}

	@Override
	public void setSourceActivation(IVertexActivation vertexSourceActivation) {
		this.transitionActivation.setSourceActivation(vertexSourceActivation);
	}

	@Override
	public IVertexActivation getTargetActivation() {
		return this.transitionActivation.getTargetActivation();
	}

	@Override
	public void setTargetActivation(IVertexActivation vertexTargetActivation) {
		this.transitionActivation.setTargetActivation(vertexTargetActivation);
	}

	@Override
	public boolean evaluateGuard(IEventOccurrence eventOccurrence) {
		return this.transitionActivation.evaluateGuard(eventOccurrence);
	}

	@Override
	public boolean hasTrigger(IEventOccurrence eventOccurrence) {
		return this.transitionActivation.hasTrigger(eventOccurrence);
	}

	@Override
	public boolean canFireOn(IEventOccurrence eventOccurrence) {
		return this.transitionActivation.canFireOn(eventOccurrence);
	}

	@Override
	public boolean canPropagateExecution(IEventOccurrence eventOccurrence) {
		return this.transitionActivation.canPropagateExecution(eventOccurrence);
	}

	@Override
	public void tryExecuteEffect(IEventOccurrence eventOccurrence) {
		this.transitionActivation.tryExecuteEffect(eventOccurrence);
	}

	@Override
	public void fire(IEventOccurrence eventOccurrence) {
		this.transitionActivation.fire(eventOccurrence);
	}

	@Override
	public IRegionActivation getLeastCommonAncestor() {
		return this.transitionActivation.getLeastCommonAncestor();
	}

	@Override
	public void exitSource(IEventOccurrence eventOccurrence) {
		this.transitionActivation.exitSource(eventOccurrence);
	}

	@Override
	public void enterTarget(IEventOccurrence eventOccurrence) {
		this.transitionActivation.enterTarget(eventOccurrence);
	}

	@Override
	public void setNode(NamedElement node) {
		this.transitionActivation.setNode(node);
	}

	@Override
	public NamedElement getNode() {
		return this.transitionActivation.getNode();
	}

	@Override
	public void setParent(ISemanticVisitor parent) {
		this.transitionActivation.setParent(parent);
	}

	@Override
	public ISemanticVisitor getParent() {
		return this.transitionActivation.getParent();
	}

	@Override
	public List<ISemanticVisitor> getContextChain() {
		return this.transitionActivation.getContextChain();
	}

	@Override
	public IExecution getStateMachineExecution() {
		return this.transitionActivation.getStateMachineExecution();
	}

	@Override
	public ILocus getExecutionLocus() {
		return this.transitionActivation.getExecutionLocus();
	}

	@Override
	public IObject_ getExecutionContext() {
		return this.transitionActivation.getExecutionContext();
	}

	@Override
	public boolean isVisitorFor(NamedElement node) {
		return this.transitionActivation.isVisitorFor(node);
	}

	@Override
	public void activate() {
		this.transitionActivation.activate();
	}

	@Override
	public void activateTransitions() {
		this.transitionActivation.activateTransitions();
	}

	@Override
	public IExecution getExecutionFor(Behavior behavior, IEventOccurrence eventOccurrence) {
		return this.transitionActivation.getExecutionFor(behavior, eventOccurrence);
	}

	@Override
	public void _endIsolation() {
		this.transitionActivation._endIsolation();
	}

	@Override
	public void _beginIsolation() {
		this.transitionActivation._beginIsolation();
	}
	
	@Override
	public String toString() {
		return this.transitionActivation.toString();
	}

}
