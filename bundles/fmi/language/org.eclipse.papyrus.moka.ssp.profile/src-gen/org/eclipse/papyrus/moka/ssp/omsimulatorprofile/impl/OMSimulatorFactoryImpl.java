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
package org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OMSimulatorFactoryImpl extends EFactoryImpl implements OMSimulatorFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2018 CEA LIST.\n\n All rights reserved. This program and the accompanying materials\n are made available under the terms of the Eclipse Public License v1.0\n which accompanies this distribution, and is available at\n http://www.eclipse.org/legal/epl-v10.html\n\n Contributors:\n  CEA LIST - Initial API and implementation";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OMSimulatorFactory init() {
		try {
			OMSimulatorFactory theOMSimulatorFactory = (OMSimulatorFactory)EPackage.Registry.INSTANCE.getEFactory(OMSimulatorPackage.eNS_URI);
			if (theOMSimulatorFactory != null) {
				return theOMSimulatorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OMSimulatorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMSimulatorFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case OMSimulatorPackage.TLM_INTERFACE_DEFINITION: return createTLMInterfaceDefinition();
			case OMSimulatorPackage.TLM_SIGNAL_DEFINITION: return createTLMSignalDefinition();
			case OMSimulatorPackage.TLM_SIGNAL: return createTLMSignal();
			case OMSimulatorPackage.OM_SIMULATOR_BUS: return createOMSimulatorBus();
			case OMSimulatorPackage.BUS_CONNECTION_END: return createBusConnectionEnd();
			case OMSimulatorPackage.TLM_CONNECTION: return createTLMConnection();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case OMSimulatorPackage.INTERPOLATION:
				return createInterpolationFromString(eDataType, initialValue);
			case OMSimulatorPackage.TLM_DOMAIN:
				return createTLMDomainFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case OMSimulatorPackage.INTERPOLATION:
				return convertInterpolationToString(eDataType, instanceValue);
			case OMSimulatorPackage.TLM_DOMAIN:
				return convertTLMDomainToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TLMInterfaceDefinition createTLMInterfaceDefinition() {
		TLMInterfaceDefinitionImpl tlmInterfaceDefinition = new TLMInterfaceDefinitionImpl();
		return tlmInterfaceDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TLMSignalDefinition createTLMSignalDefinition() {
		TLMSignalDefinitionImpl tlmSignalDefinition = new TLMSignalDefinitionImpl();
		return tlmSignalDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TLMSignal createTLMSignal() {
		TLMSignalImpl tlmSignal = new TLMSignalImpl();
		return tlmSignal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMSimulatorBus createOMSimulatorBus() {
		OMSimulatorBusImpl omSimulatorBus = new OMSimulatorBusImpl();
		return omSimulatorBus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusConnectionEnd createBusConnectionEnd() {
		BusConnectionEndImpl busConnectionEnd = new BusConnectionEndImpl();
		return busConnectionEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TLMConnection createTLMConnection() {
		TLMConnectionImpl tlmConnection = new TLMConnectionImpl();
		return tlmConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interpolation createInterpolationFromString(EDataType eDataType, String initialValue) {
		Interpolation result = Interpolation.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInterpolationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TLMDomain createTLMDomainFromString(EDataType eDataType, String initialValue) {
		TLMDomain result = TLMDomain.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTLMDomainToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMSimulatorPackage getOMSimulatorPackage() {
		return (OMSimulatorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OMSimulatorPackage getPackage() {
		return OMSimulatorPackage.eINSTANCE;
	}

} //OMSimulatorFactoryImpl
