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

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.uml2.uml.Vertex;

public interface IRegionActivation extends IStateMachineSemanticVisitor {

	public void setCompleted(boolean completed);
	
	public boolean isCompleted();
	
	public IVertexActivation getVertexActivation(Vertex vertex);
	
	public boolean canPropagateExecution(IEventOccurrence eventOccurrence, ITransitionActivation enteringTransition);
	
	public IPseudostateActivation getOrigin();
	
	public void enter(ITransitionActivation enteringTransition, IEventOccurrence eventOccurrence);
	
	public void exit(ITransitionActivation exitingTransition, IEventOccurrence eventOccurrence);
	
	public void terminate();
	
	public void setHistory(IStateActivation history);
	
	public IStateActivation getHistory();
	
	public List<IVertexActivation> getVertexActivations();
	
	public List<ITransitionActivation> getTransitionActivations();
	
}
