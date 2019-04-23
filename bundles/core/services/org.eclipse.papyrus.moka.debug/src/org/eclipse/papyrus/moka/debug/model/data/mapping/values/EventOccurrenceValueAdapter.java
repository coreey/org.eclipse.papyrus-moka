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
import org.eclipse.papyrus.moka.debug.engine.MokaDebugTarget;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;

public abstract class EventOccurrenceValueAdapter extends MokaValueAdapter<IEventOccurrence> {

	// Representation of the event occurrence
	protected String representation;
	
	public EventOccurrenceValueAdapter(MokaDebugTarget debugTarget, IEventOccurrence eventOccurrence) {
		super(debugTarget, eventOccurrence);
	}

	@Override
	public String getValueString() throws DebugException {
		// The string representation is the one specified in the representation
		// attribute or the result of toString operation applied on the adapted
		// object.
		if(this.representation == null || this.representation.isEmpty()) {
			return this.adaptedObject.toString();
		}
		return this.representation;
	}
}
