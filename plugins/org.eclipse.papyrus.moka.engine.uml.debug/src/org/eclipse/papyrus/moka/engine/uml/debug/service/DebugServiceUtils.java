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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IBreakpointManager;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.debug.breakpoint.MokaBreakpoint;
import org.eclipse.papyrus.moka.fuml.activities.IActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.activities.IActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.loci.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IObject_;
import org.eclipse.papyrus.moka.pssm.statemachines.IStateMachineSemanticVisitor;
import org.eclipse.papyrus.moka.utils.constants.MokaConstants;
import org.eclipse.papyrus.moka.utils.helper.semantics.SemanticHelper;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;

public class DebugServiceUtils {

	/**
	 * Check if the node executed by this semantic visitor has a breakpoint.
	 * 
	 * @param visitor a semantic visitor for a model element
	 * @return true if the model element has a breakpoint and false otherwise
	 */
	protected static boolean hasBreakpoint(final ISemanticVisitor visitor) {
		boolean breakpointExist = false;
		IBreakpointManager breakpointManager = DebugPlugin.getDefault().getBreakpointManager();
		IBreakpoint[] breakpoints = breakpointManager.getBreakpoints(MokaConstants.MOKA_DEBUG_MODEL_ID);
		EObject visitedModelElement = SemanticHelper.getModelElement(visitor);
		if (visitedModelElement != null) {
			int i = 0;
			while (!breakpointExist && i < breakpoints.length) {
				MokaBreakpoint breakpoint = (MokaBreakpoint) breakpoints[i];
				boolean isEnabled = false;
				try {
					isEnabled = breakpoint.isEnabled();
				} catch (CoreException e) {
					e.printStackTrace();
				}
				if (isEnabled && visitedModelElement == breakpoint.getModelElement()) {
					breakpointExist = true;
				}
				i++;
			}
		}
		return breakpointExist;
	}

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
