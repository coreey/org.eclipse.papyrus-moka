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
package org.eclipse.papyrus.moka.ssp.profile;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage;

import org.eclipse.papyrus.sysml14.deprecatedelements.DeprecatedelementsPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.moka.ssp.profile.SSPProfileFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='SSPProfile'"
 * @generated
 */
public interface SSPProfilePackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " Copyright (c) 2018,  IncQuery Labs Ltd and CEA List.\n All rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n \nContributors:\n IncQuery Labs Ltd - initial API and implementation\n CEA List ";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "profile";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.eclipse.papyrus.moka.ssp.profile/SSPProfile";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "SSPProfile";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SSPProfilePackage eINSTANCE = org.eclipse.papyrus.moka.ssp.profile.impl.SSPProfilePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.ssp.profile.impl.SsdConnectionImpl <em>Ssd Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SsdConnectionImpl
	 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SSPProfilePackageImpl#getSsdConnection()
	 * @generated
	 */
	int SSD_CONNECTION = 0;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_CONNECTION__BASE_CONNECTOR = 0;

	/**
	 * The feature id for the '<em><b>Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_CONNECTION__START = 1;

	/**
	 * The feature id for the '<em><b>End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_CONNECTION__END = 2;

	/**
	 * The feature id for the '<em><b>Start Ssd Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_CONNECTION__START_SSD_PROPERTY = 3;

	/**
	 * The feature id for the '<em><b>End Ssd Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_CONNECTION__END_SSD_PROPERTY = 4;

	/**
	 * The number of structural features of the '<em>Ssd Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_CONNECTION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.ssp.profile.impl.SsdConnectorImpl <em>Ssd Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SsdConnectorImpl
	 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SSPProfilePackageImpl#getSsdConnector()
	 * @generated
	 */
	int SSD_CONNECTOR = 1;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_CONNECTOR__BASE_PORT = DeprecatedelementsPackage.FLOW_PORT__BASE_PORT;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_CONNECTOR__DIRECTION = DeprecatedelementsPackage.FLOW_PORT__DIRECTION;

	/**
	 * The feature id for the '<em><b>Is Atomic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_CONNECTOR__IS_ATOMIC = DeprecatedelementsPackage.FLOW_PORT__IS_ATOMIC;

	/**
	 * The feature id for the '<em><b>SSD Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_CONNECTOR__SSD_DESCRIPTION = DeprecatedelementsPackage.FLOW_PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_CONNECTOR__TYPE_KIND = DeprecatedelementsPackage.FLOW_PORT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Ssd Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_CONNECTOR_FEATURE_COUNT = DeprecatedelementsPackage.FLOW_PORT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.ssp.profile.impl.SsdElementImpl <em>Ssd Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SsdElementImpl
	 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SSPProfilePackageImpl#getSsdElement()
	 * @generated
	 */
	int SSD_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_ELEMENT__ID = 0;

	/**
	 * The number of structural features of the '<em>Ssd Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.ssp.profile.impl.SsdSystemImpl <em>Ssd System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SsdSystemImpl
	 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SSPProfilePackageImpl#getSsdSystem()
	 * @generated
	 */
	int SSD_SYSTEM = 3;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_SYSTEM__ID = SSD_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_SYSTEM__BASE_CLASS = SSD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ssd System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_SYSTEM_FEATURE_COUNT = SSD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.ssp.profile.impl.SsdSignalDictionaryReferenceImpl <em>Ssd Signal Dictionary Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SsdSignalDictionaryReferenceImpl
	 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SSPProfilePackageImpl#getSsdSignalDictionaryReference()
	 * @generated
	 */
	int SSD_SIGNAL_DICTIONARY_REFERENCE = 4;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_SIGNAL_DICTIONARY_REFERENCE__ID = SSD_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_SIGNAL_DICTIONARY_REFERENCE__BASE_CLASS = SSD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ssd Signal Dictionary Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_SIGNAL_DICTIONARY_REFERENCE_FEATURE_COUNT = SSD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.ssp.profile.impl.SsdComponentImpl <em>Ssd Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SsdComponentImpl
	 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SSPProfilePackageImpl#getSsdComponent()
	 * @generated
	 */
	int SSD_COMPONENT = 5;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_COMPONENT__ID = SSD_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_COMPONENT__SOURCE = SSD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_COMPONENT__TYPE = SSD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fmu</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_COMPONENT__FMU = SSD_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_COMPONENT__BASE_PROPERTY = SSD_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Ssd Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_COMPONENT_FEATURE_COUNT = SSD_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.ssp.profile.impl.SsdImpl <em>Ssd</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SsdImpl
	 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SSPProfilePackageImpl#getSsd()
	 * @generated
	 */
	int SSD = 6;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD__BASE_PACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD__NAME = 1;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD__VERSION = 2;

	/**
	 * The feature id for the '<em><b>Main System</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD__MAIN_SYSTEM = 3;

	/**
	 * The number of structural features of the '<em>Ssd</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.ssp.profile.impl.SsdConnectorAndFmiPortImpl <em>Ssd Connector And Fmi Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SsdConnectorAndFmiPortImpl
	 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SSPProfilePackageImpl#getSsdConnectorAndFmiPort()
	 * @generated
	 */
	int SSD_CONNECTOR_AND_FMI_PORT = 7;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_CONNECTOR_AND_FMI_PORT__DESCRIPTION = FMIProfilePackage.FMI_PORT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Variability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_CONNECTOR_AND_FMI_PORT__VARIABILITY = FMIProfilePackage.FMI_PORT__VARIABILITY;

	/**
	 * The feature id for the '<em><b>Initial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_CONNECTOR_AND_FMI_PORT__INITIAL = FMIProfilePackage.FMI_PORT__INITIAL;

	/**
	 * The feature id for the '<em><b>Value Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_CONNECTOR_AND_FMI_PORT__VALUE_REFERENCE = FMIProfilePackage.FMI_PORT__VALUE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Fmi Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_CONNECTOR_AND_FMI_PORT__FMI_VARIABLE = FMIProfilePackage.FMI_PORT__FMI_VARIABLE;

	/**
	 * The feature id for the '<em><b>Causality Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_CONNECTOR_AND_FMI_PORT__CAUSALITY_KIND = FMIProfilePackage.FMI_PORT__CAUSALITY_KIND;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_CONNECTOR_AND_FMI_PORT__BASE_PORT = FMIProfilePackage.FMI_PORT__BASE_PORT;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_CONNECTOR_AND_FMI_PORT__DIRECTION = FMIProfilePackage.FMI_PORT__DIRECTION;

	/**
	 * The feature id for the '<em><b>Is Atomic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_CONNECTOR_AND_FMI_PORT__IS_ATOMIC = FMIProfilePackage.FMI_PORT__IS_ATOMIC;

	/**
	 * The feature id for the '<em><b>SSD Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_CONNECTOR_AND_FMI_PORT__SSD_DESCRIPTION = FMIProfilePackage.FMI_PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_CONNECTOR_AND_FMI_PORT__TYPE_KIND = FMIProfilePackage.FMI_PORT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Ssd Connector And Fmi Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSD_CONNECTOR_AND_FMI_PORT_FEATURE_COUNT = FMIProfilePackage.FMI_PORT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.ssp.profile.TypeKind <em>Type Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.ssp.profile.TypeKind
	 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SSPProfilePackageImpl#getTypeKind()
	 * @generated
	 */
	int TYPE_KIND = 8;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.ssp.profile.SsdConnection <em>Ssd Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ssd Connection</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.profile.SsdConnection
	 * @generated
	 */
	EClass getSsdConnection();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.ssp.profile.SsdConnection#getBase_Connector <em>Base Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Connector</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.profile.SsdConnection#getBase_Connector()
	 * @see #getSsdConnection()
	 * @generated
	 */
	EReference getSsdConnection_Base_Connector();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.ssp.profile.SsdConnection#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Start</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.profile.SsdConnection#getStart()
	 * @see #getSsdConnection()
	 * @generated
	 */
	EReference getSsdConnection_Start();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.ssp.profile.SsdConnection#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.profile.SsdConnection#getEnd()
	 * @see #getSsdConnection()
	 * @generated
	 */
	EReference getSsdConnection_End();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.ssp.profile.SsdConnection#getStartSsdProperty <em>Start Ssd Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Start Ssd Property</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.profile.SsdConnection#getStartSsdProperty()
	 * @see #getSsdConnection()
	 * @generated
	 */
	EReference getSsdConnection_StartSsdProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.ssp.profile.SsdConnection#getEndSsdProperty <em>End Ssd Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End Ssd Property</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.profile.SsdConnection#getEndSsdProperty()
	 * @see #getSsdConnection()
	 * @generated
	 */
	EReference getSsdConnection_EndSsdProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.ssp.profile.SsdConnector <em>Ssd Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ssd Connector</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.profile.SsdConnector
	 * @generated
	 */
	EClass getSsdConnector();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.ssp.profile.SsdConnector#getSSDDescription <em>SSD Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SSD Description</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.profile.SsdConnector#getSSDDescription()
	 * @see #getSsdConnector()
	 * @generated
	 */
	EAttribute getSsdConnector_SSDDescription();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.ssp.profile.SsdConnector#getTypeKind <em>Type Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Kind</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.profile.SsdConnector#getTypeKind()
	 * @see #getSsdConnector()
	 * @generated
	 */
	EAttribute getSsdConnector_TypeKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.ssp.profile.SsdElement <em>Ssd Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ssd Element</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.profile.SsdElement
	 * @generated
	 */
	EClass getSsdElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.ssp.profile.SsdElement#getID <em>ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ID</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.profile.SsdElement#getID()
	 * @see #getSsdElement()
	 * @generated
	 */
	EAttribute getSsdElement_ID();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.ssp.profile.SsdSystem <em>Ssd System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ssd System</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.profile.SsdSystem
	 * @generated
	 */
	EClass getSsdSystem();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.ssp.profile.SsdSystem#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.profile.SsdSystem#getBase_Class()
	 * @see #getSsdSystem()
	 * @generated
	 */
	EReference getSsdSystem_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.ssp.profile.SsdSignalDictionaryReference <em>Ssd Signal Dictionary Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ssd Signal Dictionary Reference</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.profile.SsdSignalDictionaryReference
	 * @generated
	 */
	EClass getSsdSignalDictionaryReference();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.ssp.profile.SsdSignalDictionaryReference#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.profile.SsdSignalDictionaryReference#getBase_Class()
	 * @see #getSsdSignalDictionaryReference()
	 * @generated
	 */
	EReference getSsdSignalDictionaryReference_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.ssp.profile.SsdComponent <em>Ssd Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ssd Component</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.profile.SsdComponent
	 * @generated
	 */
	EClass getSsdComponent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.ssp.profile.SsdComponent#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.profile.SsdComponent#getSource()
	 * @see #getSsdComponent()
	 * @generated
	 */
	EAttribute getSsdComponent_Source();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.ssp.profile.SsdComponent#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.profile.SsdComponent#getType()
	 * @see #getSsdComponent()
	 * @generated
	 */
	EAttribute getSsdComponent_Type();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.ssp.profile.SsdComponent#getFmu <em>Fmu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Fmu</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.profile.SsdComponent#getFmu()
	 * @see #getSsdComponent()
	 * @generated
	 */
	EReference getSsdComponent_Fmu();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.ssp.profile.SsdComponent#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.profile.SsdComponent#getBase_Property()
	 * @see #getSsdComponent()
	 * @generated
	 */
	EReference getSsdComponent_Base_Property();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.ssp.profile.Ssd <em>Ssd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ssd</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.profile.Ssd
	 * @generated
	 */
	EClass getSsd();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.ssp.profile.Ssd#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.profile.Ssd#getBase_Package()
	 * @see #getSsd()
	 * @generated
	 */
	EReference getSsd_Base_Package();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.ssp.profile.Ssd#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.profile.Ssd#getName()
	 * @see #getSsd()
	 * @generated
	 */
	EAttribute getSsd_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.ssp.profile.Ssd#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.profile.Ssd#getVersion()
	 * @see #getSsd()
	 * @generated
	 */
	EAttribute getSsd_Version();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.ssp.profile.Ssd#getMainSystem <em>Main System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Main System</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.profile.Ssd#getMainSystem()
	 * @see #getSsd()
	 * @generated
	 */
	EReference getSsd_MainSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.ssp.profile.SsdConnectorAndFmiPort <em>Ssd Connector And Fmi Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ssd Connector And Fmi Port</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.profile.SsdConnectorAndFmiPort
	 * @generated
	 */
	EClass getSsdConnectorAndFmiPort();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.moka.ssp.profile.TypeKind <em>Type Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type Kind</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.profile.TypeKind
	 * @generated
	 */
	EEnum getTypeKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SSPProfileFactory getSSPProfileFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.ssp.profile.impl.SsdConnectionImpl <em>Ssd Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SsdConnectionImpl
		 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SSPProfilePackageImpl#getSsdConnection()
		 * @generated
		 */
		EClass SSD_CONNECTION = eINSTANCE.getSsdConnection();

		/**
		 * The meta object literal for the '<em><b>Base Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SSD_CONNECTION__BASE_CONNECTOR = eINSTANCE.getSsdConnection_Base_Connector();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SSD_CONNECTION__START = eINSTANCE.getSsdConnection_Start();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SSD_CONNECTION__END = eINSTANCE.getSsdConnection_End();

		/**
		 * The meta object literal for the '<em><b>Start Ssd Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SSD_CONNECTION__START_SSD_PROPERTY = eINSTANCE.getSsdConnection_StartSsdProperty();

		/**
		 * The meta object literal for the '<em><b>End Ssd Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SSD_CONNECTION__END_SSD_PROPERTY = eINSTANCE.getSsdConnection_EndSsdProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.ssp.profile.impl.SsdConnectorImpl <em>Ssd Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SsdConnectorImpl
		 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SSPProfilePackageImpl#getSsdConnector()
		 * @generated
		 */
		EClass SSD_CONNECTOR = eINSTANCE.getSsdConnector();

		/**
		 * The meta object literal for the '<em><b>SSD Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SSD_CONNECTOR__SSD_DESCRIPTION = eINSTANCE.getSsdConnector_SSDDescription();

		/**
		 * The meta object literal for the '<em><b>Type Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SSD_CONNECTOR__TYPE_KIND = eINSTANCE.getSsdConnector_TypeKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.ssp.profile.impl.SsdElementImpl <em>Ssd Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SsdElementImpl
		 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SSPProfilePackageImpl#getSsdElement()
		 * @generated
		 */
		EClass SSD_ELEMENT = eINSTANCE.getSsdElement();

		/**
		 * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SSD_ELEMENT__ID = eINSTANCE.getSsdElement_ID();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.ssp.profile.impl.SsdSystemImpl <em>Ssd System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SsdSystemImpl
		 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SSPProfilePackageImpl#getSsdSystem()
		 * @generated
		 */
		EClass SSD_SYSTEM = eINSTANCE.getSsdSystem();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SSD_SYSTEM__BASE_CLASS = eINSTANCE.getSsdSystem_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.ssp.profile.impl.SsdSignalDictionaryReferenceImpl <em>Ssd Signal Dictionary Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SsdSignalDictionaryReferenceImpl
		 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SSPProfilePackageImpl#getSsdSignalDictionaryReference()
		 * @generated
		 */
		EClass SSD_SIGNAL_DICTIONARY_REFERENCE = eINSTANCE.getSsdSignalDictionaryReference();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SSD_SIGNAL_DICTIONARY_REFERENCE__BASE_CLASS = eINSTANCE.getSsdSignalDictionaryReference_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.ssp.profile.impl.SsdComponentImpl <em>Ssd Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SsdComponentImpl
		 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SSPProfilePackageImpl#getSsdComponent()
		 * @generated
		 */
		EClass SSD_COMPONENT = eINSTANCE.getSsdComponent();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SSD_COMPONENT__SOURCE = eINSTANCE.getSsdComponent_Source();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SSD_COMPONENT__TYPE = eINSTANCE.getSsdComponent_Type();

		/**
		 * The meta object literal for the '<em><b>Fmu</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SSD_COMPONENT__FMU = eINSTANCE.getSsdComponent_Fmu();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SSD_COMPONENT__BASE_PROPERTY = eINSTANCE.getSsdComponent_Base_Property();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.ssp.profile.impl.SsdImpl <em>Ssd</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SsdImpl
		 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SSPProfilePackageImpl#getSsd()
		 * @generated
		 */
		EClass SSD = eINSTANCE.getSsd();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SSD__BASE_PACKAGE = eINSTANCE.getSsd_Base_Package();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SSD__NAME = eINSTANCE.getSsd_Name();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SSD__VERSION = eINSTANCE.getSsd_Version();

		/**
		 * The meta object literal for the '<em><b>Main System</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SSD__MAIN_SYSTEM = eINSTANCE.getSsd_MainSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.ssp.profile.impl.SsdConnectorAndFmiPortImpl <em>Ssd Connector And Fmi Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SsdConnectorAndFmiPortImpl
		 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SSPProfilePackageImpl#getSsdConnectorAndFmiPort()
		 * @generated
		 */
		EClass SSD_CONNECTOR_AND_FMI_PORT = eINSTANCE.getSsdConnectorAndFmiPort();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.ssp.profile.TypeKind <em>Type Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.ssp.profile.TypeKind
		 * @see org.eclipse.papyrus.moka.ssp.profile.impl.SSPProfilePackageImpl#getTypeKind()
		 * @generated
		 */
		EEnum TYPE_KIND = eINSTANCE.getTypeKind();

	}

} //SSPProfilePackage
