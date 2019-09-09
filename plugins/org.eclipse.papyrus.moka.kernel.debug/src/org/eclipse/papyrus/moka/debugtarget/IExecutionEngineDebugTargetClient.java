/*****************************************************************************
 * Copyright (c) 2019 CEA LIST.
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
package org.eclipse.papyrus.moka.debugtarget;

public interface IExecutionEngineDebugTargetClient {

	/**
	 * Send a request to resume the execution engine
	 * 
	 * @return true if the request was sent and false otherwise
	 */
	boolean fireResumeEngineEvent();

	/**
	 * Send a request to suspend the execution engine
	 * 
	 * @return true if the request was sent and false otherwise
	 */
	boolean fireSuspendEngineEvent();

	/**
	 * Send a request to suspend the specified execution engine thread
	 * 
	 * @param thread
	 * 		the thread to be suspended
	 * 
	 * @return true if the request was sent and false otherwise
	 */
	boolean fireSuspendThreadEvent(IExecutionEngineThread thread);
	
	/**
	 * Send a request to resume the specified execution engine thread
	 * 
	 * @param thread
	 * 		the thread to be resumed
	 * 
	 * @return true if the request was sent and false otherwise
	 */
	boolean fireResumeThreadEvent(IExecutionEngineThread thread);
	
	/**
	 * Send a request to terminate the specified engine thread
	 * 
	 * @param thread
	 * 		the thread to be terminated; 
	 * @return
	 */
	boolean fireTerminateThreadEvent(IExecutionEngineThread thread);

}
