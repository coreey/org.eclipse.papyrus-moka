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
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel;

import org.eclipse.uml2.uml.LiteralUnlimitedNatural;

public class LiteralUnlimitedNaturalEvaluation extends LiteralEvaluation {

	@Override
	public Value evaluate() {
		// Evaluate a literal unlimited natural producing an unlimited natural
		// value.
		LiteralUnlimitedNatural literal = (LiteralUnlimitedNatural) specification;
		UnlimitedNaturalValue unlimitedNaturalValue = new UnlimitedNaturalValue();
		unlimitedNaturalValue.type = this.getType("UnlimitedNatural");
		unlimitedNaturalValue.value = literal.getValue();
		return unlimitedNaturalValue;
	}
}
