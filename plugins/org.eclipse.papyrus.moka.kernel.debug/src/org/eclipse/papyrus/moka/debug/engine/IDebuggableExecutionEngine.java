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
package org.eclipse.papyrus.moka.debug.engine;

import org.eclipse.debug.core.model.ISuspendResume;
import org.eclipse.papyrus.moka.debug.service.IDebugService;
import org.eclipse.papyrus.moka.engine.schedulable.IScheduledExecutionEngine;

public interface IDebuggableExecutionEngine<ThreadType, ContextType>
		extends ISuspendResume, IScheduledExecutionEngine {

	/**
	 * Get the thread corresponding to the specified identifier
	 * 
	 * @param identifier the thread identifier
	 * 
	 * @return the corresponding thread if any
	 */
	IDebuggableExecutionEngineThread<ThreadType, ContextType> getThread(final String identifier);

	/**
	 * Add the debuggable thread to the execution engine
	 * 
	 * @param t the thread to be added
	 * 
	 * @return true if it was added and false otherwise
	 */
	boolean addDebugThread(IDebuggableExecutionEngineThread<ThreadType, ContextType> t);

	/**
	 * Remove the debuggable thread from the execution engine
	 * 
	 * @param t the thread to be removed
	 * 
	 * @return if it was added and false otherwise
	 */
	boolean removeDebugThread(IDebuggableExecutionEngineThread<ThreadType, ContextType> t);

	/**
	 * Suspend the specified thread
	 * 
	 * @param thread to be suspended
	 */
	void suspendThread(IDebuggableExecutionEngineThread<ThreadType, ContextType> thread);

	/**
	 * Resume the specified thread
	 * 
	 * @param thread to be resumed
	 */
	void resumeThread(IDebuggableExecutionEngineThread<ThreadType, ContextType> thread);

	/**
	 * Terminate the specified thread
	 * 
	 * @param thread to be terminated
	 */
	void terminateThread(IDebuggableExecutionEngineThread<ThreadType, ContextType> thread);

	/**
	 * Return the debug service associated with this engine
	 * 
	 * @return the debug service
	 */
	IDebugService<ThreadType, ContextType> getDebugService();

}
