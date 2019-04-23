/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.composites.Semantics.impl.CommonBehaviors.Communications;

// Imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Object;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.FeatureValue;
import org.eclipse.uml2.uml.StructuralFeature;

public class CS_NameBased_StructuralFeatureOfInterfaceAccessStrategy extends CS_StructuralFeatureOfInterfaceAccessStrategy {

	@Override
	public IFeatureValue read(ICS_Object cs_Object, StructuralFeature feature) {
		// returns the a copy of the first feature value of cs_Object where the name of the corresponding feature
		// matches the name of the feature given as a parameter
		// Otherwise, returns an empty feature value
		List<IFeatureValue> featureValues = cs_Object.getFeatureValues();
		IFeatureValue matchingFeatureValue = null;
		for (int i = 0; i < featureValues.size() && matchingFeatureValue == null; i++) {
			IFeatureValue featureValue = featureValues.get(i);
			if (featureValue.getFeature().getName().equals(feature.getName())) {
				matchingFeatureValue = featureValue;
			}
		}
		if (matchingFeatureValue != null) {
			matchingFeatureValue = matchingFeatureValue.copy();
			matchingFeatureValue.setFeature(feature);
		} else {
			matchingFeatureValue = new FeatureValue();
			matchingFeatureValue.setFeature(feature);
			matchingFeatureValue.setValues(new ArrayList<IValue>());
			matchingFeatureValue.setPosition(0);
		}

		return matchingFeatureValue;
	}

	@Override
	public void write(ICS_Object cs_Object, StructuralFeature feature, List<IValue> values, Integer position) {
		// Retrieves the first feature value of cs_Object where the name of the corresponding feature
		// matches the name of the feature given as a parameter
		// Then updates the values for this feature value
		List<IFeatureValue> featureValues = cs_Object.getFeatureValues();
		IFeatureValue matchingFeatureValue = null;
		for (int i = 0; i < featureValues.size() && matchingFeatureValue == null; i++) {
			IFeatureValue featureValue = featureValues.get(i);
			if (featureValue.getFeature().getName().equals(feature.getName())) {
				matchingFeatureValue = featureValue;
			}
		}
		if (matchingFeatureValue != null) {
			cs_Object.setFeatureValue(matchingFeatureValue.getFeature(), values, position);
		}
	}
}
