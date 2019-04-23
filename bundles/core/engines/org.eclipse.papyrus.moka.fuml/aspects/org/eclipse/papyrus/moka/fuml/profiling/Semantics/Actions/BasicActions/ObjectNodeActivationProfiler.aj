/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0.html/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.profiling.Semantics.Actions.BasicActions;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IObjectNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.profiling.Semantics.Loci.SemanticVisitorProfiler;

public aspect ObjectNodeActivationProfiler extends SemanticVisitorProfiler{
	
	pointcut sendOffer(IObjectNodeActivation activation, List<IToken> tokens) : 
		target(activation) &&
		args(tokens) &&
		call(* IActivityNodeActivation.sendOffers(List<IToken>));
	
	
	before(IObjectNodeActivation activation, List<IToken> tokens) : sendOffer(activation, tokens){
		this.visit(new ObjectNodeActivationWrapper(activation, tokens));
	}
	
}