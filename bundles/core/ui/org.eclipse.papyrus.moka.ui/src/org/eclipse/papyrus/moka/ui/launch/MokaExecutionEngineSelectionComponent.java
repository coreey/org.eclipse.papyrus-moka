/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
 *****************************************************************************/
package org.eclipse.papyrus.moka.ui.launch;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.moka.utils.constants.MokaConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

public final class MokaExecutionEngineSelectionComponent extends MokaGroupComponent {

	public MokaExecutionEngineComboBox eligibleExecutionEngineCombo;

	public MokaExecutionEngineSelectionComponent(Composite parent, int style, String name, int columns) {
		super(parent, style, name, columns);
		this.createCombo();
	}

	private void createCombo() {
		this.eligibleExecutionEngineCombo = new MokaExecutionEngineComboBox(this.group, SWT.FILL);
		this.eligibleExecutionEngineCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] configs = registry.getConfigurationElementsFor(MokaConstants.MOKA_ENGINE_EXTENSION_POINT_ID);
		for (int i = 0; i < configs.length; i++) {
			this.eligibleExecutionEngineCombo.add(configs[i].getNamespaceIdentifier());
		}
	}
}
