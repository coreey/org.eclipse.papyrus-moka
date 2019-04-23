/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.moka.fuml.standardlibrary.library.unlimitednatural;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.StringValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.UnlimitedNaturalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.uml2.uml.PrimitiveType;

public class ToUnlimitedNatural extends OpaqueBehaviorExecution {

	@Override
	public void doBody(List<IParameterValue> inputParameters, List<IParameterValue> outputParameters) {
		try {
			String x = ((StringValue) inputParameters.get(0).getValues().get(0)).value;
			UnlimitedNaturalValue result = new UnlimitedNaturalValue();
			Integer value = null;
			if (x.equals("*")) {
				result.value = -1;
			} else {
				try {
					value = new Integer(x);
				} catch (NumberFormatException badFormat) {
				}
				if (value != null && value >= 0) {
					result.value = value;
				}
			}
			result.type = (PrimitiveType) this.locus.getFactory().getBuiltInType("UnlimitedNatural");
			List<IValue> outputs = new ArrayList<IValue>();
			outputs.add(result);
			outputParameters.get(0).setValues(outputs);
		} catch (Exception e) {
			Debug.println("An error occured during the execution of ToUnlimitedNatural " + e.getMessage());
		}
	}

	@Override
	public IValue new_() {
		return new ToUnlimitedNatural();
	}
}
