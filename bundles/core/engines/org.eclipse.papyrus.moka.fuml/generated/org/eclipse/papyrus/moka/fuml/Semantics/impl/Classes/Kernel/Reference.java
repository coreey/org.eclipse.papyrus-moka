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
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.StructuralFeature;

public class Reference extends StructuredValue implements IReference {

	public IObject_ referent;

	public void startBehavior(Class classifier, List<IParameterValue> inputs) {
		// Asynchronously start the behavior of the given classifier for the
		// referent object.
		this.referent.startBehavior(classifier, inputs);
	}

	public IExecution dispatch(Operation operation) {
		// Dispatch the given operation to the referent object.
		return this.referent.dispatch(operation);
	}

	public void send(IEventOccurrence eventOccurrence)  {
		// Send the given event occurrence to the referent object.
		this.referent.send(eventOccurrence);
	}

	public void destroy() {
		// Destroy the referent.
		this.referent.destroy();
	}

	@Override
	public Boolean equals(IValue otherValue) {
		// Test if this reference is equal to the otherValue.
		// To be equal, the otherValue must also be a reference, with the same
		// referent as this reference.
		boolean isEqual = false;
		if (otherValue instanceof Reference) {
			if (this.referent == null) {
				isEqual = ((Reference)otherValue).referent == null;
			} else {
				isEqual = this.referent.equals(((Reference) otherValue).referent);
			}
		}
		return isEqual;
	}

	@Override
	public IValue copy() {
		// Create a new reference with the same referent as this reference.
		Reference newValue = (Reference) (super.copy());
		newValue.referent = this.referent;
		return newValue;
	}

	@Override
	public IValue new_() {
		// Create a new reference with no referent.
		return new Reference();
	}

	@Override
	public List<Classifier> getTypes() {
		// Get the types of the referent object.
		return this.referent.getTypes();
	}

	@Override
	public IFeatureValue getFeatureValue(StructuralFeature feature) {
		// Get the feature value associated with the given feature in the
		// referent object.
		return this.referent.getFeatureValue(feature);
	}

	@Override
	public void setFeatureValue(StructuralFeature feature, List<IValue> values, Integer position) {
		// Set the values associated with the given feature in the referent
		// object.
		this.referent.setFeatureValue(feature, values, position);
	}

	@Override
	public List<IFeatureValue> getFeatureValues() {
		// Return the feature values of the referent.
		return this.referent.getFeatureValues();
	}

	@Override
	public String toString() {
		return "Reference to " + this.referent.toString();
	}

	public void setReferent(IObject_ referent) {
		this.referent = referent;
	}

	public IObject_ getReferent() {
		return this.referent;
	}

	public void setFeatureValues(List<IFeatureValue> featureValues) {
		this.referent.setFeatureValues(featureValues);
	}
}
