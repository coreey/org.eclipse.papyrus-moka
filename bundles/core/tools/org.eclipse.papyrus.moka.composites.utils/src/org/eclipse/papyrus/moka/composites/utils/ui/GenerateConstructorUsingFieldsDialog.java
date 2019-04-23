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
package org.eclipse.papyrus.moka.composites.utils.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.moka.composites.utils.handlers.Utils;
import org.eclipse.papyrus.moka.utils.helper.presentation.LabelProviderHelper;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;

public class GenerateConstructorUsingFieldsDialog extends TrayDialog {

	protected Class context;

	protected CheckboxTableViewer viewer;

	private Button btUP;

	private Button btDown;

	private List<Object> checkList = new ArrayList<Object>();

	public GenerateConstructorUsingFieldsDialog(Shell shell, Class context) {
		super(shell);
		setShellStyle(SWT.CLOSE | SWT.RESIZE);
		this.context = context;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		parent.getShell().setText("Generate Constructor Using Fields");
		parent.getShell().setMinimumSize(500, 500);

		/*
		 * Create composite which contains all controls, composites, & others
		 * stuff.
		 */
		Composite mainLayout = new Composite(parent, SWT.FILL);
		mainLayout.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		mainLayout.setLayout(new GridLayout(1, true));

		// Create Label Using Fields
		Label lblSelectFields = new Label(mainLayout, SWT.NONE);
		lblSelectFields.setText("Select fields to initialize :");

		/* Create composite which contains compositeCheckBox & compositeButtons */
		Composite cpCenter = new Composite(mainLayout, SWT.RESIZE);

		// Set Layout and position
		GridData gdCenter = new GridData(SWT.FILL, SWT.FILL, true, true);
		gdCenter.widthHint = 514;
		gdCenter.heightHint = 274;
		cpCenter.setLayoutData(gdCenter);
		cpCenter.setLayout(new GridLayout(2, false));

		/* Create left "panel" which contains bindings with check box controls */
		Composite cpCheckBox = new Composite(cpCenter, SWT.RESIZE | SWT.BORDER);
		cpCheckBox.setLayout(new GridLayout(1, false));

		// Set Layout and position
		GridData gdCheckBox = new GridData(SWT.FILL, SWT.FILL, true, true);
		gdCheckBox.widthHint = 370;
		cpCheckBox.setLayoutData(gdCheckBox);

		/* Add all attributes on a CheckboxTableViewer */
		viewer = CheckboxTableViewer.newCheckList(cpCheckBox, SWT.FULL_SELECTION | SWT.FILL);
		viewer.setContentProvider(new StruturedContentProvider());
		viewer.setLabelProvider(new TableLabelProvider());
		viewer.setInput(this.context.getOwnedAttributes());

		// Listen which box is checked.
		viewer.addCheckStateListener(new ICheckStateListener() {

			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				if (event.getChecked() == true) {
					viewer.setChecked(event.getElement(), true);
					checkList.add(event.getElement());
				} else {
					viewer.setChecked(event.getElement(), false);
					checkList.remove(event.getElement());
				}
			}
		});

		viewer.getTable().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				List<?> elements = (List<?>) viewer.getInput();
				Property data = null;

				if (event.item.getData() instanceof Property) {
					data = (Property) event.item.getData();

					if (data == elements.get(0)) {
						btUP.setEnabled(false);
						btDown.setEnabled(true);
					} else if (data == elements.get(elements.size() - 1)) {
						btDown.setEnabled(false);
						btUP.setEnabled(true);
					} else {
						btUP.setEnabled(true);
						btDown.setEnabled(true);
					}
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		viewer.setAllChecked(true);
		Object[] tmp = viewer.getCheckedElements();
		for (int i = 0; i < tmp.length; i++) {
			checkList.add(tmp[i]);
		}

		/* Create right "panel" which contains Select/Deselect Buttons */
		Composite cpButtons = new Composite(cpCenter, SWT.RESIZE);

		// Set Layout and position
		GridData gdButtons = new GridData(SWT.FILL, SWT.FILL, true, true);
		gdButtons.widthHint = 144;
		cpButtons.setLayoutData(gdButtons);
		cpButtons.setLayout(new GridLayout(1, false));

		/* Create Select-Deselect buttons */
		/* Push Button Select All */
		Button btSelect = new Button(cpButtons, SWT.PUSH);
		btSelect.setText("Select All");

		// Set size and position
		GridData gdSelect = new GridData(SWT.FILL, SWT.FILL, false, false);
		gdSelect.widthHint = 100;
		gdSelect.heightHint = 25;
		btSelect.setLayoutData(gdSelect);

		// Add Listener
		btSelect.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				viewer.setAllChecked(true);

				if (checkList.size() != 0) {
					checkList.removeAll(checkList);
					Object[] tmp = viewer.getCheckedElements();
					for (int i = 0; i < tmp.length; i++) {
						checkList.add(tmp[i]);
					}
				}
				// System.out.println(event.toString());
			}
		});

		/* Push Button Deselect All */
		Button btDeSelect = new Button(cpButtons, SWT.PUSH);
		btDeSelect.setText("Deselect All");

		// Set size and position
		GridData gdDeSelect = new GridData(SWT.FILL, SWT.FILL, false, false);
		gdDeSelect.widthHint = 100;
		gdDeSelect.heightHint = 25;
		btDeSelect.setLayoutData(gdDeSelect);

		// Add Listener
		btDeSelect.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				viewer.setAllChecked(false);

				if (checkList.size() != 0) {
					checkList.removeAll(checkList);
				}

				// System.out.println(event.toString());
			}
		});

		/* Create Up-Down buttons */
		/* Push Button Up */
		btUP = new Button(cpButtons, SWT.PUSH);
		btUP.setText("Up");

		// Set size and position
		GridData gdUP = new GridData(SWT.FILL, SWT.FILL, false, false);
		gdUP.widthHint = 100;
		gdUP.heightHint = 25;
		btUP.setLayoutData(gdUP);
		btUP.setEnabled(false);

		btUP.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				viewer.setInput(getElementListUP());
				// System.out.println(event.toString());
			}
		});

		/* Push Button Down */
		btDown = new Button(cpButtons, SWT.PUSH);
		btDown.setText("Down");

		// Set size and position
		GridData gdDown = new GridData(SWT.FILL, SWT.FILL, false, false);
		gdDown.widthHint = 100;
		gdDown.heightHint = 25;
		btDown.setLayoutData(gdDown);

		btDown.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				viewer.setInput(getElementListDown());
				// System.out.println(event.toString());
			}
		});

		return mainLayout;
	}

	protected boolean isCreate(Operation operation) {
		for (int j = 0; j < operation.getAppliedStereotypes().size(); j++) {
			Stereotype st_tmp = operation.getAppliedStereotypes().get(j);
			if (st_tmp.getName().equals("Create")) {
				return true;
			}
		}
		return false;
	}

	static class StruturedContentProvider implements IStructuredContentProvider {

		@SuppressWarnings("unchecked")
		@Override
		public Object[] getElements(Object inputElement) {
			ArrayList<Property> result = new ArrayList<Property>();
			if (inputElement instanceof List) {
				result.addAll((Collection<? extends Property>) inputElement);
			}
			return result.toArray();
		}

		@Override
		public void dispose() {
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}

	static class TableLabelProvider extends BaseLabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			if (element instanceof Property) {
				Property current = (Property) element;
				switch (columnIndex) {
				case 0:
					return LabelProviderHelper.getInstance().getImage(current);
				default:
					return null;
				}
			}
			return null;

		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof Property) {
				Property current = (Property) element;
				switch (columnIndex) {
				case 0:
					return current.getName();
				default:
					return "";
				}
			}
			return "";
		}

	}

	protected List<?> getElementListUP() {

		List<?> elements = (List<?>) viewer.getInput();
		IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
		List<?> element = selection.toList();
		ArrayList<Object> elementList = new ArrayList<Object>();
		ArrayList<Object> elementListTMP = new ArrayList<Object>();

		for (int i = 0; i < elements.size(); i++) {
			if (element.get(0) == elements.get(i)) {
				elementListTMP.remove(elements.get(i - 1));
				elementListTMP.add(element.get(0));
				elementListTMP.add(elements.get(i - 1));

			} else {
				elementListTMP.add(elements.get(i));

			}
		}

		elementList.addAll(elementListTMP);
		return elementList;
	}

	protected List<?> getElementListDown() {

		List<?> elements = (List<?>) viewer.getInput();
		IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
		List<?> element = selection.toList();
		ArrayList<Object> elementList = new ArrayList<Object>();
		ArrayList<Object> elementListTMP = new ArrayList<Object>();

		for (int i = 0; i < elements.size(); i++) {
			if (element.get(0) == elements.get(i)) {
				elementListTMP.add(elements.get(i + 1));
				elementListTMP.add(element.get(0));
				i++;
			} else {
				elementListTMP.add(elements.get(i));
			}
		}

		elementList.addAll(elementListTMP);
		return elementList;
	}

	@Override
	protected void okPressed() {
		// System.err.println("Ok pressed");

		// Check if the right profile is applied.
		// List<Profile> appliedProfiles = context.getModel().getAppliedProfiles();
		// for(int i = 0; i < appliedProfiles.size(); i++) {
		// System.out.println(appliedProfiles.get(i).getQualifiedName());
		// }

		if (!Utils.isStandardProfileApplied(context)) {
			PackageUtil.applyProfile(context.getModel(), Utils.standardProfile, true);
		}

		// Creating operation and method with "Create" stereotype
		Operation operation = Utils.getDefaultConstructor(context);

		int flagParamOp = 0;

		// Add parameters to instantiate
		for (int i = 0; i < checkList.size(); i++) {
			if (checkList.get(i) instanceof Property) {
				Property prop = (Property) checkList.get(i);
				Parameter in = UMLFactory.eINSTANCE.createParameter();
				in.setDirection(ParameterDirectionKind.IN_LITERAL);
				in.setType(prop.getType());
				in.setName(prop.getName());

				/* Check if parameter is already exist on the operation. */
				flagParamOp = 0;

				if (operation.getOwnedParameters().size() <= 1) {
					operation.getOwnedParameters().add(operation.getOwnedParameters().size() - 1, in);
				}

				else {
					for (int j = 0; j < operation.getOwnedParameters().size() && flagParamOp == 0; j++) {
						Parameter opParameter = operation.getOwnedParameters().get(j);
						if (!opParameter.getName().equals(in.getName())) {
							flagParamOp = 0;
						} else {
							flagParamOp = -1;
						}
					}

					if (flagParamOp == 0) {
						operation.getOwnedParameters().add(operation.getOwnedParameters().size() - 1, in);
					}
				}
			}
		}

		super.okPressed();
	}

}
