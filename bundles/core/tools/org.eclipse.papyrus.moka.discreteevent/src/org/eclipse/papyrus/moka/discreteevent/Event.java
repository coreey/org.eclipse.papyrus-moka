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

import org.eclipse.papyrus.moka.discreteevent.actions.Action;

public class Event {
	
	protected double relativeDate ;
	protected double absoluteDate ;
	protected Action action ;
	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
		this.action.setEvent(this);
	}
	protected DEScheduler scheduler ;
	
	public DEScheduler getScheduler() {
		return scheduler;
	}

	public void setScheduler(DEScheduler scheduler) {
		this.scheduler = scheduler;
	}

	public Event(double relativeDate, Action action) {
		this.relativeDate = relativeDate;
		setAction(action);
	}
	
	public double getRelativeDate() {
		return relativeDate;
	}
	public void setRelativeDate(double relativeDate) {
		this.relativeDate = relativeDate;
	}
	public double getAbsoluteDate() {
		return absoluteDate;
	}
	public void setAbsoluteDate(double absoluteDate) {
		this.absoluteDate = absoluteDate;
	}
	
}
