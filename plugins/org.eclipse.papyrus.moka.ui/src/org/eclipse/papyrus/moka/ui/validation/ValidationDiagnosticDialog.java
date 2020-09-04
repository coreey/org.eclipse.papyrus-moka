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
package org.eclipse.papyrus.moka.ui.validation;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.services.markerlistener.dialogs.DiagnosticDialog;
import org.eclipse.papyrus.moka.ui.IUIPreferences;
import org.eclipse.papyrus.moka.ui.MokaUIActivator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

public class ValidationDiagnosticDialog extends DiagnosticDialog {

	private boolean dontValidateAnymoreBeforeLaunchButton = false;

	public ValidationDiagnosticDialog(Shell parentShell, String dialogTitle, String message, Diagnostic diagnostics,
			int displayMask) {
		super(parentShell, dialogTitle, message, diagnostics, displayMask);
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	@Override
	protected void cancelPressed() {
		super.cancelPressed();
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Control control = super.createDialogArea(parent);
		if (control instanceof Composite) {
			// add an empty label to move the check box on the right column
			Label label = new Label((Composite) control, SWT.NONE);
			label.setText("");
			Button button = new Button((Composite) control, SWT.CHECK);
			button.setText("Don't run validation on simulation launch.");
			button.addSelectionListener(new SelectionListener() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					dontValidateAnymoreBeforeLaunchButton = !dontValidateAnymoreBeforeLaunchButton;
				}

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
				}

			});
		}
		return control;
	}

	@Override
	protected void buttonPressed(int id) {
		if (id == IDialogConstants.OK_ID || id == IDialogConstants.CANCEL_ID) {
			IPreferenceStore store = MokaUIActivator.getDefault().getPreferenceStore();
			store.setValue(IUIPreferences.MODEL_VALIDATION_ON_LAUNCH, !dontValidateAnymoreBeforeLaunchButton);
			try {
				((ScopedPreferenceStore) store).save();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		super.buttonPressed(id);
	}

}
