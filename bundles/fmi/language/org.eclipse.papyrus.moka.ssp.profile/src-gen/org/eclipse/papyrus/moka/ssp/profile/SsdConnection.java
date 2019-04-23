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

import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ssd Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.profile.SsdConnection#getBase_Connector <em>Base Connector</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.profile.SsdConnection#getStart <em>Start</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.profile.SsdConnection#getEnd <em>End</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.profile.SsdConnection#getStartSsdProperty <em>Start Ssd Property</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.profile.SsdConnection#getEndSsdProperty <em>End Ssd Property</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.ssp.profile.SSPProfilePackage#getSsdConnection()
 * @model
 * @generated
 */
public interface SsdConnection extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " Copyright (c) 2018,  IncQuery Labs Ltd and CEA List.\n All rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License 2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0 \r\n\r\nSPDX-License-Identifier: EPL-2.0\n \nContributors:\n IncQuery Labs Ltd - initial API and implementation\n CEA List ";

	/**
	 * Returns the value of the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Connector</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Connector</em>' reference.
	 * @see #setBase_Connector(Connector)
	 * @see org.eclipse.papyrus.moka.ssp.profile.SSPProfilePackage#getSsdConnection_Base_Connector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Connector getBase_Connector();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.ssp.profile.SsdConnection#getBase_Connector <em>Base Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Connector</em>' reference.
	 * @see #getBase_Connector()
	 * @generated
	 */
	void setBase_Connector(Connector value);

	/**
	 * Returns the value of the '<em><b>Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' reference.
	 * @see org.eclipse.papyrus.moka.ssp.profile.SSPProfilePackage#getSsdConnection_Start()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	SsdConnector getStart();

	/**
	 * Returns the value of the '<em><b>End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' reference.
	 * @see org.eclipse.papyrus.moka.ssp.profile.SSPProfilePackage#getSsdConnection_End()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	SsdConnector getEnd();

	/**
	 * Returns the value of the '<em><b>Start Ssd Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Ssd Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Ssd Property</em>' reference.
	 * @see org.eclipse.papyrus.moka.ssp.profile.SSPProfilePackage#getSsdConnection_StartSsdProperty()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	Property getStartSsdProperty();

	/**
	 * Returns the value of the '<em><b>End Ssd Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Ssd Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Ssd Property</em>' reference.
	 * @see org.eclipse.papyrus.moka.ssp.profile.SSPProfilePackage#getSsdConnection_EndSsdProperty()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	Property getEndSsdProperty();

} // SsdConnection
