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

import org.eclipse.papyrus.moka.fuml.Semantics.Activities.ExtraStructuredActivities.IExpansionActivationGroup;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.ExtraStructuredActivities.ExpansionActivationGroup;
import org.eclipse.papyrus.moka.fuml.debug.Debug;

public class ActivityFinalNodeActivation extends ControlNodeActivation {

	@Override
	public void fire(List<IToken> incomingTokens) {
		// Terminate the activity execution or structured node activation
		// containing this activation.
		Debug.println("[fire] Activity final node " + this.node.getName() + "...");
		if (incomingTokens.size() > 0 | this.incomingEdges.size() == 0) {
			if (this.getGroup().getActivityExecution_() != null) {
				this.getGroup().getActivityExecution_().terminate();
			} else if (this.getGroup().getContainingActivation() != null) {
				this.getGroup().getContainingActivation().terminateAll();
			} else if (this.getGroup() instanceof ExpansionActivationGroup) {
				((IExpansionActivationGroup) this.group).getRegionActivation().terminate();
			}
		}
	}
}
