/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IClassifierBehaviorExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IObjectActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;

public class ClassifierBehaviorExecution implements IClassifierBehaviorExecution {

	/*
	 * The execution of the associated classifier behavior for a certain object.
	 */
	public IExecution execution;

	/*
	 * The classifier whose behavior is being executed. (This must be an active
	 * class.)
	 */
	public Class classifier;

	/*
	 * The object activation that owns this classifier behavior execution.
	 */
	public IObjectActivation objectActivation;

	public void execute(Class classifier, List<IParameterValue> inputs) {
		// Set the classifier for this classifier behavior execution to the
		// given class.
		// If the given class is a behavior, set the execution to be the object
		// of the object activation of the classifier behavior execution.
		// Otherwise the class must be an active class, so get an execution
		// object for the classifier behavior for the class.
		// Set the input parameters for the execution to the given values.
		// Then start the active behavior of this ClassifierBehaviorExecution
		// object, which will execute the execution object on a separate thread
		// of control.
		// Debug.println("[execute] Executing behavior for " + classifier.name +
		// "...");
		this.classifier = classifier;
		IObject_ object = this.objectActivation.getObject();
		if (classifier instanceof Behavior) {
			this.execution = (IExecution) object;
		} else {
			this.execution = object.getLocus().getFactory().createExecution(classifier.getClassifierBehavior(), object);
		}
		if (inputs != null) {
			for (int i = 0; i < inputs.size(); i++) {
				IParameterValue input = inputs.get(i);
				this.execution.setParameterValue(input);
			}
		}
		_startObjectBehavior();
	}

	public void _startObjectBehavior() {
		this.execution.execute();
	}

	public void terminate() {
		// Terminate the associated execution.
		// If the execution is not itself the object of the object activation,
		// then destroy it.
		// Debug.println("[terminate] Terminating behavior for " +
		// classifier.name + "...");
		this.execution.terminate();
		if (this.execution != this.objectActivation.getObject()) {
			this.execution.destroy();
		}
	}

	@Override
	public IExecution getExecution() {
		return this.execution;
	}
}
