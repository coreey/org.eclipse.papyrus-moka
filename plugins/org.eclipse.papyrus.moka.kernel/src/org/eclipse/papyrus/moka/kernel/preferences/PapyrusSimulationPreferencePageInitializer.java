/*****************************************************************************
 * Copyright (c) 2019 CEA LIST.
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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.kernel.preferences;

import static org.eclipse.papyrus.moka.kernel.process.IServerMqttPreferences.MODEL_VALIDATION_ON_LAUNCH;
import static org.eclipse.papyrus.moka.kernel.process.IServerMqttPreferences.MQTT_SERVER_PORT;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.moka.kernel.MokaKernelActivator;;

public class PapyrusSimulationPreferencePageInitializer extends AbstractPreferenceInitializer {

	public PapyrusSimulationPreferencePageInitializer() {
		super();
	}
	
	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = MokaKernelActivator.getDefault().getPreferenceStore();
		store.setDefault(MQTT_SERVER_PORT, 1885);
		store.setDefault(MODEL_VALIDATION_ON_LAUNCH, true);
	}

}
