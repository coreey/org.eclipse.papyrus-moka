/**
 * Copyright (c) 2016 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0 
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *   CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.moka.xygraph.model.xygraph;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Font Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.FontDescriptor#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.FontDescriptor#getSize <em>Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.FontDescriptor#getStyle <em>Style</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getFontDescriptor()
 * @model
 * @generated
 */
public interface FontDescriptor extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"Arial"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getFontDescriptor_Name()
	 * @model default="Arial"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.FontDescriptor#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * The default value is <code>"12"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(int)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getFontDescriptor_Size()
	 * @model default="12"
	 * @generated
	 */
	int getSize();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.FontDescriptor#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(int value);

	/**
	 * Returns the value of the '<em><b>Style</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Style</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Style</em>' attribute.
	 * @see #setStyle(int)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getFontDescriptor_Style()
	 * @model default="0"
	 * @generated
	 */
	int getStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.FontDescriptor#getStyle <em>Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Style</em>' attribute.
	 * @see #getStyle()
	 * @generated
	 */
	void setStyle(int value);

} // FontDescriptor
