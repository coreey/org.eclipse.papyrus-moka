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
package org.eclipse.papyrus.moka.fuml.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IValue;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IExtensionalValue;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IObject_;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IReference;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.Reference;
import org.eclipse.uml2.uml.ReadExtentAction;

public class ReadExtentActionActivation extends ActionActivation {

	@Override
	public void doAction() {
		// Get the extent, at the current execution locus, of the classifier
		// (which must be a class) identified in the action.
		// Place references to the resulting set of objects on the result pin.
		ReadExtentAction action = (ReadExtentAction) (this.node);
		List<IExtensionalValue> objects = this.getExecutionLocus().getExtent(action.getClassifier());
		// Debug.println("[doAction] " + action.classifier.name + " has " +
		// objects.size() + " instance(s).");
		List<IValue> references = new ArrayList<IValue>();
		for (int i = 0; i < objects.size(); i++) {
			IValue object = objects.get(i);
			IReference reference = new Reference();
			reference.setReferent((IObject_) object);
			references.add(reference);
		}
		this.putTokens(action.getResult(), references);
	}
}
