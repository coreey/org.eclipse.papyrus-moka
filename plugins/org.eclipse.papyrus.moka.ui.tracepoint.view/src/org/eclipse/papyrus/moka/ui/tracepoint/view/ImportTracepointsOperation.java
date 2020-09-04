/*****************************************************************************
 * Copyright (c) 2020 CEA LIST.
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

package org.eclipse.papyrus.moka.ui.tracepoint.view;

import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.model.IBreakpointImportParticipant;
import org.eclipse.debug.ui.actions.ImportBreakpointsOperation;
import org.eclipse.papyrus.infra.core.markers.MarkerConstants;
import org.eclipse.papyrus.moka.tracepoint.service.TracepointConstants;

/**
 * Import breakpoints from a file
 */
public class ImportTracepointsOperation extends ImportBreakpointsOperation {

	IMarker markers[];

	public ImportTracepointsOperation(String fileName) {
		super(fileName, true, true);
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		try {
			if (root != null) {
				markers = root.findMarkers(TracepointConstants.tracepointMarker, true, IResource.DEPTH_INFINITE);
			}
		} catch (CoreException e) {
			Activator.getDefault().logger.error("Error occured while finding markers for "+root,e);
		}
	}

	/**
	 * Returns a marker backing an existing breakpoint based on the given set of breakpoint attributes.
	 * Overloaded, as superclass only returns breakpoints, not tracepoints.
	 *
	 * @param attributes
	 *            the map of attributes to compare for marker equality
	 * @param participants
	 *            the list of participants to ask if a breakpoint matches the given map of attributes
	 * @return the marker for an existing tracepoint or <code>null</code> if one could not be located
	 */
	@Override
	protected IMarker findExistingMarker(Map<String, Object> attributes, IBreakpointImportParticipant[] participants) {
		Object uri = attributes.get(MarkerConstants.uri);
		for (IMarker marker : markers) {
			String uriOfMarkerStr = marker.getAttribute(MarkerConstants.uri, ""); //$NON-NLS-1$
			if (uriOfMarkerStr.equals(uri)) {
				return marker;
			}
		}
		return null;
	}
}
