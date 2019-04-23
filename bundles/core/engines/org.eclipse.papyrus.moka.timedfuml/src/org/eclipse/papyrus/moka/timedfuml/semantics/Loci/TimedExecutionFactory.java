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
 * 	Sahar Guermazi
 *  CEA LIST Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.moka.timedfuml.semantics.Loci;

import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Loci.SM_ExecutionFactory;
import org.eclipse.papyrus.moka.timedfuml.semantics.Timed_OpaqueActionActivation;
import org.eclipse.papyrus.moka.timedfuml.semantics.Timed_SendSignalActionActivation;
import org.eclipse.papyrus.moka.timedfuml.semantics.Actions.CompleteActions.TimedAcceptEventActionActivation;
import org.eclipse.papyrus.moka.timedfuml.semantics.StateMachines.TimedStateMachineExecution;
import org.eclipse.papyrus.moka.timedfuml.utils.DESchedulerUtils;
import org.eclipse.uml2.uml.AcceptCallAction;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.StateMachine;

public class TimedExecutionFactory extends SM_ExecutionFactory {

	@Override
	public ISemanticVisitor instantiateVisitor(Element element) {
		// Extends fUML semantics in the sense that newly introduced
		// semantic visitors are instantiated instead of fUML visitors
		ISemanticVisitor visitor = null;
		if (element instanceof AcceptEventAction 
				&& !(element instanceof AcceptCallAction)
				&& DESchedulerUtils.isTimeTriggered(((AcceptEventAction)element).getTriggers())) {
			visitor = new TimedAcceptEventActionActivation();
		} else if (element instanceof OpaqueAction) {
			visitor = new Timed_OpaqueActionActivation();
		} else if (element instanceof SendSignalAction) {
			visitor = new Timed_SendSignalActionActivation();
		} else if(element instanceof StateMachine){
			visitor = new TimedStateMachineExecution();
		} else {
			visitor = super.instantiateVisitor(element);
		}
		return visitor;
	}

}
