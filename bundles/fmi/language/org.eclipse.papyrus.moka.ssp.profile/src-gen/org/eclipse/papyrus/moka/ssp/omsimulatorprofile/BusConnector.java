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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bus Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getBase_Connector <em>Base Connector</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getEnd1Component <em>End1 Component</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getEnd1Signals <em>End1 Signals</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getEnd2Signals <em>End2 Signals</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getEnd2Component <em>End2 Component</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage#getBusConnector()
 * @model
 * @generated
 */
public interface BusConnector extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2018 CEA LIST.\n\n All rights reserved. This program and the accompanying materials\n are made available under the terms of the Eclipse Public License v1.0\n which accompanies this distribution, and is available at\n http://www.eclipse.org/legal/epl-v10.html\n\n Contributors:\n  CEA LIST - Initial API and implementation";

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
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage#getBusConnector_Base_Connector()
	 * @model ordered="false"
	 * @generated
	 */
	Connector getBase_Connector();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getBase_Connector <em>Base Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Connector</em>' reference.
	 * @see #getBase_Connector()
	 * @generated
	 */
	void setBase_Connector(Connector value);

	/**
	 * Returns the value of the '<em><b>End1 Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End1 Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End1 Component</em>' reference.
	 * @see #setEnd1Component(Property)
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage#getBusConnector_End1Component()
	 * @model required="true" transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	Property getEnd1Component();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getEnd1Component <em>End1 Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End1 Component</em>' reference.
	 * @see #getEnd1Component()
	 * @generated
	 */
	void setEnd1Component(Property value);

	/**
	 * Returns the value of the '<em><b>End1 Signals</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Port}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End1 Signals</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End1 Signals</em>' reference list.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage#getBusConnector_End1Signals()
	 * @model transient="true" volatile="true"
	 * @generated
	 */
	EList<Port> getEnd1Signals();

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.Port} with the specified '<em><b>Name</b></em>', and '<em><b>Type</b></em>' from the '<em><b>End1 Signals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Port} to retrieve, or <code>null</code>.
	 * @param type The '<em><b>Type</b></em>' of the {@link org.eclipse.uml2.uml.Port} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.Port} with the specified '<em><b>Name</b></em>', and '<em><b>Type</b></em>', or <code>null</code>.
	 * @see #getEnd1Signals()
	 * @generated
	 */
	Port getEnd1Signals(String name, Type type);

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.Port} with the specified '<em><b>Name</b></em>', and '<em><b>Type</b></em>' from the '<em><b>End1 Signals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Port} to retrieve, or <code>null</code>.
	 * @param type The '<em><b>Type</b></em>' of the {@link org.eclipse.uml2.uml.Port} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @return The first {@link org.eclipse.uml2.uml.Port} with the specified '<em><b>Name</b></em>', and '<em><b>Type</b></em>', or <code>null</code>.
	 * @see #getEnd1Signals()
	 * @generated
	 */
	Port getEnd1Signals(String name, Type type, boolean ignoreCase);

	/**
	 * Returns the value of the '<em><b>End2 Signals</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Port}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End2 Signals</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End2 Signals</em>' reference list.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage#getBusConnector_End2Signals()
	 * @model transient="true" volatile="true"
	 * @generated
	 */
	EList<Port> getEnd2Signals();

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.Port} with the specified '<em><b>Name</b></em>', and '<em><b>Type</b></em>' from the '<em><b>End2 Signals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Port} to retrieve, or <code>null</code>.
	 * @param type The '<em><b>Type</b></em>' of the {@link org.eclipse.uml2.uml.Port} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.Port} with the specified '<em><b>Name</b></em>', and '<em><b>Type</b></em>', or <code>null</code>.
	 * @see #getEnd2Signals()
	 * @generated
	 */
	Port getEnd2Signals(String name, Type type);

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.Port} with the specified '<em><b>Name</b></em>', and '<em><b>Type</b></em>' from the '<em><b>End2 Signals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Port} to retrieve, or <code>null</code>.
	 * @param type The '<em><b>Type</b></em>' of the {@link org.eclipse.uml2.uml.Port} to retrieve, or <code>null</code>.
	 * @param ignoreCase Whether to ignore case in {@link java.lang.String} comparisons.
	 * @return The first {@link org.eclipse.uml2.uml.Port} with the specified '<em><b>Name</b></em>', and '<em><b>Type</b></em>', or <code>null</code>.
	 * @see #getEnd2Signals()
	 * @generated
	 */
	Port getEnd2Signals(String name, Type type, boolean ignoreCase);

	/**
	 * Returns the value of the '<em><b>End2 Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End2 Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End2 Component</em>' reference.
	 * @see #setEnd2Component(Property)
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage#getBusConnector_End2Component()
	 * @model required="true" transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	Property getEnd2Component();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getEnd2Component <em>End2 Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End2 Component</em>' reference.
	 * @see #getEnd2Component()
	 * @generated
	 */
	void setEnd2Component(Property value);

} // BusConnector
