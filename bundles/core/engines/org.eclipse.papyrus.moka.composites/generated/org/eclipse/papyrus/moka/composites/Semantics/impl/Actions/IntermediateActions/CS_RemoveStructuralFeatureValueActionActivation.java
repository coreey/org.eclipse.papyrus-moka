/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.composites.Semantics.impl.Actions.IntermediateActions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_InteractionPoint;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Link;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IExtensionalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.ILink;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IStructuredValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IUnlimitedNaturalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.IChoiceStrategy;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions.RemoveStructuralFeatureValueActionActivation;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.RemoveStructuralFeatureValueAction;
import org.eclipse.uml2.uml.StructuralFeature;

public class CS_RemoveStructuralFeatureValueActionActivation extends RemoveStructuralFeatureValueActionActivation {

	@Override
	public void doAction() {
		// Get the values of the object and value input pins. 
		// If the given feature is an association end, then destroy any
		// matching links. Otherwise, if the object input is a structural
		// value, remove values from the given feature and destroy all links
		// in which the removed values are involved.
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
			removeAt = ((IUnlimitedNaturalValue) this.takeTokens(action.getRemoveAt()).get(0)).getValue();
		}
		if (association != null) {
			List<ILink> links = this.getMatchingLinksForEndValue(association, feature, value, inputValue);
			if (action.isRemoveDuplicates()) {
				for (int i = 0; i < links.size(); i++) {
					ILink link = links.get(i);
					link.destroy();
				}
			} else if (action.getRemoveAt() == null) {
				// *** If there is more than one matching link,
				// non-deterministically choose one. ***
				if (links.size() > 0) {
					int i = ((IChoiceStrategy) this.getExecutionLocus().getFactory().getStrategy("choice")).choose(links.size());
					links.get(i - 1).destroy();
				}
			} else {
				boolean notFound = true;
				int i = 1;
				while (notFound & i <= links.size()) {
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
			List<IValue> removedValues = new ArrayList<IValue>();
			if (action.isRemoveDuplicates()) {
				int j = this.position(inputValue, featureValue.getValues(), 1);
				while (j > 0) {
					removedValues.add(featureValue.getValues().get(j - 1));
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
					int k = ((IChoiceStrategy) this.getExecutionLocus().getFactory().getStrategy("choice")).choose(positions.size());
					removedValues.add(featureValue.getValues().get(positions.get(k - 1) - 1));
					featureValue.getValues().remove(positions.get(k - 1) - 1);
				}
			} else {
				if (featureValue.getValues().size() >= removeAt) {
					removedValues.add(featureValue.getValues().get(removeAt - 1));
					featureValue.getValues().remove(removeAt - 1);
				}
			}
			// When values are removed from the list of values associated to the feature 
			// (in the context of the target), these latter may be involved in links representing
			// instance of connectors. If this is the case, links in which the removed values are
			// involved are destroyed.
			for(int i = 0; i < removedValues.size(); i++){
				List<ICS_Link> linkToDestroy = this.getLinksToDestroy((IStructuredValue)value, feature, removedValues.get(i));
				for(int j = 0; j < linkToDestroy.size(); j++){
					linkToDestroy.get(j).destroy();
				}
			}
		}
		if (action.getResult() != null) {
			this.putToken(action.getResult(), value);
		}
	}
	
	public List<ICS_Link> getLinksToDestroy(IStructuredValue value, StructuralFeature feature, IValue removedValue) {
		// Get all links that are required to be destroyed due to the removal of the removedValue
		List<ICS_Link> linksToDestroy = new ArrayList<ICS_Link>();
		if (value instanceof ICS_Reference) {
			ICS_Reference context = (ICS_Reference) value;
			// Retrieves the feature values for the structural feature associated with this action,
			// in the context of this reference
			if (feature instanceof Port) {
				// The removed value is an interaction point.
				// All links in which this interaction is involved must be destroyed.
				ICS_InteractionPoint interactionPoint = (ICS_InteractionPoint) removedValue;
				List<ICS_Link> connectorInstances = context.getCompositeReferent().getLinks(interactionPoint);
				for (int j = 0; j < connectorInstances.size(); j++) {
					ICS_Link link = connectorInstances.get(j);
					linksToDestroy.add(link);
				}
			} else { 
				// Feature is not a Port. Search for all potential link
				// ends existing in the context of this object.
				List<IValue> allValuesForFeature = new ArrayList<IValue>();
				for (int i = 0; i < context.getReferent().getFeatureValues().size(); i++) {
					StructuralFeature currentFeature = context.getReferent().getFeatureValues().get(i).getFeature();
					if(feature != currentFeature){
						List<IValue> values = this.getPotentialLinkEnds(context, currentFeature);
						for (int j = 0; j < values.size(); j++) {
							allValuesForFeature.add(values.get(j));
						}
					}
				}
				// Retrieves all links available at the locus
				List<IExtensionalValue> extensionalValues = this.getExecutionLocus().getExtensionalValues();
				List<ICS_Link> allLinks = new ArrayList<ICS_Link>();
				for (int i = 0; i < extensionalValues.size(); i++) {
					IExtensionalValue extensionalValue = extensionalValues.get(i);
					if (extensionalValue instanceof ICS_Link) {
						allLinks.add((ICS_Link) extensionalValue);
					}
				}
				// In the set of links involving potential link ends. Search for all
				// links that involve the removed value in other end. Any link in that
				// fulfill this condition is registered in the set of link to be destroyed.
				for (int i = 0; i < allLinks.size(); i++) {
					ICS_Link link = allLinks.get(i);
					boolean linkHasToBeDestroyed = false;
					for (int j = 0; j < allValuesForFeature.size() && !linkHasToBeDestroyed; j++) {
						IValue v = allValuesForFeature.get(j);
						StructuralFeature featureForV = link.getFeature(v);
						if (featureForV != null) {
							for (int k = 0; k < link.getFeatureValues().size() && !linkHasToBeDestroyed; k++) {
								IFeatureValue otherFeatureValue = link.getFeatureValues().get(k);
								if (otherFeatureValue.getFeature() != featureForV) {
									for (int l = 0; l < otherFeatureValue.getValues().size() && !linkHasToBeDestroyed; l++) {
										if(otherFeatureValue.getValues().get(l) == removedValue){
											linkHasToBeDestroyed = true;
										}
									}
								}
							}
						}
					}
					if (linkHasToBeDestroyed) {
						linksToDestroy.add(link);
					}
				}
			}
		}
		return linksToDestroy;
	}
	
	public List<IValue> getPotentialLinkEnds(ICS_Reference context, StructuralFeature feature) {
		// Retrieves all feature values for the context object for the given feature,
		// as well as all interaction point for these values
		List<IValue> potentialLinkEnds = new ArrayList<IValue>();
		IFeatureValue featureValue = context.getFeatureValue(feature);
		for (int i = 0; i < featureValue.getValues().size(); i++) {
			IValue v = featureValue.getValues().get(i);
			potentialLinkEnds.add(v);
			if (v instanceof ICS_Reference) {
				// add all interaction points associated with v
				for (int j = 0; j < ((ICS_Reference) v).getReferent().getFeatureValues().size(); j++) {
					if (((ICS_Reference) v).getReferent().getFeatureValues().get(j).getFeature() instanceof Port) {
						List<IValue> interactionPoints = (((ICS_Reference) v).getReferent().getFeatureValues().get(j)).getValues();
						for (int k = 0; k < interactionPoints.size(); k++) {
							potentialLinkEnds.add(interactionPoints.get(k));
						}
					}
				}
			}
		}
		return potentialLinkEnds;
	}
	
}