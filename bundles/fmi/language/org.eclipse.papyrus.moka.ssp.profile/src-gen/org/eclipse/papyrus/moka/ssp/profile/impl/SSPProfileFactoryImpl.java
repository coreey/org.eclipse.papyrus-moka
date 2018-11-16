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
package org.eclipse.papyrus.moka.ssp.profile.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.moka.ssp.profile.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SSPProfileFactoryImpl extends EFactoryImpl implements SSPProfileFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " Copyright (c) 2018,  IncQuery Labs Ltd and CEA List.\n All rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n \nContributors:\n IncQuery Labs Ltd - initial API and implementation\n CEA List ";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SSPProfileFactory init() {
		try {
			SSPProfileFactory theSSPProfileFactory = (SSPProfileFactory)EPackage.Registry.INSTANCE.getEFactory(SSPProfilePackage.eNS_URI);
			if (theSSPProfileFactory != null) {
				return theSSPProfileFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SSPProfileFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SSPProfileFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SSPProfilePackage.SSD_CONNECTION: return createSsdConnection();
			case SSPProfilePackage.SSD_CONNECTOR: return createSsdConnector();
			case SSPProfilePackage.SSD_SYSTEM: return createSsdSystem();
			case SSPProfilePackage.SSD_SIGNAL_DICTIONARY_REFERENCE: return createSsdSignalDictionaryReference();
			case SSPProfilePackage.SSD_COMPONENT: return createSsdComponent();
			case SSPProfilePackage.SSD: return createSsd();
			case SSPProfilePackage.SSD_CONNECTOR_AND_FMI_PORT: return createSsdConnectorAndFmiPort();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case SSPProfilePackage.TYPE_KIND:
				return createTypeKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case SSPProfilePackage.TYPE_KIND:
				return convertTypeKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SsdConnection createSsdConnection() {
		SsdConnectionImpl ssdConnection = new SsdConnectionImpl();
		return ssdConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SsdConnector createSsdConnector() {
		SsdConnectorImpl ssdConnector = new SsdConnectorImpl();
		return ssdConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SsdSystem createSsdSystem() {
		SsdSystemImpl ssdSystem = new SsdSystemImpl();
		return ssdSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SsdSignalDictionaryReference createSsdSignalDictionaryReference() {
		SsdSignalDictionaryReferenceImpl ssdSignalDictionaryReference = new SsdSignalDictionaryReferenceImpl();
		return ssdSignalDictionaryReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SsdComponent createSsdComponent() {
		SsdComponentImpl ssdComponent = new SsdComponentImpl();
		return ssdComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ssd createSsd() {
		SsdImpl ssd = new SsdImpl();
		return ssd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SsdConnectorAndFmiPort createSsdConnectorAndFmiPort() {
		SsdConnectorAndFmiPortImpl ssdConnectorAndFmiPort = new SsdConnectorAndFmiPortImpl();
		return ssdConnectorAndFmiPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeKind createTypeKindFromString(EDataType eDataType, String initialValue) {
		TypeKind result = TypeKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SSPProfilePackage getSSPProfilePackage() {
		return (SSPProfilePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static SSPProfilePackage getPackage() {
		return SSPProfilePackage.eINSTANCE;
	}

} //SSPProfileFactoryImpl
