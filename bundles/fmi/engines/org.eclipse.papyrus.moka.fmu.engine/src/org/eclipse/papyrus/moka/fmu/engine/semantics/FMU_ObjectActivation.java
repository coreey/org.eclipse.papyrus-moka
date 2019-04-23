/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
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
 *  CEA LIST Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.moka.fmu.engine.semantics;

import org.eclipse.papyrus.moka.timedfuml.semantics.CommonBehaviors.TimedObjectActivation;

public class FMU_ObjectActivation extends TimedObjectActivation{

	public void register(FMUChangeEventOccurence changeEventOccurrence) {
		// Add the change event occurrence at the end of the event pool.
		// Notify that that a new event occurrence was placed in the event pool.
		this.eventPool.add(changeEventOccurrence);
		this.notifyEventArrival();
	}
}
