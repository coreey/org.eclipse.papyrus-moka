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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ssd Signal Dictionary Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.profile.SsdSignalDictionaryReference#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.ssp.profile.SSPProfilePackage#getSsdSignalDictionaryReference()
 * @model
 * @generated
 */
public interface SsdSignalDictionaryReference extends SsdElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " Copyright (c) 2018,  IncQuery Labs Ltd and CEA List.\n All rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License 2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0 \r\n\r\nSPDX-License-Identifier: EPL-2.0\n \nContributors:\n IncQuery Labs Ltd - initial API and implementation\n CEA List ";

	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.papyrus.moka.ssp.profile.SSPProfilePackage#getSsdSignalDictionaryReference_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.ssp.profile.SsdSignalDictionaryReference#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

} // SsdSignalDictionaryReference
