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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ssd Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.profile.SsdElement#getID <em>ID</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.ssp.profile.SSPProfilePackage#getSsdElement()
 * @model abstract="true"
 * @generated
 */
public interface SsdElement extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " Copyright (c) 2018,  IncQuery Labs Ltd and CEA List.\n All rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License 2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0 \r\n\r\nSPDX-License-Identifier: EPL-2.0\n \nContributors:\n IncQuery Labs Ltd - initial API and implementation\n CEA List ";

	/**
	 * Returns the value of the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ID</em>' attribute.
	 * @see #setID(String)
	 * @see org.eclipse.papyrus.moka.ssp.profile.SSPProfilePackage#getSsdElement_ID()
	 * @model ordered="false"
	 * @generated
	 */
	String getID();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.ssp.profile.SsdElement#getID <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ID</em>' attribute.
	 * @see #getID()
	 * @generated
	 */
	void setID(String value);

} // SsdElement
