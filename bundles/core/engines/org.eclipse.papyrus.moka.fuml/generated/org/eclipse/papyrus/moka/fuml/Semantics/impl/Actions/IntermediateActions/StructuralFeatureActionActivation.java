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
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Actions.IntermediateActions.IStructuralFeatureActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IExtensionalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.ILink;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuralFeature;

public abstract class StructuralFeatureActionActivation extends ActionActivation implements IStructuralFeatureActionActivation {

	public Association getAssociation(StructuralFeature feature) {
		return ((GetAssociationStrategy) this.getExecutionLocus().getFactory().getStrategy("GetAssociationStrategy")).getAssociation(feature);
	}

	public List<ILink> getMatchingLinks(Association association, StructuralFeature end, IValue oppositeValue) {
		// Get the links of the given binary association whose end opposite
		// to the given end has the given value

		// FUML12-23 RemoveStructuralFeatureValueAction: Removal of links does not consider provided input value

		return this.getMatchingLinksForEndValue(association, end, oppositeValue, null);
	}

	public List<ILink> getMatchingLinksForEndValue(Association association, StructuralFeature end, IValue oppositeValue, IValue endValue) {
		// Get the links of the given binary association whose end opposite
		// to the given end has the given opposite value and, optionally, that
		// has a given end value for the given end.

		// FUML12-23 RemoveStructuralFeatureValueAction: Removal of links does not consider provided input value

		Property oppositeEnd = this.getOppositeEnd(association, end);
		List<IExtensionalValue> extent = this.getExecutionLocus().getExtent(association);
		List<ILink> links = new ArrayList<ILink>();
		for (int i = 0; i < extent.size(); i++) {
			IExtensionalValue link = extent.get(i);
			if (link.getFeatureValue(oppositeEnd).getValues().get(0).equals(oppositeValue)) {
				boolean matches = true;
				if (endValue != null) {
					matches = link.getFeatureValue(end).getValues().get(0).equals(endValue);
				}
				if (matches) {
					if (!end.isOrdered() | links.size() == 0) {
						links.add((ILink) link);
					} else {
						int n = link.getFeatureValue(end).getPosition();
						boolean continueSearching = true;
						int j = 0;
						while (continueSearching & j < links.size()) {
							j = j + 1;
							continueSearching = links.get(j - 1).getFeatureValue(end).getPosition() < n;
						}
						if (continueSearching) {
							links.add((ILink) link);
						} else {
							links.add(j - 1, (ILink) link);
						}
					}
				}
			}
		}
		return links;
	}

	public Property getOppositeEnd(Association association, StructuralFeature end) {
		// Get the end of a binary association opposite to the given end.
		Property oppositeEnd = association.getMemberEnds().get(0);
		if (oppositeEnd == end) {
			oppositeEnd = association.getMemberEnds().get(1);
		}
		return oppositeEnd;
	}
}
