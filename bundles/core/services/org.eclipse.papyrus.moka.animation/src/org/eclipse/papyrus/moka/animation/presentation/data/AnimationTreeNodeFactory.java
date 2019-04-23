/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
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
package org.eclipse.papyrus.moka.animation.presentation.data;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;

public final class AnimationTreeNodeFactory {

	public static AnimationTreeNodeFactory INSTANCE;

	private AnimationTreeNodeFactory() {
	}

	public static AnimationTreeNodeFactory getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AnimationTreeNodeFactory();
		}
		return INSTANCE;
	}

	public IAnimationTreeNode createNode(Object input) {
		IAnimationTreeNode node = null;
		if (input == null) {
			node = this.createAnimationTreeNode();
		} else if (input instanceof Diagram) {
			node = this.createDiagramAnimationNode((Diagram) input);
		} else if (input instanceof IObject_) {
			node = this.createAnimatingInstanceNode((IObject_) input);
		}
		return node;
	}

	public IAnimationTreeNode createAnimationTreeNode() {
		return new AnimationTreeNode();
	}

	public IAnimationTreeNode createAnimatingInstanceNode(IObject_ value) {
		AnimatingInstanceNode node = new AnimatingInstanceNode();
		node.setInstance(value);
		return node;
	}

	public IAnimationTreeNode createDiagramAnimationNode(Diagram diagram) {
		DiagramAnimationNode node = new DiagramAnimationNode();
		node.setAnimatedDiagram(diagram);
		return node;
	}

}
