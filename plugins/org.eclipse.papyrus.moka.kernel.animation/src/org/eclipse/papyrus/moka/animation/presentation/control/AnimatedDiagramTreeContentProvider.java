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
package org.eclipse.papyrus.moka.animation.presentation.control;

import java.util.Iterator;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.moka.animation.presentation.data.AnimatedDiagramTree;
import org.eclipse.papyrus.moka.animation.presentation.data.IAnimationTreeNode;
import org.eclipse.swt.widgets.Display;

public class AnimatedDiagramTreeContentProvider implements ITreeContentProvider {

	// Does a refresh has already been requested but it is still not realized.
	protected boolean pendingRefresh;

	// The viewer that is in charge of displaying the data model
	protected TreeViewer viewer;

	public AnimatedDiagramTreeContentProvider() {
		this.pendingRefresh = false;
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer = (TreeViewer) viewer;
		if (oldInput != null) {
			IAnimationTreeNode node = null;
			if (oldInput instanceof AnimatedDiagramTree) {
				node = ((AnimatedDiagramTree) oldInput).getRoot();
			} else {
				node = (IAnimationTreeNode) oldInput;
			}
			this.removeListenerTo(node);
		}
		if (newInput != null) {
			IAnimationTreeNode node = null;
			if (newInput instanceof AnimatedDiagramTree) {
				node = ((AnimatedDiagramTree) newInput).getRoot();
			} else {
				node = (IAnimationTreeNode) newInput;
			}
			this.addListenerTo(node);
		}
		this.pendingRefresh = false;
	}

	protected void addListenerTo(IAnimationTreeNode node) {
		node.addListener(this);
		Iterator<IAnimationTreeNode> nodeIterator = node.getChildren().iterator();
		while (nodeIterator.hasNext()) {
			this.addListenerTo(nodeIterator.next());
		}
	}

	protected void removeListenerTo(IAnimationTreeNode node) {
		node.removeListener(this);
		Iterator<IAnimationTreeNode> nodeIterator = node.getChildren().iterator();
		while (nodeIterator.hasNext()) {
			this.removeListenerTo(nodeIterator.next());
		}
	}


	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof AnimatedDiagramTree) {
			return new Object[] { ((AnimatedDiagramTree) inputElement).getRoot() };
		}
		return new Object[] {};
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		Object[] children = null;
		if (parentElement instanceof IAnimationTreeNode) {
			children = ((IAnimationTreeNode) parentElement).getChildren().toArray();
		}
		return children;
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof IAnimationTreeNode) {
			return ((IAnimationTreeNode) element).getParent();
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		boolean hasChildren = true;
		if (element instanceof IAnimationTreeNode) {
			hasChildren = !((IAnimationTreeNode) element).getChildren().isEmpty();
		}
		return hasChildren;
	}

	public void requestRefresh() {
		if (!this.pendingRefresh) {
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					TreeViewer viewer = (TreeViewer) AnimatedDiagramTreeContentProvider.this.viewer;
					viewer.refresh();
					viewer.expandAll();
				}
			});
		}
	}

	@Override
	public void dispose() {

	}
}
