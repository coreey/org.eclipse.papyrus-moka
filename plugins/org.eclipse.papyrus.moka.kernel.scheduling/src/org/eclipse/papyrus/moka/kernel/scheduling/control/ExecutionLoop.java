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
import org.eclipse.papyrus.moka.kernel.scheduling.execution.ITaskExecutionCondition;

public class ExecutionLoop implements IExecutionLoop {

	/**
	 * Scheduler handling the scheduling of the execution set included in this loop
	 */
	protected IScheduler scheduler;

	/**
	 * @see {@link IExecutionLoop#init(IRootExecution, IScheduler)}
	 */
	@Override
	public void init(ITaskExecution origin, IScheduler sched) {
		scheduler = sched;
		include(origin);
	}

	/**
	 * @see {@link IExecutionLoop#include(ITaskExecution)}
	 */
	@Override
	public boolean include(ITaskExecution task) {
		boolean included = false;
		if (task != null) {
			scheduler.schedule(task);
			included = true;
		}
		return included;
	}

	/**
	 * @see {@link IExecutionLoop#run()}
	 * 
	 *      While the scheduler has an task to schedule then continue.
	 */
	public void run() {
		while (scheduler.hasNext()) {
			runNext();
		}
	}

	/**
	 * @see {@link IExecutionLoop#step()()}
	 * 
	 *      Request the scheduler to scheduler the next available task
	 */
	public boolean step() {
		return runNext();
	}

	/**
	 * If the next task is a valid task then execute this latter
	 * 
	 * @return true if a valid task was found and false otherwise
	 */
	protected boolean runNext() {
		ITaskExecution task = scheduler.next();
		if (task != null && task.canExecute()) {
			task.execute();
			return true;
		}
		return false;
	}

	/**
	 * @see {@link ITerminate#terminate()}
	 */
	@Override
	public void terminate() {
		scheduler.terminate();
	}

	/**
	 * @see {@link ITerminate#terminate(ITaskExecutionCondition)}
	 */
	public void terminate(ITaskExecutionCondition condition) {
		scheduler.terminate(condition);
	}

	/**
	 * @see {@link ISuspend#suspend()}
	 */
	@Override
	public void suspend() {
		scheduler.suspend();
	}

	/**
	 * @see {@link ISuspend#suspend(ITaskExecutionCondition)}
	 */
	@Override
	public void suspend(ITaskExecutionCondition condition) {
		scheduler.suspend(condition);
	}

	/**
	 * @see {@link IResume#resume()}
	 */
	@Override
	public void resume() {
		scheduler.resume();
	}

	/**
	 * @see {@link IResume#resume(ITaskExecutionCondition)}
	 */
	@Override
	public void resume(ITaskExecutionCondition condition) {
		scheduler.resume(condition);
	}

}