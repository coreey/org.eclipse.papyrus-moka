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
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.ILink;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IStructuredValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Link;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.UnlimitedNaturalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1.ChoiceStrategy;
import org.eclipse.uml2.uml.AddStructuralFeatureValueAction;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuralFeature;

public class AddStructuralFeatureValueActionActivation extends WriteStructuralFeatureActionActivation {

	@Override
	public void doAction() {
		// Get the values of the object and value input pins.
		// If the given feature is an association end, then create a link
		// between the object and value inputs.
		// Otherwise, if the object input is a structural value, then add a
		// value to the values for the feature.
		// If isReplaceAll is true, first remove all current matching links or
		// feature values.
		// If isReplaceAll is false and there is an insertAt pin, insert the
		// value at the appropriate position.
		AddStructuralFeatureValueAction action = (AddStructuralFeatureValueAction) (this.node);
		StructuralFeature feature = action.getStructuralFeature();
		Association association = this.getAssociation(feature);
		IValue value = this.takeTokens(action.getObject()).get(0);
		List<IValue> inputValues = this.takeTokens(action.getValue());
		// NOTE: Multiplicity of the value input pin is required to be 1..1.
		IValue inputValue = inputValues.get(0);
		int insertAt = 0;
		if (action.getInsertAt() != null) {
			insertAt = ((UnlimitedNaturalValue) this.takeTokens(action.getInsertAt()).get(0)).value;
		}
		if (association != null) {
			List<ILink> links = this.getMatchingLinks(association, feature, value);
			Property oppositeEnd = this.getOppositeEnd(association, feature);
			int position = 0;
			if (oppositeEnd.isOrdered()) {
				position = this.getMatchingLinks(association, oppositeEnd, inputValue).size() + 1;
			}
			if (action.isReplaceAll()) {
				for (int i = 0; i < links.size(); i++) {
					ILink link = links.get(i);
					link.destroy();
				}
			} else if (feature.isUnique()) {
				int i = 1;
				boolean destroyed = false;
				while (!destroyed & i <= links.size()) {
					ILink link = links.get(i - 1);
					IFeatureValue featureValue = link.getFeatureValue(feature);
					if (featureValue.getValues().get(0).equals(inputValue)) {
						position = link.getFeatureValue(oppositeEnd).getPosition();
						link.destroy();
						destroyed = true;
					}
					i = i + 1;
				}
			}
			ILink newLink = new Link();
			newLink.setType(association);
			newLink.setFeatureValue(feature, inputValues, insertAt);
			List<IValue> oppositeValues = new ArrayList<IValue>();
			oppositeValues.add(value);
			newLink.setFeatureValue(oppositeEnd, oppositeValues, position);
			newLink.addTo(this.getExecutionLocus());
		} else if (value instanceof IStructuredValue) {
			// If the value is a data value, then it must be copied before
			// any change is made.
			if (!(value instanceof IReference)) {
				value = value.copy();
			}
			IStructuredValue structuredValue = (IStructuredValue) value;
			if (action.isReplaceAll()) {
				structuredValue.setFeatureValue(feature, inputValues, 0);
			} else {
				IFeatureValue featureValue = structuredValue.getFeatureValue(feature);
				if (featureValue.getValues().size() > 0 & insertAt == 0) {
					// *** If there is no insertAt pin, then the structural
					// feature must be unordered, and the insertion position is
					// immaterial. ***
					insertAt = ((ChoiceStrategy) this.getExecutionLocus().getFactory().getStrategy("choice")).choose(featureValue.getValues().size());
				}
				if (feature.isUnique()) {
					// Remove any existing value that duplicates the input value
					int j = position(inputValue, featureValue.getValues(), 1);
					if (j > 0) {
						featureValue.getValues().remove(j - 1);
					}
				}
				if (insertAt <= 0) { // Note: insertAt = -1 indicates an
										// unlimited value of "*"
					featureValue.getValues().add(inputValue);
				} else {
					featureValue.getValues().add(insertAt - 1, inputValue);
				}
			}
		}
		if (action.getResult() != null) {
			this.putToken(action.getResult(), value);
		}
	}
}
