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
package org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.InvocationActions;

// Imports
import java.util.List;

import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_Reference;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.InvocationActions.ICS_EventOccurrence;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ISignalInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.SendSignalActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications.SignalEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications.SignalInstance;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.Signal;


public class CS_SendSignalActionActivation extends SendSignalActionActivation {

	@Override
	public void doAction() {
		// If onPort is not specified, behaves like in fUML
		// If onPort is specified,
		// Get the value from the target pin. If the value is not a reference,
		// then do nothing.
		// Otherwise, construct a signal using the values from the argument pins
		// As compared to fUML, instead of sending directly to target reference
		// by calling operation send:
		// - if the target is to be the same as or a container of (directly or indirectly)
		// the object executing the Action, the Signal shall be related to a Reception belonging
		// to a required interface of onPort, and sendOut is called on the target reference
		// so that the signal will be sent to the environment
		// - if the target is NOT to be the same as or a container of (directly or indirectly)
		// the object executing the Action, the Signal shall be related to a Reception belonging
		// to a provided Interface of onPort, and operation sendIn is called so that the signal
		// will be sent to the internals of the target object

		SendSignalAction action = (SendSignalAction) (this.node);

		if (action.getOnPort() == null) {
			// Behaves like in fUML
			super.doAction();
		} else {
			IValue target = this.takeTokens(action.getTarget()).get(0);

			if (target instanceof CS_Reference) {
				// Constructs the signal instance
				Signal signal = action.getSignal();
				ISignalInstance signalInstance = new SignalInstance();
				signalInstance.setType(signal);

				List<Property> attributes = signal.getOwnedAttributes();
				List<InputPin> argumentPins = action.getArguments();
				Integer i = 0;
				while (i < attributes.size()) {
					Property attribute = attributes.get(i);
					InputPin argumentPin = argumentPins.get(i);
					List<IValue> values = this.takeTokens(argumentPin);
					signalInstance.setFeatureValue(attribute, values, 0);
					i = i + 1;
				}
				// Construct the signal event occurrence
				SignalEventOccurrence signalEventOccurrence =  new SignalEventOccurrence();
				signalEventOccurrence.signalInstance = (SignalInstance) signalInstance.copy();
				ICS_EventOccurrence wrappingEventOccurrence = new CS_EventOccurrence();
				wrappingEventOccurrence.setWrappedEventOccurrence(signalEventOccurrence);
				// Tries to determine if the signal has to be
				// sent to the environment or to the internals of
				// target, through onPort
				ICS_Reference targetReference = (ICS_Reference) target;
				// Port onPort = action.onPort ;
				IObject_ executionContext = this.group.getActivityExecution().getContext();
				if (executionContext == targetReference.getReferent() || targetReference.getCompositeReferent().contains(executionContext)) {
					wrappingEventOccurrence.sendOutTo(targetReference, action.getOnPort());
				} else {
					wrappingEventOccurrence.sendInTo(targetReference, action.getOnPort());
				}
			}
		}
	}
	
}
