/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.pscs.profiling.actions;

import org.eclipse.papyrus.moka.fuml.profiling.simpleclassifiers.FeatureValueWrapper;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IValue;
import org.eclipse.papyrus.moka.fuml.profiling.loci.SemanticVisitorProfiler;
import org.eclipse.papyrus.moka.pscs.actions.CS_DefaultConstructStrategy;
import org.eclipse.papyrus.moka.pscs.structuredclassifiers.ICS_Reference;
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
