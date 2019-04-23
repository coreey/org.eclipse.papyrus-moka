/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.moka.composites.Semantics.impl.Classes.Kernel;

// Imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_Object;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_Reference;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Object;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.DataValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.EnumerationValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.InstanceValueEvaluation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.StructuredValue;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.ValueSpecification;


public class CS_InstanceValueEvaluation extends InstanceValueEvaluation {

	@Override
	public IValue evaluate() {
		// If the instance specification is for an enumeration, then return the
		// identified enumeration literal.
		// If the instance specification is for a data type (but not a primitive
		// value or an enumeration), then create a data value of the given data
		// type.
		// If the instance specification is for an object, then create an object
		// at the current locus with the specified types.
		// Set each feature of the created value to the result of evaluating the
		// value specifications for the specified slot for the feature.
		// Extends fUML semantics in the sense that when the instance specification
		// is for an object which is not typed by a Behavior, A CS_Reference (to a
		// CS_Object) is produced instead of a Reference (to an Object)

		// Debug.println("[evaluate] InstanceValueEvaluation...");

		InstanceSpecification instance = ((InstanceValue) this.specification).getInstance();
		List<Classifier> types = instance.getClassifiers();
		Classifier myType = types.get(0);

		Debug.println("[evaluate] type = " + myType.getName());

		IValue value;
		if (instance instanceof EnumerationLiteral) {
			// Debug.println("[evaluate] Type is an enumeration.");
			EnumerationValue enumerationValue = new EnumerationValue();
			enumerationValue.type = (Enumeration) myType;
			enumerationValue.literal = (EnumerationLiteral) instance;
			value = enumerationValue;
		} else {
			StructuredValue structuredValue = null;

			if (myType instanceof DataType) {
				// Debug.println("[evaluate] Type is a data type.");
				DataValue dataValue = new DataValue();
				dataValue.type = (DataType) myType;
				structuredValue = dataValue;
			} else {
				IObject_ object = null;
				if (myType instanceof Behavior) {
					// Debug.println("[evaluate] Type is a behavior.");
					object = this.locus.getFactory().createExecution((Behavior) myType, null);
				} else {
					// Debug.println("[evaluate] Type is a class.");
					object = new CS_Object();
					for (int i = 0; i < types.size(); i++) {
						Classifier type = types.get(i);
						object.addType((Class) type);
					}
				}

				this.locus.add(object);

				Reference reference;
				if (object instanceof ICS_Object) {
					reference = new CS_Reference();
					((ICS_Reference) reference).setCompositeReferent((ICS_Object) object);
				} else {
					reference = new Reference();
				}
				reference.referent = object;
				structuredValue = reference;
			}

			structuredValue.createFeatureValues();

			// Debug.println("[evaluate] " + instance.slot.size() +
			// " slot(s).");

			List<Slot> instanceSlots = instance.getSlots();
			for (int i = 0; i < instanceSlots.size(); i++) {
				Slot slot = instanceSlots.get(i);
				List<IValue> values = new ArrayList<IValue>();

				// Debug.println("[evaluate] feature = " +
				// slot.definingFeature.name + ", " + slot.value.size() +
				// " value(s).");
				List<ValueSpecification> slotValues = slot.getValues();
				for (int j = 0; j < slotValues.size(); j++) {
					ValueSpecification slotValue = slotValues.get(j);
					// Debug.println("[evaluate] Value = " +
					// slotValue.getClass().getName());
					values.add(this.locus.getExecutor().evaluate(slotValue));
				}
				structuredValue.setFeatureValue(slot.getDefiningFeature(), values, 0);
			}

			value = structuredValue;
		}

		return value;
	}
}
