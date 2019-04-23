/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
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

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IClassifierBehaviorInvocationEventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IInvocationEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications.ArrivalSignal;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications.ClassifierBehaviorInvocationEventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications.InvocationEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications.ObjectActivation;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;

public class DoActivityContextObjectActivation extends ObjectActivation {

	@Override
	public void dispatchNextEvent() {
		// The dispatching behaves exactly the same at it was specified in fUML.
		// In addition to this behavior the dispatch sequence of an object activation
		// for a DoActivityContextObject has the capacity to notify the state having
		// triggered if the executed doActivity has completed. The completion of a
		// do activity is determined based on the absence of any registered event
		// accepter after the current step.
		super.dispatchNextEvent();
		if(this.waitingEventAccepters.size() == 0){
			DoActivityContextObject doActivityObject = (DoActivityContextObject)this.object;
			if(doActivityObject.owner!=null){
				doActivityObject.owner.setDoActivityCompletion(true);
				if(doActivityObject.owner.hasCompleted()){
					doActivityObject.owner.complete();
				}
			}
		}
	}
	
	@Override
	public void startBehavior(Class classifier, List<IParameterValue> inputs) {
		// The expected classifier is the doActivity behavior. The doActivity
		// behavior is executed as if it was the classifier of a class typing
		// the doActivity context object. It only exists one doActivity executed
		// as a classifier behavior for a DoActivityContextObject.
		if(classifier != null 
			&& classifier instanceof Behavior
			&& this.classifierBehaviorInvocations.isEmpty()){
			IClassifierBehaviorInvocationEventAccepter newInvocation = new ClassifierBehaviorInvocationEventAccepter();
			newInvocation.setObjectActivation(this);
			newInvocation.setClassifier(classifier);
			IExecution doActivityExecution = this.object.getLocus().getFactory().createExecution((Behavior)classifier, this.object); 
			if(inputs != null){
				for(int i = 0; i < inputs.size(); i++){
					doActivityExecution.setParameterValue(inputs.get(i));
				}
			}
			newInvocation.setExecution(doActivityExecution);
			this.classifierBehaviorInvocations.add(newInvocation);
			this.register(newInvocation);
			IInvocationEventOccurrence invocationEventOccurrence = new InvocationEventOccurrence();
			invocationEventOccurrence.setExecution(newInvocation.getExecution());
			this.eventPool.add(invocationEventOccurrence);
			this._send(new ArrivalSignal());
		}
	}
}