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

import org.eclipse.papyrus.moka.kernel.scheduling.execution.ITaskExecution;
import org.eclipse.papyrus.moka.kernel.scheduling.execution.TaskExecutionStatus;

public abstract class SchedulingStrategy implements ISchedulingStrategy {

	protected static final ExecutionQueue getScheduled(final ExecutionQueue queue) {
		ExecutionQueue scheduledQueue = new ExecutionQueue();
		for (Iterator<ITaskExecution> it = queue.iterator(); it.hasNext();) {
			ITaskExecution task = it.next();
			if (task.getStatus().equals(TaskExecutionStatus.SCHEDULED)) {
				scheduledQueue.offer(task);
			}
		}
		return scheduledQueue;
	}
}
