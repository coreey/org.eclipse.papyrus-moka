/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
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
package org.eclipse.papyrus.moka.engine.uml.debug.service;

import java.util.Iterator;

import org.eclipse.papyrus.moka.fuml.activities.IActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.activities.IActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.loci.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IObject_;
import org.eclipse.papyrus.moka.pssm.statemachines.IStateMachineSemanticVisitor;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;

public class DebugServiceUtils {

	/**
	 * Get the semantic visitor execution context
	 * 
	 * @param visitor a semantic visitor for a model element
	 * @return the execution context
	 */
	protected static IObject_ getExecutionContext(final ISemanticVisitor visitor) {
		IObject_ executionContext = null;
		if (visitor instanceof IStateMachineSemanticVisitor) {
			executionContext = ((IStateMachineSemanticVisitor) visitor).getExecutionContext();
		} else {
			if (visitor instanceof IActivityNodeActivation
					&& (((IActivityNodeActivation) visitor).getGroup() != null)) {
				executionContext = ((IActivityNodeActivation) visitor).getExecutionContext();
			} else if (visitor instanceof IActivityEdgeInstance
					&& ((IActivityEdgeInstance) visitor).getSource().getGroup() != null) {
				executionContext = ((IActivityEdgeInstance) visitor).getSource().getExecutionContext();
			}
		}
		return executionContext;
	}

	public static boolean isActive(IObject_ value) {
		boolean active = false;
		Iterator<Classifier> typesIterator = value.getTypes().iterator();
		while (!active && typesIterator.hasNext()) {
			Classifier type = typesIterator.next();
			if (type instanceof Class) {
				active = ((Class) type).isActive() && !((Class) type).isAbstract();
			}
		}
		return active;
	}

}
