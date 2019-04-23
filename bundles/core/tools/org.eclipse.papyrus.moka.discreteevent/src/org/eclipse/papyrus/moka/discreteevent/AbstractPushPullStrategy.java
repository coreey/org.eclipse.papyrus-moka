/*****************************************************************************
 * 
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.discreteevent;

import java.util.List;

public abstract class AbstractPushPullStrategy {

	protected DEScheduler scheduler ;
	
	public DEScheduler getScheduler() {
		return scheduler;
	}

	public void setScheduler(DEScheduler scheduler) {
		this.scheduler = scheduler;
	}

	public abstract List<Event> pullEvents(double date) ;
	
	public abstract void pushEvent(Event event) ;
	
	public abstract void pushEvent(Event event, double absoluteDate) ;
	
}
