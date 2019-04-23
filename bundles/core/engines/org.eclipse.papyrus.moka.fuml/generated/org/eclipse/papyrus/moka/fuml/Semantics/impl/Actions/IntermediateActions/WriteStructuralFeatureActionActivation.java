/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Actions.IntermediateActions.IWriteStructuralFeatureActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;

public abstract class WriteStructuralFeatureActionActivation extends StructuralFeatureActionActivation implements IWriteStructuralFeatureActionActivation {

	public Integer position(IValue value, List<IValue> list, Integer startAt) {
		// Return the position (counting from 1) of the first occurance of the
		// given value in the given list at or after the starting index, or 0 if
		// it is not found.
		boolean found = false;
		int i = startAt;
		while (!found & i <= list.size()) {
			found = list.get(i - 1).equals(value);
			i = i + 1;
		}
		if (!found) {
			i = 1;
		}
		return i - 1;
	}
}
