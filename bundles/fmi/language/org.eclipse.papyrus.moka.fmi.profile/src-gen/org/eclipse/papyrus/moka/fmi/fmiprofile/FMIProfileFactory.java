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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage
 * @generated
 */
public interface FMIProfileFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FMIProfileFactory eINSTANCE = org.eclipse.papyrus.moka.fmi.fmiprofile.impl.FMIProfileFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>FMU</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FMU</em>'.
	 * @generated
	 */
	FMU createFMU();

	/**
	 * Returns a new object of class '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter</em>'.
	 * @generated
	 */
	Parameter createParameter();

	/**
	 * Returns a new object of class '<em>Local</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Local</em>'.
	 * @generated
	 */
	Local createLocal();

	/**
	 * Returns a new object of class '<em>CS FMU</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CS FMU</em>'.
	 * @generated
	 */
	CS_FMU createCS_FMU();

	/**
	 * Returns a new object of class '<em>ME FMU</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ME FMU</em>'.
	 * @generated
	 */
	ME_FMU createME_FMU();

	/**
	 * Returns a new object of class '<em>FMI Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FMI Port</em>'.
	 * @generated
	 */
	FMIPort createFMIPort();

	/**
	 * Returns a new object of class '<em>Independent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Independent</em>'.
	 * @generated
	 */
	Independent createIndependent();

	/**
	 * Returns a new object of class '<em>Unknown</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unknown</em>'.
	 * @generated
	 */
	Unknown createUnknown();

	/**
	 * Returns a new object of class '<em>Output Unknown</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Unknown</em>'.
	 * @generated
	 */
	OutputUnknown createOutputUnknown();

	/**
	 * Returns a new object of class '<em>Initial Unknown</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Initial Unknown</em>'.
	 * @generated
	 */
	InitialUnknown createInitialUnknown();

	/**
	 * Returns a new object of class '<em>Derivative Unknown</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Derivative Unknown</em>'.
	 * @generated
	 */
	DerivativeUnknown createDerivativeUnknown();

	/**
	 * Returns a new object of class '<em>CS Graph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CS Graph</em>'.
	 * @generated
	 */
	CS_Graph createCS_Graph();

	/**
	 * Returns a new object of class '<em>Derivative Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Derivative Dependency</em>'.
	 * @generated
	 */
	DerivativeDependency createDerivativeDependency();

	/**
	 * Returns a new object of class '<em>Output Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Dependency</em>'.
	 * @generated
	 */
	OutputDependency createOutputDependency();

	/**
	 * Returns a new object of class '<em>Initial Unknown Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Initial Unknown Dependency</em>'.
	 * @generated
	 */
	InitialUnknownDependency createInitialUnknownDependency();

	/**
	 * Returns a new object of class '<em>Calculated Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Calculated Parameter</em>'.
	 * @generated
	 */
	CalculatedParameter createCalculatedParameter();

	/**
	 * Returns a new object of class '<em>Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port</em>'.
	 * @generated
	 */
	Port createPort();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	FMIProfilePackage getFMIProfilePackage();

} //FMIProfileFactory
