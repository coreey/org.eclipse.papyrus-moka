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
 *  Jeremie Tatibouet (CEA LIST) - Apply fix for Issue FUML12-20 Feature values need to be created for private structural features of parent classifiers
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IStructuredValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;

public abstract class StructuredValue extends Value implements IStructuredValue {

	@Override
	public ValueSpecification specify() {
		// Return an instance value that specifies this structured value.
		// Debug.println("[specify] StructuredValue...");
		InstanceValue instanceValue = UMLFactory.eINSTANCE.createInstanceValue();
		InstanceSpecification instance = UMLFactory.eINSTANCE.createInstanceSpecification();
		instanceValue.setType(null);
		instanceValue.setInstance(instance);
		instance.getClassifiers().addAll(this.getTypes());
		List<IFeatureValue> featureValues = this.getFeatureValues();
		// Debug.println("[specify] " + featureValues.size() + " feature(s).");
		for (int i = 0; i < featureValues.size(); i++) {
			IFeatureValue featureValue = featureValues.get(i);
			Slot slot = UMLFactory.eINSTANCE.createSlot();
			slot.setDefiningFeature(featureValue.getFeature());
			// Debug.println("[specify] feature = " + featureValue.feature.name
			// + ", " + featureValue.values.size() + " value(s).");
			List<IValue> values = featureValue.getValues();
			for (int j = 0; j < values.size(); j++) {
				IValue value = values.get(j);
				// Debug.println("[specify] value = " + value);
				slot.getValues().add(value.specify());
			}
			instance.getSlots().add(slot);
		}
		return instanceValue;
	}

	public void addFeatureValues(List<IFeatureValue> oldFeatureValues) {
		// Issue FUML12-20 Feature values need to be created for private structural features of parent classifiers

		// Add feature values for all structural features of the types
		// of this structured value and all its supertypes (including private
		// features that are not inherited). If a feature has an old feature
		// value in the given list, then use that to initialize the values of
		// the corresponding new feature value. Otherwise leave the values of
		// the new feature value empty.
		List<Classifier> types = this.getTypes();
		for (int i = 0; i < types.size(); i++) {
			Classifier type = types.get(i);
			this.addFeatureValuesForType(type, oldFeatureValues);
		}
	}

	public void addFeatureValuesForType(Classifier type, List<IFeatureValue> oldFeatureValues) {
		// Issue FUML12-20 Feature values need to be created for private structural features of parent classifiers

		// Add feature values for all structural features of the given type and
		// all of its supertypes (including private features that are not
		// inherited). If a feature has an old feature value in the given list,
		// then use that to initialize the values of the corresponding new
		// feature value. Otherwise leave the values of the new feature value
		// empty.
		// Set feature values for the owned structural features of the given
		// type. (Any common structural values that have already been added
		// previously will simply have their values set again.)
		List<NamedElement> ownedMembers = type.getOwnedMembers();
		for (int j = 0; j < ownedMembers.size(); j++) {
			NamedElement ownedMember = ownedMembers.get(j);
			if (ownedMember instanceof StructuralFeature) {
				this.setFeatureValue((StructuralFeature) ownedMember, this.getValues(ownedMember, oldFeatureValues), 0);
			}
		}
		// Add feature values for the structural features of the supertypes
		// of the given type. (Note that the feature values for supertype
		// features always come after the feature values for owned features.)
		List<Classifier> supertypes = type.getGenerals();
		for (int i = 0; i < supertypes.size(); i++) {
			Classifier supertype = supertypes.get(i);
			this.addFeatureValuesForType(supertype, oldFeatureValues);
		}
	}

	public void createFeatureValues() {
		// Issue FUML12-20 Feature values need to be created for private structural features of parent classifiers

		// Create empty feature values for all structural features of the types
		// of this structured value and all its supertypes (including private
		// features that are not inherited).
		this.addFeatureValues(new ArrayList<IFeatureValue>());
	}

	public List<IFeatureValue> getMemberValues() {
		// Issue FUML12-20 Feature values need to be created for private structural features of parent classifiers

		// Return the feature values for this structured value that are for structural
		// features that are members of one of the types of the structured value.
		// (That is, they are owned are inherited, excluding private features of
		// supertypes that are not inherited.)
		List<IFeatureValue> featureValues = this.getFeatureValues();
		List<IFeatureValue> memberValues = new ArrayList<IFeatureValue>();
		List<Classifier> types = this.getTypes();
		for (int i = 0; i < featureValues.size(); i++) {
			IFeatureValue featureValue = featureValues.get(i);
			Boolean isMember = false;
			int j = 1;
			while (j <= types.size() & !isMember) {
				Classifier type = types.get(j - 1);
				List<NamedElement> members = type.getMembers();
				int k = 1;
				while (k <= members.size() & !isMember) {
					NamedElement member = members.get(k - 1);
					isMember = featureValue.getFeature() == member;
					k = k + 1;
				}
				j = j + 1;
			}
			if (isMember) {
				memberValues.add(featureValue);
			}
		}
		return memberValues;
	}

	public List<IValue> getValues(NamedElement feature, List<IFeatureValue> featureValues) {
		// Issue FUML12-20 Feature values need to be created for private structural features of parent classifiers

		// Return the values from the feature value in the given list for the
		// given feature. If there is no such feature value, return an empty
		// list.
		IFeatureValue foundFeatureValue = null;
		int i = 1;
		while (foundFeatureValue == null & i <= featureValues.size()) {
			IFeatureValue featureValue = featureValues.get(i - 1);
			if (featureValue.getFeature() == feature) {
				foundFeatureValue = featureValue;
			}
			i = i + 1;
		}
		List<IValue> values;
		if (foundFeatureValue == null) {
			values = new ArrayList<IValue>();
		} else {
			values = foundFeatureValue.getValues();
		}
		return values;
	}

	public abstract IFeatureValue getFeatureValue(StructuralFeature feature);

	public abstract void setFeatureValue(StructuralFeature feature, List<IValue> values, Integer position);

	public abstract List<IFeatureValue> getFeatureValues();
}
