/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.kernel.engine;

import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.debug.core.model.ITerminate;

public interface IExecutionEngine extends ITerminate {
	
	/**
	 * Set the ID associated with this engine
	 * 
	 * @param id the id
	 */
	void setID(final String id);
	
	/**
	 * Return the ID associated with this engine
	 * 
	 * @return the id
	 */
	String getID();
	
	/**
	 * Return the configuration attached to this engine
	 * 
	 * @return the configuration
	 */
	EngineConfiguration getConfiguration();
	
	/**
	 * Run this engine based on the provided configuration
	 * 
	 * @param configuration
	 * 	the configuration providing information regarding the execution
	 *  that needs to be performed
	 * 
	 * @param monitor
	 *  provide the opportunity to report progress
	 */
	void run(final EngineConfiguration configuration, SubMonitor monitor);
	
}
