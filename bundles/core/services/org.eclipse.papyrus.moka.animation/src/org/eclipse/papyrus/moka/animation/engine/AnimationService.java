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
package org.eclipse.papyrus.moka.animation.engine;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.moka.animation.engine.animators.Animator;
import org.eclipse.papyrus.moka.animation.engine.animators.AnimatorExtensionEvaluator;
import org.eclipse.papyrus.moka.animation.engine.rendering.AnimationEngine;
import org.eclipse.papyrus.moka.animation.engine.rendering.AnimationKind;
import org.eclipse.papyrus.moka.animation.engine.rendering.DiagramHandler;
import org.eclipse.papyrus.moka.animation.engine.rendering.IAnimation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.service.AbstractMokaService;
import org.eclipse.papyrus.moka.service.IMokaExecutionListener;
import org.eclipse.papyrus.moka.service.IMokaStepListener;
import org.eclipse.papyrus.moka.utils.constants.MokaConstants;

public class AnimationService extends AbstractMokaService implements IAnimation, IMokaExecutionListener, IMokaStepListener {

	// The handler responsible for markers application
	// TODO: the animation engine shall be contributed through an extension point.
	protected AnimationEngine engine;

	// List of child animators that can be used to perform animation
	// when a node is visited of left by the execution engine.
	protected List<Animator> animators;

	public AnimationService() {
		// Create the engine and instantiate animators.
		this.engine = new AnimationEngine();
		this.animators = AnimatorExtensionEvaluator.evaluateAnimators(this.engine);
	}

	public void init(ILaunch launcher, EObject modelElement) {
		// Initialize elements of the animation service
		this.engine.init(modelElement);
	}

	public Animator getAnimator(ISemanticVisitor nodeVisitor) {
		// Find the animator capable of performing animation on the model element
		// referenced by the visitor. In situation of conflict (i.e., multiple animators
		// accept to provide an animation logic for the same set of model elements) then
		// the priority associated to animators is used to determine which animator must
		// perform the animation.
		Animator animator = null;
		Iterator<Animator> animatorsIterator = this.animators.iterator();
		while (animatorsIterator.hasNext()) {
			Animator current = animatorsIterator.next();
			if (current.accept(nodeVisitor)) {
				if (animator != null) {
					animator = current.getPriority() > animator.getPriority() ? current : animator;
				} else {
					animator = current;
				}
			}
		}
		return animator;
	}

	@Override
	public void nodeVisited(ISemanticVisitor nodeVisitor) {
		// Find a registered animator to perform animation when a node gets executed by the execution engine.
		// If one is found (i.e., it accepts to perform animation on the node interpreted by the visitor)
		// then the realization of the animation is delegated to this latter. If no animator could be
		// found then no animation is performed.
		if (MokaConstants.MOKA_AUTOMATIC_ANIMATION) {
			Animator animator = this.getAnimator(nodeVisitor);
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
			Animator animator = this.getAnimator(nodeVisitor);
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
			Animator animator = this.getAnimator(value);
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
			Animator animator = this.getAnimator(value);
			if (animator != null) {
				animator.valueDestroyed(value);
			}
		}
	}

	@Override
	public void stepStart(IReference context) {
		if (MokaConstants.MOKA_AUTOMATIC_ANIMATION) {
			Animator animator = this.getAnimator(context);
			if (animator != null) {
				animator.stepStart(context);
			}
		}
	}

	@Override
	public void stepEnd(IReference context) {
		if (MokaConstants.MOKA_AUTOMATIC_ANIMATION) {
			Animator animator = this.getAnimator(context);
			if (animator != null) {
				animator.stepEnd(context);
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

}
