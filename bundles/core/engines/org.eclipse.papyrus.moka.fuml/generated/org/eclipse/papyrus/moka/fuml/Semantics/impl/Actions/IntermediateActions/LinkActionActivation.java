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

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Actions.IntermediateActions.ILinkActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.ILink;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.UnlimitedNaturalValue;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.LinkAction;
import org.eclipse.uml2.uml.LinkEndData;
import org.eclipse.uml2.uml.LinkEndDestructionData;
import org.eclipse.uml2.uml.Property;

public abstract class LinkActionActivation extends ActionActivation implements ILinkActionActivation {

	public Boolean linkMatchesEndData(ILink link, List<LinkEndData> endDataList) {
		// Test whether the given link matches the given end data.
		boolean matches = true;
		int i = 1;
		while (matches & i <= endDataList.size()) {
			matches = this.endMatchesEndData(link, endDataList.get(i - 1));
			i = i + 1;
		}
		return matches;
	}

	public Boolean endMatchesEndData(ILink link, LinkEndData endData) {
		// Test whether the appropriate end of the given link matches the given
		// end data.
		boolean matches = false;
		if (endData.getValue() == null) {
			matches = true;
		} else {
			Property end = endData.getEnd();
			IFeatureValue linkFeatureValue = link.getFeatureValue(end);
			IValue endValue = this.getTokens(endData.getValue()).get(0);
			if (endData instanceof LinkEndDestructionData) {
				if (!((LinkEndDestructionData) endData).isDestroyDuplicates() & !end.isUnique() & end.isOrdered()) {
					int destroyAt = ((UnlimitedNaturalValue) (this.getTokens(((LinkEndDestructionData) endData).getDestroyAt()).get(0))).value;
					matches = linkFeatureValue.getValues().get(0).equals(endValue) && linkFeatureValue.getPosition() == destroyAt;
				} else {
					matches = linkFeatureValue.getValues().get(0).equals(endValue);
				}
			} else {
				matches = linkFeatureValue.getValues().get(0).equals(endValue);
			}
		}
		return matches;
	}

	public Association getAssociation() {
		// Get the association for the link action of this activation.
		return (((LinkAction) (this.node)).getEndData().get(0).getEnd().getAssociation());
	}
}
