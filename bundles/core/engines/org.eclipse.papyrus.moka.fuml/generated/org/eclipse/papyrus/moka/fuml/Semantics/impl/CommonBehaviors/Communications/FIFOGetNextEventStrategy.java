/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
 *  Jeremie Tatibouet (CEA) - Apply Fix fUML12-35 Initial execution of an activity is not run to completion
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;

public class FIFOGetNextEventStrategy extends GetNextEventStrategy {

	@Override
	public IEventOccurrence getNextEvent(ObjectActivation objectActivation) {
		// Get the first event from the given event pool. The event is removed
		// from the pool.

		// fUML12-35 Initial execution of an activity is not run to completion

		IEventOccurrence eventOccurrence = objectActivation.eventPool.get(0);
		objectActivation.eventPool.remove(0);
		return eventOccurrence;
	}
}
