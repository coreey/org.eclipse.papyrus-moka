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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='OMSimulatorProfile'"
 * @generated
 */
public interface OMSimulatorPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2018 CEA LIST.\n\n All rights reserved. This program and the accompanying materials\n are made available under the terms of the Eclipse Public License v1.0\n which accompanies this distribution, and is available at\n http://www.eclipse.org/legal/epl-v10.html\n\n Contributors:\n  CEA LIST - Initial API and implementation";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "omsimulatorprofile";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/OMSimulatorProfile/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "omsim";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OMSimulatorPackage eINSTANCE = org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.OMSimulatorPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.TLMInterfaceDefinitionImpl <em>TLM Interface Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.TLMInterfaceDefinitionImpl
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.OMSimulatorPackageImpl#getTLMInterfaceDefinition()
	 * @generated
	 */
	int TLM_INTERFACE_DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Interpolation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLM_INTERFACE_DEFINITION__INTERPOLATION = 0;

	/**
	 * The feature id for the '<em><b>Base Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLM_INTERFACE_DEFINITION__BASE_INTERFACE = 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLM_INTERFACE_DEFINITION__BASE_CLASS = 2;

	/**
	 * The feature id for the '<em><b>Signal Definitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLM_INTERFACE_DEFINITION__SIGNAL_DEFINITIONS = 3;

	/**
	 * The feature id for the '<em><b>Dimensions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLM_INTERFACE_DEFINITION__DIMENSIONS = 4;

	/**
	 * The number of structural features of the '<em>TLM Interface Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLM_INTERFACE_DEFINITION_FEATURE_COUNT = 5;

	/**
	 * The operation id for the '<em>Get Signal Definitions</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLM_INTERFACE_DEFINITION___GET_SIGNAL_DEFINITIONS = 0;

	/**
	 * The number of operations of the '<em>TLM Interface Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLM_INTERFACE_DEFINITION_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.TLMSignalDefinitionImpl <em>TLM Signal Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.TLMSignalDefinitionImpl
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.OMSimulatorPackageImpl#getTLMSignalDefinition()
	 * @generated
	 */
	int TLM_SIGNAL_DEFINITION = 1;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLM_SIGNAL_DEFINITION__BASE_PORT = 0;

	/**
	 * The number of structural features of the '<em>TLM Signal Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLM_SIGNAL_DEFINITION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>TLM Signal Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLM_SIGNAL_DEFINITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.TLMSignalImpl <em>TLM Signal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.TLMSignalImpl
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.OMSimulatorPackageImpl#getTLMSignal()
	 * @generated
	 */
	int TLM_SIGNAL = 2;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLM_SIGNAL__BASE_PORT = 0;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLM_SIGNAL__DEFINITION = 1;

	/**
	 * The number of structural features of the '<em>TLM Signal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLM_SIGNAL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>TLM Signal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLM_SIGNAL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.OMSimulatorBusImpl <em>Bus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.OMSimulatorBusImpl
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.OMSimulatorPackageImpl#getOMSimulatorBus()
	 * @generated
	 */
	int OM_SIMULATOR_BUS = 3;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OM_SIMULATOR_BUS__BASE_PORT = 0;

	/**
	 * The feature id for the '<em><b>Signals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OM_SIMULATOR_BUS__SIGNALS = 1;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OM_SIMULATOR_BUS__DOMAIN = 2;

	/**
	 * The number of structural features of the '<em>Bus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OM_SIMULATOR_BUS_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Bus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OM_SIMULATOR_BUS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.BusConnectionEndImpl <em>Bus Connection End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.BusConnectionEndImpl
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.OMSimulatorPackageImpl#getBusConnectionEnd()
	 * @generated
	 */
	int BUS_CONNECTION_END = 4;

	/**
	 * The feature id for the '<em><b>Base Connector End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONNECTION_END__BASE_CONNECTOR_END = 0;

	/**
	 * The feature id for the '<em><b>Referenced Signal</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONNECTION_END__REFERENCED_SIGNAL = 1;

	/**
	 * The number of structural features of the '<em>Bus Connection End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONNECTION_END_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Bus Connection End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONNECTION_END_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.TLMConnectionImpl <em>TLM Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.TLMConnectionImpl
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.OMSimulatorPackageImpl#getTLMConnection()
	 * @generated
	 */
	int TLM_CONNECTION = 5;

	/**
	 * The feature id for the '<em><b>Timedelay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLM_CONNECTION__TIMEDELAY = 0;

	/**
	 * The feature id for the '<em><b>Impedance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLM_CONNECTION__IMPEDANCE = 1;

	/**
	 * The feature id for the '<em><b>Rotationalimpedance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLM_CONNECTION__ROTATIONALIMPEDANCE = 2;

	/**
	 * The feature id for the '<em><b>Alpha</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLM_CONNECTION__ALPHA = 3;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLM_CONNECTION__BASE_CONNECTOR = 4;

	/**
	 * The number of structural features of the '<em>TLM Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLM_CONNECTION_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>TLM Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLM_CONNECTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.BusConnectorImpl <em>Bus Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.BusConnectorImpl
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.OMSimulatorPackageImpl#getBusConnector()
	 * @generated
	 */
	int BUS_CONNECTOR = 6;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONNECTOR__BASE_CONNECTOR = 0;

	/**
	 * The feature id for the '<em><b>End1 Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONNECTOR__END1_COMPONENT = 1;

	/**
	 * The feature id for the '<em><b>End1 Signals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONNECTOR__END1_SIGNALS = 2;

	/**
	 * The feature id for the '<em><b>End2 Signals</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONNECTOR__END2_SIGNALS = 3;

	/**
	 * The feature id for the '<em><b>End2 Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONNECTOR__END2_COMPONENT = 4;

	/**
	 * The number of structural features of the '<em>Bus Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONNECTOR_FEATURE_COUNT = 5;

	/**
	 * The operation id for the '<em>Get End1 Component</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONNECTOR___GET_END1_COMPONENT = 0;

	/**
	 * The operation id for the '<em>Get End2 Component</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONNECTOR___GET_END2_COMPONENT = 1;

	/**
	 * The operation id for the '<em>Get End1 Signals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONNECTOR___GET_END1_SIGNALS = 2;

	/**
	 * The operation id for the '<em>Get End2 Signals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONNECTOR___GET_END2_SIGNALS = 3;

	/**
	 * The number of operations of the '<em>Bus Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONNECTOR_OPERATION_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.Interpolation <em>Interpolation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.Interpolation
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.OMSimulatorPackageImpl#getInterpolation()
	 * @generated
	 */
	int INTERPOLATION = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMDomain <em>TLM Domain</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMDomain
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.OMSimulatorPackageImpl#getTLMDomain()
	 * @generated
	 */
	int TLM_DOMAIN = 8;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMInterfaceDefinition <em>TLM Interface Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TLM Interface Definition</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMInterfaceDefinition
	 * @generated
	 */
	EClass getTLMInterfaceDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMInterfaceDefinition#getInterpolation <em>Interpolation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interpolation</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMInterfaceDefinition#getInterpolation()
	 * @see #getTLMInterfaceDefinition()
	 * @generated
	 */
	EAttribute getTLMInterfaceDefinition_Interpolation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMInterfaceDefinition#getBase_Interface <em>Base Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Interface</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMInterfaceDefinition#getBase_Interface()
	 * @see #getTLMInterfaceDefinition()
	 * @generated
	 */
	EReference getTLMInterfaceDefinition_Base_Interface();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMInterfaceDefinition#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMInterfaceDefinition#getBase_Class()
	 * @see #getTLMInterfaceDefinition()
	 * @generated
	 */
	EReference getTLMInterfaceDefinition_Base_Class();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMInterfaceDefinition#getSignalDefinitions <em>Signal Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Signal Definitions</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMInterfaceDefinition#getSignalDefinitions()
	 * @see #getTLMInterfaceDefinition()
	 * @generated
	 */
	EReference getTLMInterfaceDefinition_SignalDefinitions();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMInterfaceDefinition#getDimensions <em>Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dimensions</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMInterfaceDefinition#getDimensions()
	 * @see #getTLMInterfaceDefinition()
	 * @generated
	 */
	EAttribute getTLMInterfaceDefinition_Dimensions();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMInterfaceDefinition#getSignalDefinitions() <em>Get Signal Definitions</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Signal Definitions</em>' operation.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMInterfaceDefinition#getSignalDefinitions()
	 * @generated
	 */
	EOperation getTLMInterfaceDefinition__GetSignalDefinitions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMSignalDefinition <em>TLM Signal Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TLM Signal Definition</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMSignalDefinition
	 * @generated
	 */
	EClass getTLMSignalDefinition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMSignalDefinition#getBase_Port <em>Base Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Port</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMSignalDefinition#getBase_Port()
	 * @see #getTLMSignalDefinition()
	 * @generated
	 */
	EReference getTLMSignalDefinition_Base_Port();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMSignal <em>TLM Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TLM Signal</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMSignal
	 * @generated
	 */
	EClass getTLMSignal();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMSignal#getBase_Port <em>Base Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Port</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMSignal#getBase_Port()
	 * @see #getTLMSignal()
	 * @generated
	 */
	EReference getTLMSignal_Base_Port();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMSignal#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMSignal#getDefinition()
	 * @see #getTLMSignal()
	 * @generated
	 */
	EReference getTLMSignal_Definition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorBus <em>Bus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bus</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorBus
	 * @generated
	 */
	EClass getOMSimulatorBus();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorBus#getBase_Port <em>Base Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Port</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorBus#getBase_Port()
	 * @see #getOMSimulatorBus()
	 * @generated
	 */
	EReference getOMSimulatorBus_Base_Port();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorBus#getSignals <em>Signals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Signals</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorBus#getSignals()
	 * @see #getOMSimulatorBus()
	 * @generated
	 */
	EReference getOMSimulatorBus_Signals();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorBus#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Domain</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorBus#getDomain()
	 * @see #getOMSimulatorBus()
	 * @generated
	 */
	EAttribute getOMSimulatorBus_Domain();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnectionEnd <em>Bus Connection End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bus Connection End</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnectionEnd
	 * @generated
	 */
	EClass getBusConnectionEnd();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnectionEnd#getBase_ConnectorEnd <em>Base Connector End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Connector End</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnectionEnd#getBase_ConnectorEnd()
	 * @see #getBusConnectionEnd()
	 * @generated
	 */
	EReference getBusConnectionEnd_Base_ConnectorEnd();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnectionEnd#getReferencedSignal <em>Referenced Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referenced Signal</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnectionEnd#getReferencedSignal()
	 * @see #getBusConnectionEnd()
	 * @generated
	 */
	EReference getBusConnectionEnd_ReferencedSignal();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMConnection <em>TLM Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TLM Connection</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMConnection
	 * @generated
	 */
	EClass getTLMConnection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMConnection#getTimedelay <em>Timedelay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timedelay</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMConnection#getTimedelay()
	 * @see #getTLMConnection()
	 * @generated
	 */
	EAttribute getTLMConnection_Timedelay();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMConnection#getImpedance <em>Impedance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Impedance</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMConnection#getImpedance()
	 * @see #getTLMConnection()
	 * @generated
	 */
	EAttribute getTLMConnection_Impedance();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMConnection#getRotationalimpedance <em>Rotationalimpedance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rotationalimpedance</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMConnection#getRotationalimpedance()
	 * @see #getTLMConnection()
	 * @generated
	 */
	EAttribute getTLMConnection_Rotationalimpedance();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMConnection#getAlpha <em>Alpha</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alpha</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMConnection#getAlpha()
	 * @see #getTLMConnection()
	 * @generated
	 */
	EAttribute getTLMConnection_Alpha();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMConnection#getBase_Connector <em>Base Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Connector</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMConnection#getBase_Connector()
	 * @see #getTLMConnection()
	 * @generated
	 */
	EReference getTLMConnection_Base_Connector();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector <em>Bus Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bus Connector</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector
	 * @generated
	 */
	EClass getBusConnector();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getBase_Connector <em>Base Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Connector</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getBase_Connector()
	 * @see #getBusConnector()
	 * @generated
	 */
	EReference getBusConnector_Base_Connector();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getEnd1Component <em>End1 Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End1 Component</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getEnd1Component()
	 * @see #getBusConnector()
	 * @generated
	 */
	EReference getBusConnector_End1Component();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getEnd1Signals <em>End1 Signals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>End1 Signals</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getEnd1Signals()
	 * @see #getBusConnector()
	 * @generated
	 */
	EReference getBusConnector_End1Signals();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getEnd2Signals <em>End2 Signals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>End2 Signals</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getEnd2Signals()
	 * @see #getBusConnector()
	 * @generated
	 */
	EReference getBusConnector_End2Signals();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getEnd2Component <em>End2 Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End2 Component</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getEnd2Component()
	 * @see #getBusConnector()
	 * @generated
	 */
	EReference getBusConnector_End2Component();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getEnd1Component() <em>Get End1 Component</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get End1 Component</em>' operation.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getEnd1Component()
	 * @generated
	 */
	EOperation getBusConnector__GetEnd1Component();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getEnd2Component() <em>Get End2 Component</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get End2 Component</em>' operation.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getEnd2Component()
	 * @generated
	 */
	EOperation getBusConnector__GetEnd2Component();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getEnd1Signals() <em>Get End1 Signals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get End1 Signals</em>' operation.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getEnd1Signals()
	 * @generated
	 */
	EOperation getBusConnector__GetEnd1Signals();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getEnd2Signals() <em>Get End2 Signals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get End2 Signals</em>' operation.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnector#getEnd2Signals()
	 * @generated
	 */
	EOperation getBusConnector__GetEnd2Signals();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.Interpolation <em>Interpolation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Interpolation</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.Interpolation
	 * @generated
	 */
	EEnum getInterpolation();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMDomain <em>TLM Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>TLM Domain</em>'.
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMDomain
	 * @generated
	 */
	EEnum getTLMDomain();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OMSimulatorFactory getOMSimulatorFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.TLMInterfaceDefinitionImpl <em>TLM Interface Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.TLMInterfaceDefinitionImpl
		 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.OMSimulatorPackageImpl#getTLMInterfaceDefinition()
		 * @generated
		 */
		EClass TLM_INTERFACE_DEFINITION = eINSTANCE.getTLMInterfaceDefinition();

		/**
		 * The meta object literal for the '<em><b>Interpolation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TLM_INTERFACE_DEFINITION__INTERPOLATION = eINSTANCE.getTLMInterfaceDefinition_Interpolation();

		/**
		 * The meta object literal for the '<em><b>Base Interface</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TLM_INTERFACE_DEFINITION__BASE_INTERFACE = eINSTANCE.getTLMInterfaceDefinition_Base_Interface();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TLM_INTERFACE_DEFINITION__BASE_CLASS = eINSTANCE.getTLMInterfaceDefinition_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Signal Definitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TLM_INTERFACE_DEFINITION__SIGNAL_DEFINITIONS = eINSTANCE.getTLMInterfaceDefinition_SignalDefinitions();

		/**
		 * The meta object literal for the '<em><b>Dimensions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TLM_INTERFACE_DEFINITION__DIMENSIONS = eINSTANCE.getTLMInterfaceDefinition_Dimensions();

		/**
		 * The meta object literal for the '<em><b>Get Signal Definitions</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TLM_INTERFACE_DEFINITION___GET_SIGNAL_DEFINITIONS = eINSTANCE.getTLMInterfaceDefinition__GetSignalDefinitions();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.TLMSignalDefinitionImpl <em>TLM Signal Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.TLMSignalDefinitionImpl
		 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.OMSimulatorPackageImpl#getTLMSignalDefinition()
		 * @generated
		 */
		EClass TLM_SIGNAL_DEFINITION = eINSTANCE.getTLMSignalDefinition();

		/**
		 * The meta object literal for the '<em><b>Base Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TLM_SIGNAL_DEFINITION__BASE_PORT = eINSTANCE.getTLMSignalDefinition_Base_Port();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.TLMSignalImpl <em>TLM Signal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.TLMSignalImpl
		 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.OMSimulatorPackageImpl#getTLMSignal()
		 * @generated
		 */
		EClass TLM_SIGNAL = eINSTANCE.getTLMSignal();

		/**
		 * The meta object literal for the '<em><b>Base Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TLM_SIGNAL__BASE_PORT = eINSTANCE.getTLMSignal_Base_Port();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TLM_SIGNAL__DEFINITION = eINSTANCE.getTLMSignal_Definition();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.OMSimulatorBusImpl <em>Bus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.OMSimulatorBusImpl
		 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.OMSimulatorPackageImpl#getOMSimulatorBus()
		 * @generated
		 */
		EClass OM_SIMULATOR_BUS = eINSTANCE.getOMSimulatorBus();

		/**
		 * The meta object literal for the '<em><b>Base Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OM_SIMULATOR_BUS__BASE_PORT = eINSTANCE.getOMSimulatorBus_Base_Port();

		/**
		 * The meta object literal for the '<em><b>Signals</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OM_SIMULATOR_BUS__SIGNALS = eINSTANCE.getOMSimulatorBus_Signals();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OM_SIMULATOR_BUS__DOMAIN = eINSTANCE.getOMSimulatorBus_Domain();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.BusConnectionEndImpl <em>Bus Connection End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.BusConnectionEndImpl
		 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.OMSimulatorPackageImpl#getBusConnectionEnd()
		 * @generated
		 */
		EClass BUS_CONNECTION_END = eINSTANCE.getBusConnectionEnd();

		/**
		 * The meta object literal for the '<em><b>Base Connector End</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUS_CONNECTION_END__BASE_CONNECTOR_END = eINSTANCE.getBusConnectionEnd_Base_ConnectorEnd();

		/**
		 * The meta object literal for the '<em><b>Referenced Signal</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUS_CONNECTION_END__REFERENCED_SIGNAL = eINSTANCE.getBusConnectionEnd_ReferencedSignal();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.TLMConnectionImpl <em>TLM Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.TLMConnectionImpl
		 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.OMSimulatorPackageImpl#getTLMConnection()
		 * @generated
		 */
		EClass TLM_CONNECTION = eINSTANCE.getTLMConnection();

		/**
		 * The meta object literal for the '<em><b>Timedelay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TLM_CONNECTION__TIMEDELAY = eINSTANCE.getTLMConnection_Timedelay();

		/**
		 * The meta object literal for the '<em><b>Impedance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TLM_CONNECTION__IMPEDANCE = eINSTANCE.getTLMConnection_Impedance();

		/**
		 * The meta object literal for the '<em><b>Rotationalimpedance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TLM_CONNECTION__ROTATIONALIMPEDANCE = eINSTANCE.getTLMConnection_Rotationalimpedance();

		/**
		 * The meta object literal for the '<em><b>Alpha</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TLM_CONNECTION__ALPHA = eINSTANCE.getTLMConnection_Alpha();

		/**
		 * The meta object literal for the '<em><b>Base Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TLM_CONNECTION__BASE_CONNECTOR = eINSTANCE.getTLMConnection_Base_Connector();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.BusConnectorImpl <em>Bus Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.BusConnectorImpl
		 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.OMSimulatorPackageImpl#getBusConnector()
		 * @generated
		 */
		EClass BUS_CONNECTOR = eINSTANCE.getBusConnector();

		/**
		 * The meta object literal for the '<em><b>Base Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUS_CONNECTOR__BASE_CONNECTOR = eINSTANCE.getBusConnector_Base_Connector();

		/**
		 * The meta object literal for the '<em><b>End1 Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUS_CONNECTOR__END1_COMPONENT = eINSTANCE.getBusConnector_End1Component();

		/**
		 * The meta object literal for the '<em><b>End1 Signals</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUS_CONNECTOR__END1_SIGNALS = eINSTANCE.getBusConnector_End1Signals();

		/**
		 * The meta object literal for the '<em><b>End2 Signals</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUS_CONNECTOR__END2_SIGNALS = eINSTANCE.getBusConnector_End2Signals();

		/**
		 * The meta object literal for the '<em><b>End2 Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUS_CONNECTOR__END2_COMPONENT = eINSTANCE.getBusConnector_End2Component();

		/**
		 * The meta object literal for the '<em><b>Get End1 Component</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BUS_CONNECTOR___GET_END1_COMPONENT = eINSTANCE.getBusConnector__GetEnd1Component();

		/**
		 * The meta object literal for the '<em><b>Get End2 Component</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BUS_CONNECTOR___GET_END2_COMPONENT = eINSTANCE.getBusConnector__GetEnd2Component();

		/**
		 * The meta object literal for the '<em><b>Get End1 Signals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BUS_CONNECTOR___GET_END1_SIGNALS = eINSTANCE.getBusConnector__GetEnd1Signals();

		/**
		 * The meta object literal for the '<em><b>Get End2 Signals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BUS_CONNECTOR___GET_END2_SIGNALS = eINSTANCE.getBusConnector__GetEnd2Signals();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.Interpolation <em>Interpolation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.Interpolation
		 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.OMSimulatorPackageImpl#getInterpolation()
		 * @generated
		 */
		EEnum INTERPOLATION = eINSTANCE.getInterpolation();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMDomain <em>TLM Domain</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMDomain
		 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.impl.OMSimulatorPackageImpl#getTLMDomain()
		 * @generated
		 */
		EEnum TLM_DOMAIN = eINSTANCE.getTLMDomain();

	}

} //OMSimulatorPackage
