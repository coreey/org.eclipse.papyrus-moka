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

public abstract class ExecutionEngineService<EngineType extends IExecutionEngine> implements IExecutionEngineService<EngineType> {

	// Engine that requested the service to run
	protected EngineType engine;
	
	public void init(EngineType engine) {
		// By default keep  - convenience for services which do not need to know
		// the model that is currently related to this instance of the execution
		this.engine = engine;
	}

	public void dispose(EngineType engine) {
		// By default do nothing - convenience for services which do not need to dispose
		// any resource.
		
	}

}
