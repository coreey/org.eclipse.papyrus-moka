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

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.papyrus.moka.animation.presentation.data.AnimatedDiagramTree;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class AnimationControlView extends ViewPart {

	public static final String ID = "org.eclipse.papyrus.moka.animation.presentation.control.controlview";

	protected TreeViewer viewer;

	public AnimationControlView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		this.viewer = new TreeViewer(parent, SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL);
		this.viewer.setContentProvider(new AnimatedDiagramTreeContentProvider());
		this.viewer.addFilter(new AnimationControlViewFilter());
		this.viewer.getTree().setHeaderVisible(true);
		this.viewer.getTree().setLinesVisible(true);
		this.createColumns(this.viewer);
	}

	private void createColumns(TreeViewer viewer) {
		TreeViewerColumn mainColumn = new TreeViewerColumn(viewer, SWT.NONE);
		mainColumn.getColumn().setText("Animators per diagram");
		mainColumn.getColumn().setWidth(450);
		mainColumn.setLabelProvider(new MainColumnLableProvider());
		TreeViewerColumn allowColumn = new TreeViewerColumn(viewer, SWT.CENTER);
		allowColumn.getColumn().setText("Allow");
		allowColumn.getColumn().setWidth(50);
		allowColumn.setLabelProvider(new AnimatorRightLabelProvider());
		allowColumn.setEditingSupport(new AnimationEditingSupport(this.viewer));
	}

	public void setInitialInput(AnimatedDiagramTree input) {
		this.viewer.setInput(input);
		this.viewer.expandAll();
	}

	@Override
	public void dispose() {
		super.dispose();
		this.viewer.setInput(null);
	}

	@Override
	public void setFocus() {
	}
}
