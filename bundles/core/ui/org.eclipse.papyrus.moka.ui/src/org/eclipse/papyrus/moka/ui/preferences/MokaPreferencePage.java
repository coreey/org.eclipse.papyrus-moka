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

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.papyrus.moka.utils.constants.MokaConstants;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * A preference page for Moka. It enables to select the
 * default execution engine, to be used when a launch
 * configuration is started.
 *
 */
public class MokaPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public MokaPreferencePage() {
		super(GRID);
		setPreferenceStore(org.eclipse.papyrus.moka.ui.Activator.getDefault().getPreferenceStore());
		setDescription("");
	}

	public void init(IWorkbench workbench) {
	}

	@Override
	protected void createFieldEditors() {
		String[][] names = getRegisteredExecutionEnginesAsStringArray();
		this.addField(new RadioGroupFieldEditor(MokaConstants.MOKA_DEFAULT_EXECUTION_ENGINE_PREF, "Execution Engines", 1, names, getFieldEditorParent()));
	}

	protected String[][] getRegisteredExecutionEnginesAsStringArray() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] config = registry.getConfigurationElementsFor(MokaConstants.MOKA_ENGINE_EXTENSION_POINT_ID);
		String[][] names = new String[config.length][2];
		for (int i = 0; i < config.length; i++) {
			names[i][1] = config[i].getNamespaceIdentifier();
			names[i][0] = config[i].getAttribute("description");
		}
		return names;
	}
}
