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

public class AnimatedDiagramTree {

	protected IAnimationTreeNode root;

	public AnimatedDiagramTree() {
		this.root = AnimationTreeNodeFactory.getInstance().createAnimationTreeNode();
	}

	public IAnimationTreeNode getRoot() {
		return this.root;
	}

}
