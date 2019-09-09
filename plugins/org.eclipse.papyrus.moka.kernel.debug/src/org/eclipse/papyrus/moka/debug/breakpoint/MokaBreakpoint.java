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

import java.util.MissingResourceException;

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
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.moka.utils.constants.MokaConstants;
import org.eclipse.papyrus.moka.utils.helper.EditorUtils;
import org.eclipse.ui.IEditorPart;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Implementation of IBreakpoint provided by Moka.
 * MokaBreakpoint relies on markers of type MokaConstants.MOKA_BREAKPOINT_MARKER_ID,
 * which extend both papyrus model marker and eclipse breakpoint marker.
 *
 */
public class MokaBreakpoint extends Breakpoint {

	/**
	 * The model element to which this breakpoint is attached
	 */
	protected EObject modelElement;

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
	public EObject getModelElement() {
		return this.modelElement;
	}

	/**
	 * Toggles a breakpoint on the given model element
	 *
	 * @param modelElement
	 *            The model element to which a breakpoint has to be attached
	 */
	public void toggleBreakpoint(EObject modelElement) {
		String uri = modelElement.eResource().getURI().toString();
		String fragment = modelElement.eResource().getURIFragment(modelElement);
		IResource iresource = getIResource(modelElement.eResource());
		this.modelElement = modelElement;
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
			Activator.log.error(ce);
		}
	}

	/**
	 * Convenience method returning the IResource corresponding to a Resource
	 *
	 * @param resource
	 *            The Resource from which the corresponding IResource has to be retrieved
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
		String label = "";
		if (this.modelElement instanceof NamedElement) {
			return ((NamedElement) this.modelElement).getQualifiedName();
		}
		return label;
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.debug.core.model.Breakpoint#setMarker(org.eclipse.core.resources.IMarker)
	 */
	@Override
	public void setMarker(IMarker marker) throws CoreException {
		if (this.modelElement == null) {
			this.modelElement = getEObjectOfMarker(marker);
		}
		super.setMarker(marker);
	}

	/**
	 * Convenience method returning the EObject of a given marker (provided that it is a marker with a URI)
	 *
	 * @param marker
	 *            The marker from which eObject has to be retrieved
	 * @return The EObject associated with the given marker
	 */
	public static EObject getEObjectOfMarker(IMarker marker) {
		URI uriOfMarker = getURI(marker);
		if (uriOfMarker != null) {
			try {
				EObject modelElement = null;
				IEditorPart part = EditorUtils.getEditorPart(uriOfMarker.trimFragment().toString());
				if (part != null) {
					ServicesRegistry servicesRegistry = (ServicesRegistry) part.getAdapter(ServicesRegistry.class);
					if (servicesRegistry != null) {
						try {
							ResourceSet resourceSet = servicesRegistry.getService(ModelSet.class);
							modelElement = resourceSet.getEObject(uriOfMarker, true);
							if (modelElement != null) {
								return modelElement;
							}
						} catch (ServiceException e) {
							Activator.log.error(e);
						}
					}
				}

				if (defaultResourceSet == null) {
					defaultResourceSet = new ResourceSetImpl();
				}
				defaultResourceSet.getResource(uriOfMarker.trimFragment(), true);
				return defaultResourceSet.getEObject(uriOfMarker, true);
			} catch (MissingResourceException e) {
				Activator.log.error(e);
			}
		}
		return null;
	}

	/**
	 * Convenience method returning the URI corresponding to the value of the EValidator.URI_ATTRIBUTE of a marker
	 *
	 * @param marker
	 *            The marker from which the URI corresponding to the value its EValidator.URI_ATTRIBUTE has to be constructed
	 * @return The URI corresponding to the value of the EValidator.URI_ATTRIBUTE of the given marker
	 */
	public static URI getURI(IMarker marker) {
		String uriOfMarkerStr = marker.getAttribute(EValidator.URI_ATTRIBUTE, null);
		if (uriOfMarkerStr != null) {
			return URI.createURI(uriOfMarkerStr);
		}
		return null;
	}

}
