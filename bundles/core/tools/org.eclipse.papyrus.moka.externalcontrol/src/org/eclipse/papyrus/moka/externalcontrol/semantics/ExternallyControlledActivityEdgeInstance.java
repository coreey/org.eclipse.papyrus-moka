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

import java.util.List;

import org.eclipse.papyrus.moka.externalcontrol.advice.IControllerAdvice;
import org.eclipse.papyrus.moka.externalcontrol.controller.AbstractExternallyControlledVisitor;
import org.eclipse.papyrus.moka.externalcontrol.controller.ExternalController;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivationGroup;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.uml2.uml.ActivityEdge;

public class ExternallyControlledActivityEdgeInstance extends AbstractExternallyControlledVisitor<IActivityEdgeInstance> implements IActivityEdgeInstance {

	
	public ExternallyControlledActivityEdgeInstance(IActivityEdgeInstance visitor, ExternalController controller, List<IControllerAdvice> advices) {
		super(visitor, controller, advices);
	}


	@Override
	protected void doSemanticAction() {
		//do nothing
	}
	
	@Override
	public void sendOffer(List<IToken> tokens) {
			suspendedTokens = tokens;
			suspendForControl();
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public AbstractExternallyControlledVisitor<? extends ISemanticVisitor> getStackParent() {
		//TODO to be implemented
		return null;
	}
	
	@Override
	public void doResumeExecution() {
		delegatedVisitor.sendOffer(suspendedTokens);
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
	public Integer countOfferedValues() {
		return delegatedVisitor.countOfferedValues();
	}

	@Override
	public List<IToken> takeOfferedTokens() {
		return delegatedVisitor.takeOfferedTokens();
	}

	@Override
	public List<IToken> takeOfferedTokens(Integer maxCount) {
		return delegatedVisitor.takeOfferedTokens(maxCount);
	}

	@Override
	public List<IToken> getOfferedTokens() {
		return delegatedVisitor.getOfferedTokens();
	}

	@Override
	public Boolean hasOffer() {
		return delegatedVisitor.hasOffer();
	}

	@Override
	public void setSource(IActivityNodeActivation source) {
		delegatedVisitor.setSource(source);	
	}

	@Override
	public IActivityNodeActivation getSource() {
		return delegatedVisitor.getSource();
	}

	@Override
	public void setTarget(IActivityNodeActivation target) {
		delegatedVisitor.setTarget(target);
		
	}

	@Override
	public IActivityNodeActivation getTarget() {
		return delegatedVisitor.getTarget();
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
	public void setEdge(ActivityEdge edge) {
		delegatedVisitor.setEdge(edge);
		
	}

	@Override
	public ActivityEdge getEdge() {
		return delegatedVisitor.getEdge();
	}


}
