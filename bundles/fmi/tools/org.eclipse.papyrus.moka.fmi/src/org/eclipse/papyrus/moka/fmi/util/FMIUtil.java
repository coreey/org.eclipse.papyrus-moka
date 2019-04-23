/*****************************************************************************
 * 
 * Copyright (c) 2016 CEA LIST.
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
package org.eclipse.papyrus.moka.fmi.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fmi.modeldescription.CausalityType;
import org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable;
import org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType;

public class FMIUtil {

	
	public static List<Fmi2ScalarVariable> getScalarVariables(FmiModelDescriptionType modelDescription, CausalityType causality){
		List<Fmi2ScalarVariable> ret = new ArrayList<Fmi2ScalarVariable>();
		if (modelDescription != null && modelDescription.getModelVariables() != null ){
			for (Fmi2ScalarVariable scalarVariable : modelDescription.getModelVariables().getScalarVariable()){
				if (causality.equals(scalarVariable.getCausality())){
					ret.add(scalarVariable);
				}
			}
		}
		return ret;
	}

	public static boolean isPort(Fmi2ScalarVariable variable) {
		
		return variable.getCausality() == CausalityType.INPUT || variable.getCausality() == CausalityType.OUTPUT;
	}
}
