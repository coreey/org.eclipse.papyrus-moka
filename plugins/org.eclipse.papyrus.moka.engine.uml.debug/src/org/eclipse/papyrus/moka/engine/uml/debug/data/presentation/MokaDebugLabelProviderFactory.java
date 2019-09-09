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
package org.eclipse.papyrus.moka.engine.uml.debug.data.presentation;

import org.eclipse.debug.core.DebugException;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.moka.engine.uml.debug.data.values.CS_EventOccurrenceValueAdapter;
import org.eclipse.papyrus.moka.engine.uml.debug.data.values.CallEventOccurrenceValueAdapter;
import org.eclipse.papyrus.moka.engine.uml.debug.data.values.CompletionEventOccurrenceValueAdapter;
import org.eclipse.papyrus.moka.engine.uml.debug.data.values.SignalEventOccurrenceValueAdapter;
import org.eclipse.papyrus.moka.engine.uml.debug.data.values.TimeEventOccurrenceValueAdapter;
import org.eclipse.papyrus.moka.engine.uml.debug.data.variables.CS_InteractionPointVariableAdapter;
import org.eclipse.papyrus.moka.engine.uml.debug.data.variables.EventOccurrenceVariableAdapter;
import org.eclipse.papyrus.moka.engine.uml.debug.data.variables.EventPoolVariableAdapter;
import org.eclipse.papyrus.moka.engine.uml.debug.data.variables.ExecutionContextVariableAdapter;
import org.eclipse.papyrus.moka.engine.uml.debug.data.variables.FeatureValueVariableAdapter;
import org.eclipse.papyrus.moka.engine.uml.debug.data.variables.ItemVariableAdapter;
import org.eclipse.papyrus.moka.engine.uml.debug.data.variables.ObjectNodeActivationVariableAdapter;
import org.eclipse.papyrus.moka.engine.uml.debug.data.variables.ParameterValueVariableAdapter;
import org.eclipse.papyrus.moka.engine.uml.debug.data.variables.SuspensionPointVariableAdapter;
import org.eclipse.papyrus.moka.engine.uml.debug.data.variables.TokensVariableAdapter;
import org.eclipse.papyrus.moka.engine.uml.debug.data.variables.UMLVariableAdapter;

public class MokaDebugLabelProviderFactory {

	private static MokaDebugLabelProviderFactory INSTANCE;

	private MokaDebugLabelProviderFactory() {

	}

	public static MokaDebugLabelProviderFactory getInstance(){
		if(INSTANCE == null){
			INSTANCE = new MokaDebugLabelProviderFactory();
		}
		return INSTANCE;
	}

	public ILabelProvider instantiate(UMLVariableAdapter<?> variable) {
		ILabelProvider provider = null; 
		if(variable instanceof CS_InteractionPointVariableAdapter) {
			provider = new CS_InteractionPointVariableLabelProvider();
		}else if(variable instanceof ExecutionContextVariableAdapter){
			provider = new ExecutionContextVariableLabelProvider();
		}else if(variable instanceof SuspensionPointVariableAdapter){
			provider = new SuspensionPointVariableLabelProvider();
		}else if(variable instanceof EventPoolVariableAdapter){
			provider = new EventPoolVariableLabelProvider();
		}else if(variable instanceof FeatureValueVariableAdapter){
			provider = new FeatureValueVariableLabelProvider();
		}else if(variable instanceof ItemVariableAdapter){
			provider = new ItemVariableLabelProvider();
		}else if(variable instanceof TokensVariableAdapter){
			provider = new TokensVariableLabelProvider();
		}else if(variable instanceof EventOccurrenceVariableAdapter) {
			try {
				if(((EventOccurrenceVariableAdapter)variable).getValue() instanceof CS_EventOccurrenceValueAdapter) {
					provider = new CS_EventOccurrenceVariableLabelProvider();
				} else if(((EventOccurrenceVariableAdapter)variable).getValue() instanceof TimeEventOccurrenceValueAdapter) {
					provider = new TimeEventOccurrenceVariableLabelProvider();
				}else if(((EventOccurrenceVariableAdapter)variable).getValue() instanceof SignalEventOccurrenceValueAdapter) {
					provider = new SignalEventOccurrenceVariableLabelProvider();
				} else if(((EventOccurrenceVariableAdapter)variable).getValue() instanceof CallEventOccurrenceValueAdapter) {
					provider = new CallEventOccurrenceVariableLabelProvider();
				} else if(((EventOccurrenceVariableAdapter)variable).getValue() instanceof CompletionEventOccurrenceValueAdapter) {
					provider = new CompletionEventOccurrenceVariableLabelProvider();
				}
			} catch (DebugException e) {
				e.printStackTrace();
			}
		} else if (variable instanceof ParameterValueVariableAdapter) {
			provider = new ParameterValueVariableLabelProvider();
		} else if(variable instanceof ObjectNodeActivationVariableAdapter) {
			provider = new ObjectNodeActivationVariableLabelProvider();
		}
		return provider;
	}

}
