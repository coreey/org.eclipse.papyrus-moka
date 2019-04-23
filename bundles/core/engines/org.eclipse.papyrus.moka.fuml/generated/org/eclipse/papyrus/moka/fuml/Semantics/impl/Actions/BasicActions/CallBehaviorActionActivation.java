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
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.OpaqueBehavior;

public class CallBehaviorActionActivation extends CallActionActivation {

	@Override
	public IExecution getCallExecution() {
		// Create and execution for the given behavior at the current locus and
		// return the resulting execution object.
		// If the given behavior is in the context of a classifier, then pass
		// the current context object as the context for the call.
		// Otherwise, use a null context.
		// [Note that this requires the behavior context to be compatible with
		// the type of the current context object.]
		Behavior behavior = ((CallBehaviorAction) (this.node)).getBehavior();
		IObject_ context;
		if (behavior instanceof OpaqueBehavior) {
			context = this.getActivityExecution(); // Enable to find out the execution context of an OpaqueBehavior
		} else {
			if (behavior.getContext() == null) {
				context = null;
			} else {
				context = this.getExecutionContext();
			}
		}
		// Debug.println("[getCallExecution] context = " + context);
		return this.getExecutionLocus().getFactory().createExecution(behavior, context);
	}
}
