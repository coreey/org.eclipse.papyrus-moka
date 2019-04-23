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

package org.eclipse.papyrus.moka.fuml.standardlibrary.library.integer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IIntegerValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IRealValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.RealValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution;
import org.eclipse.uml2.uml.PrimitiveType;

public class Div_ extends OpaqueBehaviorExecution {

	@Override
	public void doBody(List<IParameterValue> inputParameters, List<IParameterValue> outputParameters) {
		try{
			int x = ((IIntegerValue)inputParameters.get(0).getValues().get(0)).getValue();
			int y = ((IIntegerValue)inputParameters.get(1).getValues().get(0)).getValue();
			if(y != 0) {
				IRealValue result = new RealValue();
				result.setValue(new Double(x) / new Double(y));
				result.setType((PrimitiveType)this.locus.getFactory().getBuiltInType("Real"));
				List<IValue> values = new ArrayList<IValue>();
				values.add(result);
				outputParameters.get(0).setValues(values);
			}
		} catch (Exception e) {
			Activator.log.error("An error occured during the execution of Div_ " + e.getMessage(), e);
		}
	}

	@Override
	public IValue new_() {
		return new Div_();
	}

}
