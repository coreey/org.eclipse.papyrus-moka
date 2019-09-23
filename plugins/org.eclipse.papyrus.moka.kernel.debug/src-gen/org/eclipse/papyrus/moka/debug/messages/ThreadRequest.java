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

import org.eclipse.papyrus.moka.kernel.SuspensionReasons;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Thread Request</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.debug.messages.ThreadRequest#getThreadId <em>Thread Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.debug.messages.ThreadRequest#getSuspensionPoint <em>Suspension Point</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.debug.messages.ThreadRequest#getSuspensionReason <em>Suspension Reason</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.debug.messages.MessagesPackage#getThreadRequest()
 * @model
 * @generated
 */
public interface ThreadRequest extends DebugRequest {
	/**
	 * Returns the value of the '<em><b>Thread Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thread Id</em>' attribute.
	 * @see #setThreadId(String)
	 * @see org.eclipse.papyrus.moka.debug.messages.MessagesPackage#getThreadRequest_ThreadId()
	 * @model
	 * @generated
	 */
	String getThreadId();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.debug.messages.ThreadRequest#getThreadId <em>Thread Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thread Id</em>' attribute.
	 * @see #getThreadId()
	 * @generated
	 */
	void setThreadId(String value);

	/**
	 * Returns the value of the '<em><b>Suspension Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suspension Point</em>' attribute.
	 * @see #setSuspensionPoint(int)
	 * @see org.eclipse.papyrus.moka.debug.messages.MessagesPackage#getThreadRequest_SuspensionPoint()
	 * @model
	 * @generated
	 */
	int getSuspensionPoint();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.debug.messages.ThreadRequest#getSuspensionPoint <em>Suspension Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suspension Point</em>' attribute.
	 * @see #getSuspensionPoint()
	 * @generated
	 */
	void setSuspensionPoint(int value);

	/**
	 * Returns the value of the '<em><b>Suspension Reason</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.moka.kernel.SuspensionReasons}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suspension Reason</em>' attribute.
	 * @see org.eclipse.papyrus.moka.kernel.SuspensionReasons
	 * @see #setSuspensionReason(SuspensionReasons)
	 * @see org.eclipse.papyrus.moka.debug.messages.MessagesPackage#getThreadRequest_SuspensionReason()
	 * @model
	 * @generated
	 */
	SuspensionReasons getSuspensionReason();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.debug.messages.ThreadRequest#getSuspensionReason <em>Suspension Reason</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suspension Reason</em>' attribute.
	 * @see org.eclipse.papyrus.moka.kernel.SuspensionReasons
	 * @see #getSuspensionReason()
	 * @generated
	 */
	void setSuspensionReason(SuspensionReasons value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String toJson();

} // ThreadRequest
