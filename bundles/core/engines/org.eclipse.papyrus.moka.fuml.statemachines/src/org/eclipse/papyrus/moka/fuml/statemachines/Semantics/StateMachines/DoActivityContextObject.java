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

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IObjectActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Object_;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.CommonBehavior.ISM_ObjectActivation;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IDeferredEventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IDoActivityContextObject;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IStateActivation;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.StructuralFeature;

public class DoActivityContextObject extends Object_ implements IDoActivityContextObject{
	
	// The state activation that initiated the execution of the
	// do activity behavior
	public IStateActivation owner;
	
	// The context of the state-machine that lead to the invocation of the
	// doActivity behavior.
	public IObject_ context;
	
	public IObject_ getContext(){
		return this.context;
	}
	
	public void initialize(IObject_ context){
		// Context object of this DoActivityContextObject is the context
		// of the state machine which has invoked the doActivity.
		if(context!=null){
 			this.context = context;
 		}
	}
	
 	@Override
	public void startBehavior(Class classifier, List<IParameterValue> inputs) {
		// Starts the behavior of a DoActivityContextObject. It behaves the
		// same than in fUML except that for object is associated to a specific
		// type of object activation: DoActivityContextObjectActivation
		if(this.objectActivation == null){
			this.objectActivation = new DoActivityContextObjectActivation();
			this.objectActivation.setObject(this);
		}
		this.objectActivation.startBehavior(classifier, inputs);
	}
	
	@Override
	public void register(IEventAccepter accepter) {
		// When the executing doActivity registers an accepter it searches through the deferred event
		// pool of the object activation associated to the state-machine context.
		// 1. If the accepter being registered matches one of the deferred events then this event is
		//    transferred into the event pool of the doActivity object activation. This implies the
		//    event will be dispatched in a RTC step performed by the doActivity object activation. 
		// 2. If the accepter being registered does not match one of the deferred events then this latter
		//    is wrapped in another accepter which is registered by the state machine context object activation.
		//    This is realized in order to guarantee that the doActivity will have a chance to match an event
		//    received by the state-machine context object.
		super.register(accepter);
		ISM_ObjectActivation contextObjectActivation = (ISM_ObjectActivation) this.context.getObjectActivation();
		int i = 1;
		IDeferredEventOccurrence matchedDeferredEvent = null; 
		while(matchedDeferredEvent == null && i <= contextObjectActivation.getDeferredEvents().size()){
			IDeferredEventOccurrence eventOccurrence = contextObjectActivation.getDeferredEvents().get(i-1);
			if(this.owner == eventOccurrence.getConstrainingStateActivation()  && accepter.match(eventOccurrence.getDeferredEventOccurrence())){
				matchedDeferredEvent = eventOccurrence;
			}
			i++;
		}
		if(matchedDeferredEvent == null){
			DoActivityExecutionEventAccepter encapsulatingAccepter = new DoActivityExecutionEventAccepter();
			encapsulatingAccepter.encapsulatedAccepter = accepter;
			encapsulatingAccepter.context = this;
			this.context.register(encapsulatingAccepter);
		}else{
			contextObjectActivation.getDeferredEvents().remove(matchedDeferredEvent);
			this.objectActivation.getEvents().add(matchedDeferredEvent.getDeferredEventOccurrence());
			this.objectActivation.notifyEventArrival();
		}
	}
	
	@Override
	public IFeatureValue getFeatureValue(StructuralFeature feature) {
		// Delegate read of a particular feature to the state-machine context
		IFeatureValue featureValue = null;
		if(this.context!=null){
			featureValue = this.context.getFeatureValue(feature);
		}
		return featureValue;
	}
	
	@Override
	public void setFeatureValue(StructuralFeature feature, List<IValue> values, Integer position) {
		// Delegate write of particular feature to the state-machine context
		if(this.context!=null){
			this.context.setFeatureValue(feature, values, position);
		}
	}
	
	@Override
	public IExecution dispatch(Operation operation) {
		// Delegate operation call to the state-machine context
		IExecution execution = null;
		if(this.context!=null){
			execution = this.context.dispatch(operation);
		}
		return execution;
	}
	
	@Override
	public void send(IEventOccurrence eventOccurrence) {
		// Delegate the reception of a signal to the state-machine context
		if(this.context!=null){
			this.context.send(eventOccurrence);
		}
	}
	
	@Override
	public void destroy() {
		// When destroyed in addition to the usual behavior, the do activity context object
		// has to remove the encapsulating accepters it may have registered.
		for(int i=0; i < this.objectActivation.getWaitingEventAccepters().size(); i++){
			this.unregisterFromContext(this.objectActivation.getWaitingEventAccepters().get(i));
		}
		super.destroy();
	}
	
	protected void unregisterFromContext(IEventAccepter encapsulatedAccepter){
		// Unregister in the context of this do activity context the encapsulating
		// event accepter.
		IObjectActivation contextObjectActivation = this.context.getObjectActivation();
		if(contextObjectActivation!=null){
			DoActivityExecutionEventAccepter encapsulatingAccepter = null;
			int i = 0;
			while(encapsulatingAccepter==null && i < contextObjectActivation.getWaitingEventAccepters().size()){
				IEventAccepter currentAccepter = contextObjectActivation.getWaitingEventAccepters().get(i);
				if(currentAccepter instanceof DoActivityExecutionEventAccepter
						&& ((DoActivityExecutionEventAccepter)currentAccepter).encapsulatedAccepter==encapsulatedAccepter){
					encapsulatingAccepter = (DoActivityExecutionEventAccepter) currentAccepter;
				}
				i++;
			}
			if(encapsulatingAccepter!=null){
				contextObjectActivation.unregister(encapsulatingAccepter);
			}
		}
	}
}
