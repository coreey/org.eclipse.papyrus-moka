/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.composites;

import org.eclipse.papyrus.moka.composites.Semantics.impl.CommonBehaviors.Communications.CS_DispatchOperationOfInterfaceStrategy;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CommonBehaviors.Communications.CS_NameBased_StructuralFeatureOfInterfaceAccessStrategy;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.InvocationActions.CS_DefaultRequestPropagationStrategy;
import org.eclipse.papyrus.moka.composites.Semantics.impl.Loci.LociL3.CS_ExecutionFactory;
import org.eclipse.papyrus.moka.composites.Semantics.impl.Loci.LociL3.CS_Executor;
import org.eclipse.papyrus.moka.composites.Semantics.impl.Loci.LociL3.CS_Locus;
import org.eclipse.papyrus.moka.composites.extensions.Semantics.CompositeStructures.CS_NotNormativeDefaultConstructStrategy;
import org.eclipse.papyrus.moka.fuml.FUMLExecutionEngine;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;

public class CompositeStructuresExecutionEngine extends FUMLExecutionEngine {

	@Override
	public ILocus initializeLocus() {
		ILocus locus = new CS_Locus();
		locus.setExecutor(new CS_Executor());
		locus.setFactory(new CS_ExecutionFactory());
		return locus;
	}

	// Register semantic strategies available in the environment
	@Override
	protected void registerSemanticStrategies(ILocus locus) {
		super.registerSemanticStrategies(locus);
		locus.getFactory().setStrategy(new CS_DispatchOperationOfInterfaceStrategy());
		locus.getFactory().setStrategy(new CS_NameBased_StructuralFeatureOfInterfaceAccessStrategy());
		locus.getFactory().setStrategy(new CS_DefaultRequestPropagationStrategy());
		locus.getFactory().setStrategy(new CS_NotNormativeDefaultConstructStrategy());
	}
}
