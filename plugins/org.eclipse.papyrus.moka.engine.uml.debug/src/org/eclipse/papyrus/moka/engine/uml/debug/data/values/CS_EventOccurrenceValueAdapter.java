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

package org.eclipse.papyrus.moka.engine.uml.debug.data.values;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.engine.uml.debug.data.variables.CS_InteractionPointVariableAdapter;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IEventOccurrence;
import org.eclipse.papyrus.moka.pscs.commonbehavior.ICS_EventOccurrence;
import org.eclipse.papyrus.moka.pscs.structuredclassifiers.ICS_InteractionPoint;

public class CS_EventOccurrenceValueAdapter extends EventOccurrenceValueAdapter {

	public CS_EventOccurrenceValueAdapter(IDebugTarget debugTarget, IEventOccurrence eventOccurrence) {
		super(debugTarget, eventOccurrence);
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		if (this.variables.isEmpty()) {
			ICS_InteractionPoint interactionPoint= ((ICS_EventOccurrence) value).getInteractionPoint();
			if(interactionPoint != null) {
				this.variables.add(new CS_InteractionPointVariableAdapter(getDebugTarget(), interactionPoint));
			}
			UMLValueAdapter<?> valueAdapter = UMLValueAdapterFactory.getInstance()
					.instantiate(((ICS_EventOccurrence) value).getWrappedEventOccurrence(), getDebugTarget());
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
		UMLValueAdapter<?> valueAdapter = UMLValueAdapterFactory.getInstance()
				.instantiate(((ICS_EventOccurrence) value).getWrappedEventOccurrence(), getDebugTarget());
		return valueAdapter.getValueString();
	}

}
