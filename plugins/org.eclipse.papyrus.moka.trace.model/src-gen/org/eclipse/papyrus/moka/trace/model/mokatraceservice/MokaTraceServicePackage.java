/**
 * Copyright (c) 2019 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *   CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.moka.trace.model.mokatraceservice;

import org.eclipse.emf.ecore.EClass;
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
 * @see org.eclipse.papyrus.moka.trace.model.mokatraceservice.MokaTraceServiceFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='MokaTraceService'"
 * @generated
 */
public interface MokaTraceServicePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mokatraceservice";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/moka/trace";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "MokaTraceService";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MokaTraceServicePackage eINSTANCE = org.eclipse.papyrus.moka.trace.model.mokatraceservice.impl.MokaTraceServicePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.trace.model.mokatraceservice.impl.MokaTraceImpl <em>Moka Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.trace.model.mokatraceservice.impl.MokaTraceImpl
	 * @see org.eclipse.papyrus.moka.trace.model.mokatraceservice.impl.MokaTraceServicePackageImpl#getMokaTrace()
	 * @generated
	 */
	int MOKA_TRACE = 0;

	/**
	 * The number of structural features of the '<em>Moka Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOKA_TRACE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Moka Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOKA_TRACE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.trace.model.mokatraceservice.MokaTrace <em>Moka Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Moka Trace</em>'.
	 * @see org.eclipse.papyrus.moka.trace.model.mokatraceservice.MokaTrace
	 * @generated
	 */
	EClass getMokaTrace();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MokaTraceServiceFactory getMokaTraceServiceFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.trace.model.mokatraceservice.impl.MokaTraceImpl <em>Moka Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.trace.model.mokatraceservice.impl.MokaTraceImpl
		 * @see org.eclipse.papyrus.moka.trace.model.mokatraceservice.impl.MokaTraceServicePackageImpl#getMokaTrace()
		 * @generated
		 */
		EClass MOKA_TRACE = eINSTANCE.getMokaTrace();

	}

} //MokaTraceServicePackage
