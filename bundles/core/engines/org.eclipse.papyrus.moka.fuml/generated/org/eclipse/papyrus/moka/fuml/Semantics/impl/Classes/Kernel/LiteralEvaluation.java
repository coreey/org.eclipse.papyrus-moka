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

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.ILiteralEvaluation;
import org.eclipse.uml2.uml.PrimitiveType;

public abstract class LiteralEvaluation extends Evaluation implements ILiteralEvaluation {

	public PrimitiveType getType(String builtInTypeName) {
		// Get the type of the specification. If that is null, then use the
		// built-in type of the given name.
		PrimitiveType type = (PrimitiveType) (this.specification.getType());
		if (type == null) {
			// Cast required because builtInType list is of type Type
			type = (PrimitiveType) this.locus.getFactory().getBuiltInType(builtInTypeName);
		}
		return type;
	}
}
