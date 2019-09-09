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

import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.papyrus.moka.kernel.scheduling.execution.ITaskExecution;
import org.eclipse.papyrus.moka.kernel.scheduling.execution.ITaskExecutionCondition;
import org.eclipse.papyrus.moka.kernel.scheduling.execution.TaskExecutionStatus;

public class Scheduler implements IScheduler {

	/**
	 * Queue containing execution to be executed
	 */
	protected ExecutionQueue taskQueue;

	/**
	 * Enable thread safe access to the queue of task to be executed
	 */
	protected ReentrantLock taskQueueLock;

	/**
	 * Strategy used to choose the next execution to be scheduled
	 */
	protected ISchedulingStrategy strategy;

	/**
	 * Task currently selected by the scheduler
	 */
	private ITaskExecution currentTask;

	public Scheduler() {
		taskQueue = new ExecutionQueue();
		taskQueueLock = new ReentrantLock(true);
		strategy = new FIFOSchedulingStrategy();
		currentTask = null;
	}

	/**
	 * @see {@link IScheduler#setStrategy(ISchedulingStrategy)}
	 */
	@Override
	public void setStrategy(ISchedulingStrategy s) {
		if (s != null) {
			strategy = s;
		}
	}

	/**
	 * @see {@link IScheduler#next()}
	 */
	@Override
	public ITaskExecution next() {
		taskQueueLock.lock();
		currentTask = strategy.select(taskQueue);
		taskQueueLock.unlock();
		return currentTask;
	}

	/**
	 * @see {@link IScheduler#hasNext()}
	 */
	@Override
	public boolean hasNext() {
		boolean hasNext = false;
		taskQueueLock.lock();
		hasNext = !taskQueue.isEmpty();
		taskQueueLock.unlock();
		return hasNext;
	}

	/**
	 * @see {@link IScheduler#schedule()}
	 */
	@Override
	public void schedule(ITaskExecution task) {
		if (task != null) {
			if (taskQueueLock.tryLock()) {
				taskQueue.offer(task);
				task.setStatus(TaskExecutionStatus.SCHEDULED);
				taskQueueLock.unlock();
			}
		}
	}

	/**
	 * @see {@link IScheduler#terminate()}
	 */
	@Override
	public void terminate() {
		if (currentTask != null) {
			currentTask.terminate();
			currentTask = null;
		}
		taskQueueLock.lock();
		for (Iterator<ITaskExecution> it = taskQueue.iterator(); it.hasNext();) {
			ITaskExecution task = it.next();
			task.terminate();
			task.setStatus(TaskExecutionStatus.TERMINATED);
			it.remove();
		}
		taskQueueLock.unlock();
	}

	@Override
	public void terminate(ITaskExecutionCondition condition) {
		if (currentTask != null) {
			if (condition.evaluate(currentTask)) {
				currentTask.terminate();
				currentTask = null;
			}
		}
		taskQueueLock.lock();
		for (Iterator<ITaskExecution> it = taskQueue.iterator(); it.hasNext();) {
			ITaskExecution task = it.next();
			if (condition.evaluate(task)) {
				task.terminate();
				task.setStatus(TaskExecutionStatus.TERMINATED);
				it.remove();
			}
		}
		taskQueueLock.unlock();
	}

	@Override
	public void suspend() {
		if (currentTask != null) {
			currentTask.suspend();
			currentTask.setStatus(TaskExecutionStatus.SUSPENDED);
		}
		taskQueueLock.lock();
		for (Iterator<ITaskExecution> it = taskQueue.iterator(); it.hasNext();) {
			ITaskExecution task = it.next();
			task.suspend();
			task.setStatus(TaskExecutionStatus.SUSPENDED);
		}
		taskQueueLock.unlock();
	}

	@Override
	public void suspend(ITaskExecutionCondition condition) {
		if (currentTask != null) {
			if (condition.evaluate(currentTask)) {
				currentTask.suspend();
				currentTask.setStatus(TaskExecutionStatus.SUSPENDED);
			}
		}
		taskQueueLock.lock();
		for (Iterator<ITaskExecution> it = taskQueue.iterator(); it.hasNext();) {
			ITaskExecution task = it.next();
			if (condition.evaluate(task)) {
				task.suspend();
				task.setStatus(TaskExecutionStatus.SUSPENDED);
			}
		}
		taskQueueLock.unlock();
	}

	@Override
	public void resume() {
		if(currentTask != null) {
			currentTask.setStatus(TaskExecutionStatus.SCHEDULED);
			currentTask.resume();
		}
		taskQueueLock.lock();
		for (Iterator<ITaskExecution> it = taskQueue.iterator(); it.hasNext();) {
			ITaskExecution task = it.next();
			task.setStatus(TaskExecutionStatus.SCHEDULED);
			task.resume();
		}
		taskQueueLock.unlock();
	}

	@Override
	public void resume(ITaskExecutionCondition condition) {
		if(currentTask != null) {
			if(condition.evaluate(currentTask)) {
				currentTask.setStatus(TaskExecutionStatus.SCHEDULED);
				currentTask.resume();
			}
		}
		taskQueueLock.lock();
		for (Iterator<ITaskExecution> it = taskQueue.iterator(); it.hasNext();) {
			ITaskExecution task = it.next();
			if (condition.evaluate(task)) {
				task.setStatus(TaskExecutionStatus.SCHEDULED);
				task.resume();
			}
		}
		taskQueueLock.unlock();
	}

}
