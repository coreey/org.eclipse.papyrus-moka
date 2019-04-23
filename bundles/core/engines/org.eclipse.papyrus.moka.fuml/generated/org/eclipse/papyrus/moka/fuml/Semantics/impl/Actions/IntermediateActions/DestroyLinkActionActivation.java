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
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1.ChoiceStrategy;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.uml2.uml.DestroyLinkAction;
import org.eclipse.uml2.uml.LinkEndData;
import org.eclipse.uml2.uml.LinkEndDestructionData;
import org.eclipse.uml2.uml.Property;

public class DestroyLinkActionActivation extends WriteLinkActionActivation {

	@Override
	public void doAction() {
		// Get the extent, at the current execution locus, of the association
		// for which links are being destroyed.
		// Destroy all links that match the given link end destruction data.
		// For unique ends, or non-unique ends for which isDestroyDuplicates is
		// true, match links with a matching value for that end.
		// For non-unique, ordered ends for which isDestroyDuplicates is false,
		// match links with an end value at the given destroyAt position. [Must
		// a value be given, too, in this case?]
		// For non-unique, non-ordered ends for which isDestroyDuplicates is
		// false, pick one matching link (if any) non-deterministically. [The
		// semantics of this case is not clear from the current spec.]
		Debug.println("[doAction] DestroyLinkAction...");
		DestroyLinkAction action = (DestroyLinkAction) (this.node);
		List<LinkEndDestructionData> destructionDataList = new ArrayList<LinkEndDestructionData>();
		for (LinkEndData data : action.getEndData()) {
			destructionDataList.add((LinkEndDestructionData) data);
		}
		Debug.println("[doAction] end data size = " + destructionDataList.size());
		boolean destroyOnlyOne = false;
		int j = 1;
		while (!destroyOnlyOne & j <= destructionDataList.size()) {
			LinkEndDestructionData endData = destructionDataList.get(j - 1);
			destroyOnlyOne = !endData.getEnd().isUnique() & !endData.getEnd().isOrdered() & !endData.isDestroyDuplicates();
			j = j + 1;
		}
		List<LinkEndData> endDataList = new ArrayList<LinkEndData>();
		for (int i = 0; i < destructionDataList.size(); i++) {
			LinkEndDestructionData endData = destructionDataList.get(i);
			Debug.println("[doAction] Matching end = " + endData.getEnd().getName());
			endDataList.add(endData);
		}
		List<IExtensionalValue> extent = this.getExecutionLocus().getExtent(this.getAssociation());
		List<IExtensionalValue> matchingLinks = new ArrayList<IExtensionalValue>();
		for (int i = 0; i < extent.size(); i++) {
			IExtensionalValue value = extent.get(i);
			ILink link = (ILink) value;
			if (this.linkMatchesEndData(link, endDataList)) {
				matchingLinks.add(link);
			}
		}
		// Now that matching is done, ensure that all tokens on end data input
		// pins
		// are consumed.
		for (int i = 0; i < destructionDataList.size(); i++) {
			LinkEndDestructionData endData = destructionDataList.get(i);
			Property end = endData.getEnd();
			if (!endData.isDestroyDuplicates() & !end.isUnique() & end.isOrdered()) {
				this.takeTokens(endData.getDestroyAt());
			}
			Debug.println("[doAction] Consuming tokens for end " + end.getName());
			this.takeTokens(endData.getValue());
		}
		if (destroyOnlyOne) {
			// *** If there is more than one matching link,
			// non-deterministically choose one. ***
			if (matchingLinks.size() > 0) {
				int i = ((ChoiceStrategy) this.getExecutionLocus().getFactory().getStrategy("choice")).choose(matchingLinks.size());
				matchingLinks.get(i - 1).destroy();
			}
		} else {
			for (int i = 0; i < matchingLinks.size(); i++) {
				IExtensionalValue matchingLink = matchingLinks.get(i);
				matchingLink.destroy();
			}
		}
	}
}
