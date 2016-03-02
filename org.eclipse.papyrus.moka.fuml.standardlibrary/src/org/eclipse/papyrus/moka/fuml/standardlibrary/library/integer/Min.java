/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.IntegerValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Value;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.uml2.uml.PrimitiveType;

public class Min extends OpaqueBehaviorExecution {

	@Override
	public void doBody(List<IParameterValue> inputParameters, List<IParameterValue> outputParameters) {
		try {
			Integer x = ((IntegerValue) inputParameters.get(0).getValues().get(0)).value;
			Integer y = ((IntegerValue) inputParameters.get(1).getValues().get(0)).value;
			IntegerValue result = new IntegerValue();
			result.value = Math.min(x, y);
			List<IValue> outputs = new ArrayList<IValue>();
			result.type = (PrimitiveType) this.locus.getFactory().getBuiltInType("Integer"); // ADDED
			outputs.add(result);
			outputParameters.get(0).setValues(outputs);
		} catch (Exception e) {
			Debug.println("An error occured during the execution of Min " + e.getMessage());
		}
	}

	@Override
	public Value new_() {
		return new Min();
	}
}
