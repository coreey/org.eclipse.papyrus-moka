/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0.html/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.profiling.Semantics.Actions.BasicActions;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IPinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.profiling.Semantics.Loci.SemanticVisitorProfiler;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivation;

public aspect PinActivationProfiler extends SemanticVisitorProfiler{

	pointcut addTokens(IPinActivation activation, List<IToken> tokens) : 
		target(activation) &&
		args(tokens) &&
		call(* IActivityNodeActivation.addTokens(List<IToken>));
	
	
	after(IPinActivation activation, List<IToken> tokens) : addTokens(activation, tokens){
		this.visit(activation);
	}
	
	pointcut takeTokens(IActionActivation activation, InputPin pin) : 
		target(activation) &&
		args(pin) &&
		call(* IActionActivation.takeTokens(InputPin));
	
	after(IActionActivation activation, InputPin pin) : takeTokens(activation, pin){
		this.leave(activation.getPinActivation(pin));
	}
	
}
