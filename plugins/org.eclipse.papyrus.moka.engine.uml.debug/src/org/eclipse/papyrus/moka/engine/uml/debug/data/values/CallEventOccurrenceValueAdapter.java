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

import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.engine.uml.debug.data.variables.ParameterValueVariableAdapter;
import org.eclipse.papyrus.moka.fuml.commonbehavior.ICallEventOccurrence;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IParameterValue;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;

public class CallEventOccurrenceValueAdapter extends EventOccurrenceValueAdapter {

	public CallEventOccurrenceValueAdapter(IDebugTarget debugTarget, IEventOccurrence eventOccurrence) {
		super(debugTarget, eventOccurrence);
		this.representation = "Call Event";
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		if (this.variables.isEmpty() && !value.getParameterValues().isEmpty()) {
			Operation operation = ((ICallEventOccurrence) value).getOperation();
			if (operation != null) {
				List<Parameter> operationParameters = operation.getOwnedParameters();
				List<IParameterValue> parameterValues = value.getParameterValues();
				for (int i = 0; i < parameterValues.size(); i++) {
					this.variables.add(new ParameterValueVariableAdapter(getDebugTarget(), parameterValues.get(i),
							operationParameters.get(i).getName()));
				}
			}
		}
		return this.variables.toArray(new IVariable[0]);
	}

}
