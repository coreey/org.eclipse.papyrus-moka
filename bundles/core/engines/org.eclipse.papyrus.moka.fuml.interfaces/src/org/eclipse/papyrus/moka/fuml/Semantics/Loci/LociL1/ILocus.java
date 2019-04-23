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

package org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IExtensionalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;

public interface ILocus {

	public void setExecutor(IExecutor executor);

	public IExecutor getExecutor();

	public void setFactory(IExecutionFactory factory);

	public IExecutionFactory getFactory();

	public List<IExtensionalValue> getExtent(Classifier classifier);

	public void add(IExtensionalValue value);

	public void remove(IExtensionalValue value);

	public IObject_ instantiate(Class type);

	public Boolean conforms(Classifier type, Classifier classifier);

	public String makeIdentifier(IExtensionalValue value);

	public String getIdentifier();

	public void setExecutedTarget(Behavior behavior);

	public List<IExtensionalValue> getExtensionalValues();
}
