/*****************************************************************************
 * Copyright (c) 2016, 2020 CEA LIST.
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
package org.eclipse.papyrus.moka.engine.uml.time;

import java.util.ArrayList;

import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.engine.uml.UMLExecutionEngine;
import org.eclipse.papyrus.moka.engine.uml.time.scheduling.de.DEScheduler;
import org.eclipse.papyrus.moka.engine.uml.time.scheduling.de.actions.DisplayCurrentTimeAction;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IParameterValue;
import org.eclipse.papyrus.moka.fuml.tasks.IUMLRootTaskExecution;
import org.eclipse.papyrus.moka.kernel.engine.ExecutionEngineException;
import org.eclipse.papyrus.moka.kernel.scheduling.control.Scheduler;
import org.eclipse.uml2.uml.Element;

public class UMLTimedExecutionEngine extends UMLExecutionEngine {

	protected double getStopTime() {
		// Scheduler stop time
		return -1.0;
	}

	protected void initDEScheduler() {
		// Initialize the scheduler
		DEScheduler.init(this.getStopTime());
	}

	protected void doPreRunActions() {
		// This method can be overridden to perform pre-run initializations that can be
		// needed for a given customization. Typically useful to register pre-step
		// actions to the DEScheduler
		DEScheduler.getInstance().pushPreStepAction(new DisplayCurrentTimeAction());
	}

	protected void doPostRunActions() {
		// This method can be overridden to perform post-run finalization that can be
		// needed for a given customization.
	}

	@Override
	public void start(SubMonitor monitor) throws ExecutionEngineException {
		EObject executionSource = configuration.getExecutionSource();
		if (executionSource instanceof Element) {
			// Starts the execution loop
			Element source = (Element) configuration.getExecutionSource();
			if (locus != null && source != null) {
				IUMLRootTaskExecution<?> rootExecution = rootTaskFactory.createRootExecution(source);
				if (rootExecution != null) {
					rootExecution.setLocus(locus);
					rootExecution.setInputParameterValues(new ArrayList<IParameterValue>());
					if (rootExecution.canExecute()) {
						initDEScheduler();
						doPreRunActions();
						controller.getExecutionLoop().init(rootExecution, new Scheduler());
						controller.start();
						doPostRunActions();
					} else {
						throw new ExecutionEngineException(identifier, status,
								"Could not start the execution from the specified model element"); //$NON-NLS-1$
					}
				} else {
					throw new ExecutionEngineException(identifier, status,
							"Could not instantiate an execution from the specified element"); //$NON-NLS-1$
				}
			}
		} else {
			throw new IllegalArgumentException("ExecutionSource in configuration must be instanceOf UML::Element");
		}
	}

}
