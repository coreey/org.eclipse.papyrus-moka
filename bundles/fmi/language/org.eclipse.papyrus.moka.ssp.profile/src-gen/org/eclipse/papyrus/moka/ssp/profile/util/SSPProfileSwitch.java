/**
 *  Copyright (c) 2018,  IncQuery Labs Ltd and CEA List.
 *  All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *  IncQuery Labs Ltd - initial API and implementation
 *  CEA List 
 */
package org.eclipse.papyrus.moka.ssp.profile.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.moka.fmi.fmiprofile.FMIPort;
import org.eclipse.papyrus.moka.fmi.fmiprofile.ScalarVariable;

import org.eclipse.papyrus.moka.ssp.profile.*;

import org.eclipse.papyrus.sysml14.deprecatedelements.FlowPort;

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
 * @see org.eclipse.papyrus.moka.ssp.profile.SSPProfilePackage
 * @generated
 */
public class SSPProfileSwitch {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " Copyright (c) 2018,  IncQuery Labs Ltd and CEA List.\n All rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n \nContributors:\n IncQuery Labs Ltd - initial API and implementation\n CEA List ";

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SSPProfilePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SSPProfileSwitch() {
		if (modelPackage == null) {
			modelPackage = SSPProfilePackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SSPProfilePackage.SSD_CONNECTION: {
				SsdConnection ssdConnection = (SsdConnection)theEObject;
				Object result = caseSsdConnection(ssdConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SSPProfilePackage.SSD_CONNECTOR: {
				SsdConnector ssdConnector = (SsdConnector)theEObject;
				Object result = caseSsdConnector(ssdConnector);
				if (result == null) result = caseFlowPort(ssdConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SSPProfilePackage.SSD_ELEMENT: {
				SsdElement ssdElement = (SsdElement)theEObject;
				Object result = caseSsdElement(ssdElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SSPProfilePackage.SSD_SYSTEM: {
				SsdSystem ssdSystem = (SsdSystem)theEObject;
				Object result = caseSsdSystem(ssdSystem);
				if (result == null) result = caseSsdElement(ssdSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SSPProfilePackage.SSD_SIGNAL_DICTIONARY_REFERENCE: {
				SsdSignalDictionaryReference ssdSignalDictionaryReference = (SsdSignalDictionaryReference)theEObject;
				Object result = caseSsdSignalDictionaryReference(ssdSignalDictionaryReference);
				if (result == null) result = caseSsdElement(ssdSignalDictionaryReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SSPProfilePackage.SSD_COMPONENT: {
				SsdComponent ssdComponent = (SsdComponent)theEObject;
				Object result = caseSsdComponent(ssdComponent);
				if (result == null) result = caseSsdElement(ssdComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SSPProfilePackage.SSD: {
				Ssd ssd = (Ssd)theEObject;
				Object result = caseSsd(ssd);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SSPProfilePackage.SSD_CONNECTOR_AND_FMI_PORT: {
				SsdConnectorAndFmiPort ssdConnectorAndFmiPort = (SsdConnectorAndFmiPort)theEObject;
				Object result = caseSsdConnectorAndFmiPort(ssdConnectorAndFmiPort);
				if (result == null) result = caseFMIPort(ssdConnectorAndFmiPort);
				if (result == null) result = caseSsdConnector(ssdConnectorAndFmiPort);
				if (result == null) result = caseScalarVariable(ssdConnectorAndFmiPort);
				if (result == null) result = caseFlowPort(ssdConnectorAndFmiPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ssd Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ssd Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSsdConnection(SsdConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ssd Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ssd Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSsdConnector(SsdConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ssd Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ssd Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSsdElement(SsdElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ssd System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ssd System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSsdSystem(SsdSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ssd Signal Dictionary Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ssd Signal Dictionary Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSsdSignalDictionaryReference(SsdSignalDictionaryReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ssd Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ssd Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSsdComponent(SsdComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ssd</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ssd</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSsd(Ssd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ssd Connector And Fmi Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ssd Connector And Fmi Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSsdConnectorAndFmiPort(SsdConnectorAndFmiPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFlowPort(FlowPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scalar Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scalar Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseScalarVariable(ScalarVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FMI Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FMI Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFMIPort(FMIPort object) {
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
	public Object defaultCase(EObject object) {
		return null;
	}

} //SSPProfileSwitch
