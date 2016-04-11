/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.cosimulation;

import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.cosimulation.semantics.CosimulationAddStructuralFeatureValueActionActivation;
import org.eclipse.papyrus.moka.fuml.cosimulation.semantics.CosimulationInstanceValueEvaluation;
import org.eclipse.papyrus.moka.fuml.cosimulation.semantics.CosimulationReadStructuralFeatureActionActivation;
import org.eclipse.papyrus.moka.timedfuml.semantics.Timed_ExecutionFactory;
import org.eclipse.uml2.uml.AddStructuralFeatureValueAction;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.ReadStructuralFeatureAction;

/**
 * @author Sahar Guermazi (CEA-LIST)
 *
 */
public class CosimulationFactory extends Timed_ExecutionFactory {

	@Override
	public ISemanticVisitor instantiateVisitor(Element element) {
		ISemanticVisitor visitor = null;

		if (element instanceof ReadStructuralFeatureAction) {
			visitor = new CosimulationReadStructuralFeatureActionActivation();
		} else if (element instanceof AddStructuralFeatureValueAction) {
			visitor = new CosimulationAddStructuralFeatureValueActionActivation();
		} else if (element instanceof InstanceValue) {
			visitor = new CosimulationInstanceValueEvaluation();

		} else {
			visitor = super.instantiateVisitor(element);
		}

		return visitor;
	}
}
