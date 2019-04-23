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

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

public final class MokaExecutableSelectionComponent extends MokaGroupComponent {

	public MokaUMLComboBox eligibleExecutableElement;

	public MokaExecutableSelectionComponent(Composite parent, int style, String name, int columns) {
		super(parent, style, name, columns);
		this.createCombo();
	}

	private void createCombo() {
		this.eligibleExecutableElement = new MokaUMLComboBox(this.group, SWT.FILL);
		this.eligibleExecutableElement.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
	}
}
