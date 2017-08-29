/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.moka.fmu.engine.semantics;

import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.CommonBehavior.SM_ObjectActivation;

public class FMU_ObjectActivation extends SM_ObjectActivation{

	public void register(FMUChangeEventOccurence changeEventOccurrence) {
		// Add the change event occurrence at the end of the event pool.
		// Notify that that a new event occurrence was placed in the event pool.
		this.eventPool.add(changeEventOccurrence);
		this.notifyEventArrival();
	}
}
