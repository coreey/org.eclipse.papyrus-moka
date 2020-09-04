/*****************************************************************************
 * Copyright (c) 2019, 2020 CEA LIST and others.
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
 *   
 *****************************************************************************/
package org.eclipse.papyrus.moka.engine.uml;

import java.util.ArrayList;

import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IParameterValue;
import org.eclipse.papyrus.moka.fuml.tasks.IUMLRootTaskExecution;
import org.eclipse.papyrus.moka.kernel.engine.ExecutionEngineException;
import org.eclipse.papyrus.moka.kernel.scheduling.control.Scheduler;
import org.eclipse.uml2.uml.Element;

public class UMLExecutionEngine extends AbstractUMLExecutionEngine {

	/**
	 * Start the execution. This is technically realized by adding the the root
	 * execution to the execution queue controlled by the execution controller
	 */
	@Override
	public void start(SubMonitor monitor) throws ExecutionEngineException {
		EObject executionSource = configuration.getExecutionSource();
		if (executionSource instanceof Element) {
			Element source = (Element) configuration.getExecutionSource();
			if (locus != null && source != null) {
				IUMLRootTaskExecution<?> rootExecution = rootTaskFactory.createRootExecution(source);
				if (rootExecution != null) {
					rootExecution.setLocus(locus);
					rootExecution.setInputParameterValues(new ArrayList<IParameterValue>());
					if (rootExecution.canExecute()) {
						controller.getExecutionLoop().init(rootExecution, new Scheduler());
						SubMonitor progress = monitor.split(1);
						progress.subTask("Run model"); //$NON-NLS-1$
						controller.start();
						progress.worked(1);
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
