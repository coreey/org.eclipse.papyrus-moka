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

import java.io.File;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java File Proxy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.JavaFileProxy#getFile <em>File</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelPackage#getJavaFileProxy()
 * @model
 * @generated
 */
public interface JavaFileProxy extends AbstractFile {
	/**
	 * Returns the value of the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' attribute.
	 * @see #setFile(File)
	 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelPackage#getJavaFileProxy_File()
	 * @model dataType="org.eclipse.papyrus.moka.fmi.fmumetamodel.File" required="true" ordered="false"
	 * @generated
	 */
	File getFile();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.fmi.fmumetamodel.JavaFileProxy#getFile <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' attribute.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(File value);

} // JavaFileProxy
