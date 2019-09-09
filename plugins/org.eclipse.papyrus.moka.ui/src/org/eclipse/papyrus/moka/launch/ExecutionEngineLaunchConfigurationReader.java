/*****************************************************************************
 * Copyright (c) 2019 CEA LIST.
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

	// Configuration attribute referencing the URI of the model
	public static String MODEL_URI_ATTRIBUTE_NAME = "URI_ATTRIBUTE";

	// Configuration attribute referencing the URI of the model element
	// that will be the source of the execution
	public static String MODEL_ELEMENT_URI_ATTRIBUTE_NAME = "FRAGMENT_ATTRIBUTE";

	// Configuration attribute referencing the engine to be used to
	// perform the execution
	public final static String EXECUTION_ENGINE_ATTRIBUTE_NAME = "EXECUTION_ENGINE_ATTRIBUTE";

	// The constant for trace file path of the run configuration argument
	public static final String MOKA_TRACE_FILE_PATH = "MOKA_TRACE_FILE_PATH";
	
	// The constant for trace formater of the run configuration argument
	public static final String MOKA_TRACE_FORMATER = "MOKA_TRACE_FORMATER";
	
	// The constant to define in the configuration if the trace service is activate */
	public static final String MOKA_TRACE_SERVICE_ACTIVATE = "MOKA_TRACE_SERVICE_ACTIVATE";
	
	// The constant to define in the configuration if the tracepoint mode should be is activate */
	public static final String MOKA_TRACE_TRACEPOINT_MODE = "MOKA_TRACE_TRACEPOINT_MODE";
	
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
			uri = URI.createURI(modelURI.toString().replaceFirst(".uml", ".di"));
		}
		return uri;
	}

	public URI getModelURI() {
		// Return the URI of the referenced model if any
		URI uri = null;
		if (configuration != null) {
			try {
				uri = URI.createURI(configuration.getAttribute(MODEL_URI_ATTRIBUTE_NAME, ""));
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
				uri = URI.createURI(configuration.getAttribute(MODEL_ELEMENT_URI_ATTRIBUTE_NAME, ""));
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
				engineID = configuration.getAttribute(EXECUTION_ENGINE_ATTRIBUTE_NAME, "");
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
				traceFile = configuration.getAttribute(MOKA_TRACE_FILE_PATH, "");
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
				traceFormatterID = configuration.getAttribute(MOKA_TRACE_FORMATER, "");
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
