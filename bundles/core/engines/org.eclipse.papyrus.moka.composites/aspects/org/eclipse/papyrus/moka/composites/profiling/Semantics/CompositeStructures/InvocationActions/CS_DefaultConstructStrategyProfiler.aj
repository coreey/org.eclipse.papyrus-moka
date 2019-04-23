/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0.html/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.composites.profiling.Semantics.CompositeStructures.InvocationActions;

import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.InvocationActions.CS_DefaultConstructStrategy;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.profiling.Semantics.Classes.Kernel.FeatureValueWrapper;
import org.eclipse.papyrus.moka.fuml.profiling.Semantics.Loci.SemanticVisitorProfiler;
import org.eclipse.uml2.uml.Property;

public aspect CS_DefaultConstructStrategyProfiler extends SemanticVisitorProfiler {

	public CS_DefaultConstructStrategyProfiler() {
		super();
	}
	
	// Listen to any feature assignment made through the default construct strategy
	pointcut addStructuralFeatureValue(CS_DefaultConstructStrategy strategy, ICS_Reference context, Property feature, IValue value):
		target(strategy) &&
		args(context, feature, value) &&
		call(* CS_DefaultConstructStrategy.addStructuralFeatureValue(ICS_Reference, Property, IValue));
	
	after (CS_DefaultConstructStrategy strategy, ICS_Reference context, Property feature, IValue value) :
		 addStructuralFeatureValue(strategy, context, feature, value){
		// Whenever a FeatureValue values are updated through the default construct
		// strategy or a specialization then the services are notified.
		this.visit(new FeatureValueWrapper(context.getFeatureValue(feature), context.getReferent()));
	}
}
