/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
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

package org.eclipse.papyrus.moka.kernel.service;

import org.eclipse.papyrus.moka.kernel.engine.IExecutionEngine;

public interface IExecutionEngineService<E extends IExecutionEngine> {

	/**
	 * Let any service know the model on which the current execution is focused.
	 * Users are not intended to call directly this operation. It is automatically
	 * called as soon as the execution begin
	 * 
	 * @param engine engine notifying this service
	 */
	public void init(E engine);

	/**
	 * Let any service release all its resources when the execution terminates Users
	 * are not intended to call directly this operation. It is automatically called
	 * as soon as the execution terminates
	 * 
	 *  @param engine engine notifying this service
	 */
	public void dispose(E engine);

}
