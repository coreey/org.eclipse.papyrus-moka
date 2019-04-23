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
import org.eclipse.papyrus.moka.debug.model.data.mapping.variables.EventPoolVariableAdapter;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IObjectActivation;

public class ObjectValueAdapter extends StructuredValueAdapter {

	protected IVariable eventPoolVariable;

	public ObjectValueAdapter(MokaDebugTarget debugTarget, IObject_ object) {
		super(debugTarget, object);
	}

	@Override
	public String getValueString() throws DebugException {
		return ((IObject_) this.adaptedObject).getIdentifier();
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		super.getVariables();
		if (this.eventPoolVariable == null) {
			IObjectActivation objectActivation = ((IObject_) this.adaptedObject).getObjectActivation();
			if (objectActivation != null) {
				this.eventPoolVariable = new EventPoolVariableAdapter(this.debugTarget, objectActivation);
				this.variables.add(0, this.eventPoolVariable);
			}
		}

		return this.variables.toArray(new IVariable[0]);
	}
}
