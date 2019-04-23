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
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities;

import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IObjectToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;

public class ObjectToken extends Token implements IObjectToken {

	/*
	 * The value carried by this token. A token may have no value, in which case
	 * it is a "null token".
	 */
	public IValue value;

	@Override
	public Boolean equals(IToken other) {
		// Test if this object token is the same as the other token.
		return this == other;
	}

	@Override
	public Token copy() {
		// Return a new object token with the same value as this token.
		// [Note: the holder of the copy is not set.]
		ObjectToken copy = new ObjectToken();
		copy.value = this.value;
		return copy;
	}

	@Override
	public Boolean isControl() {
		// Return false for an object token.
		return false;
	}

	@Override
	public IValue getValue() {
		// Return the value of this object token.
		return this.value;
	}

	public void setValue(IValue value) {
		this.value = value;
	}
}
