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

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.ILink;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IStructuredValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.ClearStructuralFeatureAction;
import org.eclipse.uml2.uml.StructuralFeature;

public class ClearStructuralFeatureActionActivation extends StructuralFeatureActionActivation {

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
			}
			((IStructuredValue) value).setFeatureValue(action.getStructuralFeature(), new ArrayList<IValue>(), 0);
		}
		if (action.getResult() != null) {
			this.putToken(action.getResult(), value);
		}
	}
}
