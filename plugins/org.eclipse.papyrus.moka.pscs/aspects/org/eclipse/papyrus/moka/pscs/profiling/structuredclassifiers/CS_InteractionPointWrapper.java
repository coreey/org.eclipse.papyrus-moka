package org.eclipse.papyrus.moka.pscs.profiling.structuredclassifiers;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.commonbehavior.IEventOccurrence;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IExecution;
import org.eclipse.papyrus.moka.fuml.commonbehavior.IParameterValue;
import org.eclipse.papyrus.moka.fuml.loci.ISemanticVisitor;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IValue;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.IObject_;
import org.eclipse.papyrus.moka.pscs.structuredclassifiers.ICS_InteractionPoint;
import org.eclipse.papyrus.moka.pscs.structuredclassifiers.ICS_Reference;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.ValueSpecification;

public class CS_InteractionPointWrapper implements ISemanticVisitor, ICS_InteractionPoint {

	protected ICS_InteractionPoint interactionPoint;
	
	public CS_InteractionPointWrapper(ICS_InteractionPoint interactionPoint) {
		this.interactionPoint = interactionPoint;
	}
	
	@Override
	public void _endIsolation() {
		// Do nothing
	}

	@Override
	public void _beginIsolation() {
		// Do nothing

	}

	@Override
	public void startBehavior(Class classifier, List<IParameterValue> inputs) {
		this.interactionPoint.startBehavior(classifier, inputs);
	}

	@Override
	public IExecution dispatch(Operation operation) {
		return this.interactionPoint.dispatch(operation);
	}

	@Override
	public void send(IEventOccurrence eventOccurrence) {
		this.interactionPoint.send(eventOccurrence);
	}

	@Override
	public void destroy() {
		this.interactionPoint.destroy();
	}

	@Override
	public void setReferent(IObject_ referent) {
		this.interactionPoint.setReferent(referent);
	}

	@Override
	public IObject_ getReferent() {
		return this.interactionPoint.getReferent();
	}

	@Override
	public void addFeatureValues(List<IFeatureValue> oldFeatureValues) {
		this.interactionPoint.addFeatureValues(oldFeatureValues);
	}

	@Override
	public void addFeatureValuesForType(Classifier type, List<IFeatureValue> oldFeatureValues) {
		this.interactionPoint.addFeatureValuesForType(type, oldFeatureValues);
	}

	@Override
	public void createFeatureValues() {
		this.interactionPoint.createFeatureValues();
	}

	@Override
	public List<IFeatureValue> getMemberValues() {
		return this.interactionPoint.getMemberValues();
	}

	@Override
	public List<IValue> getValues(NamedElement feature, List<IFeatureValue> featureValues) {
		return this.interactionPoint.getValues(feature, featureValues);
	}

	@Override
	public IFeatureValue getFeatureValue(StructuralFeature feature) {
		return this.interactionPoint.getFeatureValue(feature);
	}

	@Override
	public void setFeatureValue(StructuralFeature feature, List<IValue> values, Integer position) {
		this.interactionPoint.setFeatureValue(feature, values, position);
	}

	@Override
	public List<IFeatureValue> getFeatureValues() {
		return this.interactionPoint.getFeatureValues();
	}

	@Override
	public void setFeatureValues(List<IFeatureValue> featureValues) {
		this.interactionPoint.setFeatureValues(featureValues);
	}

	@Override
	public ValueSpecification specify() {
		return this.interactionPoint.specify();
	}

	@Override
	public boolean checkAllParents(Classifier type, Classifier classifier) {
		return this.interactionPoint.checkAllParents(type, classifier);
	}

	@Override
	public boolean isInstanceOf(Classifier classifier) {
		return this.interactionPoint.isInstanceOf(classifier);
	}

	@Override
	public Boolean equals(IValue otherValue) {
		return this.interactionPoint.equals(otherValue);
	}

	@Override
	public IValue copy() {
		return this.interactionPoint.copy();
	}

	@Override
	public IValue new_() {
		return this.interactionPoint.new_();
	}

	@Override
	public List<Classifier> getTypes() {
		return this.interactionPoint.getTypes();
	}

	@Override
	public Boolean hasType(Classifier type) {
		return this.interactionPoint.hasType(type);
	}

	@Override
	public ICS_Reference getOwner() {
		return this.interactionPoint.getOwner();
	}

	@Override
	public void setOwner(ICS_Reference owner) {
		this.interactionPoint.setOwner(owner);
	}

	@Override
	public Port getDefiningPort() {
		return this.interactionPoint.getDefiningPort();
	}

	@Override
	public void setDefiningPort(Port definingPort) {
		this.interactionPoint.setDefiningPort(definingPort);
	}

}
