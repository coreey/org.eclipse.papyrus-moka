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

package org.eclipse.papyrus.moka.engine.uml.debug.data.values;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;

public class DefaultValueAdapter extends UMLValueAdapter<Object> {

	public DefaultValueAdapter(IDebugTarget debugTarget, Object object) {
		super(debugTarget, object);
	}

	@Override
	public String getReferenceTypeName() throws DebugException {
		// No value adapter could handle the object to be adapted.
		// Hence the default value adapter is used.
		return "<no reference type>";
	}

	@Override
	public String getValueString() throws DebugException {
		// No value adapter could handle the object to be adapted.
		// Hence the default value adapter is used.
		if(value != null) {
			return value.toString();
		}
		return "<null or no representation>";
	}
}
