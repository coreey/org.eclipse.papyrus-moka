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
 * A representation of the model object '<em><b>Color Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.ColorDescriptor#getR <em>R</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.ColorDescriptor#getG <em>G</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.ColorDescriptor#getB <em>B</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getColorDescriptor()
 * @model
 * @generated
 */
public interface ColorDescriptor extends EObject {
	/**
	 * Returns the value of the '<em><b>R</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>R</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>R</em>' attribute.
	 * @see #setR(int)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getColorDescriptor_R()
	 * @model
	 * @generated
	 */
	int getR();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.ColorDescriptor#getR <em>R</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>R</em>' attribute.
	 * @see #getR()
	 * @generated
	 */
	void setR(int value);

	/**
	 * Returns the value of the '<em><b>G</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>G</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>G</em>' attribute.
	 * @see #setG(int)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getColorDescriptor_G()
	 * @model
	 * @generated
	 */
	int getG();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.ColorDescriptor#getG <em>G</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>G</em>' attribute.
	 * @see #getG()
	 * @generated
	 */
	void setG(int value);

	/**
	 * Returns the value of the '<em><b>B</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>B</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>B</em>' attribute.
	 * @see #setB(int)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getColorDescriptor_B()
	 * @model
	 * @generated
	 */
	int getB();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.ColorDescriptor#getB <em>B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>B</em>' attribute.
	 * @see #getB()
	 * @generated
	 */
	void setB(int value);

} // ColorDescriptor
