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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.papyrus.moka.animation.presentation.control.AnimatedDiagramTreeContentProvider;


public class AnimationTreeNode implements IAnimationTreeNode {

	public IAnimationTreeNode parent;

	public List<IAnimationTreeNode> children;

	public List<IContentProvider> listeners;

	public AnimationTreeNode() {
		this.children = new ArrayList<IAnimationTreeNode>();
		this.listeners = new ArrayList<IContentProvider>();
	}

	@Override
	public IAnimationTreeNode getParent() {
		return this.parent;
	}

	@Override
	public IAnimationTreeNode getRoot() {
		if (this.parent != null) {
			return this.getParent();
		}
		return this;
	}

	@Override
	public boolean addChild(IAnimationTreeNode node) {
		boolean added = false;
		if (node != null) {
			added = this.children.add(node);
			if (added) {
				node.setParent(this);
				this.fireChildAdded();
			}
		}
		return added;
	}

	@Override
	public boolean removeChild(IAnimationTreeNode node) {
		boolean removed = false;
		if (node != null) {
			removed = this.children.remove(node);
			if (removed) {
				this.fireChildRemoved();
			}
		}
		return removed;
	}

	@Override
	public boolean addListener(IContentProvider contentProvider) {
		boolean added = false;
		if (contentProvider != null) {
			added = this.listeners.add(contentProvider);
		}
		return added;
	}

	@Override
	public boolean removeListener(IContentProvider contentProvider) {
		boolean removed = false;
		if (contentProvider != null) {
			removed = this.listeners.remove(contentProvider);
		}
		return removed;
	}

	@Override
	public List<IAnimationTreeNode> getChildren() {
		return this.children;
	}

	@Override
	public void setParent(IAnimationTreeNode node) {
		this.parent = node;
	}

	protected void fireChildAdded() {
		for (IContentProvider contentProvider : this.listeners) {
			if (contentProvider instanceof AnimatedDiagramTreeContentProvider) {
				((AnimatedDiagramTreeContentProvider) contentProvider).requestRefresh();
			}
		}
	}

	protected void fireChildRemoved() {
		for (IContentProvider contentProvider : this.listeners) {
			if (contentProvider instanceof AnimatedDiagramTreeContentProvider) {
				((AnimatedDiagramTreeContentProvider) contentProvider).requestRefresh();
			}
		}
	}
}
