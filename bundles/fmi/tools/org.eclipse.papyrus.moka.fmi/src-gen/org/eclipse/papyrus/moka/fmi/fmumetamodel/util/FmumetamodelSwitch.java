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
package org.eclipse.papyrus.moka.fmi.fmumetamodel.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.moka.fmi.fmumetamodel.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelPackage
 * @generated
 */
public class FmumetamodelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static FmumetamodelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FmumetamodelSwitch() {
		if (modelPackage == null) {
			modelPackage = FmumetamodelPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case FmumetamodelPackage.FMU_BUNDLE: {
				FMUBundle fmuBundle = (FMUBundle)theEObject;
				T result = caseFMUBundle(fmuBundle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmumetamodelPackage.ABSTRACT_FILE: {
				AbstractFile abstractFile = (AbstractFile)theEObject;
				T result = caseAbstractFile(abstractFile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmumetamodelPackage.FOLDER_TO_CREATE_IN_FMU: {
				FolderToCreateInFMU folderToCreateInFMU = (FolderToCreateInFMU)theEObject;
				T result = caseFolderToCreateInFMU(folderToCreateInFMU);
				if (result == null) result = caseAbstractFile(folderToCreateInFMU);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmumetamodelPackage.ARCHIVE_TO_UNZIP_IN_FMU: {
				ArchiveToUnzipInFMU archiveToUnzipInFMU = (ArchiveToUnzipInFMU)theEObject;
				T result = caseArchiveToUnzipInFMU(archiveToUnzipInFMU);
				if (result == null) result = caseAbstractFile(archiveToUnzipInFMU);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FmumetamodelPackage.JAVA_FILE_PROXY: {
				JavaFileProxy javaFileProxy = (JavaFileProxy)theEObject;
				T result = caseJavaFileProxy(javaFileProxy);
				if (result == null) result = caseAbstractFile(javaFileProxy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FMU Bundle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FMU Bundle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFMUBundle(FMUBundle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract File</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract File</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractFile(AbstractFile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Folder To Create In FMU</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Folder To Create In FMU</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFolderToCreateInFMU(FolderToCreateInFMU object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Archive To Unzip In FMU</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Archive To Unzip In FMU</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArchiveToUnzipInFMU(ArchiveToUnzipInFMU object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java File Proxy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java File Proxy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaFileProxy(JavaFileProxy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //FmumetamodelSwitch
