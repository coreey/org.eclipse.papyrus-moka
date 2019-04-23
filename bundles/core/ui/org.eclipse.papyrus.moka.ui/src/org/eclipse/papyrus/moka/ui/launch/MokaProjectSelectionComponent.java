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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

public final class MokaProjectSelectionComponent extends MokaGroupComponent {

	private final static String PROJECT_SELECTION_BUTTON_NAME = "Browse...";

	public Button projectSelectionButton;

	public Text projectSelectionText;

	public MokaProjectSelectionComponent(Composite parent, int style, String name, int columns) {
		super(parent, style, name, columns);
		this.createProjectionSelectionText();
		this.createProjectSelectionButton();
	}

	private void createProjectSelectionButton() {
		this.projectSelectionButton = new Button(this.group, SWT.NONE);
		this.projectSelectionButton.setText(PROJECT_SELECTION_BUTTON_NAME);
		this.projectSelectionButton.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, false, false));
	}

	private void createProjectionSelectionText() {
		this.projectSelectionText = new Text(this.group, SWT.BORDER);
		this.projectSelectionText.setEditable(false);
		this.projectSelectionText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		this.projectSelectionText.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
	}
}
