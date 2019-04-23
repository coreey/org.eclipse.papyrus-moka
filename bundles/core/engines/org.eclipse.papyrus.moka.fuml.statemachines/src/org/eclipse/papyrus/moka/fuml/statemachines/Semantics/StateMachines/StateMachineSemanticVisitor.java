/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
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
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1.SemanticVisitor;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.CommonBehavior.EventTriggeredExecution;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.CommonBehavior.IEventTriggeredExecution;
import org.eclipse.papyrus.moka.fuml.statemachines.interfaces.Semantics.StateMachines.IStateMachineSemanticVisitor;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.NamedElement;

public abstract class StateMachineSemanticVisitor extends SemanticVisitor implements IStateMachineSemanticVisitor{

	// Each semantic visitor for a state-machine know its parent visitor 
	protected ISemanticVisitor parent;

	// Each semantic visitor traverse a particular node of a state-machine
	protected NamedElement node;
	
	public NamedElement getNode() {
		return node;
	}

	public void setNode(NamedElement node) {
		this.node = node;
	}

	public ISemanticVisitor getParent() {
		return parent;
	}

	public void setParent(ISemanticVisitor parent) {
		this.parent = parent;
	}

	public StateMachineSemanticVisitor(){
		this.parent = null;
	}
	
	public List<ISemanticVisitor> getContextChain(){
		// Return the hierarchy of visitors that need to be traversed to access
		// the visitor that called context chain. The caller is part of the returned
		// context chain.
		List<ISemanticVisitor> contextChain = new ArrayList<ISemanticVisitor>();
		if(!(this instanceof ExitPointPseudostateActivation) && !(this instanceof EntryPointPseudostateActivation)){
			contextChain.add(this);
		}
		if(this.parent!=null){
			if(this.parent instanceof StateMachineExecution){
				contextChain.add(this.parent);
			}else{
				contextChain.addAll(((StateMachineSemanticVisitor)this.parent).getContextChain());
			}
		}
		return contextChain;
	}
		
	public IExecution getStateMachineExecution(){
		// Return the state-machine execution from which the caller of this operation belongs
		if(this.parent!=null && this.parent instanceof StateMachineExecution){
			return (IExecution)this.parent;
		}else{
			return ((StateMachineSemanticVisitor)this.parent).getStateMachineExecution();
		}
	}
	
	public ILocus getExecutionLocus(){
		return this.getStateMachineExecution().getLocus();
	}
	
	public IObject_ getExecutionContext(){
		return this.getStateMachineExecution().getContext();
	}
	
	public boolean isVisitorFor(NamedElement node){
		// A visitor is the interpreter for a model if the node given as parameter is the
		// this model element.
		return this.node == node;
	}
	
	public void activate(){
		// This operation is intended to be overridden by sub-classes. For required sub-classes
		// (e.g., RegionActivation, StateActivation) it will initiate the instantiation phase of
		// child semantic visitors. By default activate does nothing.
		return;
	}
	
	public void activateTransitions(){
		// ActivateTransition is intended to be overridden by sub-classes. It will capture the instantiation
		// of transitions visitors as well as the linking between these visitors and the required vertices
		// activation. By default activate does nothing.
		return;
	}
	
	public IExecution getExecutionFor(Behavior behavior, IEventOccurrence eventOccurrence){
		// Create an Execution for the specified behavior. In addition to the creation of this
		// Execution, if the behavior execution is triggered by the dispatching of an event (i.e.
		// a CallEvent or a SignalEvent) then an EventTriggeredExecution is provided. This
		// execution wraps the original execution and ensures passing of event data to the
		// wrapped execution.
		IExecution execution = null;
		if(behavior != null){
			IExecution originalExecution = this.getExecutionLocus().getFactory().createExecution(behavior, this.getExecutionContext());
			if(eventOccurrence != null){
				IEventTriggeredExecution containerExecution = new EventTriggeredExecution();
				containerExecution.setTriggerringEventOccurrence(eventOccurrence);
				containerExecution.setConcreteExecution(originalExecution);
				containerExecution.setContext(originalExecution.getContext());
				execution = containerExecution;
			}else{
				execution = originalExecution;
			}
		}
		return execution;
	}
	
	public String toString(){
		return this.node.getName();
	}
}
