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

package org.eclipse.papyrus.moka.fuml.loci;

import org.eclipse.papyrus.moka.fuml.commonbehavior.IExecution;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IOpaqueBehaviorExecution;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IEvaluation;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IObject_;
import org.eclipse.papyrus.moka.fuml.tasks.IUMLTaskExecutionFactory;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;

public interface IExecutionFactory {

	public IExecution createExecution(Behavior behavior, IObject_ context);

	public IEvaluation createEvaluation(ValueSpecification specification);

	public ISemanticVisitor instantiateVisitor(Element element);

	public IOpaqueBehaviorExecution instantiateOpaqueBehaviorExecution(OpaqueBehavior behavior);

	public void addPrimitiveBehaviorPrototype(IOpaqueBehaviorExecution execution);

	public void setTaskFactory(IUMLTaskExecutionFactory factory);
	
	public IUMLTaskExecutionFactory getTaskFactory();
	
	public void setStrategy(ISemanticStrategy strategy);

	public ISemanticStrategy getStrategy(String name);

	public Integer getStrategyIndex(String name);

	public void setLocus(ILocus locus);

	public ILocus getLocus();

	public Type getBuiltInType(String name);

	public void addBuiltInType(Type type);
}
