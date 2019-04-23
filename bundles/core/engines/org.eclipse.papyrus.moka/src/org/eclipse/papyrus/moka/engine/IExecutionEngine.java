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
package org.eclipse.papyrus.moka.engine;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.emf.ecore.EObject;

public interface IExecutionEngine {

	public void init(ILaunch launch, final EObject executionEntryPoint, String[] executionArgs, OperatingMode mode);

	public void start(IProgressMonitor monitor);

	public void stop(IProgressMonitor monitor);
	
	public enum OperatingMode{
		NORMAL, // Services (animation, debug, etc) are notified by engine at runtime
		QUIET,  // Services (animation, debug, etc) are NOT notified by engine at runtime
	}
	
}
