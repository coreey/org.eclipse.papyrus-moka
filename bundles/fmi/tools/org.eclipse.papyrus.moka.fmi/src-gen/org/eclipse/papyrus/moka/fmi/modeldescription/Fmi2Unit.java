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
 * A representation of the model object '<em><b>Fmi2 Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Unit definition (with respect to SI base units) and default display units
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Unit#getBaseUnit <em>Base Unit</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Unit#getGroup <em>Group</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Unit#getDisplayUnit <em>Display Unit</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Unit#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getFmi2Unit()
 * @model extendedMetaData="name='fmi2Unit' kind='elementOnly'"
 * @generated
 */
public interface Fmi2Unit extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * BaseUnit_value = factor*Unit_value + offset
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Base Unit</em>' containment reference.
	 * @see #setBaseUnit(BaseUnitType)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getFmi2Unit_BaseUnit()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='BaseUnit' namespace='##targetNamespace'"
	 * @generated
	 */
	BaseUnitType getBaseUnit();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Unit#getBaseUnit <em>Base Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Unit</em>' containment reference.
	 * @see #getBaseUnit()
	 * @generated
	 */
	void setBaseUnit(BaseUnitType value);

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
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getFmi2Unit_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:1'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Display Unit</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.moka.fmi.modeldescription.DisplayUnitType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * DisplayUnit_value = factor*Unit_value + offset
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Display Unit</em>' containment reference list.
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getFmi2Unit_DisplayUnit()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='DisplayUnit' namespace='##targetNamespace' group='group:1'"
	 * @generated
	 */
	EList<DisplayUnitType> getDisplayUnit();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name of Unit element, e.g. "N.m", "Nm",  "%/s". "name" must be unique will respect to all other elements of the UnitDefinitions list. The variable values of fmi2SetXXX and fmi2GetXXX are with respect to this unit.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getFmi2Unit_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NormalizedString" required="true"
	 *        extendedMetaData="kind='attribute' name='name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2Unit#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Fmi2Unit
