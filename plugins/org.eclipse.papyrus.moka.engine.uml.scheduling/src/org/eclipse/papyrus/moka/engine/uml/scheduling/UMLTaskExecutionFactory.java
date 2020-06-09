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
package org.eclipse.papyrus.moka.engine.uml.scheduling;

import org.eclipse.papyrus.moka.kernel.scheduling.control.IExecutionLoop;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;

public class UMLTaskExecutionFactory implements IUMLTaskExecutionFactory {

	/**
	 * Factory instance
	 */
	private static UMLTaskExecutionFactory FACTORY;

	protected IExecutionLoop executionLoop;

	protected UMLTaskExecutionFactory() {
		executionLoop = null;
	}

	/**
	 * Create (if required) and return the factory instance
	 * 
	 * @return the task factory
	 */
	public static UMLTaskExecutionFactory getInstance() {
		if (FACTORY == null) {
			FACTORY = new UMLTaskExecutionFactory();
		}
		return FACTORY;
	}

	public IExecutionLoop getExecutionLoop() {
		return executionLoop;
	}

	public void setExecutionLoop(IExecutionLoop loop) {
		executionLoop = loop;
	}

	public IUMLEventDispatchLoopExecution createEventDispatchLoopExecution() {
		return new UMLEventDispatchLoopExecution(executionLoop);
	}

	public IUMLEventSendingExecution createEventSendingExecution() {
		return new UMLEventSendingTaskExecution(executionLoop);
	}

	public UMLRootExecution<?> createRootExecution(final Element executionRoot) {
		UMLRootExecution<?> rootExecution = null;
		if (executionRoot instanceof Behavior) {
			rootExecution = new RootBehaviorTaskExecution(executionLoop, (Behavior) executionRoot);
		} else if (executionRoot instanceof Class) {
			rootExecution = new RootClassTaskExecution(executionLoop, (Class) executionRoot);
		}
		return rootExecution;
	}

}
