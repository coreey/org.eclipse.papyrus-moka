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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.SendSignalAction;

/**
 * target_signal_reception
 * 
 * The target input pin must have a type that has a reception for the signal.
 * self.target.type.oclAsType(Classifier).allFeatures()->select(oclIsKindOf(Reception))
 * ->exists(f:Feature|self.signal.conformsTo(f.oclAsType(Reception).signal))
 */
public class FumlSendSignalActionTargetSignalReceptionConstraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		SendSignalAction sendSignalAction = (SendSignalAction) ctx.getTarget();
		if (sendSignalAction.getSignal() != null
				&& sendSignalAction.getTarget() != null
				&& sendSignalAction.getTarget().getType() != null
				&& sendSignalAction.getTarget().getType() instanceof Classifier) {
			Classifier targetType = (Classifier) sendSignalAction.getTarget().getType();
			boolean targetHasReception = targetType.getFeatures().stream()
					.filter(feature -> feature instanceof Reception)
					.map(Reception.class::cast)
					.anyMatch(f -> sendSignalAction.getSignal().conformsTo(f.getSignal()));
			if (!targetHasReception) {
				return ctx.createFailureStatus("SendSignalAction - The target input pin must have a type that has a reception for the signal.");
			}
		}
		return ctx.createSuccessStatus();
	}
}