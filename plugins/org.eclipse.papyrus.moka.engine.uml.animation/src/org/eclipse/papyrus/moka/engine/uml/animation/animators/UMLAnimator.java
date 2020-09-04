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
 *   CEA LIST - Bug 551906
 *   
 *****************************************************************************/
package org.eclipse.papyrus.moka.engine.uml.animation.animators;

import org.eclipse.papyrus.moka.animation.engine.animators.Animator;
import org.eclipse.papyrus.moka.animation.engine.animators.actions.DerivedAnimationAction;
import org.eclipse.papyrus.moka.fuml.loci.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.profiling.listeners.IRTCStepListener;
import org.eclipse.papyrus.moka.fuml.profiling.listeners.ISemanticVisitorExecutionListener;
import org.eclipse.papyrus.moka.fuml.profiling.listeners.IValueLifecyleListener;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IValue;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IReference;
import org.eclipse.papyrus.moka.kernel.assistant.Suspension;

public abstract class UMLAnimator extends Animator implements ISemanticVisitorExecutionListener, IRTCStepListener, IValueLifecyleListener{

	@Override
	public final void nodeVisited(ISemanticVisitor nodeVisitor) {
		// Apply PRE and POST actions attached to the animator when
		// an acceptable node is visited.
		for(DerivedAnimationAction derivedAction : this.derivedAnimationAction) {
			if(derivedAction.accept(nodeVisitor)) {
				derivedAction.preVisitAction(this.engine, nodeVisitor);
			}
		}
		this.nodeVisited_(nodeVisitor);
		for(DerivedAnimationAction derivedAction : this.derivedAnimationAction) {
			if(derivedAction.accept(nodeVisitor)) {
				derivedAction.postVisitAction(this.engine, nodeVisitor);
			}
		}
	}
	
	public abstract void nodeVisited_(ISemanticVisitor nodeVisitor);
	
	@Override
	public final void nodeLeft(ISemanticVisitor nodeVisitor) {
		// Apply PRE and POST actions attached to the animator when
		// an acceptable node is left.
		for(DerivedAnimationAction derivedAction : this.derivedAnimationAction) {
			if(derivedAction.accept(nodeVisitor)) {
				derivedAction.preLeftAction(this.engine, nodeVisitor);
			}
		}
		this.nodeLeft_(nodeVisitor);
		for(DerivedAnimationAction derivedAction : this.derivedAnimationAction) {
			if(derivedAction.accept(nodeVisitor)) {
				derivedAction.postLeftAction(this.engine, nodeVisitor);
			}
		}
	}
	
	public abstract void nodeLeft_(ISemanticVisitor nodeVisitor);
	
	@Override
	public void nodeSuspended(ISemanticVisitor nodeVisitor, Suspension suspension) {
		// Apply PRE and POST actions attached to the animator when
		// an acceptable node is suspended.
		for(DerivedAnimationAction derivedAction : this.derivedAnimationAction) {
			if(derivedAction.accept(nodeVisitor)) {
				derivedAction.preSuspendAction(this.engine, nodeVisitor);
			}
		}
		this.nodeSuspended_(nodeVisitor);
		for(DerivedAnimationAction derivedAction : this.derivedAnimationAction) {
			if(derivedAction.accept(nodeVisitor)) {
				derivedAction.postSuspendAction(this.engine, nodeVisitor);
			}
		}
	}
	
	public abstract void nodeSuspended_(ISemanticVisitor nodeVisitor);
	
	@Override
	public void valueCreated(IValue value) {
		// By default do nothing
	}

	@Override
	public void valueDestroyed(IValue value) {
		// By default do nothing
	}
	
	public void rtcStepBegin(IReference context) {
		// By default do nothing
	}
	
	public void rtcStepEnd(IReference context) {
		// By default do nothing
	}

}
