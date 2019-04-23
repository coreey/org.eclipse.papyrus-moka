/*****************************************************************************
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
 *****************************************************************************/
package org.eclipse.papyrus.moka.debug.engine;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.CompleteActions.IAcceptEventActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IStateMachineSemanticVisitor;
import org.eclipse.papyrus.moka.service.AbstractMokaService;
import org.eclipse.papyrus.moka.service.IMokaExecutionListener;

public class DebugService extends AbstractMokaService implements IMokaExecutionListener {

	// Debug target attached to the debug service
	protected IMokaDebugTarget debugTarget;

	@Override
	public void init(ILaunch launcher, EObject modelElement) {
		this.debugTarget = (IMokaDebugTarget) launcher.getDebugTarget();
	}

	@Override
	public void nodeVisited(ISemanticVisitor nodeVisitor) {
		// If an activity or a state machine semantic visitor shall
		// be suspended then the execution thread of the object executing
		// the node is suspended.
		// Note: An accept event action is never suspended when it fires.
		// Instead it is suspended when an event is accepted by this action
		// from the event pool.
		if (!this.debugTarget.isDisconnected()) {
			if (nodeVisitor instanceof IActivityNodeActivation
					|| nodeVisitor instanceof IActivityEdgeInstance
					|| nodeVisitor instanceof IStateMachineSemanticVisitor) {
				IObject_ object = null;
				if(nodeVisitor instanceof IStateMachineSemanticVisitor) {
					object = ((IStateMachineSemanticVisitor)nodeVisitor).getExecutionContext();
				}else {
					if (nodeVisitor instanceof IActivityNodeActivation
							&& !(nodeVisitor instanceof IAcceptEventActionActivation)
							&& (((IActivityNodeActivation) nodeVisitor).getGroup() != null)) {
							object = ((IActivityNodeActivation) nodeVisitor).getExecutionContext();
					} else if (nodeVisitor instanceof IActivityEdgeInstance
							&& ((IActivityEdgeInstance) nodeVisitor).getSource().getGroup() != null) {
							object = ((IActivityEdgeInstance) nodeVisitor).getSource().getExecutionContext();
					}
				}
				if (object != null) {
					this.debugTarget.update(object, nodeVisitor);
					if (this.debugTarget.isSuspensionRequired(object, nodeVisitor)) {
						this.debugTarget.suspend(object, nodeVisitor);
					}
				}
			}
		}
	}

	@Override
	public void nodeLeft(ISemanticVisitor nodeVisitor) {
		// If an accept event action is left this means it has accepted an event
		// from the event pool. This accept event action is therefore suspended for
		// debug which provides the designer to observe which event triggered the action.
		if (!this.debugTarget.isDisconnected()) {
			IObject_ object = null;
			if(nodeVisitor instanceof IAcceptEventActionActivation
					&& ((IAcceptEventActionActivation)nodeVisitor).getGroup() != null) {
				object = ((IAcceptEventActionActivation)nodeVisitor).getExecutionContext();
			}
			if(object != null) {
				this.debugTarget.update(object, nodeVisitor);
				if (this.debugTarget.isSuspensionRequired(object, nodeVisitor)) {
					this.debugTarget.suspend(object, nodeVisitor);
				}
			}
		}
	}

	@Override
	public void valueCreated(IValue value) {
		// When a new fUML value is instantiated within the fUML execution context
		// this value is registered by the debug target as being a logical thread under
		// the following conditions
		// 1 - The value is instance of a Class
		// 2 - The instantiated class is specified as being active
		// 3 - There is no thread already registered for this object within the debug target
		if (!this.debugTarget.isDisconnected()) {
			if (value instanceof IObject_) {
				IObject_ object = (IObject_) value;
				if(this.debugTarget.isNewThread(object)) {
					if(object instanceof IExecution
							&& ((IExecution)object).getContext() == object) {
						this.debugTarget.registerThread(object);
					}else {
						if(DebugServiceHelper.INSTANCE.isActive(object)) {
							this.debugTarget.registerThread(object);
						}
					}
				}
			}
		}
	}

	@Override
	public void valueDestroyed(IValue value) {
		// When a fUML value is destroyed within the fUML context, a thread known
		// by the debug target might be also be terminated. Such situation occurs
		// under the following conditions:
		// 1 - The destroyed value is an instance of for an active class
		// 2 - This instance matches a thread that is known by the debug target
		if (!this.debugTarget.isDisconnected()) {
			if (value instanceof IObject_) {
				IObject_ object = (IObject_) value;
				if (!this.debugTarget.isNewThread(object)) {
					this.debugTarget.unregisterThread(object);
				}
			}
		}
	}
	
	@Override
	public void dispose() {
		// When disposed the debug service shall indicate to the debug target that
		// it is terminated. Termination of the debug target makes sure that registered
		// thread are destroyed.
		if(this.debugTarget!=null && !this.debugTarget.isTerminated()){
			try {
				this.debugTarget.terminate();
			} catch (DebugException e) {
				e.printStackTrace();
			}
			this.debugTarget = null;
		}
	}
}
