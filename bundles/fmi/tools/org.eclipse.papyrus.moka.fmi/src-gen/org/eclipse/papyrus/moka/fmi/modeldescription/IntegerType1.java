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
 * A representation of the model object '<em><b>Integer Type1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType1#getMax <em>Max</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType1#getMin <em>Min</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType1#getQuantity <em>Quantity</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getIntegerType1()
 * @model extendedMetaData="name='Integer_._1_._type' kind='empty'"
 * @generated
 */
public interface IntegerType1 extends EObject {
	/**
	 * Returns the value of the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * max >= min required
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Max</em>' attribute.
	 * @see #isSetMax()
	 * @see #unsetMax()
	 * @see #setMax(int)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getIntegerType1_Max()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='max' namespace='##targetNamespace'"
	 * @generated
	 */
	int getMax();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType1#getMax <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max</em>' attribute.
	 * @see #isSetMax()
	 * @see #unsetMax()
	 * @see #getMax()
	 * @generated
	 */
	void setMax(int value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType1#getMax <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMax()
	 * @see #getMax()
	 * @see #setMax(int)
	 * @generated
	 */
	void unsetMax();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType1#getMax <em>Max</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Max</em>' attribute is set.
	 * @see #unsetMax()
	 * @see #getMax()
	 * @see #setMax(int)
	 * @generated
	 */
	boolean isSetMax();

	/**
	 * Returns the value of the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min</em>' attribute.
	 * @see #isSetMin()
	 * @see #unsetMin()
	 * @see #setMin(int)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getIntegerType1_Min()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='min' namespace='##targetNamespace'"
	 * @generated
	 */
	int getMin();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType1#getMin <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min</em>' attribute.
	 * @see #isSetMin()
	 * @see #unsetMin()
	 * @see #getMin()
	 * @generated
	 */
	void setMin(int value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType1#getMin <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMin()
	 * @see #getMin()
	 * @see #setMin(int)
	 * @generated
	 */
	void unsetMin();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType1#getMin <em>Min</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Min</em>' attribute is set.
	 * @see #unsetMin()
	 * @see #getMin()
	 * @see #setMin(int)
	 * @generated
	 */
	boolean isSetMin();

	/**
	 * Returns the value of the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quantity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quantity</em>' attribute.
	 * @see #setQuantity(String)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getIntegerType1_Quantity()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NormalizedString"
	 *        extendedMetaData="kind='attribute' name='quantity' namespace='##targetNamespace'"
	 * @generated
	 */
	String getQuantity();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.IntegerType1#getQuantity <em>Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quantity</em>' attribute.
	 * @see #getQuantity()
	 * @generated
	 */
	void setQuantity(String value);

} // IntegerType1
