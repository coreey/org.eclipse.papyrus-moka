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

public interface IScheduler extends ITerminate, ISuspend, IResume{
	
	/**
	 * Set a scheduling strategy
	 * 
	 * @param strategy
	 * 		the strategy to be used by the scheduler
	 */
	public void setStrategy(ISchedulingStrategy strategy);
	
	/**
	 * Return the next task to be executed
	 * 
	 * @return the next task or null
	 */
	public ITaskExecution next();
	
	/**
	 * Check if the scheduler has a next execution available
	 * 
	 * @return true if an execution is available and false otherwise
	 */
	public boolean hasNext();
	
	/**
	 * Add the execution to the collection of execution handled by the scheduler
	 * 
	 * @param execution
	 * 		the execution to be scheduled
	 */
	public void schedule(ITaskExecution task);
	
}
