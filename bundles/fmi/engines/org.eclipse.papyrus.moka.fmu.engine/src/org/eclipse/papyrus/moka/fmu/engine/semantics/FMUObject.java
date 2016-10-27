/*****************************************************************************
 * 
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.fmu.engine.semantics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.InvocationActions.CS_DefaultConstructStrategy;
import org.eclipse.papyrus.moka.fmi.profile.util.FMIProfileUtil;
import org.eclipse.papyrus.moka.fmu.communication.FMUInterface;
import org.eclipse.papyrus.moka.fmu.engine.control.EngineStatus;
import org.eclipse.papyrus.moka.fmu.engine.utils.FMUEngineUtils;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IBooleanValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IIntegerValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IRealValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IStringValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.BooleanValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.IntegerValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.RealValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.StringValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications.ArrivalSignal;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications.ObjectActivation;
import org.eclipse.papyrus.moka.timedfuml.semantics.Timed_Object;
import org.eclipse.papyrus.moka.utils.UMLPrimitiveTypesUtils;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.util.UMLUtil;


public class FMUObject extends Timed_Object implements FMUInterface, IObject_ {

	// FIXME indexes in maps shall be implement with Long
	protected Map<Integer, Double> realMap = new HashMap<Integer, Double>();
	protected Map<Integer, Integer> integerMap = new HashMap<Integer, Integer>();
	protected Map<Integer, Boolean> booleanMap = new HashMap<Integer, Boolean>();
	protected Map<Integer, String> stringMap = new HashMap<Integer, String>();

	protected Map<Integer, Property> indexToUMLPropertyMap ;
	protected Map<Property, Integer> UMLPropertyToIndexMap ;
	protected Map<String, Integer> UMLPropertyNameToIndexMap ;

	@Override
	public void doStep(double currentCommunicationTime, double stepSize) {
		// TODO
		// FIXME There may be some "rounding" problems with double. 
		// We need to make sure that the current time in the DEEngine equals the currentCommunicationTime,
		// and possibly perform some corrections on the DEEngine side (e.g., update the current DEEngine time, and possibly time on events in 
		// its pool)
	}

	@Override
	public void updateMaps() {
		// TODO Equivalent de synchronize with maps.
	}

	@Override
	public void init() {
		// The hypothesis is that the this object has been instantiated by the FMU Execution Engine,
		// but it is not constructed yet (in the sense of PSCS Construct Strategy),
		// and its classifier behavior has not been started.
		// This is done prior to the first doStep
		CS_DefaultConstructStrategy strategy = (CS_DefaultConstructStrategy)this.locus.getFactory().getStrategy("constructStrategy") ;
		strategy.constructObject(this, this.types.get(0)) ;
		for (IFeatureValue fv : this.getFeatureValues()) {
			this.synchronizeFeatureValueWithValueMaps(fv.getFeature(), fv.getValues());
		}
	}

	@Override
	public void terminate() {
		// TODO
		// FIXME in the FMI API, terminate() does not "kill" the FMU (this is done by freeInstance()). Is there anything special to do here ?
		// Should we have freeInstance() in FMUInterface.java?
	}

	@Override
	public void setFeatureValue(StructuralFeature feature, List<IValue> values, Integer position) {
		super.setFeatureValue(feature, values, position);
		this.synchronizeFeatureValueWithValueMaps(feature, values) ;
	}

	protected void synchronizeFeatureValueWithValueMaps(StructuralFeature feature, List<IValue> values) {
		if (this.indexToUMLPropertyMap == null && this.UMLPropertyToIndexMap == null && this.UMLPropertyNameToIndexMap == null) {
			this.indexToUMLPropertyMap = new HashMap<Integer, Property>() ;
			this.UMLPropertyToIndexMap = new HashMap<Property, Integer>() ;
			this.UMLPropertyNameToIndexMap = new HashMap<String, Integer>() ;
			for (Property p : this.types.get(0).allAttributes()) {
				if (FMIProfileUtil.isFMUPort(p)) {
					int index = FMIProfileUtil.getValueReference(p) ;
					if (index != -1) {
						this.indexToUMLPropertyMap.put(index, p) ;
						this.UMLPropertyToIndexMap.put(p, index) ;
						this.UMLPropertyNameToIndexMap.put(p.getName(), index) ;
					}
				}
			}
		}
		if (FMIProfileUtil.isFMUPort(feature)) {
			int key = UMLPropertyToIndexMap.get(feature) ;
			Type featureType = feature.getType();
			if (featureType != null){
				if (UMLUtil.isReal(featureType)){
					
					IRealValue realValue = values.isEmpty() ? null : (IRealValue)values.get(0) ;
					Double value = realValue == null ? null : realValue.getValue() ;
					realMap.put(key, value) ;
				}
				else if (UMLUtil.isInteger(featureType)) {
					IIntegerValue integerValue = values.isEmpty() ? null : (IIntegerValue)values.get(0) ;
					Integer value = integerValue == null ? null : integerValue.getValue() ;
					integerMap.put(key, value) ;
				}
				else if (UMLUtil.isBoolean(featureType)) {
					IBooleanValue booleanValue = values.isEmpty() ? null : (IBooleanValue)values.get(0) ;
					Boolean value = booleanValue == null ? null : booleanValue.getValue() ;
					booleanMap.put(key, value) ;
				}
				else if (UMLUtil.isString(featureType)) {
					IStringValue stringValue = values.isEmpty() ? null : (IStringValue)values.get(0) ;
					String value = stringValue == null ? null : stringValue.getValue() ;
					stringMap.put(key, value) ;
				}
				else {
					// FIXME unsupported type. What do we do? Return a Fatal STATUS ?
				}
			}
		
		}
	}

	@Override
	public Map<Integer, Double> fmiGetReals() {
		return realMap;
	}

	@Override
	public Map<Integer, Integer> fmiGetIntegers() {
		return integerMap;
	}

	@Override
	public Map<Integer, Boolean> fmiGetBools() {
		return booleanMap;
	}

	@Override
	public Map<Integer, String> fmiGetStrings() {
		return stringMap;
	}

	@Override
	public void fmiSetReals(Map<Integer, Double> realsMap) {
		this.realMap.putAll(realsMap);
		// updates feature values
		for (Iterator<Integer> i = realsMap.keySet().iterator() ; i.hasNext() ; ) {
			Integer key = i.next() ;
			Property p = indexToUMLPropertyMap.get(key) ;
			IFeatureValue fv = this.getFeatureValue(p) ;
			IRealValue realValue = fv.getValues().isEmpty() ? null : (IRealValue)fv.getValues().get(0) ;
			if (realValue == null) {
				realValue = new RealValue() ;
				realValue.setType((PrimitiveType)UMLPrimitiveTypesUtils.getReal(p)) ;
				fv.getValues().add(realValue) ;
			}
			if (realValue.getValue() != null) {
				if (FMUEngineUtils.getFMUControlService().getEngineStatus() == EngineStatus.STEPPING) { // This is to avoid generation of change events at the end of the init phase
					Double old = realValue.getValue() ;
					Double new_ = realMap.get(key) ;
					if (! (old.equals(new_))) {
						RealValue oldValue = new RealValue() ;
						oldValue.setType((PrimitiveType)UMLPrimitiveTypesUtils.getReal(p));
						oldValue.setValue(new_);
						FMUChangeEventOccurence changeEventOccurence = new FMUChangeEventOccurence(p, oldValue, realValue) ;
						this.getObjectActivation().getEvents().add(changeEventOccurence) ;
						((ObjectActivation)this.getObjectActivation())._send(new ArrivalSignal()); 
					}
				}
				realValue.setValue(realsMap.get(key)) ;
			}
		}
	}

	@Override
	public void fmiSetIntegers(Map<Integer, Integer> integersMap) {
		this.integerMap.putAll(integersMap);
		// updates feature values
		for (Iterator<Integer> i = integersMap.keySet().iterator() ; i.hasNext() ; ) {
			Integer key = i.next() ;
			Property p = indexToUMLPropertyMap.get(key) ;
			IFeatureValue fv = this.getFeatureValue(p) ;
			IIntegerValue integerValue = fv.getValues().isEmpty() ? null : (IIntegerValue)fv.getValues().get(0) ;
			if (integerValue == null) {
				integerValue = new IntegerValue() ;
				integerValue.setType((PrimitiveType)UMLPrimitiveTypesUtils.getInteger(p)) ;
				fv.getValues().add(integerValue) ;
			}
			if (integerValue.getValue() != null) {
				if (FMUEngineUtils.getFMUControlService().getEngineStatus() == EngineStatus.STEPPING) { // This is to avoid generation of change events at the end of the init phase
					Integer old = integerValue.getValue() ;
					Integer new_ = integerMap.get(key) ;
					if (!(old.equals(new_))) {
						IntegerValue oldValue = new IntegerValue() ;
						oldValue.setType((PrimitiveType)UMLPrimitiveTypesUtils.getInteger(p));
						oldValue.setValue(new_);
						FMUChangeEventOccurence changeEventOccurence = new FMUChangeEventOccurence(p, oldValue, integerValue) ;
						this.getObjectActivation().getEvents().add(changeEventOccurence) ;
						((ObjectActivation)this.getObjectActivation())._send(new ArrivalSignal()); 
					}
				}
				integerValue.setValue(integerMap.get(key)) ;
			}
		}
	}

	@Override
	public void fmiSetBools(Map<Integer, Boolean> boolsMap) {
		this.booleanMap.putAll(boolsMap);
		// updates feature values
		for (Iterator<Integer> i = boolsMap.keySet().iterator() ; i.hasNext() ; ) {
			Integer key = i.next() ;
			Property p = indexToUMLPropertyMap.get(key) ;
			IFeatureValue fv = this.getFeatureValue(p) ;
			IBooleanValue booleanValue = fv.getValues().isEmpty() ? null : (IBooleanValue)fv.getValues().get(0) ;
			if (booleanValue == null) {
				booleanValue = new BooleanValue() ;
				booleanValue.setType((PrimitiveType)UMLPrimitiveTypesUtils.getBoolean(p)) ;
				fv.getValues().add(booleanValue) ;
			}
			if (booleanValue.getValue() != null) {
				if (FMUEngineUtils.getFMUControlService().getEngineStatus() == EngineStatus.STEPPING) { // This is to avoid generation of change events at the end of the init phase
					Boolean old = booleanValue.getValue() ;
					Boolean new_ = booleanMap.get(key) ;
					if (!(old.equals(new_))) {
						BooleanValue oldValue = new BooleanValue() ;
						oldValue.setType((PrimitiveType)UMLPrimitiveTypesUtils.getBoolean(p));
						oldValue.setValue(new_);
						FMUChangeEventOccurence changeEventOccurence = new FMUChangeEventOccurence(p, oldValue, booleanValue) ;
						this.getObjectActivation().getEvents().add(changeEventOccurence) ;
						((ObjectActivation)this.getObjectActivation())._send(new ArrivalSignal()); 
					}
					booleanValue.setValue(booleanMap.get(key)) ;
				}
			}
		}
	}

	@Override
	public void fmiSetStrings(Map<Integer, String> stringsMap) {
		this.stringMap.putAll(stringsMap);
		// updates feature values
		for (Iterator<Integer> i = stringsMap.keySet().iterator() ; i.hasNext() ; ) {
			Integer key = i.next() ;
			Property p = indexToUMLPropertyMap.get(key) ;
			IFeatureValue fv = this.getFeatureValue(p) ;
			IStringValue stringValue = fv.getValues().isEmpty() ? null : (IStringValue)fv.getValues().get(0) ;
			if (stringValue == null) {
				stringValue = new StringValue() ;
				stringValue.setType((PrimitiveType)UMLPrimitiveTypesUtils.getString(p)) ;
				fv.getValues().add(stringValue) ;
			}
			if (stringValue.getValue() != null) {
				if (FMUEngineUtils.getFMUControlService().getEngineStatus() == EngineStatus.STEPPING) { // This is to avoid generation of change events at the end of the init phase
					String old = stringValue.getValue() ;
					String new_ = stringMap.get(key) ;
					if (! (old.equals(new_))) {
						StringValue oldValue = new StringValue() ;
						oldValue.setType((PrimitiveType)UMLPrimitiveTypesUtils.getString(p));
						oldValue.setValue(new_);
						FMUChangeEventOccurence changeEventOccurence = new FMUChangeEventOccurence(p, oldValue, stringValue) ;
						this.getObjectActivation().getEvents().add(changeEventOccurence) ;
						((ObjectActivation)this.getObjectActivation())._send(new ArrivalSignal()); 
					}
				}
				stringValue.setValue(stringMap.get(key)) ;
			}
		}
	}

	public Map<Integer, Property> getIndexToUMLPropertyMap() {
		return indexToUMLPropertyMap;
	}

	public Map<String, Integer> getPropertyNameToIndexMap() {
		return UMLPropertyNameToIndexMap ;
	}

}
