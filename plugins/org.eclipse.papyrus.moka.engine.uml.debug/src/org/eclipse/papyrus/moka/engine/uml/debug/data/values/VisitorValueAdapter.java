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
import org.eclipse.papyrus.moka.fuml.loci.ISemanticVisitor;

public abstract class VisitorValueAdapter<T extends ISemanticVisitor> extends UMLValueAdapter<T> {

	private final static String EMPTY_REPRESENTATION = "";
	
	public VisitorValueAdapter(IDebugTarget target, T visitor) {
		super(target, visitor);
	}
	
	@Override
	public String getValueString() throws DebugException {
		if (value != null) {
			return value.toString();
		}
		return EMPTY_REPRESENTATION;
	}
	
}
