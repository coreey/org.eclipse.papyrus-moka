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

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.papyrus.moka.fmi.util.FMUResourceUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ExportFMUDialog extends Dialog {

	protected String selectedDir = "" ;
	protected String selectedPlatform = "" ;
	protected boolean embedJre = false ;
	protected String selectedJrePath = "" ;

	protected Button selectTargetDirButton ;
	protected Text selectedDirText ;
	protected Combo combo ;
	protected Button isJreEmbedded ;
	protected Button selectJREButton ;
	protected Text selectedJrePathText ;
	private String fmuName;
	private Text setNameText;

	public ExportFMUDialog(Shell parentShell, String defaultName) {
		super(parentShell);
		this.fmuName = defaultName;
	}



	@Override
	protected Control createButtonBar(Composite parent) {
		Control control = super.createButtonBar(parent);
		this.getButton(IDialogConstants.OK_ID).setEnabled(false);
		return control ;
	}



	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE) ;
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);

		createSetName(container);
		createSelectDir(container);
		createSelectPlatform(container);
		createEmbbedJRE(container) ;
		createSelectJRE(container);

		selectTargetDirButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = container.getShell();
				DirectoryDialog dirDialog = new DirectoryDialog(shell);
				dirDialog.setText("Select target directory");
				selectedDir = dirDialog.open();
				if (selectedDir != null) {
					selectedDirText.setText(selectedDir);
				}
				else {
					selectedDir = "" ;
				}
				checkInformation();
			}
		});

		setNameText.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				fmuName = setNameText.getText();
			}
		});
		
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selectedPlatform = combo.getText() ;
				checkInformation();
			}
		});

		isJreEmbedded.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				embedJre = !embedJre ;
				if (embedJre == true) {
					selectJREButton.setEnabled(true);
					selectedJrePathText.setEnabled(true);
				}
				else {
					selectJREButton.setEnabled(false);
					selectedJrePathText.setEnabled(false);
				}
				checkInformation();
			}
		});

		selectJREButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = container.getShell();
				DirectoryDialog dirDialog = new DirectoryDialog(shell);
				dirDialog.setText("Select JRE path");
				selectedJrePath = dirDialog.open();
				if (selectedJrePath != null) {
					selectedJrePathText.setText(selectedJrePath);
				}
				else {
					selectedJrePath = "" ;
				}
				checkInformation();
			}
		});

		return container;
	}

	private void createSelectDir(Composite container) {
		selectTargetDirButton = new Button(container, SWT.PUSH);
		selectTargetDirButton.setText("Select target directory");

		GridData dataDirText = new GridData();
		dataDirText.grabExcessHorizontalSpace = true;
		dataDirText.horizontalAlignment = GridData.FILL;

		selectedDirText = new Text(container, SWT.BORDER | SWT.PUSH);
		selectedDirText.setText(selectedDir);
		selectedDirText.setLayoutData(dataDirText);
	}

	private void createSetName(Composite container) {
		Label label = new Label(container, SWT.NULL);  
		label.setText("FMU name: ");

		setNameText = new Text(container, SWT.SINGLE | SWT.BORDER);
		GridData dataDirText = new GridData();
		dataDirText.grabExcessHorizontalSpace = true;
		dataDirText.horizontalAlignment = GridData.FILL;
		
		setNameText.setText(fmuName);
		setNameText.setLayoutData(dataDirText);

		//		GridData dataDirText = new GridData();
		//	    dataDirText.grabExcessHorizontalSpace = true;
		//	    dataDirText.horizontalAlignment = GridData.FILL;
		//		
		//		selectedDirText = new Text(container, SWT.BORDER | SWT.PUSH);
		//		selectedDirText.setText(selectedDir);
		//		selectedDirText.setLayoutData(dataDirText);
	}

	private void createSelectPlatform(Composite container) {
		Label label = new Label(container, SWT.NONE) ;
		label.setText("Target platform:");

		combo = new Combo(container, SWT.DROP_DOWN | SWT.PUSH);
		combo.setItems(FMUResourceUtil.BINARIES_LINUX32, FMUResourceUtil.BINARIES_LINUX64, FMUResourceUtil.BINARIES_WIN64);
		combo.setText(FMUResourceUtil.BINARIES_LINUX64);
		selectedPlatform = FMUResourceUtil.BINARIES_LINUX64 ;
	}

	private void createEmbbedJRE(Composite container) {
		Label label = new Label(container, SWT.NONE) ;
		label.setText("Include JRE:");

		isJreEmbedded = new Button(container, SWT.CHECK) ;
		isJreEmbedded.setText("");
	}

	private void createSelectJRE(Composite container) {
		selectJREButton = new Button(container, SWT.PUSH);
		selectJREButton.setText("Select JRE path");
		selectJREButton.setEnabled(false);

		GridData dataJREText = new GridData();
		dataJREText.grabExcessHorizontalSpace = true;
		dataJREText.horizontalAlignment = GridData.FILL;

		selectedJrePathText = new Text(container, SWT.BORDER | SWT.PUSH);
		selectedJrePathText.setText(selectedJrePath);
		selectedJrePathText.setLayoutData(dataJREText);
	}


	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Export FMU");
	}

	@Override
	protected Point getInitialSize() {
		return new Point(550, 300);
	}

	protected void checkInformation() {
		boolean validSelectedDir = ! ("".equals(selectedDir)) ;
		boolean validJre = embedJre ? !("".equals(selectedJrePath)) : true ;
		if (validSelectedDir  && validJre) {
			this.getButton(IDialogConstants.OK_ID).setEnabled(true);
		}
		else {
			this.getButton(IDialogConstants.OK_ID).setEnabled(false);
		}
	}

	public String getSelectedDir() {
		return selectedDir;
	}

	public String getSelectedPlatform() {
		return selectedPlatform;
	}

	public boolean isEmbedJre() {
		return embedJre;
	}

	public String getSelectedJrePath() {
		return selectedJrePath;
	}
	public String getFmuName() {
		return fmuName;
	}
}
