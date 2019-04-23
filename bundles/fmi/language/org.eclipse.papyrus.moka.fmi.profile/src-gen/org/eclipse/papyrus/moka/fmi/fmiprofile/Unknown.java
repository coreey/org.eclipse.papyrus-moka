/**
 * Copyright (c) 2016 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *   CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.moka.fmi.fmiprofile;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unknown</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.Unknown#getBase_Property <em>Base Property</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.Unknown#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.Unknown#getDependenciesKind <em>Dependencies Kind</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getUnknown()
 * @model
 * @generated
 */
public interface Unknown extends EObject {
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
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getUnknown_Base_Property()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Property getBase_Property();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.Unknown#getBase_Property <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Property</em>' reference.
	 * @see #getBase_Property()
	 * @generated
	 */
	void setBase_Property(Property value);

	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' attribute.
	 * @see #setDependencies(String)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getUnknown_Dependencies()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getDependencies();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.Unknown#getDependencies <em>Dependencies</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependencies</em>' attribute.
	 * @see #getDependencies()
	 * @generated
	 */
	void setDependencies(String value);

	/**
	 * Returns the value of the '<em><b>Dependencies Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies Kind</em>' attribute.
	 * @see #setDependenciesKind(String)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getUnknown_DependenciesKind()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getDependenciesKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.Unknown#getDependenciesKind <em>Dependencies Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependencies Kind</em>' attribute.
	 * @see #getDependenciesKind()
	 * @generated
	 */
	void setDependenciesKind(String value);

} // Unknown
