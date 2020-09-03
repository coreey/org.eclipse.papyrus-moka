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

import java.util.List;

import org.eclipse.papyrus.moka.fuml.commonbehavior.IParameterValue;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IValue;
import org.eclipse.papyrus.moka.kernel.scheduling.control.IExecutionLoop;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.StateMachine;

public class RootBehaviorTaskExecution extends UMLRootTaskExecution<Behavior>{

	public RootBehaviorTaskExecution(IExecutionLoop loop, Behavior executionRoot) {
		super(loop, executionRoot);
	}
	
	@Override
	public boolean canExecute() {
		return root instanceof Activity || root instanceof StateMachine;
	}
	
	@Override
	public void execute() {
		if(root.isActive()) {
			locus.getExecutor().start(root, parameterValues);
		} else {
			List<IParameterValue> outputParameterValues = locus.getExecutor().execute(root, null, parameterValues);
			for (IParameterValue outputParameterValue : outputParameterValues) {
				setParameterValue(outputParameterValue);
			}
		}
	}
	
	@Override
	public IValue new_() {
		return new RootBehaviorTaskExecution(executionLoop, root);
	}

}
