/**
 *  Copyright (c) 2018,  IncQuery Labs Ltd and CEA List.
 *  All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *  IncQuery Labs Ltd - initial API and implementation
 *  CEA List 
 */
package org.eclipse.papyrus.moka.ssp.profile;

import org.eclipse.papyrus.sysml14.deprecatedelements.FlowPort;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ssd Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.profile.SsdConnector#getSSDDescription <em>SSD Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.profile.SsdConnector#getTypeKind <em>Type Kind</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.ssp.profile.SSPProfilePackage#getSsdConnector()
 * @model
 * @generated
 */
public interface SsdConnector extends FlowPort {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " Copyright (c) 2018,  IncQuery Labs Ltd and CEA List.\n All rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License 2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0 \r\n\r\nSPDX-License-Identifier: EPL-2.0\n \nContributors:\n IncQuery Labs Ltd - initial API and implementation\n CEA List ";

	/**
	 * Returns the value of the '<em><b>SSD Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSD Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SSD Description</em>' attribute.
	 * @see #setSSDDescription(String)
	 * @see org.eclipse.papyrus.moka.ssp.profile.SSPProfilePackage#getSsdConnector_SSDDescription()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getSSDDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.ssp.profile.SsdConnector#getSSDDescription <em>SSD Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SSD Description</em>' attribute.
	 * @see #getSSDDescription()
	 * @generated
	 */
	void setSSDDescription(String value);

	/**
	 * Returns the value of the '<em><b>Type Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.moka.ssp.profile.TypeKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Kind</em>' attribute.
	 * @see org.eclipse.papyrus.moka.ssp.profile.TypeKind
	 * @see #setTypeKind(TypeKind)
	 * @see org.eclipse.papyrus.moka.ssp.profile.SSPProfilePackage#getSsdConnector_TypeKind()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	TypeKind getTypeKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.ssp.profile.SsdConnector#getTypeKind <em>Type Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Kind</em>' attribute.
	 * @see org.eclipse.papyrus.moka.ssp.profile.TypeKind
	 * @see #getTypeKind()
	 * @generated
	 */
	void setTypeKind(TypeKind value);

} // SsdConnector
