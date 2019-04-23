/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
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
 *  Jeremie Tatibouet (CEA LIST) - Based on Ed Seidewitz remarks
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.InvocationActions.ICS_EventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications.EventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ICallEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1.ChoiceStrategy;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IStateConfiguration;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IStateMachineEventAccepter;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.ITransitionActivation;

public class StateMachineEventAccepter extends EventAccepter implements IStateMachineEventAccepter {

	// The execution that actually made the event accepter registered
	// in the object activation. Note this is particularly useful to access the
	// the configured related to the state-machine that registered this event
	// accepter.
	public StateMachineExecution registrationContext;

	public StateMachineEventAccepter(StateMachineExecution execution) {
		this.registrationContext = execution;
	}

	@Override
	public void accept(IEventOccurrence eventOccurrence) {
		// When an event occurrence is accepted this marks the beginning of a new RTC
		// step for
		// the executed state-machine. The following set of actions takes place:
		// 1 - The event can be deferred if required
		// 2 - The event can trigger on to many transitions if it is not deferred
		//	2.1 - The list of transitions that can be fired using the given event
		//        occurrence is computed.
		//  2.2 - Transitions in the set of fireable transitions are fired **concurrently**
		//  2.3 - If the accepted event occurrence is a call event occurrence then there is a explicit
		//	      "return from call" which enables the caller to continue its execution. 
		// 3 - When the RTC step is about to complete a new event accepter for the state-machine
		//	   is registered at the waiting event accepter list handled by the object activation
		// Note that there always is a single event accepter for a state-machine. This differs from
		// fUML. Indeed, in the state machine context, the overall state machine configuration gets
		// analyzed.
		if (this.isDeferred(eventOccurrence)) {
			this.defer(eventOccurrence);
		} else {
			List<ITransitionActivation> fireableTransitionActivations = this.select(eventOccurrence);
			if (!fireableTransitionActivations.isEmpty()) {
				for (Iterator<ITransitionActivation> fireableTransitionsIterator = fireableTransitionActivations
						.iterator(); fireableTransitionsIterator.hasNext();) {
					fireableTransitionsIterator.next().fire(eventOccurrence);
				}
				ICallEventOccurrence callEventOccurrence = null;
				if(eventOccurrence instanceof ICS_EventOccurrence){
					IEventOccurrence wrappedEventOccurrence = ((ICS_EventOccurrence)eventOccurrence).getWrappedEventOccurrence();
					if(wrappedEventOccurrence instanceof ICallEventOccurrence){
						callEventOccurrence = (ICallEventOccurrence) wrappedEventOccurrence;
					}
				}else if(eventOccurrence instanceof ICallEventOccurrence){
					callEventOccurrence = (ICallEventOccurrence) eventOccurrence;
				}
				if(callEventOccurrence != null){
					callEventOccurrence.returnFromCall();
				}
			}
		}
		IObject_ context = this.registrationContext.context;
		if (context != null && context.getObjectActivation() != null) {
			context.register(new StateMachineEventAccepter(this.registrationContext));
		}
	}

	@Override
	public Boolean match(IEventOccurrence eventOccurrence) {
		// There are two cases in which the state machine event accepter can match
		// 1 - In the current state machine configuration the event can be deferred
		// 2 - In the current state machine configuration the current event can trigger
		// one or more transitions
		return this.isDeferred(eventOccurrence) | this.isTriggering(eventOccurrence);
	}

	public boolean isDeferred(IEventOccurrence eventOccurrence) {
		// Determine if the dispatched event occurrence is deferred in the
		// current state machine configuration. An event occurrence can only be deferred
		// if the following conditions are fulfilled:
		// 1 - One active state in the hierarchy declares the event types as being
		// deferred.
		// 2 - No transitions (ready to fire) with a higher priority than the deferring
		// state
		// could be found.
		// 3 - It does not exist any running doActivity having already registered an
		// accepter
		// for the given event occurrence
		// Note: a completion event cannot be deferred.
		boolean deferred = false;
		if(!(eventOccurrence instanceof CompletionEventOccurrence)){
			deferred = this._isDeferred(eventOccurrence, this.registrationContext.getConfiguration().getRoot());
		}
		if (deferred) {
			IObject_ context = this.registrationContext.context;
			if (context != null && context.getObjectActivation() != null) {
				int i = 1;
				while (deferred && i <= context.getObjectActivation().getWaitingEventAccepters().size()) {
					IEventAccepter currentEventAccepter = context.getObjectActivation().getWaitingEventAccepters()
							.get(i - 1);
					if (currentEventAccepter != this && currentEventAccepter instanceof DoActivityExecutionEventAccepter
							&& currentEventAccepter.match(eventOccurrence)) {
						deferred = false;
						;
					}
					i++;
				}
			}
		}
		return deferred;
	}

	protected boolean _isDeferred(IEventOccurrence eventOccurrence, IStateConfiguration stateConfiguration) {
		// Determine if the given state configuration is capable of deferring the given
		// event occurrence.
		int i = 0;
		boolean deferred = false;
		while (!deferred && i < stateConfiguration.getChildren().size()) {
			deferred = this._isDeferred(eventOccurrence, stateConfiguration.getChildren().get(i));
			i++;
		}
		if (!deferred && stateConfiguration.getVertexActivation() != null
				&& ((StateActivation) stateConfiguration.getVertexActivation()).canDefer(eventOccurrence)) {
			if (this._select(eventOccurrence, stateConfiguration).isEmpty()) {
				deferred = true;
			}
		}
		return deferred;
	}

	protected void defer(IEventOccurrence eventOccurrence) {
		// Defers the given event occurrence. A deferred event occurrence is registered
		// in
		// the deferred event pool. This latter refers to the deferred event as well as
		// to the
		// the deferring state.
		this._defer(eventOccurrence, this.registrationContext.getConfiguration().getRoot());
	}

	protected boolean _defer(IEventOccurrence eventOccurrence, IStateConfiguration stateConfiguration) {
		// Defers the given event occurrence in the context of the given state
		// configuration.
		int i = 0;
		boolean deferred = false;
		while (!deferred && i < stateConfiguration.getChildren().size()) {
			deferred = this._defer(eventOccurrence, stateConfiguration.getChildren().get(i));
			i++;
		}
		if (!deferred && stateConfiguration.getVertexActivation() != null
				&& ((StateActivation) stateConfiguration.getVertexActivation()).canDefer(eventOccurrence)) {
			((StateActivation) stateConfiguration.getVertexActivation()).defer(eventOccurrence);
			deferred = true;
		}
		return deferred;
	}

	public boolean isTriggering(IEventOccurrence eventOccurrence) {
		// Returns true when one or more transition are ready to be fired using this
		// event
		// occurrence; false otherwise.
		return !this.select(eventOccurrence).isEmpty();
	}

	protected List<ITransitionActivation> select(IEventOccurrence eventOccurrence) {
		// Find for the given configuration the set of transition that can fire.
		return this._select(eventOccurrence, this.registrationContext.getConfiguration().getRoot());
	}

	protected List<ITransitionActivation> _select(IEventOccurrence eventOccurrence,
			IStateConfiguration stateConfiguration) {
		// Find for the given state configuration all transition that can actually fire.
		// The set of transition only contains transitions with the highest priority. In
		// addition
		// no conflicting transitions are added to that set.
		List<ITransitionActivation> selectedTransitions = new ArrayList<ITransitionActivation>();
		for (int i = 0; i < stateConfiguration.getChildren().size(); i++) {
			selectedTransitions.addAll(this._select(eventOccurrence, stateConfiguration.getChildren().get(i)));
		}
		if (selectedTransitions.isEmpty() && stateConfiguration.getVertexActivation() != null) {
			for (int i = 0; i < stateConfiguration.getVertexActivation().getOutgoingTransitions().size(); i++) {
				ITransitionActivation transitionActivation = stateConfiguration.getVertexActivation()
						.getOutgoingTransitions().get(i);
				if (transitionActivation.canFireOn(eventOccurrence)) {
					selectedTransitions.add(transitionActivation);
				}
			}
			if (selectedTransitions.size() > 1) {
				ChoiceStrategy choiceStrategy = (ChoiceStrategy) this.registrationContext.locus.getFactory()
						.getStrategy("choice");
				ITransitionActivation electedTransition = selectedTransitions
						.get(choiceStrategy.choose(selectedTransitions.size()) - 1);
				selectedTransitions.clear();
				selectedTransitions.add(electedTransition);
			}
		}
		return selectedTransitions;
	}

}
