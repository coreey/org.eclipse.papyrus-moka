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
package org.eclipse.papyrus.moka.fuml.tasks;

import org.eclipse.papyrus.moka.fuml.commonbehavior.IExecution;

public interface IUMLEventDispatchLoopExecution extends IExecution{
	
	/**
	 * Make the event dispatch loop to dispatch the next event
	 */
	void dispatchNextEvent();
	
	/**
	 * Let the event dispatch loop account for the arrival of a new signal
	 */
	public void newSignalArrival();
	
}
