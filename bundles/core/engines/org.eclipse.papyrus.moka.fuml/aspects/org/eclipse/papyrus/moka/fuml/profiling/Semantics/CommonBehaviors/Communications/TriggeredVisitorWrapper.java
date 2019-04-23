/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
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

package org.eclipse.papyrus.moka.fuml.profiling.Semantics.CommonBehaviors.Communications;

import org.eclipse.papyrus.moka.fuml.Profiling.ITriggeredVisitorWrapper;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;

public abstract class TriggeredVisitorWrapper implements ITriggeredVisitorWrapper{
	
	protected IEventOccurrence eventOccurrence;
	
	public TriggeredVisitorWrapper(IEventOccurrence eventOccurrence) {
		this.eventOccurrence = eventOccurrence;
	}
	
	@Override
	public IEventOccurrence getTriggeringEventOccurrence() {
		return this.eventOccurrence;
	}

}
