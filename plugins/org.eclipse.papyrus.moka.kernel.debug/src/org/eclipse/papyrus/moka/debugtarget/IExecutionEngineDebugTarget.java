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

import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.papyrus.moka.debug.engine.IDebuggableExecutionEngine;
import org.eclipse.papyrus.moka.debug.messages.ThreadRequest;

public interface IExecutionEngineDebugTarget extends IDebugTarget, IExecutionEngineDebugElement{

	/**
	 * Return the debuggable execution engine associated with this target
	 * 
	 * @return the execution engine
	 */
	IDebuggableExecutionEngine<?, ?> getExecutionEngine();
	
	/**
	 * Return the thread corresponding to this id (or null if exists no corresponding thread)
	 * 
	 * @param threadId
	 *  id of the thread
	 * 
	 * @return
	 *  the thread with this id
	 */
	ExecutionEngineThread getThread(final String threadId);
	
	/**
	 * Return the client associated with the debug target
	 * 
	 * @return the client
	 */
	IExecutionEngineDebugTargetClient getClient();
	
	/**
	 * Account for the creation of the thread in the execution engine
	 * 
	 * @param request the received request
	 * 
	 */
	void handleTargetThreadCreateEvent(ThreadRequest request);
	
	/**
	 * Account for the termination of the thread in the execution engine
	 * 
	 * @param request the received request
	 * 
	 */
	void handleTargetThreadTerminateEvent(ThreadRequest request);
	
	
	/**
	 * Account for the termination of the execution engine
	 */
	void handleTargetTerminateEvent();
	
}
