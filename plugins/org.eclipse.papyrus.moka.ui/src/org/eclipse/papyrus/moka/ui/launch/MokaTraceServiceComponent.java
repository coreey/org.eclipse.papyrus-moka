/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.moka.ui.launch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.papyrus.infra.widgets.editors.StringDirectorySelector;
import org.eclipse.papyrus.moka.trace.capture.CaptureServiceRegistry;
import org.eclipse.papyrus.moka.trace.formater.TraceFileFormaterRegistry;
import org.eclipse.papyrus.moka.trace.interfaces.capture.ICaptureServiceFactory;
import org.eclipse.papyrus.moka.trace.interfaces.format.ITraceFileFormater;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ExpandableComposite;

public class MokaTraceServiceComponent extends Composite {

	protected Button traceCheckBox;
	protected StringDirectorySelector filePathSelector;
	protected Button traceSelectionButton;
	protected Map<String, Button> captureEngineRadioButtons;
	Map<String, List<ITraceFileFormater>> mapCaptureIdToFormatersId;
	protected Map<String, Combo> formaterComboBoxs;
	protected Button traceTracepointModeCheckBox;

	public MokaTraceServiceComponent(Composite parent, int style, String name, int columns) {
		super(parent, style);
		this.setLayout(new GridLayout());
		this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		Composite composite = this.createExpandableComposite(parent, name, columns);
		formaterComboBoxs = new HashMap<String, Combo>();
		this.createCheckbox(composite);
		this.createFilePathText(composite);
		this.createFileFormatList(composite);
		this.createTracepointModeCheckbox(composite);
	}

	protected Composite createExpandableComposite(Composite parent, String name, int columns) {
		ExpandableComposite expandableComposite = new ExpandableComposite(parent, ExpandableComposite.TWISTIE | ExpandableComposite.CLIENT_INDENT);
		expandableComposite.setText(name);
		expandableComposite.setExpanded(false);
		expandableComposite.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false, 1, 1));
		expandableComposite.addExpansionListener(new ExpansionAdapter() {
			@Override
			public void expansionStateChanged(final ExpansionEvent e) {
				expandableComposite.getParent().getParent().layout();
				expandableComposite.getParent().getParent().redraw();
			}
		});

		// Create the composite
		Group composite = new Group(expandableComposite, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = columns;
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		expandableComposite.setClient(composite);

		return composite;
	}

	protected void createCheckbox(Composite parent) {
		this.traceCheckBox = new Button(parent, SWT.CHECK);
		this.traceCheckBox.setEnabled(true);
		this.traceCheckBox.setText("Generate trace file");
	}

	protected void createFilePathText(Composite parent) {
		filePathSelector = new StringDirectorySelector(parent, SWT.NONE);
		filePathSelector.setLabel("Output folder");
		filePathSelector.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
	}

	protected void createFileFormatList(Composite parent) {
		Group fileFormatGroup = new Group(parent, SWT.NONE);
		fileFormatGroup.setText("File format output");
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.horizontalSpacing = SWT.FILL;
		fileFormatGroup.setLayout(gridLayout);
		fileFormatGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		Map<String, ICaptureServiceFactory> captureEngine = CaptureServiceRegistry.INSTANCE.getCaptureServices();
		captureEngineRadioButtons = new LinkedHashMap<String, Button>();


		mapCaptureIdToFormatersId = new HashMap<>();
		Collection<ITraceFileFormater> formaters = TraceFileFormaterRegistry.INSTANCE.getTraceFileFormater();
		for (Entry<String, ICaptureServiceFactory> capture : captureEngine.entrySet()) {
			List<ITraceFileFormater> formaterList = new ArrayList<>();
			for (ITraceFileFormater formater : formaters) {
				if (formater.getCaptureId().equals(capture.getKey())) {
					formaterList.add(formater);
				}
			}
			mapCaptureIdToFormatersId.put(capture.getKey(), formaterList);
		}

		for (Entry<String, ICaptureServiceFactory> capture : captureEngine.entrySet()) {
			Button button = new Button(fileFormatGroup, SWT.RADIO);
			button.setText(capture.getValue().getName());
			captureEngineRadioButtons.put(capture.getKey(), button);
			addFormaterComboBox(fileFormatGroup, capture.getKey());
		}
	}

	protected void addFormaterComboBox(Composite parent, String captureId) {
		Combo combo = new Combo(parent, SWT.FILL);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		combo.setEnabled(true);
		mapCaptureIdToFormatersId.get(captureId).stream().forEach(formater -> combo.add(formater.getName()));
		if (combo.getItemCount() != 0) {
			combo.select(0);
		}
		formaterComboBoxs.put(captureId, combo);
	}

	protected void createTracepointModeCheckbox(Composite parent) {
		this.traceTracepointModeCheckBox = new Button(parent, SWT.CHECK);
		this.traceTracepointModeCheckBox.setEnabled(true);
		this.traceTracepointModeCheckBox.setText("Tracepoint mode");
		this.traceTracepointModeCheckBox.setToolTipText("When the tracepoint mode is activate, only nodes which have a tracepoint marker are traced (right click on the node, tracing, add tracepoint)");
	}

	public String getFilePath() {
		return filePathSelector.getText().getText();
	}

	public void setFilePath(String text) {
		this.filePathSelector.getText().setText(text);
	}

	public ICaptureServiceFactory getCaptureServiceFactory() {
		String captureID = getCaptureId();
		if (captureID != null) {
			return CaptureServiceRegistry.INSTANCE.getCaptureService(captureID);
		}
		return null;
	}

	protected String getCaptureId() {
		String captureID = null;
		for (Entry<String, Button> captureEntry : captureEngineRadioButtons.entrySet()) {
			if (captureEntry.getValue().getSelection()) {
				captureID = captureEntry.getKey();
				break;
			}
		}
		return captureID;
	}

	public ITraceFileFormater getFormater() {
		String captureID = getCaptureId();
		if (captureID != null) {
			Combo combo = formaterComboBoxs.get(captureID);
			List<ITraceFileFormater> comboFormaterRef = mapCaptureIdToFormatersId.get(captureID);
			ITraceFileFormater formater = comboFormaterRef.get(combo.getSelectionIndex());
			return formater;
		}
		return null;
	}

	public void setFormaterFromID(String id) {
		ITraceFileFormater formater = TraceFileFormaterRegistry.INSTANCE.getFormaterFromID(id);
		if (formater != null) {
			String captureId = formater.getCaptureId();
			// set radio
			captureEngineRadioButtons.get(captureId).setSelection(true);
			// set formater
			List<ITraceFileFormater> formaterList = mapCaptureIdToFormatersId.get(captureId);
			int index = formaterList.indexOf(formater);
			formaterComboBoxs.get(captureId).select(index);
		} else {
			// Select the first of the list
			for (Button button : captureEngineRadioButtons.values()) {
				button.setSelection(true);
				break;
			}
		}
		enabledComboBoxs();
	}

	protected void enabledComboBoxs() {
		for (Entry<String, Button> button : captureEngineRadioButtons.entrySet()) {
			Combo combo = formaterComboBoxs.get(button.getKey());
			combo.setEnabled(button.getValue().getSelection());
		}
	}

	public void enableTraceWidget(boolean enable) {
		this.filePathSelector.setAllowFileSystem(enable);
		this.filePathSelector.setAllowWorkspace(enable);
		captureEngineRadioButtons.values().stream().forEach(button -> button.setEnabled(enable));
		if (enable) {
			enabledComboBoxs();
		} else {
			formaterComboBoxs.values().stream().forEach(combo -> combo.setEnabled(false));
		}
		this.traceTracepointModeCheckBox.setEnabled(enable);
	}

	public void addRadioListner(MokaRunConfigurationTab tab) {
		SelectionAdapter selectionAdapter = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				tab.updateLaunchConfigurationDialog();
				MokaTraceServiceComponent.this.enabledComboBoxs();
			}
		};
		captureEngineRadioButtons.values().stream().forEach(button -> button.addSelectionListener(selectionAdapter));
	}

	public void addTracePointModeListner(MokaRunConfigurationTab tab) {
		SelectionAdapter selectionAdapter = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				tab.updateLaunchConfigurationDialog();
			}
		};
		this.traceTracepointModeCheckBox.addSelectionListener(selectionAdapter);
	}

	public static boolean shouldDisplay() {
		return !CaptureServiceRegistry.INSTANCE.getCaptureServices().isEmpty();
	}

}
