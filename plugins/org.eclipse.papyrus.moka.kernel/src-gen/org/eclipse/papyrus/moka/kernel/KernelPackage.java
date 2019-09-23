/**
 * Copyright (c) 2019 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.moka.kernel;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.moka.kernel.KernelFactory
 * @model kind="package"
 * @generated
 */
public interface KernelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "kernel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "Kernel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Kernel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	KernelPackage eINSTANCE = org.eclipse.papyrus.moka.kernel.impl.KernelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.kernel.SuspensionReasons <em>Suspension Reasons</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.kernel.SuspensionReasons
	 * @see org.eclipse.papyrus.moka.kernel.impl.KernelPackageImpl#getSuspensionReasons()
	 * @generated
	 */
	int SUSPENSION_REASONS = 0;


	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.moka.kernel.SuspensionReasons <em>Suspension Reasons</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Suspension Reasons</em>'.
	 * @see org.eclipse.papyrus.moka.kernel.SuspensionReasons
	 * @generated
	 */
	EEnum getSuspensionReasons();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	KernelFactory getKernelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.kernel.SuspensionReasons <em>Suspension Reasons</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.kernel.SuspensionReasons
		 * @see org.eclipse.papyrus.moka.kernel.impl.KernelPackageImpl#getSuspensionReasons()
		 * @generated
		 */
		EEnum SUSPENSION_REASONS = eINSTANCE.getSuspensionReasons();

	}

} //KernelPackage
