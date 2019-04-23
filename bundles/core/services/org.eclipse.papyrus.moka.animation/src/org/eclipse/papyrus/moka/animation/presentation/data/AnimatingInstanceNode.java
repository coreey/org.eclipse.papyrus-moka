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

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;

public class AnimatingInstanceNode extends AnimationTreeNode {

	public IObject_ instance;

	public boolean allowed;

	public AnimatingInstanceNode() {
		super();
		this.allowed = true;
	}

	public IObject_ getInstance() {
		return instance;
	}

	public void setInstance(IObject_ instance) {
		this.instance = instance;
	}

	@Override
	public boolean addChild(IAnimationTreeNode node) {
		// This node is not intended to have children
		return false;
	}

	@Override
	public boolean removeChild(IAnimationTreeNode node) {
		// This node is not intended to have children
		return false;
	}

	public boolean isAllowed() {
		return allowed;
	}

	public void setAllowed(boolean allowed) {
		this.allowed = allowed;
	}
}
