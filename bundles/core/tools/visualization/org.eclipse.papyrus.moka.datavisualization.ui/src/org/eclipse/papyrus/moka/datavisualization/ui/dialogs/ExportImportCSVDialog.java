/*****************************************************************************
 * 
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.datavisualization.ui.dialogs;

import java.io.File;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.papyrus.moka.datavisualization.ui.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ExportImportCSVDialog extends Dialog {

	private static final String SEPARATOR_SETTING = "CSV_EXPORT_SEPARATOR";
	private static final String TARGET_DIR_SETTING = "CSV_EXPORT_TARGET_DIR";
	private static final String	PREVIOUS_CSV_FILE= "CSV_IMPORT_CSV_FILE";
	
	protected String previousDir;
	private String selectedPath;
	protected String separator =";";
	private String csvFileName;

	private String previousImportedFile;
	
	protected Button selectTargetDirButton ;
	protected Text selectedPathText ;
	
	protected Text separatorText ;

	
	boolean save = false;

	
	
	public ExportImportCSVDialog(Shell parentShell, String defaultName, boolean save) {
		super(parentShell);
		this.csvFileName = defaultName;
		this.save = save;
		IDialogSettings settings = Activator.getDefault().getDialogSettings();
		if (settings != null){
			String previousSep = settings.get(SEPARATOR_SETTING);
			if (previousSep != null){
				separator = previousSep;
			}
			String previousDir = settings.get(TARGET_DIR_SETTING);
			if (previousDir != null){
				this.previousDir = previousDir;
			}
			
			this.previousImportedFile= settings.get(PREVIOUS_CSV_FILE);
			
		}
	}

	@Override
	protected boolean isResizable() {
		return true;
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

	
		createSetSeparator(container);
		createSelectDir(container);
	

		return container;
	}

	private void createSetSeparator(Composite container) {
		Label label = new Label(container, SWT.NULL);  
		label.setText("CSV separator : ");

		separatorText = new Text(container, SWT.SINGLE | SWT.BORDER);
		GridData dataDirText = new GridData();
		
		
		
		separatorText.setText(separator);
		separatorText.setLayoutData(dataDirText);

		separatorText.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				separator = separatorText.getText();
				checkInformation();
			}
		});
		
		
	}



	private void createSelectDir(Composite container) {
		selectTargetDirButton = new Button(container, SWT.PUSH);
		if (save){
			selectTargetDirButton.setText("Select target file");
		}else {
			selectTargetDirButton.setText("Select file to import");
		}

		GridData dataDirText = new GridData();
		dataDirText.grabExcessHorizontalSpace = true;
		dataDirText.horizontalAlignment = GridData.FILL;
		
		selectedPathText = new Text(container, SWT.BORDER | SWT.PUSH);
		selectedPathText.setText("");
		
		
	
		selectedPathText.setLayoutData(dataDirText);
		
		
		
		selectTargetDirButton.addSelectionListener(new SelectionAdapter() {
			

			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = container.getShell();
				FileDialog fileDialog;
				if (save){
					fileDialog =  new FileDialog(shell, SWT.SAVE);
					fileDialog.setOverwrite(true);
					fileDialog.setText("Select target folder");
					fileDialog.setFileName(csvFileName+".csv");
					fileDialog.setFilterPath(previousDir);
				}else {
					fileDialog  = new FileDialog(shell);
					fileDialog.setText("Select target CSV file");
					if (previousImportedFile != null){
						File previousFile = new File(previousImportedFile);
						fileDialog.setFileName(previousFile.getName());
						fileDialog.setFilterPath(previousFile.getParent());
					}
				}
				fileDialog.setFilterExtensions(new String[] {"*.csv"});
				
				
				selectedPath = fileDialog.open();
			
				if (selectedPath != null) {
					selectedPathText.setText(selectedPath);

					
				}
				else {
					selectedPath = "" ;
				}
				checkInformation();
			}
		});
	}

	
	
	

	

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Export CSV");
	}

	@Override
	protected Point getInitialSize() {
		
		return new Point(600,230);
	}

	protected void checkInformation() {
		boolean validSelectedDir = ! ("".equals(selectedPath)) ;
		boolean validSeparator = (separator != null) && !separator.isEmpty();
		
		if (validSelectedDir  && validSeparator ) {
			this.getButton(IDialogConstants.OK_ID).setEnabled(true);
		}
		else {
			this.getButton(IDialogConstants.OK_ID).setEnabled(false);
		}
	}

	public String getSelectedPath() {
		return selectedPath;
	}

	
	public String getSeparator() {
		return separator;
	}
	
	@Override
	protected void okPressed() {
		IDialogSettings settings = Activator.getDefault().getDialogSettings();
		if (settings != null){
			settings.put(SEPARATOR_SETTING, separator);
			
			File selectedPathFile = new File(selectedPath);
			settings.put(TARGET_DIR_SETTING, selectedPathFile.getParent());
		
		}
		super.okPressed();
	}
}
