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
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Vertex;

public interface IStateActivation extends IVertexActivation{

	public void setEntryCompletion(boolean completed);
	
	public void setExitCompletion(boolean completed);
	
	public void setDoActivityCompletion(boolean completed);
	
	public boolean hasCompleted();
	
	public void complete();
	
	public List<IPseudostateActivation> getConnectionPointActivation();
	
	public IPseudostateActivation getConnectionPointActivation(Vertex vertex);
	
	public Behavior getEntry();
	
	public Behavior getExit();
	
	public Behavior getDoActivity();
	
	public void tryExecuteEntry(IEventOccurrence eventOccurrence);
	
	public void tryInvokeDoActivity(IEventOccurrence eventOccurrence);
	
	public void tryExecuteExit(IEventOccurrence eventOccurrence);
	
	public void enterRegions(ITransitionActivation enteringTransition, IEventOccurrence eventOccurrence);
	
	public List<ITransitionActivation> getFireableTransitions(IEventOccurrence eventOccurrence);
	
	public boolean canDefer(IEventOccurrence eventOccurrence);
	
	public void defer(IEventOccurrence eventOccurrence);
	
	public void releaseDeferredEvents();
	
	public List<IRegionActivation> getRegionActivation();
	
}
