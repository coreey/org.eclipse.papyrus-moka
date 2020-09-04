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
package org.eclipse.papyrus.moka.debug.engine;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IVariable;

public interface IDebuggableExecutionEngineThread<ThreadType, SuspensionContextType> extends IAdaptable {

	String getID();

	void setID(final String identifier);

	ThreadType getThread();

	void setThread(final ThreadType t);

	SuspensionContextType getSuspensionContext();

	void setSuspensionContext(final SuspensionContextType c);

	List<IVariable> getVariables(final IDebugTarget target);

}
