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

import org.eclipse.papyrus.moka.kernel.scheduling.execution.ITaskExecution;

public interface IExecutionLoop extends ITerminate, ISuspend, IResume{

	
	/**
	 * Initialize the loop with a root execution and a scheduler 
	 * 
	 * @param execution
	 * 		the root execution
	 *
	 * @param scheduler
	 * 		the scheduler handling execution scheduling
	 */
	void init(ITaskExecution task, IScheduler sched);
	
	
	/**
	 * Include this execution to the set of execution handled
	 * by this execution loop 
	 * 
	 * @param execution
	 * 		the execution to be included
	 */
	boolean include(ITaskExecution task);
	
	
	/**
	 * Run the loop (i.e., execute the execution handled by the loop
	 * according to the scheduler scheduling policy)
	 */
	void run();
	
	/**
	 * Perform an iteration in the execution loop
	 */
	boolean step();
	
	
}
