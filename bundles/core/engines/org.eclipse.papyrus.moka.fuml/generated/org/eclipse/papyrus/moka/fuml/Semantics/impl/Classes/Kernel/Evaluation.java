/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IEvaluation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1.SemanticVisitor;
import org.eclipse.uml2.uml.ValueSpecification;

public abstract class Evaluation extends SemanticVisitor implements IEvaluation {

	/*
	 * The value specification to be evaluated.
	 */
	public ValueSpecification specification;

	/*
	 * The locus at which this evaluation is taking place.
	 */
	public ILocus locus;

	public abstract IValue evaluate();


	public void setSpecification(ValueSpecification specification) {
		this.specification = specification;
	}

	public ValueSpecification getSpecification() {
		return this.specification;
	}

	public void setLocus(ILocus locus) {
		this.locus = locus;
	}

	public ILocus getLocus() {
		return this.locus;
	}
}
