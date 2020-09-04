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

import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IParameterValue;
import org.eclipse.papyrus.moka.fuml.commonbehavior.ISignalEventOccurrence;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.ISignalInstance;

public class SignalEventOccurrenceValueAdapter extends EventOccurrenceValueAdapter {

	public SignalEventOccurrenceValueAdapter(IDebugTarget target, IEventOccurrence eventOccurrence) {
		super(target, eventOccurrence);
		this.representation = "Signal Event";
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		if (this.variables.isEmpty() && !value.getParameterValues().isEmpty()) {
			ISignalInstance signalInstance = ((ISignalEventOccurrence)value).getSignalInstance();
			if(signalInstance != null) {
				List<IParameterValue> parameterValues = value.getParameterValues();
				List<IFeatureValue> featureValues = signalInstance.getMemberValues();
				for(int i=0; i < parameterValues.size(); i++) {
					this.variables.add(new ParameterValueVariableAdapter(getDebugTarget(), parameterValues.get(i), featureValues.get(i).getFeature().getName()));
				}
			}
		}
		return this.variables.toArray(new IVariable[0]);
	}

}
