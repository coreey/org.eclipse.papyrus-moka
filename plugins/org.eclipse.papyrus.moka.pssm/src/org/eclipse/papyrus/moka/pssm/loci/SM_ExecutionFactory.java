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
package org.eclipse.papyrus.moka.pssm.loci;

import org.eclipse.papyrus.moka.fuml.loci.ISemanticVisitor;
import org.eclipse.papyrus.moka.pscs.loci.CS_ExecutionFactory;
import org.eclipse.papyrus.moka.pssm.actions.SM_ReadSelfActionActivation;
import org.eclipse.papyrus.moka.pssm.statemachines.ChoicePseudostateActivation;
import org.eclipse.papyrus.moka.pssm.statemachines.DeepHistoryPseudostateActivation;
import org.eclipse.papyrus.moka.pssm.statemachines.EntryPointPseudostateActivation;
import org.eclipse.papyrus.moka.pssm.statemachines.ExitPointPseudostateActivation;
import org.eclipse.papyrus.moka.pssm.statemachines.ExternalTransitionActivation;
import org.eclipse.papyrus.moka.pssm.statemachines.FinalStateActivation;
import org.eclipse.papyrus.moka.pssm.statemachines.ForkPseudostateActivation;
import org.eclipse.papyrus.moka.pssm.statemachines.InitialPseudostateActivation;
import org.eclipse.papyrus.moka.pssm.statemachines.InternalTransitionActivation;
import org.eclipse.papyrus.moka.pssm.statemachines.JoinPseudostateActivation;
import org.eclipse.papyrus.moka.pssm.statemachines.JunctionPseudostateActivation;
import org.eclipse.papyrus.moka.pssm.statemachines.LocalTransitionActivation;
import org.eclipse.papyrus.moka.pssm.statemachines.RegionActivation;
import org.eclipse.papyrus.moka.pssm.statemachines.ShallowHistoryPseudostateActivation;
import org.eclipse.papyrus.moka.pssm.statemachines.StateActivation;
import org.eclipse.papyrus.moka.pssm.statemachines.StateMachineExecution;
import org.eclipse.papyrus.moka.pssm.statemachines.TerminatePseudostateActivation;
import org.eclipse.papyrus.moka.pssm.values.SM_OpaqueExpressionEvaluation;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.ReadSelfAction;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;

public class SM_ExecutionFactory extends CS_ExecutionFactory {
	
	public ISemanticVisitor instantiateVisitor(Element element) {
		// Return the semantic visitor corresponding to the given model element.
		// If no visitor can be created for this model element then null is 
		// returned.
		ISemanticVisitor visitor = null ;
		if(element instanceof StateMachine){
			visitor = new StateMachineExecution();
		}else if (element instanceof Pseudostate) {
			Pseudostate pseudostate = (Pseudostate) element;
			switch(pseudostate.getKind()){
				case INITIAL_LITERAL: visitor = new InitialPseudostateActivation(); break;
				case ENTRY_POINT_LITERAL: visitor = new EntryPointPseudostateActivation(); break;
				case EXIT_POINT_LITERAL: visitor = new ExitPointPseudostateActivation(); break;
				case CHOICE_LITERAL: visitor = new ChoicePseudostateActivation(); break;
				case FORK_LITERAL: visitor = new ForkPseudostateActivation(); break;
				case JOIN_LITERAL: visitor = new JoinPseudostateActivation(); break;
				case TERMINATE_LITERAL: visitor = new TerminatePseudostateActivation(); break;
				case DEEP_HISTORY_LITERAL: visitor = new DeepHistoryPseudostateActivation(); break;
				case SHALLOW_HISTORY_LITERAL: visitor = new ShallowHistoryPseudostateActivation(); break;
				case JUNCTION_LITERAL: visitor = new JunctionPseudostateActivation(); break;
			}
		}else if (element instanceof State) {
			if(element instanceof FinalState){
				visitor = new FinalStateActivation();
			}else{
				visitor = new StateActivation() ;
			}
		}else if (element instanceof Transition) {
			Transition transition = (Transition) element;
			switch(transition.getKind()){
				case EXTERNAL_LITERAL: visitor = new ExternalTransitionActivation(); break;
				case INTERNAL_LITERAL: visitor = new InternalTransitionActivation(); break;
				case LOCAL_LITERAL: visitor = new LocalTransitionActivation(); break;
			}
		}else if (element instanceof Region) {
			visitor = new RegionActivation();
		}else if(element instanceof OpaqueExpression) {
			visitor = new SM_OpaqueExpressionEvaluation();
		}else if(element instanceof ReadSelfAction){
			visitor = new SM_ReadSelfActionActivation();
		}else {
			visitor = super.instantiateVisitor(element);
		}
		return visitor;
	}
}
