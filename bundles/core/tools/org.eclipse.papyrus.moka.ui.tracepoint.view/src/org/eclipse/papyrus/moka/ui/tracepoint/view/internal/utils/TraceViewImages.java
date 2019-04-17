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

package org.eclipse.papyrus.moka.ui.tracepoint.view.internal.utils;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.moka.ui.tracepoint.view.Activator;
import org.eclipse.swt.graphics.Image;


public class TraceViewImages {

	public static ImageDescriptor getGotoObjID() {
		org.eclipse.papyrus.infra.widgets.Activator widgetsActivator =
				org.eclipse.papyrus.infra.widgets.Activator.getDefault();
		return widgetsActivator.getImageDescriptor(Activator.PLUGIN_ID, "icons/gotoobj_tsk.gif"); //$NON-NLS-1$
	}

	public static ImageDescriptor getSkipAllID() {
		org.eclipse.papyrus.infra.widgets.Activator widgetsActivator =
				org.eclipse.papyrus.infra.widgets.Activator.getDefault();
		return widgetsActivator.getImageDescriptor(Activator.PLUGIN_ID, "icons/skip_brkp.gif"); //$NON-NLS-1$
	}

	public static Image getSkipAllImage() {
		if (skipAllImage == null) {
			skipAllImage = getSkipAllID().createImage();
		}
		return skipAllImage;
	}

	protected static Image skipAllImage = null;
}
