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
package org.eclipse.papyrus.moka.kernel.engine;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.kernel.service.ServiceOperatingMode;

public class EngineConfiguration<SourceElementType extends EObject> {

	// The project containing the model to be executed
	protected IProject project;
	
	// Determine if services should run or not
	protected ServiceOperatingMode mode;

	// The URI of the executed model
	protected URI modelURI;
	
	// The model element that is used as a starting point for the execution
	protected SourceElementType source;

	// The list of parameter passed to the execution engine
	protected Map<String, String> parameters;

	protected String traceFilePath;
	
	protected String formatterID;
	
	protected boolean traceEnabled;
	
	protected boolean tracepointMode;

	public EngineConfiguration() {
		mode = ServiceOperatingMode.NORMAL;
		parameters = new HashMap<String, String>();
	}

	public EngineConfiguration(SourceElementType src, ServiceOperatingMode m) {
		source = src;
		mode = m;
		parameters = new HashMap<String, String>();
	}
	
	public EngineConfiguration(EngineConfiguration<SourceElementType> ec) {
		source = ec.getExecutionSource();
		mode = ec.getMode();
		parameters = new HashMap<String, String>();
		for(Map.Entry<String, String> p : ec.getParameters().entrySet()) {
			parameters.put(p.getKey(), p.getValue());
		}
		project = ec.getProject();
		modelURI = ec.getModelURI();
		traceFilePath = ec.getTraceFilePath();
		formatterID = ec.getFormatterID();
		traceEnabled = ec.isTraceEnabled();
		tracepointMode = ec.isTracepointMode();
	}

	public void setExecutionSource(final SourceElementType src) {
		source = src;
	}

	public SourceElementType getExecutionSource() {
		return source;
	}

	public void setMode(final ServiceOperatingMode m) {
		mode = m;
	}

	public ServiceOperatingMode getMode() {
		return mode;
	}

	public boolean addParameter(final String name, final String value) {
		return parameters.put(name, value) != null;
	}

	public boolean removeParameter(final String name) {
		if (parameters.containsKey(name)) {
			return parameters.remove(name) != null;
		}
		return false;
	}

	public String getParameter(String parameterName) {
		return parameters.get(parameterName);
	}

	public Map<String, String> getParameters() {
		return parameters;
	}
	
	public IProject getProject() {
		return project;
	}

	public void setProject(IProject project) {
		this.project = project;
	}

	public URI getModelURI() {
		return modelURI;
	}

	public void setModelURI(URI modelURI) {
		this.modelURI = modelURI;
	}
	
	public String getTraceFilePath() {
		return traceFilePath;
	}

	public void setTraceFilePath(String traceFilePath) {
		this.traceFilePath = traceFilePath;
	}
	
	
	public String getFormatterID() {
		return formatterID;
	}

	public void setFormatterID(String formatterID) {
		this.formatterID = formatterID;
	}

	public boolean isTraceEnabled() {
		return traceEnabled;
	}

	public void setTraceEnabled(boolean traceEnabled) {
		this.traceEnabled = traceEnabled;
	}

	public void setTracepointMode(boolean mode) {
		tracepointMode = mode;
	}
	
	public boolean isTracepointMode() {
		return this.tracepointMode;
	}

}
