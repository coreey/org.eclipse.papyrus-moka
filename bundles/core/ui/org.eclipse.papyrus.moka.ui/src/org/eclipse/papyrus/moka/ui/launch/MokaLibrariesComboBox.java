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

import java.util.Iterator;

import org.eclipse.papyrus.uml.extensionpoints.library.IRegisteredLibrary;
import org.eclipse.swt.widgets.Composite;

public class MokaLibrariesComboBox extends MokaComboBox<String, IRegisteredLibrary> {

	public MokaLibrariesComboBox(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public void add(IRegisteredLibrary element) {
		String label = this.generateLabel(element);
		this.population.put(label, element);
		this.add(label);
	}

	@Override
	protected String generateLabel(IRegisteredLibrary e) {
		return "[" + e.getName() + "] - " + e.getDescription();
	}

	public void selectByUri(String libraryUri) {
		Iterator<IRegisteredLibrary> librariesIterator = this.population.values().iterator();
		IRegisteredLibrary targetLib = null;
		while (targetLib == null && librariesIterator.hasNext()) {
			IRegisteredLibrary current = librariesIterator.next();
			if (current.getUri().toString().equals(libraryUri)) {
				targetLib = current;
			}
		}
		if (targetLib != null) {
			this.selectById(this.generateLabel(targetLib));
		}
	}

}
