/*****************************************************************************
 * Copyright (c) 2019 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * 		CEA LIST - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.moka.ui.launch;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.papyrus.infra.widgets.editors.StringEditor;
import org.eclipse.papyrus.infra.widgets.editors.TreeSelectorDialog;
import org.eclipse.papyrus.infra.widgets.messages.Messages;
import org.eclipse.papyrus.infra.widgets.providers.WorkspaceContentProvider;
import org.eclipse.papyrus.infra.widgets.util.FileUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class MokaStringFileSelector extends StringEditor {

	private Button browseWorkspace;

	private List<String> filterNames;

	private List<String> filterExtensions;

	private boolean readOnly = false;

	private String defaultFileName;
	
	private String fileExtension;

	public MokaStringFileSelector(Composite parent, int style, String label) {
		this(parent, style, label, "fileName");
	}

	public MokaStringFileSelector(Composite parent, int style, String label, String defaultFileName) {
		super(parent, style, label);
		this.defaultFileName = defaultFileName;
		((GridLayout) getLayout()).numColumns = 4;

		browseWorkspace = factory.createButton(this, "Browse...", SWT.PUSH);
		browseWorkspace.setLayoutData(new GridData());

		filterNames = new LinkedList<String>();
		filterExtensions = new LinkedList<String>();

		browseWorkspace.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				LabelProviderService labelProviderService = new LabelProviderServiceImpl();
				try {
					labelProviderService.startService();
				} catch (ServiceException ex) {
					Activator.log.error(ex);
				}

				ILabelProvider labelProvider = labelProviderService.getLabelProvider();

				IFile currentFile = FileUtil.getIFile(text.getText());

				TreeSelectorDialog dialog = new TreeSelectorDialog(getShell());
				if (labelText != null) {
					dialog.setTitle(labelText);
				}

				WorkspaceContentProvider contentProvider = new WorkspaceContentProvider();

				if (!(filterExtensions.isEmpty() || filterNames.isEmpty())) {
					// The filters have been defined
					contentProvider.setExtensionFilters(new LinkedHashMap<String, String>()); // Reset the default
																								// filters

					// Use our own filters
					for (int i = 0; i < Math.min(filterNames.size(), filterExtensions.size()); i++) {
						contentProvider.addExtensionFilter(filterExtensions.get(i), filterNames.get(i));
					}
				}

				dialog.setContentProvider(contentProvider);
				dialog.setLabelProvider(labelProvider);

				if (currentFile != null && currentFile.exists()) {
					dialog.setInitialSelections(new Object[] { currentFile });
				}

				int code = dialog.open();
				if (code == Window.OK) {
					Object[] result = dialog.getResult();
					if (result.length > 0) {
						Object file = result[0];
						if (file instanceof IFile) {
							setResult((IFile) file);
						} else if (file instanceof IResource) {
							setResult((IResource) file);
						}
					}
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// Nothing
			}

		});
	}

	protected void setResult(IFile file) {
		text.setText(file.getFullPath().toString());
		notifyChange();
	}

	protected void setResult(IResource folder) {
		StringBuilder builder = new StringBuilder();
		builder.append(folder.getFullPath().toString());
		builder.append(File.separator);
		builder.append(defaultFileName);
		builder.append(".");
		builder.append(fileExtension);
		text.setText(builder.toString());
		notifyChange();
	}

	protected void setResult(String path) {
		text.setText(path);
		notifyChange();
	}

	public void setFilters(String[] filterExtensions, String[] filterNames) {
		if (filterExtensions.length != filterNames.length) {
			// This is a simple warning. Only valid filters will be retained.
			Activator.log.warn(Messages.StringFileSelector_0);
		}

		setFilterNames(getFilterLabels(filterNames, filterExtensions));
		setFilterExtensions(filterExtensions);
	}

	protected String[] getFilterLabels(String[] filterNames, String[] filterExtensions) {
		int size = Math.min(filterNames.length, filterExtensions.length);
		String[] filters = new String[size];
		for (int i = 0; i < size; i++) {
			filters[i] = filterNames[i] + " (" + filterExtensions[i] + ")"; //$NON-NLS-1$ //$NON-NLS-2$
		}
		return filters;
	}

	public void setFilterExtensions(String[] filterExtensions) {
		this.filterExtensions = Arrays.asList(filterExtensions);
	}

	public void setFilterNames(String[] filterNames) {
		this.filterNames = Arrays.asList(filterNames);
	}
	
	protected void updateFileExtension(String fileExtension) {
		IPath path = new Path(text.getText());
		path = path.removeFileExtension();
		path = path.addFileExtension(fileExtension);
		text.setText(path.toString());
	}

	public void addFilteredExtension(String filteredExtension, String filterName) {
		if (filteredExtension != null) {
			if (filterName == null) {
				filterName = filteredExtension;
			}

			filterExtensions.add(filteredExtension);
			filterNames.add(filterName);
		}
	}

	@Override
	public Object getEditableType() {
		return String.class;
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		super.setReadOnly(readOnly);
		this.readOnly = readOnly;
		updateButtons();
	}

	private void updateButtons() {
		boolean enableWorkspace = !readOnly;
		browseWorkspace.setEnabled(enableWorkspace);
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
		updateFileExtension(fileExtension);
	}

}
