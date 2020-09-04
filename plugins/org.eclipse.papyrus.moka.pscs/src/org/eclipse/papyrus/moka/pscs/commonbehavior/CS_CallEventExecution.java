/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.pscs.commonbehavior;

import org.eclipse.papyrus.moka.fuml.commonbehavior.CallEventExecution;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IValue;
import org.eclipse.papyrus.moka.pscs.structuredclassifiers.ICS_InteractionPoint;

public class CS_CallEventExecution extends CallEventExecution implements ICS_CallEventExecution {

	// The port manifestation at which the operation call arrived.
	public ICS_InteractionPoint interactionPoint;

	@Override
	public IEventOccurrence createEventOccurrence() {
		// Wrap the created event occurrence within a CS_EventOccurrence which
		// references the behavior port on which the call was dispatched.
		ICS_EventOccurrence wrappingEventOccurrence = new CS_EventOccurrence();
		wrappingEventOccurrence.setInteractionPoint(this.interactionPoint);
		wrappingEventOccurrence.setWrappedEventOccurrence(super.createEventOccurrence());
		return wrappingEventOccurrence;
	}

	public IValue new_() {
		// Create a new call event execution.
		return new CS_CallEventExecution();
	}

	public IValue copy() {
		// Create a new call event execution that is a copy of this execution, no
		// referenced interaction point.
		CS_CallEventExecution copy = (CS_CallEventExecution) super.copy();
		copy.interactionPoint = null;
		return copy;
	}

	@Override
	public void setInteractionPoint(ICS_InteractionPoint interactionPoint) {
		this.interactionPoint = interactionPoint;
	}

	@Override
	public ICS_InteractionPoint getInteractionPoint() {
		return this.interactionPoint;
	}

}
