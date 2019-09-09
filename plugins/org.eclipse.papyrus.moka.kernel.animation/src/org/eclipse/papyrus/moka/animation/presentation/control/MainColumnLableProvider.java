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

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.papyrus.moka.animation.presentation.data.AnimatingInstanceNode;
import org.eclipse.papyrus.moka.animation.presentation.data.AnimationTreeNode;
import org.eclipse.papyrus.moka.animation.presentation.data.DiagramAnimationNode;
import org.eclipse.papyrus.moka.utils.helper.presentation.LabelProviderHelper;

public class MainColumnLableProvider extends ColumnLabelProvider {

	protected RootLabelProvider rootLabelProvider;

	protected AnimatingInstanceLabelProvider animatorLabelProvider;

	public MainColumnLableProvider() {
		this.rootLabelProvider = new RootLabelProvider();
		this.animatorLabelProvider = new AnimatingInstanceLabelProvider();
	}

	protected void initPapyrusLabelProviderService() {

	}

	@Override
	public void update(ViewerCell cell) {
		Object element = cell.getElement();
		if (element instanceof AnimatingInstanceNode) {
			cell.setText(this.animatorLabelProvider.getText(element));
			cell.setImage(this.animatorLabelProvider.getImage(element));
		} else if (element instanceof DiagramAnimationNode) {
			Diagram diagram = ((DiagramAnimationNode) element).getAnimatedDiagram();
			cell.setText(LabelProviderHelper.getInstance().getText(diagram));
			cell.setImage(LabelProviderHelper.getInstance().getImage(diagram));
		} else if (element instanceof AnimationTreeNode) {
			cell.setText(this.rootLabelProvider.getText(element));
			cell.setImage(this.rootLabelProvider.getImage(element));
		} else {
			cell.setText("Unknown");
		}
	}

}
