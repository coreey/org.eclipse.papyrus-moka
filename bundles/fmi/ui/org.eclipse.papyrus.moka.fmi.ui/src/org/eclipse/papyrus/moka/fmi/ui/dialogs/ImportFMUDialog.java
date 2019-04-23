/*****************************************************************************
 * 
 * Copyright (c) 2016 CEA LIST.
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
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.fmi.ui.dialogs;

import java.util.LinkedList;
import java.util.List;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Shell;

public class ImportFMUDialog  extends AbstractFMIDialog{

	private String importedLibName;	

	private StringFieldEditor importedModelNameEditor;


	public ImportFMUDialog(Shell parentShell, String exporterArgs) {
		super(parentShell, " Enter a name for your Model Library");
		this.importedLibName = exporterArgs;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);		
	}

	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == IDialogConstants.OK_ID) {
			importedLibName = importedModelNameEditor.getStringValue();
		}
		super.buttonPressed(buttonId);
	}

	public String getImportedModelName() {
		return importedLibName;
	}

	@Override
	protected List<FieldEditor> additionalFields(Composite fieldEditorParent) {		
		List<FieldEditor> fes = new LinkedList<FieldEditor>();
		
		importedModelNameEditor = new StringFieldEditor("", "Model Library Name:", fieldEditorParent);
		importedModelNameEditor.setEmptyStringAllowed(false);
		importedModelNameEditor.setStringValue(importedLibName);
		fes.add(importedModelNameEditor);

		return fes;
	}

}