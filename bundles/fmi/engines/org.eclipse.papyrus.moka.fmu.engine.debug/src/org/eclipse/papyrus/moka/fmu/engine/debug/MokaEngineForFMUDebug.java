/*****************************************************************************
 * 
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.fmu.engine.debug;

import org.eclipse.papyrus.moka.discreteevent.DEScheduler;
import org.eclipse.papyrus.moka.discreteevent.Event;
import org.eclipse.papyrus.moka.fmu.control.queue.FMIRootExecution;
import org.eclipse.papyrus.moka.fmu.engine.MokaEngineForFMUExport;
import org.eclipse.papyrus.moka.fmu.engine.control.FMUControlService;
import org.eclipse.papyrus.moka.fmu.engine.de.FMIPushPullStrategy;
import org.eclipse.papyrus.moka.fmu.engine.de.FMUStepEnd;
import org.eclipse.papyrus.moka.fmu.engine.utils.FMUEngineUtils;
import org.eclipse.papyrus.moka.fuml.control.queue.ExecutionController;
import org.eclipse.papyrus.moka.timedfuml.actions._displayCurrentTimeAction;
import org.eclipse.papyrus.moka.timedfuml.control.queue.TimedExecutionLoop;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Class;

public class MokaEngineForFMUDebug extends MokaEngineForFMUExport {

	@Override
	protected void initDEScheduler() {
		// Initialize DEScheduler
		DEScheduler.init(-1.0, new FMIPushPullStrategy());
	}

	@Override
	protected void doPreRunActions() {
		// Push a pre-run action and add an event at time 0.0
		DEScheduler.getInstance().pushPreStepAction(new _displayCurrentTimeAction());
		FMUStepEnd stepEnd = new FMUStepEnd();
		DEScheduler.getInstance().pushEvent(new Event(0.0, stepEnd));
	}

	@Override
	protected void run_() {
		// 1] Job on which the engine gets executed is suspended.
		// 2] Open the FMU control dialog
		// This status remains until the termination lock gets
		// released (see FMUControlService).
		ExecutionController.getInstance().setExecutionLoop(new TimedExecutionLoop());
		FMUControlService controlService = FMUEngineUtils.getFMUControlService();
		controlService.setRootExecution(new FMIRootExecution((Class) this.executionEntryPoint, this.executionArguments, this.locus));
		this.launchMaster();
		controlService.waitForTermination();
	}

	protected void launchMaster() {
		// Open execution engine control dialog on separated UI thread
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				FMUDebugDialog dialog = new FMUDebugDialog(Display.getDefault().getActiveShell());
				dialog.setBlockOnOpen(false);
				dialog.open();
			}
		});
		FMUEngineUtils.getFMUControlService().getInstantiationLock().release();
	}

}