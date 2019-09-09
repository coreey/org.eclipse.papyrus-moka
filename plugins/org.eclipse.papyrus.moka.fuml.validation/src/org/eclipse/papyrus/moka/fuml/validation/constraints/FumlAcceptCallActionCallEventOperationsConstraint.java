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

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.AcceptCallAction;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Trigger;

/**
 * fuml_accept_call_action_call_event_operations
 * 
 * The operations of the call events on the triggers of an accept call action must be owned or inherited
 * by the context class of the action.
 * let cls: Class = self.context.oclAsType(Class) in
 * let classes:Bag(Class) = cls.allParents()->select(oclIsKindOf(Class))->collect(oclAsType(Class))->union(cls->asBag()) in
 * classes.ownedOperation→includesAll(self.trigger.event→collect(oclAsType(CallEvent)).operation)
 */
public class FumlAcceptCallActionCallEventOperationsConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		AcceptCallAction acceptCallAction = (AcceptCallAction) ctx.getTarget();
		if (acceptCallAction.getContext() instanceof org.eclipse.uml2.uml.Class) {
			org.eclipse.uml2.uml.Class cls = (org.eclipse.uml2.uml.Class) acceptCallAction.getContext();
			Set<Class> classes = cls.allParents().stream()
					.filter(c -> c instanceof Class)
					.map(c -> Class.class.cast(c))
					.collect(Collectors.toSet());
			classes.add(cls);
			Set<Operation> triggersOperation = new HashSet<Operation>();
			for (Trigger trigger : acceptCallAction.getTriggers()) {
				if (trigger.getEvent() instanceof CallEvent) {
					triggersOperation.add(((CallEvent) trigger.getEvent()).getOperation());
				}
			}
			Set<Operation> classesOperation = new HashSet<Operation>();
			for (Class clazz : classes) {
				classesOperation.addAll(clazz.getOwnedOperations());
			}
			if (!classesOperation.containsAll(triggersOperation)) {
				return ctx.createFailureStatus("AcceptCallAction - The operations of the call events on the triggers of an accept call action must be owned or inherited by the context class of the action.");
			}
		}
		return ctx.createSuccessStatus();
	}
}