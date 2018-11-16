/**
 * Copyright (c) 2018 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *   CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.moka.ssp.omsimulatorprofile;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage
 * @generated
 */
public interface OMSimulatorFactory extends EFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2018 CEA LIST.\n\n All rights reserved. This program and the accompanying materials\n are made available under the terms of the Eclipse Public License v1.0\n which accompanies this distribution, and is available at\n http://www.eclipse.org/legal/epl-v10.html\n\n Contributors:\n  CEA LIST - Initial API and implementation";

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OMSimulatorFactory eINSTANCE = org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.OMSimulatorFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>TLM Interface Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TLM Interface Definition</em>'.
	 * @generated
	 */
	TLMInterfaceDefinition createTLMInterfaceDefinition();

	/**
	 * Returns a new object of class '<em>TLM Signal Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TLM Signal Definition</em>'.
	 * @generated
	 */
	TLMSignalDefinition createTLMSignalDefinition();

	/**
	 * Returns a new object of class '<em>TLM Signal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TLM Signal</em>'.
	 * @generated
	 */
	TLMSignal createTLMSignal();

	/**
	 * Returns a new object of class '<em>Bus</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bus</em>'.
	 * @generated
	 */
	OMSimulatorBus createOMSimulatorBus();

	/**
	 * Returns a new object of class '<em>Bus Connection End</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bus Connection End</em>'.
	 * @generated
	 */
	BusConnectionEnd createBusConnectionEnd();

	/**
	 * Returns a new object of class '<em>TLM Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TLM Connection</em>'.
	 * @generated
	 */
	TLMConnection createTLMConnection();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OMSimulatorPackage getOMSimulatorPackage();

} //OMSimulatorFactory