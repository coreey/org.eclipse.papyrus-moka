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
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IPrimitiveValue;

public class PrimitiveValueAdapter extends UMLValueAdapter<IPrimitiveValue> {

	public PrimitiveValueAdapter(IDebugTarget debugTarget, IPrimitiveValue value) {
		super(debugTarget, value);
	}

	@Override
	public String getValueString() throws DebugException {
		// The string is the value represented by this primitive value.
		return value.toString();
	}

}
