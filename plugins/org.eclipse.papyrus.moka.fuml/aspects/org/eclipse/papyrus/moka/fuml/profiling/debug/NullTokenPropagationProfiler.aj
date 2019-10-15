/*****************************************************************************
 * Copyright (c) 2019 CEA LIST.
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
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.profiling.debug;

import java.util.List;

import org.eclipse.papyrus.moka.debug.assistant.DebugAssistantException;
import org.eclipse.papyrus.moka.fuml.actions.OutputPinActivation;
import org.eclipse.papyrus.moka.fuml.activities.IObjectNodeActivation;
import org.eclipse.papyrus.moka.fuml.activities.IToken;
import org.eclipse.uml2.uml.OutputPin;

public aspect NullTokenPropagationProfiler extends AbstractActivityNodeDebugAssistantProfiler {

	public static final String ASSISTANT_ID = "org.eclipse.papyrus.moka.fuml.profiling.debug.NullTokenPropagationProfiler";
	
	public NullTokenPropagationProfiler() {
		super();
	}

	pointcut getUnofferedTokens(OutputPinActivation objectNode):
		target(objectNode) &&
		call(List<IToken> IObjectNodeActivation.getUnofferedTokens());
	
	after(OutputPinActivation objectNode) returning(List<IToken> tokens): getUnofferedTokens(objectNode){
		if(tokens.isEmpty() && ((OutputPin)objectNode.getNode()).getLower()> 0){
			throw new DebugAssistantException(this, objectNode);
		}
	}

	@Override
	public String getAssistantID() {
		return ASSISTANT_ID;
	}
	
}
