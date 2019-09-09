/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.launch;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.moka.kernel.engine.IExecutionEngine;

public interface IExecutionEngineLaunchConfigurationReader {
	
	public IProject getProject();
	
	IExecutionEngine getEngine();
	
	URI getModelDIURI();
	
	URI getModelURI();
	
	URI getExecutionSourceURI();
	
	String getExecutionEngineID();
	
	String getTraceFile();
	
	String getTraceFormatterID();
	
	boolean isTraceServiceEnabled();
	
	boolean isTracePointMode();
	
}
