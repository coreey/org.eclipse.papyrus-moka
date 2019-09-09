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
import org.eclipse.swt.graphics.Image;

public class RootLabelProvider extends LabelProvider {

	public static final String ROOT_ICON = "icons/observe_icon.png";

	protected static final String ROOT_NAME = "Animated Diagrams";

	@Override
	public String getText(Object element) {
		return ROOT_NAME;
	}

	@Override
	public Image getImage(Object element) {
		return AnimationPlugin.getDefault().getImageRegistry().get(ROOT_ICON);
	}
}
