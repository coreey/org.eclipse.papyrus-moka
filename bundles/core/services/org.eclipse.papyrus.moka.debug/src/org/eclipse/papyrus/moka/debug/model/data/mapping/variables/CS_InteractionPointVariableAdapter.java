/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.moka.debug.model.data.mapping.variables;

import org.eclipse.debug.core.DebugException;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_InteractionPoint;
import org.eclipse.papyrus.moka.debug.engine.MokaDebugTarget;

public class CS_InteractionPointVariableAdapter extends MokaVariableAdapter<ICS_InteractionPoint>{
	
	// Variable name
	private final String NAME = "port";
	
	
	public CS_InteractionPointVariableAdapter(MokaDebugTarget debugTarget, ICS_InteractionPoint interactionPoint) {
		super(debugTarget, interactionPoint);
	}

	@Override
	public String getName() throws DebugException {
		// Return the variable name
		return NAME;
	}

}
