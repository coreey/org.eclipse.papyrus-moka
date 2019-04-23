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

import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.debug.engine.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.model.data.mapping.variables.ParameterValueVariableAdapter;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ICallEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;

public class CallEventOccurrenceValueAdapter extends EventOccurrenceValueAdapter {

	public CallEventOccurrenceValueAdapter(MokaDebugTarget debugTarget, IEventOccurrence eventOccurrence) {
		super(debugTarget, eventOccurrence);
		this.representation = "Call Event";
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		if (this.variables.isEmpty() && !this.adaptedObject.getParameterValues().isEmpty()) {
			Operation operation = ((ICallEventOccurrence) this.adaptedObject).getOperation();
			if (operation != null) {
				List<Parameter> operationParameters = operation.getOwnedParameters();
				List<IParameterValue> parameterValues = this.adaptedObject.getParameterValues();
				for (int i = 0; i < parameterValues.size(); i++) {
					this.variables.add(new ParameterValueVariableAdapter(debugTarget, parameterValues.get(i),
							operationParameters.get(i).getName()));
				}
			}
		}
		return this.variables.toArray(new IVariable[0]);
	}

}
