/*****************************************************************************
 * Copyright (c) 2019 CEA LIST.
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
package org.eclipse.papyrus.moka.kernel.validation;

import java.util.HashSet;
import java.util.Set;

public class ValidationDescriptor {

	protected String category = "";

	protected Set<String> excludedConstrains = new HashSet<String>();

	protected Set<String> excludedCategories = new HashSet<String>();

	public ValidationDescriptor() {
	}

	public ValidationDescriptor(String category) {
		super();
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Set<String> getExcludedConstrains() {
		return excludedConstrains;
	}

	public void addExcludedConstraint(String constraint) {
		excludedConstrains.add(constraint);
	}

	public Set<String> getExcludedCategories() {
		return excludedCategories;
	}

	public void addExcludedCategory(String category) {
		excludedCategories.add(category);
	}

}
