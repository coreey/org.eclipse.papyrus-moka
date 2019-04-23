/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
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

package org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.CompleteActions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReturnInformation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.ReplyAction;
import org.eclipse.uml2.uml.Trigger;

public class ReplyActionActivation extends ActionActivation {

	@Override
	public void doAction() {
		// Reply to the call represented by the return information on
		// the return information pin using the reply values given
		// on the reply value pins.
		ReplyAction action = (ReplyAction) this.node;
		Trigger replyToCall = action.getReplyToCall();
		List<InputPin> replyValuePins = action.getReplyValues();
		InputPin returnInformationPin = action.getReturnInformation();
		List<IValue> values = this.takeTokens(returnInformationPin);
		IReturnInformation returnInformation = (IReturnInformation) values.get(0);
		if (replyToCall.getEvent() instanceof CallEvent
				& ((CallEvent) replyToCall.getEvent()).getOperation() == returnInformation.getOperation()) {
			List<IParameterValue> parameterValues = new ArrayList<IParameterValue>();
			int i = 1;
			while (i <= replyValuePins.size()) {
				IParameterValue parameterValue = new ParameterValue();
				parameterValue.setValues(this.takeTokens(replyValuePins.get(i - 1)));
				parameterValues.add(parameterValue);
				i = i + 1;
			}
			returnInformation.reply(parameterValues);
		}
	}

}