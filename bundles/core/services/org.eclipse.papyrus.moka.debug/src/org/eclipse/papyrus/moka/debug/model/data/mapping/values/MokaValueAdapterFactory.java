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
package org.eclipse.papyrus.moka.debug.model.data.mapping.values;

import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.InvocationActions.ICS_EventOccurrence;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_InteractionPoint;
import org.eclipse.papyrus.moka.debug.engine.MokaDebugTarget;
import org.eclipse.papyrus.moka.fuml.Profiling.ITriggeredVisitorWrapper;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.CompleteActions.IAcceptEventActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IForkedToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IObjectNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IObjectToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IPrimitiveValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IStructuredValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ICallEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ISignalEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.ICompletionEventOccurrence;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.ITransitionActivation;
import org.eclipse.papyrus.moka.timedfuml.interfaces.semantics.CommonBehaviors.ITimedEventOccurrence;

public class MokaValueAdapterFactory {

	protected static MokaValueAdapterFactory INSTANCE;

	private MokaValueAdapterFactory() {
	}

	public static MokaValueAdapterFactory getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MokaValueAdapterFactory();
		}
		return INSTANCE;
	}

	public MokaValueAdapter<?> instantiate(Object value, MokaDebugTarget debugTarget) {
		MokaValueAdapter<?> adapter = null;
		if (value != null) {
			if (value instanceof IEventOccurrence) {
				if(value instanceof ICS_EventOccurrence) {
					adapter = new CS_EventOccurrenceValueAdapter(debugTarget, (ICS_EventOccurrence) value);
				} else if(value instanceof ITimedEventOccurrence) {
					adapter = new TimeEventOccurrenceValueAdapter(debugTarget, (ITimedEventOccurrence) value);
				} else if(value instanceof ISignalEventOccurrence) {
					adapter = new SignalEventOccurrenceValueAdapter(debugTarget, (ISignalEventOccurrence) value);
				} else if(value instanceof ICallEventOccurrence) {
					adapter = new CallEventOccurrenceValueAdapter(debugTarget, (ICallEventOccurrence) value);
				} else if(value instanceof ICompletionEventOccurrence) {
					adapter = new CompletionEventOccurrenceValueAdapter(debugTarget, (ICompletionEventOccurrence) value);
				}
			} else if (value instanceof IToken) {
				if (value instanceof IObjectToken) {
					adapter = new ObjectTokenValueAdapter(debugTarget, (IObjectToken) value);
				} else if (value instanceof IForkedToken) {
					adapter = this.instantiate(((IForkedToken) value).getBaseToken(), debugTarget);
				} else {
					adapter = new TokenValueAdapter(debugTarget, (IToken) value);
				}
			} else if (value instanceof IValue) {
				if (value instanceof IReference) {
					if(value instanceof ICS_InteractionPoint) {
						adapter = new CS_InteractionPointValueAdapter(debugTarget, (ICS_InteractionPoint )value);
					}else {
						adapter = new ReferenceValueAdapter(debugTarget, (IReference) value);
					}
				} else if (value instanceof IObject_) {
					adapter = new ObjectValueAdapter(debugTarget, (IObject_) value);
				} else if (value instanceof IStructuredValue) {
					adapter = new StructuredValueAdapter(debugTarget, (IStructuredValue) value);
				} else if (value instanceof IPrimitiveValue) {
					adapter = new PrimitiveValueAdapter(debugTarget, (IPrimitiveValue) value);
				}
			} else if (value instanceof ISemanticVisitor) {
				if (value instanceof IActivityNodeActivation) {
					if(value instanceof IAcceptEventActionActivation) {
						adapter = new TriggeredVisitorValueAdapter(debugTarget, (ITriggeredVisitorWrapper) value);
					}else if(value instanceof IActionActivation) {
						adapter = new ActionActivationValueAdapter<IActionActivation>(debugTarget, (IActionActivation) value);
					} else if(value instanceof IObjectNodeActivation) {
						adapter = new ObjectNodeActivationValueAdapter(debugTarget, (IObjectNodeActivation)value);
					}
				}else if (value instanceof IActivityEdgeInstance){
					adapter = new ActivityEdgeInstanceValueAdapter(debugTarget, (IActivityEdgeInstance)value);
				} else if (value instanceof ITransitionActivation) {
					adapter = new TriggeredVisitorValueAdapter(debugTarget, (ITriggeredVisitorWrapper)value);
				}
			}
		}
		if (adapter == null) {
			adapter = new DefaultValueAdapter(debugTarget, value);
		}
		return adapter;
	}
}
