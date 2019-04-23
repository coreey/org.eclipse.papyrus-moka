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

import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IJoinNodeActivation;

public class JoinNodeActivation extends ControlNodeActivation implements IJoinNodeActivation {

	@Override
	public Boolean isReady() {
		// Check that all incoming edges have sources that are offering tokens.
		boolean ready = true;
		int i = 1;
		while (ready & i <= this.incomingEdges.size()) {
			ready = this.incomingEdges.get(i - 1).hasOffer();
			i = i + 1;
		}
		return ready;
	}
}
