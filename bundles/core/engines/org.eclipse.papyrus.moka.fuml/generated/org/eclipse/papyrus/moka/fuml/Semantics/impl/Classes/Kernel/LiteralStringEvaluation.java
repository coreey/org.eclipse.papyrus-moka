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

import org.eclipse.uml2.uml.LiteralString;

public class LiteralStringEvaluation extends LiteralEvaluation {

	@Override
	public Value evaluate() {
		// Evaluate a literal string, producing a string value.
		LiteralString literal = (LiteralString) specification;
		StringValue stringValue = new StringValue();
		stringValue.type = this.getType("String");
		stringValue.value = literal.getValue();
		return stringValue;
	}
}
