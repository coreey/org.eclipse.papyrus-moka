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

import static org.eclipse.papyrus.moka.kernel.IKernelPreferences.KERNEL_PREFERENCES_ID;
import static org.eclipse.papyrus.moka.kernel.process.IServerMqttPreferences.MODEL_VALIDATION_ON_LAUNCH;
import static org.eclipse.papyrus.moka.kernel.process.IServerMqttPreferences.MQTT_SERVER_PATH;
import static org.eclipse.papyrus.moka.kernel.process.IServerMqttPreferences.MQTT_SERVER_PORT;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.moka.animation.css.MokaCSSDiagram;
import org.eclipse.papyrus.moka.debugtarget.ExecutionEngineDebugTarget;
import org.eclipse.papyrus.moka.kernel.IKernelPreferences;
import org.eclipse.papyrus.moka.kernel.engine.EngineConfiguration;
import org.eclipse.papyrus.moka.kernel.engine.EngineRegistry;
import org.eclipse.papyrus.moka.kernel.process.ExecutionEngineProcess;
import org.eclipse.papyrus.moka.kernel.process.ServerMqttProcess;
import org.eclipse.papyrus.moka.ui.Messages;
import org.eclipse.papyrus.moka.ui.MokaUIActivator;
import org.eclipse.papyrus.moka.ui.validation.ValidationUtil;
import org.eclipse.papyrus.moka.utils.helper.PapyrusEditorUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.uml2.uml.Class;

public class ExecutionEngineLaunchDelegate extends LaunchConfigurationDelegate implements ILaunchConfigurationDelegate {

	// The project containing the model for which
	// the execution is launched
	protected IProject project;
	private EngineConfiguration engineConfiguration;
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
		ScopedPreferenceStore store = new ScopedPreferenceStore(ConfigurationScope.INSTANCE, KERNEL_PREFERENCES_ID);
		if (store != null) {
			canRunServer = !store.getString(MQTT_SERVER_PATH).isEmpty() && store.getInt(MQTT_SERVER_PORT) > 0;
		}
		return canRunServer;
	}

	private boolean isValidationOk(EngineConfiguration engineConfiguration, IProgressMonitor monitor) {
		// If the preference allow to run model validation before the launch, the
		// validation is run. If there are errors, the system ask the user if he/she
		// still wants to run the simulation.
		// Return true if the simulation must continue, false otherwise
		ScopedPreferenceStore store = new ScopedPreferenceStore(ConfigurationScope.INSTANCE,
				IKernelPreferences.KERNEL_PREFERENCES_ID);
		boolean mustValidate = store.getBoolean(MODEL_VALIDATION_ON_LAUNCH);
		boolean continueSimulation = true;
		if (mustValidate) {
			continueSimulation = ValidationUtil.validateModel(engineConfiguration, monitor);
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
				if (canRunServer()) {
					SubMonitor progressMonitor = SubMonitor.convert(monitor);
					IExecutionEngineLaunchConfigurationReader cr = createReader(configuration);
					modelSet = initializeModelingEnvironment(cr, progressMonitor.split(2));
					if (modelSet != null) {
						engineConfiguration = createConfiguration(cr, modelSet);
						if (isValidationOk(engineConfiguration, progressMonitor)) {
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
							PreferencesUtil.createPreferenceDialogOn(shell, IKernelPreferences.KERNEL_PREFERENCES_ID,
									null, null).open();
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
				MokaUIActivator.getDefault().getLogger().error("Server execution failed", serverProcess.getError());
			}
		} else {
			MokaUIActivator.getDefault().getLogger().error("Modeling environment could not be initialized", null);
		}
	}

	protected IExecutionEngineLaunchConfigurationReader createReader(ILaunchConfiguration configuration) {
		return new ExecutionEngineLaunchConfigurationReader(configuration);
	}

	protected EngineConfiguration createConfiguration(IExecutionEngineLaunchConfigurationReader cr, ModelSet ms) {
		// Return a configuration containing the information required by
		// the engine to perform the execution
		EngineConfiguration ec = new EngineConfiguration();
		ec.setProject(project);
		ec.setModelURI(cr.getModelURI());
		Resource resource = ms.getResource(cr.getModelURI(), true);
		if (resource != null) {
			Class target = (Class) resource.getEObject(cr.getExecutionSourceURI().toString());
			ec.setExecutionSource(target);
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
			IExecutionEngineLaunchConfigurationReader cr, EngineConfiguration ec) {
		ExecutionEngineProcess process = new ExecutionEngineProcess(l, cr.getEngine(), ec);
		ExecutionEngineDebugTarget debugTarget = new ExecutionEngineDebugTarget(l, process);
		l.addProcess(process);
		l.addDebugTarget(debugTarget);
		return process;
	}
}
