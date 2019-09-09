/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.moka.pscs.actions;

import org.eclipse.papyrus.moka.fuml.loci.SemanticStrategy;

public abstract class CS_ConstructStrategy extends SemanticStrategy implements ICS_ConstructStrategy{

	@Override
	public String getName() {
		// a CS_ConstructionStrategy is always named "constructStrategy"
		return "constructStrategy";
	}

}
