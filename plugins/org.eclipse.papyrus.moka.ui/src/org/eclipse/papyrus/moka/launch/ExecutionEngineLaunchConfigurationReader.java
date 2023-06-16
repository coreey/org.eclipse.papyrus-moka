/*****************************************************************************
 * Copyright (c) 2019, 2023 CEA LIST.
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
 *  Pauline DEVILLE (CEA LIST) pauline.deville@cea.fr - Bug 582072
 *  
 *****************************************************************************/

package org.eclipse.papyrus.moka.launch;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.moka.kernel.engine.EngineRegistry;
import org.eclipse.papyrus.moka.kernel.engine.IExecutionEngine;

public class ExecutionEngineLaunchConfigurationReader implements IExecutionEngineLaunchConfigurationReader {

	private static final String DEFAULT_VALUE_STRING = ""; //$NON-NLS-1$

	// Configuration attribute referencing the URI of the model
	public static String MODEL_URI_ATTRIBUTE_NAME = "URI_ATTRIBUTE"; //$NON-NLS-1$

	// Configuration attribute referencing the URI of the model element
	// that will be the source of the execution
	public static String MODEL_ELEMENT_URI_ATTRIBUTE_NAME = "FRAGMENT_ATTRIBUTE"; //$NON-NLS-1$

	// Configuration attribute referencing the engine to be used to
	// perform the execution
	public final static String EXECUTION_ENGINE_ATTRIBUTE_NAME = "EXECUTION_ENGINE_ATTRIBUTE"; //$NON-NLS-1$

	// The constant for trace file path of the run configuration argument
	public static final String MOKA_TRACE_FILE_PATH = "MOKA_TRACE_FILE_PATH"; //$NON-NLS-1$
	
	// The constant for trace formater of the run configuration argument
	public static final String MOKA_TRACE_FORMATER = "MOKA_TRACE_FORMATER"; //$NON-NLS-1$
	
	// The constant to define in the configuration if the trace service is activate */
	public static final String MOKA_TRACE_SERVICE_ACTIVATE = "MOKA_TRACE_SERVICE_ACTIVATE"; //$NON-NLS-1$
	
	// The constant to define in the configuration if the tracepoint mode should be is activate */
	public static final String MOKA_TRACE_TRACEPOINT_MODE = "MOKA_TRACE_TRACEPOINT_MODE"; //$NON-NLS-1$
	
	// The configuration from which information are extracted
	protected ILaunchConfiguration configuration;

	public ExecutionEngineLaunchConfigurationReader(final ILaunchConfiguration c) {
		configuration = c;
	}

	public void setConfiguration(final ILaunchConfiguration c) {
		configuration = c;
	}

	public IProject getProject() {
		// Resolve the project containing the model file that itself
		// contains the execution source
		IProject project = null;
		URI uri = getModelURI();
		if (uri != null) {
			IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
			IFile file = workspaceRoot.getFile(new Path(uri.toPlatformString(true)));
			if (file != null && file.exists()) {
				project = file.getProject();
			}
		}
		return project;
	}

	public IExecutionEngine getEngine() {
		// Return the instance of the selected execution engine
		return EngineRegistry.getInstance().getEngine(getExecutionEngineID());
	}

	public URI getModelDIURI() {
		// Return the URI of the DI model
		URI uri = null;
		URI modelURI = getModelURI();
		if (modelURI != null && !modelURI.isEmpty()) {
			if ("uml".equals(modelURI.fileExtension())) { //$NON-NLS-1$
				uri = modelURI.trimFileExtension();
				uri = uri.appendFileExtension("di"); //$NON-NLS-1$
			}
		}
		return uri;
	}

	public URI getModelURI() {
		// Return the URI of the referenced model if any
		URI uri = null;
		if (configuration != null) {
			try {
				uri = URI.createURI(configuration.getAttribute(MODEL_URI_ATTRIBUTE_NAME, DEFAULT_VALUE_STRING));
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return uri;
	}

	public URI getExecutionSourceURI() {
		// Return the URI of the referenced model element used as the execution source
		URI uri = null;
		if (configuration != null) {
			try {
				uri = URI.createURI(configuration.getAttribute(MODEL_ELEMENT_URI_ATTRIBUTE_NAME, DEFAULT_VALUE_STRING));
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return uri;
	}

	public String getExecutionEngineID() {
		// Return the ID of the selected execution engine
		String engineID = null;
		if (configuration != null) {
			try {
				engineID = configuration.getAttribute(EXECUTION_ENGINE_ATTRIBUTE_NAME, DEFAULT_VALUE_STRING);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return engineID;
	}

	@Override
	public String getTraceFile() {
		String traceFile = null;
		if (configuration != null) {
			try {
				traceFile = configuration.getAttribute(MOKA_TRACE_FILE_PATH, DEFAULT_VALUE_STRING);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return traceFile;
	}

	@Override
	public String getTraceFormatterID() {
		String traceFormatterID = null;
		if (configuration != null) {
			try {
				traceFormatterID = configuration.getAttribute(MOKA_TRACE_FORMATER, DEFAULT_VALUE_STRING);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return traceFormatterID;
	}

	@Override
	public boolean isTraceServiceEnabled() {
		boolean enabled = false;
		if(configuration != null) {
			try {
				enabled = configuration.getAttribute(MOKA_TRACE_SERVICE_ACTIVATE, false);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return enabled;
	}

	@Override
	public boolean isTracePointMode() {
		boolean tracepointMode = false;
		if (configuration != null) {
			try {
				tracepointMode = configuration.getAttribute(MOKA_TRACE_TRACEPOINT_MODE, false);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return tracepointMode;
	}

}
