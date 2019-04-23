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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.moka.animation.engine.animators.actions.DerivedAnimationAction;
import org.eclipse.papyrus.moka.animation.engine.rendering.AnimationEngine;

public class AnimatorExtensionEvaluator {
	
	private static final String ANIMATOR_ID = "org.eclipse.papyrus.moka.animation.animator";
	
	private static final String REDEFINED_ATTR = "redefined";
	
	private static final String PRIORITY_ATTR = "priority";
	
	private static final String CLASS_ATTR = "class";
	
	private static final String DERIVED_ACTIONS_ATTR = "derivedAnimationAction";
	
	public static List<Animator> evaluateAnimators(AnimationEngine engine){
		// Evaluate all contributions to the ANIMATOR extension points
		List<Animator> animators = new ArrayList<Animator>();
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] configurations = registry.getConfigurationElementsFor(ANIMATOR_ID);
		if(configurations.length > 0) {
			Set<String> redefinedAnimator = getRedefinedAnimator(configurations);
			for(IConfigurationElement configuration : configurations){
				String clazz = configuration.getAttribute(CLASS_ATTR);
				if(!redefinedAnimator.contains(clazz)) {
					animators.add(createAnimator(configuration, engine));
				}
			}
		}
		return animators;
	}
	
	private static Set<String> getRedefinedAnimator(IConfigurationElement[] configurations){
		// Build the set of animators that are redefined and that shall
		// no be instantiated
		Set<String> redefinedAnimator = new HashSet<String>();
		for(IConfigurationElement configuration : configurations) {
			String redefined = configuration.getAttribute(REDEFINED_ATTR);
			if(redefined != null && !redefined.isEmpty()) {
				redefinedAnimator.add(redefined);
			}
		}
		return redefinedAnimator;
	}
	
	private static Animator createAnimator(IConfigurationElement configuration, AnimationEngine engine) {
		// Instantiate the animator based on the information provided in the contribution
		// to the extension point.
		// 1] The class defining the animator is instantiated
		// 2] If no priority is given to the animator then it has the default priority (i.e. 0)
		// 3] If the animator is provided with derived animation actions then they
		//    are attached to the animator
		Animator animator = null;
		if(configuration != null) {
			try {
				animator = (Animator) configuration.createExecutableExtension(CLASS_ATTR);
				animator.setAnimationEngine(engine);
			} catch (CoreException e) {
				e.printStackTrace();
			}
			if(animator != null){
				String prioritySpecification = configuration.getAttribute(PRIORITY_ATTR);
				if(prioritySpecification != null && !prioritySpecification.isEmpty()){
					int priority = 0;
					try{
						priority = Integer.parseInt(prioritySpecification);
					}catch(NumberFormatException e){
						e.printStackTrace();
					}
					animator.setPriority(priority);
				}else{
					animator.setPriority(0);
				}
				animator.setDerivedAnimationAction(evaluateDerivedActions(configuration.getChildren(DERIVED_ACTIONS_ATTR)));
			}
		}
		return animator;
	}
	
	
	private static List<DerivedAnimationAction> evaluateDerivedActions(final IConfigurationElement[] contributions){
		// Instantiate derived animation actions specified for an animator
		List<DerivedAnimationAction> derivedActions = new ArrayList<DerivedAnimationAction>();
		for(IConfigurationElement contribution : contributions) {
			DerivedAnimationAction derivedAction = null;
			try {
				derivedAction = (DerivedAnimationAction) contribution.createExecutableExtension(CLASS_ATTR);
			} catch (CoreException e) {
				e.printStackTrace();
			}
			derivedActions.add(derivedAction);
		}
		return derivedActions;
	}
}
