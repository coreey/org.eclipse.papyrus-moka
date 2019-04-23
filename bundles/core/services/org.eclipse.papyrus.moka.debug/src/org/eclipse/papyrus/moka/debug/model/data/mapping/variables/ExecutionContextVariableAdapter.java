/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
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
import org.eclipse.papyrus.moka.debug.engine.MokaDebugTarget;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;

public class ExecutionContextVariableAdapter extends MokaVariableAdapter<IObject_> {

	protected IObject_ context;

	protected final String NAME = "context";

	public ExecutionContextVariableAdapter(MokaDebugTarget debugTarget, IObject_ context) {
		super(debugTarget, context);
	}

	@Override
	public String getName() throws DebugException {
		// Return the variable name
		return this.NAME;
	}
	
}
