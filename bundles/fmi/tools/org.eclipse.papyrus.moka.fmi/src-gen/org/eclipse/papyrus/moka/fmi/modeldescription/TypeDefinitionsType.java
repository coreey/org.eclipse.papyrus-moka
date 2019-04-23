/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.moka.fmi.modeldescription;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Definitions Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.TypeDefinitionsType#getGroup <em>Group</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.TypeDefinitionsType#getSimpleType <em>Simple Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getTypeDefinitionsType()
 * @model extendedMetaData="name='TypeDefinitions_._type' kind='elementOnly'"
 * @generated
 */
public interface TypeDefinitionsType extends EObject {
	/**
	 * Returns the value of the '<em><b>Group</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' attribute list.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getTypeDefinitionsType_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:0'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Simple Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Type</em>' containment reference list.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getTypeDefinitionsType_SimpleType()
	 * @model containment="true" required="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='SimpleType' namespace='##targetNamespace' group='group:0'"
	 * @generated
	 */
	EList<Fmi2SimpleType> getSimpleType();

} // TypeDefinitionsType
