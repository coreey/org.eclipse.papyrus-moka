/*****************************************************************************
 * Copyright (c) 2019 CEA LIST.
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
package org.eclipse.papyrus.moka.debug.target;

import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IDebugTarget;

public abstract class ExecutionEngineDebugElement extends DebugElement implements IExecutionEngineDebugElement{

	/**
	 * Status associated with this debug element
	 */
	protected DebugElementStatus status;
	
	/**
	 * Enable safe access and modification of the status
	 */
	protected ReentrantLock statusLock;
	
	public ExecutionEngineDebugElement(IDebugTarget target) {
		super(target);
		status = DebugElementStatus.NONE;
		statusLock = new ReentrantLock(true);
	}

	@Override
	public String getModelIdentifier() {
		// Use default debug model presentation
		return  null;
	}

	@Override
	public void setStatus(DebugElementStatus s) {
		statusLock.lock();
		status = s;
		statusLock.unlock();
	}

	@Override
	public DebugElementStatus getStatus() {
		DebugElementStatus s = null;
		statusLock.lock();
		s = status;
		statusLock.unlock();
		return s;
	}

}
