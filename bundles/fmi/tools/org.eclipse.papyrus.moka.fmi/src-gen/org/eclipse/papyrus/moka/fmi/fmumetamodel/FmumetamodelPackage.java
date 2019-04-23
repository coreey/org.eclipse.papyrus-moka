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
package org.eclipse.papyrus.moka.fmi.fmumetamodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelFactory
 * @model kind="package"
 * @generated
 */
public interface FmumetamodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "fmumetamodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/Papyrus/fmu/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "fmu";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FmumetamodelPackage eINSTANCE = org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FmumetamodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FMUBundleImpl <em>FMU Bundle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FMUBundleImpl
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FmumetamodelPackageImpl#getFMUBundle()
	 * @generated
	 */
	int FMU_BUNDLE = 0;

	/**
	 * The feature id for the '<em><b>Model Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_BUNDLE__MODEL_DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Resources Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_BUNDLE__RESOURCES_FILES = 1;

	/**
	 * The feature id for the '<em><b>Win32 Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_BUNDLE__WIN32_FILES = 2;

	/**
	 * The feature id for the '<em><b>Win64 Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_BUNDLE__WIN64_FILES = 3;

	/**
	 * The feature id for the '<em><b>Linux32 Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_BUNDLE__LINUX32_FILES = 4;

	/**
	 * The feature id for the '<em><b>Linux64 Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_BUNDLE__LINUX64_FILES = 5;

	/**
	 * The feature id for the '<em><b>Darwin64 Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_BUNDLE__DARWIN64_FILES = 6;

	/**
	 * The feature id for the '<em><b>Darwin32 Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_BUNDLE__DARWIN32_FILES = 7;

	/**
	 * The feature id for the '<em><b>Documentation Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_BUNDLE__DOCUMENTATION_FILES = 8;

	/**
	 * The feature id for the '<em><b>Source Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_BUNDLE__SOURCE_FILES = 9;

	/**
	 * The feature id for the '<em><b>Root Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_BUNDLE__ROOT_FILES = 10;

	/**
	 * The number of structural features of the '<em>FMU Bundle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_BUNDLE_FEATURE_COUNT = 11;

	/**
	 * The number of operations of the '<em>FMU Bundle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FMU_BUNDLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.AbstractFileImpl <em>Abstract File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.AbstractFileImpl
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FmumetamodelPackageImpl#getAbstractFile()
	 * @generated
	 */
	int ABSTRACT_FILE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FILE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Abstract File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FILE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Abstract File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FILE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FolderToCreateInFMUImpl <em>Folder To Create In FMU</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FolderToCreateInFMUImpl
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FmumetamodelPackageImpl#getFolderToCreateInFMU()
	 * @generated
	 */
	int FOLDER_TO_CREATE_IN_FMU = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_TO_CREATE_IN_FMU__NAME = ABSTRACT_FILE__NAME;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_TO_CREATE_IN_FMU__CHILDREN = ABSTRACT_FILE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Folder To Create In FMU</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_TO_CREATE_IN_FMU_FEATURE_COUNT = ABSTRACT_FILE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Folder To Create In FMU</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_TO_CREATE_IN_FMU_OPERATION_COUNT = ABSTRACT_FILE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.ArchiveToUnzipInFMUImpl <em>Archive To Unzip In FMU</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.ArchiveToUnzipInFMUImpl
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FmumetamodelPackageImpl#getArchiveToUnzipInFMU()
	 * @generated
	 */
	int ARCHIVE_TO_UNZIP_IN_FMU = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHIVE_TO_UNZIP_IN_FMU__NAME = ABSTRACT_FILE__NAME;

	/**
	 * The feature id for the '<em><b>Archive File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHIVE_TO_UNZIP_IN_FMU__ARCHIVE_FILE = ABSTRACT_FILE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Archive To Unzip In FMU</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHIVE_TO_UNZIP_IN_FMU_FEATURE_COUNT = ABSTRACT_FILE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Archive To Unzip In FMU</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHIVE_TO_UNZIP_IN_FMU_OPERATION_COUNT = ABSTRACT_FILE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.JavaFileProxyImpl <em>Java File Proxy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.JavaFileProxyImpl
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FmumetamodelPackageImpl#getJavaFileProxy()
	 * @generated
	 */
	int JAVA_FILE_PROXY = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_FILE_PROXY__NAME = ABSTRACT_FILE__NAME;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_FILE_PROXY__FILE = ABSTRACT_FILE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Java File Proxy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_FILE_PROXY_FEATURE_COUNT = ABSTRACT_FILE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Java File Proxy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_FILE_PROXY_OPERATION_COUNT = ABSTRACT_FILE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '<em>File</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.File
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FmumetamodelPackageImpl#getFile()
	 * @generated
	 */
	int FILE = 5;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle <em>FMU Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FMU Bundle</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle
	 * @generated
	 */
	EClass getFMUBundle();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getModelDescription <em>Model Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Model Description</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getModelDescription()
	 * @see #getFMUBundle()
	 * @generated
	 */
	EReference getFMUBundle_ModelDescription();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getResourcesFiles <em>Resources Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources Files</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getResourcesFiles()
	 * @see #getFMUBundle()
	 * @generated
	 */
	EReference getFMUBundle_ResourcesFiles();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getWin32Files <em>Win32 Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Win32 Files</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getWin32Files()
	 * @see #getFMUBundle()
	 * @generated
	 */
	EReference getFMUBundle_Win32Files();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getWin64Files <em>Win64 Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Win64 Files</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getWin64Files()
	 * @see #getFMUBundle()
	 * @generated
	 */
	EReference getFMUBundle_Win64Files();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getLinux32Files <em>Linux32 Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Linux32 Files</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getLinux32Files()
	 * @see #getFMUBundle()
	 * @generated
	 */
	EReference getFMUBundle_Linux32Files();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getLinux64Files <em>Linux64 Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Linux64 Files</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getLinux64Files()
	 * @see #getFMUBundle()
	 * @generated
	 */
	EReference getFMUBundle_Linux64Files();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getDarwin64Files <em>Darwin64 Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Darwin64 Files</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getDarwin64Files()
	 * @see #getFMUBundle()
	 * @generated
	 */
	EReference getFMUBundle_Darwin64Files();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getDarwin32Files <em>Darwin32 Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Darwin32 Files</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getDarwin32Files()
	 * @see #getFMUBundle()
	 * @generated
	 */
	EReference getFMUBundle_Darwin32Files();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getDocumentationFiles <em>Documentation Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Documentation Files</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getDocumentationFiles()
	 * @see #getFMUBundle()
	 * @generated
	 */
	EReference getFMUBundle_DocumentationFiles();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getSourceFiles <em>Source Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source Files</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getSourceFiles()
	 * @see #getFMUBundle()
	 * @generated
	 */
	EReference getFMUBundle_SourceFiles();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getRootFiles <em>Root Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Root Files</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getRootFiles()
	 * @see #getFMUBundle()
	 * @generated
	 */
	EReference getFMUBundle_RootFiles();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.AbstractFile <em>Abstract File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract File</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.AbstractFile
	 * @generated
	 */
	EClass getAbstractFile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.AbstractFile#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.AbstractFile#getName()
	 * @see #getAbstractFile()
	 * @generated
	 */
	EAttribute getAbstractFile_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.FolderToCreateInFMU <em>Folder To Create In FMU</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Folder To Create In FMU</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FolderToCreateInFMU
	 * @generated
	 */
	EClass getFolderToCreateInFMU();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.FolderToCreateInFMU#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FolderToCreateInFMU#getChildren()
	 * @see #getFolderToCreateInFMU()
	 * @generated
	 */
	EReference getFolderToCreateInFMU_Children();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.ArchiveToUnzipInFMU <em>Archive To Unzip In FMU</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Archive To Unzip In FMU</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.ArchiveToUnzipInFMU
	 * @generated
	 */
	EClass getArchiveToUnzipInFMU();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.ArchiveToUnzipInFMU#getArchiveFile <em>Archive File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Archive File</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.ArchiveToUnzipInFMU#getArchiveFile()
	 * @see #getArchiveToUnzipInFMU()
	 * @generated
	 */
	EAttribute getArchiveToUnzipInFMU_ArchiveFile();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.JavaFileProxy <em>Java File Proxy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java File Proxy</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.JavaFileProxy
	 * @generated
	 */
	EClass getJavaFileProxy();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.JavaFileProxy#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File</em>'.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.JavaFileProxy#getFile()
	 * @see #getJavaFileProxy()
	 * @generated
	 */
	EAttribute getJavaFileProxy_File();

	/**
	 * Returns the meta object for data type '{@link java.io.File <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>File</em>'.
	 * @see java.io.File
	 * @model instanceClass="java.io.File"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='File'"
	 * @generated
	 */
	EDataType getFile();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FmumetamodelFactory getFmumetamodelFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FMUBundleImpl <em>FMU Bundle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FMUBundleImpl
		 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FmumetamodelPackageImpl#getFMUBundle()
		 * @generated
		 */
		EClass FMU_BUNDLE = eINSTANCE.getFMUBundle();

		/**
		 * The meta object literal for the '<em><b>Model Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMU_BUNDLE__MODEL_DESCRIPTION = eINSTANCE.getFMUBundle_ModelDescription();

		/**
		 * The meta object literal for the '<em><b>Resources Files</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMU_BUNDLE__RESOURCES_FILES = eINSTANCE.getFMUBundle_ResourcesFiles();

		/**
		 * The meta object literal for the '<em><b>Win32 Files</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMU_BUNDLE__WIN32_FILES = eINSTANCE.getFMUBundle_Win32Files();

		/**
		 * The meta object literal for the '<em><b>Win64 Files</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMU_BUNDLE__WIN64_FILES = eINSTANCE.getFMUBundle_Win64Files();

		/**
		 * The meta object literal for the '<em><b>Linux32 Files</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMU_BUNDLE__LINUX32_FILES = eINSTANCE.getFMUBundle_Linux32Files();

		/**
		 * The meta object literal for the '<em><b>Linux64 Files</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMU_BUNDLE__LINUX64_FILES = eINSTANCE.getFMUBundle_Linux64Files();

		/**
		 * The meta object literal for the '<em><b>Darwin64 Files</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMU_BUNDLE__DARWIN64_FILES = eINSTANCE.getFMUBundle_Darwin64Files();

		/**
		 * The meta object literal for the '<em><b>Darwin32 Files</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMU_BUNDLE__DARWIN32_FILES = eINSTANCE.getFMUBundle_Darwin32Files();

		/**
		 * The meta object literal for the '<em><b>Documentation Files</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMU_BUNDLE__DOCUMENTATION_FILES = eINSTANCE.getFMUBundle_DocumentationFiles();

		/**
		 * The meta object literal for the '<em><b>Source Files</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMU_BUNDLE__SOURCE_FILES = eINSTANCE.getFMUBundle_SourceFiles();

		/**
		 * The meta object literal for the '<em><b>Root Files</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FMU_BUNDLE__ROOT_FILES = eINSTANCE.getFMUBundle_RootFiles();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.AbstractFileImpl <em>Abstract File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.AbstractFileImpl
		 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FmumetamodelPackageImpl#getAbstractFile()
		 * @generated
		 */
		EClass ABSTRACT_FILE = eINSTANCE.getAbstractFile();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_FILE__NAME = eINSTANCE.getAbstractFile_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FolderToCreateInFMUImpl <em>Folder To Create In FMU</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FolderToCreateInFMUImpl
		 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FmumetamodelPackageImpl#getFolderToCreateInFMU()
		 * @generated
		 */
		EClass FOLDER_TO_CREATE_IN_FMU = eINSTANCE.getFolderToCreateInFMU();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOLDER_TO_CREATE_IN_FMU__CHILDREN = eINSTANCE.getFolderToCreateInFMU_Children();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.ArchiveToUnzipInFMUImpl <em>Archive To Unzip In FMU</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.ArchiveToUnzipInFMUImpl
		 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FmumetamodelPackageImpl#getArchiveToUnzipInFMU()
		 * @generated
		 */
		EClass ARCHIVE_TO_UNZIP_IN_FMU = eINSTANCE.getArchiveToUnzipInFMU();

		/**
		 * The meta object literal for the '<em><b>Archive File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARCHIVE_TO_UNZIP_IN_FMU__ARCHIVE_FILE = eINSTANCE.getArchiveToUnzipInFMU_ArchiveFile();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.JavaFileProxyImpl <em>Java File Proxy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.JavaFileProxyImpl
		 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FmumetamodelPackageImpl#getJavaFileProxy()
		 * @generated
		 */
		EClass JAVA_FILE_PROXY = eINSTANCE.getJavaFileProxy();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_FILE_PROXY__FILE = eINSTANCE.getJavaFileProxy_File();

		/**
		 * The meta object literal for the '<em>File</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.io.File
		 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FmumetamodelPackageImpl#getFile()
		 * @generated
		 */
		EDataType FILE = eINSTANCE.getFile();

	}

} //FmumetamodelPackage
