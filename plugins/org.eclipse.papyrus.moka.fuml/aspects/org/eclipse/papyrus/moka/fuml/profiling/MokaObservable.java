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

package org.eclipse.papyrus.moka.fuml.profiling;

import java.util.Collection;

import org.eclipse.papyrus.moka.kernel.engine.IExecutionEngine;
import org.eclipse.papyrus.moka.kernel.service.IExecutionEngineService;
import org.eclipse.papyrus.moka.kernel.service.ServiceRegistry;

public abstract class MokaObservable {

	/**
	 * Return all potential listeners for an observable. These listeners are
	 * execution services attached to the engine
	 * 
	 * @return all engine services
	 */
	public Collection<IExecutionEngineService<IExecutionEngine>> getListeners() {
		return ServiceRegistry.getInstance().getAllServices();
	}
	
}
