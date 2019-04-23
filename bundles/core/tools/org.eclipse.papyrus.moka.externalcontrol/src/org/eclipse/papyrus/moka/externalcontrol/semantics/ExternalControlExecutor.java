/*****************************************************************************
 * 
 * Copyright (c) 2017 CEA LIST.
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
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.externalcontrol.semantics;

import java.util.List;

import org.eclipse.papyrus.moka.composites.Semantics.impl.Loci.LociL3.CS_Executor;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.uml2.uml.Behavior;

public class ExternalControlExecutor extends CS_Executor {

	@Override
	public List<IParameterValue> execute(Behavior behavior, IObject_ context, List<IParameterValue> inputs) {
		// Execute the given behavior with the given input values in the given
		// context, producing the given output values.
		// There must be one input parameter value for each input (in or in-out)
		// parameter of the behavior.
		// The returned values include one parameter value for each output
		// (in-out, out or return) parameter of the behavior.
		// The execution instance is destroyed at completion.
		IExecution execution = this.locus.getFactory().createExecution(behavior, context);
		for (int i = 0; i < inputs.size(); i++) {
			execution.setParameterValue(inputs.get(i));
		}
		execution.execute();
		List<IParameterValue> outputValues = execution.getOutputParameterValues();
		
		//We don't call destroy because the execution is immediately suspended for control
		//and we will enter in external controller loop
		//execution.destroy();
		
		return outputValues;
	}

}
