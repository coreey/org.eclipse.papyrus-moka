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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;

public interface IRenderingEngine {

	public boolean isRenderingRuleApplied(EObject modelElement, AnimationKind kind);

	public void removeRenderingRules(EObject modelElement);

	public void startRendering(EObject modelElement, IObject_ animator, AnimationKind kind);

	public void stopRendering(EObject modelElement, IObject_ animator, AnimationKind kind);

	public void renderAs(EObject modelElement, IObject_ object, AnimationKind targetStyle);
	
	public void renderAs(EObject modelElement, IObject_ object, AnimationKind sourceStyle, AnimationKind targetStyle, int duration);

}
