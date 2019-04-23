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
 *  Jeremie Tatibouet (CEA LIST) - Issue FUML12-23 RemoveStructuralFeatureValueAction: Removal of links does not consider provided input value
 *  Jeremie Tatibouet (CEA LIST) - Issue FUML12-24 RemoveStructuralFeatureValueAction: Removing links with specified remove at value works incorrectly
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
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.UnlimitedNaturalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1.ChoiceStrategy;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.RemoveStructuralFeatureValueAction;
import org.eclipse.uml2.uml.StructuralFeature;

public class RemoveStructuralFeatureValueActionActivation extends WriteStructuralFeatureActionActivation {

	@Override
	public void doAction() {
		// Get the values of the object and value input pins.
		// If the given feature is an association end, then destroy any matching
		// links.
		// Otherwise, if the object input is a structural value, remove values
		// from the given feature.
		// If isRemoveDuplicates is true, then destroy all current matching
		// links or remove all values equal to the input value.
		// If isRemoveDuplicates is false and there is no removeAt input pin,
		// remove any one feature value equal to the input value (if there are
		// any that are equal).
		// If isRemoveDuplicates is false, and there is a removeAt input pin
		// remove the feature value at that position.
		RemoveStructuralFeatureValueAction action = (RemoveStructuralFeatureValueAction) (this.node);
		StructuralFeature feature = action.getStructuralFeature();
		Association association = this.getAssociation(feature);
		IValue value = this.takeTokens(action.getObject()).get(0);
		IValue inputValue = null;
		if (action.getValue() != null) {
			// NOTE: Multiplicity of the value input pin is required to be 1..1.
			inputValue = this.takeTokens(action.getValue()).get(0);
		}
		int removeAt = 0;
		if (action.getRemoveAt() != null) {
			removeAt = ((UnlimitedNaturalValue) this.takeTokens(action.getRemoveAt()).get(0)).value;
		}
		if (association != null) {
			List<ILink> links = this.getMatchingLinksForEndValue(association, feature, value, inputValue); // FUML12-23 RemoveStructuralFeatureValueAction: Removal of links does not consider provided input value
			if (action.isRemoveDuplicates()) {
				for (int i = 0; i < links.size(); i++) {
					ILink link = links.get(i);
					link.destroy();
				}
			} else if (action.getRemoveAt() == null) {
				// *** If there is more than one matching link,
				// non-deterministically choose one. ***
				if (links.size() > 0) {
					int i = ((ChoiceStrategy) this.getExecutionLocus().getFactory().getStrategy("choice")).choose(links.size());
					links.get(i - 1).destroy();
				}
			} else {
				boolean notFound = true;
				int i = 1;
				while (notFound & i <= links.size()) { // FUML12-24 RemoveStructuralFeatureValueAction: Removing links with specified remove at value works incorrectly
					ILink link = links.get(i - 1);
					if (link.getFeatureValue(feature).getPosition() == removeAt) {
						notFound = false;
						link.destroy();
					}
				}
			}
		} else if (value instanceof IStructuredValue) {
			// If the value is a data value, then it must be copied before
			// any change is made.
			if (!(value instanceof IReference)) {
				value = value.copy();
			}
			IFeatureValue featureValue = ((IStructuredValue) value).getFeatureValue(action.getStructuralFeature());
			if (action.isRemoveDuplicates()) {
				int j = this.position(inputValue, featureValue.getValues(), 1);
				while (j > 0) {
					featureValue.getValues().remove(j - 1);
					j = this.position(inputValue, featureValue.getValues(), j);
				}
			} else if (action.getRemoveAt() == null) {
				List<Integer> positions = new ArrayList<Integer>();
				int j = this.position(inputValue, featureValue.getValues(), 1);
				while (j > 0) {
					positions.add(j);
					j = this.position(inputValue, featureValue.getValues(), j);
				}
				if (positions.size() > 0) {
					// *** Nondeterministically choose which value to remove.
					// ***
					int k = ((ChoiceStrategy) this.getExecutionLocus().getFactory().getStrategy("choice")).choose(positions.size());
					featureValue.getValues().remove(positions.get(k - 1) - 1);
				}
			} else {
				if (featureValue.getValues().size() >= removeAt) {
					featureValue.getValues().remove(removeAt - 1);
				}
			}
		}
		if (action.getResult() != null) {
			this.putToken(action.getResult(), value);
		}
	}
}
