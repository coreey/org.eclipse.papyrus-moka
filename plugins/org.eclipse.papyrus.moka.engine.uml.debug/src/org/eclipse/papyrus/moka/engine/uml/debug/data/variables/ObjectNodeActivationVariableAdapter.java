/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.moka.engine.uml.debug.data.variables;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.papyrus.moka.fuml.activities.IObjectNodeActivation;
import org.eclipse.uml2.uml.ObjectNode;

public class ObjectNodeActivationVariableAdapter extends UMLVariableAdapter<IObjectNodeActivation> {

	public ObjectNodeActivationVariableAdapter(IDebugTarget target, IObjectNodeActivation variable) {
		super(target, variable);
	}
	
	@Override
	public String getName() throws DebugException {
		// The name of the variable is the name of the object node or 'empty'
		// if no node is attached to the node activation
		ObjectNode node = (ObjectNode) variable.getNode();
		if (node != null) {
			return node.getName();
		}
		return super.getName();
	}

}
