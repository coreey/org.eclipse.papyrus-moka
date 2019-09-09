/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
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
package org.eclipse.papyrus.moka.animation.engine.animators;

import java.util.List;

import org.eclipse.papyrus.moka.animation.engine.animators.actions.DerivedAnimationAction;
import org.eclipse.papyrus.moka.animation.engine.rendering.AnimationEngine;

public abstract class Animator {

	// The animation engine associated to the animator
	protected AnimationEngine engine;
	
	// The priority of this animator (used to resolve conflicts
	// in case two animator can be elected to animate the same type
	// of element).
	protected int priority;
	
	// The list of actions to be executed in addition to the
	// animation an element type
	protected List<DerivedAnimationAction> derivedAnimationAction;
	
	public AnimationEngine getAnimationEngine(){
		return this.engine;
	}
	
	public void setAnimationEngine(AnimationEngine engine){
		this.engine = engine;
	}
	
	public int getPriority(){
		return this.priority;
	}
	
	public void setPriority(int priority){
		this.priority = priority;
	}
	
	public void setDerivedAnimationAction(List<DerivedAnimationAction> derivedAnimationActions) {
		this.derivedAnimationAction = derivedAnimationActions;
	}
	
	public List<DerivedAnimationAction> getDerivedAnimationAction(){
		return this.derivedAnimationAction;
	}
	
	// Constrain the set of element type that can be animated by
	// this animator
	public abstract boolean accept(Object object);
	
}
