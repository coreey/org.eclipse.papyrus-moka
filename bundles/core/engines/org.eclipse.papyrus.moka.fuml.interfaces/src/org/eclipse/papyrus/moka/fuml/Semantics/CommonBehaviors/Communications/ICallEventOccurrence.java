/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.ICallEventExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.uml2.uml.Operation;

public interface ICallEventOccurrence extends IEventOccurrence {
	
	public Operation getOperation();
	
	public void suspendCaller();
	
	public void returnFromCall();
	
	public void setOutputParameterValues(List<IParameterValue> parameterValues);
	
	public void setCallEventExecution(ICallEventExecution execution);
	
	public ICallEventExecution getCallEventExecution();
	
}
