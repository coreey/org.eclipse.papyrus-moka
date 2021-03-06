/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
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
 *   CEA LIST - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.profiling.activities;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.activities.IActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.activities.IObjectNodeActivation;
import org.eclipse.papyrus.moka.fuml.activities.IToken;
import org.eclipse.papyrus.moka.fuml.activities.ObjectNodeActivation;
import org.eclipse.papyrus.moka.fuml.profiling.loci.SemanticVisitorProfiler;

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