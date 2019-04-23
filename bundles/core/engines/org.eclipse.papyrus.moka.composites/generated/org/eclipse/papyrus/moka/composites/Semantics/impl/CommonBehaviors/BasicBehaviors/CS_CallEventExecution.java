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

package org.eclipse.papyrus.moka.composites.Semantics.impl.CommonBehaviors.BasicBehaviors;

import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.InvocationActions.CS_EventOccurrence;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CommonBehaviors.BasicBehaviors.ICS_CallEventExecution;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.InvocationActions.ICS_EventOccurrence;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_InteractionPoint;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.CallEventExecution;

public class CS_CallEventExecution extends CallEventExecution implements ICS_CallEventExecution{

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
