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
package org.eclipse.papyrus.moka.fuml.standardlibrary.library.string;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.IntegerValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.StringValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.uml2.uml.PrimitiveType;

public class Substring extends OpaqueBehaviorExecution {

	@Override
	public void doBody(List<IParameterValue> inputParameters, List<IParameterValue> outputParameters) {
		try {
			String x = ((StringValue) inputParameters.get(0).getValues().get(0)).value;
			Integer lower = ((IntegerValue) inputParameters.get(1).getValues().get(0)).value;
			Integer upper = ((IntegerValue) inputParameters.get(2).getValues().get(0)).value;

			// ADDED if statement
			List<IValue> outputs = new ArrayList<IValue>();
			if (lower >= 1 && lower <= x.length() && upper >= 1 && upper <= x.length() && lower <= upper) {
				StringValue result = new StringValue();
				result.value = x.substring(lower - 1, upper); // CHANGED "lower" to "lower-1"
				result.type = (PrimitiveType) this.locus.getFactory().getBuiltInType("String"); // ADDED
				outputs.add(result);
			}

			outputParameters.get(0).setValues(outputs);
		} catch (Exception e) {
			Debug.println("An error occured during the execution of Substring " + e.getMessage());
		}
	}

	@Override
	public IValue new_() {
		return new Substring();
	}
}
