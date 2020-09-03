/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
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

package org.eclipse.papyrus.moka.engine.uml.scheduling;

import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.papyrus.moka.fuml.commonbehavior.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IExecution;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IValue;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IObject_;
import org.eclipse.papyrus.moka.fuml.tasks.IUMLEventSendingExecution;
import org.eclipse.papyrus.moka.kernel.scheduling.control.IExecutionLoop;
import org.eclipse.papyrus.moka.kernel.scheduling.execution.ITaskExecution;

public class UMLEventSendingTaskExecution extends UMLTaskExecution implements IUMLEventSendingExecution{

	/**
	 * Event occurrence to be sent
	 */
	protected IEventOccurrence event;
	
	/**
	 * Enable safe access to the event
	 */
	protected ReentrantLock eventLock;

	
	public UMLEventSendingTaskExecution(IExecutionLoop loop) {
		super(loop);
		eventLock = new ReentrantLock(true);
	}

	/**
	 * @see {@link IUMLEventSendingExecution#setEvent(IEventOccurrence)} 
	 */
	@Override
	public void setEvent(IEventOccurrence eventOcccurence) {
		eventLock.lock();
		event = eventOcccurence;
		eventLock.unlock();
	}
	
	/**
	 * @see {@link ITaskExecution#canExecute()}
	 */
	@Override
	public boolean canExecute() {
		boolean canExecute = false;
		eventLock.lock();
		canExecute = event != null;
		eventLock.unlock();
		return canExecute;
	}
	
	/**
	 * @see IUMLEventSendingExecution#sendEvent()
	 */
	@Override
	public void sendEvent() {
		eventLock.lock();
		if(event != null) {
			event.doSend();
		}
		eventLock.unlock();
	}
	
	/**
	 * @see IExecution#execute()
	 * 
	 * Delegates to IEventSendingExecution#sendEvent()
	 */
	@Override
	public void execute() {
		sendEvent();
	}

	/**
	 * @see IExecution#new_()
	 * 
	 */
	@Override
	public IValue new_() {
		UMLEventSendingTaskExecution sendingExecution = new UMLEventSendingTaskExecution(executionLoop);
		eventLock.lock();
		sendingExecution.event = event;
		eventLock.unlock();
		return sendingExecution;
	}

	@Override
	public String toString() {
		return "EventOccurrenceSendingExecution(" + event + ")";
	}
	
	/**
	 * @see IExecution#terminate()
	 * 
	 * The event becomes null which prevents any sending to be done
	 */
	@Override
	public void terminate() {
		eventLock.lock();
		event = null;
		eventLock.unlock();
	}
	
	@Override
	public IObject_ getContext() {
		IObject_ context = null;
		eventLock.lock();
		if(event != null) {
			context = event.getTarget().getReferent();
		}
		eventLock.unlock();
		return context;
	}

}