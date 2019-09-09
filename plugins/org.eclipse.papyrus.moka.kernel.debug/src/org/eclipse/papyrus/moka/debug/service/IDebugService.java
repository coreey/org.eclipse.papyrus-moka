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
package org.eclipse.papyrus.moka.debug.service;

import org.eclipse.papyrus.moka.debug.engine.IDebuggableExecutionEngineThread;

public interface IDebugService<ThreadType, ContextType>{

	/**
	 * Request the execution engine to be suspended 
	 * 
	 * @return
	 */
	boolean requestSuspendEngine();
	
	/**
	 * Request the execution engine to be resumed
	 * 
	 * @return
	 */
	boolean requestResumeEngine();
	
	/**
	 * Request the execution engine to terminate
	 * 
	 * @return
	 */
	boolean requestTerminateEngine();
	
	/**
	 * Request an execution engine thread to be suspended
	 * 
	 * @param identifier of the thread to be suspended
	 * 
	 * @return
	 */
	boolean requestSuspendThread(String identifier);
	
	/**
	 * Request an execution engine thread to be resumed
	 * 
	 * @param identifier of the thread to be suspended
	 * 
	 * @return
	 */
	boolean requestResumeThread(String identifier);
	
	/**
	 * Request an execution engine thread to be terminated
	 * 
	 * @param identifier of the thread to be suspended
	 * 
	 * @return
	 */
	boolean requestTerminateThread(String identifier);
	
	/**
	 * Realize execution engine suspension
	 */
	void suspendEngine();
	
	/**
	 * Realize execution engine thread suspension
	 * 
	 * @param thread to be suspended
	 * 
	 * @param context of the suspension
	 */
	void suspendThread(IDebuggableExecutionEngineThread<ThreadType, ContextType> thread);
	
	/**
	 * Realize execution engine termination
	 */
	void terminateEngine();
	
	/**
	 * Realize execution engine thread termination
	 * 
	 * @param thread to be terminated
	 */
	void terminateThread(IDebuggableExecutionEngineThread<ThreadType, ContextType> thread);
	
	/**
	 * Notify termination of the execution engine
	 */
	void fireTerminateEngineEvent();
	
	
}
