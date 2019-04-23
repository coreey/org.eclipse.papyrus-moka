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
package org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IOpaqueBehaviorExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;

public abstract class OpaqueBehaviorExecution extends Execution implements IOpaqueBehaviorExecution {

	@Override
	public void execute() {
		// Execute the body of the opaque behavior.
		Debug.println("[execute] Opaque behavior " + this.getBehavior().getName() + "...");
		List<Parameter> parameters = this.getBehavior().getOwnedParameters();
		List<IParameterValue> inputs = new ArrayList<IParameterValue>();
		List<IParameterValue> outputs = new ArrayList<IParameterValue>();
		for (int i = 0; i < parameters.size(); i++) {
			Parameter parameter = parameters.get(i);
			if ((parameter.getDirection() == ParameterDirectionKind.IN_LITERAL) | (parameter.getDirection() == ParameterDirectionKind.INOUT_LITERAL)) {
				inputs.add(this.getParameterValue(parameter));
			}
			if ((parameter.getDirection() == ParameterDirectionKind.INOUT_LITERAL) | (parameter.getDirection() == ParameterDirectionKind.OUT_LITERAL) | (parameter.getDirection() == ParameterDirectionKind.RETURN_LITERAL)) {
				ParameterValue parameterValue = new ParameterValue();
				parameterValue.parameter = parameter;
				this.setParameterValue(parameterValue);
				outputs.add(parameterValue);
			}
		}
		this.doBody(inputs, outputs);
	}

	public abstract void doBody(List<IParameterValue> inputParameters, List<IParameterValue> outputParameters);
}
