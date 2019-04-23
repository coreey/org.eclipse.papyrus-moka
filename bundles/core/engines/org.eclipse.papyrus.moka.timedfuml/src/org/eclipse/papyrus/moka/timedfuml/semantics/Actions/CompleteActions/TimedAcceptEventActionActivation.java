/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * 	Sahar Guermazi
 * 	Jeremie Tatibouet (CEA LIST)
 *  CEA LIST Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.moka.timedfuml.semantics.Actions.CompleteActions;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.CompleteActions.AcceptEventActionActivation;
import org.eclipse.papyrus.moka.timedfuml.utils.DESchedulerUtils;
import org.eclipse.uml2.uml.AcceptEventAction;

public class TimedAcceptEventActionActivation extends AcceptEventActionActivation {

	@Override
	public void fire(List<IToken> incomingTokens) {
		// Behaves like in fUML. Then install timers corresponding
		// to expected time events to the clock (i.e., the DEScheduler).
		super.fire(incomingTokens);
		DESchedulerUtils.pushEvents(((AcceptEventAction) this.getNode()).getTriggers(), this, this.getExecutionContext());
	}
	
	@Override
	public void accept(IEventOccurrence eventOccurrence) {
		// Cancel remaining timers installed by this visitor (if any)
		// Behaves like in fUML.
		DESchedulerUtils.cancelEvents(this);
		super.accept(eventOccurrence);
	}
	
	@Override
	public void terminate() {
		// Behaves like fUML. Cancel remaining timers installed by this
		// visitor (if any)
		super.terminate();
		DESchedulerUtils.cancelEvents(this);
	}

}
