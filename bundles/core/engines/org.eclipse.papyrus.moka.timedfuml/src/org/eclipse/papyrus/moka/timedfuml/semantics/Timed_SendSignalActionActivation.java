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
 *  CEA LIST Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.timedfuml.semantics;

import java.util.List;

import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.InvocationActions.CS_SendSignalActionActivation;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_Reference;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Object;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.SendSignalAction;

public class Timed_SendSignalActionActivation extends CS_SendSignalActionActivation {
	@Override
	public List<IValue> takeTokens(InputPin pin) {
		// FIXME generalize this for the SIMEX profile
		// Deals with "implicit this"
		List<IValue> values = super.takeTokens(pin);
		if (values.isEmpty()) {
			// check if the pin is the target pin,
			// and automatically adds a reference to the context object
			SendSignalAction sendSignalAction = (SendSignalAction) this.node;
			if (sendSignalAction.getTarget() == pin) {
				ICS_Reference targetReference = new CS_Reference();
				IValue target = this.getExecutionContext();
				targetReference.setReferent((IObject_) target);
				targetReference.setCompositeReferent((ICS_Object) target);
				values.add(targetReference);
			}
		}
		return values;
	}
}
