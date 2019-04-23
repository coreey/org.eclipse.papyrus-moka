/**
 * Copyright (c) 2017 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0 
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *   CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.moka.debug.model.data.mapping.variables;

import org.eclipse.debug.core.DebugException;
import org.eclipse.papyrus.moka.debug.engine.MokaDebugTarget;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IObjectNodeActivation;
import org.eclipse.uml2.uml.ObjectNode;

public class ObjectNodeActivationVariableAdapter extends MokaVariableAdapter<IObjectNodeActivation> {

	public ObjectNodeActivationVariableAdapter(MokaDebugTarget debugTarget, IObjectNodeActivation adaptedVariable) {
		super(debugTarget, adaptedVariable);
	}
	
	@Override
	public String getName() throws DebugException {
		// The name of the variable is the name of the object node or 'empty'
		// if no node is attached to the node activation
		ObjectNode node = (ObjectNode) this.adaptedVariable.getNode();
		if (node != null) {
			return node.getName();
		}
		return "<empty>";
	}

}
