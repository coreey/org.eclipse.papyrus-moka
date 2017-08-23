/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.InvocationActions;

import java.util.List;

import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.InvocationActions.ICS_EventOccurrence;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_InteractionPoint;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications.EventOccurrence;
import org.eclipse.uml2.uml.Trigger;

public class CS_EventOccurrence extends EventOccurrence implements ICS_EventOccurrence {

	// Real event occurrence
	public IEventOccurrence wrappedEventOccurrence;

	// Port manifestation from which the wrapped event occurrence was received.
	public ICS_InteractionPoint interactionPoint;

	@Override
	public boolean match(Trigger trigger) {
		// If the trigger references ports then to match this latter it is required that
		// 1] the interaction point is instance of port referenced by the trigger
		// 2] the referenced event occurrence match operation returns true.
		// If the trigger does not reference ports then the behavior is the same than for fUML.
		boolean matches = false;
		if (trigger.getPorts().size() > 0) {
			int i = 1;
			while (!matches && i <= trigger.getPorts().size()) {
				if (this.interactionPoint.getDefiningPort() == trigger.getPorts().get(i - 1)) {
					matches = true;
				}
				i++;
			}
			if (matches) {
				matches = this.wrappedEventOccurrence.match(trigger);
			}
		} else {
			matches = this.wrappedEventOccurrence.match(trigger);
		}
		return matches;
	}

	@Override
	public List<IParameterValue> getParameterValues() {
		// Return the parametric data of the referenced event occurrence
		return this.wrappedEventOccurrence.getParameterValues();
	}

	@Override
	public void setWrappedEventOccurrence(IEventOccurrence eventOccurrence) {
		this.wrappedEventOccurrence = eventOccurrence;
	}

	@Override
	public IEventOccurrence getWrappedEventOccurrence() {
		return this.wrappedEventOccurrence;
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
