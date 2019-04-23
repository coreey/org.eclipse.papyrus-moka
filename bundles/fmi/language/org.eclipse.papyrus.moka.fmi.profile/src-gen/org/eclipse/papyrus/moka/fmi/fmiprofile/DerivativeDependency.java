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

import org.eclipse.uml2.uml.Dependency;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Derivative Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.DerivativeDependency#getBase_Dependency <em>Base Dependency</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.DerivativeDependency#getDependencyKind <em>Dependency Kind</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getDerivativeDependency()
 * @model
 * @generated
 */
public interface DerivativeDependency extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Dependency</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Dependency</em>' reference.
	 * @see #setBase_Dependency(Dependency)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getDerivativeDependency_Base_Dependency()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Dependency getBase_Dependency();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.DerivativeDependency#getBase_Dependency <em>Base Dependency</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Dependency</em>' reference.
	 * @see #getBase_Dependency()
	 * @generated
	 */
	void setBase_Dependency(Dependency value);

	/**
	 * Returns the value of the '<em><b>Dependency Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.moka.fmi.fmiprofile.DependenciesKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependency Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependency Kind</em>' attribute.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.DependenciesKind
	 * @see #setDependencyKind(DependenciesKind)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getDerivativeDependency_DependencyKind()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DependenciesKind getDependencyKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.DerivativeDependency#getDependencyKind <em>Dependency Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependency Kind</em>' attribute.
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.DependenciesKind
	 * @see #getDependencyKind()
	 * @generated
	 */
	void setDependencyKind(DependenciesKind value);

} // DerivativeDependency
