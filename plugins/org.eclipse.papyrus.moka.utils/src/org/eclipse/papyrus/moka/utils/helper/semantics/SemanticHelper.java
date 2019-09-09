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

import org.eclipse.papyrus.moka.fuml.activities.IActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.activities.IActivityNodeActivation;
import org.eclipse.papyrus.moka.pssm.statemachines.IPseudostateActivation;
import org.eclipse.papyrus.moka.pssm.statemachines.IStateActivation;
import org.eclipse.papyrus.moka.pssm.statemachines.IStateMachineSemanticVisitor;
import org.eclipse.papyrus.moka.pssm.statemachines.ITransitionActivation;
import org.eclipse.uml2.uml.NamedElement;

public class SemanticHelper {

	public static NamedElement getModelElement(Object object) {
		// For a given type of visitor return the visited model element.
		// It returns null when the visited model element is null.
		NamedElement modelElement = null;
		if (object instanceof IActivityNodeActivation) {
			modelElement = ((IActivityNodeActivation) object).getNode();
		} else if (object instanceof IActivityEdgeInstance) {
			modelElement = ((IActivityEdgeInstance) object).getEdge();
		} else if (object instanceof IStateMachineSemanticVisitor) {
			modelElement = ((IStateMachineSemanticVisitor) object).getNode();
		}
		return modelElement;
	}

	public static String getName(Object object) {
		String name = "undefined";
		NamedElement modelElement = getModelElement(object);
		if (modelElement != null) {
			if(modelElement.getName() != null) {
				name = modelElement.getName();
			}
			if (object instanceof IActivityNodeActivation) {
				name += " [Activity Node]";
			} else if (object instanceof IActivityEdgeInstance) {
				name += " [Activity Edge]";
			} else if (object instanceof IPseudostateActivation) {
				name += " [Pseudostate]";
			} else if (object instanceof IStateActivation) {
				name += " [State]";
			} else if (object instanceof ITransitionActivation) {
				name += " [Transition]";
			}
		}
		return name;
	}

}
