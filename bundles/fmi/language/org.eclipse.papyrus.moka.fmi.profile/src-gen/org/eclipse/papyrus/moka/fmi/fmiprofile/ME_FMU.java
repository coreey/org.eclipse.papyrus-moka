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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ME FMU</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmiprofile.ME_FMU#isCompletedIntegratorStepNotNeeded <em>Completed Integrator Step Not Needed</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getME_FMU()
 * @model
 * @generated
 */
public interface ME_FMU extends FMU {
	/**
	 * Returns the value of the '<em><b>Completed Integrator Step Not Needed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Completed Integrator Step Not Needed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Completed Integrator Step Not Needed</em>' attribute.
	 * @see #setCompletedIntegratorStepNotNeeded(boolean)
	 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage#getME_FMU_CompletedIntegratorStepNotNeeded()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isCompletedIntegratorStepNotNeeded();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmiprofile.ME_FMU#isCompletedIntegratorStepNotNeeded <em>Completed Integrator Step Not Needed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Completed Integrator Step Not Needed</em>' attribute.
	 * @see #isCompletedIntegratorStepNotNeeded()
	 * @generated
	 */
	void setCompletedIntegratorStepNotNeeded(boolean value);

} // ME_FMU
