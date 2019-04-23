/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
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
 *  Jeremie Tatibouet (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.NamedElement;

public interface IStateMachineSemanticVisitor extends ISemanticVisitor {

	public void setNode(NamedElement node);
	
	public NamedElement getNode();
	
	public void setParent(ISemanticVisitor parent);
	
	public ISemanticVisitor getParent();
	
	public List<ISemanticVisitor> getContextChain();
	
	public IExecution getStateMachineExecution();
	
	public ILocus getExecutionLocus();
	
	public IObject_ getExecutionContext();
	
	public boolean isVisitorFor(NamedElement node);
	
	public void activate();
	
	public void activateTransitions();
	
	public IExecution getExecutionFor(Behavior behavior, IEventOccurrence eventOccurrence);
	
}
