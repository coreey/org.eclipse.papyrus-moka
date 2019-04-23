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
 *   CEA LIST Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.timedfuml.semantics.CommonBehaviors;

import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.CommonBehavior.SM_ObjectActivation;
import org.eclipse.papyrus.moka.timedfuml.interfaces.semantics.CommonBehaviors.ITimedEventOccurrence;
import org.eclipse.papyrus.moka.timedfuml.interfaces.semantics.CommonBehaviors.ITimedObjectActivation;

public class TimedObjectActivation extends SM_ObjectActivation implements ITimedObjectActivation{

	@Override
	public void register(ITimedEventOccurrence timedEventOccurrence) {
		// Add the timed event occurrence at the end of the event pool.
		// Notify that that a new event occurrence was placed in the event pool.
		this.eventPool.add(timedEventOccurrence);
		this.notifyEventArrival();
	}

}
