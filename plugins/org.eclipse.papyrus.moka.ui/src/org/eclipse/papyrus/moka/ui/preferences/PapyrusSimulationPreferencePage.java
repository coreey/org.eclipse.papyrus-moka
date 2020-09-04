/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.moka.ui.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.papyrus.moka.kernel.IKernelProperties;
import org.eclipse.papyrus.moka.ui.IUIPreferences;
import org.eclipse.papyrus.moka.ui.MokaUIActivator;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class PapyrusSimulationPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	private final static String DESCRIPTION = "Configure preferences for the Papyrus simulation tool";

	private final static String SERVER_PATH_LABEL = "Server path";

	private final static String SERVER_PORT_LABEL = "Server port";

	private final static String MODEL_VALIDATION_ON_LAUNCH_LABEL = "Run validation on launch";

	public PapyrusSimulationPreferencePage() {
		super(GRID);
	}

	public void init(IWorkbench workbench) {
		IPreferenceStore store = MokaUIActivator.getDefault().getPreferenceStore();
		setPreferenceStore(store);
		setDescription(DESCRIPTION);
	}

	@Override
	protected void createFieldEditors() {
		FileFieldEditor serverPathEditor = new FileFieldEditor(IKernelProperties.MQTT_SERVER_PATH, SERVER_PATH_LABEL,
				getFieldEditorParent());
		serverPathEditor.setEmptyStringAllowed(false);
		serverPathEditor.setErrorMessage("Invalid path to the server");

		addField(serverPathEditor);
		IntegerFieldEditor portFieldEditor = new IntegerFieldEditor(IKernelProperties.MQTT_SERVER_PORT,
				SERVER_PORT_LABEL, getFieldEditorParent());
		portFieldEditor.setValidRange(0, 65536);
		portFieldEditor.setErrorMessage("Invalid port");

		addField(portFieldEditor);
		BooleanFieldEditor validationOnLaunch = new BooleanFieldEditor(IUIPreferences.MODEL_VALIDATION_ON_LAUNCH,
				MODEL_VALIDATION_ON_LAUNCH_LABEL, getFieldEditorParent());
		addField(validationOnLaunch);
	}
}
