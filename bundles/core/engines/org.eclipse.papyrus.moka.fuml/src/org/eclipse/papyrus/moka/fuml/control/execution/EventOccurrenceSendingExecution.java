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

package org.eclipse.papyrus.moka.fuml.control.execution;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.Execution;

public class EventOccurrenceSendingExecution extends Execution{

	// Event occurrence that is required to be sent
	public IEventOccurrence self;
	
	@Override
	public void execute() {
		// Send the event occurrence to the etarget object
		this.self.doSend();
	}

	@Override
	public IValue new_() {
		EventOccurrenceSendingExecution sendingExecution = new EventOccurrenceSendingExecution();
		sendingExecution.self = this.self;
		return sendingExecution;
	}

	@Override
	public String toString() {
		return "EventOccurrenceSendingExecution("+this.self+")";
	}
}