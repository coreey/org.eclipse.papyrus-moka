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

package org.eclipse.papyrus.moka.fuml.profiling.Semantics.Activities.IntermediateActivities;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IObjectNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.ObjectNodeActivation;
import org.eclipse.papyrus.moka.fuml.profiling.Semantics.Loci.SemanticVisitorProfiler;

public aspect ActivityNodeActivationProfiler extends SemanticVisitorProfiler {

	public ActivityNodeActivationProfiler() {
		super();
	}

	pointcut fire(IActivityNodeActivation activation, List<IToken> tokens):
		!within(ObjectNodeActivation+) &&
		target(activation) && 
		args(tokens) && 
		call(* IActivityNodeActivation.fire(List<IToken>));

	before(IActivityNodeActivation activation, List<IToken> tokens): fire(activation, tokens) {
		if(activation instanceof IObjectNodeActivation) {
			//this.visit(new ObjectNodeActivationWrapper((IObjectNodeActivation)activation, tokens));
		}else {
			this.visit(activation);
		}
	}

}