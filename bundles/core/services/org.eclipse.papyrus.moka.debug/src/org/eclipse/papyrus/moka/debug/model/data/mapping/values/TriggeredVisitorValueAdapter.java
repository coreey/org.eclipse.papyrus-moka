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

package org.eclipse.papyrus.moka.debug.model.data.mapping.values;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.debug.engine.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.model.data.mapping.variables.EventOccurrenceVariableAdapter;
import org.eclipse.papyrus.moka.fuml.Profiling.ITriggeredVisitorWrapper;

public class TriggeredVisitorValueAdapter extends VisitorValueAdapter<ITriggeredVisitorWrapper> {

	public TriggeredVisitorValueAdapter(MokaDebugTarget debugTarget, ITriggeredVisitorWrapper visitor) {
		super(debugTarget, visitor);
	}
	
	@Override
	public IVariable[] getVariables() throws DebugException {
		// The only variable that is accessible from a triggered visitor is the
		// event occurrence that triggered the visitor. This event occurrence may
		// itself have event variables.
		if (this.variables.isEmpty()) {
			this.variables.add(
					new EventOccurrenceVariableAdapter(debugTarget, this.adaptedObject.getTriggeringEventOccurrence()));
		}
		return this.variables.toArray(new IVariable[0]);
	}
	
}
