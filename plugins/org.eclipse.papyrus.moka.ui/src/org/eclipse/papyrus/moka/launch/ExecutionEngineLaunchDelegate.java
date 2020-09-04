/*****************************************************************************
 * Copyright (c) 2013, 2020 CEA LIST.
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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.moka.animation.css.MokaCSSDiagram;
import org.eclipse.papyrus.moka.debug.target.ExecutionEngineDebugTarget;
import org.eclipse.papyrus.moka.kernel.IKernelProperties;
import org.eclipse.papyrus.moka.kernel.engine.EngineConfiguration;
import org.eclipse.papyrus.moka.kernel.engine.EngineRegistry;
import org.eclipse.papyrus.moka.kernel.process.ExecutionEngineProcess;
import org.eclipse.papyrus.moka.kernel.process.MQTTServerConfig;
import org.eclipse.papyrus.moka.kernel.process.ServerMqttProcess;
import org.eclipse.papyrus.moka.ui.IUIPreferences;
import org.eclipse.papyrus.moka.ui.Messages;
import org.eclipse.papyrus.moka.ui.MokaUIActivator;
import org.eclipse.papyrus.moka.ui.validation.ValidationUtil;
import org.eclipse.papyrus.moka.utils.helper.PapyrusEditorUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.dialogs.PreferencesUtil;

public class ExecutionEngineLaunchDelegate extends LaunchConfigurationDelegate implements ILaunchConfigurationDelegate {

	public ExecutionEngineLaunchDelegate() {
		super();
	}

	/**
	 * The project containing the model from which the execution is started
	 */
	protected IProject project;

	/**
	 * The user defined engine configuration
	 */
	private EngineConfiguration<?> engineConfiguration;

	/**
	 * The model set containing the model that is executed
	 */
	private ModelSet modelSet;

	private boolean canOpenProject(final IExecutionEngineLaunchConfigurationReader reader) {
		boolean isOpen = false;
		if (reader != null) {
			IProject p = reader.getProject();
			if (p != null) {
				isOpen = p.isOpen();
			}
		}
		return isOpen;
	}

	private boolean canInstantiateEngine(final IExecutionEngineLaunchConfigurationReader reader) {
		boolean engineInstantiated = false;
		if (reader != null) {
			engineInstantiated = reader.getEngine() != null;
		}
		return engineInstantiated;
	}

	private boolean canRunServer() {
		boolean canRunServer = false;
		canRunServer = !MQTTServerConfig.getMQTTServerPath().isEmpty()
				&& Integer.parseInt(MQTTServerConfig.getMQTTServerPort()) > 0;
		return canRunServer;
	}

	private boolean isValidationOk(EngineConfiguration<?> engineConfiguration, IProgressMonitor monitor,
			String engineID) {
		// If the preference allow to run model validation before the launch, the
		// validation is run. If there are errors, the system ask the user if he/she
		// still wants to run the simulation.
		// Return true if the simulation must continue, false otherwise
		IPreferenceStore store = MokaUIActivator.getDefault().getPreferenceStore();
		boolean mustValidate = store.getBoolean(IUIPreferences.MODEL_VALIDATION_ON_LAUNCH);
		boolean continueSimulation = true;
		if (mustValidate) {
			continueSimulation = ValidationUtil.validateModel(engineConfiguration, monitor, engineID);
		}
		return continueSimulation;
	}

	@Override
	public boolean preLaunchCheck(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor)
			throws CoreException {
		// The following set of condition must hold to guarantee the execution
		// to be performed:
		// (1) the project can be found in the workspace
		// (2) It is possible to instantiate the execution engine
		// (3) It is possible to run MQTT server
		// (4) These is no validation error in the model or the user choice to run the
		// simulation in spite of errors
		modelSet = null;
		engineConfiguration = null;
		boolean prechecks = false;
		EngineRegistry.getInstance().loadEngines();
		IExecutionEngineLaunchConfigurationReader reader = createReader(configuration);
		if (canOpenProject(reader)) {
			project = reader.getProject();
			if (canInstantiateEngine(reader)) {
				initMQTTServerConfig();
				if (canRunServer()) {
					SubMonitor progressMonitor = SubMonitor.convert(monitor);
					IExecutionEngineLaunchConfigurationReader cr = createReader(configuration);
					modelSet = initializeModelingEnvironment(cr, progressMonitor.split(2));
					if (modelSet != null) {
						engineConfiguration = createConfiguration(cr, modelSet);
						if (isValidationOk(engineConfiguration, progressMonitor, reader.getExecutionEngineID())) {
							prechecks = true;
						}
					} else {
						Display.getDefault().asyncExec(new Runnable() {
							@Override
							public void run() {
								Shell shell = Display.getDefault().getActiveShell();
								Status status = new Status(Status.ERROR, MokaUIActivator.PLUGIN_ID,
										Messages.ModelSetOpenning_Status);
								MokaErrorDialog dialog = new MokaErrorDialog(shell, Messages.MokaDialogError_Title,
										Messages.ModelSetOpenning_Title, status, Status.ERROR);
								dialog.open();
							}
						});
					}
				} else {
					Display.getDefault().asyncExec(new Runnable() {
						@Override
						public void run() {
							Shell shell = Display.getDefault().getActiveShell();
							Status status = new Status(Status.ERROR, MokaUIActivator.PLUGIN_ID,
									Messages.ServerError_Status);
							MokaErrorDialog dialog = new MokaErrorDialog(shell, Messages.MokaDialogError_Title,
									Messages.ServerError_Title, status, Status.ERROR);
							dialog.open();
							PreferencesUtil
									.createPreferenceDialogOn(shell, IUIPreferences.UI_PREFERENCES_ID, null, null)
									.open();
						}
					});
				}
			} else {
				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						Shell shell = Display.getDefault().getActiveShell();
						Status status = new Status(Status.ERROR, MokaUIActivator.PLUGIN_ID,
								Messages.EngineInstantiationError_Status);
						MokaErrorDialog dialog = new MokaErrorDialog(shell, Messages.MokaDialogError_Title,
								Messages.EngineInstantiationError_Title, status, Status.ERROR);
						dialog.open();
					}
				});
			}
		} else {
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					Shell shell = Display.getDefault().getActiveShell();
					Status status = new Status(Status.ERROR, MokaUIActivator.PLUGIN_ID,
							Messages.ProjectOpeningError_Status);
					MokaErrorDialog dialog = new MokaErrorDialog(shell, Messages.MokaDialogError_Title,
							Messages.ProjectOpeningError_Title, status, Status.ERROR);
					dialog.open();
				}
			});
		}
		return prechecks;
	}

	protected void initMQTTServerConfig() {
		MQTTServerConfig.setMQTTServerPath(
				MokaUIActivator.getDefault().getPreferenceStore().getString(IKernelProperties.MQTT_SERVER_PATH));
		MQTTServerConfig.setMQTTServerPort(
				MokaUIActivator.getDefault().getPreferenceStore().getString(IKernelProperties.MQTT_SERVER_PORT));
	}

	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
			throws CoreException {
		SubMonitor progressMonitor = SubMonitor.convert(monitor);
		IExecutionEngineLaunchConfigurationReader cr = createReader(configuration);
		if (modelSet == null) {
			modelSet = initializeModelingEnvironment(cr, progressMonitor.split(2));
		}
		if (modelSet != null && engineConfiguration != null) {
			engineConfiguration = createConfiguration(cr, modelSet);
		}
		if (modelSet != null && engineConfiguration != null) {
			ServerMqttProcess serverProcess = new ServerMqttProcess(launch);
			serverProcess.run();
			if (!serverProcess.isTerminated()) {
				ExecutionEngineProcess engineProcess = initializeExecutionProcess(launch, cr, engineConfiguration);
				// Find every MokaCSSDiagram to register listener
				Iterable<MokaCSSDiagram> diagrams = NotationUtils.getAllNotations(modelSet, MokaCSSDiagram.class);
				Job job = engineProcess.getProcess();
				if (job != null) {
					diagrams.forEach(d -> job.addJobChangeListener((IJobChangeListener) d.getEngine()));
				}
				if (engineProcess != null) {
					engineProcess.run();
				}
			} else {
				MokaUIActivator.getDefault().getLogger().error("Server execution failed", serverProcess.getError()); //$NON-NLS-1$
			}
		} else {
			MokaUIActivator.getDefault().getLogger().error("Modeling environment could not be initialized", null); //$NON-NLS-1$
		}
	}

	protected IExecutionEngineLaunchConfigurationReader createReader(ILaunchConfiguration configuration) {
		return new ExecutionEngineLaunchConfigurationReader(configuration);
	}

	protected EngineConfiguration<?> createConfiguration(IExecutionEngineLaunchConfigurationReader cr, ModelSet ms) {
		// Return a configuration containing the information required by
		// the engine to perform the execution
		EngineConfiguration<EObject> ec = new EngineConfiguration<EObject>();
		ec.setProject(project);
		ec.setModelURI(cr.getModelURI());
		Resource resource = ms.getResource(cr.getModelURI(), true);
		if (resource != null) {
			ec.setExecutionSource(resource.getEObject(cr.getExecutionSourceURI().toString()));
		}
		ec.setTraceEnabled(cr.isTraceServiceEnabled());
		ec.setTraceFilePath(cr.getTraceFile());
		ec.setFormatterID(cr.getTraceFormatterID());
		ec.setTracepointMode(cr.isTracePointMode());
		return ec;
	}

	protected final ModelSet initializeModelingEnvironment(
			IExecutionEngineLaunchConfigurationReader configurationReader, SubMonitor monitor) {
		// If it is required, the model is opened and the corresponding editor get the
		// focus. The model set managed by Papyrus is returned
		if (!PapyrusEditorUtils.isProjectOpen(configurationReader.getModelDIURI())
				| !PapyrusEditorUtils.isEditorActivated(configurationReader.getModelDIURI())) {
			PapyrusEditorUtils.openProject(project, configurationReader.getModelDIURI());
		}
		monitor.worked(1);
		ModelSet modelSet = null;
		IEditorPart editor = PapyrusEditorUtils.getEditor(configurationReader.getModelDIURI());
		if (editor != null) {
			ServicesRegistry registry = editor.getAdapter(ServicesRegistry.class);
			if (registry != null) {
				try {
					modelSet = registry.getService(ModelSet.class);
				} catch (ServiceException e) {
					e.printStackTrace();
				}
			}
		}
		monitor.worked(1);
		return modelSet;
	}

	protected final ExecutionEngineProcess initializeExecutionProcess(ILaunch l,
			IExecutionEngineLaunchConfigurationReader cr, EngineConfiguration<? extends EObject> ec) {
		ExecutionEngineProcess process = new ExecutionEngineProcess(l, cr.getEngine(), ec);
		ExecutionEngineDebugTarget debugTarget = new ExecutionEngineDebugTarget(l, process);
		l.addProcess(process);
		l.addDebugTarget(debugTarget);
		return process;
	}
}
