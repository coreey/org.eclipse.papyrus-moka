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

import java.io.File;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Archive To Unzip In FMU</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.ArchiveToUnzipInFMU#getArchiveFile <em>Archive File</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelPackage#getArchiveToUnzipInFMU()
 * @model
 * @generated
 */
public interface ArchiveToUnzipInFMU extends AbstractFile {
	/**
	 * Returns the value of the '<em><b>Archive File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Archive File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Archive File</em>' attribute.
	 * @see #setArchiveFile(File)
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelPackage#getArchiveToUnzipInFMU_ArchiveFile()
	 * @model dataType="org.eclipse.papyrus.moka.fmi.fmumetamodel.File" required="true" ordered="false"
	 * @generated
	 */
	File getArchiveFile();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.ArchiveToUnzipInFMU#getArchiveFile <em>Archive File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Archive File</em>' attribute.
	 * @see #getArchiveFile()
	 * @generated
	 */
	void setArchiveFile(File value);

} // ArchiveToUnzipInFMU
