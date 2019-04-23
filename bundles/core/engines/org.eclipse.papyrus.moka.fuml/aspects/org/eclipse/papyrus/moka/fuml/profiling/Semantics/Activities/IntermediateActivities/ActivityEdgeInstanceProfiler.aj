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

import org.eclipse.papyrus.moka.fuml.profiling.Semantics.Loci.SemanticVisitorProfiler;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;

public aspect ActivityEdgeInstanceProfiler extends SemanticVisitorProfiler{
	
	public ActivityEdgeInstanceProfiler(){
		super();
	}
	
	pointcut sendOffer(IActivityEdgeInstance edgeInstance, List<IToken> tokens) : 
		target(edgeInstance) &&
		args(tokens) &&
		call(* IActivityEdgeInstance.sendOffer(List<IToken>));
	
	before(IActivityEdgeInstance edgeInstance, List<IToken> tokens): sendOffer(edgeInstance, tokens){
		this.visit(edgeInstance);
	}
	
	pointcut takeOfferedTokens(IActivityEdgeInstance edgeInstance):
		target(edgeInstance) &&
		call(List<IToken> IActivityEdgeInstance.takeOfferedTokens());
	
	after(IActivityEdgeInstance edgeInstance) returning(List<IToken> tokens): takeOfferedTokens(edgeInstance){
		if(!tokens.isEmpty()){
			this.leave(edgeInstance);
		}
	}
	
	pointcut takeOfferedTokensMax(IActivityEdgeInstance edgeInstance, Integer maxCount):
		target(edgeInstance) &&
		args(maxCount) &&
		call(List<IToken> IActivityEdgeInstance.takeOfferedTokens(Integer));
	
	after(IActivityEdgeInstance edgeInstance, Integer maxCount) returning(List<IToken> tokens): takeOfferedTokensMax(edgeInstance, maxCount){
		if(!edgeInstance.hasOffer()){
			this.leave(edgeInstance);
		}
	}
}