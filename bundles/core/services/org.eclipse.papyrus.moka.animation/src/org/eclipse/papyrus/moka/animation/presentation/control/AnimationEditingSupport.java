/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
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
package org.eclipse.papyrus.moka.animation.presentation.control;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.moka.animation.presentation.data.AnimatingInstanceNode;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class AnimationEditingSupport extends EditingSupport {

	// The viewer for which an editing support is provided
	private TreeViewer viewer;

	// The cell editor used to realize the edition
	private ComboBoxCellEditor cellEditor;

	public static final String YES = "Yes";

	public static final String NO = "No";

	public AnimationEditingSupport(TreeViewer treeViewer) {
		super(treeViewer);
		this.viewer = treeViewer;
		this.cellEditor = new ComboBoxCellEditor((Composite) treeViewer.getControl(), new String[] { YES, NO });
		this.cellEditor.setStyle(SWT.CENTER);
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		// A cell editor is only provided in the case the data behind
		// the tree item is actually an animator (i.e., an extensional value)
		// provided by the Moka runtime
		if (element instanceof AnimatingInstanceNode) {
			return this.cellEditor;
		}
		return null;
	}

	@Override
	protected boolean canEdit(Object element) {
		// Editing support is only provided in the case the data behind
		// the tree item is actually an animator (i.e., an extensional value)
		// provided by the Moka runtime
		if (element instanceof AnimatingInstanceNode) {
			return true;
		}
		return false;
	}

	@Override
	protected Object getValue(Object element) {
		// The value that is displayed by the control is the view
		// of the rights of the animator
		if (element instanceof AnimatingInstanceNode) {
			if (((AnimatingInstanceNode) element).isAllowed()) {
				return 0;
			} else {
				return 1;
			}
		}
		return null;
	}

	@Override
	protected void setValue(Object element, Object value) {
		// When the value change then these changes are both propagated
		// to the viewer and the data model
		if (element instanceof AnimatingInstanceNode) {
			if (((Integer) value) == 0) {
				((AnimatingInstanceNode) element).setAllowed(true);
			} else {
				((AnimatingInstanceNode) element).setAllowed(false);
			}
			viewer.update(element, null);
		}
	}

}
