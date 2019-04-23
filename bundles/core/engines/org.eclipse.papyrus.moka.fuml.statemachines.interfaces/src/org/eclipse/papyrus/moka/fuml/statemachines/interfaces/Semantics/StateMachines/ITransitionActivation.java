/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
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
 *  Jeremie Tatibouet (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;

public interface ITransitionActivation extends IStateMachineSemanticVisitor{

	public void setStatus(TransitionMetadata status);
	
	public TransitionMetadata getStatus();
	
	public void setAnalyticalStatus(TransitionMetadata status);
	
	public TransitionMetadata getAnalyticalStatus();
	
	public boolean isReached(boolean staticCheck);
	
	public boolean isTraversed(boolean staticCheck);
	
	public boolean isTriggered();
	
	public boolean isGuarded();
	
	public IVertexActivation getSourceActivation();
	
	public void setSourceActivation(IVertexActivation vertexSourceActivation);
	
	public IVertexActivation getTargetActivation();
	
	public void setTargetActivation(IVertexActivation vertexTargetActivation);
	
	public boolean evaluateGuard(IEventOccurrence eventOccurrence);
	
	public boolean hasTrigger(IEventOccurrence eventOccurrence);
	
	public boolean canFireOn(IEventOccurrence eventOccurrence);
	
	public boolean canPropagateExecution(IEventOccurrence eventOccurrence);
	
	public void tryExecuteEffect(IEventOccurrence eventOccurrence);
	
	public void fire(IEventOccurrence eventOccurrence);
	
	public IRegionActivation getLeastCommonAncestor();
	
	public void exitSource(IEventOccurrence eventOccurrence);
	
	public void enterTarget(IEventOccurrence eventOccurrence);

}
