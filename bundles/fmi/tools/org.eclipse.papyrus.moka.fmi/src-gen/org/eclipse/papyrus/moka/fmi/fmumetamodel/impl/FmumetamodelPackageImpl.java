/**
 * Copyright (c) 2019 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.moka.fmi.fmumetamodel.impl;

import java.io.File;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.moka.fmi.fmumetamodel.AbstractFile;
import org.eclipse.papyrus.moka.fmi.fmumetamodel.ArchiveToUnzipInFMU;
import org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle;
import org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelFactory;
import org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelPackage;
import org.eclipse.papyrus.moka.fmi.fmumetamodel.FolderToCreateInFMU;
import org.eclipse.papyrus.moka.fmi.fmumetamodel.JavaFileProxy;

import org.eclipse.papyrus.moka.fmi.modeldescription.FmiPackage;

import org.eclipse.uml2.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FmumetamodelPackageImpl extends EPackageImpl implements FmumetamodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fmuBundleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass folderToCreateInFMUEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass archiveToUnzipInFMUEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaFileProxyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType fileEDataType = null;

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
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FmumetamodelPackageImpl() {
		super(eNS_URI, FmumetamodelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link FmumetamodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FmumetamodelPackage init() {
		if (isInited) return (FmumetamodelPackage)EPackage.Registry.INSTANCE.getEPackage(FmumetamodelPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredFmumetamodelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		FmumetamodelPackageImpl theFmumetamodelPackage = registeredFmumetamodelPackage instanceof FmumetamodelPackageImpl ? (FmumetamodelPackageImpl)registeredFmumetamodelPackage : new FmumetamodelPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		FmiPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theFmumetamodelPackage.createPackageContents();

		// Initialize created meta-data
		theFmumetamodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFmumetamodelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FmumetamodelPackage.eNS_URI, theFmumetamodelPackage);
		return theFmumetamodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFMUBundle() {
		return fmuBundleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFMUBundle_ModelDescription() {
		return (EReference)fmuBundleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFMUBundle_ResourcesFiles() {
		return (EReference)fmuBundleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFMUBundle_Win32Files() {
		return (EReference)fmuBundleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFMUBundle_Win64Files() {
		return (EReference)fmuBundleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFMUBundle_Linux32Files() {
		return (EReference)fmuBundleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFMUBundle_Linux64Files() {
		return (EReference)fmuBundleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFMUBundle_Darwin64Files() {
		return (EReference)fmuBundleEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFMUBundle_Darwin32Files() {
		return (EReference)fmuBundleEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFMUBundle_DocumentationFiles() {
		return (EReference)fmuBundleEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFMUBundle_SourceFiles() {
		return (EReference)fmuBundleEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFMUBundle_RootFiles() {
		return (EReference)fmuBundleEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractFile() {
		return abstractFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractFile_Name() {
		return (EAttribute)abstractFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFolderToCreateInFMU() {
		return folderToCreateInFMUEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFolderToCreateInFMU_Children() {
		return (EReference)folderToCreateInFMUEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getArchiveToUnzipInFMU() {
		return archiveToUnzipInFMUEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getArchiveToUnzipInFMU_ArchiveFile() {
		return (EAttribute)archiveToUnzipInFMUEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJavaFileProxy() {
		return javaFileProxyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJavaFileProxy_File() {
		return (EAttribute)javaFileProxyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getFile() {
		return fileEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FmumetamodelFactory getFmumetamodelFactory() {
		return (FmumetamodelFactory)getEFactoryInstance();
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
		fmuBundleEClass = createEClass(FMU_BUNDLE);
		createEReference(fmuBundleEClass, FMU_BUNDLE__MODEL_DESCRIPTION);
		createEReference(fmuBundleEClass, FMU_BUNDLE__RESOURCES_FILES);
		createEReference(fmuBundleEClass, FMU_BUNDLE__WIN32_FILES);
		createEReference(fmuBundleEClass, FMU_BUNDLE__WIN64_FILES);
		createEReference(fmuBundleEClass, FMU_BUNDLE__LINUX32_FILES);
		createEReference(fmuBundleEClass, FMU_BUNDLE__LINUX64_FILES);
		createEReference(fmuBundleEClass, FMU_BUNDLE__DARWIN64_FILES);
		createEReference(fmuBundleEClass, FMU_BUNDLE__DARWIN32_FILES);
		createEReference(fmuBundleEClass, FMU_BUNDLE__DOCUMENTATION_FILES);
		createEReference(fmuBundleEClass, FMU_BUNDLE__SOURCE_FILES);
		createEReference(fmuBundleEClass, FMU_BUNDLE__ROOT_FILES);

		abstractFileEClass = createEClass(ABSTRACT_FILE);
		createEAttribute(abstractFileEClass, ABSTRACT_FILE__NAME);

		folderToCreateInFMUEClass = createEClass(FOLDER_TO_CREATE_IN_FMU);
		createEReference(folderToCreateInFMUEClass, FOLDER_TO_CREATE_IN_FMU__CHILDREN);

		archiveToUnzipInFMUEClass = createEClass(ARCHIVE_TO_UNZIP_IN_FMU);
		createEAttribute(archiveToUnzipInFMUEClass, ARCHIVE_TO_UNZIP_IN_FMU__ARCHIVE_FILE);

		javaFileProxyEClass = createEClass(JAVA_FILE_PROXY);
		createEAttribute(javaFileProxyEClass, JAVA_FILE_PROXY__FILE);

		// Create data types
		fileEDataType = createEDataType(FILE);
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
		FmiPackage theFmiPackage = (FmiPackage)EPackage.Registry.INSTANCE.getEPackage(FmiPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		folderToCreateInFMUEClass.getESuperTypes().add(this.getAbstractFile());
		archiveToUnzipInFMUEClass.getESuperTypes().add(this.getAbstractFile());
		javaFileProxyEClass.getESuperTypes().add(this.getAbstractFile());

		// Initialize classes, features, and operations; add parameters
		initEClass(fmuBundleEClass, FMUBundle.class, "FMUBundle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFMUBundle_ModelDescription(), theFmiPackage.getFmiModelDescriptionType(), null, "modelDescription", null, 0, 1, FMUBundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFMUBundle_ResourcesFiles(), this.getAbstractFile(), null, "resourcesFiles", null, 0, -1, FMUBundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFMUBundle_Win32Files(), this.getAbstractFile(), null, "win32Files", null, 0, -1, FMUBundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFMUBundle_Win64Files(), this.getAbstractFile(), null, "win64Files", null, 0, -1, FMUBundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFMUBundle_Linux32Files(), this.getAbstractFile(), null, "linux32Files", null, 0, -1, FMUBundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFMUBundle_Linux64Files(), this.getAbstractFile(), null, "linux64Files", null, 0, -1, FMUBundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFMUBundle_Darwin64Files(), this.getAbstractFile(), null, "darwin64Files", null, 0, -1, FMUBundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFMUBundle_Darwin32Files(), this.getAbstractFile(), null, "darwin32Files", null, 0, -1, FMUBundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFMUBundle_DocumentationFiles(), this.getAbstractFile(), null, "documentationFiles", null, 0, -1, FMUBundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFMUBundle_SourceFiles(), this.getAbstractFile(), null, "sourceFiles", null, 0, -1, FMUBundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFMUBundle_RootFiles(), this.getAbstractFile(), null, "rootFiles", null, 0, -1, FMUBundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(abstractFileEClass, AbstractFile.class, "AbstractFile", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractFile_Name(), theTypesPackage.getString(), "name", null, 0, 1, AbstractFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(folderToCreateInFMUEClass, FolderToCreateInFMU.class, "FolderToCreateInFMU", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFolderToCreateInFMU_Children(), this.getAbstractFile(), null, "children", null, 0, -1, FolderToCreateInFMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(archiveToUnzipInFMUEClass, ArchiveToUnzipInFMU.class, "ArchiveToUnzipInFMU", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArchiveToUnzipInFMU_ArchiveFile(), this.getFile(), "archiveFile", null, 1, 1, ArchiveToUnzipInFMU.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(javaFileProxyEClass, JavaFileProxy.class, "JavaFileProxy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaFileProxy_File(), this.getFile(), "file", null, 1, 1, JavaFileProxy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize data types
		initEDataType(fileEDataType, File.class, "File", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

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
		  (fileEDataType,
		   source,
		   new String[] {
			   "originalName", "File"
		   });
	}

} //FmumetamodelPackageImpl
