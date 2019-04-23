/*****************************************************************************
 * 
 * Copyright (c) 2016 CEA LIST.
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
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.utils.helper.semantics;

import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IPseudostateActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IStateActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IStateMachineSemanticVisitor;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.ITransitionActivation;
import org.eclipse.uml2.uml.NamedElement;

public class SemanticHelper {

	public static NamedElement getModelElement(ISemanticVisitor visitor) {
		// For a given type of visitor return the visited model element.
		// It returns null when the visited model element is null.
		NamedElement modelElement = null;
		if (visitor instanceof IActivityNodeActivation) {
			modelElement = ((IActivityNodeActivation) visitor).getNode();
		} else if (visitor instanceof IActivityEdgeInstance) {
			modelElement = ((IActivityEdgeInstance) visitor).getEdge();
		} else if (visitor instanceof IStateMachineSemanticVisitor) {
			modelElement = ((IStateMachineSemanticVisitor) visitor).getNode();
		}
		return modelElement;
	}

	public static String getName(ISemanticVisitor visitor) {
		String name = "undefined";
		NamedElement modelElement = getModelElement(visitor);
		if (modelElement != null) {
			if(modelElement.getName() != null) {
				name = modelElement.getName();
			}
			if (visitor instanceof IActivityNodeActivation) {
				name += " [Activity Node]";
			} else if (visitor instanceof IActivityEdgeInstance) {
				name += " [Activity Edge]";
			} else if (visitor instanceof IPseudostateActivation) {
				name += " [Pseudostate]";
			} else if (visitor instanceof IStateActivation) {
				name += " [State]";
			} else if (visitor instanceof ITransitionActivation) {
				name += " [Transition]";
			}
		}
		return name;
	}

}
