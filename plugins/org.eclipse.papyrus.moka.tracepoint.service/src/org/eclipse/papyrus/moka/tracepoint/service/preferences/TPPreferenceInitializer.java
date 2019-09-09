/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.tracepoint.service.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.moka.tracepoint.service.Activator;
import org.eclipse.papyrus.moka.tracepoint.service.ITraceMechanism;
import org.eclipse.papyrus.moka.tracepoint.service.TraceMechanism;

/**
 * Class used to initialize default preference values.
 */
public class TPPreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		EList<ITraceMechanism> mechanisms = TraceMechanism.getTraceMechanisms();
		String mechanismID = ""; //$NON-NLS-1$
		if (mechanisms.size() > 0) {
			ITraceMechanism mechanism = mechanisms.get(0);
			// TODO: function need to support null object
			EList<String> mechanismIDs = mechanism.getTraceMechanismIDs(null);
			if (mechanismIDs.size() > 0) {
				mechanismID = mechanismIDs.get(0);
			}
		}
		store.setDefault(TPPreferenceConstants.P_TRACE_IMPLEMENTATION_PORT, mechanismID);
		store.setDefault(TPPreferenceConstants.P_TRACE_IMPLEMENTATION_OP, mechanismID);
		store.setDefault(TPPreferenceConstants.P_TRACE_IMPLEMENTATION_SM, mechanismID);

		store.setDefault(TPPreferenceConstants.P_TRACE_OPTION_CLASS, 3);
		store.setDefault(TPPreferenceConstants.P_TRACE_OPTION_STATE, 0);
		store.setDefault(TPPreferenceConstants.P_TRACE_OPTION_OP, 0);
	}
}
