/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
 *  Ansgar Radermacher (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.moka.tracepoint.service.dialogs;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.moka.tracepoint.service.ITraceMechanism;
import org.eclipse.papyrus.moka.tracepoint.service.Messages;
import org.eclipse.papyrus.moka.tracepoint.service.TraceActions;
import org.eclipse.papyrus.moka.tracepoint.service.TraceActions.TAClass;
import org.eclipse.papyrus.moka.tracepoint.service.TraceActions.TAOperation;
import org.eclipse.papyrus.moka.tracepoint.service.TraceActions.TAState;
import org.eclipse.papyrus.moka.tracepoint.service.TraceActions.TATransition;
import org.eclipse.papyrus.moka.tracepoint.service.TraceActions.TraceFeature;
import org.eclipse.papyrus.moka.tracepoint.service.TraceMechanism;
import org.eclipse.papyrus.moka.tracepoint.service.TracepointConstants;
import org.eclipse.papyrus.moka.tracepoint.service.preferences.BinaryEncodedMChoiceFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.dialogs.SelectionStatusDialog;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Transition;

public class TraceActionSelection extends SelectionStatusDialog {

	protected CheckboxTableViewer fTraceImplementations;

	protected Text fDescription;

	IMarker m_marker;

	BinaryEncodedMChoiceFieldEditor classOptions;

	BinaryEncodedMChoiceFieldEditor operationOptions;

	BinaryEncodedMChoiceFieldEditor portOptions;

	BinaryEncodedMChoiceFieldEditor stateOptions;

	BinaryEncodedMChoiceFieldEditor transitionOptions;

	/**
	 * The model element that has a trace marker
	 */
	private Element m_me;

	public TraceActionSelection(Shell parent, IMarker marker, Element me) {
		super(parent);
		m_me = me;
		m_marker = marker;
		// int traceAction = marker.getAttribute(TracepointConstants.traceAction, 0);
	}


	/**
	 * @see SelectionStatusDialog#computeResult()
	 *      need to return two values: trace action & mechanism
	 */
	@Override
	protected void computeResult() {
		// nothing to do
		String traceActionValue = null;
		if (m_me instanceof State) {
			traceActionValue = stateOptions.getResult();
		}
		else if (m_me instanceof Class) {
			traceActionValue = TraceActions.compositeClassOption(
					classOptions.getIntResult(),
					stateOptions.getIntResult(),
					operationOptions.getIntResult());
		}
		else if (m_me instanceof State) {
			traceActionValue = stateOptions.getResult();
		}
		else if (m_me instanceof Transition) {
			traceActionValue = transitionOptions.getResult();
		}
		else if (m_me instanceof Operation) {
			traceActionValue = operationOptions.getResult();
		}
		else if (m_me instanceof Port) {
			traceActionValue = portOptions.getResult();
		}
		String traceMechanism = ""; //$NON-NLS-1$
		for (Object tableElement : fTraceImplementations.getCheckedElements()) {
			traceMechanism = (String) tableElement;
		}

		Object[] result = new Object[] {
				traceActionValue,
				traceMechanism
		};
		setResult(Arrays.asList(result));
	}

	class EnumLabelProvider extends LabelProvider implements ITableLabelProvider {

		@Override
		public String getColumnText(Object obj, int index) {
			if (obj instanceof Enum) {
				return ((Enum<?>) obj).name();
			}
			return obj.toString();
		}

		@Override
		public Image getColumnImage(Object obj, int index) {
			return null;
		}
	}

	class TraceMechanismsCP implements IStructuredContentProvider {

		@Override
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		@Override
		public void dispose() {
		}

		@Override
		public Object[] getElements(Object parent) {
			Object items[] = null;
			//
			// Implementations of a tracing mechanism are depending on the injection mechanism and (likely) on the
			// programming language. Therefore, they are not part of this plugin shipped with Papyrus, but use an
			// extension mechanism.

			List<ITraceMechanism> mechanisms = TraceMechanism.getTraceMechanisms();
			if (mechanisms.size() == 0) {
				items = new String[] { Messages.TraceActionSelection_NoPluginsProvideTraceExt };
			}
			else {
				EList<String> idList = new BasicEList<String>();
				for (ITraceMechanism mechanism : mechanisms) {
					for (String id : mechanism.getTraceMechanismIDs(m_me)) {
						idList.add(id);
					}
				}
				items = idList.toArray(new String[0]);
			}
			return items;
		}
	}

	@Override
	public Control createDialogArea(Composite parent) {
		Composite contents = (Composite) super.createDialogArea(parent);

		Label label = new Label(contents, SWT.NONE);
		label.setText(Messages.TraceActionSelection_SelectTraceAction);

		// need context dependent dialogs on options
		// we may need more than one options (e.g. AllOperations + OperationsWithParameters + (begin/end or both?))
		// clean way: accumulate all options, distribute them automatically accordingly. Better (even if less efficient, if strings)

		String[][] taClassOptions = TraceActions.getStringFields(TAClass.values());
		String[][] taStateOptions = TraceActions.getStringFields(TAState.values());
		String[][] taOperationOptions = TraceActions.getStringFields(TAOperation.values());
		String[][] taTransitionOptions = TraceActions.getStringFields(TATransition.values());
		String actionString = m_marker.getAttribute(TracepointConstants.traceAction, ""); //$NON-NLS-1$
		String mechanismID = m_marker.getAttribute(TracepointConstants.traceMechanism, ""); //$NON-NLS-1$

		if (m_me instanceof State) {
			stateOptions = new BinaryEncodedMChoiceFieldEditor(Messages.TraceActionSelection_StateOptions, 3, taStateOptions, contents, true);
			stateOptions.setupViaString(actionString);
		}
		else if (m_me instanceof Class) {
			classOptions = new BinaryEncodedMChoiceFieldEditor(Messages.TraceActionSelection_ClassOptions, 3, taClassOptions, contents, true);
			stateOptions = new BinaryEncodedMChoiceFieldEditor(Messages.TraceActionSelection_StateOptions, 3, taStateOptions, contents, true);
			operationOptions = new BinaryEncodedMChoiceFieldEditor(Messages.TraceActionSelection_OperationOptions, 3, taOperationOptions, contents, true);
			classOptions.setupViaString(TraceActions.getOptions(actionString, TraceFeature.Class));
			stateOptions.setupViaString(TraceActions.getOptions(actionString, TraceFeature.State));
			operationOptions.setupViaString(TraceActions.getOptions(actionString, TraceFeature.Operation));
		}
		else if (m_me instanceof Operation) {
			operationOptions = new BinaryEncodedMChoiceFieldEditor(Messages.TraceActionSelection_OperationOptions, 3, taOperationOptions, contents, true);
			operationOptions.setupViaString(actionString);
		}
		else if (m_me instanceof Port) {
			// same options as for operation - only the operation name or the parameters as well
			portOptions = new BinaryEncodedMChoiceFieldEditor(Messages.TraceActionSelection_PortOptions, 3, taOperationOptions, contents, true);
			portOptions.setupViaString(actionString);
		}
		else if (m_me instanceof Transition) {
			transitionOptions = new BinaryEncodedMChoiceFieldEditor(Messages.TraceActionSelection_TransitionOptions, 3, taTransitionOptions, contents, true);
			transitionOptions.setupViaString(actionString);
		}

		Group implementationGroup = new Group(parent, SWT.NONE);
		implementationGroup.setText(Messages.TraceActionSelection_ImplementationOptions);

		// need additional item how the trace mechanism should be realized, i.e. available tracing mechanisms
		fTraceImplementations = CheckboxTableViewer.newCheckList(implementationGroup, SWT.H_SCROLL | SWT.V_SCROLL);

		fTraceImplementations.setContentProvider(new TraceMechanismsCP());
		fTraceImplementations.setInput(this);
		fTraceImplementations.setChecked(mechanismID, true); // TODO: likely not to work

		fTraceImplementations.addCheckStateListener(new ICheckStateListener() {

			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				Object element = event.getElement();
				boolean isChecked = event.getChecked();
				// assure radio button functionality
				if (isChecked) {
					for (Object checkedElement : fTraceImplementations.getCheckedElements()) {
						if (checkedElement != element) {
							fTraceImplementations.setChecked(checkedElement, false);
						}
					}
				}
			}
		});

		fTraceImplementations.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object first = ((IStructuredSelection) selection).getFirstElement();
					if (first instanceof String) {
						List<ITraceMechanism> mechanisms = TraceMechanism.getTraceMechanisms();
						boolean noDesc = true;
						for (ITraceMechanism mechanism : mechanisms) {
							String description = mechanism.getTraceMechanismDescription(m_me, (String) first);
							if (description != null) {
								fDescription.setText(description);
								noDesc = false;
								break;
							}
						}
						if (noDesc) {
							fDescription.setText(Messages.TraceActionSelection_NotAvail);
						}
					}
				}
			}
		});

		fDescription = new Text(implementationGroup, SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY);

		GridData span = new GridData();
		span.horizontalAlignment = GridData.FILL;
		span.grabExcessHorizontalSpace = true;
		span.grabExcessVerticalSpace = true;
		span.verticalAlignment = GridData.FILL;
		span.heightHint = 250;

		// fTraceActions.getTable().setLayoutData(span);
		implementationGroup.setLayout(new GridLayout());
		implementationGroup.setLayoutData(span);

		GridData span2 = new GridData();
		span2.horizontalAlignment = GridData.FILL;
		span2.grabExcessHorizontalSpace = true;
		span2.grabExcessVerticalSpace = true;
		span2.verticalAlignment = GridData.FILL;
		span2.heightHint = 80;
		fDescription.setLayoutData(span2);
		fTraceImplementations.getTable().setLayoutData(span2);

		// ruleGroup.setLayout(new RowLayout (SWT.VERTICAL));
		parent.setLayout(new GridLayout(1, false));
		// parent.setLayoutData(groupGridData);
		return contents;
	}

	// obtain name and explicit/implicit node Allocation
	protected void setTextFromData(TreeItem ti) {
		Object data = ti.getData();
		if (data instanceof InstanceSpecification) {
			// ti.setText(new String[]{ name, nodeName, "[" + list + "]" });
		}
	}

	protected void refreshTree(TreeItem ti) {
		setTextFromData(ti);
		for (TreeItem subItem : ti.getItems()) {
			refreshTree(subItem);
		}
	}
}
