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
 * A representation of the model object '<em><b>Boolean Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.BooleanType#getDeclaredType <em>Declared Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.BooleanType#isStart <em>Start</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getBooleanType()
 * @model extendedMetaData="name='Boolean_._type' kind='empty'"
 * @generated
 */
public interface BooleanType extends EObject {
	/**
	 * Returns the value of the '<em><b>Declared Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If present, name of type defined with TypeDefinitions / SimpleType providing defaults.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Declared Type</em>' attribute.
	 * @see #setDeclaredType(String)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getBooleanType_DeclaredType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NormalizedString"
	 *        extendedMetaData="kind='attribute' name='declaredType' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDeclaredType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BooleanType#getDeclaredType <em>Declared Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declared Type</em>' attribute.
	 * @see #getDeclaredType()
	 * @generated
	 */
	void setDeclaredType(String value);

	/**
	 * Returns the value of the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Value before initialization, if initial=exact or approx
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Start</em>' attribute.
	 * @see #isSetStart()
	 * @see #unsetStart()
	 * @see #setStart(boolean)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getBooleanType_Start()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='start' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isStart();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BooleanType#isStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' attribute.
	 * @see #isSetStart()
	 * @see #unsetStart()
	 * @see #isStart()
	 * @generated
	 */
	void setStart(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BooleanType#isStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStart()
	 * @see #isStart()
	 * @see #setStart(boolean)
	 * @generated
	 */
	void unsetStart();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.BooleanType#isStart <em>Start</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Start</em>' attribute is set.
	 * @see #unsetStart()
	 * @see #isStart()
	 * @see #setStart(boolean)
	 * @generated
	 */
	boolean isSetStart();

} // BooleanType
