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

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.papyrus.moka.animation.presentation.data.AnimatingInstanceNode;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public class AnimatorRightLabelProvider extends ColumnLabelProvider {

	@Override
	public void update(ViewerCell cell) {
		if (cell.getElement() instanceof AnimatingInstanceNode) {
			AnimatingInstanceNode animator = (AnimatingInstanceNode) cell.getElement();
			if (animator.isAllowed()) {
				cell.setText(AnimationEditingSupport.YES);
				cell.setBackground(new Color(Display.getDefault(), 91, 196, 21));
			} else {
				cell.setText(AnimationEditingSupport.NO);
				cell.setBackground(new Color(Display.getDefault(), 255, 0, 0));
			}
		}
	}
}
