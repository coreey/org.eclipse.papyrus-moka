/*****************************************************************************
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
 *  CEA LIST - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.moka.modeling.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Class ;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * A utility class for the generation of an instance specification tree
 *
 */
public class InstanceSpecificationGeneratorUtil {

	/**
	 * The container for the generated instance specifications
	 */
	protected Package rootContainer ;
	
	/**
	 * An index map used for the generation of unique instance names
	 */
	protected Map<Classifier, Integer> indexes = new HashMap<Classifier, Integer>() ;

	/**
	 * Constructor
	 * 
	 * @param rootContainer The root container for the generated instances
	 */
	public InstanceSpecificationGeneratorUtil(Package rootContainer) {
		super();
		this.rootContainer = rootContainer;
	}

	/**
	 * Generates a tree of instance specification, where the root of the tree is typed by the given classifier.
	 * Instances can be generated recursively if the given classifier owns composite parts which are typed by a Class.
	 * All instance specifications are generated inside the package given as an argument of the constructor.
	 * For a given property of the classifier, a slot is generated only if canGenerateSlot returns true.
	 * For a given slot, a value is generated only if canGenerateNewValue returns true.
	 * 
	 * @param classifier The type of the root instance specification to be generated
	 * @return The root instance specification generated
	 */
	public InstanceSpecification generateInstanceSpecification(Classifier classifier) {
		return generateInstanceSpecification(classifier, new ArrayList<Classifier>()) ;
	}
	
	/**
	 * See generateInstanceSpecification(Classifier classifier).
	 * 
	 * @param classifier The type of the root instance specification to be generated
	 * @param visited A list of "visited" classifiers, completed at each recursive call, to avoid infinite recursions
	 * @return The root instance specification generated
	 */
	protected InstanceSpecification generateInstanceSpecification(Classifier classifier, List<Classifier> visited) {
		visited.add(classifier) ;
		String instanceSpecName = this.generateInstanceName(classifier) ;
		InstanceSpecification instanceSpec = (InstanceSpecification)this.rootContainer.createPackagedElement(instanceSpecName, UMLPackage.eINSTANCE.getInstanceSpecification()) ;
		instanceSpec.getClassifiers().add(classifier) ;
		for (Property p : classifier.getAllAttributes()) {
			if (this.canGenerateSlot(classifier, p)) {
				Slot slot = instanceSpec.createSlot() ;
				slot.setDefiningFeature(p);
				if (p.getDefaultValue() != null) {
					ValueSpecification v = p.getDefaultValue() ;
					ValueSpecification copy = EcoreUtil.copy(v) ;
					slot.getValues().add(copy) ;
					copy.setName("valueFor " + p.getName());
				}
				else {
					if (this.canGenerateNewValue(classifier, p)) {
						Type type = p.getType() ;
						if (type instanceof Enumeration || type instanceof PrimitiveType) {
							generateValueSpecification(slot) ;
						} 
						else {
							if (! visited.contains(type)) {
								List<Classifier> newVisited = new ArrayList<Classifier>() ;
								newVisited.addAll(visited) ;
								InstanceValue instanceValue = (InstanceValue)slot.createValue("valueFor " + p.getName(), type, UMLPackage.eINSTANCE.getInstanceValue());
								InstanceSpecification generatedInstanceSpec = this.generateInstanceSpecification((Classifier)p.getType(), newVisited) ;
								instanceValue.setInstance(generatedInstanceSpec);
							}
						}
					}
				}
			}
		}
		return instanceSpec ;
	}
	
	/**
	 * Generate and assign a value specification to a slot, in the case where the defining feature of the slot 
	 * is typed by an Enumeration or a PrimitiveType
	 * 
	 * @param slot
	 * @return The generated value specification, which has been assigned to the given slot
	 */
	protected ValueSpecification generateValueSpecification(Slot slot) {
		Property p = (Property)slot.getDefiningFeature() ;
		Type type = p.getType() ;
		ValueSpecification v = null ;
		if (type instanceof Enumeration) {
			v = slot.createValue("valueFor " + p.getName(), type, UMLPackage.eINSTANCE.getInstanceValue());
		}
		else if (type instanceof PrimitiveType) {
			String name = "" + type.getName() ;
			if (name.equals("Integer")) {
				v = slot.createValue("valueFor " + p.getName(), type, UMLPackage.eINSTANCE.getLiteralInteger());
			} else if (name.equals("Boolean")) { //$NON-NLS-1$
				v = slot.createValue("valueFor " + p.getName(), type, UMLPackage.eINSTANCE.getLiteralBoolean());
			} else if (name.equals("Real")) { //$NON-NLS-1$
				v = slot.createValue("valueFor " + p.getName(), type, UMLPackage.eINSTANCE.getLiteralReal());
			} else if (name.equals("String")){
				v = slot.createValue("valueFor " + p.getName(), type, UMLPackage.eINSTANCE.getLiteralString());
			}
		}
		return v ;
	}
	
	/**
	 * Generate an instance name, based on a given classifier
	 * 
	 * @param classifier
	 * @return The generated instance name
	 */
	protected String generateInstanceName(Classifier classifier) {
		int index = 0;
		if (this.indexes.get(classifier) == null) {
			index = 1 ;
		}
		this.indexes.put(classifier, index + 1) ;
		return "" + classifier.getName().toLowerCase() + " " + index;
	}

	/**
	 * Determines if it is allowed to generate a slot for the given property.
	 * It always returns true, but it can be overridden by clients.
	 * 
	 * @param contextClassifier
	 * @param property
	 * @return always true (but can be overridden by clients)
	 */
	protected boolean canGenerateSlot(Classifier contextClassifier, Property property) {
		return true ;
	}

	/**
	 * Determines if it is allowed to generate a value for the given property.
	 * If the property is typed by a class, it returns true if the property is composite.
	 * If the property is not typed by a class, it returns true.
	 * It returns false only if the property is not typed.
	 * 
	 * @param contextClassifier
	 * @param property
	 * @return true if it is allowed to generate a value for the given property, false otherwise
	 */
	protected boolean canGenerateNewValue(Classifier contextClassifier, Property property) {
		if (property.getType() != null) {
			if (property.getType() instanceof Class) {
				return property.isComposite() ;
			}
			return true ;
		}
		return false ;
	}
	
}
