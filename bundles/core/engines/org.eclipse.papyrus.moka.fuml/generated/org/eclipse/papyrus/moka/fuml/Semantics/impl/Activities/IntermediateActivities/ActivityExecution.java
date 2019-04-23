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
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivationGroup;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityParameterNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.Execution;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityParameterNode;

public class ActivityExecution extends Execution implements IActivityExecution {

	/*
	 * The group of activations of the activity nodes of the activity.
	 */
	public IActivityNodeActivationGroup activationGroup;

	@Override
	public void execute() {
		// Execute the activity for this execution by creating an activity node
		// activation group and activating all the activity nodes in the
		// activity.
		// When this is complete, copy the values on the tokens offered by
		// output parameter nodes to the corresponding output parameters.
		Activity activity = (Activity) (this.getTypes().get(0));
		Debug.println("[execute] Activity " + activity.getName() + "...");
		// Debug.println("[execute] context = " + this.context.objectId());
		Debug.println("[event] Execute activity=" + activity.getName());
		this.activationGroup = new ActivityNodeActivationGroup();
		this.activationGroup.setActivityExecution_(this);
		this.activationGroup.activate(activity.getNodes(), activity.getEdges());
		// Debug.println("[execute] Getting output parameter node activations...");
		List<IActivityParameterNodeActivation> outputActivations = this.activationGroup.getOutputParameterNodeActivations();
		// Debug.println("[execute] There are " + outputActivations.size() +
		// " output parameter node activations.");
		for (int i = 0; i < outputActivations.size(); i++) {
			IActivityParameterNodeActivation outputActivation = outputActivations.get(i);
			ParameterValue parameterValue = new ParameterValue();
			parameterValue.parameter = ((ActivityParameterNode) (outputActivation.getNode())).getParameter();
			List<IToken> tokens = outputActivation.getTokens();
			for (int j = 0; j < tokens.size(); j++) {
				IToken token = tokens.get(j);
				IValue value = ((ObjectToken) token).value;
				if (value != null) {
					parameterValue.values.add(value);
					Debug.println("[event] Output activity=" + activity.getName() + " parameter=" + parameterValue.parameter.getName() + " value=" + value);
				}
			}
			this.setParameterValue(parameterValue);
		}
		Debug.println("[execute] Activity " + activity.getName() + " completed.");
	}

	@Override
	public IValue copy() {
		// Create a new activity execution that is a copy of this execution.
		// [Note: This currently just returns a non-executing execution for the
		// same activity as this execution.]
		return super.copy();
	}

	@Override
	public IValue new_() {
		// Create a new activity execution with empty properties.
		return new ActivityExecution();
	}

	@Override
	public void terminate() {
		// Terminate all node activations (which will ultimately result in the
		// activity execution completing).
		if (this.activationGroup != null) {
			this.activationGroup.terminateAll();
		}
	}

	public void setGroup(IActivityNodeActivationGroup group) {
		this.activationGroup = group;
	}

	public IActivityNodeActivationGroup getGroup() {
		return this.activationGroup;
	}
}
