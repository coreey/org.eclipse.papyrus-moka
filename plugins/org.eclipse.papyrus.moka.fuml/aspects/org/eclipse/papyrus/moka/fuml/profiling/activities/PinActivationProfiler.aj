/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.profiling.activities;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.actions.IActionActivation;
import org.eclipse.papyrus.moka.fuml.actions.IPinActivation;
import org.eclipse.papyrus.moka.fuml.activities.IActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.activities.IToken;
import org.eclipse.papyrus.moka.fuml.profiling.loci.SemanticVisitorProfiler;
import org.eclipse.uml2.uml.InputPin;

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
