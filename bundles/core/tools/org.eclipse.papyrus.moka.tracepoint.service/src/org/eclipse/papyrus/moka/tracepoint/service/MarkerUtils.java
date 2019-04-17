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

package org.eclipse.papyrus.moka.tracepoint.service;

import java.util.MissingResourceException;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.infra.core.markers.MarkerConstants;

/**
 * Utilities for Markers (TODO: some of these are generic marker services (move to infra core markers) and not specific to tracepoints).
 *
 * @author ansgar
 *
 */
public class MarkerUtils {

	public static URI getURI(IMarker marker) {
		String uriOfMarkerStr = marker.getAttribute(MarkerConstants.uri, null);
		if (uriOfMarkerStr != null) {
			return URI.createURI(uriOfMarkerStr);
		}
		return null;
	}

	/**
	 * return the EObject of a marker (provided that it is a marker with a URI)
	 *
	 * @param marker
	 * @return the associated EObject
	 */
	public static EObject getEObjectOfMarker(IMarker marker) {
		return getEObjectOfMarker(resourceSet, marker);
	}

	/**
	 * return the EObject of a marker (provided that it is a marker with a URI)
	 *
	 * @param pResourceSet
	 *            : the resourceSet into which the model associated with the eObject should
	 *            be loaded
	 * @param marker
	 * @return the associated EObject
	 */
	public static EObject getEObjectOfMarker(ResourceSet pResourceSet, IMarker marker) {
		URI uriOfMarker = getURI(marker);
		if (uriOfMarker != null) {
			try {
				pResourceSet.getResource(uriOfMarker.trimFragment(), true);
				return pResourceSet.getEObject(uriOfMarker, true);
			} catch (MissingResourceException e) {
				throw new RuntimeException("MarkerUtils.getEObjectOfMarker: " + e.getMessage()); //$NON-NLS-1$
			}
		}
		return null;
	}

	public static boolean isActive(IMarker marker) {
		return marker.getAttribute(TracepointConstants.isActive, false);
	}

	/**
	 * our own copy of resource set
	 * we do not use the Papyrus resourceSet, since every editor keeps his own copy of the resource set (which is probably
	 * quite bad) and thus no resourceSet would be available, if Papyrus is not open.
	 */
	public static ResourceSet resourceSet = new ResourceSetImpl();
}
