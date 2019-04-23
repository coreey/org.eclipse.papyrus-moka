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

package org.eclipse.papyrus.moka.debug.model.data.mapping.variables;

import java.util.Iterator;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.papyrus.moka.debug.engine.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.model.data.mapping.values.MokaValueAdapterList;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IObjectActivation;

public class EventPoolVariableAdapter extends MokaVariableAdapter<IObjectActivation> {

	protected final String NAME = "events";

	public EventPoolVariableAdapter(MokaDebugTarget debugTarget, IObjectActivation objectActivation) {
		super(debugTarget, objectActivation);
	}

	@Override
	public IValue getValue() throws DebugException {
		// The variable corresponding to the event pool may have multiple values.
		// This implies it is not sufficient to request a value adapter to the factory.
		// Instead a list of value adapter is provided, each adapted corresponds to a
		// event occurrence available in the pool.
		if (this.value == null) {
			MokaValueAdapterList adapterList = new MokaValueAdapterList(this.debugTarget);
			Iterator<IEventOccurrence> eventsIterator = this.adaptedVariable.getEvents().iterator();
			while (eventsIterator.hasNext()) {
				adapterList.add(eventsIterator.next());
			}
			this.value = adapterList;
		}
		return this.value;
	}

	@Override
	public String getName() throws DebugException {
		// Return the variable name
		return this.NAME;
	}

}
