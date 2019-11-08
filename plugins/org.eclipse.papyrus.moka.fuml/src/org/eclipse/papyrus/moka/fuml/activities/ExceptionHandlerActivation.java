/*****************************************************************************
 * Copyright (c) 2020 CEA LIST.
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
 *  Jeremie TATIBOUET (CEA LIST) <jeremie.taibouet@cea.fr>
  *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.activities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.actions.IActionActivation;
import org.eclipse.papyrus.moka.fuml.actions.IPinActivation;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IValue;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Pin;

public class ExceptionHandlerActivation implements IExceptionHandlerActivation {

	protected ExceptionHandler handler;

	protected IActionActivation declaringActionActivation;

	public void setHandler(ExceptionHandler handler) {
		this.handler = handler;
	}
	
	@Override
	public void setDeclaringActionActivation(IActionActivation activation) {
		declaringActionActivation = activation;
	}

	public boolean match(IValue exception) {
		boolean match = false;
		if (handler != null && exception != null) {
			Iterator<Classifier> itExceptionTypes = handler.getExceptionTypes().iterator();
			while (!match && itExceptionTypes.hasNext()) {
				match = exception.isInstanceOf(itExceptionTypes.next());
			}
		}
		return match;
	}

	@Override
	public boolean handle(IValue exception) {
		boolean handled = false;
		if (declaringActionActivation != null && exception != null) {
			IActivityNodeActivationGroup group = declaringActionActivation.getGroup();
			if (group != null) {
				IActionActivation actionActivation = (IActionActivation) group
						.getNodeActivation(handler.getHandlerBody());
				if (actionActivation != null) {
					IPinActivation pinActivation = actionActivation.getPinActivation((Pin) handler.getExceptionInput());
					if(pinActivation != null) {
						IObjectToken token = new ObjectToken();
						token.setValue(exception);
						pinActivation.addToken(token);
						if(actionActivation.isReady()) {
							handled = true;
							actionActivation.receiveOffer();
							transferOutputs(actionActivation);
						}
					}
				}
			}
		}
		return handled;
	}
	
	public void transferOutputs(IActionActivation source) {
		List<OutputPin> sourceOutputs = ((Action)source.getNode()).getOutputs();
		List<OutputPin> targetOutputs = ((Action)declaringActionActivation.getNode()).getOutputs();
		for(int i = 0; i < sourceOutputs.size(); i++) {
			IPinActivation sourcePinActivation = source.getPinActivation(sourceOutputs.get(i));
			List<IValue> values = new ArrayList<IValue>();
			for(IToken token : sourcePinActivation.takeTokens()) {
				values.add(token.getValue());
			}
			declaringActionActivation.putTokens(targetOutputs.get(i), values);
		}
	}

}
