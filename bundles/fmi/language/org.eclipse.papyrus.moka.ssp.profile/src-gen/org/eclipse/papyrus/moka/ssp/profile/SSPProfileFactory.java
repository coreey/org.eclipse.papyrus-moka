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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.moka.ssp.profile.SSPProfilePackage
 * @generated
 */
public interface SSPProfileFactory extends EFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " Copyright (c) 2018,  IncQuery Labs Ltd and CEA List.\n All rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License 2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0 \r\n\r\nSPDX-License-Identifier: EPL-2.0\n \nContributors:\n IncQuery Labs Ltd - initial API and implementation\n CEA List ";

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SSPProfileFactory eINSTANCE = org.eclipse.papyrus.moka.ssp.profile.impl.SSPProfileFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Ssd Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ssd Connection</em>'.
	 * @generated
	 */
	SsdConnection createSsdConnection();

	/**
	 * Returns a new object of class '<em>Ssd Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ssd Connector</em>'.
	 * @generated
	 */
	SsdConnector createSsdConnector();

	/**
	 * Returns a new object of class '<em>Ssd System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ssd System</em>'.
	 * @generated
	 */
	SsdSystem createSsdSystem();

	/**
	 * Returns a new object of class '<em>Ssd Signal Dictionary Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ssd Signal Dictionary Reference</em>'.
	 * @generated
	 */
	SsdSignalDictionaryReference createSsdSignalDictionaryReference();

	/**
	 * Returns a new object of class '<em>Ssd Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ssd Component</em>'.
	 * @generated
	 */
	SsdComponent createSsdComponent();

	/**
	 * Returns a new object of class '<em>Ssd</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ssd</em>'.
	 * @generated
	 */
	Ssd createSsd();

	/**
	 * Returns a new object of class '<em>Ssd Connector And Fmi Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ssd Connector And Fmi Port</em>'.
	 * @generated
	 */
	SsdConnectorAndFmiPort createSsdConnectorAndFmiPort();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SSPProfilePackage getSSPProfilePackage();

} //SSPProfileFactory
