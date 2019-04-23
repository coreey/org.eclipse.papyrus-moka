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

package org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.InvocationActions;

import java.util.List;

import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.InvocationActions.ICS_EventOccurrence;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_InteractionPoint;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications.EventOccurrence;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Trigger;

public class CS_EventOccurrence extends EventOccurrence implements ICS_EventOccurrence {

	// Real event occurrence
	public IEventOccurrence wrappedEventOccurrence;

	// Port manifestation from which the wrapped event occurrence was received.
	public ICS_InteractionPoint interactionPoint;

	// The direction followed to propagate the event occurrence.
	public boolean propagationInward;
	
	// Port specification of the port manifestation from which this event occurrence was sent. 
	public Port onPort;
	
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
	public void doSend() {
		// If the specified target is a CS_Reference and the propagation must be done
		// to the environment, then the operation sendOut(EventOccurrence, Port) is called
		// and make the propagation to continue.
		// If the specified target is a CS_Reference but the propagation must be done to
		// the internals then the operation sendIn(EventOccurrence, Port) is called.
		// In the case were the target is not a CS_EventOccurrence then send(EventOccurence)
		// is called.
		if(this.target instanceof ICS_Reference){
			if(this.propagationInward == true){
				((ICS_Reference)this.target).sendIn(this, this.onPort);
			}else{
				((ICS_Reference)this.target).sendOut(this, this.onPort);
			}
		}else{
			super.doSend();
		}
	}
	
	public void sendInTo(ICS_Reference target, Port port){
		// Propagate the sending of the event occurrence to the internals
		this.onPort = port;
		this.propagationInward = true;
		this.sendTo(target);
	}
	
	public void sendOutTo(ICS_Reference target, Port port){
		// Propagate the sending of the event occurrence to the environment
		this.onPort = port;
		this.propagationInward = false;
		this.sendTo(target);
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
