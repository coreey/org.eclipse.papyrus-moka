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
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;

public class InternalTransitionActivation extends TransitionActivation{
	
	@Override
	public void exitSource(IEventOccurrence eventOccurrence) {
		// An internal transition does not cause exit of the source state
		return;
	}
	
	public void enterTarget(IEventOccurrence eventOccurrence) {
		// An internal transition does not cause entry of the target state
		return;
	}
	
}
