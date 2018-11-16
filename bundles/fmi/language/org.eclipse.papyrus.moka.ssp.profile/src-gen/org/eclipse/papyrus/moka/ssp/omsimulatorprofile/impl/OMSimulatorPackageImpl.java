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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.BusConnectionEnd;
import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.Interpolation;
import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorBus;
import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorFactory;
import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage;
import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMConnection;
import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMDomain;
import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMInterfaceDefinition;
import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMSignal;
import org.eclipse.papyrus.moka.ssp.omsimulatorprofile.TLMSignalDefinition;

import org.eclipse.uml2.types.TypesPackage;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OMSimulatorPackageImpl extends EPackageImpl implements OMSimulatorPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2018 CEA LIST.\n\n All rights reserved. This program and the accompanying materials\n are made available under the terms of the Eclipse Public License v1.0\n which accompanies this distribution, and is available at\n http://www.eclipse.org/legal/epl-v10.html\n\n Contributors:\n  CEA LIST - Initial API and implementation";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tlmInterfaceDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tlmSignalDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tlmSignalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass omSimulatorBusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass busConnectionEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tlmConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum interpolationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum tlmDomainEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.moka.ssp.omsimulatorprofile.OMSimulatorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OMSimulatorPackageImpl() {
		super(eNS_URI, OMSimulatorFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link OMSimulatorPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OMSimulatorPackage init() {
		if (isInited) return (OMSimulatorPackage)EPackage.Registry.INSTANCE.getEPackage(OMSimulatorPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredOMSimulatorPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		OMSimulatorPackageImpl theOMSimulatorPackage = registeredOMSimulatorPackage instanceof OMSimulatorPackageImpl ? (OMSimulatorPackageImpl)registeredOMSimulatorPackage : new OMSimulatorPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		UMLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theOMSimulatorPackage.createPackageContents();

		// Initialize created meta-data
		theOMSimulatorPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOMSimulatorPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OMSimulatorPackage.eNS_URI, theOMSimulatorPackage);
		return theOMSimulatorPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTLMInterfaceDefinition() {
		return tlmInterfaceDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTLMInterfaceDefinition_Interpolation() {
		return (EAttribute)tlmInterfaceDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTLMInterfaceDefinition_Base_Interface() {
		return (EReference)tlmInterfaceDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTLMInterfaceDefinition_Base_Class() {
		return (EReference)tlmInterfaceDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTLMInterfaceDefinition_SignalDefinitions() {
		return (EReference)tlmInterfaceDefinitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTLMInterfaceDefinition_Dimensions() {
		return (EAttribute)tlmInterfaceDefinitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTLMInterfaceDefinition__GetSignalDefinitions() {
		return tlmInterfaceDefinitionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTLMSignalDefinition() {
		return tlmSignalDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTLMSignalDefinition_Base_Port() {
		return (EReference)tlmSignalDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTLMSignal() {
		return tlmSignalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTLMSignal_Base_Port() {
		return (EReference)tlmSignalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTLMSignal_Definition() {
		return (EReference)tlmSignalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOMSimulatorBus() {
		return omSimulatorBusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOMSimulatorBus_Base_Port() {
		return (EReference)omSimulatorBusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOMSimulatorBus_Signals() {
		return (EReference)omSimulatorBusEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOMSimulatorBus_Domain() {
		return (EAttribute)omSimulatorBusEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusConnectionEnd() {
		return busConnectionEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusConnectionEnd_Base_ConnectorEnd() {
		return (EReference)busConnectionEndEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusConnectionEnd_ReferencedSignal() {
		return (EReference)busConnectionEndEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTLMConnection() {
		return tlmConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTLMConnection_Timedelay() {
		return (EAttribute)tlmConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTLMConnection_Impedance() {
		return (EAttribute)tlmConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTLMConnection_Rotationalimpedance() {
		return (EAttribute)tlmConnectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTLMConnection_Alpha() {
		return (EAttribute)tlmConnectionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTLMConnection_Base_Connector() {
		return (EReference)tlmConnectionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getInterpolation() {
		return interpolationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTLMDomain() {
		return tlmDomainEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OMSimulatorFactory getOMSimulatorFactory() {
		return (OMSimulatorFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		tlmInterfaceDefinitionEClass = createEClass(TLM_INTERFACE_DEFINITION);
		createEAttribute(tlmInterfaceDefinitionEClass, TLM_INTERFACE_DEFINITION__INTERPOLATION);
		createEReference(tlmInterfaceDefinitionEClass, TLM_INTERFACE_DEFINITION__BASE_INTERFACE);
		createEReference(tlmInterfaceDefinitionEClass, TLM_INTERFACE_DEFINITION__BASE_CLASS);
		createEReference(tlmInterfaceDefinitionEClass, TLM_INTERFACE_DEFINITION__SIGNAL_DEFINITIONS);
		createEAttribute(tlmInterfaceDefinitionEClass, TLM_INTERFACE_DEFINITION__DIMENSIONS);
		createEOperation(tlmInterfaceDefinitionEClass, TLM_INTERFACE_DEFINITION___GET_SIGNAL_DEFINITIONS);

		tlmSignalDefinitionEClass = createEClass(TLM_SIGNAL_DEFINITION);
		createEReference(tlmSignalDefinitionEClass, TLM_SIGNAL_DEFINITION__BASE_PORT);

		tlmSignalEClass = createEClass(TLM_SIGNAL);
		createEReference(tlmSignalEClass, TLM_SIGNAL__BASE_PORT);
		createEReference(tlmSignalEClass, TLM_SIGNAL__DEFINITION);

		omSimulatorBusEClass = createEClass(OM_SIMULATOR_BUS);
		createEReference(omSimulatorBusEClass, OM_SIMULATOR_BUS__BASE_PORT);
		createEReference(omSimulatorBusEClass, OM_SIMULATOR_BUS__SIGNALS);
		createEAttribute(omSimulatorBusEClass, OM_SIMULATOR_BUS__DOMAIN);

		busConnectionEndEClass = createEClass(BUS_CONNECTION_END);
		createEReference(busConnectionEndEClass, BUS_CONNECTION_END__BASE_CONNECTOR_END);
		createEReference(busConnectionEndEClass, BUS_CONNECTION_END__REFERENCED_SIGNAL);

		tlmConnectionEClass = createEClass(TLM_CONNECTION);
		createEAttribute(tlmConnectionEClass, TLM_CONNECTION__TIMEDELAY);
		createEAttribute(tlmConnectionEClass, TLM_CONNECTION__IMPEDANCE);
		createEAttribute(tlmConnectionEClass, TLM_CONNECTION__ROTATIONALIMPEDANCE);
		createEAttribute(tlmConnectionEClass, TLM_CONNECTION__ALPHA);
		createEReference(tlmConnectionEClass, TLM_CONNECTION__BASE_CONNECTOR);

		// Create enums
		interpolationEEnum = createEEnum(INTERPOLATION);
		tlmDomainEEnum = createEEnum(TLM_DOMAIN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(tlmInterfaceDefinitionEClass, TLMInterfaceDefinition.class, "TLMInterfaceDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTLMInterfaceDefinition_Interpolation(), this.getInterpolation(), "interpolation", null, 1, 1, TLMInterfaceDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTLMInterfaceDefinition_Base_Interface(), theUMLPackage.getInterface(), null, "base_Interface", null, 1, 1, TLMInterfaceDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTLMInterfaceDefinition_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, TLMInterfaceDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTLMInterfaceDefinition_SignalDefinitions(), this.getTLMSignalDefinition(), null, "signalDefinitions", null, 1, -1, TLMInterfaceDefinition.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getTLMInterfaceDefinition_Dimensions(), theTypesPackage.getInteger(), "dimensions", null, 1, 1, TLMInterfaceDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEOperation(getTLMInterfaceDefinition__GetSignalDefinitions(), this.getTLMSignalDefinition(), "getSignalDefinitions", 0, -1, IS_UNIQUE, !IS_ORDERED);

		initEClass(tlmSignalDefinitionEClass, TLMSignalDefinition.class, "TLMSignalDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTLMSignalDefinition_Base_Port(), theUMLPackage.getPort(), null, "base_Port", null, 1, 1, TLMSignalDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(tlmSignalEClass, TLMSignal.class, "TLMSignal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTLMSignal_Base_Port(), theUMLPackage.getPort(), null, "base_Port", null, 1, 1, TLMSignal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTLMSignal_Definition(), this.getTLMSignalDefinition(), null, "definition", null, 1, 1, TLMSignal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(omSimulatorBusEClass, OMSimulatorBus.class, "OMSimulatorBus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOMSimulatorBus_Base_Port(), theUMLPackage.getPort(), null, "base_Port", null, 1, 1, OMSimulatorBus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOMSimulatorBus_Signals(), theUMLPackage.getPort(), null, "signals", null, 0, -1, OMSimulatorBus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getOMSimulatorBus_Domain(), this.getTLMDomain(), "domain", null, 0, -1, OMSimulatorBus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(busConnectionEndEClass, BusConnectionEnd.class, "BusConnectionEnd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBusConnectionEnd_Base_ConnectorEnd(), theUMLPackage.getConnectorEnd(), null, "base_ConnectorEnd", null, 1, 1, BusConnectionEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBusConnectionEnd_ReferencedSignal(), theUMLPackage.getPort(), null, "referencedSignal", null, 0, -1, BusConnectionEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(tlmConnectionEClass, TLMConnection.class, "TLMConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTLMConnection_Timedelay(), theTypesPackage.getReal(), "timedelay", null, 1, 1, TLMConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getTLMConnection_Impedance(), theTypesPackage.getReal(), "impedance", null, 0, 1, TLMConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getTLMConnection_Rotationalimpedance(), theTypesPackage.getReal(), "rotationalimpedance", null, 0, 1, TLMConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getTLMConnection_Alpha(), theTypesPackage.getReal(), "alpha", null, 0, 1, TLMConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTLMConnection_Base_Connector(), theUMLPackage.getConnector(), null, "base_Connector", null, 1, 1, TLMConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(interpolationEEnum, Interpolation.class, "Interpolation");
		addEEnumLiteral(interpolationEEnum, Interpolation.NONE);
		addEEnumLiteral(interpolationEEnum, Interpolation.COARSEGRAINED);
		addEEnumLiteral(interpolationEEnum, Interpolation.FINEGRAINED);

		initEEnum(tlmDomainEEnum, TLMDomain.class, "TLMDomain");
		addEEnumLiteral(tlmDomainEEnum, TLMDomain.HYDRAULIC);
		addEEnumLiteral(tlmDomainEEnum, TLMDomain.MECHANICAL);
		addEEnumLiteral(tlmDomainEEnum, TLMDomain.ROTATIONAL);
		addEEnumLiteral(tlmDomainEEnum, TLMDomain.ELECTRIC);
		addEEnumLiteral(tlmDomainEEnum, TLMDomain.INPUT);
		addEEnumLiteral(tlmDomainEEnum, TLMDomain.OUTPUT);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/uml2/2.0.0/UML
		createUMLAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/uml2/2.0.0/UML</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createUMLAnnotations() {
		String source = "http://www.eclipse.org/uml2/2.0.0/UML";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "originalName", "OMSimulatorProfile"
		   });
		addAnnotation
		  (getTLMConnection_Timedelay(),
		   source,
		   new String[] {
			   "originalName", "time delay"
		   });
		addAnnotation
		  (getTLMConnection_Rotationalimpedance(),
		   source,
		   new String[] {
			   "originalName", "rotational impedance"
		   });
	}

} //OMSimulatorPackageImpl
