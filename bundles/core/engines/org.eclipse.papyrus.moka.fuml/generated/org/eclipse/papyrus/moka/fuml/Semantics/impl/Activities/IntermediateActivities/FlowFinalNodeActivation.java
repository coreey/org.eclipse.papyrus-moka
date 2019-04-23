/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IFlowFinalNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.debug.Debug;

public class FlowFinalNodeActivation extends ControlNodeActivation implements IFlowFinalNodeActivation {

	@Override
	public void fire(List<IToken> incomingTokens) {
		// Consume all incoming tokens.
		Debug.println("[fire] Flow final node " + this.node.getName() + "...");
		for (int i = 0; i < incomingTokens.size(); i++) {
			IToken token = incomingTokens.get(i);
			token.withdraw();
		}
	}
}
