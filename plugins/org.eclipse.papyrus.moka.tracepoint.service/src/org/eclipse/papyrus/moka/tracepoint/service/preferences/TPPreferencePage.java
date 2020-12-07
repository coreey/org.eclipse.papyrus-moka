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
package org.eclipse.papyrus.moka.tracepoint.service.preferences;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.papyrus.moka.tracepoint.service.Activator;
import org.eclipse.papyrus.moka.tracepoint.service.ITraceMechanism;
import org.eclipse.papyrus.moka.tracepoint.service.Messages;
import org.eclipse.papyrus.moka.tracepoint.service.TraceActions;
import org.eclipse.papyrus.moka.tracepoint.service.TraceActions.TAClass;
import org.eclipse.papyrus.moka.tracepoint.service.TraceActions.TAOperation;
import org.eclipse.papyrus.moka.tracepoint.service.TraceActions.TAState;
import org.eclipse.papyrus.moka.tracepoint.service.TraceActions.TATransition;
import org.eclipse.papyrus.moka.tracepoint.service.TraceMechanism;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * This class represents the TracePoint preference page
 * <p>
 * This page is used to modify preferences only. They are stored in the preference store that belongs to the main plug-in class. That way, preferences can be accessed directly via the preference store.
 */

public class TPPreferencePage
		extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {

	public TPPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription(Messages.TPPreferencePage_TraceOptions);
	}

	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	@Override
	public void createFieldEditors() {
		List<ITraceMechanism> mechanisms = TraceMechanism.getTraceMechanisms();
		int elements = 0;
		for (ITraceMechanism mechanism : mechanisms) {
			EList<String> mechanismIDs = mechanism.getTraceMechanismIDs(null);
			elements += mechanismIDs.size();
		}
		String[][] mechList = new String[elements][2];
		elements = 0;
		for (ITraceMechanism mechanism : mechanisms) {
			EList<String> mechanismIDs = mechanism.getTraceMechanismIDs(null);
			for (String id : mechanismIDs) {
				String description = mechanism.getTraceMechanismDescription(null, id);
				if (description == null) {
					description = Messages.TraceActionSelection_NotAvail;
				}
				mechList[elements][1] = id;
				mechList[elements][0] = description;
				elements++;
			}
		}

		String[][] taClassOptions = TraceActions.getStringFields(TAClass.values());
		String[][] taStateOptions = TraceActions.getStringFields(TAState.values());
		String[][] taOperationOptions = TraceActions.getStringFields(TAOperation.values());
		String[][] taPortOptions = TraceActions.getStringFields(TAOperation.values());
		String[][] taTransitionOptions = TraceActions.getStringFields(TATransition.values());

		String tst = getPreferenceStore().getString(TPPreferenceConstants.P_TRACE_OPTION_CLASS);
		
		addField(new BinaryEncodedMChoiceFieldEditor(TPPreferenceConstants.P_TRACE_OPTION_CLASS, Messages.TraceActionSelection_ClassOptions, 3, taClassOptions, getFieldEditorParent(), true));

		addField(new BinaryEncodedMChoiceFieldEditor(TPPreferenceConstants.P_TRACE_OPTION_STATE, Messages.TraceActionSelection_StateOptions, 3, taStateOptions, getFieldEditorParent(), true));

		addField(new RadioGroupFieldEditor(
				TPPreferenceConstants.P_TRACE_OPTION_OP,
				Messages.TraceActionSelection_OperationOptions, 3, taOperationOptions, getFieldEditorParent(), true));

		addField(new RadioGroupFieldEditor(
				TPPreferenceConstants.P_TRACE_OPTION_PORT,
				Messages.TraceActionSelection_PortOptions, 3, taPortOptions, getFieldEditorParent(), true));

		addField(new RadioGroupFieldEditor(
				TPPreferenceConstants.P_TRACE_OPTION_TRANSITION,
				Messages.TraceActionSelection_TransitionOptions, 3, taTransitionOptions, getFieldEditorParent(), true));

		addField(new ComboFieldEditor(
				TPPreferenceConstants.P_TRACE_IMPLEMENTATION,
				Messages.TPPreferencePage_TRACE_IMPL, mechList, getFieldEditorParent()));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	@Override
	public void init(IWorkbench workbench) {
	}
}
