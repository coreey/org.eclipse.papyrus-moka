/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
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
package org.eclipse.papyrus.moka.engine.uml.scheduling;

import org.eclipse.papyrus.moka.kernel.scheduling.control.IExecutionLoop;

public class UMLTaskExecutionFactory implements IUMLTaskExecutionFactory{

	protected static UMLTaskExecutionFactory FACTORY; 
	
	protected IExecutionLoop executionLoop;
	
	protected UMLTaskExecutionFactory() {
		executionLoop = null;
	}

	public static UMLTaskExecutionFactory getFactory() {
		if(FACTORY == null) {
			FACTORY = new UMLTaskExecutionFactory();
		}
		return FACTORY;
	}
	
	public IExecutionLoop getExecutionLoop() {
		return executionLoop;
	}
	
	public void setExecutionLoop(IExecutionLoop loop) {
		executionLoop = loop;
	}
	
	public IUMLEventDispatchLoopExecution createEventDispatchLoopExecution() {
		return new UMLEventDispatchLoopExecution(executionLoop);
	}
	
	public IUMLEventSendingExecution createEventSendingExecution() {
		return new UMLEventSendingTaskExecution(executionLoop);
	}
	
	public IUMLRootExecution createRootExecution() {
		return new UMLRootExecution(executionLoop);
	}
	
}
