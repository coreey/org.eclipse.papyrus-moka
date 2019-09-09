/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.moka.engine.uml.animation.service;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.moka.animation.engine.AnimationService;
import org.eclipse.papyrus.moka.animation.engine.rendering.AnimationKind;
import org.eclipse.papyrus.moka.animation.engine.rendering.DiagramHandler;
import org.eclipse.papyrus.moka.engine.uml.animation.animators.UMLAnimator;
import org.eclipse.papyrus.moka.engine.uml.debug.listeners.UMLRTCStepListener;
import org.eclipse.papyrus.moka.engine.uml.debug.listeners.UMLSemanticVisitorExecutionListener;
import org.eclipse.papyrus.moka.engine.uml.debug.listeners.UMLValueLifecyleListener;
import org.eclipse.papyrus.moka.fuml.loci.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IValue;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IObject_;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IReference;
import org.eclipse.papyrus.moka.kernel.engine.IExecutionEngine;
import org.eclipse.papyrus.moka.utils.constants.MokaConstants;

public class UMLAnimationService extends AnimationService implements UMLSemanticVisitorExecutionListener, UMLRTCStepListener, UMLValueLifecyleListener{

	public UMLAnimationService() {
		super();
	}
	
	@Override
	public void nodeVisited(ISemanticVisitor nodeVisitor) {
		// Find a registered animator to perform animation when a node gets executed by the execution engine.
		// If one is found (i.e., it accepts to perform animation on the node interpreted by the visitor)
		// then the realization of the animation is delegated to this latter. If no animator could be
		// found then no animation is performed.
		if (MokaConstants.MOKA_AUTOMATIC_ANIMATION) {
			UMLAnimator animator = (UMLAnimator) this.getAnimator(nodeVisitor);
			if (animator != null) {
				animator.nodeVisited(nodeVisitor);
			}
		}

	}

	@Override
	public void nodeLeft(ISemanticVisitor nodeVisitor) {
		// Find a registered animator to perform animation when a node gets exited by the execution engine.
		// If one is found, then the realization of the animation is delegated to this latter. If no
		// animator could be found then no animation is performed
		if (MokaConstants.MOKA_AUTOMATIC_ANIMATION) {
			UMLAnimator animator = (UMLAnimator) this.getAnimator(nodeVisitor);
			if (animator != null) {
				animator.nodeLeft(nodeVisitor);
			}
		}
	}

	@Override
	public void valueCreated(IValue value) {
		if (MokaConstants.MOKA_AUTOMATIC_ANIMATION) {
			if (value instanceof IObject_) {
				DiagramHandler diagramHandler = this.engine.getDiagramHandler();
				if (!diagramHandler.isRegistered((IObject_) value)) {
					Set<Diagram> relatedDiagrams = diagramHandler.findDiagramsInvolved((IObject_) value);
					for (Diagram diagram : relatedDiagrams) {
						diagramHandler.addRenderable((IObject_) value, diagram);
					}
				}
			}
			UMLAnimator animator = (UMLAnimator) this.getAnimator(value);
			if (animator != null) {
				animator.valueCreated(value);
			}
		}
	}

	@Override
	public void valueDestroyed(IValue value) {
		if (MokaConstants.MOKA_AUTOMATIC_ANIMATION) {
			if (value instanceof IObject_) {
				this.engine.getDiagramHandler().deleteRenderable((IObject_) value);
			}
			UMLAnimator animator = (UMLAnimator) this.getAnimator(value);
			if (animator != null) {
				animator.valueDestroyed(value);
			}
		}
	}

	@Override
	public void rtcStepBegin(IReference context) {
		if (MokaConstants.MOKA_AUTOMATIC_ANIMATION) {
			UMLAnimator animator = (UMLAnimator) this.getAnimator(context);
			if (animator != null) {
				animator.rtcStepBegin(context);
			}
		}
	}

	@Override
	public void rtcStepEnd(IReference context) {
		if (MokaConstants.MOKA_AUTOMATIC_ANIMATION) {
			UMLAnimator animator = (UMLAnimator) this.getAnimator(context);
			if (animator != null) {
				animator.rtcStepEnd(context);
			}
		}
	}
	
	public void dispose() {
		this.engine.clean();
	}

	@Override
	public void renderAs(EObject modelElement, IObject_ animator, AnimationKind targetStyle) {
		this.engine.removeRenderingRules(modelElement);
		this.engine.startRendering(modelElement, animator, targetStyle);
	}

	@Override
	public void renderAs(EObject modelElement, IObject_ animator, AnimationKind sourceStyle, AnimationKind targetStyle, int duration) {
		this.engine.removeRenderingRules(modelElement);
		this.engine.startRendering(modelElement, animator, sourceStyle);
		if (duration >= 25) {
			try {
				Thread.sleep(duration);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.engine.stopRendering(modelElement, animator, sourceStyle);
		this.engine.startRendering(modelElement, animator, targetStyle);
	}

	@Override
	public void dispose(IExecutionEngine engine) {
		this.engine.deleteAllMarkers();
	}
	
}
