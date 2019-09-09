/*****************************************************************************
 * Copyright (c) 2019 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier:EPL-2.0 
 *
 * Contributors:
 *  Pauline DEVILLE (CEA LIST) pauline.deville@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.validation.constraints;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.Classifier;

/**
 * proper_context
 * 
 * If the behavior has a context, it must be the same as the context of the enclosing
 * activity or a (direct or indirect) superclass of it.
 * self.behavior.context->notEmpty() implies
 * self.context->union(self.context.allParents())->includes(self.behavior.context)
 */
public class FumlCallBehaviorActionProperContextConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		CallBehaviorAction callBehaviorAction = (CallBehaviorAction) ctx.getTarget();
		if (callBehaviorAction.getBehavior() != null) {
			if (callBehaviorAction.getContext() != null) {
				List<Classifier> inheritedContext = new ArrayList<>();
				inheritedContext.add(callBehaviorAction.getContext());
				inheritedContext.addAll(callBehaviorAction.getContext().allParents());
				if (!inheritedContext.contains(callBehaviorAction.getBehavior().getContext())) {
					return ctx.createFailureStatus("CallBehaviorAction - If the behavior has a context, it must be the same as the context of the enclosing activity or a (direct or indirect) superclass of it.");
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}