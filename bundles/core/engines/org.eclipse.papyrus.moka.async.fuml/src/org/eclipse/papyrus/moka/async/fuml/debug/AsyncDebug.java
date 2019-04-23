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
 *  Jeremie Tatibouet (CEA LIST) - Add a utility method to print information about an event occurrence that is lost 
 *  
 *****************************************************************************/
package org.eclipse.papyrus.moka.async.fuml.debug;

import java.io.IOException;

import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.CompleteActions.IAcceptEventActionEventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ISignalEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ISignalInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications.ObjectActivation;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.console.IOConsoleOutputStream;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.Trigger;

/**
 * The Class AsyncDebug.
 */
public class AsyncDebug extends Debug {

	/**
	 * The displayed message states:
	 * - What event was lost
	 * - The object to which the signal was sent
	 * - What were the registered event accepters at the time which the event was consumed
	 * 
	 * @param eventOccurrence
	 *            the event that is lost
	 * @param objectActivation
	 *            the event activation attached to the object that lost the signal
	 * @param outstream
	 *            the stream on which the message must be displayed
	 */
	public static void printLostSignal(final IEventOccurrence eventOccurrence, final ObjectActivation objectActivation, final IOConsoleOutputStream outstream) {
		String expectedSignals = "";
		for (IEventAccepter eventAccepter : objectActivation.waitingEventAccepters) {
			if (eventAccepter instanceof IAcceptEventActionEventAccepter) {
				IAcceptEventActionEventAccepter acceptEventAccepter = (IAcceptEventActionEventAccepter) eventAccepter;
				AcceptEventAction acceptEventAction = (AcceptEventAction) acceptEventAccepter.getActionActivation().getNode();
				for (Trigger trigger : acceptEventAction.getTriggers()) {
					if (trigger.getEvent() instanceof SignalEvent) {
						SignalEvent signalEvent = (SignalEvent) trigger.getEvent();
						Signal signal = signalEvent.getSignal();
						if (!expectedSignals.isEmpty()) {
							expectedSignals += ", ";
						}
						expectedSignals += signal.getName();
					}
				}
			}
		}
		if (eventOccurrence instanceof ISignalEventOccurrence) {
			final ISignalInstance finalSignalInstance = ((ISignalEventOccurrence) eventOccurrence).getSignalInstance();
			final String finalExpectedSignals = expectedSignals;
			Display.getDefault().syncExec(new Runnable() {
				public void run() {
					try {
						outstream.setColor(new Color(null, new RGB(200, 120, 10)));
						outstream.write("[ WARNING : Lost signal " + finalSignalInstance.getTypes().get(0).getName() + " (classifier behavior of " + objectActivation.object + " was waiting for " + finalExpectedSignals + ") ]\n");
						outstream.flush();
					} catch (IOException e) {
						Activator.log.error(e);
					}
				}
			});
		}
	}
}
