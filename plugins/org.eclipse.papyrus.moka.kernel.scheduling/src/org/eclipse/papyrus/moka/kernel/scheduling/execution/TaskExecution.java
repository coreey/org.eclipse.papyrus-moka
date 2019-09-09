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

import java.util.concurrent.locks.ReentrantLock;

public abstract class TaskExecution implements ITaskExecution{

	/**
	 * Status associated with the task
	 */
	protected TaskExecutionStatus status;
	
	/**Enable safe access and modification of the task status
	 * 
	 */
	protected ReentrantLock statusLock;
	
	public TaskExecution() {
		status = TaskExecutionStatus.NONE;
		statusLock = new ReentrantLock(true);
	}
	
	@Override
	public TaskExecutionStatus getStatus() {
		TaskExecutionStatus s;
		statusLock.lock();
		s = status;
		statusLock.unlock();
		return s;
	}
	
	@Override
	public void setStatus(TaskExecutionStatus s) {
		statusLock.lock();
		status = s;
		statusLock.unlock();
	}
	
	@Override
	public boolean canExecute() {
		return true;
	}
	
	/**
	 * @see {@link ITaskExecution#terminate(ICondition)}
	 */
	@Override
	public void terminate(ITaskExecutionCondition condition) {
		if(condition.evaluate(this)) {
			terminate();
		}
	}
	
	/**
	 * @see {@link ITaskExecution#suspend(ICondition)}
	 */
	@Override
	public void suspend(ITaskExecutionCondition condition) {
		if(condition.evaluate(this)) {
			suspend();
		}
	}
	
	/**
	 * @see {@link ITaskExecution#resume(ICondition)}
	 */
	@Override
	public void resume(ITaskExecutionCondition condition) {
		if(condition.evaluate(this)) {
			resume();
		}
	}
	
}
