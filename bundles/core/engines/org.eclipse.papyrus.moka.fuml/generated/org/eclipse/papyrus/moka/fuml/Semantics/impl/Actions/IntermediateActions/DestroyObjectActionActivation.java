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

import org.eclipse.papyrus.moka.fuml.Semantics.Actions.IntermediateActions.IDestroyObjectActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IExtensionalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.ILink;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.DestroyObjectAction;
import org.eclipse.uml2.uml.Property;

public class DestroyObjectActionActivation extends ActionActivation implements IDestroyObjectActivation {

	@Override
	public void doAction() {
		// Get the value on the target input pin.
		// If the value is not a reference, then the action has no effect.
		// Otherwise, do the following.
		// If isDestroyLinks is true, destroy all links in which the referent
		// participates.
		// If isDestroyOwnedObjects is true, destroy all objects owned by the
		// referent via composition links.
		// Destroy the referent object.
		DestroyObjectAction action = (DestroyObjectAction) (this.node);
		IValue value = this.takeTokens(action.getTarget()).get(0);
		this.destroyObject(value, action.isDestroyLinks(), action.isDestroyOwnedObjects());
	}

	public void destroyObject(IValue value, Boolean isDestroyLinks, Boolean isDestroyOwnedObjects) {
		// If the given value is a reference, then destroy the referenced
		// object, per the given destroy action attribute values.
		// Debug.println("[destroyObject] object = " + value.objectId());
		if (value instanceof IReference) {
			IReference reference = (IReference) value;
			if (isDestroyLinks | isDestroyOwnedObjects) {
				Debug.println("[destroyObject] Destroying links...");
				List<IExtensionalValue> extensionalValues = this.getExecutionLocus().getExtensionalValues();
				for (int i = 0; i < extensionalValues.size(); i++) {
					IExtensionalValue extensionalValue = extensionalValues.get(i);
					if (extensionalValue instanceof ILink) {
						ILink link = (ILink) extensionalValue;
						if (this.valueParticipatesInLink(reference, link)) {
							if (isDestroyLinks | this.objectIsComposite(reference, link)) {
								// Debug.println("[destroyObject] Destroying link "
								// + link.objectId());
								link.destroy();
							}
						}
					}
				}
			}
			if (isDestroyOwnedObjects) {
				Debug.println("[destroyObject] Destroying owned objects...");
				List<IFeatureValue> objectFeatureValues = reference.getFeatureValues();
				for (int i = 0; i < objectFeatureValues.size(); i++) {
					IFeatureValue featureValue = objectFeatureValues.get(i);
					if (((Property) featureValue.getFeature()).getAggregation() == AggregationKind.COMPOSITE_LITERAL) {
						List<IValue> values = featureValue.getValues();
						for (int j = 0; j < values.size(); j++) {
							IValue ownedValue = values.get(j);
							this.destroyObject(ownedValue, isDestroyLinks, isDestroyOwnedObjects);
						}
					}
				}
			}
			reference.destroy();
		}
	}

	public Boolean objectIsComposite(IReference reference, ILink link) {
		// Test whether the given reference participates in the given link as a
		// composite.
		List<IFeatureValue> linkFeatureValues = link.getFeatureValues();
		boolean isComposite = false;
		int i = 1;
		while (!isComposite & i <= linkFeatureValues.size()) {
			IFeatureValue featureValue = linkFeatureValues.get(i - 1);
			if (!featureValue.getValues().get(0).equals(reference) & ((Property) featureValue.getFeature()).getAggregation() == AggregationKind.COMPOSITE_LITERAL) {
				isComposite = true;
			}
			i = i + 1;
		}
		return isComposite;
	}
}
