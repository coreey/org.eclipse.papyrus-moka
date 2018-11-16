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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.moka.fmi.fmumetamodel.FmumetamodelPackage
 * @generated
 */
public interface FmumetamodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FmumetamodelFactory eINSTANCE = org.eclipse.papyrus.moka.fmi.fmumetamodel.impl.FmumetamodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>FMU Bundle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FMU Bundle</em>'.
	 * @generated
	 */
	FMUBundle createFMUBundle();

	/**
	 * Returns a new object of class '<em>Folder To Create In FMU</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Folder To Create In FMU</em>'.
	 * @generated
	 */
	FolderToCreateInFMU createFolderToCreateInFMU();

	/**
	 * Returns a new object of class '<em>Archive To Unzip In FMU</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Archive To Unzip In FMU</em>'.
	 * @generated
	 */
	ArchiveToUnzipInFMU createArchiveToUnzipInFMU();

	/**
	 * Returns a new object of class '<em>Java File Proxy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java File Proxy</em>'.
	 * @generated
	 */
	JavaFileProxy createJavaFileProxy();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	FmumetamodelPackage getFmumetamodelPackage();

} //FmumetamodelFactory
