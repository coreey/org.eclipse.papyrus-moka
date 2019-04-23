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

import org.eclipse.uml2.uml.Pin;

public class InputPinActivation extends PinActivation {

	@Override
	public void receiveOffer() {
		// Forward the offer to the action activation. [When all input pins are
		// ready, the action will fire them.]
		this.actionActivation.receiveOffer();
	}

	@Override
	public Boolean isReady() {
		// Return true if the total number of values already being offered by
		// this pin plus those being offered
		// by the sources of incoming edges is at least equal to the minimum
		// multiplicity of the pin.
		boolean ready = super.isReady();
		if (ready) {
			int totalValueCount = this.countUnofferedTokens() + this.countOfferedValues();
			int minimum = ((Pin) this.node).getLower();
			ready = totalValueCount >= minimum;
		}
		return ready;
	}
}
