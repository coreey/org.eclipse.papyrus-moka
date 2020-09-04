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

public interface ITaskExecutionCondition<ThreadType> {

	/**
	 * Evaluate the condition
	 * 
	 * @param task the task used a parameter for the evaluation
	 * 
	 * @return true if the condition is verified, false otherwise
	 */
	boolean evaluate(ThreadType task);

}
