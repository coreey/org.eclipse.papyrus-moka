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
package org.eclipse.papyrus.moka.ssp.omsimulatorprofile.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage
 * @generated
 */
public class OMSimulatorSwitch<T> extends Switch<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2018 CEA LIST.\n\n All rights reserved. This program and the accompanying materials\n are made available under the terms of the Eclipse Public License 2.0\n which accompanies this distribution, and is available at\n https://www.eclipse.org/legal/epl-2.0 \r\n\r\nSPDX-License-Identifier: EPL-2.0\n\n Contributors:\n  CEA LIST - Initial API and implementation";

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static OMSimulatorPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMSimulatorSwitch() {
		if (modelPackage == null) {
			modelPackage = OMSimulatorPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case OMSimulatorPackage.TLM_INTERFACE_DEFINITION: {
				TLMInterfaceDefinition tlmInterfaceDefinition = (TLMInterfaceDefinition)theEObject;
				T result = caseTLMInterfaceDefinition(tlmInterfaceDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OMSimulatorPackage.TLM_SIGNAL_DEFINITION: {
				TLMSignalDefinition tlmSignalDefinition = (TLMSignalDefinition)theEObject;
				T result = caseTLMSignalDefinition(tlmSignalDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OMSimulatorPackage.TLM_SIGNAL: {
				TLMSignal tlmSignal = (TLMSignal)theEObject;
				T result = caseTLMSignal(tlmSignal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OMSimulatorPackage.OM_SIMULATOR_BUS: {
				OMSimulatorBus omSimulatorBus = (OMSimulatorBus)theEObject;
				T result = caseOMSimulatorBus(omSimulatorBus);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OMSimulatorPackage.BUS_CONNECTION_END: {
				BusConnectionEnd busConnectionEnd = (BusConnectionEnd)theEObject;
				T result = caseBusConnectionEnd(busConnectionEnd);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OMSimulatorPackage.TLM_CONNECTION: {
				TLMConnection tlmConnection = (TLMConnection)theEObject;
				T result = caseTLMConnection(tlmConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OMSimulatorPackage.BUS_CONNECTOR: {
				BusConnector busConnector = (BusConnector)theEObject;
				T result = caseBusConnector(busConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TLM Interface Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TLM Interface Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTLMInterfaceDefinition(TLMInterfaceDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TLM Signal Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TLM Signal Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTLMSignalDefinition(TLMSignalDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TLM Signal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TLM Signal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTLMSignal(TLMSignal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bus</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bus</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOMSimulatorBus(OMSimulatorBus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bus Connection End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bus Connection End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBusConnectionEnd(BusConnectionEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TLM Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TLM Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTLMConnection(TLMConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bus Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bus Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBusConnector(BusConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //OMSimulatorSwitch
