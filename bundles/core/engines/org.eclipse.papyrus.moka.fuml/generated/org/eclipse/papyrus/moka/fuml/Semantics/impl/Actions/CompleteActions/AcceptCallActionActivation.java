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

package org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.CompleteActions;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReturnInformation;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ICallEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.ReturnInformation;
import org.eclipse.uml2.uml.AcceptCallAction;
import org.eclipse.uml2.uml.OutputPin;

public class AcceptCallActionActivation extends AcceptEventActionActivation {

	@Override
	public void accept(IEventOccurrence eventOccurrence) {
		// Accept the given event occurrence, which must be a call event occurrence.
		// Place return information for the call on the return information
		// output pin. Then complete the acceptance of the event occurrence
		// as usual.
		AcceptCallAction action = (AcceptCallAction) this.node;
		OutputPin returnInformationPin = action.getReturnInformation();
		IReturnInformation returnInformation = new ReturnInformation();
		returnInformation.setCallEventOcccurrence((ICallEventOccurrence)eventOccurrence);
		this.putToken(returnInformationPin, returnInformation);
		super.accept(eventOccurrence);
	}

}