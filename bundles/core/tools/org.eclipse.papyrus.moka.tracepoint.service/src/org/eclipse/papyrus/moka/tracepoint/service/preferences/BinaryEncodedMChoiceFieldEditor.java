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

import org.eclipse.swt.widgets.Composite;


/**
 * A class derived from the MultipleChoiceFieldEditor.
 * It encodes a multiple choice value in a binary way, i.e. bit I is set in the result, if the i-th choice is active.
 * This class can also be used outside a preference page
 *
 * @author ansgar
 *
 */
public class BinaryEncodedMChoiceFieldEditor extends MultipleChoiceFieldEditor {

	/**
	 * @param name
	 *            The preference ID
	 * @param labeltext
	 *            the label text
	 * @param numColumns
	 *            the number of columns
	 * @param labelsAndValues
	 *            a two dimensional array containing the labels and values
	 * @param parent
	 *            the parent SWT composite (field editor parent)
	 * @param useGroup
	 *            display contents within a group
	 */
	public BinaryEncodedMChoiceFieldEditor(String name, String labeltext, int numColumns, String[][] labelsAndValues, Composite parent, boolean useGroup) {
		super(name, labeltext, numColumns, labelsAndValues, parent, useGroup);
	}


	/**
	 * Convenience constructor, if used outside a preference page
	 *
	 * @param labeltext
	 *            the label text
	 * @param numColumns
	 *            the number of columns
	 * @param labelsAndValues
	 *            a two dimensional array containing the labels and values
	 * @param parent
	 *            the parent SWT composite (field editor parent)
	 * @param useGroup
	 *            display contents within a group
	 */
	public BinaryEncodedMChoiceFieldEditor(String labeltext, int numColumns, String[][] labelsAndValues, Composite parent, boolean useGroup) {
		super("", labeltext, numColumns, labelsAndValues, parent, useGroup); //$NON-NLS-1$
	}

	/**
	 * Use this function to initialize the set/non-set flags within the dialog from a binary encoded value,
	 * if you use the dialog outside a preference page
	 *
	 * @param currentValue
	 */
	public void setupViaString(String currentValue) {
		setupControls(currentValue);
	}

	/**
	 * Use this function to get the results,
	 * if you use the dialog outside a preference page
	 *
	 * @return the result
	 */
	public String getResult() {
		result = gatherSettings();
		return result;
	}

	/**
	 * Convenience function returning an integer result instead of a String result
	 * (requires double conversion that is difficult to avoid, since calculateResults needs to return
	 * a string);
	 */
	public int getIntResult() {
		if (getResult() == null) {
			return 0;
		}
		return Integer.parseInt(getResult());
	}

	@Override
	protected String calculateResult(String[][] settings) {
		int traceActionValue = 0;
		int index = 0;
		for (String setting[] : settings) {
			// [0] = name, [1] = value [2] = checked
			if (setting[2].equals("true")) { //$NON-NLS-1$
				traceActionValue += 1 << index;
			}
			index++;
		}
		;
		return String.valueOf(traceActionValue);
	}

	@Override
	protected boolean isSelected(String fieldName, String valueToSet) {
		try {
			int value = new Integer(valueToSet);
			int index = 0;
			for (String setting[] : labelsAndValues) {
				// [0] = name, [1] = value [2] = checked
				if (setting[0].equals(fieldName)) {
					return (value & (1 << index)) > 0;
				}
				index++;
			}
			;
		} catch (NumberFormatException e) {
		}
		return false;
	}
}
