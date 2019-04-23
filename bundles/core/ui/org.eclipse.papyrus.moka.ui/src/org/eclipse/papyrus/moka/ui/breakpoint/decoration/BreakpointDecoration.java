/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.moka.ui.breakpoint.decoration;

import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.services.decoration.IDecorationSpecificFunctions;
import org.eclipse.papyrus.infra.services.decoration.util.Decoration.PreferedPosition;
import org.eclipse.papyrus.infra.services.decoration.util.IPapyrusDecoration;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;
import org.eclipse.papyrus.moka.ui.Activator;

/**
 * An implementation of IDecorationSpecificFunctions, in order to attach
 * specific decorations to Moka Breakpoint Markers.
 *
 */
public class BreakpointDecoration implements IDecorationSpecificFunctions {

	public static final String activeBreakpoint16 = "icons/brkp_16x16.gif";

	public static final String inActiveBreakpoint16 = "icons/brkpd_16x16.gif";

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.papyrus.infra.services.decoration.IDecorationSpecificFunctions#getImageDescriptorForGE(org.eclipse.papyrus.infra.services.
	 * markerlistener.IPapyrusMarker)
	 */
	public ImageDescriptor getImageDescriptorForGE(IPapyrusMarker marker) {
		org.eclipse.papyrus.infra.widgets.Activator widgetsActivator = org.eclipse.papyrus.infra.widgets.Activator.getDefault();
		ImageDescriptor overlay = null;
		boolean isEnabled = marker.getAttribute(IBreakpoint.ENABLED, false);
		if (isEnabled) {
			overlay = widgetsActivator.getImageDescriptor(Activator.PLUGIN_ID, activeBreakpoint16);
		} else {
			overlay = widgetsActivator.getImageDescriptor(Activator.PLUGIN_ID, inActiveBreakpoint16);
		}

		return overlay;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.papyrus.infra.services.decoration.IDecorationSpecificFunctions#getImageDescriptorForME(org.eclipse.papyrus.infra.services.
	 * markerlistener.IPapyrusMarker)
	 */
	public ImageDescriptor getImageDescriptorForME(IPapyrusMarker marker) {
		org.eclipse.papyrus.infra.widgets.Activator widgetsActivator = org.eclipse.papyrus.infra.widgets.Activator.getDefault();
		ImageDescriptor overlay = null;
		boolean isEnabled = marker.getAttribute(IBreakpoint.ENABLED, false);
		if (isEnabled) {
			overlay = widgetsActivator.getImageDescriptor(Activator.PLUGIN_ID, activeBreakpoint16);
		} else {
			overlay = widgetsActivator.getImageDescriptor(Activator.PLUGIN_ID, inActiveBreakpoint16);
		}

		return overlay;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.papyrus.infra.services.decoration.IDecorationSpecificFunctions#getPreferedPosition(org.eclipse.papyrus.infra.services.markerlistener
	 * .IPapyrusMarker)
	 */
	public PreferedPosition getPreferedPosition(IPapyrusMarker marker) {
		return PreferedPosition.SOUTH_EAST;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.papyrus.infra.services.decoration.IDecorationSpecificFunctions#getMessage(org.eclipse.papyrus.infra.services.markerlistener.
	 * IPapyrusMarker)
	 */
	public String getMessage(IPapyrusMarker marker) {
		boolean isEnabled = marker.getAttribute(IBreakpoint.ENABLED, false);
		return (isEnabled ? "" : "disabled ") + "breakpoint";
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.papyrus.infra.services.decoration.IDecorationSpecificFunctions#getPriority(org.eclipse.papyrus.infra.services.markerlistener.
	 * IPapyrusMarker)
	 */
	public int getPriority(IPapyrusMarker marker) {
		return 0; // all markers have same priority (and we should not have multiple markers on the same model element).
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.papyrus.infra.services.decoration.IDecorationSpecificFunctions#supportsMarkerPropagation()
	 */
	public MarkChildren supportsMarkerPropagation() {
		return MarkChildren.NO;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.papyrus.infra.services.decoration.IDecorationSpecificFunctions#markerPropagation(org.eclipse.emf.common.util.EList)
	 */
	public IPapyrusDecoration markerPropagation(EList<IPapyrusDecoration> childDecorations) {
		return null;
	}

}
