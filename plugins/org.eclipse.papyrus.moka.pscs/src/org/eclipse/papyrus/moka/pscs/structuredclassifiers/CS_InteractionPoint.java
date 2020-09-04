/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.pscs.structuredclassifiers;

// Imports
import java.util.List;

import org.eclipse.papyrus.moka.fuml.commonbehavior.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IExecution;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IParameterValue;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IValue;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.Reference;
import org.eclipse.papyrus.moka.pscs.commonbehavior.CS_EventOccurrence;
import org.eclipse.papyrus.moka.pscs.commonbehavior.ICS_EventOccurrence;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Port;

public class CS_InteractionPoint extends Reference implements ICS_InteractionPoint {

	/*
	 * Represents the Reference to the CompositeObject owning this InteractionPort.
	 * NOTE: This is introduced to address requirement R3 (It represents the "link
	 * from that instance to the instance of the owning classifier [...] through
	 * which communication is forwarded to the instance of the owning classifier or
	 * through which the owning classifier communicates)
	 */
	public ICS_Reference owner;

	/*
	 * The Port for which this InteractionPoint is a runtime manifestation
	 */
	public Port definingPort;

	@Override
	public void startBehavior(Class classifier, List<IParameterValue> inputs) {
		// Overridden to do nothing
	}

	@Override
	public IExecution dispatch(Operation operation) {
		// Delegates dispatching to the owning object
		return this.owner.dispatchIn(operation, this);
	}

	@Override
	public void send(IEventOccurrence eventOccurrence) {
		// An event occurrence that passes through a CS_InteractionPoint is
		// (if necessary) wrapped in a CS_EventOccurrence. This event occurrence
		// is then sent to the owning object.
		ICS_EventOccurrence wrappingEventOccurrence = null;
		if (eventOccurrence instanceof ICS_EventOccurrence) {
			wrappingEventOccurrence = (ICS_EventOccurrence) eventOccurrence;
		} else {
			wrappingEventOccurrence = new CS_EventOccurrence();
			wrappingEventOccurrence.setWrappedEventOccurrence(eventOccurrence);
		}
		wrappingEventOccurrence.setInteractionPoint(this);
		this.owner.sendIn(wrappingEventOccurrence, this);
	}

	@Override
	public IValue copy() {
		// Create a new interaction point with the same referent as this interaction
		// point.
		ICS_InteractionPoint newValue = (ICS_InteractionPoint) (super.copy());
		newValue.setReferent(this.referent);
		return newValue;
	}

	@Override
	public IValue new_() {
		return new CS_InteractionPoint();
	}

	@Override
	public ICS_Reference getOwner() {
		return this.owner;
	}

	@Override
	public void setOwner(ICS_Reference owner) {
		this.owner = owner;
	}

	public Port getDefiningPort() {
		return this.definingPort;
	}

	public void setDefiningPort(Port definingPort) {
		this.definingPort = definingPort;
	}

	@Override
	public boolean checkAllParents(Classifier type, Classifier classifier) {
		// Delegates the type checking to the reference
		return this.referent.checkAllParents(type, classifier);
	}
}
