/*****************************************************************************
 * 
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.fmu.engine.semantics;

import org.eclipse.papyrus.moka.fuml.Semantics.Actions.CompleteActions.IAcceptEventActionEventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.CompleteActions.AcceptEventActionEventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications.SignalInstance;
import org.eclipse.papyrus.moka.service.IMokaExecutionListener;
import org.eclipse.papyrus.moka.service.IMokaService;
import org.eclipse.papyrus.moka.service.MokaServiceRegistry;

public class FMUAcceptChangeEventActionEventAccepter extends AcceptEventActionEventAccepter implements IAcceptEventActionEventAccepter {

	public void accept(IEventOccurrence eventOccurrence) {
		if (eventOccurrence instanceof FMUChangeEventOccurence) {
			// FIXME notification should be automatically handled by an aspect (which doesn't work)
			for (IMokaService service : MokaServiceRegistry.getInstance().getAllServices()) {
				if(service instanceof IMokaExecutionListener){
					((IMokaExecutionListener)service).nodeLeft(this.actionActivation);
				}
			}
			//
			this.actionActivation.accept(new SignalInstance());
		}
		else {
			super.accept(eventOccurrence);
		}
	}

	public Boolean match(IEventOccurrence eventOccurrence) {
		boolean matches = false;
		if (eventOccurrence instanceof FMUChangeEventOccurence) {
			matches = ((FMUAcceptChangeEventActionActivation)this.actionActivation).matchChangeEvent((FMUChangeEventOccurence) eventOccurrence);
		}
		return matches;
	}

}
