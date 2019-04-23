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
package org.eclipse.papyrus.moka.composites.Semantics.impl.Actions.IntermediateActions;

// Imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_InteractionPoint;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_Link;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_Reference;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_InteractionPoint;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Link;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.ILink;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IStructuredValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions.AddStructuralFeatureValueActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.UnlimitedNaturalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1.ChoiceStrategy;
import org.eclipse.uml2.uml.AddStructuralFeatureValueAction;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuralFeature;


public class CS_AddStructuralFeatureValueActionActivation extends AddStructuralFeatureValueActionActivation {

	@Override
	public void doAction() {
		// If the feature is a port and the input value to be added is a
		// Reference,
		// Replaces this Reference by an InteractionPoint, and then behaves
		// as usual.
		// If the feature is not a port, behaves as usual

		AddStructuralFeatureValueAction action = (AddStructuralFeatureValueAction) (this.node);
		StructuralFeature feature = action.getStructuralFeature();

		if (!(feature instanceof Port)) {
			// Behaves as usual
			this.doActionDefault();
		} else {
			List<IValue> inputValues = this.takeTokens(action.getValue());
			// NOTE: Multiplicity of the value input pin is required to be 1..1.
			IValue inputValue = inputValues.get(0);
			if (inputValue instanceof IReference) {
				// First constructs an InteractionPoint from the inputValue
				IReference reference = (IReference) inputValue;
				ICS_InteractionPoint interactionPoint = new CS_InteractionPoint();
				interactionPoint.setReferent(reference.getReferent());
				interactionPoint.setDefiningPort((Port) feature);
				// The value on action.object is necessarily instanceof
				// ReferenceToCompositeStructure (otherwise, the feature cannot
				// be a port)
				ICS_Reference owner = (CS_Reference) this.takeTokens(action.getObject()).get(0);
				interactionPoint.setOwner(owner);
				// Then replaces the Reference by an InteractionPoint
				// in the inputValues
				inputValues.remove(0);
				inputValues.add(0, interactionPoint);
				// Finally concludes with usual fUML behavior of
				// AddStructuralFeatureValueAction (i.e., the usual behavior
				// when
				// the value on action.object pin is a StructuredValue)
				Integer insertAt = 0;
				if (action.getInsertAt() != null) {
					insertAt = ((UnlimitedNaturalValue) this.takeTokens(action.getInsertAt()).get(0)).value;
				}
				if (action.isReplaceAll()) {
					owner.setFeatureValue(feature, inputValues, 0);
				} else {
					IFeatureValue featureValue = owner.getFeatureValue(feature);

					if (featureValue.getValues().size() > 0 & insertAt == 0) {
						// If there is no insertAt pin, then the structural
						// feature must
						// be unordered, and the insertion position is
						// immaterial.
						insertAt = ((ChoiceStrategy) this.getExecutionLocus().getFactory().getStrategy("choice")).choose(featureValue.getValues().size());
					}
					if (feature.isUnique()) {
						// Remove any existing value that duplicates the input
						// value
						Integer j = position(interactionPoint, featureValue.getValues(), 1);
						if (j > 0) {
							featureValue.getValues().remove(j - 1);
							if (insertAt > 0 & j < insertAt) {
								insertAt = insertAt - 1;
							}
						}
					}

					if (insertAt <= 0) {
						// Note: insertAt = -1 indicates an unlimited value of
						// "*"
						featureValue.getValues().add(interactionPoint);
					} else {
						featureValue.getValues().add(insertAt - 1, interactionPoint);
					}
				}
				if (action.getResult() != null) {
					this.putToken(action.getResult(), owner);
				}
			} else {
				// behaves as usual
				this.doActionDefault();
			}
		}
	}

	public void doActionDefault() {
		// Get the values of the object and value input pins.
		// If the given feature is an association end, then create a link
		// between the object and value inputs.
		// Otherwise, if the object input is a structural value, then add a
		// value to the values for the feature.
		// If isReplaceAll is true, first remove all current matching links or
		// feature values.
		// If isReplaceAll is false and there is an insertAt pin, insert the
		// value at the appropriate position.
		// This operation captures same semantics as fUML
		// AddStructuralFeatureValueActionActivation.doAction(), except that
		// when the feature is an association end, a CS_Link will be created instead
		// of a Link

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
				position = -1;
			}

			if (action.isReplaceAll()) {
				for (int i = 0; i < links.size(); i++) {
					ILink link = links.get(i);
					link.destroy();
				}
			} else if (feature.isUnique()) {
				for (int i = 0; i < links.size(); i++) {
					ILink link = links.get(i);
					IFeatureValue featureValue = link.getFeatureValue(feature);
					if (featureValue.getValues().get(0).equals(inputValue)) {
						position = link.getFeatureValue(oppositeEnd).getPosition();
						if (insertAt > 0 & featureValue.getPosition() < insertAt) {
							insertAt = insertAt - 1;
						}
						link.destroy();
					}
				}
			}

			ICS_Link newLink = new CS_Link();
			newLink.setType(association);

			// This necessary when setting a feature value with an insertAt
			// position
			newLink.setLocus(this.getExecutionLocus());

			newLink.setFeatureValue(feature, inputValues, insertAt);

			List<IValue> oppositeValues = new ArrayList<IValue>();
			oppositeValues.add(value);
			newLink.setFeatureValue(oppositeEnd, oppositeValues, position);

			newLink.getLocus().add(newLink);

		} else if (value instanceof IStructuredValue) {
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
						if (insertAt > 0 & j < insertAt) {
							insertAt = insertAt - 1;
						}
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
