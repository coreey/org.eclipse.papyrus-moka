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
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IEvaluation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IOpaqueBehaviorExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.IExecutionFactory;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticStrategy;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;

public abstract class ExecutionFactory implements IExecutionFactory {

	/*
	 * The locus at which this factory resides.
	 */
	public ILocus locus;

	/*
	 * The set of opaque behavior executions to be used to execute the primitive
	 * behaviors known to the factory.
	 */
	public List<IOpaqueBehaviorExecution> primitiveBehaviorPrototypes;

	/*
	 * The set of primitive types that have corresponding literal value
	 * specifications. Must include Integer, Boolean, String and
	 * UnlimitedNatural.
	 */
	// FIXME: Sounds better to have a list of Type because built in types can only be classes
	// public List<PrimitiveType> builtInTypes = new ArrayList<PrimitiveType>();

	public List<Type> builtInTypes;

	/*
	 * The set of semantic strategies currently registered with this execution
	 * factory.
	 */
	public List<ISemanticStrategy> strategies;

	public ExecutionFactory() {
		super();
		this.builtInTypes = new ArrayList<Type>();
		this.strategies = new ArrayList<ISemanticStrategy>();
		this.primitiveBehaviorPrototypes = new ArrayList<IOpaqueBehaviorExecution>();
	}

	public IExecution createExecution(Behavior behavior, IObject_ context) {
		// Create an execution object for a given behavior.
		// The execution will take place at the locus of the factory in the
		// given context.
		// If the context is empty, the execution is assumed to provide its own
		// context.
		IExecution execution;
		if (behavior instanceof OpaqueBehavior) {
			execution = this.instantiateOpaqueBehaviorExecution((OpaqueBehavior) behavior);
		} else {
			execution = (IExecution) this.instantiateVisitor(behavior);
			execution.addType(behavior);
			execution.createFeatureValues();
		}
		this.locus.add(execution);
		if (context == null) {
			execution.setContext(execution);
		} else {
			execution.setContext(context);
		}
		return execution;
	}

	public IEvaluation createEvaluation(ValueSpecification specification) {
		// Create an evaluation object for a given value specification.
		// The evaluation will take place at the locus of the factory.
		IEvaluation evaluation = (IEvaluation) this.instantiateVisitor(specification);
		evaluation.setSpecification(specification);
		evaluation.setLocus(this.locus);
		return evaluation;
	}

	public abstract ISemanticVisitor instantiateVisitor(Element element);

	public IOpaqueBehaviorExecution instantiateOpaqueBehaviorExecution(OpaqueBehavior behavior) {
		// Return a copy of the prototype for the primitive behavior execution
		// of the given opaque behavior.
		OpaqueBehaviorExecution execution = null;
		int i = 1;
		while (execution == null & i <= this.primitiveBehaviorPrototypes.size()) {
			// Debug.println("[instantiateOpaqueExecution] Checking " +
			// this.primitiveBehaviorPrototypes.get(i).objectId() + "...");
			IOpaqueBehaviorExecution prototype = this.primitiveBehaviorPrototypes.get(i - 1);
			if (prototype.getBehavior() == behavior) {
				execution = (OpaqueBehaviorExecution) (prototype.copy());
			}
			i = i + 1;
		}
		if (execution == null) {
			Debug.println("[instantiateOpaqueExecution] No prototype execution found for " + behavior.getName() + ".");
		}
		return execution;
	}

	public void addPrimitiveBehaviorPrototype(IOpaqueBehaviorExecution execution) {
		// Add an opaque behavior execution to use as a prototype for
		// instantiating the corresponding primitive opaque behavior.
		// Precondition: No primitive behavior prototype for the type of the
		// given execution should already exist.
		this.primitiveBehaviorPrototypes.add(execution);
	}

	public void addBuiltInType(Type type) {
		this.builtInTypes.add(type);
	}

	public Type getBuiltInType(String name) {
		// Return the built-in type with the given name.
		Type type = null;
		int i = 1;
		while (type == null & i <= this.builtInTypes.size()) {
			Type currentType = this.builtInTypes.get(i - 1);
			if (currentType.getName().equals(name)) {
				type = currentType;
			}
			i = i + 1;
		}
		return type;
	}

	public void setStrategy(ISemanticStrategy strategy) {
		// Set the strategy for a semantic variation point. Any existing
		// strategy for the same SVP is replaced.
		int i = this.getStrategyIndex(strategy.getName());
		if (i <= this.strategies.size()) {
			this.strategies.remove(i - 1);
		}
		this.strategies.add(strategy);
	}

	public ISemanticStrategy getStrategy(String name) {
		// Get the strategy with the given name.
		int i = this.getStrategyIndex(name);
		ISemanticStrategy strategy = null;
		if (i <= this.strategies.size()) {
			strategy = this.strategies.get(i - 1);
		}
		return strategy;
	}

	public Integer getStrategyIndex(String name) {
		// Get the index of the strategy with the given name.
		// If there is no such strategy, return the size of the strategies list.
		List<ISemanticStrategy> strategies = this.strategies;
		int i = 1;
		boolean unmatched = true;
		while (unmatched & (i <= strategies.size())) {
			if (strategies.get(i - 1).getName().equals(name)) {
				unmatched = false;
			} else {
				i = i + 1;
			}
		}
		return i;
	}

	public ILocus getLocus() {
		return locus;
	}

	public void setLocus(ILocus locus) {
		this.locus = locus;
	}
}
