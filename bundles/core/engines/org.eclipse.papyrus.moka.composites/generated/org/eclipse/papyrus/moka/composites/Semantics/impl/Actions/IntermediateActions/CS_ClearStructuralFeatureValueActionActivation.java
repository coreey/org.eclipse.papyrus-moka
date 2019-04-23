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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_Link;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_Reference;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.Actions.IntermediateActions.ICS_ClearStructuralFeatureValueActionActivation;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_InteractionPoint;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Link;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IExtensionalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.ILink;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IStructuredValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions.ClearStructuralFeatureActionActivation;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.ClearStructuralFeatureAction;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.StructuralFeature;

public class CS_ClearStructuralFeatureValueActionActivation extends ClearStructuralFeatureActionActivation implements ICS_ClearStructuralFeatureValueActionActivation {

	@Override
	public void doAction() {
		// Get the value of the object input pin.
		// If the given feature is an association end, then
		// destroy all links that have the object input on the opposite end.
		// Otherwise, if the object input is a structured value, then
		// set the appropriate feature of the input value to be empty.
		ClearStructuralFeatureAction action = (ClearStructuralFeatureAction) (this.node);
		StructuralFeature feature = action.getStructuralFeature();
		Association association = this.getAssociation(feature);
		IValue value = this.takeTokens(action.getObject()).get(0);
		if (association != null) {
			List<ILink> links = this.getMatchingLinks(association, feature, value);
			for (int i = 0; i < links.size(); i++) {
				ILink link = links.get(i);
				link.destroy();
			}
		} else if (value instanceof IStructuredValue) {
			// If the value is a data value, then it must be copied before
			// any change is made.
			if (!(value instanceof IReference)) {
				value = value.copy();
			} else {
				// extension to fUML
				List<ICS_Link> linksToDestroy = this.getLinksToDestroy((IStructuredValue) value, feature);
				for (int i = 0; i < linksToDestroy.size(); i++) {
					linksToDestroy.get(i).destroy();
				}
				//
			}
			((IStructuredValue) value).setFeatureValue(action.getStructuralFeature(), new ArrayList<IValue>(), 0);
		}
		if (action.getResult() != null) {
			this.putToken(action.getResult(), value);
		}
	}

	public List<ICS_Link> getLinksToDestroy(IStructuredValue value, StructuralFeature feature) {
		List<ICS_Link> linksToDestroy = new ArrayList<ICS_Link>();
		if (value instanceof CS_Reference) {
			ICS_Reference context = (CS_Reference) value;
			// Retrieves the feature values for the structural feature associated with this action,
			// in the context of this reference
			IFeatureValue featureValue = context.getFeatureValue(feature);
			if (feature instanceof Port) {
				// all values are interaction points
				// any link targeting this interaction point must be destroyed
				for (int i = 0; i < featureValue.getValues().size(); i++) {
					ICS_InteractionPoint interactionPoint = (ICS_InteractionPoint) featureValue.getValues().get(i);
					List<ICS_Link> connectorInstances = context.getCompositeReferent().getLinks(interactionPoint);
					for (int j = 0; j < connectorInstances.size(); j++) {
						ICS_Link link = connectorInstances.get(j);
						linksToDestroy.add(link);
					}
				}
			} else { // feature is an attribute
						// Retrieve all potential link ends,
						// separating potential link ends corresponding to the given feature,
						// and potential link ends corresponding to other features.
						// By "potential link ends", we refer to the values of a given feature,
						// as well as interaction points associated with this value, if any.
				List<IValue> allValuesForFeature = new ArrayList<IValue>();
				List<IValue> allOtherValues = new ArrayList<IValue>();
				for (int i = 0; i < context.getReferent().getFeatureValues().size(); i++) {
					StructuralFeature currentFeature = context.getReferent().getFeatureValues().get(i).getFeature();
					List<IValue> values = this.getPotentialLinkEnds(context, currentFeature);
					for (int j = 0; j < values.size(); j++) {
						IValue v = values.get(j);
						if (currentFeature != feature) {
							allOtherValues.add(v);
						} else {
							allValuesForFeature.add(v);
						}
					}
				}
				// Retrieves all links available at the locus
				List<IExtensionalValue> extensionalValues = this.getExecutionLocus().getExtensionalValues();
				List<CS_Link> allLinks = new ArrayList<CS_Link>();
				for (int i = 0; i < extensionalValues.size(); i++) {
					IExtensionalValue extensionalValue = extensionalValues.get(i);
					if (extensionalValue instanceof CS_Link) {
						allLinks.add((CS_Link) extensionalValue);
					}
				}
				// Retrieves links representing connector instances in the context object
				for (int i = 0; i < allLinks.size(); i++) {
					ICS_Link link = allLinks.get(i);
					boolean linkHasToBeDestroyed = false;
					for (int j = 0; j < allValuesForFeature.size() && !linkHasToBeDestroyed; j++) {
						IValue v = allValuesForFeature.get(j);
						StructuralFeature featureForV = link.getFeature(v);
						if (featureForV != null) {
							// Check if feature values of this link for other features
							// contains elements identified in allOtherValue
							for (int k = 0; k < link.getFeatureValues().size() && !linkHasToBeDestroyed; k++) {
								IFeatureValue otherFeatureValue = link.getFeatureValues().get(k);
								if (otherFeatureValue.getFeature() != featureForV) {
									for (int l = 0; l < otherFeatureValue.getValues().size() && !linkHasToBeDestroyed; l++) {
										for (int m = 0; m < allOtherValues.size() && !linkHasToBeDestroyed; m++) {
											if (otherFeatureValue.getValues().get(l) == allOtherValues.get(m)) {
												linkHasToBeDestroyed = true;
											}
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
				for (int j = 0; j < ((CS_Reference) v).getReferent().getFeatureValues().size(); j++) {
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
