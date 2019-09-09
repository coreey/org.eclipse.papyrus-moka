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

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.moka.animation.AnimationPlugin;
import org.eclipse.papyrus.moka.animation.presentation.data.AnimatingInstanceNode;
import org.eclipse.swt.graphics.Image;

public class AnimatingInstanceLabelProvider extends LabelProvider {

	public static final String THREAD_ICON = "icons/thread_icon.png";

	@Override
	public String getText(Object element) {
		if (element instanceof AnimatingInstanceNode) {
			return ((AnimatingInstanceNode) element).instance.getIdentifier();
		}
		return null;
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof AnimatingInstanceNode) {
			return AnimationPlugin.getDefault().getImageRegistry().get(THREAD_ICON);
		}
		return null;
	}

}
