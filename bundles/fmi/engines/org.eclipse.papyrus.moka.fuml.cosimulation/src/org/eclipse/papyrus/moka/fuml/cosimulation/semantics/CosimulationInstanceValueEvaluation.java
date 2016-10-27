/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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

// Imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_Object;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_Reference;
import org.eclipse.papyrus.moka.fmi.master.fmilibrary.Fmi2ScalarVariable;
import org.eclipse.papyrus.moka.fmi.master.fmuproxy.Fmu2ProxyService;
import org.eclipse.papyrus.moka.fmi.profile.util.FMIProfileUtil;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IBooleanValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IDataValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IEnumerationValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IIntegerValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IRealValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IStringValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IStructuredValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.BooleanValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.DataValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.EnumerationValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.InstanceValueEvaluation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.IntegerValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.RealValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Reference;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.ValueSpecification;


public class CosimulationInstanceValueEvaluation extends InstanceValueEvaluation {

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
		IObject_ object = null;

		Debug.println("[evaluate] type = " + myType.getName());

		IValue value;
		if (instance instanceof EnumerationLiteral) {
			// Debug.println("[evaluate] Type is an enumeration.");
			IEnumerationValue enumerationValue = new EnumerationValue();
			enumerationValue.setType((Enumeration) myType);
			enumerationValue.setLiteral((EnumerationLiteral) instance);
			value = enumerationValue;
		} else {
			IStructuredValue structuredValue = null;

			if (myType instanceof DataType) {
				// Debug.println("[evaluate] Type is a data type.");
				IDataValue dataValue = new DataValue();
				dataValue.setType((DataType) myType);
				structuredValue = dataValue;
			} else {

				if (myType instanceof Behavior) {
					// Debug.println("[evaluate] Type is a behavior.");
					object = this.locus.getFactory().createExecution((Behavior) myType, null);
				} else {
					// Debug.println("[evaluate] Type is a class.");


					// Modified here to instanciate a Fmu2ProxyService from part default value instance
					Class fmuClassifier = getFMUClassifier(instance);

					if (fmuClassifier != null) {
						object = new Fmu2ProxyService(fmuClassifier);
					} else {
						object = new CS_Object();
					}

					for (int i = 0; i < types.size(); i++) {
						Classifier type = types.get(i);
						object.addType((Class) type);
					}
				}

				this.locus.add(object);

				IReference reference;
				if (object instanceof CS_Object) {
					reference = new CS_Reference();
					((CS_Reference) reference).compositeReferent = (CS_Object) object;
				} else {
					reference = new Reference();
				}
				reference.setReferent(object);
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
					IValue runtimeValue = this.locus.getExecutor().evaluate(slotValue) ;
					values.add(runtimeValue);
					if (object instanceof Fmu2ProxyService) {
						Fmi2ScalarVariable variable = ((Fmu2ProxyService)object).getVariable((Property)slot.getDefiningFeature()) ;
						Object actualRuntimeValue = null;
						if (runtimeValue instanceof IntegerValue) {
							actualRuntimeValue = ((IIntegerValue)runtimeValue).getValue() ;
						}
						else if (runtimeValue instanceof BooleanValue) {
							actualRuntimeValue = ((IBooleanValue)runtimeValue).getValue() ;
						}
						else if (runtimeValue instanceof RealValue) {
							actualRuntimeValue = ((IRealValue)runtimeValue).getValue() ;
						}
						else  {
							actualRuntimeValue = ((IStringValue)runtimeValue).getValue() ;
						}
						if (variable != null) {
							variable.setRuntimeValue(actualRuntimeValue);
						}
					}
				}
				
				structuredValue.setFeatureValue(slot.getDefiningFeature(), values, 0);
			}

			value = structuredValue;
		}

		return value;
	}


	private Class getFMUClassifier(InstanceSpecification instance) {
		List<Classifier> types = instance.getClassifiers();
		for (int i = 0; i < types.size(); i++) {
			Classifier type = types.get(i);
			if (type instanceof Class && FMIProfileUtil.isCS_FMU((Class) type) != null) {
				return (Class) type;
			}
		}
		return null;
	}
}
