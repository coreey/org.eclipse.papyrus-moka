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
package org.eclipse.papyrus.moka.kernel.scheduling.execution;

import org.eclipse.papyrus.moka.kernel.scheduling.control.IResume;
import org.eclipse.papyrus.moka.kernel.scheduling.control.ISuspend;
import org.eclipse.papyrus.moka.kernel.scheduling.control.ITerminate;

public interface ITaskExecution extends ITerminate, ISuspend, IResume{

	/**
	 * Get the status of this task
	 * 
	 * @return task status
	 */
	TaskExecutionStatus getStatus();
	
	/**
	 * Set the status of this task
	 * 
	 * @param task status
	 */
	void setStatus(TaskExecutionStatus status);
	
	/**
	 * Check if this task can be executed
	 * 
	 * @return true if it can be executed and false otherwise
	 */
	boolean canExecute();

	/**
	 * Execute the task
	 */
	void execute();

}
