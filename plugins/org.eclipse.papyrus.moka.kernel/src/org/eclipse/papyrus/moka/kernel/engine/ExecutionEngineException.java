/*****************************************************************************
 * Copyright (c) 2020 CEA LIST and others.
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
package org.eclipse.papyrus.moka.kernel.engine;

@SuppressWarnings("serial")
final public class ExecutionEngineException extends Exception {

	/**
	 * ID of the engine from which this exception was raised
	 */
	private String engineID;
	
	/**
	 * Execution engine status at the exception time
	 */
	private ExecutionEngineStatus engineStatus; 
	
	public ExecutionEngineException(String ID, ExecutionEngineStatus status, String message) {
		super(message);
		this.engineID = ID;
		this.engineStatus = status;
		
	}
	
	public ExecutionEngineException(String ID, ExecutionEngineStatus status, String message, Throwable cause) {
		super(message, cause);
		this.engineID = ID;
		this.engineStatus = status;
	}
	
	public String getEngineID() {
		return engineID;
	}
	
	public ExecutionEngineStatus getEngineStatus() {
		return engineStatus;
	}
	
}
