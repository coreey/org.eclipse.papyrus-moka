/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
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
 *   CEA LIST - Bug 551906, Bug 552564
 *   
 *****************************************************************************/
package org.eclipse.papyrus.moka.trace.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.moka.fuml.loci.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.profiling.listeners.ISemanticVisitorExecutionListener;
import org.eclipse.papyrus.moka.kernel.assistant.Suspension;
import org.eclipse.papyrus.moka.kernel.engine.EngineConfiguration;
import org.eclipse.papyrus.moka.kernel.engine.IExecutionEngine;
import org.eclipse.papyrus.moka.kernel.service.ExecutionEngineService;
import org.eclipse.papyrus.moka.trace.Activator;
import org.eclipse.papyrus.moka.trace.capture.CaptureServiceRegistry;
import org.eclipse.papyrus.moka.trace.formater.TraceFileFormaterRegistry;
import org.eclipse.papyrus.moka.trace.interfaces.capture.ICaptureServiceFactory;
import org.eclipse.papyrus.moka.trace.interfaces.capture.ITraceCaptureService;
import org.eclipse.papyrus.moka.trace.interfaces.format.ITraceFileFormater;
import org.eclipse.papyrus.moka.trace.model.mokatraceservice.MokaTrace;
import org.eclipse.papyrus.moka.tracepoint.service.MarkerUtils;
import org.eclipse.papyrus.moka.tracepoint.service.TracepointConstants;

public class TraceGenerationService extends ExecutionEngineService<IExecutionEngine>
		implements ISemanticVisitorExecutionListener {

	public static final String FILE_NAME = "trace";

	protected ICaptureServiceFactory captureServiceFactory;

	protected List<ITraceFileFormater> formaters;

	protected String traceDirectory;

	protected MokaTrace trace;

	protected boolean isTraceServiceActivate = false;

	protected boolean tracepointMode = false;

	protected Set<EObject> tracepoints;

	// TODO should implement a cache for ITraceCaptureService
	@Override
	public void init(IExecutionEngine engine) {
		super.init(engine);
		EngineConfiguration<? extends EObject> configuration = engine.getConfiguration();
		if (configuration != null && configuration.isTraceEnabled()) {
			this.isTraceServiceActivate = configuration.isTraceEnabled();
			this.formaters = Collections.singletonList(
					TraceFileFormaterRegistry.INSTANCE.getFormaterFromID(configuration.getFormatterID()));
			this.traceDirectory = configuration.getTraceFilePath();
			this.captureServiceFactory = CaptureServiceRegistry.INSTANCE
					.getCaptureService(this.formaters.iterator().next().getCaptureId());
			this.trace = captureServiceFactory.createTraceElement();
			captureServiceFactory.startTraceElement(trace);
			this.tracepointMode = configuration.isTracepointMode();
			initTracePoint(configuration.getExecutionSource());
		}
	}

	protected void initTracePoint(EObject modelElement) {
		tracepoints = new HashSet<>();
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

		try {
			if (root != null) {
				IMarker tracePoints[];
				tracePoints = root.findMarkers(TracepointConstants.tracepointMarker, true, IResource.DEPTH_INFINITE);
				for (IMarker tracePointObj : tracePoints) {
					if (tracePointObj instanceof IMarker) {
						IMarker tracePoint = (IMarker) tracePointObj;
						ResourceSet resourceSet = modelElement.eResource().getResourceSet();
						EObject eobj = MarkerUtils.getEObjectOfMarker(resourceSet, tracePoint);
						this.tracepoints.add(eobj);
					}
				}
			}
		} catch (CoreException e) {
			Activator.getDefault().logger.error("Error occured while finding markers for "+root,e);
		}

	}

	@Override
	public void dispose(IExecutionEngine engine) {
		super.dispose(engine);
		if (this.isTraceServiceActivate) {
			for (ITraceFileFormater formater : formaters) {
				String path = getDirectoryPath(formater);
				formater.rightTrace(path, trace);
			}
		}
	}

	private String getDirectoryPath(ITraceFileFormater formater) {
		IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
		String workspacePath = workspace.getLocation().toFile().getPath().toString();
		IFile currentFile = null;

		// Search a file in the workspace
		try {
			currentFile = workspace.getFileForLocation(new Path(workspacePath + traceDirectory));
		} catch (IllegalArgumentException ex) {
			// Ignore
		}
		if (currentFile != null) {
			return workspacePath + traceDirectory;
		}

		// Search a folder in the workspace
		IContainer currentFolder = null;
		try {
			currentFolder = workspace.getContainerForLocation(new Path(workspacePath + traceDirectory));
		} catch (IllegalArgumentException ex) {
			// Ignore
		}
		if (currentFolder != null && currentFolder.exists()) {
			return workspacePath + traceDirectory;
		}

		// The folder or the file is in the disk
		return traceDirectory;
	}

	@Override
	public void nodeVisited(ISemanticVisitor nodeVisitor) {
		if (shouldTrace(nodeVisitor)) {
			ITraceCaptureService tracer = captureServiceFactory.getCaptureService(nodeVisitor);
			if (tracer != null) {
				tracer.traceBeforeNode(nodeVisitor, trace);
			}
		}
	}

	@Override
	public void nodeLeft(ISemanticVisitor nodeVisitor) {
		if (shouldTrace(nodeVisitor)) {
			ITraceCaptureService tracer = captureServiceFactory.getCaptureService(nodeVisitor);
			if (tracer != null) {
				tracer.traceAfterNode(nodeVisitor, trace);
			}
		}
	}

	protected boolean shouldTrace(ISemanticVisitor nodeVisitor) {
		return isTraceServiceActivate && ((tracepointMode
				&& captureServiceFactory.isVisitorConcernedByTracepoints(this.tracepoints, nodeVisitor))
				|| !tracepointMode);
	}

	@Override
	public void nodeSuspended(ISemanticVisitor visitor, Suspension suspension) {
		// do nothing
	}

}
