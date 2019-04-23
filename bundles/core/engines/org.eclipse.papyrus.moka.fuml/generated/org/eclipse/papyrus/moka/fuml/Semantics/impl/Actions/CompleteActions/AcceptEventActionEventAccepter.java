/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
 *  CEA LIST - Initial API and implementation
 *  Jeremie Tatibouet (CEA) - Apply Fix fUML12-35 Initial execution of an activity is not run to completion
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.CompleteActions;

import org.eclipse.papyrus.moka.fuml.Semantics.Actions.CompleteActions.IAcceptEventActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.CompleteActions.IAcceptEventActionEventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications.EventAccepter;

public class AcceptEventActionEventAccepter extends EventAccepter implements IAcceptEventActionEventAccepter {

	/*
	 * The accept event action activation on behalf of which this event accepter
	 * is waiting.
	 */
	public IAcceptEventActionActivation actionActivation;

	public void accept(IEventOccurrence eventOccurrence) {
		// Accept an event occurrence and forward it to the action activation.
		this.actionActivation.accept(eventOccurrence);
	}

	public Boolean match(IEventOccurrence eventOccurrence) {
		// Return true if the given event occurrence matches a trigger of the accept event 
		// action of the action activation.
		return this.actionActivation.match(eventOccurrence);
	}

	public IAcceptEventActionActivation getActionActivation() {
		return this.getActionActivation();
	}

	public void setAcceptEventActionActivation(IAcceptEventActionActivation actionActivation) {
		this.actionActivation = actionActivation;
	}
}
