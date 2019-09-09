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

import java.util.Iterator;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.engine.uml.debug.data.variables.FeatureValueVariableAdapter;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IStructuredValue;

public class StructuredValueAdapter extends UMLValueAdapter<IStructuredValue> {

	public StructuredValueAdapter(IDebugTarget target, IStructuredValue value) {
		super(target, value);
	}

	@Override
	public String getValueString() throws DebugException {
		// By default the representation of a structured value
		// as string is given by the toString operation applied
		// on an executable UML value
		if(value != null){
			return value.toString();
		}
		return "";
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		// Variables available for a structured value are variable adapters
		// built from features values owned by the structured value.
		if (this.variables.isEmpty()) {
			Iterator<IFeatureValue> featureValueIterator = value.getFeatureValues().iterator();
			while (featureValueIterator.hasNext()) {
				this.variables.add(new FeatureValueVariableAdapter(getDebugTarget(), value, featureValueIterator.next()));
			}
		}
		return this.variables.toArray(new IVariable[0]);
	}
}
