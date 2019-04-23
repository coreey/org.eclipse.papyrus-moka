/*****************************************************************************
 * 
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
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.fmu.engine.semantics;

import java.util.List;

import org.eclipse.papyrus.moka.composites.extensions.Semantics.CompositeStructures.CS_NotNormativeDefaultConstructStrategy;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Object;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;

public class FMUConstructStrategy extends CS_NotNormativeDefaultConstructStrategy {

	@Override
	public void addStructuralFeatureValue(ICS_Reference context, Property feature, IValue value) {
		IFeatureValue featureValue = context.getFeatureValue(feature);
		if (featureValue != null) {
			List<IValue> values = featureValue.getValues();
			if (feature instanceof Port && !(value instanceof ICS_Object)) {
				values.add(value);
			} else {
				super.addStructuralFeatureValue(context, feature, value);
			}
		}
	}
}