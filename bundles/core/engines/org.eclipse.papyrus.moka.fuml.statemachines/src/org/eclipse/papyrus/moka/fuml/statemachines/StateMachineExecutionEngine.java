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
package org.eclipse.papyrus.moka.fuml.statemachines;

import org.eclipse.papyrus.moka.composites.CompositeStructuresExecutionEngine;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CommonBehaviors.Communications.CS_DispatchOperationOfInterfaceStrategy;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CommonBehaviors.Communications.CS_NameBased_StructuralFeatureOfInterfaceAccessStrategy;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.InvocationActions.CS_DefaultRequestPropagationStrategy;
import org.eclipse.papyrus.moka.composites.Semantics.impl.Loci.LociL3.CS_Executor;
import org.eclipse.papyrus.moka.composites.extensions.Semantics.CompositeStructures.CS_NotNormativeDefaultConstructStrategy;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions.DefaultCreateObjectActionStrategy;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions.DefaultGetAssociationStrategy;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications.FIFOGetNextEventStrategy;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1.FirstChoiceStrategy;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Loci.SM_ExecutionFactory;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Loci.SM_Locus;

public class StateMachineExecutionEngine extends CompositeStructuresExecutionEngine{

	@Override
	public ILocus initializeLocus() {
		ILocus locus = new SM_Locus();
		locus.setExecutor(new CS_Executor());
		locus.setFactory(new SM_ExecutionFactory());
		return locus;
	}

	@Override
	protected void registerSemanticStrategies(ILocus locus) {
		locus.getFactory().setStrategy(new FirstChoiceStrategy());
		locus.getFactory().setStrategy(new FIFOGetNextEventStrategy());
		locus.getFactory().setStrategy(new CS_DispatchOperationOfInterfaceStrategy());
		locus.getFactory().setStrategy(new CS_NameBased_StructuralFeatureOfInterfaceAccessStrategy());
		locus.getFactory().setStrategy(new CS_DefaultRequestPropagationStrategy());
		locus.getFactory().setStrategy(new CS_NotNormativeDefaultConstructStrategy());
		locus.getFactory().setStrategy(new DefaultGetAssociationStrategy());
		locus.getFactory().setStrategy(new DefaultCreateObjectActionStrategy());
	}
	
}
