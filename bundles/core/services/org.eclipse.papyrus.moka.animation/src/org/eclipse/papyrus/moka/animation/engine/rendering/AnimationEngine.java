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
package org.eclipse.papyrus.moka.animation.engine.rendering;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;
import org.eclipse.papyrus.infra.services.markerlistener.PapyrusMarkerAdapter;
import org.eclipse.papyrus.moka.utils.constants.MokaConstants;
import org.eclipse.papyrus.moka.animation.utils.AnimationUtils;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;

/**
 * Some facilities to manage animation in diagrams.
 */
public class AnimationEngine implements IRenderingEngine {

	// The diagram manager handles every action done by the animation regarding diagrams
	protected DiagramHandler diagramManager;

	// Maintain a map of model elements having makers
	// The only purpose of this map is too avoid a to global search in diagrams at some points of the execution
	protected Map<EObject, List<IPapyrusMarker>> modelElementMarkers = new HashMap<EObject, List<IPapyrusMarker>>();

	protected boolean isReady;

	public AnimationEngine() {
		// Constructor
		this.isReady = false;
		this.diagramManager = new DiagramHandler();
		this.modelElementMarkers = new HashMap<EObject, List<IPapyrusMarker>>();
	}

	private boolean hasMarker(EObject modelElement, AnimationKind kind) {
		// Find out if a marker of the given kind is applied on the model element
		if (modelElement == null) {
			return false;
		}
		List<IPapyrusMarker> markers = this.modelElementMarkers.get(modelElement);
		if (markers == null || markers.isEmpty()) {
			return false;
		}
		boolean found = false;
		int i = 0;
		while (!found && i < markers.size()) {
			IPapyrusMarker marker = markers.get(i);
			String type = "";
			try {
				type = marker.getType();
			} catch (CoreException e) {
				e.printStackTrace();
			}
			if (kind == AnimationKind.ANIMATED) {
				found = type.equals(AnimationUtils.ANIMATED_MARKER_ID);
			} else if (kind == AnimationKind.SUSPENDED) {
				found = type.equals(AnimationUtils.SUSPENDED_MARKER_ID);
			} else if (kind == AnimationKind.VISITED) {
				found = type.equals(AnimationUtils.VISITED_MARKER_ID);
			}
			i++;
		}
		return found;
	}

	@SuppressWarnings("unchecked")
	private IPapyrusMarker createMarker(final EObject modelElement, final String markerID, @SuppressWarnings("rawtypes") Map attributes) {
		// Create a marker of the given type (c.f. markerID) and set the attributes
		// with the provided map
		IPapyrusMarker marker = null;
		// Assert that the model element is usable
		if (modelElement == null || modelElement.eResource() == null) {
			return null;
		}
		final String uri = EcoreUtil.getURI(modelElement).toString();
		if (uri == null || uri.isEmpty()) {
			return null;
		}
		// Assert we are able to access the resource on which the marker will be placed
		IResource resource = this.getWorkspaceResource(modelElement);
		if (resource != null && resource.exists()) {
			IMarker newMarker = null;
			try {
				newMarker = resource.createMarker(markerID);
				newMarker.setAttributes(attributes);
			} catch (CoreException e) {
				e.printStackTrace();
			}
			if (newMarker != null) {
				// Place the Papyrus marker
				marker = PapyrusMarkerAdapter.wrap(modelElement.eResource(), newMarker, attributes);
			}
		}
		return marker;
	}

	private IPapyrusMarker deleteMarker(final EObject modelElement, AnimationKind kind) {
		// Find out a marker of the given type placed on a model element. This marker is
		// then deleted. The deleted marker is returned by the operation.
		List<IPapyrusMarker> markers = this.modelElementMarkers.get(modelElement);
		Iterator<IPapyrusMarker> markersIterator = markers.iterator();
		IPapyrusMarker deletedMarker = null;
		while (deletedMarker == null && markersIterator.hasNext()) {
			IPapyrusMarker currentMarker = markersIterator.next();
			String markerType = "";
			try {
				markerType = currentMarker.getType();
			} catch (CoreException e) {
				e.printStackTrace();
			}
			if (kind == AnimationKind.ANIMATED) {
				deletedMarker = markerType.equals(AnimationUtils.ANIMATED_MARKER_ID) ? currentMarker : null;
			} else if (kind == AnimationKind.SUSPENDED) {
				deletedMarker = markerType.equals(AnimationUtils.SUSPENDED_MARKER_ID) ? currentMarker : null;
			} else if (kind == AnimationKind.VISITED) {
				deletedMarker = markerType.equals(AnimationUtils.VISITED_MARKER_ID) ? currentMarker : null;
			}
		}
		if (deletedMarker != null) {
			try {
				deletedMarker.delete();
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return deletedMarker;
	}

	private IResource getWorkspaceResource(final EObject modelElement) {
		IResource resource = null;
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		if (workspace != null) {
			resource = workspace.getRoot().getFile(new Path(modelElement.eResource().getURI().toPlatformString(true)));
		}
		return resource;
	}

	public void init(EObject modelElement) {
		// Triggers diagrams search when called
		this.diagramManager.init(modelElement);
	}

	protected void preRendering(EObject modelElement) {
		// This operation specifies pre-actions that need to be accomplished
		// before proceeding to the animation.
		if (MokaConstants.MOKA_OPEN_DIAGRAM_IN_AUTOMATIC_ANIMATION) {
			if (!this.diagramManager.hasOpenedDiagram(modelElement)) {
				this.diagramManager.openDiagrams(modelElement);
			}
		}
	}

	@Override
	public synchronized void startRendering(EObject modelElement, IObject_ animator, AnimationKind animationKind) {
		// Apply the specified style to the model element
		if (!this.isReady) {
			this.diagramManager.init(modelElement);
			this.isReady = true;
		}
		if (modelElement != null && this.isRenderable(modelElement, animator)) {
			this.preRendering(modelElement);
			IPapyrusMarker requestedMarker = null;
			if (!this.hasMarker(modelElement, animationKind)) {
				Map<String, Object> attributes = new HashMap<String, Object>();
				attributes.put(EValidator.URI_ATTRIBUTE, EcoreUtil.getURI(modelElement).toString());
				attributes.put("CONSTRAINTS", this.diagramManager.getAnimatedDiagrams(animator));
				// Defined which type of animation is expected
				if (animationKind.equals(AnimationKind.ANIMATED)) {
					requestedMarker = this.createMarker(modelElement, AnimationUtils.ANIMATED_MARKER_ID, attributes);
				} else if (animationKind.equals(AnimationKind.SUSPENDED)) {
					requestedMarker = this.createMarker(modelElement, AnimationUtils.SUSPENDED_MARKER_ID, attributes);
				} else if (animationKind.equals(AnimationKind.VISITED)) {
					requestedMarker = this.createMarker(modelElement, AnimationUtils.VISITED_MARKER_ID, attributes);
				} else {
					System.err.println("[startRendering] - animation kind not recognized");
				}
				// Update map of applied markers
				List<IPapyrusMarker> markerList = this.modelElementMarkers.get(modelElement);
				if (markerList == null) {
					markerList = new ArrayList<IPapyrusMarker>();
					this.modelElementMarkers.put(modelElement, markerList);
				}
				if (requestedMarker != null) {
					markerList.add(requestedMarker);
				}
			}
		}
	}

	@Override
	public synchronized void stopRendering(EObject modelElement, IObject_ animator, AnimationKind kind) {
		// Remove the specified style from the model element
		if (!this.isReady) {
			this.diagramManager.init(modelElement);
			this.isReady = true;
		}
		if (modelElement != null && this.isRenderable(modelElement, animator)) {
			if (this.hasMarker(modelElement, kind)) {
				IPapyrusMarker marker = this.deleteMarker(modelElement, kind);
				if (marker != null) {
					this.modelElementMarkers.get(modelElement).remove(marker);
				}
			}
		}
	}

	public boolean isRenderable(EObject modelElement, IObject_ animator) {
		return MokaConstants.MOKA_AUTOMATIC_ANIMATION && this.diagramManager.isRenderable(modelElement);
	}

	public void deleteAllMarkers() {
		// Make sure any marker placed by the framework over a model element is deleted when this operation is called
		// The operation is thread safe and lock a model element before starting to remove the markers
		for (EObject modelElement : this.modelElementMarkers.keySet()) {
			for (IPapyrusMarker marker : this.modelElementMarkers.get(modelElement)) {
				if (marker.exists()) {
					try {
						marker.delete();
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}
			this.modelElementMarkers.get(modelElement).clear();
		}
		this.modelElementMarkers.clear();
	}

	public synchronized void clean() {
		// The clean operation is in charge of:
		// 1 - Releasing all model elements from their makers (if placed by the animation framework)
		// 2 - Releasing all diagram referenced by the animation diagram manager
		this.isReady = false;
		this.deleteAllMarkers();
		this.diagramManager.clean();
	}

	public DiagramHandler getDiagramHandler() {
		// Convenience operation to get access to the diagram manager
		return this.diagramManager;
	}

	@Override
	public boolean isRenderingRuleApplied(EObject modelElement, AnimationKind kind) {
		return this.hasMarker(modelElement, kind);
	}

	public void removeRenderingRules(EObject modelElement) {
		// Markers applied to this model element and hence contribute to modify
		// its style are removed. This implies the model element will retrieve its
		// user defined style.
		if (this.modelElementMarkers.get(modelElement) != null) {
			for (IPapyrusMarker marker : this.modelElementMarkers.get(modelElement)) {
				if (marker.exists()) {
					try {
						marker.delete();
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}
			this.modelElementMarkers.get(modelElement).clear();
		}
	}

	@Override
	public void renderAs(EObject modelElement, IObject_ object, AnimationKind targetStyle) {
		// Apply the style  to model element if the context is allowed to perform animation.
		this.removeRenderingRules(modelElement);
		this.startRendering(modelElement, object, targetStyle);
	}

	@Override
	public void renderAs(EObject modelElement, IObject_ object, AnimationKind sourceStyle, AnimationKind targetStyle,
			int duration) {
		// Apply the source style to model element during the specified duration. As soon as this period of time as elapsed then
		// the target style is applied to the model element.
		this.removeRenderingRules(modelElement);
		this.startRendering(modelElement, object, sourceStyle);
		if(duration >= 25){	
			try {
				Thread.sleep(duration);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.stopRendering(modelElement, object, sourceStyle);
		this.startRendering(modelElement, object, targetStyle);
		
	}
}
