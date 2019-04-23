/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Jeremie Tatibouet (CEA) - Apply Fix fUML12-35 Initial execution of an activity is not run to completion
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ISignalEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ISignalInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.Trigger;

/**
 * A signal event occurrence represents the occurrence of a signal event due to
 * the receipt of a specific signal instance.
 */
public class SignalEventOccurrence extends EventOccurrence implements ISignalEventOccurrence{

	/*
	 * The signal instance whose receipt caused this signal event occurrence.
	 */
	public ISignalInstance signalInstance;

	@Override
	public boolean match(Trigger trigger) {
		// Match a trigger if it references a signal event whose signal is the type of
		// the signal instance or one of its super types
		boolean matches = false;
		if (trigger.getEvent() instanceof SignalEvent) {
			SignalEvent event = (SignalEvent) trigger.getEvent();
			matches = this.signalInstance.isInstanceOf(event.getSignal());
		}
		return matches;
	}

	@Override
	public List<IParameterValue> getParameterValues() {
		// Return parameter values for feature of the signal instance, in order.
		// These are intended to be treated as if they are the values of effective
		// parameters of direction "in".
		List<IParameterValue> parameterValues = new ArrayList<IParameterValue>();
		List<IFeatureValue> memberValues = this.signalInstance.getMemberValues();
		for (int i = 0; i < memberValues.size(); i++) {
			IFeatureValue feature = memberValues.get(i);
			IParameterValue parameterValue = new ParameterValue();
			parameterValue.setValues(feature.getValues());
			parameterValues.add(parameterValue);
		}
		return parameterValues;
	}

	@Override
	public void setSignalInstance(ISignalInstance signalInstance) {
		this.signalInstance = signalInstance;
	}

	@Override
	public ISignalInstance getSignalInstance() {
		return this.signalInstance;
	}
}
