/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReturnInformation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ICallEventOccurrence;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.ValueSpecification;


public class ReturnInformation extends Value implements IReturnInformation{

	public ICallEventOccurrence callEventOccurrence;
	
	public Operation getOperation(){
		// Return the operation associated with the call event occurrence of this
		// return information.
		Operation operation = null;
		if(this.callEventOccurrence != null){
			operation = this.callEventOccurrence.getOperation();
		}
		return operation;
	}
	
	public void reply(List<IParameterValue> outputParameterValues){
		// Reply to the call by setting the output parameters and
		// releasing the caller.
		this.callEventOccurrence.setOutputParameterValues(outputParameterValues);
		this.callEventOccurrence.returnFromCall();	
	}

	
	@Override
	public IValue copy() {
		// Create a new return information value that is a copy of this value, with
		// the same call event occurrence.
		ReturnInformation copy = (ReturnInformation)super.copy();
		copy.callEventOccurrence = this.callEventOccurrence;
		return copy;
	}
	
	public Boolean equals(IValue otherValue) {
		// One return information value equals another if they are for the
		// same call event occurrence.
		boolean isEqual = false;
		if (otherValue instanceof ReturnInformation) {
			isEqual = ((ReturnInformation)otherValue).callEventOccurrence == this.callEventOccurrence;
		}
		return isEqual;
	}
	
	@Override
	public ValueSpecification specify() {
		// Return information cannot be specified using a value specification.
		return null;
	}

	@Override
	public IValue new_() {
		// Create a new return information value, with an empty call event occurrence.
		return new ReturnInformation();
	}

	@Override
	public List<Classifier> getTypes() {
		// Return information is untyped.
		return new ArrayList<Classifier>();
	}

	@Override
	public String toString() {
		// Return a string representation of the return information.
		return "ReturnInformation(" + callEventOccurrence.getOperation().getName() + ")";
	}

	@Override
	public void setCallEventOcccurrence(ICallEventOccurrence callEventOccurrence) {
		this.callEventOccurrence = callEventOccurrence;
	}

	@Override
	public ICallEventOccurrence getCallEventOccurrence() {
		return this.callEventOccurrence;
	}

}
