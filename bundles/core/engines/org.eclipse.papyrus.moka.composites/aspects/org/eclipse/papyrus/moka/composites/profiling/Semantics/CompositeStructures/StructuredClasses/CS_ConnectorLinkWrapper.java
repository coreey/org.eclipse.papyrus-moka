/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
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

package org.eclipse.papyrus.moka.composites.profiling.Semantics.CompositeStructures.StructuredClasses;

import java.util.List;

import org.eclipse.papyrus.moka.composites.interfaces.extensions.Semantics.CompositeStructures.StructuredClasses.ICS_ConnectorLink;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IExtensionalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.ValueSpecification;

public class CS_ConnectorLinkWrapper implements ICS_ConnectorLink, ISemanticVisitor{

	protected ICS_ConnectorLink connectorLink;
	
	public CS_ConnectorLinkWrapper(ICS_ConnectorLink connectorLink) {
		this.connectorLink = connectorLink;
	}
	
	@Override
	public Boolean hasValueForAFeature(IValue value) {
		return this.connectorLink.hasValueForAFeature(value);
	}

	@Override
	public StructuralFeature getFeature(IValue value) {
		return this.connectorLink.getFeature(value);
	}

	@Override
	public Boolean isMatchingLink(IExtensionalValue link, Property end) {
		return this.connectorLink.isMatchingLink(link, end);
	}

	@Override
	public List<IFeatureValue> getOtherFeatureValues(List<IExtensionalValue> extent, Property end) {
		return this.connectorLink.getOtherFeatureValues(extent, end);
	}

	@Override
	public void addTo(ILocus locus) {
		this.connectorLink.addTo(locus);
	}

	@Override
	public void setType(Association association) {
		this.connectorLink.setType(association);
	}

	@Override
	public Association getType() {
		return this.connectorLink.getType();
	}

	@Override
	public void destroy() {
		this.connectorLink.destroy();
	}

	@Override
	public void setLocus(ILocus locus) {
		this.connectorLink.setLocus(locus);
	}

	@Override
	public ILocus getLocus() {
		return this.connectorLink.getLocus();
	}

	@Override
	public void setIdentifier(String identifier) {
		this.connectorLink.setIdentifier(identifier);
	}

	@Override
	public String getIdentifier() {
		return this.connectorLink.getIdentifier();
	}

	@Override
	public void addFeatureValues(List<IFeatureValue> oldFeatureValues) {
		this.connectorLink.addFeatureValues(oldFeatureValues);
	}

	@Override
	public void addFeatureValuesForType(Classifier type, List<IFeatureValue> oldFeatureValues) {
		this.connectorLink.addFeatureValuesForType(type, oldFeatureValues);
	}

	@Override
	public void createFeatureValues() {
		this.connectorLink.createFeatureValues();
	}

	@Override
	public List<IFeatureValue> getMemberValues() {
		return this.connectorLink.getMemberValues();
	}

	@Override
	public List<IValue> getValues(NamedElement feature, List<IFeatureValue> featureValues) {
		return this.connectorLink.getValues(feature, featureValues);
	}

	@Override
	public IFeatureValue getFeatureValue(StructuralFeature feature) {
		return this.connectorLink.getFeatureValue(feature);
	}

	@Override
	public void setFeatureValue(StructuralFeature feature, List<IValue> values, Integer position) {
		this.connectorLink.setFeatureValue(feature, values, position);
	}

	@Override
	public List<IFeatureValue> getFeatureValues() {
		return this.connectorLink.getFeatureValues();
	}

	@Override
	public void setFeatureValues(List<IFeatureValue> featureValues) {
		this.connectorLink.setFeatureValues(featureValues);
	}

	@Override
	public ValueSpecification specify() {
		return this.connectorLink.specify();
	}

	@Override
	public boolean checkAllParents(Classifier type, Classifier classifier) {
		return this.connectorLink.checkAllParents(type, classifier);
	}

	@Override
	public boolean isInstanceOf(Classifier classifier) {
		return this.connectorLink.isInstanceOf(classifier);
	}

	@Override
	public Boolean equals(IValue otherValue) {
		return this.connectorLink.equals(otherValue);
	}

	@Override
	public IValue copy() {
		return this.connectorLink.copy();
	}

	@Override
	public IValue new_() {
		return this.connectorLink.new_();
	}

	@Override
	public List<Classifier> getTypes() {
		return this.connectorLink.getTypes();
	}

	@Override
	public Boolean hasType(Classifier type) {
		return this.connectorLink.hasType(type);
	}

	@Override
	public void _endIsolation() {
		this.connectorLink._endIsolation();
	}

	@Override
	public void _beginIsolation() {
		this.connectorLink._beginIsolation();
	}

	@Override
	public void setConnector(Connector connector) {
		this.connectorLink.setConnector(connector);
	}

	@Override
	public Connector getConnector() {
		return this.connectorLink.getConnector();
	}

}
