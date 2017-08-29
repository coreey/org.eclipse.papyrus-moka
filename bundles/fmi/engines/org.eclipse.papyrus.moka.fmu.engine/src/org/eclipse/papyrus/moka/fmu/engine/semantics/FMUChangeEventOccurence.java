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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Value;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications.EventOccurrence;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.ChangeEvent;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.LiteralString;

public class FMUChangeEventOccurence extends EventOccurrence {
	
	protected Property changedProperty ;
	protected IValue formerValue ;
	protected IValue newValue ;
	
	public FMUChangeEventOccurence(Property changedProperty, IValue formerValue, IValue newValue) {
		super();
		this.changedProperty = changedProperty;
		this.formerValue = formerValue;
		this.newValue = newValue;
	}

	public Property getChangedProperty() {
		return changedProperty;
	}

	public void setChangedProperty(Property changedProperty) {
		this.changedProperty = changedProperty;
	}

	public IValue getFormerValue() {
		return formerValue;
	}

	public void setFormerValue(Value formerValue) {
		this.formerValue = formerValue;
	}

	public IValue getNewValue() {
		return newValue;
	}

	public void setNewValue(Value newValue) {
		this.newValue = newValue;
	}

	@Override
	public void sendTo(IReference target) {
		// Do nothing. There is no sending of the event occurrence from an object
		// to target objects. Indeed, a change event occurrence is generated upon
		// the change of the value of the property and directly placed in the event
		// pool of the object owning the observed property
	}
	
	@Override
	public void doSend() {
		// Do nothing. See comment in sendTo.
	}
	
	@Override
	public boolean match(Trigger trigger) {
		// Return true if the changed property (i.e., the property referenced in
		// the event) is the same than the observed property.
		boolean matches = false;
		if(trigger.getEvent() instanceof ChangeEvent) {
			ChangeEvent event = (ChangeEvent) trigger.getEvent();
			if(this.getObservedProperty(event) == this.changedProperty){
				matches = true;
			}
		}
		return matches;
	}

	public void register() {
		// Register the change event occurrence in the event pool. It is added 
		// to the event pool after any other event already registered in the pool.
		FMU_ObjectActivation objectActivation = (FMU_ObjectActivation) this.target.getReferent().getObjectActivation();
		objectActivation.register(this);
	}
	
	protected Property getObservedProperty(ChangeEvent event){
		// The name specified in the change expression shall match the name
		// of a property of class typing the target object. If a property is
		// found then this latter shall be the same than the property referenced
		// in the event occurrence. If these aforementioned conditions are not
		// fulfilled then null is returned. 
		String propertyName = ((LiteralString)event.getChangeExpression()).getValue();
		Iterator<Classifier> types =  this.target.getReferent().getTypes().iterator();
		Property matchingProperty = null;
		while(matchingProperty == null && types.hasNext()){
			Iterator<Property> properties = types.next().allAttributes().iterator();
			while(matchingProperty == null && properties.hasNext()){
				Property property = properties.next();
				if(property.getName().equals(propertyName)){
					matchingProperty = property;
				}
			}
		}
		return matchingProperty;
	}
	
	@Override
	public List<IParameterValue> getParameterValues() {
		// Return the list of parameter values containing the former and the new value
		// for the watched property.
		List<IParameterValue> parameterValues = new ArrayList<IParameterValue>();
		IParameterValue parameterValue = new ParameterValue();
		List<IValue> formerValue = new ArrayList<IValue>();
		formerValue.add(this.formerValue);		
		parameterValue.setValues(formerValue);
		parameterValues.add(parameterValue);
		parameterValue = new ParameterValue();
		List<IValue> newValue = new ArrayList<IValue>();
		newValue.add(this.newValue);
		parameterValues.add(parameterValue);
		return parameterValues;
	}
	
	
}
