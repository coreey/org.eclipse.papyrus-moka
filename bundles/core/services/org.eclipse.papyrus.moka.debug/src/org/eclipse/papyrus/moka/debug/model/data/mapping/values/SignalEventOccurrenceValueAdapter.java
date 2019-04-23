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
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ISignalEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ISignalInstance;

public class SignalEventOccurrenceValueAdapter extends EventOccurrenceValueAdapter {

	public SignalEventOccurrenceValueAdapter(MokaDebugTarget debugTarget, IEventOccurrence eventOccurrence) {
		super(debugTarget, eventOccurrence);
		this.representation = "Signal Event";
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		if (this.variables.isEmpty() && !this.adaptedObject.getParameterValues().isEmpty()) {
			ISignalInstance signalInstance = ((ISignalEventOccurrence)this.adaptedObject).getSignalInstance();
			if(signalInstance != null) {
				List<IParameterValue> parameterValues = this.adaptedObject.getParameterValues();
				List<IFeatureValue> featureValues = signalInstance.getMemberValues();
				for(int i=0; i < parameterValues.size(); i++) {
					this.variables.add(new ParameterValueVariableAdapter(debugTarget, parameterValues.get(i), featureValues.get(i).getFeature().getName()));
				}
			}
		}
		return this.variables.toArray(new IVariable[0]);
	}

}
