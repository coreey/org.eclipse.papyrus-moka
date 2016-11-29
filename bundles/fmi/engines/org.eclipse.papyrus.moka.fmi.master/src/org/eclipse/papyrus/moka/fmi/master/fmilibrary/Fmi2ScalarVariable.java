/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.fmi.master.fmilibrary;

import org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable;
import org.eclipse.papyrus.moka.fmi.master.fmuproxy.Fmu2ProxyService;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

public class Fmi2ScalarVariable {
	private Fmu2ProxyService fmu;
	private String name;
	private long valueReference;
	private String variability;
	private String causality;
	private String initial;
	private String type;

	private boolean hasChanged;


	private Object runtimeValue;

	public Object getRuntimeValue() {
		return runtimeValue;
	}

	public void setRuntimeValue(Object runtimeValue) {
		this.runtimeValue = runtimeValue;
	}

	public Fmi2ScalarVariable(Fmu2ProxyService fmu, Property p, Stereotype st) {

		ScalarVariable variable = (ScalarVariable) p.getStereotypeApplication(st);
		org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable modelDescVariable = variable.getFmiVariable();

		this.fmu = fmu;
		this.name = p.getName();
		this.valueReference = modelDescVariable.getValueReference();
		this.variability = modelDescVariable.getVariability().getName();
		this.causality = modelDescVariable.getCausality().toString();
		this.initial = modelDescVariable.getInitial().getName();
		this.setType(p.getType().getName());
		
	}

	public Fmu2ProxyService getFmu() {
		return fmu;
	}

	public void setFmu(Fmu2ProxyService fmu) {
		this.fmu = fmu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getValueReference() {
		return valueReference;
	}

	public void setValueReference(long valueReference) {
		this.valueReference = valueReference;
	}

	public String getVariability() {
		return variability;
	}

	public void setVariability(String variability) {
		this.variability = variability;
	}

	public String getCausality() {
		return causality;
	}

	public void setCausality(String causality) {
		this.causality = causality;
	}

	public String getInitial() {
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setHasChanged(boolean hasChanged) {
		this.hasChanged =hasChanged; 

	}

	public boolean hasChanged(){
		return hasChanged;
	}



}
