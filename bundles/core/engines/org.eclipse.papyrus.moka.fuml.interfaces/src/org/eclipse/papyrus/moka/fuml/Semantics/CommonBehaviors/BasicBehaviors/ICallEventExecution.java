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

package org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.uml2.uml.Operation;

public interface ICallEventExecution extends IExecution{
	
	public Operation getOperation();
	
	public void makeCall();
	
	public IEventOccurrence createEventOccurrence();
	
	public List<IParameterValue> getInputParameterValues();
	
	public void setOutputParameterValues(List<IParameterValue> parameterValues);
	
	public boolean isCallerSuspended();
	
	public void setCallerSuspended(boolean callerSuspended);
	
	public void suspend();
	
	public void wait_();
	
}
