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
package org.eclipse.papyrus.moka.debug.messages;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
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
 * @see org.eclipse.papyrus.moka.debug.messages.MessagesFactory
 * @model kind="package"
 * @generated
 */
public interface MessagesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "org.eclipse.papyrus.moka.debug.messages";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "Debug";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Debug";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MessagesPackage eINSTANCE = org.eclipse.papyrus.moka.debug.messages.impl.MessagesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.debug.messages.impl.DebugRequestImpl <em>Debug Request</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.debug.messages.impl.DebugRequestImpl
	 * @see org.eclipse.papyrus.moka.debug.messages.impl.MessagesPackageImpl#getDebugRequest()
	 * @generated
	 */
	int DEBUG_REQUEST = 1;

	/**
	 * The feature id for the '<em><b>Event Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_REQUEST__EVENT_KIND = 0;

	/**
	 * The feature id for the '<em><b>Event Detail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_REQUEST__EVENT_DETAIL = 1;

	/**
	 * The feature id for the '<em><b>Context Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_REQUEST__CONTEXT_KIND = 2;

	/**
	 * The number of structural features of the '<em>Debug Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_REQUEST_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>To Json</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_REQUEST___TO_JSON = 0;

	/**
	 * The number of operations of the '<em>Debug Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBUG_REQUEST_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.debug.messages.impl.ThreadRequestImpl <em>Thread Request</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.debug.messages.impl.ThreadRequestImpl
	 * @see org.eclipse.papyrus.moka.debug.messages.impl.MessagesPackageImpl#getThreadRequest()
	 * @generated
	 */
	int THREAD_REQUEST = 0;

	/**
	 * The feature id for the '<em><b>Event Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD_REQUEST__EVENT_KIND = DEBUG_REQUEST__EVENT_KIND;

	/**
	 * The feature id for the '<em><b>Event Detail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD_REQUEST__EVENT_DETAIL = DEBUG_REQUEST__EVENT_DETAIL;

	/**
	 * The feature id for the '<em><b>Context Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD_REQUEST__CONTEXT_KIND = DEBUG_REQUEST__CONTEXT_KIND;

	/**
	 * The feature id for the '<em><b>Thread Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD_REQUEST__THREAD_ID = DEBUG_REQUEST_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Suspension Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD_REQUEST__SUSPENSION_POINT = DEBUG_REQUEST_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Suspension Reason</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD_REQUEST__SUSPENSION_REASON = DEBUG_REQUEST_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Thread Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD_REQUEST_FEATURE_COUNT = DEBUG_REQUEST_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>To Json</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD_REQUEST___TO_JSON = DEBUG_REQUEST_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Thread Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD_REQUEST_OPERATION_COUNT = DEBUG_REQUEST_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.debug.messages.DebugEventContextKind <em>Debug Event Context Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.debug.messages.DebugEventContextKind
	 * @see org.eclipse.papyrus.moka.debug.messages.impl.MessagesPackageImpl#getDebugEventContextKind()
	 * @generated
	 */
	int DEBUG_EVENT_CONTEXT_KIND = 2;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.debug.messages.ThreadRequest <em>Thread Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Thread Request</em>'.
	 * @see org.eclipse.papyrus.moka.debug.messages.ThreadRequest
	 * @generated
	 */
	EClass getThreadRequest();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.debug.messages.ThreadRequest#getThreadId <em>Thread Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thread Id</em>'.
	 * @see org.eclipse.papyrus.moka.debug.messages.ThreadRequest#getThreadId()
	 * @see #getThreadRequest()
	 * @generated
	 */
	EAttribute getThreadRequest_ThreadId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.debug.messages.ThreadRequest#getSuspensionPoint <em>Suspension Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Suspension Point</em>'.
	 * @see org.eclipse.papyrus.moka.debug.messages.ThreadRequest#getSuspensionPoint()
	 * @see #getThreadRequest()
	 * @generated
	 */
	EAttribute getThreadRequest_SuspensionPoint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.debug.messages.ThreadRequest#getSuspensionReason <em>Suspension Reason</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Suspension Reason</em>'.
	 * @see org.eclipse.papyrus.moka.debug.messages.ThreadRequest#getSuspensionReason()
	 * @see #getThreadRequest()
	 * @generated
	 */
	EAttribute getThreadRequest_SuspensionReason();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.moka.debug.messages.ThreadRequest#toJson() <em>To Json</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To Json</em>' operation.
	 * @see org.eclipse.papyrus.moka.debug.messages.ThreadRequest#toJson()
	 * @generated
	 */
	EOperation getThreadRequest__ToJson();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.debug.messages.DebugRequest <em>Debug Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Debug Request</em>'.
	 * @see org.eclipse.papyrus.moka.debug.messages.DebugRequest
	 * @generated
	 */
	EClass getDebugRequest();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.debug.messages.DebugRequest#getEventKind <em>Event Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event Kind</em>'.
	 * @see org.eclipse.papyrus.moka.debug.messages.DebugRequest#getEventKind()
	 * @see #getDebugRequest()
	 * @generated
	 */
	EAttribute getDebugRequest_EventKind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.debug.messages.DebugRequest#getEventDetail <em>Event Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event Detail</em>'.
	 * @see org.eclipse.papyrus.moka.debug.messages.DebugRequest#getEventDetail()
	 * @see #getDebugRequest()
	 * @generated
	 */
	EAttribute getDebugRequest_EventDetail();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.debug.messages.DebugRequest#getContextKind <em>Context Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Context Kind</em>'.
	 * @see org.eclipse.papyrus.moka.debug.messages.DebugRequest#getContextKind()
	 * @see #getDebugRequest()
	 * @generated
	 */
	EAttribute getDebugRequest_ContextKind();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.moka.debug.messages.DebugRequest#toJson() <em>To Json</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>To Json</em>' operation.
	 * @see org.eclipse.papyrus.moka.debug.messages.DebugRequest#toJson()
	 * @generated
	 */
	EOperation getDebugRequest__ToJson();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.moka.debug.messages.DebugEventContextKind <em>Debug Event Context Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Debug Event Context Kind</em>'.
	 * @see org.eclipse.papyrus.moka.debug.messages.DebugEventContextKind
	 * @generated
	 */
	EEnum getDebugEventContextKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MessagesFactory getMessagesFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.debug.messages.impl.ThreadRequestImpl <em>Thread Request</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.debug.messages.impl.ThreadRequestImpl
		 * @see org.eclipse.papyrus.moka.debug.messages.impl.MessagesPackageImpl#getThreadRequest()
		 * @generated
		 */
		EClass THREAD_REQUEST = eINSTANCE.getThreadRequest();

		/**
		 * The meta object literal for the '<em><b>Thread Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THREAD_REQUEST__THREAD_ID = eINSTANCE.getThreadRequest_ThreadId();

		/**
		 * The meta object literal for the '<em><b>Suspension Point</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THREAD_REQUEST__SUSPENSION_POINT = eINSTANCE.getThreadRequest_SuspensionPoint();

		/**
		 * The meta object literal for the '<em><b>Suspension Reason</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THREAD_REQUEST__SUSPENSION_REASON = eINSTANCE.getThreadRequest_SuspensionReason();

		/**
		 * The meta object literal for the '<em><b>To Json</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation THREAD_REQUEST___TO_JSON = eINSTANCE.getThreadRequest__ToJson();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.debug.messages.impl.DebugRequestImpl <em>Debug Request</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.debug.messages.impl.DebugRequestImpl
		 * @see org.eclipse.papyrus.moka.debug.messages.impl.MessagesPackageImpl#getDebugRequest()
		 * @generated
		 */
		EClass DEBUG_REQUEST = eINSTANCE.getDebugRequest();

		/**
		 * The meta object literal for the '<em><b>Event Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_REQUEST__EVENT_KIND = eINSTANCE.getDebugRequest_EventKind();

		/**
		 * The meta object literal for the '<em><b>Event Detail</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_REQUEST__EVENT_DETAIL = eINSTANCE.getDebugRequest_EventDetail();

		/**
		 * The meta object literal for the '<em><b>Context Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBUG_REQUEST__CONTEXT_KIND = eINSTANCE.getDebugRequest_ContextKind();

		/**
		 * The meta object literal for the '<em><b>To Json</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DEBUG_REQUEST___TO_JSON = eINSTANCE.getDebugRequest__ToJson();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.debug.messages.DebugEventContextKind <em>Debug Event Context Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.debug.messages.DebugEventContextKind
		 * @see org.eclipse.papyrus.moka.debug.messages.impl.MessagesPackageImpl#getDebugEventContextKind()
		 * @generated
		 */
		EEnum DEBUG_EVENT_CONTEXT_KIND = eINSTANCE.getDebugEventContextKind();

	}

} //MessagesPackage
