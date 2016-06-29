/**
 * Copyright (c) 2016 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *   CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.moka.fmi.fmiprofile;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.moka.fmi.modeldescription.Fmi2ScalarVariable;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scalar Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable#getBase_Property <em>Base Property</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable#getVariability <em>Variability</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable#getInitial <em>Initial</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable#getValueReference <em>Value Reference</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable#getFmiVariable <em>Fmi Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getScalarVariable()
 * @model abstract="true"
 * @generated
 */
public interface ScalarVariable extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Property</em>' reference.
	 * @see #setBase_Property(Property)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getScalarVariable_Base_Property()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Property getBase_Property();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable#getBase_Property <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Property</em>' reference.
	 * @see #getBase_Property()
	 * @generated
	 */
	void setBase_Property(Property value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getScalarVariable_Description()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Variability</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.moka.fmi.fmiprofile.VariabilityKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variability</em>' attribute.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.VariabilityKind
	 * @see #setVariability(VariabilityKind)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getScalarVariable_Variability()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	VariabilityKind getVariability();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable#getVariability <em>Variability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variability</em>' attribute.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.VariabilityKind
	 * @see #getVariability()
	 * @generated
	 */
	void setVariability(VariabilityKind value);

	/**
	 * Returns the value of the '<em><b>Initial</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.moka.fmi.fmiprofile.InitialKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial</em>' attribute.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.InitialKind
	 * @see #setInitial(InitialKind)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getScalarVariable_Initial()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	InitialKind getInitial();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable#getInitial <em>Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial</em>' attribute.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.InitialKind
	 * @see #getInitial()
	 * @generated
	 */
	void setInitial(InitialKind value);

	/**
	 * Returns the value of the '<em><b>Value Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Reference</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Reference</em>' attribute.
	 * @see #setValueReference(int)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getScalarVariable_ValueReference()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getValueReference();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable#getValueReference <em>Value Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Reference</em>' attribute.
	 * @see #getValueReference()
	 * @generated
	 */
	void setValueReference(int value);

	/**
	 * Returns the value of the '<em><b>Fmi Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fmi Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fmi Variable</em>' reference.
	 * @see #setFmiVariable(Fmi2ScalarVariable)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getScalarVariable_FmiVariable()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Fmi2ScalarVariable getFmiVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable#getFmiVariable <em>Fmi Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fmi Variable</em>' reference.
	 * @see #getFmiVariable()
	 * @generated
	 */
	void setFmiVariable(Fmi2ScalarVariable value);

} // ScalarVariable
