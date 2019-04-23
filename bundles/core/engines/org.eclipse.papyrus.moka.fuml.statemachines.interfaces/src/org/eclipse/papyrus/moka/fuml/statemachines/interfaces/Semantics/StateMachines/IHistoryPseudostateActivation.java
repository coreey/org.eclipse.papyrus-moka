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

public interface IHistoryPseudostateActivation extends IPseudostateActivation{

	public boolean hasDefaultTransition();
	
	public void restore(IStateActivation stateActivation, ITransitionActivation enteringTransition, IEventOccurrence eventOccurrence);
	
	public abstract void restore(IRegionActivation regionActivation, ITransitionActivation enteringTransition, IEventOccurrence eventOccurrence);
	
}
