/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
 *  Jeremie Tatibouet (CEA LIST) 
 *  	- Apply fix for FUML12-33 Extensional values should have an unique identifier
 *  	- Apply fix for FUML12-21 ReclassifyObjectAction handles removal of structural features incorrect
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.ICompoundValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.StructuralFeature;

public abstract class CompoundValue extends StructuredValue implements ICompoundValue {

	public List<IFeatureValue> featureValues = new ArrayList<IFeatureValue>();

	@Override
	public Boolean equals(IValue otherValue) {
		// Test if this data value is equal to the otherValue.
		// To be equal, the otherValue must also be a compund value with the
		// same types and equal values for each feature.
		// Debug.println("[equals] othervalue instanceof CompoundValue = " +
		// (otherValue instanceof CompoundValue));
		// Debug.println("[equals] super.equals(otherValue) = " +
		// super.equals(otherValue));
		boolean isEqual = otherValue instanceof CompoundValue;
		if (isEqual) {
			CompoundValue otherCompoundValue = (CompoundValue) otherValue;
			// Debug.println("[equals] " + this.featureValues.size() +
			// " feature(s).");
			isEqual = super.equals(otherValue) & otherCompoundValue.featureValues.size() == this.featureValues.size();
			int i = 1;
			while (isEqual & i <= this.featureValues.size()) {
				IFeatureValue thisFeatureValue = this.featureValues.get(i - 1);
				boolean matched = false;
				int j = 1;
				while (!matched & j <= otherCompoundValue.featureValues.size()) {
					IFeatureValue otherFeatureValue = otherCompoundValue.featureValues.get(j - 1);
					if (thisFeatureValue.getFeature() == otherFeatureValue.getFeature()) {
						matched = thisFeatureValue.hasEqualValues(otherFeatureValue);
					}
					j = j + 1;
				}
				isEqual = matched;
				i = i + 1;
			}
		}
		return isEqual;
	}

	@Override
	public IValue copy() {
		// Create a new data value with the same featureValues as this data
		// value.
		CompoundValue newValue = (CompoundValue) (super.copy());
		List<IFeatureValue> featureValues = this.featureValues;
		for (int i = 0; i < featureValues.size(); i++) {
			IFeatureValue featureValue = featureValues.get(i);
			newValue.featureValues.add(featureValue.copy());
		}
		return newValue;
	}

	@Override
	public IFeatureValue getFeatureValue(StructuralFeature feature) {
		// Get the value(s) of the member of featureValues for the given
		// feature.
		IFeatureValue featureValue = null;
		int i = 1;
		while (featureValue == null & i <= this.featureValues.size()) {
			if (this.featureValues.get(i - 1).getFeature() == feature) {
				featureValue = this.featureValues.get(i - 1);
			}
			i = i + 1;
		}
		return featureValue;
	}

	@Override
	public void setFeatureValue(StructuralFeature feature, List<IValue> values, Integer position) {
		// Set the value(s) of the member of featureValues for the given
		// feature.
		IFeatureValue featureValue = this.getFeatureValue(feature);
		if (featureValue == null) {
			featureValue = new FeatureValue();
			this.featureValues.add(featureValue);
		}
		featureValue.setFeature(feature);
		featureValue.setValues(values);
		featureValue.setPosition(position);
	}

	@Override
	public List<IFeatureValue> getFeatureValues() {
		// Return the feature values for this compound value.
		return this.featureValues;
	}

	@Override
	public String toString() {
		// Issue FUML12-33 Extensional values should have an unique identifier
		String buffer = "(";
		List<Classifier> types = this.getTypes();
		int i = 1;
		while (i <= types.size()) {
			if (i != 1) {
				buffer = buffer + " ";
			}
			buffer = buffer + types.get(i - 1).getName();
			i = i + 1;
		}
		int k = 1;
		while (k <= this.featureValues.size()) {
			IFeatureValue featureValue = this.featureValues.get(k - 1);
			buffer = buffer + "\n\t\t" + featureValue.getFeature().getName() + "[" + featureValue.getPosition() + "]  =";
			int j = 1;
			while (j <= featureValue.getValues().size()) {
				IValue value = featureValue.getValues().get(j - 1);
				if (value instanceof IReference) {
					IObject_ object = ((IReference) value).getReferent();
					buffer = buffer + " Reference to " + object.getIdentifier() + "(";
					types = object.getTypes();
					int n = 1;
					while (n <= types.size()) {
						if (n != 1) {
							buffer = buffer + " ";
						}
						buffer = buffer + types.get(n - 1).getName();
						n = n + 1;
					}
					buffer = buffer + ")";
				} else {
					buffer = buffer + " " + value.toString();
				}
				j = j + 1;
			}
			k = k + 1;
		}
		return buffer + ")";
	}

	public void setFeatureValues(List<IFeatureValue> featureValues) {
		this.featureValues = featureValues;
	}
}
