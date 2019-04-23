/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.control.queue;

import org.eclipse.papyrus.moka.fuml.control.execution.RootExecution;

public class ExecutionController {

	// The manager is a singleton
	private static ExecutionController INSTANCE;
	
	private ExecutionController(){}
	
	protected ExecutionLoop executionLoop;
	
	public static ExecutionController getInstance(){
		// Instantiate the manager if required and return the
		// singleton instance 
		if(INSTANCE == null){
			INSTANCE = new ExecutionController();
		}
		return INSTANCE;
	}
	
	public void setExecutionLoop(ExecutionLoop loop) {
		this.executionLoop = loop;
	}
	
	public ExecutionLoop getExecutionLoop() {
		return this.executionLoop;
	}
	
	public void start(RootExecution rootExecution){
		if(this.executionLoop != null){
			this.executionLoop.start(rootExecution);
		}else {
			throw new RuntimeException("Execution loop cannot be null");
		}
	}
}
