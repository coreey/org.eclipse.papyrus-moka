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
 *  Jeremie Tatibouet (CEA LIST) - Apply fix for FUML12-33 Extensional values should have an unique identifier
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IExtensionalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.ILink;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Property;

public class Link extends ExtensionalValue implements ILink {

	/*
	 * The type of this link.
	 */
	public Association type;

	@Override
	public void destroy() {
		// Remove the type of this link and destroy it.
		// Shift the positions of the feature values of any remaining links in
		// the extent of the same association, for ends that are ordered.

		// Issue FUML12-33 Extensional values should have an unique identifier

		List<Property> ends = this.type.getMemberEnds();
		List<IExtensionalValue> extent = this.locus.getExtent(this.type);
		for (int i = 0; i < extent.size(); i++) {
			IExtensionalValue otherLink = extent.get(i);
			for (int j = 0; j < ends.size(); j++) {
				Property end = ends.get(j);
				if (end.isOrdered()) {
					IFeatureValue featureValue = otherLink.getFeatureValue(end);
					if (this.getFeatureValue(end).getPosition() < featureValue.getPosition()) {
						featureValue.setPosition(featureValue.getPosition() - 1);
					}
				}
			}
		}
		this.type = null;
		super.destroy();
	}

	@Override
	public Value copy() {
		// Create a new link with the same type, locus and feature values as
		// this link.
		Link newValue = (Link) (super.copy());
		newValue.type = this.type;
		return newValue;
	}

	@Override
	public Value new_() {
		// Create a new link with no type or properies.
		return new Link();
	}

	@Override
	public List<Classifier> getTypes() {
		// Return the single type of this link (if any).
		List<Classifier> types = null;
		if (this.type == null) {
			types = new ArrayList<Classifier>();
		} else {
			types = new ArrayList<Classifier>();
			types.add(this.type);
		}
		return types;
	}

	public Boolean isMatchingLink(IExtensionalValue link, Property end) {
		// Test whether the given link matches the values of this link on all
		// ends other than the given end.
		List<Property> ends = this.type.getMemberEnds();
		boolean matches = true;
		int i = 1;
		while (matches & i <= ends.size()) {
			Property otherEnd = ends.get(i - 1);
			if (otherEnd != end && !this.getFeatureValue(otherEnd).getValues().isEmpty() && !link.getFeatureValue(otherEnd).getValues().isEmpty() && !this.getFeatureValue(otherEnd).getValues().get(0).equals(link.getFeatureValue(otherEnd).getValues().get(0))) {
				matches = false;
			}
			i = i + 1;
		}
		return matches;
	}

	public List<IFeatureValue> getOtherFeatureValues(List<IExtensionalValue> extent, Property end) {
		// Return all feature values for the given end of links in the given
		// extent whose other ends match this link.
		List<IFeatureValue> featureValues = new ArrayList<IFeatureValue>();
		for (int i = 0; i < extent.size(); i++) {
			IExtensionalValue link = extent.get(i);
			if (link != this) {
				if (isMatchingLink(link, end)) {
					featureValues.add(link.getFeatureValue(end));
				}
			}
		}
		return featureValues;
	}

	public void addTo(ILocus locus) {
		// Add this link to the extent of its association at the given locus.
		// Shift the positions of ends of other links, as appropriate, for ends
		// that are ordered.

		// Issue FUML12-33 Extensional values should have an unique identifier

		List<Property> ends = this.type.getMemberEnds();
		List<IExtensionalValue> extent = locus.getExtent(this.type);
		for (int i = 0; i < ends.size(); i++) {
			Property end = ends.get(i);
			if (end.isOrdered()) {
				IFeatureValue featureValue = this.getFeatureValue(end);
				List<IFeatureValue> otherFeatureValues = this.getOtherFeatureValues(extent, end);
				int n = otherFeatureValues.size();
				if (featureValue.getPosition() < 0 | featureValue.getPosition() > n) {
					featureValue.setPosition(n + 1);
				} else {
					if (featureValue.getPosition() == 0) {
						featureValue.setPosition(1);
					}
					for (int j = 0; j < otherFeatureValues.size(); j++) {
						IFeatureValue otherFeatureValue = otherFeatureValues.get(j);
						if (featureValue.getPosition() <= otherFeatureValue.getPosition()) {
							otherFeatureValue.setPosition(otherFeatureValue.getPosition() + 1);
						}
					}
				}
			}
		}
		locus.add(this);
	}

	public void setType(Association association) {
		this.type = association;
	}

	public Association getType() {
		return this.type;
	}
}
