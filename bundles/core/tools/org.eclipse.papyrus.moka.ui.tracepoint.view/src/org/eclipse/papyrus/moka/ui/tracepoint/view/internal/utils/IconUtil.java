/*****************************************************************************
 * Copyright (c) 2019 CEA LIST.
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
 *  Pauline DEVILLE (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.ui.tracepoint.view.internal.utils;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.moka.tracepoint.service.TraceFunctions;
import org.eclipse.swt.graphics.Image;

/**
 * This util class is used to provide icons
 */
public class IconUtil {

	private static Image activateTracepointIcon;

	private static Image inactivateTracepointIcon;

	/**
	 * Get the activate tracepoint icon
	 */
	public static Image getActivateTracepointIcon() {
		if (activateTracepointIcon == null) {
			org.eclipse.papyrus.infra.widgets.Activator widgetsActivator = org.eclipse.papyrus.infra.widgets.Activator.getDefault();
			ImageDescriptor imageDescriptor = widgetsActivator.getImageDescriptor(org.eclipse.papyrus.moka.tracepoint.service.Activator.PLUGIN_ID, TraceFunctions.activeTracepoint16);
			if (imageDescriptor != null) {
				activateTracepointIcon = imageDescriptor.createImage();
			}
		}
		return activateTracepointIcon;
	}

	/**
	 * Get the inactivate tracepoint icon
	 */
	public static Image getInactivateTracepointIcon() {
		if (inactivateTracepointIcon == null) {
			org.eclipse.papyrus.infra.widgets.Activator widgetsActivator = org.eclipse.papyrus.infra.widgets.Activator.getDefault();
			ImageDescriptor imageDescriptor = widgetsActivator.getImageDescriptor(org.eclipse.papyrus.moka.tracepoint.service.Activator.PLUGIN_ID, TraceFunctions.inActiveTracepoint16);
			if (imageDescriptor != null) {
				inactivateTracepointIcon = imageDescriptor.createImage();
			}
		}
		return inactivateTracepointIcon;
	}

}
