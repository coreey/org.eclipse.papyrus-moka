/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.validation.constraints;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallAction;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.Signal;

/**
 * This class is introduced to check the following constraint:
 * Argument / result pins of call actions shall match parameters of invoked / sent Operation / Behavior / Signal
 * See 439648: [Moka] [Validation] Argument / result pins of call actions shall match parameters of invoked / sent Operation / Behavior / Signal
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=439648
 *
 */
public class ArgumentAndResultPinsOfCallActions_Constraint extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		// fUML / PSCS support three kinds of call actions: CallOperationAction, CallBehaviorAction, SendSignalAction
		// First gather relevant information to validate argument / result pins of the call,
		// which a an approach specific to each kind of action.
		// From the standpoint of the fUML Execution Engine, only the number of pins are relevant
		List<ConnectableElement> inputParameters = new ArrayList<ConnectableElement>();
		List<ConnectableElement> outputParameters = new ArrayList<ConnectableElement>();
		if (ctx.getTarget() instanceof CallOperationAction || ctx.getTarget() instanceof CallBehaviorAction) {
			List<Parameter> allParameters = new ArrayList<Parameter>();
			if (ctx.getTarget() instanceof CallOperationAction) {
				Operation op = ((CallOperationAction) ctx.getTarget()).getOperation();
				if (op != null) {
					allParameters.addAll(op.getOwnedParameters());
				}
			} else if (ctx.getTarget() instanceof CallBehaviorAction) {
				Behavior behav = ((CallBehaviorAction) ctx.getTarget()).getBehavior();
				if (behav != null) {
					allParameters.addAll(behav.getOwnedParameters());
				}
			}
			for (Parameter p : allParameters) {
				if (p.getDirection().equals(ParameterDirectionKind.IN_LITERAL) || p.getDirection().equals(ParameterDirectionKind.INOUT_LITERAL)) {
					inputParameters.add(p);
				}
				if (p.getDirection().equals(ParameterDirectionKind.INOUT_LITERAL) || p.getDirection().equals(ParameterDirectionKind.OUT_LITERAL) || p.getDirection().equals(ParameterDirectionKind.RETURN_LITERAL)) {
					outputParameters.add(p);
				}
			}
		} else if (ctx.getTarget() instanceof SendSignalAction) {
			Signal s = ((SendSignalAction) ctx.getTarget()).getSignal();
			if (s != null) {
				inputParameters.addAll(s.getAllAttributes());
			}
		}

		CallAction callAction = (CallAction) ctx.getTarget();
		String argumentsErrorMessage = "";
		if (callAction.getArguments().size() < inputParameters.size()) {
			argumentsErrorMessage += "Not enough argument pins (found " + callAction.getArguments().size() + ", expected " + inputParameters.size() + ")";
		} else if (callAction.getArguments().size() > inputParameters.size()) {
			argumentsErrorMessage += "Too many argument pins (found " + callAction.getArguments().size() + ", expected " + inputParameters.size() + ")";
		}
		String resultsErrorMessage = "";
		if (callAction.getResults().size() < outputParameters.size()) {
			resultsErrorMessage += "Not enough result pins (found " + callAction.getResults().size() + ", expected " + outputParameters.size() + ")";
		} else if (callAction.getResults().size() > outputParameters.size()) {
			if (callAction.getResults().size() < outputParameters.size()) {
				resultsErrorMessage += "Too many result pins (found " + callAction.getResults().size() + ", expected " + outputParameters.size() + ")";
			}
		}

		if (argumentsErrorMessage.equals("") && resultsErrorMessage.equals("")) {
			return ctx.createSuccessStatus();
		}

		if (!argumentsErrorMessage.equals("")) {
			resultsErrorMessage = " - " + resultsErrorMessage;
		}

		return ctx.createFailureStatus(argumentsErrorMessage + resultsErrorMessage);
	}

}
