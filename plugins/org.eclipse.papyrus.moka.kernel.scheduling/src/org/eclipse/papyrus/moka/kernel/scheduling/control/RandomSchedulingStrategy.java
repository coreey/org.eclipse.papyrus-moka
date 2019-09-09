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

import java.util.concurrent.ThreadLocalRandom;

import org.eclipse.papyrus.moka.kernel.scheduling.execution.ITaskExecution;

public class RandomSchedulingStrategy extends SchedulingStrategy{

	/**
	 * The next task to be executed is chosen randomly. The random approach
	 * gives the opportunity to observe a wider range of possible executions.
	 * However, it also prevents the reproducibility of a particular execution 
	 * even starting from the very same initial conditions.
	 */
	@Override
	public ITaskExecution select(ExecutionQueue queue) {
		ITaskExecution task = null;
		if (queue != null && !queue.isEmpty()) {
			ExecutionQueue scheduledQueue = getScheduled(queue);
			if(!scheduledQueue.isEmpty()) {
				task = scheduledQueue.poll(ThreadLocalRandom.current().nextInt(0, scheduledQueue.size()));
				if(task != null) {
					queue.remove(task);
				}
			}
		}
		return task;
	}

}
