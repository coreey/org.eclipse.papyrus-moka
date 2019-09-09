/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.profiling.loci;

import org.eclipse.papyrus.moka.fuml.commonbehavior.IExecution;
import org.eclipse.papyrus.moka.fuml.loci.IExecutionFactory;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IObject_;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.OpaqueBehavior;

public aspect ExecutionFactoryProfiler extends ValueLifecycleObservable{

	pointcut createExecution(IExecutionFactory factory, Behavior behavior, IObject_ context):
		target(factory) &&
		args(behavior, context) &&
		call(* IExecutionFactory.createExecution(Behavior, IObject_));
	
	after(IExecutionFactory factory, Behavior behavior, IObject_ context) returning (IExecution execution): 
		 createExecution(factory, behavior, context){
		// The creation of an execution for a behavior is only notified if the
		// the behavior for which the execution created is not an OpaqueBehavior
		// and the execution is its own context (this implies the behavior is executed
		// outside an instance of class)
		if(!(behavior instanceof OpaqueBehavior) && execution == execution.getContext()) {
			this.fireValueCreated(execution);
		}
	}
	
}
