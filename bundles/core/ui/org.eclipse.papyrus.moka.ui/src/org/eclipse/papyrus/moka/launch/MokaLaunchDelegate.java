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
package org.eclipse.papyrus.moka.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.moka.debug.engine.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.engine.MokaProcess;
import org.eclipse.papyrus.moka.engine.IExecutionEngine;
import org.eclipse.papyrus.moka.engine.MokaExecutionEngineJob;
import org.eclipse.papyrus.moka.ui.Activator;
import org.eclipse.papyrus.moka.utils.constants.MokaConstants;
import org.eclipse.papyrus.moka.utils.helper.EditorUtils;

public class MokaLaunchDelegate extends LaunchConfigurationDelegate implements ILaunchConfigurationDelegate {

	// The debug target to which created through the launcher
	protected MokaDebugTarget debugTarget;

	protected final IExecutionEngine getExecutionEngine(ILaunchConfiguration configuration) {
		// Create the instance of the execution engine specified by the user in the launch configuration
		String selectedExecutionEngine = null;
		try {
			selectedExecutionEngine = configuration.getAttribute(MokaConstants.EXECUTION_ENGINE_ATTRIBUTE_NAME, "");
		} catch (CoreException e) {
			e.printStackTrace();
		}
		if (selectedExecutionEngine == null || selectedExecutionEngine.isEmpty()) {
			selectedExecutionEngine = "" + Activator.getDefault().getPreferenceStore().getString(MokaConstants.MOKA_DEFAULT_EXECUTION_ENGINE_PREF);
		}
		return this.instantiateExecutionEngine(selectedExecutionEngine);
	}

	protected final EObject getExecutionEntryPoint(ILaunchConfiguration configuration) {
		// Load the selected model. Return the model element designated by the configuration
		// as being the entry point from which the execution shall start
		EObject executionEntryPoint = null;
		String modelURI = null;
		try {
			modelURI = configuration.getAttribute(MokaConstants.URI_ATTRIBUTE_NAME, "");
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (modelURI != null) {
			ServicesRegistry servicesRegistry = (ServicesRegistry) EditorUtils.getEditorPart(modelURI).getAdapter(ServicesRegistry.class);
			ResourceSet resourceSet = null;
			try {
				resourceSet = servicesRegistry.getService(ModelSet.class);
			} catch (ServiceException e) {
				resourceSet = new ResourceSetImpl();
				//org.eclipse.papyrus.infra.core.log.LogHelper.error(e);
			}
			Resource resource = resourceSet.getResource(URI.createURI(modelURI), true);
			String uriFragment = null;
			try {
				uriFragment = configuration.getAttribute(MokaConstants.FRAGMENT_ATTRIBUTE_NAME, "");
			} catch (CoreException e) {
				e.printStackTrace();
			}
			executionEntryPoint = resource.getEObject(uriFragment);
		}

		return executionEntryPoint;
	}

	protected IExecutionEngine instantiateExecutionEngine(String selectedExecutionEngine) {
		// Read the extension point to find the corresponding execution engine. Create an instance
		// of this latter and then return it.
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] config = registry.getConfigurationElementsFor(MokaConstants.MOKA_ENGINE_EXTENSION_POINT_ID);
		try {
			IConfigurationElement e = null;
			if (selectedExecutionEngine == null || selectedExecutionEngine.equals("")) {
				// This situation happens when the preferences for the default moka execution engine have never been changed
				e = config[0];
			} else {
				for (int i = 0; i < config.length; i++) {
					if (config[i].getNamespaceIdentifier().equals(selectedExecutionEngine)) {
						e = config[i];
					}
				}
			}
			final Object o = e.createExecutableExtension("class");
			return (IExecutionEngine) o;
		} catch (CoreException ex) {
			org.eclipse.papyrus.infra.core.Activator.log.equals(ex);
		} catch (Exception ex) {
			org.eclipse.papyrus.infra.core.Activator.log.equals(ex);
		}
		// If null is returned, the calling method (launch) fires a CoreException
		return null;
	}

	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		monitor.beginTask("Start Moka Execution", 4);
		/* 1. Instantiate the execution engine */
		monitor.subTask("Create execution engine");
		IExecutionEngine engine = this.getExecutionEngine(configuration);
		if (engine == null) {
			this.abort("Could not instantiate execution engine", null);
		}
		monitor.worked(1);
		/* 2. Retrieve the modele element from which the execution will start */
		monitor.subTask("Figure out execution entry point");
		EObject executionEntryPoint = this.getExecutionEntryPoint(configuration);
		if (executionEntryPoint == null) {
			this.abort("The specified execution entry point is not valid or could not be found", null);
		}
		monitor.worked(1);
		/* 3. Starts the execution engine on a separated thread */
		monitor.subTask("Start execution engine");
		this.debugTarget = new MokaDebugTarget(launch);
		launch.addDebugTarget(debugTarget);
		String arguments = configuration.getAttribute(MokaConstants.ARGS_ATTRIBUTE_NAME, "");
		MokaExecutionEngineJob executionEngineJob = MokaExecutionEngineJob.getInstance();
		executionEngineJob.initialize(launch, engine, executionEntryPoint, arguments.split("\\s+"));
		MokaProcess executionEngineprocess = new MokaProcess(launch, executionEngineJob);
		launch.addProcess(executionEngineprocess);
		this.debugTarget.setProcess(executionEngineprocess);
		executionEngineprocess.schedule(Job.LONG);
		monitor.worked(1);
		monitor.done();
	}


	protected void abort(String message, Throwable e) throws CoreException {
		throw new CoreException(new Status(IStatus.ERROR, MokaConstants.MOKA_DEBUG_MODEL_ID, 0, message, e));
	}

}
