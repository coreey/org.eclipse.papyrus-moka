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

import java.util.Iterator;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.debug.engine.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.model.data.mapping.variables.FeatureValueVariableAdapter;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IStructuredValue;

public class StructuredValueAdapter extends MokaValueAdapter<IStructuredValue> {

	public StructuredValueAdapter(MokaDebugTarget debugTarget, IStructuredValue value) {
		super(debugTarget, value);
	}

	@Override
	public String getValueString() throws DebugException {
		// By default the representation of a structured value
		// as string is given by the toString operation applied
		// on an executable UML value
		if(this.adaptedObject != null){
			return this.adaptedObject.toString();
		}
		return "";
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		// Variables available for a structured value are variable adapters
		// built from features values owned by the structured value.
		if (this.variables.isEmpty()) {
			Iterator<IFeatureValue> featureValueIterator = this.adaptedObject.getFeatureValues().iterator();
			while (featureValueIterator.hasNext()) {
				this.variables.add(new FeatureValueVariableAdapter(this.debugTarget, this.adaptedObject, featureValueIterator.next()));
			}
		}
		return this.variables.toArray(new IVariable[0]);
	}
}
