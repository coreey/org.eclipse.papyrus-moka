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

package org.eclipse.papyrus.moka.engine.uml.debug.data.variables;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IEventOccurrence;

public class EventOccurrenceVariableAdapter extends UMLVariableAdapter<IEventOccurrence>{

	private final String NAME = "event";
	
	public EventOccurrenceVariableAdapter(IDebugTarget target, IEventOccurrence eventOccurrence) {
		super(target, eventOccurrence);
	}

	@Override
	public String getName() throws DebugException {
		// Return the variable name
		return NAME;
	}
	
}
