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

package org.eclipse.papyrus.moka.debug.model.data.mapping.values;

import org.eclipse.debug.core.DebugException;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_InteractionPoint;
import org.eclipse.papyrus.moka.debug.engine.MokaDebugTarget;

public class CS_InteractionPointValueAdapter extends MokaValueAdapter<ICS_InteractionPoint>{

	public CS_InteractionPointValueAdapter(MokaDebugTarget debugTarget, ICS_InteractionPoint adaptedObject) {
		super(debugTarget, adaptedObject);
	}
	
	@Override
	public String getValueString() throws DebugException {
		// The string representation of an interaction point is given
		// by the identifier of its referent (i.e., the object representing
		// the port instance).
		if(this.adaptedObject.getReferent() != null) {
			return this.adaptedObject.getReferent().getIdentifier();
		}
		return "";
	}

}
