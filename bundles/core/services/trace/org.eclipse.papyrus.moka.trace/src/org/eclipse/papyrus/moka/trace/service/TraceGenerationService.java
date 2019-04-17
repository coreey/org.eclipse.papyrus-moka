/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.moka.trace.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.service.AbstractMokaService;
import org.eclipse.papyrus.moka.service.IMokaExecutionListener;
import org.eclipse.papyrus.moka.trace.Activator;
import org.eclipse.papyrus.moka.trace.capture.CaptureServiceRegistry;
import org.eclipse.papyrus.moka.trace.formater.TraceFileFormaterRegistry;
import org.eclipse.papyrus.moka.trace.interfaces.capture.ICaptureServiceFactory;
import org.eclipse.papyrus.moka.trace.interfaces.capture.ITraceCaptureService;
import org.eclipse.papyrus.moka.trace.interfaces.format.ITraceFileFormater;
import org.eclipse.papyrus.moka.trace.model.mokatraceservice.MokaTrace;
import org.eclipse.papyrus.moka.tracepoint.service.MarkerUtils;
import org.eclipse.papyrus.moka.tracepoint.service.TracepointConstants;
import org.eclipse.papyrus.moka.utils.constants.MokaConstants;

public class TraceGenerationService extends AbstractMokaService implements IMokaExecutionListener {

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
	public void init(ILaunch launcher, EObject modelElement) {
		super.init(launcher, modelElement);
		this.isTraceServiceActivate = Boolean.parseBoolean(launcher.getAttribute(MokaConstants.MOKA_TRACE_SERVICE_ACTIVATE));
		if (this.isTraceServiceActivate) {
			String formaterID = launcher.getAttribute(MokaConstants.MOKA_TRACE_FORMATER);
			this.formaters = Collections.singletonList(TraceFileFormaterRegistry.INSTANCE.getFormaterFromID(formaterID));
			this.traceDirectory = launcher.getAttribute(MokaConstants.MOKA_TRACE_FILE_PATH);
			this.captureServiceFactory = CaptureServiceRegistry.INSTANCE.getCaptureService(this.formaters.get(0).getCaptureId());
			this.trace = captureServiceFactory.createTraceElement();
			captureServiceFactory.startTraceElement(trace);
			this.tracepointMode = Boolean.parseBoolean(launcher.getAttribute(MokaConstants.MOKA_TRACE_TRACEPOINT_MODE));
			initTracePoint(modelElement);
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
			Activator.log.error(e);
		}

	}

	@Override
	public void dispose() {
		super.dispose();
		if (isTraceServiceActivate) {
			for (ITraceFileFormater formater : formaters) {
				String path = getDirectoryPath(formater);
				formater.rightTrace(path, trace);
			}
		}
	}

	private String getDirectoryPath(ITraceFileFormater formater) {
		// Search the file in the workspace
		IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
		String workspacePath = workspace.getLocation().toFile().getPath().toString();
		IContainer currentFolder = null;
		try {
			currentFolder = workspace.getContainerForLocation(new Path(workspacePath + traceDirectory));
		} catch (IllegalArgumentException ex) {
			// Ignore
		}

		// Then search it on the disk
		if (currentFolder == null || !currentFolder.exists()) {
			return traceDirectory;
		} else {
			return workspacePath + traceDirectory;
		}
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

	@Override
	public void valueCreated(IValue value) {
		// do nothing
	}

	@Override
	public void valueDestroyed(IValue value) {
		// do nothing
	}

	protected boolean shouldTrace(ISemanticVisitor nodeVisitor) {
		return isTraceServiceActivate &&
				((tracepointMode && captureServiceFactory.isVisitorConcernedByTracepoints(this.tracepoints, nodeVisitor)) ||
						!tracepointMode);
	}

}
