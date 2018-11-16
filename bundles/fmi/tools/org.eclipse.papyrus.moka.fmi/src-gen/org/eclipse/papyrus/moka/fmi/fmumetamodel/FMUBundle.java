/**
 * Copyright (c) 2019 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.moka.fmi.fmumetamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.moka.fmi.modeldescription.FmiModelDescriptionType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FMU Bundle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getModelDescription <em>Model Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getResourcesFiles <em>Resources Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getWin32Files <em>Win32 Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getWin64Files <em>Win64 Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getLinux32Files <em>Linux32 Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getLinux64Files <em>Linux64 Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getDarwin64Files <em>Darwin64 Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getDarwin32Files <em>Darwin32 Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getDocumentationFiles <em>Documentation Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getSourceFiles <em>Source Files</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getRootFiles <em>Root Files</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelPackage#getFMUBundle()
 * @model
 * @generated
 */
public interface FMUBundle extends EObject {
	/**
	 * Returns the value of the '<em><b>Model Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Description</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Description</em>' containment reference.
	 * @see #setModelDescription(FmiModelDescriptionType)
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelPackage#getFMUBundle_ModelDescription()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	FmiModelDescriptionType getModelDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.FMUBundle#getModelDescription <em>Model Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Description</em>' containment reference.
	 * @see #getModelDescription()
	 * @generated
	 */
	void setModelDescription(FmiModelDescriptionType value);

	/**
	 * Returns the value of the '<em><b>Resources Files</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.moka.fmi.fmumetamodel.AbstractFile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources Files</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources Files</em>' containment reference list.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelPackage#getFMUBundle_ResourcesFiles()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<AbstractFile> getResourcesFiles();

	/**
	 * Returns the value of the '<em><b>Win32 Files</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.moka.fmi.fmumetamodel.AbstractFile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Win32 Files</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Win32 Files</em>' containment reference list.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelPackage#getFMUBundle_Win32Files()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<AbstractFile> getWin32Files();

	/**
	 * Returns the value of the '<em><b>Win64 Files</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.moka.fmi.fmumetamodel.AbstractFile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Win64 Files</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Win64 Files</em>' containment reference list.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelPackage#getFMUBundle_Win64Files()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<AbstractFile> getWin64Files();

	/**
	 * Returns the value of the '<em><b>Linux32 Files</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.moka.fmi.fmumetamodel.AbstractFile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linux32 Files</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linux32 Files</em>' containment reference list.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelPackage#getFMUBundle_Linux32Files()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<AbstractFile> getLinux32Files();

	/**
	 * Returns the value of the '<em><b>Linux64 Files</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.moka.fmi.fmumetamodel.AbstractFile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linux64 Files</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linux64 Files</em>' containment reference list.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelPackage#getFMUBundle_Linux64Files()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<AbstractFile> getLinux64Files();

	/**
	 * Returns the value of the '<em><b>Darwin64 Files</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.moka.fmi.fmumetamodel.AbstractFile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Darwin64 Files</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Darwin64 Files</em>' containment reference list.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelPackage#getFMUBundle_Darwin64Files()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<AbstractFile> getDarwin64Files();

	/**
	 * Returns the value of the '<em><b>Darwin32 Files</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.moka.fmi.fmumetamodel.AbstractFile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Darwin32 Files</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Darwin32 Files</em>' containment reference list.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelPackage#getFMUBundle_Darwin32Files()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<AbstractFile> getDarwin32Files();

	/**
	 * Returns the value of the '<em><b>Documentation Files</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.moka.fmi.fmumetamodel.AbstractFile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Documentation Files</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Documentation Files</em>' containment reference list.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelPackage#getFMUBundle_DocumentationFiles()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<AbstractFile> getDocumentationFiles();

	/**
	 * Returns the value of the '<em><b>Source Files</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.moka.fmi.fmumetamodel.AbstractFile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Files</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Files</em>' containment reference list.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelPackage#getFMUBundle_SourceFiles()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<AbstractFile> getSourceFiles();

	/**
	 * Returns the value of the '<em><b>Root Files</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.moka.fmi.fmumetamodel.AbstractFile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Files</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Files</em>' containment reference list.
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelPackage#getFMUBundle_RootFiles()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<AbstractFile> getRootFiles();

} // FMUBundle
