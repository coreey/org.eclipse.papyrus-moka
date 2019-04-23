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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.moka.fmi.fmumetamodel.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FmumetamodelFactoryImpl extends EFactoryImpl implements FmumetamodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FmumetamodelFactory init() {
		try {
			FmumetamodelFactory theFmumetamodelFactory = (FmumetamodelFactory)EPackage.Registry.INSTANCE.getEFactory(FmumetamodelPackage.eNS_URI);
			if (theFmumetamodelFactory != null) {
				return theFmumetamodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FmumetamodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FmumetamodelFactoryImpl() {
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
			case FmumetamodelPackage.FMU_BUNDLE: return createFMUBundle();
			case FmumetamodelPackage.FOLDER_TO_CREATE_IN_FMU: return createFolderToCreateInFMU();
			case FmumetamodelPackage.ARCHIVE_TO_UNZIP_IN_FMU: return createArchiveToUnzipInFMU();
			case FmumetamodelPackage.JAVA_FILE_PROXY: return createJavaFileProxy();
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
			case FmumetamodelPackage.FILE:
				return createFileFromString(eDataType, initialValue);
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
			case FmumetamodelPackage.FILE:
				return convertFileToString(eDataType, instanceValue);
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
	public FMUBundle createFMUBundle() {
		FMUBundleImpl fmuBundle = new FMUBundleImpl();
		return fmuBundle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FolderToCreateInFMU createFolderToCreateInFMU() {
		FolderToCreateInFMUImpl folderToCreateInFMU = new FolderToCreateInFMUImpl();
		return folderToCreateInFMU;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ArchiveToUnzipInFMU createArchiveToUnzipInFMU() {
		ArchiveToUnzipInFMUImpl archiveToUnzipInFMU = new ArchiveToUnzipInFMUImpl();
		return archiveToUnzipInFMU;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JavaFileProxy createJavaFileProxy() {
		JavaFileProxyImpl javaFileProxy = new JavaFileProxyImpl();
		return javaFileProxy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public File createFileFromString(EDataType eDataType, String initialValue) {
		return (File)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFileToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FmumetamodelPackage getFmumetamodelPackage() {
		return (FmumetamodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FmumetamodelPackage getPackage() {
		return FmumetamodelPackage.eINSTANCE;
	}

} //FmumetamodelFactoryImpl
