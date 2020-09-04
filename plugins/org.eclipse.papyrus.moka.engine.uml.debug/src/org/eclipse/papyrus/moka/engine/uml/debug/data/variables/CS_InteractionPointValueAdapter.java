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

package org.eclipse.papyrus.moka.engine.uml.debug.data.variables;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.papyrus.moka.pscs.structuredclassifiers.ICS_InteractionPoint;

public class CS_InteractionPointValueAdapter extends UMLValueAdapter<ICS_InteractionPoint>{

	public CS_InteractionPointValueAdapter(IDebugTarget target, ICS_InteractionPoint adaptedObject) {
		super(target, adaptedObject);
	}
	
	@Override
	public String getValueString() throws DebugException {
		// The string representation of an interaction point is given
		// by the identifier of its referent (i.e., the object representing
		// the port instance).
		if(value.getReferent() != null) {
			return value.getReferent().getIdentifier();
		}
		return "";
	}

}
