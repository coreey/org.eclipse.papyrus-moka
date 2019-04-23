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
 *  Jeremie Tatibouet (CEA LIST) - Alignment of the asynchronous implementation of fUML with the version 1.2 of the standard
 *  
 *****************************************************************************/
package org.eclipse.papyrus.moka.async.fuml.Semantics.CommonBehaviors.Communications;

import org.eclipse.papyrus.moka.async.fuml.Activator;
import org.eclipse.papyrus.moka.async.fuml.debug.AsyncDebug;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;

/**
 * FIFO strategy that retrieve the oldest SignalInstance owned by the EventPool object.
 */
public class AsyncFIFOGetNextEventStrategy extends AsyncGetNextEventStrategy {

	@Override
	/**
	 * This method is always called by the object activation owning the event pool.
	 * The call is blocking if no SignalInstance can be retrieved from the event pool.
	 */
	public IEventOccurrence getNextEvent(AsyncEventPool eventPool) {
		IEventOccurrence eventOccurrence = null;
		try {
			eventOccurrence = eventPool.take();
		} catch (InterruptedException e) {
			AsyncDebug.println("getNextEvent interrupted while waiting");
			Activator.log.error(e);
		}
		return eventOccurrence;
	}
}
