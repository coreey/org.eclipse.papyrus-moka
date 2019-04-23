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
 *  Jeremie Tatibouet (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IClassifierBehaviorInvocationEventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IObjectActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Object_;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1.ChoiceStrategy;
import org.eclipse.papyrus.moka.fuml.control.execution.EventDispatchLoopExecution;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;

public class ObjectActivation implements IObjectActivation {

	/*
	 * The invocations of the executing classifier behaviors for this object activation
	 * 
	 * fUML12-35 Initial execution of an activity is not run to completion
	 */
	public List<IClassifierBehaviorInvocationEventAccepter> classifierBehaviorInvocations = new ArrayList<IClassifierBehaviorInvocationEventAccepter>();

	/*
	 * The set of event accepters waiting for event occurrences to be dispatched from the pool
	 */
	public List<IEventAccepter> waitingEventAccepters = new ArrayList<IEventAccepter>();

	/*
	 * The pool of event occurrences received by the object of this object activation, pending
	 * dispatching as events.
	 * 
	 * fUML12-35 Initial execution of an activity is not run to completion
	 */
	public List<IEventOccurrence> eventPool = new ArrayList<IEventOccurrence>();

	/*
	 * The object whose active behavior is being handled by this active object.
	 */
	public IObject_ object;

	public void stop() {
		// Stop this object activation by terminating all classifier behavior
		// executions.

		// fUML12-35 Initial execution of an activity is not run to completion

		List<IClassifierBehaviorInvocationEventAccepter> classifierBehaviorExecutions = this.classifierBehaviorInvocations;
		for (int i = 0; i < classifierBehaviorExecutions.size(); i++) {
			IClassifierBehaviorInvocationEventAccepter classifierBehaviorExecution = classifierBehaviorExecutions.get(i);
			classifierBehaviorExecution.terminate();
		}
	}

	public void register(IEventAccepter accepter) {
		// Register the given event accepter to wait for a dispatched signal
		// event.
		Debug.println("[register] object = " + this.object);
		Debug.println("[register] accepter = " + accepter);
		this.waitingEventAccepters.add(accepter);
	}

	public void unregister(IEventAccepter accepter) {
		// Remove the given event accepter for the list of waiting event
		// accepters.
		Debug.println("[unregister] object = " + this.object);
		Debug.println("[unregister] accepter = " + accepter);
		boolean notFound = true;
		int i = 1;
		while (notFound & i <= this.waitingEventAccepters.size()) {
			if (this.waitingEventAccepters.get(i - 1) == accepter) {
				this.waitingEventAccepters.remove(i - 1);
				notFound = false;
			}
			i = i + 1;
		}
	}

	public void dispatchNextEvent() {
		// fUML12-35 Initial execution of an activity is not run to completion
		if (this.eventPool.size() > 0) {
			IEventOccurrence eventOccurrence = this.getNextEvent();
			Debug.println("[dispatchNextEvent] eventOccurrence = " + eventOccurrence);
			List<Integer> matchingEventAccepterIndexes = new ArrayList<Integer>();
			List<IEventAccepter> waitingEventAccepters = this.waitingEventAccepters;
			for (int i = 0; i < waitingEventAccepters.size(); i++) {
				IEventAccepter eventAccepter = waitingEventAccepters.get(i);
				if (eventAccepter.match(eventOccurrence)) {
					matchingEventAccepterIndexes.add(i);
				}
			}
			if (matchingEventAccepterIndexes.size() > 0) {
				// *** Choose one matching event accepter non-deterministically.
				// ***
				int j = ((ChoiceStrategy) this.object.getLocus().getFactory().getStrategy("choice")).choose(matchingEventAccepterIndexes.size());
				IEventAccepter selectedEventAccepter = this.waitingEventAccepters.get(matchingEventAccepterIndexes.get(j - 1));
				int removeAt = matchingEventAccepterIndexes.get(j - 1);
				this.waitingEventAccepters.remove(removeAt);
				selectedEventAccepter.accept(eventOccurrence);
			}
		}
	}

	public IEventOccurrence getNextEvent() {
		// Get the next event from the event pool, using a get next event
		// strategy.

		// fUML12-35 Initial execution of an activity is not run to completion

		return ((GetNextEventStrategy) this.object.getLocus().getFactory().getStrategy("getNextEvent")).getNextEvent(this);
	}

	public void send(IEventOccurrence eventOccurrence) {
		// Add an event occurrence to the event pool and signal that a 
		// new event occurrence has arrived.
		this.eventPool.add(eventOccurrence);
		_send(new ArrivalSignal());
	}

	public void startBehavior(Class classifier, List<IParameterValue> inputs) {
		// Start the event dispatch loop for this object activation (if it has
		// not already been started).
		// If a classifier is given that is a type of the object of this object
		// activation and there is not already a classifier behavior invocation
		// for it,
		// then create a classifier behavior invocation for it.
		// Otherwise, create a classifier behavior invocation for each of the
		// types of the object of this object activation which has a classifier
		// behavior or which is a behavior itself
		// and for which there is not currently a classifier behavior invocation.
		// Start EventDispatchLoop

		// fUML12-35 Initial execution of an activity is not run to completion

		_startObjectBehavior();
		if (classifier == null) {
			Debug.println("[startBehavior] Starting behavior for all classifiers...");
			// *** Start all classifier behaviors concurrently. ***
			List<Class> types = ((Object_) this.object).types;
			for (Iterator<Class> i = types.iterator(); i.hasNext();) {
				Class type = i.next();
				if (type instanceof Behavior | type.getClassifierBehavior() != null) {
					this.startBehavior(type, new ArrayList<IParameterValue>());
				}
			}
		} else {
			Debug.println("[startBehavior] Starting behavior for " + classifier.getName() + "...");
			boolean notYetStarted = true;
			int i = 1;
			while (notYetStarted & i <= this.classifierBehaviorInvocations.size()) {
				notYetStarted = (this.classifierBehaviorInvocations.get(i - 1).getExecutedClassifier() != classifier);
				i = i + 1;
			}
			if (notYetStarted) {
				/*
				 * 1. Register an event accepter to denote the waiting of an InvocationEventoccurence that allows the classifier behavior to start
				 * 2. Place in the event pool an InvocationEventOccurrence. When consumed it will triggers the execution of the classifier behavior in an RTC step
				 * 3. Force the starting of the dispatch loop using the usual pattern of the ArrivalSignal
				 */
				// FIXME: This should be done in a Factory
				IClassifierBehaviorInvocationEventAccepter newInvocation = new ClassifierBehaviorInvocationEventAccepter();
				newInvocation.setObjectActivation(this);
				this.classifierBehaviorInvocations.add(newInvocation);
				newInvocation.invokeBehavior(classifier, inputs);
				InvocationEventOccurrence eventOccurrence = new InvocationEventOccurrence();
				eventOccurrence.execution = newInvocation.getExecution();
				this.eventPool.add(eventOccurrence);
				_send(new ArrivalSignal());
			}
		}
	}


	private EventDispatchLoopExecution dispatchLoopExecution;

	public void _startObjectBehavior() {
		// *** This should start the EventDispatchLoop ***
		if(this.dispatchLoopExecution == null){
			this.dispatchLoopExecution = new EventDispatchLoopExecution();
			this.dispatchLoopExecution.self = this;
		}
		this.dispatchLoopExecution.newSignalArrival();
	}

	public void notifyEventArrival(){
		this._send(new ArrivalSignal());
	}
	
	public void _send(ArrivalSignal signal) {
		// Signal the arrival of a new signal instance in the event pool.
		// *** This should send an ArrivalSignal to the EventDispatchLoop. ***
		this._startObjectBehavior();
	}

	public void setObject(IObject_ context) {
		this.object = context;
	}

	public IObject_ getObject() {
		return this.object;
	}

	public List<IClassifierBehaviorInvocationEventAccepter> getClassifierBehaviorInvocations() {
		return this.classifierBehaviorInvocations;
	}

	public List<IEventOccurrence> getEvents() {
		return this.eventPool;
	}

	@Override
	public List<IEventAccepter> getWaitingEventAccepters() {
		return this.waitingEventAccepters;
	}

}
