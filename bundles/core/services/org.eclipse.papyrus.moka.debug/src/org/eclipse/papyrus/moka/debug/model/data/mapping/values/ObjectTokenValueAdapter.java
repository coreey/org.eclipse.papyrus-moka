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

package org.eclipse.papyrus.moka.debug.model.data.mapping.values;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.debug.engine.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.model.data.mapping.variables.ObjectTokenVariableValueAdapter;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IObjectToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;

public class ObjectTokenValueAdapter extends TokenValueAdapter {

	public ObjectTokenValueAdapter(MokaDebugTarget debugTarget, IToken token) {
		super(debugTarget, token);
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		if (this.variables.isEmpty()) {
			this.variables.add(new ObjectTokenVariableValueAdapter(debugTarget, ((IObjectToken)this.adaptedObject).getValue()));
		}
		return this.variables.toArray(new IVariable[0]);
	}
	
	@Override
	public String getValueString() throws DebugException {
		return "";
	}
}
