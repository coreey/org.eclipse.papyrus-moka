/*****************************************************************************
 * 
 * Copyright (c) 2017 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 * 
 *****************************************************************************/
package org.eclipse.papyrus.moka.externalcontrol.semantics;

import java.util.List;

import org.eclipse.papyrus.moka.externalcontrol.advice.IControllerAdvice;
import org.eclipse.papyrus.moka.externalcontrol.controller.AbstractExternallyControlledVisitor;
import org.eclipse.papyrus.moka.externalcontrol.controller.ExternalController;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivationGroup;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityParameterNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IToken;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventAccepter;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.IObjectActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.ActivityExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.ActivityNodeActivationGroup;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.ObjectToken;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.ValueSpecification;

public class ExternallyControlledActivityExecution extends AbstractExternallyControlledVisitor<ActivityExecution> implements IActivityExecution {

	public ExternallyControlledActivityExecution(ActivityExecution visitor, ExternalController controller, List<IControllerAdvice> advices) {
		super(visitor, controller, advices);
	}

	
	protected AbstractExternallyControlledVisitor<? extends ISemanticVisitor> stackParent;

	@Override
	public AbstractExternallyControlledVisitor<? extends ISemanticVisitor> getStackParent() {
		return stackParent;
	}
	
	//This operation is normally called by the ExternallyControlledCallActionActivation which created this execution
	public void setStackParent(AbstractExternallyControlledVisitor<? extends ISemanticVisitor> parent) {
		this.stackParent = parent;
	}

	@Override
	protected void doSemanticAction() {
		
		// Execute the activity for this execution by creating an activity node
		// activation group and activating all the activity nodes in the
		// activity.
		// When this is complete, copy the values on the tokens offered by
		// output parameter nodes to the corresponding output parameters.
		Activity activity = (Activity) (this.getTypes().get(0));
	
		
		Debug.println("[execute] Activity " + activity.getName() + "...");
		// Debug.println("[execute] context = " + this.context.objectId());
		Debug.println("[event] Execute activity=" + activity.getName());
		setGroup( new ActivityNodeActivationGroup());
		this.getGroup().setActivityExecution_(this);
		this.getGroup().activate(activity.getNodes(), activity.getEdges());
		
	}

	@Override
	protected void doResumeExecution() {
		Activity activity = (Activity) (this.getTypes().get(0));
		// Debug.println("[execute] Getting output parameter node activations...");
		List<IActivityParameterNodeActivation> outputActivations = this.getGroup().getOutputParameterNodeActivations();
		// Debug.println("[execute] There are " + outputActivations.size() +
		// " output parameter node activations.");
		for (int i = 0; i < outputActivations.size(); i++) {
			IActivityParameterNodeActivation outputActivation = outputActivations.get(i);
			ParameterValue parameterValue = new ParameterValue();
			parameterValue.parameter = ((ActivityParameterNode) (outputActivation.getNode())).getParameter();
			List<IToken> tokens = outputActivation.getTokens();
			for (int j = 0; j < tokens.size(); j++) {
				IToken token = tokens.get(j);
				IValue value = ((ObjectToken) token).value;
				if (value != null) {
					parameterValue.values.add(value);
					Debug.println("[event] Output activity=" + activity.getName() + " parameter=" + parameterValue.parameter.getName() + " value=" + value);
				}
			}
			this.setParameterValue(parameterValue);
		}
		Debug.println("[execute] Activity " + activity.getName() + " completed.");


	}




	@Override
	public void execute() {
		//we suspend for control immediately
		suspendForControl();
	}





	@Override
	public void addType(Class type) {
		delegatedVisitor.addType(type);

	}

	@Override
	public void removeType(Class type) {
		delegatedVisitor.removeType(type);

	}

	@Override
	public void startBehavior(Class classifier, List<IParameterValue> inputs) {
		delegatedVisitor.startBehavior(classifier, inputs);

	}

	@Override
	public IExecution dispatch(Operation operation) {
		return delegatedVisitor.dispatch(operation);
	}

	@Override
	public void send(IEventOccurrence eventOccurrence) {
		delegatedVisitor.send(eventOccurrence);

	}

	@Override
	public void register(IEventAccepter accepter) {
		delegatedVisitor.register(accepter);

	}

	@Override
	public void unregister(IEventAccepter accepter) {
		delegatedVisitor.unregister(accepter);

	}

	@Override
	public IObjectActivation getObjectActivation() {
		return delegatedVisitor.getObjectActivation();
	}

	@Override
	public void setObjectActivation(IObjectActivation objectActivation) {
		delegatedVisitor.setObjectActivation(objectActivation);

	}

	@Override
	public void destroy() {
			delegatedVisitor.destroy();
	}

	@Override
	public void setLocus(ILocus locus) {
		delegatedVisitor.setLocus(locus);

	}

	@Override
	public ILocus getLocus() {
		return delegatedVisitor.getLocus();
	}

	@Override
	public void setIdentifier(String identifier) {
		delegatedVisitor.setIdentifier(identifier);

	}

	@Override
	public String getIdentifier() {
		return delegatedVisitor.getIdentifier();
	}

	@Override
	public void addFeatureValues(List<IFeatureValue> oldFeatureValues) {
		delegatedVisitor.addFeatureValues(oldFeatureValues);

	}

	@Override
	public void addFeatureValuesForType(Classifier type, List<IFeatureValue> oldFeatureValues) {
		delegatedVisitor.addFeatureValuesForType(type, oldFeatureValues);

	}

	@Override
	public void createFeatureValues() {
		delegatedVisitor.createFeatureValues();

	}

	@Override
	public List<IFeatureValue> getMemberValues() {

		return delegatedVisitor.getMemberValues();
	}

	@Override
	public List<IValue> getValues(NamedElement feature, List<IFeatureValue> featureValues) {

		return delegatedVisitor.getValues(feature, featureValues);
	}

	@Override
	public IFeatureValue getFeatureValue(StructuralFeature feature) {

		return delegatedVisitor.getFeatureValue(feature);
	}

	@Override
	public void setFeatureValue(StructuralFeature feature, List<IValue> values, Integer position) {
		delegatedVisitor.setFeatureValue(feature, values, position);


	}

	@Override
	public List<IFeatureValue> getFeatureValues() {

		return delegatedVisitor.getFeatureValues();
	}

	@Override
	public void setFeatureValues(List<IFeatureValue> featureValues) {
		delegatedVisitor.setFeatureValues(featureValues);

	}

	@Override
	public ValueSpecification specify() {

		return delegatedVisitor.specify();
	}

	@Override
	public Boolean equals(IValue otherValue) {

		return delegatedVisitor.equals(otherValue);
	}

	@Override
	public IValue copy() {

		return delegatedVisitor.copy();
	}

	@Override
	public IValue new_() {
		return delegatedVisitor.new_();
	}

	@Override
	public List<Classifier> getTypes() {

		return delegatedVisitor.getTypes();
	}

	@Override
	public Boolean hasType(Classifier type) {

		return delegatedVisitor.hasType(type);
	}

	@Override
	public void _endIsolation() {
		delegatedVisitor._endIsolation();

	}

	@Override
	public void _beginIsolation() {
		delegatedVisitor._beginIsolation();

	}



	@Override
	public void setParameterValue(IParameterValue parameterValue) {
		delegatedVisitor.setParameterValue(parameterValue);

	}

	@Override
	public IParameterValue getReturnParameterValue() {

		return delegatedVisitor.getReturnParameterValue();
	}

	@Override
	public IParameterValue getParameterValue(Parameter parameter) {

		return delegatedVisitor.getParameterValue(parameter);
	}

	@Override
	public List<IParameterValue> getOutputParameterValues() {

		return delegatedVisitor.getOutputParameterValues();
	}

	@Override
	public Behavior getBehavior() {

		return delegatedVisitor.getBehavior();
	}

	@Override
	public void terminate() {
		delegatedVisitor.terminate();

	}

	@Override
	public void setContext(IObject_ context) {
		delegatedVisitor.setContext(context);

	}

	@Override
	public IObject_ getContext() {
		return delegatedVisitor.getContext();
	}

	@Override
	public List<IParameterValue> getParameterValues() {

		return delegatedVisitor.getParameterValues();
	}


	@Override
	public void setGroup(IActivityNodeActivationGroup group) {
		delegatedVisitor.setGroup(group);
		
	}


	@Override
	public IActivityNodeActivationGroup getGroup() {
		
		return delegatedVisitor.getGroup();
	}

	@Override
	public boolean checkAllParents(Classifier type, Classifier classifier) {
		return this.delegatedVisitor.checkAllParents(type, classifier);
	}

	@Override
	public boolean isInstanceOf(Classifier classifier) {
		return this.delegatedVisitor.isInstanceOf(classifier);
	}

}
