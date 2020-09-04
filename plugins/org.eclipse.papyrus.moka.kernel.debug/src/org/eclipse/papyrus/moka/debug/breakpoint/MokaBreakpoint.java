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
package org.eclipse.papyrus.moka.debug.breakpoint;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.model.Breakpoint;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.moka.debug.MokaDebugPlugin;
import org.eclipse.papyrus.moka.utils.constants.MokaConstants;

/**
 * Implementation of IBreakpoint provided by Moka. MokaBreakpoint relies on
 * markers of type MokaConstants.MOKA_BREAKPOINT_MARKER_ID, which extend both
 * papyrus model marker and eclipse breakpoint marker.
 *
 */
public class MokaBreakpoint extends Breakpoint {

	/**
	 * The uri of the element to which this breakpoint is attached
	 */
	protected URI uriOfElement;

	private String label;

	/**
	 * A default resource set which should, ideally, never be used
	 */
	protected static ResourceSet defaultResourceSet;

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.debug.core.model.IBreakpoint#getModelIdentifier()
	 */
	public String getModelIdentifier() {
		return MokaConstants.MOKA_DEBUG_MODEL_ID;
	}

	/**
	 * Return the model element to which this breakpoint is attached
	 *
	 * @return The model element to which this breakpoint is attached
	 */
	public URI getModelElementURI() {
		return this.uriOfElement;
	}

	/**
	 * Toggles a breakpoint on the given model element
	 *
	 * @param modelElement The model element to which a breakpoint has to be
	 *                     attached
	 */
	public void toggleBreakpoint(EObject modelElement, String label) {
		String uri = modelElement.eResource().getURI().toString();
		String fragment = modelElement.eResource().getURIFragment(modelElement);
		IResource iresource = getIResource(modelElement.eResource());

		this.uriOfElement = EcoreUtil.getURI(modelElement);

		this.label = label;

		try {
			if (iresource != null) {
				IMarker marker = iresource.createMarker(MokaConstants.MOKA_BREAKPOINT_MARKER_ID);
				marker.setAttribute(EValidator.URI_ATTRIBUTE, uri + "#" + fragment);
				marker.setAttribute(IBreakpoint.ID, this.getModelIdentifier());
				this.setMarker(marker);
				this.setEnabled(true);
				this.setPersisted(true);
			}
		} catch (CoreException ce) {
			MokaDebugPlugin.getDefault().logger.error("Problem while toggleBreakpointing " + uriOfElement, ce); //$NON-NLS-1$
		}
	}

	/**
	 * Convenience method returning the IResource corresponding to a Resource
	 *
	 * @param resource The Resource from which the corresponding IResource has to be
	 *                 retrieved
	 * @return the IResource corresponding to the Resource
	 */
	public static IResource getIResource(Resource resource) {
		if (resource == null) {
			return null;
		}
		String uriPath = resource.getURI().toPlatformString(true);
		if (uriPath == null) {
			return null;
		}
		IResource iresource = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uriPath));
		if (iresource != null) {
			if (iresource.exists()) {
				return iresource;
			}
		}
		return null;
	}

	/**
	 * Computes a label for this breakpoint
	 *
	 * @return A label for this breakpoint
	 */
	public String getLabel() {

		return label;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.debug.core.model.Breakpoint#setMarker(org.eclipse.core.resources.
	 * IMarker)
	 */
	@Override
	public void setMarker(IMarker marker) throws CoreException {
		if (this.uriOfElement == null) {
			this.uriOfElement = getURI(marker);
		}
		super.setMarker(marker);
	}

	/**
	 * Convenience method returning the URI corresponding to the value of the
	 * EValidator.URI_ATTRIBUTE of a marker
	 *
	 * @param marker The marker from which the URI corresponding to the value its
	 *               EValidator.URI_ATTRIBUTE has to be constructed
	 * @return The URI corresponding to the value of the EValidator.URI_ATTRIBUTE of
	 *         the given marker
	 */
	public static URI getURI(IMarker marker) {
		String uriOfMarkerStr = marker.getAttribute(EValidator.URI_ATTRIBUTE, null);
		if (uriOfMarkerStr != null) {
			return URI.createURI(uriOfMarkerStr);
		}
		return null;
	}

}
