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

import org.eclipse.debug.core.ILaunch;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.animation.engine.animators.Animator;
import org.eclipse.papyrus.moka.animation.engine.animators.AnimatorExtensionEvaluator;
import org.eclipse.papyrus.moka.animation.engine.rendering.AnimationEngine;
import org.eclipse.papyrus.moka.animation.engine.rendering.IAnimation;
import org.eclipse.papyrus.moka.fuml.loci.ISemanticVisitor;
import org.eclipse.papyrus.moka.kernel.engine.IExecutionEngine;
import org.eclipse.papyrus.moka.kernel.service.ExecutionEngineService;

public abstract class AnimationService extends ExecutionEngineService<IExecutionEngine> implements IAnimation {

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

}
