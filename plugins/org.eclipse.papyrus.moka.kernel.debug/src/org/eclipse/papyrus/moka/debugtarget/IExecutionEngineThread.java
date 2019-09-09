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
package org.eclipse.papyrus.moka.debugtarget;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IThread;

public interface IExecutionEngineThread extends IThread{
	
	/**
	 * Return the ID associated with this thread
	 * @return id
	 */
	String getID();
	
	/**
	 * Handle the thread suspension required by the targeted execution engine
	 * 
	 * @param detail
	 * 		suspension request detail
	 * @throws DebugException
	 */
	void handleSuspendEvent(int supensionDetail);
	
}
