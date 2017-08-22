/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.profiling.Semantics.Actions.CompleteActions;

import org.eclipse.papyrus.moka.fuml.Semantics.Actions.CompleteActions.IAcceptEventActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.profiling.Semantics.Loci.SemanticVisitorProfiler;

public aspect AcceptEventActionActivationProfiler extends SemanticVisitorProfiler{
	
	pointcut accept(IAcceptEventActionActivation activation, IEventOccurrence eventOccurrence):
		target(activation) &&
		args(eventOccurrence) &&
		call(* IAcceptEventActionActivation.accept(IEventOccurrence));
	
	before(IAcceptEventActionActivation activation, IEventOccurrence eventOccurrence): accept(activation, eventOccurrence){
		this.fireNodeLeft(activation);
	}
}