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
package org.eclipse.papyrus.moka.kernel.scheduling.control;


public class ExecutionController implements IExecutionController{

	/**
	 * Execution loop associated with the controller
	 */
	protected IExecutionLoop loop;
	
	public void setExecutionLoop(IExecutionLoop l) {
		loop = l;
	}
	
	public IExecutionLoop getExecutionLoop() {
		return loop;
	}
	
	/**
	 * Start the controller execution. It implies to start the loop.
	 */
	public void start(){
		if(this.loop != null){
			this.loop.run();
		}
	}
}
