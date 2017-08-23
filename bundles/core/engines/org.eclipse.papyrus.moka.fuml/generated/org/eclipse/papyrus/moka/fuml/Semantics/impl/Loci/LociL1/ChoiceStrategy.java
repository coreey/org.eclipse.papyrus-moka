/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1;

import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.IChoiceStrategy;

public abstract class ChoiceStrategy extends SemanticStrategy implements IChoiceStrategy{

	@Override
	public String getName() {
		// The name of a choice strategy is always "choice".
		return "choice";
	}

	public abstract Integer choose(Integer size);
}
