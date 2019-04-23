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

import org.eclipse.papyrus.moka.fmi.fmiprofile.FMU;

import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ssd Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.profile.SsdComponent#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.profile.SsdComponent#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.profile.SsdComponent#getFmu <em>Fmu</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.profile.SsdComponent#getBase_Property <em>Base Property</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.ssp.profile.SSPProfilePackage#getSsdComponent()
 * @model
 * @generated
 */
public interface SsdComponent extends SsdElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " Copyright (c) 2018,  IncQuery Labs Ltd and CEA List.\n All rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License 2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0 \r\n\r\nSPDX-License-Identifier: EPL-2.0\n \nContributors:\n IncQuery Labs Ltd - initial API and implementation\n CEA List ";

	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #setSource(String)
	 * @see org.eclipse.papyrus.moka.ssp.profile.SSPProfilePackage#getSsdComponent_Source()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.ssp.profile.SsdComponent#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.eclipse.papyrus.moka.ssp.profile.SSPProfilePackage#getSsdComponent_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.ssp.profile.SsdComponent#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Fmu</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fmu</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fmu</em>' reference.
	 * @see #setFmu(FMU)
	 * @see org.eclipse.papyrus.moka.ssp.profile.SSPProfilePackage#getSsdComponent_Fmu()
	 * @model ordered="false"
	 * @generated
	 */
	FMU getFmu();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.ssp.profile.SsdComponent#getFmu <em>Fmu</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fmu</em>' reference.
	 * @see #getFmu()
	 * @generated
	 */
	void setFmu(FMU value);

	/**
	 * Returns the value of the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Property</em>' reference.
	 * @see #setBase_Property(Property)
	 * @see org.eclipse.papyrus.moka.ssp.profile.SSPProfilePackage#getSsdComponent_Base_Property()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Property getBase_Property();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.ssp.profile.SsdComponent#getBase_Property <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Property</em>' reference.
	 * @see #getBase_Property()
	 * @generated
	 */
	void setBase_Property(Property value);

} // SsdComponent
