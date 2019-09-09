/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
 *****************************************************************************/
package org.eclipse.papyrus.moka.ui.launch;

import java.util.HashMap;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

public abstract class MokaComboBox<I, E> extends Combo {

	protected HashMap<I, E> population;

	public MokaComboBox(Composite parent, int style) {
		super(parent, style);
		this.population = new HashMap<I, E>();
	}

	public abstract void add(E element);

	protected abstract String generateLabel(E e);

	public E getSelected() {
		if (this.getSelectionIndex() < 0) {
			return null;
		}
		String id = this.getItem(this.getSelectionIndex());
		return this.population.get(id);
	}

	@Override
	public void removeAll() {
		super.removeAll();
		this.population.clear();
	}

	public void selectFirst() {
		if (this.getItemCount() != 0) {
			this.select(0);
		}
	}

	public void selectById(I id) {
		int index = 0;
		String item = null;
		while (item == null && index < this.getItemCount()) {
			if (this.getItem(index).equals(id)) {
				item = this.getItem(index);
				this.select(index);
			}
			index++;
		}
	}

	@Override
	protected void checkSubclass() {
		// Do nothing, but ensure that we are allowed to extend basic widget provided by SWT
	}
}
