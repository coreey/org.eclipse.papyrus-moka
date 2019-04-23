/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
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

package org.eclipse.papyrus.moka.fuml.control.execution;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.Execution;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;

public class RootExecution extends Execution {

	// Class to be executed
	protected Class executedClass;

	public RootExecution() {
	}

	public RootExecution(Class executedClass, List<IParameterValue> inputParameterValues, ILocus locus) {
		this.executedClass = executedClass;
		this.setInputParameterValues(inputParameterValues);
		this.locus = locus;
	}

	public void setInputParameterValues(List<IParameterValue> inputParameterValues) {
		// Set input parameter values of the root execution
		for (IParameterValue inputParameterValue : inputParameterValues) {
			this.setParameterValue(inputParameterValue);
		}
	}

	@Override
	public void execute() {
		// If the class is active then it is instantiated and
		// started on its own thread of execution. Conversely,
		// if it is not active then it shall be a behavior. In
		// such situation the behavior gets executed otherwise
		// this operation has no effect.
		if (this.executedClass.isActive()) {
			this.locus.getExecutor().start(executedClass, this.parameterValues);
		} else if (this.executedClass instanceof Behavior) {
			List<IParameterValue> outputParameterValues = this.locus.getExecutor()
					.execute((Behavior) this.executedClass, null, this.parameterValues);
			for (IParameterValue parameterValue : outputParameterValues) {
				this.setParameterValue(parameterValue);
			}
		}
	}

	@Override
	public IValue new_() {
		return new RootExecution();
	}

	@Override
	public List<Classifier> getTypes() {
		List<Classifier> types = new ArrayList<Classifier>();
		types.add(this.executedClass);
		return types;
	}

	@Override
	public String toString() {
		return "RootExecution()";
	}
}
