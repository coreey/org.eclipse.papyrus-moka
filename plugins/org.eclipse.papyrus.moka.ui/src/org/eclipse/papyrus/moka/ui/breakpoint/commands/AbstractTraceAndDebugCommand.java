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
 *  Ansgar Radermarcher (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.ui.breakpoint.commands;

import java.util.Collections;

import javax.sound.sampled.Port;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.core.markers.MarkerConstants;
import org.eclipse.papyrus.moka.tracepoint.service.Activator;
import org.eclipse.papyrus.moka.tracepoint.service.ITraceMechanism;
import org.eclipse.papyrus.moka.tracepoint.service.TPPreferenceConstants;
import org.eclipse.papyrus.moka.tracepoint.service.TraceMechanism;
import org.eclipse.papyrus.moka.tracepoint.service.TracepointConstants;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.State;

/**
 * Action used for pasting either a model element or a shape (i.e. the model element represented
 * by the shape). Delegates to PasteShapeOrElementCommand
 *
 * @author Ansgar Radermacher (CEA LIST)
 */
abstract public class AbstractTraceAndDebugCommand extends AbstractTransactionalCommand {

	protected TransactionalEditingDomain domain;

	protected EObject selectedElement;

	/**
	 * Creates a new ImportLibraryFromRepositoryCommand
	 *
	 * @param label
	 *            the label of the command
	 * @param domain
	 *            editing domain that manages the changed objects
	 * @param selectedElement
	 *            a selected element
	 */
	public AbstractTraceAndDebugCommand(String label, TransactionalEditingDomain domain, EObject selectedElement) {
		super(domain, label, Collections.EMPTY_LIST);
		this.domain = domain;
		this.selectedElement = selectedElement;
	}

	protected void updateResourceAndURI() {
		resource = selectedElement.eResource();
		uri = resource.getURI() + "#" + resource.getURIFragment(selectedElement); //$NON-NLS-1$
		iresource = WorkspaceSynchronizer.getFile(selectedElement.eResource());
	}

	protected IMarker findMarker(String type) {

		if (iresource != null) {
			try {
				for (IMarker marker : iresource.findMarkers(type, false, IResource.DEPTH_INFINITE)) {
					String markerURI = marker.getAttribute(MarkerConstants.uri, ""); //$NON-NLS-1$
					if ((markerURI != null) && markerURI.equals(uri)) {
						return marker;
					}
				}
			} catch (CoreException ce) {
			}
		}
		return null;
	}

	protected IMarker toggleMarker() {
		try {
			if (iresource != null) {
				IMarker marker = findMarker(TracepointConstants.tracepointMarker);
				if (marker == null) { // marker does not exist => create
					marker = iresource.createMarker(TracepointConstants.tracepointMarker);
					marker.setAttribute(MarkerConstants.uri, uri);
					marker.setAttribute(TracepointConstants.isActive, true);
					return marker;
				}
				else {
					// marker exists => delete
					marker.delete();
				}
			}
		} catch (CoreException ce) {
		}
		return null;
	}

	protected void toggleMarkerActivation() {
		try {
			if (iresource != null) {
				IMarker marker = findMarker(TracepointConstants.tracepointMarker);
				if (marker == null) { // marker does not exist => create
					marker = iresource.createMarker(TracepointConstants.tracepointMarker);
					marker.setAttribute(MarkerConstants.uri, uri);
					marker.setAttribute(TracepointConstants.isActive, true);

					// apply trace mechanism according to default in preferences
					IPreferenceStore store = Activator.getDefault().getPreferenceStore();
					String id = null;
					if (selectedElement instanceof Operation) {
						id = store.getDefaultString(TPPreferenceConstants.P_TRACE_IMPLEMENTATION_OP);
					}
					else if (selectedElement instanceof Port) {
						id = store.getDefaultString(TPPreferenceConstants.P_TRACE_IMPLEMENTATION_PORT);
					}
					else if (selectedElement instanceof State) {
						id = store.getDefaultString(TPPreferenceConstants.P_TRACE_IMPLEMENTATION_SM);
					}
					if (id != null) {
						for (ITraceMechanism mechanism : TraceMechanism.getTraceMechanisms()) {
							for (String providedID : mechanism.getTraceMechanismIDs(selectedElement)) {
								if (id.equals(providedID)) {
									mechanism.applyTraceMechanism(selectedElement, id, 0);
								}
							}
						}
					}
				}
				else {
					// marker exists => change activation status
					boolean isSet = marker.getAttribute(TracepointConstants.isActive, false);
					marker.setAttribute(TracepointConstants.isActive, !isSet);
				}
			}
		} catch (CoreException ce) {
			throw new RuntimeException(ce);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canExecute() {
		return (selectedElement != null);
	}

	protected Resource resource;

	protected IResource iresource;

	protected String uri;
}
