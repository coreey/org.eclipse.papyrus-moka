/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
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
package org.eclipse.papyrus.moka.engine.uml.scheduling;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.commonbehavior.IEventAccepter;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IExecution;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IObjectActivation;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IParameterValue;
import org.eclipse.papyrus.moka.fuml.loci.ILocus;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IValue;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IObject_;
import org.eclipse.papyrus.moka.fuml.tasks.IUMLTaskExecution;
import org.eclipse.papyrus.moka.kernel.scheduling.control.IExecutionLoop;
import org.eclipse.papyrus.moka.kernel.scheduling.execution.TaskExecution;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.ValueSpecification;

public abstract class UMLTaskExecution extends TaskExecution implements IUMLTaskExecution{

	/**
	 * Execution locus for the root execution 
	 */
	protected ILocus locus;
	
	protected IExecutionLoop executionLoop;
	
	public UMLTaskExecution(IExecutionLoop loop) {
		super();
		executionLoop = loop;
	}
	
	@Override
	public void schedule() {
		executionLoop.include(this);
	}
	
	/**
	 * @see {@link IExecution#addType(Class)}
	 */
	@Override
	public void addType(Class type) {
		// Does nothing
	}

	/**
	 * @see {@link IExecution#removeType(Class)}
	 */
	@Override
	public void removeType(Class type) {
		// Does nothing
	}

	/**
	 * @see {@link IExecution#startBehavior(Class, List)}
	 */
	@Override
	public void startBehavior(Class classifier, List<IParameterValue> inputs) {
		// Does nothing
	}

	/**
	 * @see {@link IExecution#dispatch(Operation))}
	 */
	@Override
	public IExecution dispatch(Operation operation) {
		// Does nothing
		return null;
	}

	/**
	 * @see {@link IExecution#register(IEventAccepter)}
	 */
	@Override
	public void register(IEventAccepter accepter) {
		// Does nothing
	}

	/**
	 * @see {@link IExecution#unregister(IEventAccepter)}
	 */
	@Override
	public void unregister(IEventAccepter accepter) {
		// Does nothing
	}

	/**
	 * @see {@link IExecution#getObjectActivation()}
	 */
	@Override
	public IObjectActivation getObjectActivation() {
		// Does nothing
		return null;
	}

	/**
	 * @see {@link IExecution#setObjectActivation(IObjectActivation)}
	 */
	@Override
	public void setObjectActivation(IObjectActivation objectActivation) {
		// Does nothing
	}

	/**
	 * @see {@link IExecution#destroy()}
	 */
	@Override
	public void destroy() {
		// Does nothing
	}

	/**
	 * @see {@link IExecution#setLocus(ILocus)}
	 */
	@Override
	public void setLocus(ILocus l) {
		locus = l;
	}

	/**
	 * @see {@link IExecution#getLocus()}
	 */
	@Override
	public ILocus getLocus() {
		return locus;
	}

	/**
	 * @see {@link IExecution#setIdentifier(String)}
	 */
	@Override
	public void setIdentifier(String identifier) {
		// Does nothing
		
	}

	/**
	 * @see {@link IExecution#getIdentifier()}
	 */
	@Override
	public String getIdentifier() {
		// Does nothing
		return null;
	}

	/**
	 * @see {@link IExecution#getIdentifier()}
	 */
	@Override
	public void addFeatureValues(List<IFeatureValue> oldFeatureValues) {
		// Does nothing
	}

	/**
	 * @see {@link IExecution#addFeatureValuesForType(Classifier, List)}
	 */
	@Override
	public void addFeatureValuesForType(Classifier type, List<IFeatureValue> oldFeatureValues) {
		// Does nothing
	}

	/**
	 * @see {@link IExecution#createFeatureValues()}
	 */
	@Override
	public void createFeatureValues() {
		// Does nothing
		
	}

	/**
	 * @see {@link IExecution#getMemberValues()}
	 */
	@Override
	public List<IFeatureValue> getMemberValues() {
		// Does nothing
		return null;
	}

	/**
	 * @see {@link IExecution#getValues(NamedElement, List)}
	 */
	@Override
	public List<IValue> getValues(NamedElement feature, List<IFeatureValue> featureValues) {
		// Does nothing
		return null;
	}

	/**
	 * @see {@link IExecution#getFeatureValue(StructuralFeature)}
	 */
	@Override
	public IFeatureValue getFeatureValue(StructuralFeature feature) {
		// Does nothing
		return null;
	}

	/**
	 * @see {@link IExecution#setFeatureValue(StructuralFeature, List, Integer)}
	 */
	@Override
	public void setFeatureValue(StructuralFeature feature, List<IValue> values, Integer position) {
		// Does nothing
	}

	/**
	 * @see {@link IExecution#getFeatureValues()}
	 */
	@Override
	public List<IFeatureValue> getFeatureValues() {
		// Does nothing
		return null;
	}

	/**
	 * @see {@link IExecution#setFeatureValues(List)}
	 */
	@Override
	public void setFeatureValues(List<IFeatureValue> featureValues) {
		// Does nothing
	}

	/**
	 * @see {@link IExecution#specify()}
	 */
	@Override
	public ValueSpecification specify() {
		// Does nothing
		return null;
	}

	/**
	 * @see {@link IExecution#checkAllParents(Classifier, Classifier)}
	 */
	@Override
	public boolean checkAllParents(Classifier type, Classifier classifier) {
		// Does nothing
		return false;
	}

	/**
	 * @see {@link IExecution#isInstanceOf(Classifier)}
	 */
	@Override
	public boolean isInstanceOf(Classifier classifier) {
		// Does nothing
		return false;
	}

	/**
	 * @see {@link IExecution#equals(IValue)}
	 */
	@Override
	public Boolean equals(IValue otherValue) {
		// Does nothing
		return null;
	}

	/**
	 * @see {@link IExecution#copy()}
	 */
	@Override
	public IValue copy() {
		// Does nothing
		return null;
	}

	/**
	 * @see {@link IExecution#new_()}
	 */
	@Override
	public IValue new_() {
		// Does nothing
		return null;
	}

	/**
	 * @see {@link IExecution#hasType(Classifier)}
	 */
	@Override
	public Boolean hasType(Classifier type) {
		// Does nothing
		return null;
	}

	/**
	 * @see {@link IExecution#_endIsolation()}
	 */
	@Override
	public void _endIsolation() {
		// Does nothing
	}

	/**
	 * @see {@link IExecution#_beginIsolation()}
	 */
	@Override
	public void _beginIsolation() {
		// Does nothing
	}

	/**
	 * @see {@link IExecution#setParameterValue(IParameterValue)}
	 */
	@Override
	public void setParameterValue(IParameterValue parameterValue) {
		// Does nothing
	}

	/**
	 * @see {@link IExecution#getReturnParameterValue()}
	 */
	@Override
	public IParameterValue getReturnParameterValue() {
		// Does nothing
		return null;
	}

	/**
	 * @see {@link IExecution#getParameterValue(Parameter)}
	 */
	@Override
	public IParameterValue getParameterValue(Parameter parameter) {
		// Does nothing
		return null;
	}

	/**
	 * @see {@link IExecution#getOutputParameterValues()}
	 */
	@Override
	public List<IParameterValue> getOutputParameterValues() {
		// Does nothing
		return null;
	}

	/**
	 * @see {@link IExecution#getBehavior()}
	 */
	@Override
	public Behavior getBehavior() {
		// Does nothing
		return null;
	}

	/**
	 * @see {@link IExecution#setContext(IObject_)}
	 */
	@Override
	public void setContext(IObject_ context) {
		// Does nothing
	}

	/**
	 * @see {@link IExecution#getContext()}
	 */
	@Override
	public IObject_ getContext() {
		// Does nothing
		return null;
	}

	/**
	 * @see {@link IExecution#getParameterValues()}
	 */
	@Override
	public List<IParameterValue> getParameterValues() {
		// Does nothing
		return null;
	}
	
	/**
	 * @see {@link IExecution#send(IEventOccurrence)}
	 */
	@Override
	public void send(IEventOccurrence eventOccurrence) {
		// Does nothing
	}
	
	/**
	 * @see {@link IValue#getTypes()}
	 */
	@Override
	public List<Classifier> getTypes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void suspend() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void terminate() {

	}
	
}
