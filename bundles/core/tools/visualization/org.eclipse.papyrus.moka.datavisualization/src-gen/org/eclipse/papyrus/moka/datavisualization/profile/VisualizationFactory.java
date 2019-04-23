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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.moka.datavisualization.profile.VisualizationPackage
 * @generated
 */
public interface VisualizationFactory extends EFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2016 CEA LIST.\r\n\r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License 2.0\r\n which accompanies this distribution, and is available at\r\n https://www.eclipse.org/legal/epl-2.0 \r\n\r\nSPDX-License-Identifier: EPL-2.0\r\n\r\n Contributors:\r\n  CEA LIST - Initial API and implementation";

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VisualizationFactory eINSTANCE = org.eclipse.papyrus.moka.datavisualization.profile.impl.VisualizationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Data Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Source</em>'.
	 * @generated
	 */
	DataSource createDataSource();

	/**
	 * Returns a new object of class '<em>Value Series</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Value Series</em>'.
	 * @generated
	 */
	ValueSeries createValueSeries();

	/**
	 * Returns a new object of class '<em>String Series</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Series</em>'.
	 * @generated
	 */
	StringSeries createStringSeries();

	/**
	 * Returns a new object of class '<em>Double Series</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Series</em>'.
	 * @generated
	 */
	DoubleSeries createDoubleSeries();

	/**
	 * Returns a new object of class '<em>Integer Series</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Series</em>'.
	 * @generated
	 */
	IntegerSeries createIntegerSeries();

	/**
	 * Returns a new object of class '<em>Boolean Series</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Series</em>'.
	 * @generated
	 */
	BooleanSeries createBooleanSeries();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	VisualizationPackage getVisualizationPackage();

} //VisualizationFactory
