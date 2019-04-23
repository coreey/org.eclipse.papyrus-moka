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
package org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses;

// Imports
import java.util.List;

import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Link;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Link;
import org.eclipse.uml2.uml.StructuralFeature;


public class CS_Link extends Link implements ICS_Link {

	public Boolean hasValueForAFeature(IValue value) {
		// Returns true if the given value object is used as a value for a FeatureValue of this link
		return this.getFeature(value) != null;
	}

	public StructuralFeature getFeature(IValue value) {
		List<IFeatureValue> allFeatureValues = this.getFeatureValues();
		Integer i = 1;
		StructuralFeature feature = null;
		while (i <= allFeatureValues.size() && feature == null) {
			IFeatureValue featureValue = allFeatureValues.get(i - 1);
			if (!featureValue.getValues().isEmpty() && featureValue.getValues().get(0).equals(value)) {
				feature = featureValue.getFeature();
			}
			i = i + 1;
		}
		return feature;
	}
}
