/**
 * Copyright (c) 2018 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0 
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *   CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.moka.ssp.omsimulatorprofile;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bus</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * OMSimulatorBus is a new kind of Port which can be added to FMU Blocks. Those ports can reference other Flowports belonging to the owning FMU.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorBus#getBase_Port <em>Base Port</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorBus#getSignals <em>Signals</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorBus#getDomain <em>Domain</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage#getOMSimulatorBus()
 * @model
 * @generated
 */
public interface OMSimulatorBus extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2018 CEA LIST.\n\n All rights reserved. This program and the accompanying materials\n are made available under the terms of the Eclipse Public License 2.0\n which accompanies this distribution, and is available at\n https://www.eclipse.org/legal/epl-2.0 \r\n\r\nSPDX-License-Identifier: EPL-2.0\n\n Contributors:\n  CEA LIST - Initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Port</em>' reference.
	 * @see #setBase_Port(Port)
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage#getOMSimulatorBus_Base_Port()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Port getBase_Port();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorBus#getBase_Port <em>Base Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Port</em>' reference.
	 * @see #getBase_Port()
	 * @generated
	 */
	void setBase_Port(Port value);

	/**
	 * Returns the value of the '<em><b>Signals</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Port}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signals</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signals</em>' reference list.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage#getOMSimulatorBus_Signals()
	 * @model
	 * @generated
	 */
	EList<Port> getSignals();

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.Port} with the specified '<em><b>Name</b></em>', and '<em><b>Type</b></em>' from the '<em><b>Signals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Port} to retrieve, or <code>null</code>.
	 * @param type The '<em><b>Type</b></em>' of the {@link org.eclipse.uml2.uml.Port} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.Port} with the specified '<em><b>Name</b></em>', and '<em><b>Type</b></em>', or <code>null</code>.
	 * @see #getSignals()
	 * @generated
	 */
	Port getSignals(String name, Type type);

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.Port} with the specified '<em><b>Name</b></em>', and '<em><b>Type</b></em>' from the '<em><b>Signals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Port} to retrieve, or <code>null</code>.
	 * @param type The '<em><b>Type</b></em>' of the {@link org.eclipse.uml2.uml.Port} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @return The first {@link org.eclipse.uml2.uml.Port} with the specified '<em><b>Name</b></em>', and '<em><b>Type</b></em>', or <code>null</code>.
	 * @see #getSignals()
	 * @generated
	 */
	Port getSignals(String name, Type type, boolean ignoreCase);

	/**
	 * Returns the value of the '<em><b>Domain</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMDomain}.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMDomain}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' attribute list.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMDomain
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage#getOMSimulatorBus_Domain()
	 * @model ordered="false"
	 * @generated
	 */
	EList<TLMDomain> getDomain();

} // OMSimulatorBus
