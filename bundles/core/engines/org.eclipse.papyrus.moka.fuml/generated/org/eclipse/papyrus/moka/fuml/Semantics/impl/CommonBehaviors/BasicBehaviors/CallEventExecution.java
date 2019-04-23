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

package org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.ICallEventExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ICallEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications.CallEventOccurrence;
import org.eclipse.papyrus.moka.fuml.control.queue.ExecutionController;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;

public class CallEventExecution extends Execution implements ICallEventExecution{
	
	public boolean callerSuspended;
	
	public Operation getOperation(){
		// Return the operation being called by this call event execution.
		return ((CallEventBehavior)this.getBehavior()).operation;
	}
	
	@Override
	public void execute() {
		// Send a new CallEventOccurrence to the target of this call
		// (which is the context of this execution) and suspend the
		// caller until the call is completed. Note that the
		// call will never be completed if the target is not an active
		// object, since then the object would then have no event
		// pool in which the event occurrence could be placed.
		this.setCallerSuspended(true);
		this.makeCall();
		this.suspend();
	}
	
	public void makeCall(){
		// Make the call on the target object (which is the context of this execution)
		// by sending a call event occurrence. (Note that the call will never be 
		// completed if the target is not an active object, since then the object 
		// would then have no event pool in which the event occurrence could be placed.)
		IReference reference = new Reference();
		reference.setReferent(this.context);		
		this.createEventOccurrence().sendTo(reference);		
	}
	
	public IEventOccurrence createEventOccurrence(){
		// Create a call event occurrence associated with this call event execution.
		// (This operation may be overridden in subclasses to alter how the event
		// occurrence is create, e.g., if it is necessary to wrap it.)
		ICallEventOccurrence eventOccurrence = new CallEventOccurrence();
		eventOccurrence.setCallEventExecution(this);
		return eventOccurrence;
	}
	
	@Override
	public IValue new_() {
		// Create a new call event execution.
		return new CallEventExecution();
	}
	
	@Override
	public IValue copy() {
		// Create a new call event execution that is a copy of this execution, with the
		// caller initially not suspended.
		CallEventExecution copy = (CallEventExecution)super.copy();
		copy.callerSuspended = false;
		return copy;
	}
	
	public List<IParameterValue> getInputParameterValues(){
		// Return input parameter values for this execution.
		List<IParameterValue> parameterValues = new ArrayList<IParameterValue>();
		for(int i=0; i < this.parameterValues.size(); i++){
			IParameterValue parameterValue = this.parameterValues.get(i);
			if(parameterValue.getParameter().getDirection().equals(ParameterDirectionKind.IN_LITERAL)
					| parameterValue.getParameter().getDirection().equals(ParameterDirectionKind.INOUT_LITERAL)){
				parameterValues.add(parameterValue);
			}
		}
		return parameterValues;
	}
	
	public boolean isCallerSuspended(){
		// Check if the caller is still suspended.
		// This is done in isolation from possible concurrent updates to this flag.
		_beginIsolation();
		boolean isSuspended = this.callerSuspended;
		_endIsolation();
		return isSuspended;
	}
	
	public void setCallerSuspended(boolean callerSuspended){
		// Set the caller suspended flag to the given value.
		// This is done in isolation from possible concurrent queries to this flag.
		_beginIsolation();
		this.callerSuspended = callerSuspended;
		_endIsolation();
	}

	public void setOutputParameterValues(List<IParameterValue> parameterValues){
		// Set the output parameter values for this execution.
		List<Parameter> parameters = this.getBehavior().getOwnedParameters();
		int i = 1;
		int j = 1;
		while (i <= parameters.size()) {
			Parameter parameter = parameters.get(i-1);
			if (parameter.getDirection().equals(ParameterDirectionKind.INOUT_LITERAL) | 
					parameter.getDirection().equals(ParameterDirectionKind.OUT_LITERAL) | 
					parameter.getDirection().equals(ParameterDirectionKind.RETURN_LITERAL)) {
				IParameterValue parameterValue = parameterValues.get(j-1);
				parameterValue.setParameter(parameter);
				this.setParameterValue(parameterValue);
				j = j + 1;
			}
			i = i + 1;
		}
	}
	
	public void suspend(){
		// Suspend the caller until the caller is released.
		while(this.isCallerSuspended()){
			this.wait_();
		}
	}
	
	public void wait_(){
		// Wait for an indeterminate amount of time to allow other concurrent 
		// executions to proceed.
		// [There is no further formal specification for this operation.]
		ExecutionController.getInstance().getExecutionLoop().step();
	}

}
