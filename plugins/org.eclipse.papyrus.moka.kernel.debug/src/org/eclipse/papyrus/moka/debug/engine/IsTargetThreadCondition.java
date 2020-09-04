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
package org.eclipse.papyrus.moka.debug.engine;

import org.eclipse.papyrus.moka.fuml.tasks.IUMLTaskExecution;
import org.eclipse.papyrus.moka.kernel.scheduling.execution.ITaskExecutionCondition;

public class IsTargetThreadCondition<ThreadType> implements ITaskExecutionCondition<ThreadType> {

	/**
	 * The target thread
	 */
	protected ThreadType thread;

	public IsTargetThreadCondition(ThreadType t) {
		thread = t;
	}

	@Override
	public boolean evaluate(ThreadType task) {
		boolean result = false;
		if (task instanceof IUMLTaskExecution) {
			result = thread != null && thread.equals(((IUMLTaskExecution) task).getContext());
		}
		return result;
	}

}
