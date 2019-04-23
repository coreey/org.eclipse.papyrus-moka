/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
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

package org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ValueSpecification;

public interface IValue extends ISemanticVisitor {

	public ValueSpecification specify();
	
	public boolean checkAllParents(Classifier type, Classifier classifier);
	
	public boolean isInstanceOf(Classifier classifier);

	public Boolean equals(IValue otherValue);

	public IValue copy();

	public IValue new_();

	public List<Classifier> getTypes();

	public Boolean hasType(Classifier type);

}
