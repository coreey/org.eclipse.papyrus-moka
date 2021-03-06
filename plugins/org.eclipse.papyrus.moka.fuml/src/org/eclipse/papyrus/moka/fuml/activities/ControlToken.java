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
package org.eclipse.papyrus.moka.fuml.activities;

import org.eclipse.papyrus.moka.fuml.values.Value;

public class ControlToken extends Token {

	@Override
	public Boolean equals(IToken other) {
		// Return true if the other token is a control token, because control
		// tokens are interchangable.
		return other instanceof ControlToken;
	}

	@Override
	public Token copy() {
		// Return a new control token.
		return new ControlToken();
	}

	@Override
	public Boolean isControl() {
		// Return true for a control token.
		return true;
	}

	@Override
	public Value getValue() {
		// Control tokens do not have values.
		return null;
	}
}
