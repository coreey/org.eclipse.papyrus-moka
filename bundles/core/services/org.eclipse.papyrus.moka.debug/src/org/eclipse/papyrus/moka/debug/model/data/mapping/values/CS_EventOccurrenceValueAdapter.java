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

package org.eclipse.papyrus.moka.debug.model.data.mapping.values;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.InvocationActions.ICS_EventOccurrence;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_InteractionPoint;
import org.eclipse.papyrus.moka.debug.engine.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.model.data.mapping.variables.CS_InteractionPointVariableAdapter;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;

public class CS_EventOccurrenceValueAdapter extends EventOccurrenceValueAdapter {

	public CS_EventOccurrenceValueAdapter(MokaDebugTarget debugTarget, IEventOccurrence eventOccurrence) {
		super(debugTarget, eventOccurrence);
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		if (this.variables.isEmpty()) {
			ICS_InteractionPoint interactionPoint= ((ICS_EventOccurrence) this.adaptedObject).getInteractionPoint();
			if(interactionPoint != null) {
				this.variables.add(new CS_InteractionPointVariableAdapter(debugTarget, interactionPoint));
			}
			MokaValueAdapter<?> valueAdapter = MokaValueAdapterFactory.getInstance()
					.instantiate(((ICS_EventOccurrence) this.adaptedObject).getWrappedEventOccurrence(), debugTarget);
			IVariable[] delegatedVariables = valueAdapter.getVariables(); 
			for(int i=0; i < delegatedVariables.length; i++) {
				this.variables.add(delegatedVariables[i]);
			}
		}
		return this.variables.toArray(new IVariable[0]);
	}
	
	@Override
	public String getValueString() throws DebugException {
		// The string representation is the one specified by the value
		// adapter of the wrapped event occurrence.
		MokaValueAdapter<?> valueAdapter = MokaValueAdapterFactory.getInstance()
				.instantiate(((ICS_EventOccurrence) this.adaptedObject).getWrappedEventOccurrence(), debugTarget);
		return valueAdapter.getValueString();
	}

}
