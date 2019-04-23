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

package org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.ICallEventExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ICallEventOccurrence;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Trigger;

public class CallEventOccurrence extends EventOccurrence implements ICallEventOccurrence {

	public ICallEventExecution execution;
	
	public Operation getOperation(){
		// Get the operation being called by this call event occurrence.
		return this.execution.getOperation();
	}
	
	@Override
	public boolean match(Trigger trigger) {
		// Match a trigger if it references a call event whose operation is the
		// operation of this call event occurrence.
		boolean matches = false;
		if (trigger.getEvent() instanceof CallEvent) {
			CallEvent callEvent = (CallEvent)trigger.getEvent();
			matches = callEvent.getOperation() == this.getOperation();
		}
		return matches;
	}

	@Override
	public List<IParameterValue> getParameterValues() {
		// Return the input parameter values from the call event execution for
		// this call event occurrence, which correspond to the values of the
		// operation input parameters for the call.
		List<IParameterValue> parameterValues = new ArrayList<IParameterValue>();
		if (this.execution != null) {
			parameterValues = this.execution.getInputParameterValues();
		}			
		return parameterValues;
	}
	
	public void suspendCaller(){
		// Suspend the caller
		this.execution.setCallerSuspended(true);
	}

	public void returnFromCall(){
		// Release the caller on return from the call.
		this.execution.setCallerSuspended(false);
	}

	public void setOutputParameterValues(List<IParameterValue> parameterValues){
		// this call event occurrence, which correspond to the values of the
		// operation output parameters for the call.
		if (this.execution != null) {
			this.execution.setOutputParameterValues(parameterValues);
		}
	}
	
	@Override
	public void sendTo(IReference target) {
		// The caller is suspended and then the event occurrence
		// is forwarded to the target object.
		this.suspendCaller();
		super.sendTo(target);
	}

	@Override
	public void setCallEventExecution(ICallEventExecution execution) {
		this.execution = execution;
	}

	@Override
	public ICallEventExecution getCallEventExecution() {
		return this.execution;
	}
}