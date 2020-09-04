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

package org.eclipse.papyrus.moka.engine.uml.debug.data.variables;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IEventOccurrence;

public class TimeEventOccurrenceValueAdapter extends EventOccurrenceValueAdapter {

	protected static final String TIME = "time";

	public TimeEventOccurrenceValueAdapter(IDebugTarget target, IEventOccurrence eventOccurrence) {
		super(target, eventOccurrence);
		this.representation = "Time Event";
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		// A time event occurrence always has a single variable.
		// This variable contains the time at which the event occurrence
		// is received by an object.
		if (this.variables.isEmpty() && value.getParameterValues().size() == 1) {
			this.variables.add(new ParameterValueVariableAdapter(getDebugTarget(),
					value.getParameterValues().iterator().next(), TIME));
		}
		return this.variables.toArray(new IVariable[0]);
	}

}
