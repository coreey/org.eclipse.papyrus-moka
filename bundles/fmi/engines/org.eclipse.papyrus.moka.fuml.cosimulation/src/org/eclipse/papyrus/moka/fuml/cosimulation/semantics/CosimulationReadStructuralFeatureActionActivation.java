/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.cosimulation.semantics;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.ILink;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IStructuredValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions.ReadStructuralFeatureActionActivation;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.ReadStructuralFeatureAction;
import org.eclipse.uml2.uml.StructuralFeature;

public class CosimulationReadStructuralFeatureActionActivation extends ReadStructuralFeatureActionActivation {

	@Override
	public void doAction() {
		// Get the value of the object input pin.
		// If the given feature is an association end, then get all values of
		// the that end.
		// for which the opposite end has the object input value and place them
		// on the result pin.
		// Otherwise, if the object input value is a structural value, then get
		// the values
		// of the appropriate feature of the input value and place them on the
		// result output pin.
		ReadStructuralFeatureAction action = (ReadStructuralFeatureAction) (this.node);
		StructuralFeature feature = action.getStructuralFeature();
		Association association = this.getAssociation(feature);
		IValue value = this.takeTokens(action.getObject()).get(0);
		List<IValue> resultValues = new ArrayList<IValue>();
		if (association != null) {
			List<ILink> links = this.getMatchingLinks(association, feature, value);
			for (int i = 0; i < links.size(); i++) {
				ILink link = links.get(i);
				resultValues.add(link.getFeatureValue(feature).getValues().get(0));
			}
		} else if (value instanceof IStructuredValue) {
			// Debug.println("[ReadStructuralFeatureActionActivation] value = "
			// + value +", structural feature = " + feature.name);
			resultValues = ((IStructuredValue) value).getFeatureValue(feature).getValues();
		}
		this.putTokens(action.getResult(), resultValues);
	}
}
