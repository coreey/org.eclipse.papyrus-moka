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
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.AcceptCallAction;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.Trigger;

/**
 * fUML_receive_all_triggering_signals
 * 
 * Unless the action is an accept call action, the context class must have receptions for all triggering signals.
 * not self.oclIsKindOf(AcceptCallAction) implies
 * let cls:Class = self.context.oclAsType(Class) in
 * let classes:Bag(Class) = cls.allParents()->select(oclIsKindOf(Class))->collect(oclAsType(Class))->union(cls->asBag()) in
 * classes.ownedReception.signal→includesAll(self.trigger.event→collect(oclAsType(SignalEvent)).signal)
 */
public class FumlAcceptEventReceiveAllTriggeringSignalsConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		AcceptEventAction acceptEventAction = (AcceptEventAction) ctx.getTarget();
		if (false == acceptEventAction instanceof AcceptCallAction) {
			if (acceptEventAction.getContext() instanceof Class) {
				Class cls = (Class) acceptEventAction.getContext();
				List<Class> classes = cls.allParents().stream()
						.filter(c -> c instanceof Class)
						.map(c -> Class.class.cast(c))
						.collect(Collectors.toList());
				Set<Signal> contextReceptionSignals = new HashSet<>();
				for (Class clazz : classes) {
					for (Reception reception : clazz.getOwnedReceptions()) {
						contextReceptionSignals.add(reception.getSignal());
					}
				}
				for (Reception reception : cls.getOwnedReceptions()) {
					contextReceptionSignals.add(reception.getSignal());
				}
				Set<Signal> triggerSignals = new HashSet<>();
				for (Trigger trigger : acceptEventAction.getTriggers()) {
					if (trigger.getEvent() instanceof SignalEvent) {
						triggerSignals.add(((SignalEvent) trigger.getEvent()).getSignal());
					}
				}

				if (!contextReceptionSignals.containsAll(triggerSignals)) {
					return ctx.createFailureStatus("AcceptEventAction - Unless the action is an accept call action, the context class must have receptions for all triggering signals.");
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}