/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
 *****************************************************************************/
package org.eclipse.papyrus.moka.async.fuml;

import org.eclipse.papyrus.moka.async.fuml.Semantics.CommonBehaviors.Communications.AsyncFIFOGetNextEventStrategy;
import org.eclipse.papyrus.moka.async.fuml.Semantics.Loci.LociL1.AsyncLocus;
import org.eclipse.papyrus.moka.composites.CompositeStructuresExecutionEngine;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CommonBehaviors.Communications.CS_DispatchOperationOfInterfaceStrategy;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CommonBehaviors.Communications.CS_NameBased_StructuralFeatureOfInterfaceAccessStrategy;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.InvocationActions.CS_DefaultConstructStrategy;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.InvocationActions.CS_DefaultRequestPropagationStrategy;
import org.eclipse.papyrus.moka.composites.Semantics.impl.Loci.LociL3.CS_ExecutionFactory;
import org.eclipse.papyrus.moka.composites.Semantics.impl.Loci.LociL3.CS_Executor;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;

/**
 * Entry point of this plug-in. By extending the FUMLExecutionEngine it contributes
 * to the extension point defined by Moka and is by the way registered as a new engine
 * that can be used to execute a defined model
 *
 * @author CEA LIST (jt605650)
 *
 */
public class FUMLMultiThreadExecutionEngine extends CompositeStructuresExecutionEngine {

	@Override
	public ILocus initializeLocus() {
		ILocus locus = new AsyncLocus();
		locus.setExecutor(new CS_Executor());
		locus.setFactory(new CS_ExecutionFactory());
		return locus;
	}

	@Override
	protected void registerSemanticStrategies(ILocus locus) {
		super.registerSemanticStrategies(locus);
		locus.getFactory().setStrategy(new AsyncFIFOGetNextEventStrategy());
		locus.getFactory().setStrategy(new CS_DispatchOperationOfInterfaceStrategy());
		locus.getFactory().setStrategy(new CS_NameBased_StructuralFeatureOfInterfaceAccessStrategy());
		locus.getFactory().setStrategy(new CS_DefaultRequestPropagationStrategy());
		locus.getFactory().setStrategy(new CS_DefaultConstructStrategy());
	}
}
