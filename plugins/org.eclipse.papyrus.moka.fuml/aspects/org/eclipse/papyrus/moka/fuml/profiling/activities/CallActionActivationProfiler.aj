/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
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
 *   CEA LIST - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.profiling.activities;

import org.eclipse.papyrus.moka.fuml.actions.ICallActionActivation;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IExecution;
import org.eclipse.papyrus.moka.fuml.profiling.loci.SemanticVisitorProfiler;
import org.eclipse.uml2.uml.CallAction;

public aspect CallActionActivationProfiler extends SemanticVisitorProfiler{
	
	public CallActionActivationProfiler(){
		super();
	}
	
	pointcut removeCallExecution(ICallActionActivation activation, IExecution execution): 
		target(activation) &&
		args(execution) &&
		call(* ICallActionActivation.removeCallExecution(IExecution));
	
	after(ICallActionActivation activation, IExecution execution) : removeCallExecution(activation, execution){
		CallAction callAction = (CallAction) activation.getNode();
		if(callAction.isSynchronous()){
			this.leave(activation);
		}
	}
}