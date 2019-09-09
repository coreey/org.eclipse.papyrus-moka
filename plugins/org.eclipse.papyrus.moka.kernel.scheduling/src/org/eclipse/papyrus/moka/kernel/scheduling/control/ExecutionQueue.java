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

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.papyrus.moka.kernel.scheduling.execution.ITaskExecution;

public final class ExecutionQueue extends AbstractQueue<ITaskExecution> {

	/**
	 * The pool of task maintained by the queue
	 */
	private ArrayList<ITaskExecution> pool;

	public ExecutionQueue() {
		this.pool = new ArrayList<ITaskExecution>();
	}

	/**
	 * @see {@link AbstractQueue#offer(Object)}
	 * 
	 *      The provided task is always added at the end of the queue. This
	 *      operation returns false if the provided task is null and true
	 *      otherwise.
	 */
	public boolean offer(ITaskExecution e) {
		if (e == null) {
			return false;
		}
		this.pool.add(e);
		return true;
	}

	/**
	 * Retrieves and remove the task at the specified index
	 * 
	 * @param index the index at which the element is removed
	 * 
	 * @return the element removed at the specified index or null
	 */
	public ITaskExecution poll(int index) {
		//
		ITaskExecution task = null;
		if (index >= 0 && index < pool.size()) {
			task = pool.remove(index);
		}
		return task;
	}

	/**
	 * @see {@link AbstractQueue#poll()}
	 */
	public ITaskExecution poll() {
		if (this.pool.isEmpty()) {
			return null;
		}
		return this.pool.remove(0);
	}

	/**
	 * @see {@link AbstractQueue#peek()}
	 */
	public ITaskExecution peek() {
		if (this.pool.isEmpty()) {
			return null;
		}
		return this.pool.get(0);
	}

	/**
	 * @see {@link AbstractQueue#iterator()}
	 */
	@Override
	public Iterator<ITaskExecution> iterator() {
		return this.pool.iterator();
	}

	/**
	 * @see {@link AbstractQueue#size()}
	 */
	@Override
	public int size() {
		return this.pool.size();
	}

}