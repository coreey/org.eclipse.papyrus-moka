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
package org.eclipse.papyrus.moka.fuml.standardlibrary.library.boolean_;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.simpleclassifiers.StringValue;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IParameterValue;
import org.eclipse.papyrus.moka.fuml.commonbehavior.OpaqueBehaviorExecution;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.BooleanValue;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IValue;
import org.eclipse.papyrus.moka.fuml.values.Value;
import org.eclipse.uml2.uml.PrimitiveType;

public class ToBoolean extends OpaqueBehaviorExecution {

	@Override
	public void doBody(List<IParameterValue> inputParameters, List<IParameterValue> outputParameters) {
		try {
			String x = ((StringValue) inputParameters.get(0).getValues().get(0)).value;
			BooleanValue result = new BooleanValue();
			result.value = Boolean.valueOf(x);
			result.type = (PrimitiveType) this.locus.getFactory().getBuiltInType("Boolean"); // ADDED
			List<IValue> outputs = new ArrayList<IValue>();
			outputs.add(result);
			outputParameters.get(0).setValues(outputs);
		} catch (Exception e) {
			Debug.println("An error occured during the execution of ToBoolean " + e.getMessage());
		}
	}

	@Override
	public Value new_() {
		return new ToBoolean();
	}
}
