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
package org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses;

import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_InteractionPoint;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Object;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Reference;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Port;


public class CS_Reference extends Reference implements ICS_Reference {

	/*
	 * The composite object referenced by this ReferenceToCompositeStructure. This property subsets Reference::referent.
	 */
	public ICS_Object compositeReferent;

	public IExecution dispatchIn(Operation operation, ICS_InteractionPoint interactionPoint) {
		// Delegates dispatching to composite referent
		return this.compositeReferent.dispatchIn(operation, interactionPoint);
	}

	public void sendIn(IEventOccurrence eventOccurrence, ICS_InteractionPoint interactionPoint) {
		// delegates sending to composite referent
		this.compositeReferent.sendIn(eventOccurrence, interactionPoint);
	}

	public void sendOut(IEventOccurrence eventOccurrence, Port onPort) {
		// delegates sending to composite referent
		this.compositeReferent.sendOut(eventOccurrence, onPort);
	}

	public IExecution dispatchOut(Operation operation, Port onPort) {
		// delegates dispatching to composite referent
		return this.compositeReferent.dispatchOut(operation, onPort);
	}

	public IExecution dispatchIn(Operation operation, Port onPort) {
		// delegates dispatching to composite referent
		return this.compositeReferent.dispatchIn(operation, onPort);
	}

	public void sendIn(IEventOccurrence eventOccurrence, Port onPort) {
		// delegates sending to composite referent
		this.compositeReferent.sendIn(eventOccurrence, onPort);
	}

	public IExecution dispatchOut(Operation operation, ICS_InteractionPoint interactionPoint) {
		// Delegates dispatching (through the interaction point, to the environment)
		// to compositeReferent
		return this.compositeReferent.dispatchOut(operation, interactionPoint);
	}

	public void sendOut(IEventOccurrence eventOccurrence, ICS_InteractionPoint interactionPoint) {
		// Delegates sending (through the interaction point, to the environment)
		// to compositeReferent
		this.compositeReferent.sendOut(eventOccurrence, interactionPoint);
	}

	@Override
	public IValue copy() {
		// Create a new reference with the same referent and composite referent as this reference.
		ICS_Reference newValue = new CS_Reference();
		newValue.setReferent(this.getReferent());
		newValue.setCompositeReferent(this.compositeReferent);
		return newValue;
	}

	@Override
	public ICS_Object getCompositeReferent() {
		return this.compositeReferent;
	}

	@Override
	public void setCompositeReferent(ICS_Object compositeReferent) {
		this.compositeReferent = compositeReferent;
	}
}
