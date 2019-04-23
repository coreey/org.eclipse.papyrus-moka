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
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.ILink;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Link;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.UnlimitedNaturalValue;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.CreateLinkAction;
import org.eclipse.uml2.uml.LinkEndCreationData;
import org.eclipse.uml2.uml.LinkEndData;

public class CreateLinkActionActivation extends WriteLinkActionActivation {

	@Override
	public void doAction() {
		// If the association has any unique ends, then destroy an existing link
		// that matches all ends of the link being created.
		// Get the extent at the current execution locus of the association for
		// which a link is being created.
		// Destroy all links that have a value for any end for which
		// isReplaceAll is true.
		// Create a new link for the association, at the current locus, with the
		// given end data values,
		// inserted at the given insertAt position (for ordered ends).
		CreateLinkAction action = (CreateLinkAction) (this.node);
		List<LinkEndCreationData> endDataList = new ArrayList<LinkEndCreationData>();
		for (LinkEndData data : action.getEndData()) {
			endDataList.add((LinkEndCreationData) data);
		}
		Association linkAssociation = this.getAssociation();
		List<IExtensionalValue> extent = this.getExecutionLocus().getExtent(linkAssociation);
		boolean unique = false;
		for (int i = 0; i < endDataList.size(); i++) {
			if (endDataList.get(i).getEnd().isUnique()) {
				unique = true;
			}
		}
		for (int i = 0; i < extent.size(); i++) {
			IExtensionalValue value = extent.get(i);
			ILink link = (ILink) value;
			boolean match = true;
			boolean destroy = false;
			int j = 1;
			while (j <= endDataList.size()) {
				LinkEndCreationData endData = endDataList.get(j - 1);
				if (this.endMatchesEndData(link, endData)) {
					if (endData.isReplaceAll()) {
						destroy = true;
					}
				} else {
					match = false;
				}
				j = j + 1;
			}
			if (destroy | unique & match) {
				link.destroy();
			}
		}
		ILink newLink = new Link();
		newLink.setType(linkAssociation);
		for (int i = 0; i < endDataList.size(); i++) {
			LinkEndCreationData endData = endDataList.get(i);
			int insertAt = 0;
			if (endData.getInsertAt() != null) {
				insertAt = ((UnlimitedNaturalValue) (this.takeTokens(endData.getInsertAt()).get(0))).value;
			}
			newLink.setFeatureValue(endData.getEnd(), this.takeTokens(endData.getValue()), insertAt);
		}
		newLink.addTo(this.getExecutionLocus());
	}
}
