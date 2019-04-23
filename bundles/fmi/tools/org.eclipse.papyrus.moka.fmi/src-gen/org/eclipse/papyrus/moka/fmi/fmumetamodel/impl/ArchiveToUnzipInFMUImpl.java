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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.moka.fmi.fmumetamodel.ArchiveToUnzipInFMU;
import org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Archive To Unzip In FMU</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.ArchiveToUnzipInFMUImpl#getArchiveFile <em>Archive File</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArchiveToUnzipInFMUImpl extends AbstractFileImpl implements ArchiveToUnzipInFMU {
	/**
	 * The default value of the '{@link #getArchiveFile() <em>Archive File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArchiveFile()
	 * @generated
	 * @ordered
	 */
	protected static final File ARCHIVE_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getArchiveFile() <em>Archive File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArchiveFile()
	 * @generated
	 * @ordered
	 */
	protected File archiveFile = ARCHIVE_FILE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArchiveToUnzipInFMUImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FmumetamodelPackage.Literals.ARCHIVE_TO_UNZIP_IN_FMU;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public File getArchiveFile() {
		return archiveFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setArchiveFile(File newArchiveFile) {
		File oldArchiveFile = archiveFile;
		archiveFile = newArchiveFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FmumetamodelPackage.ARCHIVE_TO_UNZIP_IN_FMU__ARCHIVE_FILE, oldArchiveFile, archiveFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FmumetamodelPackage.ARCHIVE_TO_UNZIP_IN_FMU__ARCHIVE_FILE:
				return getArchiveFile();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FmumetamodelPackage.ARCHIVE_TO_UNZIP_IN_FMU__ARCHIVE_FILE:
				setArchiveFile((File)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FmumetamodelPackage.ARCHIVE_TO_UNZIP_IN_FMU__ARCHIVE_FILE:
				setArchiveFile(ARCHIVE_FILE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FmumetamodelPackage.ARCHIVE_TO_UNZIP_IN_FMU__ARCHIVE_FILE:
				return ARCHIVE_FILE_EDEFAULT == null ? archiveFile != null : !ARCHIVE_FILE_EDEFAULT.equals(archiveFile);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (archiveFile: ");
		result.append(archiveFile);
		result.append(')');
		return result.toString();
	}

} //ArchiveToUnzipInFMUImpl
