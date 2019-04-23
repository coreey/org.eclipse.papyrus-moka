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
package org.eclipse.papyrus.moka.datavisualization.profile.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.moka.datavisualization.profile.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VisualizationFactoryImpl extends EFactoryImpl implements VisualizationFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2016 CEA LIST.\r\n\r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License 2.0\r\n which accompanies this distribution, and is available at\r\n https://www.eclipse.org/legal/epl-2.0 \r\n\r\nSPDX-License-Identifier: EPL-2.0\r\n\r\n Contributors:\r\n  CEA LIST - Initial API and implementation";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VisualizationFactory init() {
		try {
			VisualizationFactory theVisualizationFactory = (VisualizationFactory)EPackage.Registry.INSTANCE.getEFactory(VisualizationPackage.eNS_URI);
			if (theVisualizationFactory != null) {
				return theVisualizationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new VisualizationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisualizationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case VisualizationPackage.DATA_SOURCE: return createDataSource();
			case VisualizationPackage.VALUE_SERIES: return createValueSeries();
			case VisualizationPackage.STRING_SERIES: return createStringSeries();
			case VisualizationPackage.DOUBLE_SERIES: return createDoubleSeries();
			case VisualizationPackage.INTEGER_SERIES: return createIntegerSeries();
			case VisualizationPackage.BOOLEAN_SERIES: return createBooleanSeries();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataSource createDataSource() {
		DataSourceImpl dataSource = new DataSourceImpl();
		return dataSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueSeries createValueSeries() {
		ValueSeriesImpl valueSeries = new ValueSeriesImpl();
		return valueSeries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringSeries createStringSeries() {
		StringSeriesImpl stringSeries = new StringSeriesImpl();
		return stringSeries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleSeries createDoubleSeries() {
		DoubleSeriesImpl doubleSeries = new DoubleSeriesImpl();
		return doubleSeries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerSeries createIntegerSeries() {
		IntegerSeriesImpl integerSeries = new IntegerSeriesImpl();
		return integerSeries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanSeries createBooleanSeries() {
		BooleanSeriesImpl booleanSeries = new BooleanSeriesImpl();
		return booleanSeries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisualizationPackage getVisualizationPackage() {
		return (VisualizationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static VisualizationPackage getPackage() {
		return VisualizationPackage.eINSTANCE;
	}

} //VisualizationFactoryImpl
