/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Jeremie Tatibouet (CEA LIST)
 *
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;

public interface IDeferredEventOccurrence extends IEventOccurrence{

	public void register(IStateActivation stateActivation);
	
	public IStateActivation getConstrainingStateActivation();
	
	public void setConstrainingStateActivation(IStateActivation constrainingState);
	
	public IEventOccurrence getDeferredEventOccurrence();
	
	public void setDeferredEventOccurrence(IEventOccurrence deferredEvent);
	
}
