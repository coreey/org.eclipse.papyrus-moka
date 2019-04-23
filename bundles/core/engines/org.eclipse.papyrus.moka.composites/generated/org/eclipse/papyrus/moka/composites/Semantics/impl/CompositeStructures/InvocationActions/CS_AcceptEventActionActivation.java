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

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.CompleteActions.AcceptEventActionActivation;

public class CS_AcceptEventActionActivation extends AcceptEventActionActivation {

	@Override
	public void accept(IEventOccurrence eventOccurrence) {
		// If the accepted event occurrence is a CS_EventOccurrence then the wrapped
		// event occurrence is extracted. The acceptance process is the one define
		// by AcceptEventActionActivation defined in fUML.
		if (eventOccurrence instanceof CS_EventOccurrence) {
			super.accept(((CS_EventOccurrence) eventOccurrence).wrappedEventOccurrence);
		} else {
			super.accept(eventOccurrence);
		}
	}
}
