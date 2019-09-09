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
package org.eclipse.papyrus.moka.engine.uml.debug.data.values;

import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.papyrus.moka.engine.uml.time.interfaces.ITimedEventOccurrence;
import org.eclipse.papyrus.moka.fuml.actions.IAcceptEventActionActivation;
import org.eclipse.papyrus.moka.fuml.actions.IActionActivation;
import org.eclipse.papyrus.moka.fuml.activities.IActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.activities.IActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.activities.IForkedToken;
import org.eclipse.papyrus.moka.fuml.activities.IObjectNodeActivation;
import org.eclipse.papyrus.moka.fuml.activities.IObjectToken;
import org.eclipse.papyrus.moka.fuml.activities.IToken;
import org.eclipse.papyrus.moka.fuml.commonbehavior.ICallEventOccurrence;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.commonbehavior.ISignalEventOccurrence;
import org.eclipse.papyrus.moka.fuml.loci.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.loci.additions.ITriggeredVisitorWrapper;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IPrimitiveValue;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IStructuredValue;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IValue;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IObject_;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IReference;
import org.eclipse.papyrus.moka.pscs.commonbehavior.ICS_EventOccurrence;
import org.eclipse.papyrus.moka.pscs.structuredclassifiers.ICS_InteractionPoint;
import org.eclipse.papyrus.moka.pssm.statemachines.ICompletionEventOccurrence;
import org.eclipse.papyrus.moka.pssm.statemachines.ITransitionActivation;

public class UMLValueAdapterFactory {

	protected static UMLValueAdapterFactory factory;

	private UMLValueAdapterFactory() {
	}

	public static UMLValueAdapterFactory getInstance() {
		if (factory == null) {
			factory = new UMLValueAdapterFactory();
		}
		return factory;
	}

	public UMLValueAdapter<?> instantiate(Object value, IDebugTarget target) {
		UMLValueAdapter<?> adapter = null;
		if (value != null) {
			if (value instanceof IEventOccurrence) {
				if(value instanceof ICS_EventOccurrence) {
					adapter = new CS_EventOccurrenceValueAdapter(target, (ICS_EventOccurrence) value);
				} else if(value instanceof ITimedEventOccurrence) {
					adapter = new TimeEventOccurrenceValueAdapter(target, (ITimedEventOccurrence) value);
				} else if(value instanceof ISignalEventOccurrence) {
					adapter = new SignalEventOccurrenceValueAdapter(target, (ISignalEventOccurrence) value);
				} else if(value instanceof ICallEventOccurrence) {
					adapter = new CallEventOccurrenceValueAdapter(target, (ICallEventOccurrence) value);
				} else if(value instanceof ICompletionEventOccurrence) {
					adapter = new CompletionEventOccurrenceValueAdapter(target, (ICompletionEventOccurrence) value);
				}
			} else if (value instanceof IToken) {
				if (value instanceof IObjectToken) {
					adapter = new ObjectTokenValueAdapter(target, (IObjectToken) value);
				} else if (value instanceof IForkedToken) {
					adapter = this.instantiate(((IForkedToken) value).getBaseToken(), target);
				} else {
					adapter = new TokenValueAdapter(target, (IToken) value);
				}
			} else if (value instanceof IValue) {
				if (value instanceof IReference) {
					if(value instanceof ICS_InteractionPoint) {
						adapter = new CS_InteractionPointValueAdapter(target, (ICS_InteractionPoint )value);
					}else {
						adapter = new ReferenceValueAdapter(target, (IReference) value);
					}
				} else if (value instanceof IObject_) {
					adapter = new ObjectValueAdapter(target, (IObject_) value);
				} else if (value instanceof IStructuredValue) {
					adapter = new StructuredValueAdapter(target, (IStructuredValue) value);
				} else if (value instanceof IPrimitiveValue) {
					adapter = new PrimitiveValueAdapter(target, (IPrimitiveValue) value);
				}
			} else if (value instanceof ISemanticVisitor) {
				if (value instanceof IActivityNodeActivation) {
					if(value instanceof IAcceptEventActionActivation) {
						adapter = new TriggeredVisitorValueAdapter(target, (ITriggeredVisitorWrapper) value);
					}else if(value instanceof IActionActivation) {
						adapter = new ActionActivationValueAdapter<IActionActivation>(target, (IActionActivation) value);
					} else if(value instanceof IObjectNodeActivation) {
						adapter = new ObjectNodeActivationValueAdapter(target, (IObjectNodeActivation)value);
					}
				}else if (value instanceof IActivityEdgeInstance){
					adapter = new ActivityEdgeInstanceValueAdapter(target, (IActivityEdgeInstance)value);
				} else if (value instanceof ITransitionActivation) {
					adapter = new TriggeredVisitorValueAdapter(target, (ITriggeredVisitorWrapper)value);
				}
			}
		}
		if (adapter == null) {
			adapter = new DefaultValueAdapter(target, value);
		}
		return adapter;
	}
}
