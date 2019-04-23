/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.animation.engine.rendering;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.sashwindows.di.service.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.papyrus.moka.animation.presentation.control.AnimationControlView;
import org.eclipse.papyrus.moka.animation.presentation.data.AnimatedDiagramTree;
import org.eclipse.papyrus.moka.animation.presentation.data.AnimatingInstanceNode;
import org.eclipse.papyrus.moka.animation.presentation.data.AnimationTreeNodeFactory;
import org.eclipse.papyrus.moka.animation.presentation.data.DiagramAnimationNode;
import org.eclipse.papyrus.moka.animation.presentation.data.IAnimationTreeNode;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.utils.helper.EditorUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.PlatformUI;

public class DiagramHandler {

	// The set of diagrams identified for a given model
	protected HashSet<Diagram> modelDiagrams;

	// The cache linking a model element to the of diagram in which it appears
	protected HashMap<EObject, HashSet<Diagram>> modelDiagramMapping;

	protected AnimatedDiagramTree animatedDiagrams;

	public DiagramHandler() {
		this.modelDiagrams = new HashSet<Diagram>();
		this.modelDiagramMapping = new HashMap<EObject, HashSet<Diagram>>();
	}

	public DiagramHandler(Model model) {
		this();
		this.init(model);
	}

	public void init(EObject modelElement) {
		// Initialize the animated diagrams manager. The initialize process consist in:
		// 1 - Identifying diagrams located in a model
		// 2 - Build a cache linking a model element to a list of diagrams in which it appears
		if (modelElement instanceof Element) {
			// Find all diagrams available in this model
			Element owner = ((Element)modelElement).getOwner();
			while(owner.getOwner() != null) {
				owner = owner.getOwner();
			}
			Job diagramsLoading = new InitiliazeDiagramManagerJob(owner.getModel());
			diagramsLoading.schedule();
			try {
				diagramsLoading.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.hookView();
		}
	}

	private void hookView() {
		// Populate initial data model to be displayed.
		this.animatedDiagrams = new AnimatedDiagramTree();
		IAnimationTreeNode root = this.animatedDiagrams.getRoot();
		for (Diagram diagram : this.modelDiagrams) {
			root.addChild(AnimationTreeNodeFactory.getInstance().createDiagramAnimationNode(diagram));
		}
		// Locate view to populate
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				IViewPart animationControlView = DiagramHandler.this.getView(AnimationControlView.ID, false);
				if (animationControlView != null && animationControlView instanceof AnimationControlView) {
					((AnimationControlView) animationControlView).setInitialInput(DiagramHandler.this.animatedDiagrams);
				}
			}
		});
	}

	private IViewPart getView(final String ID, boolean restore) {
		// Find out a view using the specified ID
		IViewPart view = null;
		IViewReference viewReferences[] = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getViewReferences();
		int i = 0;
		while (view == null && i < viewReferences.length) {
			if (viewReferences[i].getId().equals(ID)) {
				view = viewReferences[i].getView(restore);
			}
			i++;
		}
		return view;
	}

	private List<Diagram> getAssociatedDiagrams(EObject modelElement, Resource notationResource) {
		// Find the set of diagrams in which the given model element appears
		List<Diagram> associatedDiagrams = new ArrayList<Diagram>();
		if (notationResource != null && modelElement != null) {
			return DiagramUtils.getAssociatedDiagramsFromNotationResource(modelElement, notationResource);
		}
		return associatedDiagrams;
	}

	private void searchDiagrams(Model model, IProgressMonitor monitor) {
		// Identify all diagrams that are available in a model. The unique place from which
		// this operation is called is the job in charge of executing the search.
		Resource resource = model.eResource();
		ResourceSet resourceSet = resource.getResourceSet();
		// Load the resource corresponding to the notation
		final String resourceNotationURI = model.eResource().getURI().toString().replaceAll("\\.uml$", ".notation");
		Resource notationResource = resourceSet.getResource(URI.createURI(resourceNotationURI), true);
		// Discover all diagrams
		monitor.subTask("Find all diagrams");
		Iterator<EObject> modelContentIterator = model.eAllContents();
		while (modelContentIterator.hasNext()) {
			EObject currentModelElement = modelContentIterator.next();
			// Find the associated diagrams
			List<Diagram> diagrams = this.getAssociatedDiagrams(currentModelElement, notationResource);
			// Build the cache to relate the model element the set of diagrams where it is shown
			if (!diagrams.isEmpty()) {
				// Add newly found diagrams to the set
				this.modelDiagrams.addAll(diagrams);
			}
		}
		monitor.worked(1);
		// Build the map to enable the possibility
		monitor.subTask("Build mapping with model elements");
		Iterator<Diagram> diagramIterator = this.modelDiagrams.iterator();
		while (diagramIterator.hasNext()) {
			Diagram currentDiagram = diagramIterator.next();
			Iterator<EObject> diagramViews = currentDiagram.eAllContents();
			while (diagramViews.hasNext()) {
				EObject potentialView = diagramViews.next();
				if (potentialView instanceof View) {
					EObject modelElement = ((View) (potentialView)).getElement();
					if (this.modelDiagramMapping.containsKey(modelElement)) {
						HashSet<Diagram> diagrams = this.modelDiagramMapping.get(modelElement);
						if (!diagrams.contains(currentDiagram)) {
							diagrams.add(currentDiagram);
						}
					} else {
						HashSet<Diagram> diagramSet = new HashSet<Diagram>();
						diagramSet.add(currentDiagram);
						this.modelDiagramMapping.put(modelElement, diagramSet);
					}
				}
			}
		}
		monitor.worked(1);
	}

	/**
	 * The diagrams search is executed in a separate job.
	 */
	class InitiliazeDiagramManagerJob extends Job {

		private Model model;

		public InitiliazeDiagramManagerJob(Model model) {
			super("Diagrams lookup");
			this.model = model;
			this.setUser(true);
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			monitor.beginTask("Prepare execution", 2);
			DiagramHandler.this.searchDiagrams(this.model, monitor);
			monitor.done();
			return Status.OK_STATUS;
		}

	}

	public boolean hasOpenedDiagram(EObject modelElement) {
		// Determine if a model element has at least one of its diagrams opened (i.e., visible to the user)
		boolean opened = false;
		Set<Diagram> diagramSet = this.modelDiagramMapping.get(modelElement);
		if (diagramSet != null) {
			Iterator<Diagram> diagramIterator = diagramSet.iterator();
			while (!opened && diagramIterator.hasNext()) {
				Diagram diagram = diagramIterator.next();
				IEditorPart editorPart = EditorUtils.getEditorPart(diagram);
				ServicesRegistry servicesRegistry = (ServicesRegistry) editorPart.getAdapter(ServicesRegistry.class);
				IPageManager pageManager = null;
				try {
					pageManager = ServiceUtils.getInstance().getIPageManager(servicesRegistry);
				} catch (ServiceException e) {
					e.printStackTrace();
				}
				if (pageManager != null) {
					opened = pageManager.isOpen(diagram);
				}
			}
		}
		return opened;
	}

	public void openDiagrams(EObject modelElement) {
		// Open every diagrams on which the specify on which this model element appear
		HashSet<Diagram> diagrams = this.modelDiagramMapping.get(modelElement);
		if (!diagrams.isEmpty()) {
			for (Diagram diagram : diagrams) {
				IEditorPart editorPart = EditorUtils.getEditorPart(diagram);
				ServicesRegistry servicesRegistry = (ServicesRegistry) editorPart.getAdapter(ServicesRegistry.class);
				IPageManager pageManager = null;
				try {
					pageManager = ServiceUtils.getInstance().getIPageManager(servicesRegistry);
				} catch (ServiceException e) {
					e.printStackTrace();
				}
				if (pageManager != null) {
					pageManager.openPage(diagram);
					pageManager.selectPage(diagram);
				}
			}
		}
	}

	public boolean isRenderable(EObject modelElement) {
		// A model element can be rendered as soon as it exists a diagram in which it
		// appear in the model
		Set<Diagram> diagramSet = this.modelDiagramMapping.get(modelElement);
		return diagramSet != null && !diagramSet.isEmpty();
	}

	public boolean isRegistered(IObject_ instance) {
		// Verifies if a particular instance is allowed to trigger animation
		// An instance is allowed to trigger animation if it is part of the "AnimatedDiagramTree"
		// Note that users may have decided to manually disallow a particular instance
		// to trigger animation. In this case even if previously presented preconditions
		// are full filled this operation returns false
		boolean isRenderable = false;
		if (instance != null && this.animatedDiagrams != null) {
			Iterator<IAnimationTreeNode> nodesIterator = this.animatedDiagrams.getRoot().getChildren().iterator();
			while (!isRenderable && nodesIterator.hasNext()) {
				DiagramAnimationNode node = (DiagramAnimationNode) nodesIterator.next();
				if (node.hasAnimator(instance)) {
					isRenderable = true;
				}
			}
		}
		return isRenderable;
	}

	public Set<Diagram> getAnimatedDiagrams(IObject_ instance) {
		// Provides the list of diagrams on which the given instance is allowed
		// to trigger animation actions.
		Set<Diagram> diagrams = new HashSet<Diagram>();
		if (instance != null && this.animatedDiagrams != null) {
			Iterator<IAnimationTreeNode> nodesIterator = this.animatedDiagrams.getRoot().getChildren().iterator();
			while (nodesIterator.hasNext()) {
				DiagramAnimationNode node = (DiagramAnimationNode) nodesIterator.next();
				if (node.isAnimatorAllowed(instance)) {
					diagrams.add(node.getAnimatedDiagram());
				}
			}
		}
		return diagrams;
	}

	public Set<Diagram> findDiagramsInvolved(IObject_ instance) {
		// Find any diagram on which this particular instance may trigger
		// animations. The research is based on the analysis of the classifier
		// behavior (if any) and operation implementations
		HashSet<Diagram> relatedDiagrams = new HashSet<Diagram>();
		if (instance != null) {
			Iterator<Classifier> types = instance.getTypes().iterator();
			while (types.hasNext()) {
				Class type = (Class) types.next();
				if (type.isActive() || type instanceof Behavior) {
					Behavior behavior = null;
					if (type instanceof Behavior) {
						behavior = (Behavior) type;
					} else {
						behavior = type.getClassifierBehavior();
					}
					if (behavior != null) {
						Iterator<Element> elementIterator = behavior.getOwnedElements().iterator();
						while (elementIterator.hasNext()) {
							Element behaviorElement = elementIterator.next();
							if (this.isRenderable(behaviorElement)) {
								relatedDiagrams.addAll(this.modelDiagramMapping.get(behaviorElement));
							}
						}
					}
				}
				Iterator<Operation> operationsIterator = type.getOperations().iterator();
				while (operationsIterator.hasNext()) {
					Operation currentOperation = operationsIterator.next();
					Iterator<Behavior> implementationIterator = currentOperation.getMethods().iterator();
					while (implementationIterator.hasNext()) {
						Behavior currentImplementation = implementationIterator.next();
						Iterator<Element> elementIterator = currentImplementation.getOwnedElements().iterator();
						while (elementIterator.hasNext()) {
							Element behaviorElement = elementIterator.next();
							if (this.isRenderable(behaviorElement)) {
								relatedDiagrams.addAll(this.modelDiagramMapping.get(behaviorElement));
							}
						}
					}
				}
			}
		}
		return relatedDiagrams;
	}

	public void addRenderable(IObject_ instance, Diagram diagram) {
		// Add the relation between the diagram and the instance. This relation
		// is formalized through the data model (see AnimatedDiagramExecutionTree).
		if (instance != null && diagram != null) {
			Iterator<IAnimationTreeNode> nodesIterator = this.animatedDiagrams.getRoot().getChildren().iterator();
			while (nodesIterator.hasNext()) {
				IAnimationTreeNode node = nodesIterator.next();
				if (((DiagramAnimationNode) node).getAnimatedDiagram() == diagram) {
					node.addChild(AnimationTreeNodeFactory.getInstance().createAnimatingInstanceNode(instance));
				}
			}
		}
	}

	public void deleteRenderable(IObject_ instance) {
		// Removes the relation existing between this instance and any diagram. This relationship
		// is formalized through the data model.
		if (instance != null && this.animatedDiagrams != null) {
			Iterator<IAnimationTreeNode> nodesIterator = this.animatedDiagrams.getRoot().getChildren().iterator();
			while (nodesIterator.hasNext()) {
				IAnimationTreeNode node = nodesIterator.next();
				Iterator<IAnimationTreeNode> childrenIterator = node.getChildren().iterator();
				List<IAnimationTreeNode> unregisteredAnimators = new ArrayList<IAnimationTreeNode>();
				while (childrenIterator.hasNext()) {
					IAnimationTreeNode animator = childrenIterator.next();
					if (((AnimatingInstanceNode) animator).instance == instance) {
						unregisteredAnimators.add(animator);
					}
				}
				for (IAnimationTreeNode animator : unregisteredAnimators) {
					node.removeChild(animator);
				}
			}
		}
	}

	public synchronized void clean() {
		// Release data and dispose view that is linked to these data
		this.modelDiagrams.clear();
		this.modelDiagramMapping.clear();
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				IViewPart animationControlView = DiagramHandler.this.getView(AnimationControlView.ID, false);
				if (animationControlView != null && animationControlView instanceof AnimationControlView) {
					((AnimationControlView) animationControlView).dispose();
				}
			}
		});
		this.animatedDiagrams = null;
	}
}
