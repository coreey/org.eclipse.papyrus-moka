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
 * A representation of the model object '<em><b>Fmi2 Simple Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Type attributes of a scalar variable
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType#getReal <em>Real</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType#getInteger <em>Integer</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType#getBoolean <em>Boolean</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType#getString <em>String</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType#getEnumeration <em>Enumeration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getFmi2SimpleType()
 * @model extendedMetaData="name='fmi2SimpleType' kind='elementOnly'"
 * @generated
 */
public interface Fmi2SimpleType extends EObject {
	/**
	 * Returns the value of the '<em><b>Real</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Real</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Real</em>' containment reference.
	 * @see #setReal(RealType1)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getFmi2SimpleType_Real()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Real' namespace='##targetNamespace'"
	 * @generated
	 */
	RealType1 getReal();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType#getReal <em>Real</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Real</em>' containment reference.
	 * @see #getReal()
	 * @generated
	 */
	void setReal(RealType1 value);

	/**
	 * Returns the value of the '<em><b>Integer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Integer</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Integer</em>' containment reference.
	 * @see #setInteger(IntegerType1)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getFmi2SimpleType_Integer()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Integer' namespace='##targetNamespace'"
	 * @generated
	 */
	IntegerType1 getInteger();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType#getInteger <em>Integer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Integer</em>' containment reference.
	 * @see #getInteger()
	 * @generated
	 */
	void setInteger(IntegerType1 value);

	/**
	 * Returns the value of the '<em><b>Boolean</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boolean</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boolean</em>' containment reference.
	 * @see #setBoolean(EObject)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getFmi2SimpleType_Boolean()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Boolean' namespace='##targetNamespace'"
	 * @generated
	 */
	EObject getBoolean();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType#getBoolean <em>Boolean</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boolean</em>' containment reference.
	 * @see #getBoolean()
	 * @generated
	 */
	void setBoolean(EObject value);

	/**
	 * Returns the value of the '<em><b>String</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String</em>' containment reference.
	 * @see #setString(EObject)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getFmi2SimpleType_String()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='String' namespace='##targetNamespace'"
	 * @generated
	 */
	EObject getString();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType#getString <em>String</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String</em>' containment reference.
	 * @see #getString()
	 * @generated
	 */
	void setString(EObject value);

	/**
	 * Returns the value of the '<em><b>Enumeration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumeration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumeration</em>' containment reference.
	 * @see #setEnumeration(EnumerationType1)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getFmi2SimpleType_Enumeration()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Enumeration' namespace='##targetNamespace'"
	 * @generated
	 */
	EnumerationType1 getEnumeration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType#getEnumeration <em>Enumeration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enumeration</em>' containment reference.
	 * @see #getEnumeration()
	 * @generated
	 */
	void setEnumeration(EnumerationType1 value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Description of the SimpleType
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getFmi2SimpleType_Description()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='description' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name of SimpleType element. "name" must be unique with respect to all other elements of the TypeDefinitions list. Furthermore,  "name" of a SimpleType must be different to all "name"s of ScalarVariable.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage#getFmi2SimpleType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NormalizedString" required="true"
	 *        extendedMetaData="kind='attribute' name='name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2SimpleType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Fmi2SimpleType
