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


import java.util.List;

import org.eclipse.papyrus.uml.extensionpoints.library.IRegisteredLibrary;
import org.eclipse.papyrus.uml.extensionpoints.library.RegisteredLibrary;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

public class MokaAdditionalSemanticsSelectionComponent extends MokaGroupComponent {

	// This class is currently not used

	public MokaLibrariesComboBox registeredLibraries;

	public MokaAdditionalSemanticsSelectionComponent(Composite parent, int style, String name, int columns) {
		super(parent, style, name, columns);
		this.createComboBox();
	}

	public void createComboBox() {
		this.registeredLibraries = new MokaLibrariesComboBox(this.group, SWT.NONE);
		this.registeredLibraries.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		List<IRegisteredLibrary> libraries = RegisteredLibrary.getRegisteredLibraries();
		for (IRegisteredLibrary lib : libraries) {
			this.registeredLibraries.add(lib);
		}
		if (this.registeredLibraries.getItemCount() > 0) {
			this.registeredLibraries.select(1);
		}
	}

}
