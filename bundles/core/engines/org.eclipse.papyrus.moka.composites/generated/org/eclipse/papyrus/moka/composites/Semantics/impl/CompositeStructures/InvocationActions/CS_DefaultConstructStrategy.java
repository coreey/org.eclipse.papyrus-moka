/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.InvocationActions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.composites.Semantics.impl.Classes.Kernel.CS_OpaqueExpressionEvaluation;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_InteractionPoint;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_Link;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_Reference;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_InteractionPoint;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Link;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Object;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IEvaluation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;


public class CS_DefaultConstructStrategy extends CS_ConstructStrategy {

	public ILocus locus;

	@Override
	public IObject_ construct(Operation constructor, ICS_Object context) {
		this.locus = context.getLocus();
		return this.constructObject(context, (Class) constructor.getType());
	}

	public IObject_ constructObject(ICS_Object context, Class type) {
		ICS_Reference referenceToContext = new CS_Reference();
		referenceToContext.setReferent(context);
		referenceToContext.setCompositeReferent(context);
		// FIXME detect infinite recursive instantiation
		List<Property> allAttributes = type.getAllAttributes();
		int i = 1;
		// Instantiate ports and parts
		while (i <= allAttributes.size()) {
			Property p = allAttributes.get(i - 1);
			if (p.getDefaultValue() != null) {
				ValueSpecification defaultValueSpecification = p.getDefaultValue();
				IEvaluation evaluation = (IEvaluation) context.getLocus().getFactory().instantiateVisitor(defaultValueSpecification);
				evaluation.setSpecification(defaultValueSpecification);
				evaluation.setLocus(context.getLocus());
				if (evaluation instanceof CS_OpaqueExpressionEvaluation) {
					List<IValue> evaluations = ((CS_OpaqueExpressionEvaluation) evaluation).executeExpressionBehavior();
					for (int j = 0; j < evaluations.size(); j++) {
						this.addStructuralFeatureValue(referenceToContext, p, evaluations.get(j));
					}
				} else {
					IValue defaultValue = evaluation.evaluate();
					this.addStructuralFeatureValue(referenceToContext, p, defaultValue);
				}
			} else if (this.canInstantiate(p)) {
				int j = 1;
				while (j <= p.getLower()) {
					IObject_ value;
					// if p is a Port typed by an Interface
					// creates an Object without type, but with FeatureValues corresponding to
					// structural features of the interface.
					if (p instanceof Port && p.getType() instanceof Interface) {
						value = this.instantiateInterface((Interface) p.getType(), this.locus);
						this.addStructuralFeatureValue(referenceToContext, p, value);
					} else {
						value = context.getLocus().instantiate((Class) p.getType());
						// TODO account for existing constructors
						value = this.constructObject((ICS_Object) value, (Class) p.getType());
						this.addStructuralFeatureValue(referenceToContext, p, value);
						if (((Class) p.getType()).isActive()) {
							value.startBehavior((Class) p.getType(), new ArrayList<IParameterValue>());
						}
					}
					j = j + 1;
				}
			}
			i = i + 1;
		}
		// Instantiate connectors
		List<NamedElement> allMembers = type.getMembers();
		i = 1;
		while (i <= allMembers.size()) {
			NamedElement member = allMembers.get(i - 1);
			if (member instanceof Connector) {
				Connector connector = (Connector) member;
				if (this.isArrayPattern(connector)) {
					this.generateArrayPattern(referenceToContext, connector);
				} else if (this.isStarPattern(connector)) {
					this.generateStarPattern(referenceToContext, connector);
				}
			}
			i = i + 1;
		}
		return referenceToContext.getReferent();
	}

	public void addStructuralFeatureValue(ICS_Reference context, Property feature, IValue value) {
		IFeatureValue featureValue = context.getFeatureValue(feature);
		if (featureValue != null) {
			List<IValue> values = featureValue.getValues();
			if (feature instanceof Port) {
				// insert an interaction point
				ICS_InteractionPoint interactionPoint = new CS_InteractionPoint();
				interactionPoint.setDefiningPort((Port) feature);
				interactionPoint.setReferent((ICS_Object) value);
				interactionPoint.setOwner(context);
				values.add(interactionPoint);
			} else if (value instanceof ICS_Object) {
				// insert a reference
				ICS_Reference reference = new CS_Reference();
				reference.setCompositeReferent((ICS_Object) value);
				reference.setReferent((ICS_Object) value);
				values.add(reference);
			} else {
				values.add(value);
			}
		}
	}

	public void generateArrayPattern(ICS_Reference context, Connector connector) {
		ConnectorEnd end1 = connector.getEnds().get(0);
		ConnectorEnd end2 = connector.getEnds().get(1);
		List<IReference> end1Values = this.getValuesFromConnectorEnd(context, end1);
		List<IReference> end2Values = this.getValuesFromConnectorEnd(context, end2);
		for (int i = 0; i < end1Values.size(); i++) {
			ICS_Link link = new CS_Link();
			if (connector.getType() == null) {
				link.setType(this.getDefaultAssociation());
			} else {
				link.setType(connector.getType());
			}
			List<IValue> valuesForEnd1 = new ArrayList<IValue>();
			valuesForEnd1.add(end1Values.get(i));
			List<IValue> valuesForEnd2 = new ArrayList<IValue>();
			valuesForEnd2.add(end2Values.get(i));
			link.setFeatureValue(link.getType().getOwnedEnds().get(0), valuesForEnd1, -1);
			link.setFeatureValue(link.getType().getOwnedEnds().get(1), valuesForEnd2, -1);
			link.addTo(context.getReferent().getLocus());
		}
	}

	public List<IReference> getValuesFromConnectorEnd(ICS_Reference context, ConnectorEnd end) {
		List<IReference> endValues = new ArrayList<IReference>();
		if (end.getPartWithPort() != null) {
			IFeatureValue valueForPart = context.getFeatureValue(end.getPartWithPort());
			if (valueForPart != null) {
				for (int i = 0; i < valueForPart.getValues().size(); i++) {
					IReference reference = (IReference) valueForPart.getValues().get(i);
					IFeatureValue valueForPort = reference.getFeatureValue((Port) end.getRole());
					if (valueForPort != null) {
						for (int j = 0; j < valueForPort.getValues().size(); j++) {
							endValues.add((IReference) valueForPort.getValues().get(j));
						}
					}
				}
			}
		} else {
			IFeatureValue valueForRole = context.getFeatureValue((Property) end.getRole());
			if (valueForRole != null) {
				for (int i = 0; i < valueForRole.getValues().size(); i++) {
					endValues.add((IReference) valueForRole.getValues().get(i));
				}
			}
		}
		return endValues;
	}

	public void generateStarPattern(ICS_Reference context, Connector connector) {
		ConnectorEnd end1 = connector.getEnds().get(0);
		ConnectorEnd end2 = connector.getEnds().get(1);
		List<IReference> end1Values = this.getValuesFromConnectorEnd(context, end1);
		List<IReference> end2Values = this.getValuesFromConnectorEnd(context, end2);
		for (int i = 0; i < end1Values.size(); i++) {
			for (int j = 0; j < end2Values.size(); j++) {
				ICS_Link link = new CS_Link();
				if (connector.getType() == null) {
					link.setType(this.getDefaultAssociation());
				} else {
					link.setType(connector.getType());
				}
				List<IValue> valuesForEnd1 = new ArrayList<IValue>();
				valuesForEnd1.add(end1Values.get(i));
				List<IValue> valuesForEnd2 = new ArrayList<IValue>();
				valuesForEnd2.add(end2Values.get(j));
				link.setFeatureValue(link.getType().getOwnedEnds().get(0), valuesForEnd1, -1);
				link.setFeatureValue(link.getType().getOwnedEnds().get(1), valuesForEnd2, -1);
				link.addTo(context.getReferent().getLocus());
			}
		}
	}

	public boolean canInstantiate(Property p) {
		// Instantiate is possible if:
		// - p is composite
		// - p is typed
		// - This type is a Class and it is not abstract
		// - Or p is a Port and the type is an Interface
		if (p.isComposite()) {
			if (p.getType() != null) {
				if (p.getType() instanceof Class) {
					return !((Class) p.getType()).isAbstract();
				} else if (p.getType() instanceof Interface) {
					return p instanceof Port;
				}
			}
		}
		return false;
	}

	public int getCardinality(ConnectorEnd end) {
		int lowerOfRole = ((MultiplicityElement) end.getRole()).getLower();
		if (lowerOfRole == 0) {
			return 0;
		} else if (end.getPartWithPort() == null) {
			return lowerOfRole;
		} else {
			int lowerOfPart = end.getPartWithPort().getLower();
			return lowerOfRole * lowerOfPart;
		}
	}


	public boolean isArrayPattern(Connector c) {
		// This is an array pattern if:
		// - c is binary
		// - lower bound of the two connector ends is 1
		// - Cardinality of ends are equals
		if (c.getEnds().size() == 2) {
			if (c.getEnds().get(0).getLower() == 1) {
				if (c.getEnds().get(1).getLower() == 1) {
					if (this.canInstantiate((Property) c.getEnds().get(0).getRole()) && this.canInstantiate((Property) c.getEnds().get(1).getRole())) {
						int cardinality1 = this.getCardinality(c.getEnds().get(0));
						int cardinality2 = this.getCardinality(c.getEnds().get(1));
						return cardinality1 == cardinality2;
					}
				}
			}
		}
		return false;
	}


	public boolean isStarPattern(Connector c) {
		// This is an array pattern if:
		// - c is binary
		// - lower bound of end1 equals cardinality of end1
		// - lower bound of end2 equals cardinality of end2
		if (c.getEnds().size() == 2) {
			if (this.canInstantiate((Property) c.getEnds().get(0).getRole()) && this.canInstantiate((Property) c.getEnds().get(1).getRole())) {
				int cardinalityOfEnd1 = this.getCardinality(c.getEnds().get(0));
				int lowerBoundofEnd1 = c.getEnds().get(0).getLower();
				if (cardinalityOfEnd1 == lowerBoundofEnd1) {
					int cardinalityOfEnd2 = this.getCardinality(c.getEnds().get(1));
					int lowerBoundofEnd2 = c.getEnds().get(1).getLower();
					return cardinalityOfEnd2 == lowerBoundofEnd2;
				}
			}
		}
		return false;
	}

	public Association defaultAssociation;

	public Association getDefaultAssociation() {
		// Computes an returns an Association with two untyped owned ends,
		// with multiplicity [*].
		// This association can be used to type links instantiated from untyped connectors
		if (defaultAssociation == null) {
			defaultAssociation = UMLFactory.eINSTANCE.createAssociation();
			defaultAssociation.setName("DefaultGeneratedAssociation");
			Property end1 = defaultAssociation.createOwnedEnd("x", null);
			end1.setLower(0);
			end1.setUpper(-1);
			end1.setIsOrdered(true);
			end1.setIsUnique(true);
			Property end2 = defaultAssociation.createOwnedEnd("y", null);
			end2.setLower(0);
			end2.setUpper(-1);
			end2.setIsOrdered(true);
			end2.setIsUnique(true);
		}
		return defaultAssociation;
	}

	public IObject_ instantiateInterface(Interface interface_, ILocus locus) {
		Class realizingClass = this.getRealizingClass(interface_);
		IObject_ object = locus.instantiate(realizingClass);
		return object;
	}

	public List<Class> generatedRealizingClasses = new ArrayList<Class>();

	public Class getRealizingClass(Interface interface_) {
		Class realizingClass = null;
		// TODO For cached RealizingClasses, search based on InterfaceRealizations rather than name
		String realizingClassName = interface_.getQualifiedName() + "GeneratedRealizingClass";
		int i = 1;
		while (i <= generatedRealizingClasses.size() && realizingClass == null) {
			Class cddRealizingClass = generatedRealizingClasses.get(i - 1);
			if (cddRealizingClass.getName().equals(realizingClassName)) {
				realizingClass = cddRealizingClass;
			}
			i = i + 1;
		}
		if (realizingClass == null) {
			realizingClass = this.generateRealizingClass(interface_, realizingClassName);
			generatedRealizingClasses.add(realizingClass);
		}
		return realizingClass;
	}

	public Class generateRealizingClass(Interface interface_, String className) {
		Class realizingClass = UMLFactory.eINSTANCE.createClass();
		realizingClass.setName(className);
		realizingClass.createInterfaceRealization("", interface_);
		// TODO Deal with structural features of the interface
		// TODO Make a test case for reading/writing structural features of an interface
		return realizingClass;
	}

}
