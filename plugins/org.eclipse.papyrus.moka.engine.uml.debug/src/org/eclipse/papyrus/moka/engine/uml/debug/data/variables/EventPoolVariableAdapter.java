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

import java.util.Iterator;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.papyrus.moka.engine.uml.debug.data.values.MokaValueAdapterList;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IObjectActivation;

public class EventPoolVariableAdapter extends UMLVariableAdapter<IObjectActivation> {

	protected final String NAME = "events";

	public EventPoolVariableAdapter(IDebugTarget target, IObjectActivation objectActivation) {
		super(target, objectActivation);
	}

	@Override
	public IValue getValue() throws DebugException {
		// The variable corresponding to the event pool may have multiple values.
		// This implies it is not sufficient to request a value adapter to the factory.
		// Instead a list of value adapter is provided, each adapted corresponds to a
		// event occurrence available in the pool.
		if (this.value == null) {
			MokaValueAdapterList adapterList = new MokaValueAdapterList(getDebugTarget());
			Iterator<IEventOccurrence> eventsIterator = variable.getEvents().iterator();
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
