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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Display Unit Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.DisplayUnitType#getFactor <em>Factor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.DisplayUnitType#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.DisplayUnitType#getOffset <em>Offset</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getDisplayUnitType()
 * @model extendedMetaData="name='DisplayUnit_._type' kind='empty'"
 * @generated
 */
public interface DisplayUnitType extends EObject {
	/**
	 * Returns the value of the '<em><b>Factor</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Factor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Factor</em>' attribute.
	 * @see #isSetFactor()
	 * @see #unsetFactor()
	 * @see #setFactor(double)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getDisplayUnitType_Factor()
	 * @model default="1" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='attribute' name='factor' namespace='##targetNamespace'"
	 * @generated
	 */
	double getFactor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DisplayUnitType#getFactor <em>Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Factor</em>' attribute.
	 * @see #isSetFactor()
	 * @see #unsetFactor()
	 * @see #getFactor()
	 * @generated
	 */
	void setFactor(double value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DisplayUnitType#getFactor <em>Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFactor()
	 * @see #getFactor()
	 * @see #setFactor(double)
	 * @generated
	 */
	void unsetFactor();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DisplayUnitType#getFactor <em>Factor</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Factor</em>' attribute is set.
	 * @see #unsetFactor()
	 * @see #getFactor()
	 * @see #setFactor(double)
	 * @generated
	 */
	boolean isSetFactor();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name of DisplayUnit element, e.g. <Unit name="rad"/>, <DisplayUnit factor="57.29..." name="deg"/>. "name" must be unique with respect to all other "names" of the DisplayUnit definitions of the same Unit (different Unit elements may have the same DisplayUnit names).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getDisplayUnitType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NormalizedString" required="true"
	 *        extendedMetaData="kind='attribute' name='name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DisplayUnitType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Offset</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset</em>' attribute.
	 * @see #isSetOffset()
	 * @see #unsetOffset()
	 * @see #setOffset(double)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getDisplayUnitType_Offset()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='attribute' name='offset' namespace='##targetNamespace'"
	 * @generated
	 */
	double getOffset();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DisplayUnitType#getOffset <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset</em>' attribute.
	 * @see #isSetOffset()
	 * @see #unsetOffset()
	 * @see #getOffset()
	 * @generated
	 */
	void setOffset(double value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DisplayUnitType#getOffset <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOffset()
	 * @see #getOffset()
	 * @see #setOffset(double)
	 * @generated
	 */
	void unsetOffset();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.DisplayUnitType#getOffset <em>Offset</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Offset</em>' attribute is set.
	 * @see #unsetOffset()
	 * @see #getOffset()
	 * @see #setOffset(double)
	 * @generated
	 */
	boolean isSetOffset();

} // DisplayUnitType
