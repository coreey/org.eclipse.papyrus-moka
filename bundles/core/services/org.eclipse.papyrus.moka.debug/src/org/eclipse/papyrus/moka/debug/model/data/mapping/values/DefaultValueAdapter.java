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
import org.eclipse.papyrus.moka.debug.engine.MokaDebugTarget;

public class DefaultValueAdapter extends MokaValueAdapter<Object> {

	public DefaultValueAdapter(MokaDebugTarget debugTarget, Object adapted) {
		super(debugTarget, adapted);
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
		if(this.adaptedObject != null) {
			return this.toString();
		}
		return "<null or no representation>";
	}
}
