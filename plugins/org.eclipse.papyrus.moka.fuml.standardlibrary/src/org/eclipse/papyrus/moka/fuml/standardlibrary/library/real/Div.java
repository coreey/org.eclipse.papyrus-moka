/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.standardlibrary.library.real;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.commonbehavior.IParameterValue;
import org.eclipse.papyrus.moka.fuml.commonbehavior.OpaqueBehaviorExecution;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IValue;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.RealValue;
import org.eclipse.papyrus.moka.fuml.standardlibrary.Activator;
import org.eclipse.uml2.uml.PrimitiveType;

public class Div extends OpaqueBehaviorExecution {

	@Override
	public void doBody(List<IParameterValue> inputParameters, List<IParameterValue> outputParameters) {
		try {
			Double x = ((RealValue) inputParameters.get(0).getValues().get(0)).value;
			Double y = ((RealValue) inputParameters.get(1).getValues().get(0)).value;
			if (y != 0) {
				RealValue result = new RealValue();
				result.value = x / y;
				result.type = (PrimitiveType) this.locus.getFactory().getBuiltInType("Real");
				List<IValue> outputs = new ArrayList<IValue>();
				outputs.add(result);
				outputParameters.get(0).setValues(outputs);
			}
		} catch (Exception e) {
			Activator.getDefault().logger.error("An error occured during the execution of Div " + e.getMessage(), e);
		}
	}

	@Override
	public IValue new_() {
		return new Div();
	}
}
