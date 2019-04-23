/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
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
 *  David LOPEZ BETANCUR (CEA LIST)
 *  Sebastien REVOL (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.xygraph.common.ui;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor;

public class XYGraphEditorPartSelectionProvider implements ISelectionProvider {
	
	private final ListenerList<ISelectionChangedListener> fListeners= new ListenerList<>();
	private ISelection currentSelection = StructuredSelection.EMPTY;
	
	public XYGraphEditorPartSelectionProvider(XYGraphDescriptor xyGraphDescriptor) {
		currentSelection = new StructuredSelection(xyGraphDescriptor);
	}

	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		fListeners.add(listener);
	}

	@Override
	public ISelection getSelection() {
		return currentSelection;
	}

	@Override
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		fListeners.remove(listener);
	}

	@Override
	public void setSelection(ISelection selection) {
		if ( this.currentSelection != null && this.currentSelection.equals(selection)) {
			return;
		}
		
		this.currentSelection = selection;
		
		final SelectionChangedEvent event = new SelectionChangedEvent(this, this.currentSelection);
		for (final ISelectionChangedListener current : this.fListeners) {
			current.selectionChanged(event);
		}
	}
}
