/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
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

package org.eclipse.papyrus.moka.engine.uml.time.actions;

import org.eclipse.papyrus.moka.engine.uml.time.scheduling.de.actions.CallbackAction;
import org.eclipse.papyrus.moka.engine.uml.time.semantics.Timed_OpaqueActionActivation;

/**
 * @author ac221913
 *
 */
public class SendOfferAction extends CallbackAction {

	protected Timed_OpaqueActionActivation actionActivation;

	public SendOfferAction(Timed_OpaqueActionActivation actionActivation) {
		super();
		this.actionActivation = actionActivation;
	}

	/**
	 * @see org.eclipse.papyrus.moka.engine.uml.time.scheduling.de.actions.Action#execute()
	 *
	 */
	@Override
	public void execute() {
		// System.out.println(DEScheduler.getInstance().getCurrentTime() + " : sending offer - " + this.actionActivation);
		this.actionActivation.sendOffersDefault();
	}

}
