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
package org.eclipse.papyrus.moka.datavisualization.profile;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Series</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.datavisualization.profile.ValueSeries#getBinaryString <em>Binary String</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.datavisualization.profile.ValueSeries#getBase_Property <em>Base Property</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.datavisualization.profile.ValueSeries#getDependent <em>Dependent</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.datavisualization.profile.VisualizationPackage#getValueSeries()
 * @model
 * @generated
 */
public interface ValueSeries extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2016 CEA LIST.\r\n\r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License 2.0\r\n which accompanies this distribution, and is available at\r\n https://www.eclipse.org/legal/epl-2.0 \r\n\r\nSPDX-License-Identifier: EPL-2.0\r\n\r\n Contributors:\r\n  CEA LIST - Initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Binary String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binary String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binary String</em>' attribute.
	 * @see #setBinaryString(String)
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.VisualizationPackage#getValueSeries_BinaryString()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getBinaryString();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.datavisualization.profile.ValueSeries#getBinaryString <em>Binary String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binary String</em>' attribute.
	 * @see #getBinaryString()
	 * @generated
	 */
	void setBinaryString(String value);

	/**
	 * Returns the value of the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Property</em>' reference.
	 * @see #setBase_Property(Property)
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.VisualizationPackage#getValueSeries_Base_Property()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Property getBase_Property();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.datavisualization.profile.ValueSeries#getBase_Property <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Property</em>' reference.
	 * @see #getBase_Property()
	 * @generated
	 */
	void setBase_Property(Property value);

	/**
	 * Returns the value of the '<em><b>Dependent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependent</em>' reference.
	 * @see #setDependent(ValueSeries)
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.VisualizationPackage#getValueSeries_Dependent()
	 * @model ordered="false"
	 * @generated
	 */
	ValueSeries getDependent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.datavisualization.profile.ValueSeries#getDependent <em>Dependent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependent</em>' reference.
	 * @see #getDependent()
	 * @generated
	 */
	void setDependent(ValueSeries value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true" ordered="false"
	 * @generated
	 */
	int getSize();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" indexRequired="true" indexOrdered="false"
	 * @generated
	 */
	String getStringValue(int index);

} // ValueSeries
