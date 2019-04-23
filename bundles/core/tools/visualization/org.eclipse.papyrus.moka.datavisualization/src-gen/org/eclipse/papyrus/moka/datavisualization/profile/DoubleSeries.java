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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Double Series</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.datavisualization.profile.DoubleSeries#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.datavisualization.profile.VisualizationPackage#getDoubleSeries()
 * @model
 * @generated
 */
public interface DoubleSeries extends ValueSeries {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2016 CEA LIST.\r\n\r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License 2.0\r\n which accompanies this distribution, and is available at\r\n https://www.eclipse.org/legal/epl-2.0 \r\n\r\nSPDX-License-Identifier: EPL-2.0\r\n\r\n Contributors:\r\n  CEA LIST - Initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Values</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' attribute list.
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.VisualizationPackage#getDoubleSeries_Values()
	 * @model unique="false" transient="true"
	 * @generated
	 */
	EList<Double> getValues();

} // DoubleSeries
