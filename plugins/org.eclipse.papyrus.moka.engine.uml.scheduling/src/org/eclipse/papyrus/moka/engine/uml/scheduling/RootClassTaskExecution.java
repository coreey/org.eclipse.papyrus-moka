/*****************************************************************************
 * Copyright (c) 2020 CEA LIST and others.
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

import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IValue;
import org.eclipse.papyrus.moka.kernel.scheduling.control.IExecutionLoop;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.StateMachine;

public class RootClassTaskExecution extends UMLRootTaskExecution<Class>{

	public RootClassTaskExecution(IExecutionLoop loop, Class executionRoot) {
		super(loop, executionRoot);
	}

	@Override
	public boolean canExecute() {
		return root.isActive() && (root.getClassifierBehavior() instanceof StateMachine || root.getClassifierBehavior() instanceof Activity);
	}
	
	@Override
	public void execute() {
		locus.getExecutor().start(root, parameterValues);
	}
	
	@Override
	public IValue new_() {
		return new RootClassTaskExecution(executionLoop, root);
	}
	
}
