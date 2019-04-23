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
 *  Jeremie Tatibouet (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.CommonBehavior.EventTriggeredExecution;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.CommonBehavior.ISM_ObjectActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.ICompletionEventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IDeferredEventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IHistoryPseudostateActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IPseudostateActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IRegionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IStateActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.ITransitionActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IVertexActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.StateMetadata;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Vertex;

/**
 * This class captures the semantics of a state that can be either simple or composite. 
 */
public class StateActivation extends VertexActivation implements IStateActivation {
	
	// The visitors for the regions owned by this state
	protected List<IRegionActivation> regionActivation;
	
	// The visitors for the connection points (EntryPoint / ExitPoint) owned by this state 
	protected List<IPseudostateActivation> connectionPointActivation;
	
	// Boolean flag to know if the entry behavior was completed
	public boolean isEntryCompleted;
	
	// Boolean flag to know if the doActivity behavior was completed
	public boolean isDoActivityCompleted;
	
	// Boolean flag to know if the exit behavior was completed
	public boolean isExitCompleted; 
	
	// The context object in which is executed the doActivity
	// owned by the visited state
	public DoActivityContextObject doActivityContextObject;
	
	public void setEntryCompletion(boolean completed){
		this.isEntryCompleted = completed;
	}
	
	public void setExitCompletion(boolean completed){
		this.isExitCompleted = completed;
	}
	
	public void setDoActivityCompletion(boolean completed){
		this.isDoActivityCompleted = completed;
	}
	
	public boolean hasCompleted(){
		// A state can only be considered as being completed under the following circumstances
		// 1 - If the state is simple, both its entry and doActivity have finished their execution
		// 2 - If the state is composite, the same rules than used for the simple state, but additionally
		//     all the region of the state must have completed by reaching their final states
		// When the operation returns true then the generation of a completion event is allowed
		// for that particular state
		boolean stateCompleted = this.isEntryCompleted & this.isDoActivityCompleted;
		int i = 0;
		while(stateCompleted && i < this.regionActivation.size()){
			stateCompleted = stateCompleted && this.regionActivation.get(i).isCompleted(); 
			i = i + 1;
		}
		return stateCompleted;
	}
	
	public void complete(){
		// StateActivation completion consists in sending in the execution
		// context of the state-machine a completion event occurrence. This event is
		// placed in the pool before any other event
		ICompletionEventOccurrence completionEventOccurrence = new CompletionEventOccurrence();
		completionEventOccurrence.register(this);
	}
	
	public List<IPseudostateActivation> getConnectionPointActivation(){
		return this.connectionPointActivation;
	}

	public IPseudostateActivation getConnectionPointActivation(Vertex vertex){
		// Return the activation for the exit point or the entry point.
		IPseudostateActivation activation = null;
		int i = 0;
		while(i < this.connectionPointActivation.size() && activation==null){
			if(this.connectionPointActivation.get(i).getNode()==vertex){
				activation = this.connectionPointActivation.get(i);
			}
			i++;
		}
		return activation;
	}
	
	@Override
	public boolean isVisitorFor(NamedElement node) {
		// A state activation is the interpreter of a state if the specified node is
		// the state or if the state redefines the specified node (which is of course)
		// a state.
		// 
		// Note: as soon as vertex will be redefineable elements, this constraints will be
		// moved to the vertex activation class.
		boolean isVisitor = super.isVisitorFor(node);
		if(!isVisitor){
			State state = ((State)this.node).getRedefinedState();
			while(!isVisitor && state != null){
				if(state == node){
					isVisitor = true;
				}else{
					state = state.getRedefinedState();
				}
			}
		}
		return isVisitor; 
	}
	
	
	public IVertexActivation getVertexActivation(Vertex vertex){
		// Return the activation corresponding to the vertex. Search
		// is propagated through the owned region activation of the
		// state activation if this latter is composite. If no activation
		// is found null is returned.
		IVertexActivation vertexActivation = null;
		State state = (State) this.getNode();
		if(state.isComposite()){
			vertexActivation = this.getConnectionPointActivation(vertex);
			if(vertexActivation==null){
				int i = 0;
				while(i < this.regionActivation.size() && vertexActivation==null){
					vertexActivation = this.regionActivation.get(i).getVertexActivation(vertex);
					i++;
				}
			}
		}
		return vertexActivation;
	}
	
	public List<IRegionActivation> getRegionActivation() {
		return this.regionActivation;
	}

	public StateActivation(){
		super();
		this.isEntryCompleted = false;
		this.isDoActivityCompleted = false;
		this.regionActivation = new ArrayList<IRegionActivation>();
		this.connectionPointActivation = new ArrayList<IPseudostateActivation>();
	}
	
	public void activate(){
		// Instantiate visitors for all vertices owned by this region 
		State state = (State) this.getNode();
		if(state.isComposite()){
			IObject_ context = this.getExecutionContext();
			for(Pseudostate connectionPoint : state.getConnectionPoints()){
				IPseudostateActivation activation = (IPseudostateActivation)context.getLocus().getFactory().instantiateVisitor(connectionPoint);
				activation.setParent(this);
				activation.setNode(connectionPoint);
				this.connectionPointActivation.add(activation);
			}
			for(Region region: state.getRegions()){
				RegionActivation activation = (RegionActivation) context.getLocus().getFactory().instantiateVisitor(region);
				activation.setParent(this);
				activation.setNode(region);
				activation.activate();
				this.regionActivation.add(activation);
			}
		}
	}
	
	public void activateTransitions(){
		// Instantiate visitor for transitions owned by this region
		State state = (State) this.getNode();
		if(state.isComposite()){
			for(IRegionActivation activation : this.regionActivation){
				activation.activateTransitions();
			}
		}
	}
	
	public Behavior getEntry(){
		// Return the entry behavior of the state or one inherited
		// from a redefined state. If no entry can be found null is
		// returned.
		State state = (State) this.getNode();
		Behavior entry = state.getEntry();
		while(entry  == null && state.getRedefinedState() != null){
			state = state.getRedefinedState();
			entry = state.getEntry();
		}
		return entry;
	}
	
	public Behavior getExit(){
		// Return the exit behavior of the state or one inherited
		// from a redefined state. If no exit can be found null is
		// returned.
		State state = (State) this.getNode();
		Behavior exit = state.getExit();
		while(exit  == null && state.getRedefinedState() != null){
			state = state.getRedefinedState();
			exit = state.getExit();
		}
		return exit;
	}
	
	public Behavior getDoActivity(){
		// Return the doActivity behavior of the state or one inherited
		// from a redefined state. If no doActivity can be found null is
		// returned.
		State state = (State) this.getNode();
		Behavior doActivity = state.getDoActivity();
		while(doActivity == null && state.getRedefinedState() != null){
			state = state.getRedefinedState();
			doActivity = state.getDoActivity();
		}
		return doActivity;
	}
	
	public void tryExecuteEntry(IEventOccurrence eventOccurrence){
		// If an entry behavior is specified for that state then it is executed.
		// If no entry behavior is specified but the state redefines another state
		// and this latter provides an entry behavior then this behavior is executed
		// instead. The rule applies recursively.
		if(!this.isEntryCompleted){
			Behavior entry = this.getEntry(); 
			if(entry != null){
				IExecution execution = this.getExecutionFor(entry, eventOccurrence);
				if(execution!=null){
					execution.execute();
					this.isEntryCompleted = true;
				}
				// If state has completed then generate a completion event
				if(this.hasCompleted()){
					this.complete();
				}
			}
		}
	}
	
	public void tryInvokeDoActivity(IEventOccurrence eventOccurrence){
		// If an doActivity behavior is specified for that state then it is executed.
		// If no doActivity is specified but the state redefines another state which
		// provides a doActivity then this latter is executed instead. The rule applies
		// recursively.
		if(!this.isDoActivityCompleted){
			Behavior doActivity = this.getDoActivity();
			if(doActivity!=null){
				// Create, initialize and register to the locus the doActivityContextObject. 
				this.doActivityContextObject = new DoActivityContextObject();
				this.getExecutionLocus().add(this.doActivityContextObject);
				this.doActivityContextObject.initialize(this.getExecutionContext());
				this.doActivityContextObject.owner = this;
				// Extract data from triggering event occurrence if possible. Reuse event occurrence
				// embedded data extraction logic provided by EventTriggeredExecution.
				List<IParameterValue> inputs = null;
				IExecution doActivityExecution = this.getExecutionFor(doActivity, eventOccurrence);
				if(doActivityExecution instanceof EventTriggeredExecution){
					((EventTriggeredExecution)doActivityExecution).initialize();
					inputs = new ArrayList<IParameterValue>(((EventTriggeredExecution)doActivityExecution).wrappedExecution.getParameterValues());
				}
				// Start doActivity execution on its own thread of execution (i.e., this
				// a different thread of execution than the one used for the state machine).
				this.doActivityContextObject.startBehavior(doActivity, inputs);
			}
		}
	}
	
	public void tryExecuteExit(IEventOccurrence eventOccurrence){
		// Execute the exit behavior if any. If no exit behavior is
		// specified but the state redefines another state which provides an
		// exit behavior then this latter is executed instead. The rule applies
		// recursively.
		Behavior exit = this.getExit();
		if(exit != null){
			IExecution execution = this.getExecutionFor(exit, eventOccurrence);
			if(execution!=null){
				execution.execute();
			}
		}
		super.exit(null, eventOccurrence, null);
	}
	
	public void enterRegions(ITransitionActivation enteringTransition, IEventOccurrence eventOccurrence){
		// Regions can be entered either implicitly or explicitly. 
		// A region is typically entered implicitly when its activation is triggered
		// by a transition terminating on the edge of its containing state.
		// A region is typically entered explicitly when one of its contained
		// state is targeted by a transition coming from the outside.
		// *** Regions are entered concurrently ***
		List<Vertex> targetedVertices = new ArrayList<Vertex>();
		IVertexActivation sourceActivation = enteringTransition.getSourceActivation();
		if(sourceActivation instanceof ForkPseudostateActivation){
			Pseudostate fork = (Pseudostate)sourceActivation.getNode(); 
			for(int i = 0; i < fork.getOutgoings().size(); i++){
				targetedVertices.add(fork.getOutgoings().get(i).getTarget());
			}
		}else{
			IVertexActivation targetActivation = enteringTransition.getTargetActivation();
			if(targetActivation instanceof EntryPointPseudostateActivation){
				Pseudostate entryPoint = (Pseudostate)targetActivation.getNode();
				for(int i = 0; i < entryPoint.getOutgoings().size(); i++){
					targetedVertices.add(entryPoint.getOutgoings().get(i).getTarget());
				}
			}else{
				if(!(targetActivation instanceof IHistoryPseudostateActivation)){
					targetedVertices.add((Vertex)targetActivation.getNode());
				}
			}
		}		
		for(int i=0; i < this.regionActivation.size(); i++){
			IRegionActivation regionActivation = this.regionActivation.get(i);
			int j = 0;
			boolean found = false;
			while(j < targetedVertices.size() && !found){
				found = regionActivation.getVertexActivation(targetedVertices.get(j)) != null;
				j++;
			}
			if(!found){
				regionActivation.enter(enteringTransition, eventOccurrence);
			}
		}
	}
	
	@Override
	public boolean isEnterable(ITransitionActivation enteringTransition, boolean staticCheck) {
		// A state can only be entered if it is not part of the state-machine configuration
		// (i.e., the state is not currently active)
		return !((StateMachineExecution)this.getStateMachineExecution()).getConfiguration().isActive(this);
	}
	
	@Override
	public boolean canPropagateExecution(ITransitionActivation enteringTransition, IEventOccurrence eventOccurrence, IRegionActivation leastCommonAncestor) {
		// When a simple state is encountered then the propagation analysis is terminated. If
		// the visited state is composite then the analysis  is propagated to the region(s). All
		// regions for which the possibility to propagate the execution is asserted must return true.
		boolean propagate = true;
		if(!this.regionActivation.contains(leastCommonAncestor)){
			propagate = super.canPropagateExecution(enteringTransition, eventOccurrence, leastCommonAncestor);
		}
		if(propagate && this.regionActivation.size() > 0){
			int i = 0;
			while(propagate && i < this.regionActivation.size()){
				propagate = this.regionActivation.get(i).canPropagateExecution(eventOccurrence, enteringTransition);
				i++;
			}
		}
		return propagate;
	}
	
	public void enter(ITransitionActivation enteringTransition, IEventOccurrence eventOccurrence, IRegionActivation leastCommonAncestor) {
		if(this.status.equals(StateMetadata.IDLE)){
			// The state is entered via an explicit transition
			// The impact on the execution is that the parent state
			// of the current state is not active then it must be entered
			// the rule applies recursively
			super.enter(enteringTransition, eventOccurrence, leastCommonAncestor);
			// Initialization
			this.isEntryCompleted = this.getEntry()==null;
			this.isDoActivityCompleted = this.getDoActivity()==null;
			this.isExitCompleted = this.getExit()==null;
			// When the state is entered it is registered in the current
			// state-machine configuration
			StateMachineExecution smExecution = (StateMachineExecution)this.getStateMachineExecution();
			smExecution.getConfiguration().register(this);
			// If state has completed then generate a completion event*/
			if(this.hasCompleted()){
				this.complete();
			}else{
				// Execute the entry behavior if any
				this.tryExecuteEntry(eventOccurrence);
				// Invoke the doActivity if any
				this.tryInvokeDoActivity(eventOccurrence);
				// If the state is not completed, then try to start its owned regions.
				// A region is entered implicitly since the is not the 
				this.enterRegions(enteringTransition, eventOccurrence);
			}
		}
	}
	
	@Override
	public boolean isExitable(ITransitionActivation exitingTransition, boolean staticCheck) {
		// A state can only be be exited if it is part of the state-machine configuration
		// (i.e., the state is currently active)
		return !this.isEnterable(exitingTransition, staticCheck);
	}
	
	public void exit(ITransitionActivation exitingTransition, IEventOccurrence eventOccurrence, IRegionActivation leastCommonAncestor){
		// If we exit a composite state, this provokes the termination of all of its regions 
		if(!this.regionActivation.isEmpty()){
			for(IRegionActivation regionActivation : this.regionActivation){
				regionActivation.exit(exitingTransition, eventOccurrence);
			}
		}
		// If there is a doActivity currently executing then it is aborted
		if(!this.isDoActivityCompleted){
			this.doActivityContextObject.destroy();
			this.doActivityContextObject = null;
		}
		// If there is an exit behavior specified for the state it is executed
		if(!this.isExitCompleted){
			this.tryExecuteExit(eventOccurrence);
		}
		// Re-initialize the boolean flags
		this.isEntryCompleted = false;
		this.isDoActivityCompleted = false;
		this.isExitCompleted = false;
		// Change containing region history
		IRegionActivation containgRegionActivation = this.getOwningRegionActivation();
		containgRegionActivation.setHistory(this);
		// When the state is exited then it is removed from the state-machine configuration
		StateMachineExecution smExecution = (StateMachineExecution)this.getStateMachineExecution();
		smExecution.getConfiguration().unregister(this);
		// The state is exited by a transition that targets a state which is located within 
		// another region. This means parent state must also be exited.  
		super.exit(exitingTransition, eventOccurrence, leastCommonAncestor);
	}
	
	public List<ITransitionActivation> getFireableTransitions(IEventOccurrence eventOccurrence){
		// Return the set of transitions that can fire using the the given event occurrence
		List<ITransitionActivation> fireableTransitions = new ArrayList<ITransitionActivation>();
		for(int i=0; i < this.outgoingTransitionActivations.size(); i++){
			ITransitionActivation outgoingTransitionActivation = this.outgoingTransitionActivations.get(i);
			if(outgoingTransitionActivation.canFireOn(eventOccurrence)){
				fireableTransitions.add(outgoingTransitionActivation);
			}
		}
		return fireableTransitions;
	}
	
	public boolean canDefer(IEventOccurrence eventOccurrence){
		// Return true if current state activation is capable of deferring the given
		// event occurrence; false otherwise. Note that false is returned in case where
		// the deferring constraint is overridden by an outgoing transition
		// 
		// Note: for the moment the evaluation is done with the assumption that the
		// received event occurrence is a signal event occurrence. This will change
		// as soon as other kind of event (e.g. call event) will be supported in fUML.
		State state = (State) this.node;
		boolean deferred = eventOccurrence.matchAny(state.getDeferrableTriggers());
		while(!deferred && state.getRedefinedState() != null){
			state = state.getRedefinedState();
			deferred = eventOccurrence.matchAny(state.getDeferrableTriggers());
		}
		if(deferred){
			int i = 0;
			ITransitionActivation overridingTransitionActivation = null;
			while(overridingTransitionActivation == null && i < this.outgoingTransitionActivations.size()){
				ITransitionActivation currentTransitionActivation = this.outgoingTransitionActivations.get(i);
				if(currentTransitionActivation.canFireOn(eventOccurrence)){
					overridingTransitionActivation = currentTransitionActivation;
				}
				i++;
			}
			deferred = overridingTransitionActivation == null;
		}
		return deferred;
	}
	
	public void defer(IEventOccurrence eventOccurrence){
		// Postpone the time at which this event occurrence will be available at the event pool.
		// The given event occurrence is placed in the deferred event pool and will be released
		// only when the current state activation will leave the state-machine configuration.
		IDeferredEventOccurrence deferringEventOccurrence = new DeferredEventOccurrence();
		deferringEventOccurrence.setDeferredEventOccurrence(eventOccurrence);
		deferringEventOccurrence.register(this);
	}
	
	public void releaseDeferredEvents(){
		// If events have been deferred by that state then these latter return to the
		// regular event pool.
		IObject_ context = this.getExecutionContext();
		if(context.getObjectActivation() != null){
			((ISM_ObjectActivation)context.getObjectActivation()).releaseDeferredEvents(this); 
		}
	}
	
	public void terminate(){
		// A state gets terminated when the state-machine that contains it gets itself terminated.
		// If the state has an ongoing doActivity behavior then this latter is aborted. In addition,
		// the state is active then it is removed from the active state configuration.
		if(this.isActive()){
			if(!this.regionActivation.isEmpty()){
				for(int i = 0; i < this.regionActivation.size(); i++){
					this.regionActivation.get(i).terminate();
				}
				this.regionActivation.clear();
			}
			if(!this.isDoActivityCompleted){
				this.doActivityContextObject.destroy();
			}
			this.connectionPointActivation.clear();
		}
	}
}
