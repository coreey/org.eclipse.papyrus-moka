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

import org.eclipse.swt.widgets.Composite;
import org.eclipse.uml2.uml.NamedElement;

public class MokaUMLComboBox extends MokaComboBox<String, NamedElement> {

	public MokaUMLComboBox(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public void add(NamedElement element) {
		String label = this.generateLabel(element);
		this.add(this.generateLabel(element));
		this.population.put(label, element);
	}

	public void selectByURIFragment(String fragment) {
		for (String id : this.population.keySet()) {
			String uriFrag = this.population.get(id).eResource().getURIFragment(this.population.get(id));
			if (uriFrag != null && uriFrag.equals(fragment)) {
				this.selectById(id);
				break;
			}
		}
	}

	@Override
	protected String generateLabel(NamedElement e) {
		String label = "[" + e.getClass().getSimpleName().replace("Impl", "") + "] ";
		String s = e == null ? "" : (e.getQualifiedName() == null ? "" : e.getQualifiedName());
		label += s;
		return label;
	}
}
