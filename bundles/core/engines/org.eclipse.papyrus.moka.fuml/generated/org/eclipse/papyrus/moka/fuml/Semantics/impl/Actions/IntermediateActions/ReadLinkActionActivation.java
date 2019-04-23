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

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IExtensionalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.ILink;
import org.eclipse.uml2.uml.LinkEndData;
import org.eclipse.uml2.uml.ReadLinkAction;

public class ReadLinkActionActivation extends LinkActionActivation {

	@Override
	public void doAction() {
		// Get the extent, at the current execution locus, of the association to
		// which the action applies.
		// For all links that match the link end data, place the value of the
		// remaining "open" end on the result pin.
		ReadLinkAction action = (ReadLinkAction) (this.node);
		List<LinkEndData> endDataList = action.getEndData();
		LinkEndData openEnd = null;
		int i = 1;
		while ((openEnd == null) & i <= endDataList.size()) {
			if (endDataList.get(i - 1).getValue() == null) {
				openEnd = endDataList.get(i - 1);
			}
			i = i + 1;
		}
		List<IExtensionalValue> extent = this.getExecutionLocus().getExtent(this.getAssociation());
		List<IFeatureValue> featureValues = new ArrayList<IFeatureValue>();
		for (int j = 0; j < extent.size(); j++) {
			IExtensionalValue value = extent.get(j);
			ILink link = (ILink) value;
			if (this.linkMatchesEndData(link, endDataList)) {
				IFeatureValue featureValue = link.getFeatureValue(openEnd.getEnd());
				if (!openEnd.getEnd().isOrdered() | featureValues.size() == 0) {
					featureValues.add(featureValue);
				} else {
					int n = featureValue.getPosition();
					boolean continueSearching = true;
					int k = 0;
					while (continueSearching & k < featureValues.size()) {
						k = k + 1;
						continueSearching = featureValues.get(k - 1).getPosition() < n;
					}
					if (continueSearching) {
						featureValues.add(featureValue);
					} else {
						featureValues.add(k - 1, featureValue);
					}
				}
			}
		}
		for (int j = 0; j < featureValues.size(); j++) {
			IFeatureValue featureValue = featureValues.get(j);
			this.putToken(action.getResult(), featureValue.getValues().get(0));
		}
		// Now that matching is done, ensure that all tokens on end data input
		// pins
		// are consumed.
		for (int k = 0; k < endDataList.size(); k++) {
			LinkEndData endData = endDataList.get(k);
			if (endData.getValue() != null) {
				this.takeTokens(endData.getValue());
			}
		}
	}
}
