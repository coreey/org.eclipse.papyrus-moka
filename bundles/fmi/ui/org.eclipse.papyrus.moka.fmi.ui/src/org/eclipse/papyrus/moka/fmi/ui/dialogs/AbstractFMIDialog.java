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

import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.moka.fmi.ui.Activator;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public abstract class AbstractFMIDialog extends Dialog {

    private FieldEditorPreferencePage page;
    private String dialogTitle;

    protected IPreferenceStore store;
    
    public AbstractFMIDialog(Shell parentShell, String dialogTitle) {
        super(parentShell);
        this.dialogTitle = dialogTitle;
        //Set the preference store for the preference page.
        IPreferenceStore store = Activator.getDefault().getPreferenceStore();
        setPreferenceStore(store);
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(dialogTitle);
        newShell.setSize(500, 170);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);

        page = new FieldEditorPreferencePage(FieldEditorPreferencePage.GRID) {
            @Override
            public void createControl(Composite parentComposite) {
                noDefaultAndApplyButton();
                super.createControl(parentComposite);
            }

            @Override
            protected void createFieldEditors() {
                Composite fieldEditorParent = getFieldEditorParent();

                List<? extends FieldEditor> additionalFields = additionalFields(fieldEditorParent);
                for (FieldEditor fieldEditor : additionalFields) {
                    addField(fieldEditor);
                }
            }

            @Override
            protected void updateApplyButton() {
                updateButtons(isValid());
                super.updateApplyButton();
            }
        };

        page.createControl(composite);
        Control pageControl = page.getControl();
        pageControl.setLayoutData(new GridData(GridData.FILL_BOTH));
        return pageControl;
    }

    protected abstract List<? extends FieldEditor> additionalFields(Composite fieldEditorParent);

    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        super.createButtonsForButtonBar(parent);
        updateButtons(page.isValid());
    }

    private void updateButtons(boolean isValid) {
        Button okButton = getButton(IDialogConstants.OK_ID);
        if (okButton != null) {
            okButton.setEnabled(isValid);
        }
    }

    @Override
    protected void buttonPressed(int buttonId) {
//        if (buttonId == IDialogConstants.OK_ID) {
//            targetDirectory = new File(targetDirectoryEditor.getStringValue());
//        }
        super.buttonPressed(buttonId);
    }

//    public File getTargetDirectory() {
//        return targetDirectory;
//    }

    public void setPreferenceStore(IPreferenceStore store) {
        this.store = store;
    }

}