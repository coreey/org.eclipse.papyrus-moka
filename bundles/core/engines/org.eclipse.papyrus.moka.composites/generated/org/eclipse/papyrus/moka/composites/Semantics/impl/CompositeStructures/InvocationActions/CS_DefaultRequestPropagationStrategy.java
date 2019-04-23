/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.InvocationActions;

// Imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.SendSignalActionActivation;


public class CS_DefaultRequestPropagationStrategy extends CS_RequestPropagationStrategy {

	@Override
	public List<IReference> select(List<IReference> potentialTargets, ISemanticVisitor context) {
		// returns all potential targets in the case where the context is a SendSignalActionActivation
		// returns the first potential target in the case where the context is anything else
		List<IReference> selectedTargets = new ArrayList<IReference>();
		if (context instanceof SendSignalActionActivation) {
			for (int i = 0; i < potentialTargets.size(); i++) {
				selectedTargets.add(potentialTargets.get(i));
			}
		} else {
			if (potentialTargets.size() >= 1) {
				selectedTargets.add(potentialTargets.get(0));
			}
		}
		return selectedTargets;
	}
}
