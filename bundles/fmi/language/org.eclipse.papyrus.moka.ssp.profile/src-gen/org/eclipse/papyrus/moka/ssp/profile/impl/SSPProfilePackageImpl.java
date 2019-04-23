/**
 *  Copyright (c) 2018,  IncQuery Labs Ltd and CEA List.
 *  All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *  IncQuery Labs Ltd - initial API and implementation
 *  CEA List 
 */
package org.eclipse.papyrus.moka.ssp.profile.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.moka.fmi.fmiprofile.FMIProfilePackage;

import org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelPackage;

import org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage;

import org.eclipse.papyrus.moka.ssp.profile.SSPProfileFactory;
import org.eclipse.papyrus.moka.ssp.profile.SSPProfilePackage;
import org.eclipse.papyrus.moka.ssp.profile.Ssd;
import org.eclipse.papyrus.moka.ssp.profile.SsdComponent;
import org.eclipse.papyrus.moka.ssp.profile.SsdConnection;
import org.eclipse.papyrus.moka.ssp.profile.SsdConnector;
import org.eclipse.papyrus.moka.ssp.profile.SsdConnectorAndFmiPort;
import org.eclipse.papyrus.moka.ssp.profile.SsdElement;
import org.eclipse.papyrus.moka.ssp.profile.SsdSignalDictionaryReference;
import org.eclipse.papyrus.moka.ssp.profile.SsdSystem;
import org.eclipse.papyrus.moka.ssp.profile.TypeKind;

import org.eclipse.papyrus.sysml14.deprecatedelements.DeprecatedelementsPackage;

import org.eclipse.papyrus.sysml14.sysmlPackage;

import org.eclipse.uml2.types.TypesPackage;

import org.eclipse.uml2.uml.UMLPackage;

import org.eclipse.uml2.uml.profile.standard.StandardPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SSPProfilePackageImpl extends EPackageImpl implements SSPProfilePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " Copyright (c) 2018,  IncQuery Labs Ltd and CEA List.\n All rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License 2.0\nwhich accompanies this distribution, and is available at\nhttps://www.eclipse.org/legal/epl-2.0 \r\n\r\nSPDX-License-Identifier: EPL-2.0\n \nContributors:\n IncQuery Labs Ltd - initial API and implementation\n CEA List ";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ssdConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ssdConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ssdElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ssdSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ssdSignalDictionaryReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ssdComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ssdEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ssdConnectorAndFmiPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum typeKindEEnum = null;

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
	 * @see org.eclipse.papyrus.moka.ssp.profile.SSPProfilePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SSPProfilePackageImpl() {
		super(eNS_URI, SSPProfileFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SSPProfilePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SSPProfilePackage init() {
		if (isInited) return (SSPProfilePackage)EPackage.Registry.INSTANCE.getEPackage(SSPProfilePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredSSPProfilePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		SSPProfilePackageImpl theSSPProfilePackage = registeredSSPProfilePackage instanceof SSPProfilePackageImpl ? (SSPProfilePackageImpl)registeredSSPProfilePackage : new SSPProfilePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		FMIProfilePackage.eINSTANCE.eClass();
		StandardPackage.eINSTANCE.eClass();
		sysmlPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		UMLPackage.eINSTANCE.eClass();
		FmiPackage.eINSTANCE.eClass();
		FmumetamodelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSSPProfilePackage.createPackageContents();

		// Initialize created meta-data
		theSSPProfilePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSSPProfilePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SSPProfilePackage.eNS_URI, theSSPProfilePackage);
		return theSSPProfilePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSsdConnection() {
		return ssdConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSsdConnection_Base_Connector() {
		return (EReference)ssdConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSsdConnection_Start() {
		return (EReference)ssdConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSsdConnection_End() {
		return (EReference)ssdConnectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSsdConnection_StartSsdProperty() {
		return (EReference)ssdConnectionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSsdConnection_EndSsdProperty() {
		return (EReference)ssdConnectionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSsdConnector() {
		return ssdConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSsdConnector_SSDDescription() {
		return (EAttribute)ssdConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSsdConnector_TypeKind() {
		return (EAttribute)ssdConnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSsdElement() {
		return ssdElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSsdElement_ID() {
		return (EAttribute)ssdElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSsdSystem() {
		return ssdSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSsdSystem_Base_Class() {
		return (EReference)ssdSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSsdSignalDictionaryReference() {
		return ssdSignalDictionaryReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSsdSignalDictionaryReference_Base_Class() {
		return (EReference)ssdSignalDictionaryReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSsdComponent() {
		return ssdComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSsdComponent_Source() {
		return (EAttribute)ssdComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSsdComponent_Type() {
		return (EAttribute)ssdComponentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSsdComponent_Fmu() {
		return (EReference)ssdComponentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSsdComponent_Base_Property() {
		return (EReference)ssdComponentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSsd() {
		return ssdEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSsd_Base_Package() {
		return (EReference)ssdEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSsd_Name() {
		return (EAttribute)ssdEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSsd_Version() {
		return (EAttribute)ssdEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSsd_MainSystem() {
		return (EReference)ssdEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSsdConnectorAndFmiPort() {
		return ssdConnectorAndFmiPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTypeKind() {
		return typeKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SSPProfileFactory getSSPProfileFactory() {
		return (SSPProfileFactory)getEFactoryInstance();
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
		ssdConnectionEClass = createEClass(SSD_CONNECTION);
		createEReference(ssdConnectionEClass, SSD_CONNECTION__BASE_CONNECTOR);
		createEReference(ssdConnectionEClass, SSD_CONNECTION__START);
		createEReference(ssdConnectionEClass, SSD_CONNECTION__END);
		createEReference(ssdConnectionEClass, SSD_CONNECTION__START_SSD_PROPERTY);
		createEReference(ssdConnectionEClass, SSD_CONNECTION__END_SSD_PROPERTY);

		ssdConnectorEClass = createEClass(SSD_CONNECTOR);
		createEAttribute(ssdConnectorEClass, SSD_CONNECTOR__SSD_DESCRIPTION);
		createEAttribute(ssdConnectorEClass, SSD_CONNECTOR__TYPE_KIND);

		ssdElementEClass = createEClass(SSD_ELEMENT);
		createEAttribute(ssdElementEClass, SSD_ELEMENT__ID);

		ssdSystemEClass = createEClass(SSD_SYSTEM);
		createEReference(ssdSystemEClass, SSD_SYSTEM__BASE_CLASS);

		ssdSignalDictionaryReferenceEClass = createEClass(SSD_SIGNAL_DICTIONARY_REFERENCE);
		createEReference(ssdSignalDictionaryReferenceEClass, SSD_SIGNAL_DICTIONARY_REFERENCE__BASE_CLASS);

		ssdComponentEClass = createEClass(SSD_COMPONENT);
		createEAttribute(ssdComponentEClass, SSD_COMPONENT__SOURCE);
		createEAttribute(ssdComponentEClass, SSD_COMPONENT__TYPE);
		createEReference(ssdComponentEClass, SSD_COMPONENT__FMU);
		createEReference(ssdComponentEClass, SSD_COMPONENT__BASE_PROPERTY);

		ssdEClass = createEClass(SSD);
		createEReference(ssdEClass, SSD__BASE_PACKAGE);
		createEAttribute(ssdEClass, SSD__NAME);
		createEAttribute(ssdEClass, SSD__VERSION);
		createEReference(ssdEClass, SSD__MAIN_SYSTEM);

		ssdConnectorAndFmiPortEClass = createEClass(SSD_CONNECTOR_AND_FMI_PORT);

		// Create enums
		typeKindEEnum = createEEnum(TYPE_KIND);
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
		DeprecatedelementsPackage theDeprecatedelementsPackage = (DeprecatedelementsPackage)EPackage.Registry.INSTANCE.getEPackage(DeprecatedelementsPackage.eNS_URI);
		FMIProfilePackage theFMIProfilePackage = (FMIProfilePackage)EPackage.Registry.INSTANCE.getEPackage(FMIProfilePackage.eNS_URI);

		// Add supertypes to classes
		ssdConnectorEClass.getESuperTypes().add(theDeprecatedelementsPackage.getFlowPort());
		ssdSystemEClass.getESuperTypes().add(this.getSsdElement());
		ssdSignalDictionaryReferenceEClass.getESuperTypes().add(this.getSsdElement());
		ssdComponentEClass.getESuperTypes().add(this.getSsdElement());
		ssdConnectorAndFmiPortEClass.getESuperTypes().add(theFMIProfilePackage.getFMIPort());
		ssdConnectorAndFmiPortEClass.getESuperTypes().add(this.getSsdConnector());

		// Initialize classes and features; add operations and parameters
		initEClass(ssdConnectionEClass, SsdConnection.class, "SsdConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSsdConnection_Base_Connector(), theUMLPackage.getConnector(), null, "base_Connector", null, 1, 1, SsdConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSsdConnection_Start(), this.getSsdConnector(), null, "start", null, 1, 1, SsdConnection.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getSsdConnection_End(), this.getSsdConnector(), null, "end", null, 1, 1, SsdConnection.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getSsdConnection_StartSsdProperty(), theUMLPackage.getProperty(), null, "startSsdProperty", null, 0, 1, SsdConnection.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getSsdConnection_EndSsdProperty(), theUMLPackage.getProperty(), null, "endSsdProperty", null, 0, 1, SsdConnection.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		initEClass(ssdConnectorEClass, SsdConnector.class, "SsdConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSsdConnector_SSDDescription(), ecorePackage.getEString(), "SSDDescription", null, 1, 1, SsdConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSsdConnector_TypeKind(), this.getTypeKind(), "typeKind", null, 1, 1, SsdConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(ssdElementEClass, SsdElement.class, "SsdElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSsdElement_ID(), ecorePackage.getEString(), "ID", null, 0, 1, SsdElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(ssdSystemEClass, SsdSystem.class, "SsdSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSsdSystem_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, SsdSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(ssdSignalDictionaryReferenceEClass, SsdSignalDictionaryReference.class, "SsdSignalDictionaryReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSsdSignalDictionaryReference_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, SsdSignalDictionaryReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(ssdComponentEClass, SsdComponent.class, "SsdComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSsdComponent_Source(), ecorePackage.getEString(), "source", null, 1, 1, SsdComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSsdComponent_Type(), ecorePackage.getEString(), "type", null, 1, 1, SsdComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSsdComponent_Fmu(), theFMIProfilePackage.getFMU(), null, "fmu", null, 0, 1, SsdComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSsdComponent_Base_Property(), theUMLPackage.getProperty(), null, "base_Property", null, 1, 1, SsdComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(ssdEClass, Ssd.class, "Ssd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSsd_Base_Package(), theUMLPackage.getPackage(), null, "base_Package", null, 1, 1, Ssd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSsd_Name(), ecorePackage.getEString(), "name", null, 1, 1, Ssd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSsd_Version(), ecorePackage.getEString(), "version", null, 1, 1, Ssd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSsd_MainSystem(), this.getSsdSystem(), null, "mainSystem", null, 1, 1, Ssd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(ssdConnectorAndFmiPortEClass, SsdConnectorAndFmiPort.class, "SsdConnectorAndFmiPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(typeKindEEnum, TypeKind.class, "TypeKind");
		addEEnumLiteral(typeKindEEnum, TypeKind.INPUT_LITERAL);
		addEEnumLiteral(typeKindEEnum, TypeKind.OUTPUT_LITERAL);
		addEEnumLiteral(typeKindEEnum, TypeKind.PARAMETER_LITERAL);
		addEEnumLiteral(typeKindEEnum, TypeKind.CALCULATED_PARAMETER_LITERAL);
		addEEnumLiteral(typeKindEEnum, TypeKind.INOUT_LITERAL);

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
			   "originalName", "SSPProfile"
		   });
	}

} //SSPProfilePackageImpl
