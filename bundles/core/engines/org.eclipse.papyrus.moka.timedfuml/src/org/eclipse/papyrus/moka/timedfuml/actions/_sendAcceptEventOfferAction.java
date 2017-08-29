/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.moka.timedfuml.actions;

import org.eclipse.papyrus.moka.discreteevent.actions.Action;
import org.eclipse.papyrus.moka.timedfuml.semantics.Timed_AcceptEventActionActivation;

/**
 * @author sg239226
 *
 */
public class _sendAcceptEventOfferAction extends Action {

	protected Timed_AcceptEventActionActivation actionActivation;

	public _sendAcceptEventOfferAction(Timed_AcceptEventActionActivation actionActivation) {
		super();
		this.actionActivation = actionActivation;
	}
	
	@Override
	public void execute() {
		this.actionActivation.accept(null);
	}

}
