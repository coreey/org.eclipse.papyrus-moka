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

package org.eclipse.papyrus.moka.engine.uml.debug.data.variables;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IObjectActivation;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IObject_;

public class ObjectValueAdapter extends StructuredValueAdapter {

	protected IVariable eventPoolVariable;

	public ObjectValueAdapter(IDebugTarget debugTarget, IObject_ object) {
		super(debugTarget, object);
	}

	@Override
	public String getValueString() throws DebugException {
		return ((IObject_)value).getIdentifier();
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		super.getVariables();
		if (this.eventPoolVariable == null) {
			IObjectActivation objectActivation = ((IObject_) value).getObjectActivation();
			if (objectActivation != null) {
				this.eventPoolVariable = new EventPoolVariableAdapter(getDebugTarget(), objectActivation);
				this.variables.add(0, this.eventPoolVariable);
			}
		}

		return this.variables.toArray(new IVariable[0]);
	}
}
