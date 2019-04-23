/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.cosimulation;


import org.eclipse.papyrus.moka.composites.Semantics.impl.Loci.LociL3.CS_Executor;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.fuml.cosimulation.semantics.CosimulationDefaultConstructStrategy;
import org.eclipse.papyrus.moka.fuml.cosimulation.semantics.CosimulationLocus;
import org.eclipse.papyrus.moka.timedfuml.TimedUmlExecutionEngine;

public class CosimulationExecutionEngine extends TimedUmlExecutionEngine {

	@Override
	public ILocus initializeLocus() {
		this.locus = new CosimulationLocus();
		this.locus.setFactory(new CosimulationFactory());
		this.locus.setExecutor(new CS_Executor());
		return this.locus;
	}


	@Override
	protected void registerSemanticStrategies(ILocus locus) {
		// TODO Auto-generated method stub
		super.registerSemanticStrategies(locus);
		locus.getFactory().setStrategy(new CosimulationDefaultConstructStrategy());

	}

}
