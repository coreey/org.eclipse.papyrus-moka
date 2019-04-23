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

public interface IAnimation {

	// Render the specified model element using the specified style. Existing style
	// are removed in order to ensure that the specified style is used. Moving from
	// a style to another style just consists in two successive call to this operation
	public void renderAs(EObject modelElement, IObject_ object, AnimationKind targetStyle);

	public void renderAs(EObject modelElement, IObject_ object, AnimationKind sourceStyle, AnimationKind targetStyle, int duration);

}
