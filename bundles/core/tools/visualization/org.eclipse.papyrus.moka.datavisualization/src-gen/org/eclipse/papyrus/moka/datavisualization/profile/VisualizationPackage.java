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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.moka.datavisualization.profile.VisualizationFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='DataVisualizationProfile'"
 * @generated
 */
public interface VisualizationPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2016 CEA LIST.\r\n\r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License 2.0\r\n which accompanies this distribution, and is available at\r\n https://www.eclipse.org/legal/epl-2.0 \r\n\r\nSPDX-License-Identifier: EPL-2.0\r\n\r\n Contributors:\r\n  CEA LIST - Initial API and implementation";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "profile";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://www.eclipse.org/papyrus/datavisualization/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "visualization";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VisualizationPackage eINSTANCE = org.eclipse.papyrus.moka.datavisualization.profile.impl.VisualizationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.datavisualization.profile.impl.DataSourceImpl <em>Data Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.impl.DataSourceImpl
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.impl.VisualizationPackageImpl#getDataSource()
	 * @generated
	 */
	int DATA_SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE__BASE_DATA_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Series</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE__SERIES = 1;

	/**
	 * The number of structural features of the '<em>Data Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Data Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SOURCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.datavisualization.profile.impl.ValueSeriesImpl <em>Value Series</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.impl.ValueSeriesImpl
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.impl.VisualizationPackageImpl#getValueSeries()
	 * @generated
	 */
	int VALUE_SERIES = 1;

	/**
	 * The feature id for the '<em><b>Binary String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SERIES__BINARY_STRING = 0;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SERIES__BASE_PROPERTY = 1;

	/**
	 * The feature id for the '<em><b>Dependent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SERIES__DEPENDENT = 2;

	/**
	 * The number of structural features of the '<em>Value Series</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SERIES_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>Get Size</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SERIES___GET_SIZE = 0;

	/**
	 * The operation id for the '<em>Get String Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SERIES___GET_STRING_VALUE__INT = 1;

	/**
	 * The number of operations of the '<em>Value Series</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_SERIES_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.datavisualization.profile.impl.StringSeriesImpl <em>String Series</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.impl.StringSeriesImpl
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.impl.VisualizationPackageImpl#getStringSeries()
	 * @generated
	 */
	int STRING_SERIES = 2;

	/**
	 * The feature id for the '<em><b>Binary String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SERIES__BINARY_STRING = VALUE_SERIES__BINARY_STRING;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SERIES__BASE_PROPERTY = VALUE_SERIES__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Dependent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SERIES__DEPENDENT = VALUE_SERIES__DEPENDENT;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SERIES__VALUES = VALUE_SERIES_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Series</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SERIES_FEATURE_COUNT = VALUE_SERIES_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Size</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SERIES___GET_SIZE = VALUE_SERIES___GET_SIZE;

	/**
	 * The operation id for the '<em>Get String Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SERIES___GET_STRING_VALUE__INT = VALUE_SERIES___GET_STRING_VALUE__INT;

	/**
	 * The number of operations of the '<em>String Series</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_SERIES_OPERATION_COUNT = VALUE_SERIES_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.datavisualization.profile.impl.DoubleSeriesImpl <em>Double Series</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.impl.DoubleSeriesImpl
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.impl.VisualizationPackageImpl#getDoubleSeries()
	 * @generated
	 */
	int DOUBLE_SERIES = 3;

	/**
	 * The feature id for the '<em><b>Binary String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_SERIES__BINARY_STRING = VALUE_SERIES__BINARY_STRING;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_SERIES__BASE_PROPERTY = VALUE_SERIES__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Dependent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_SERIES__DEPENDENT = VALUE_SERIES__DEPENDENT;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_SERIES__VALUES = VALUE_SERIES_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Double Series</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_SERIES_FEATURE_COUNT = VALUE_SERIES_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Size</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_SERIES___GET_SIZE = VALUE_SERIES___GET_SIZE;

	/**
	 * The operation id for the '<em>Get String Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_SERIES___GET_STRING_VALUE__INT = VALUE_SERIES___GET_STRING_VALUE__INT;

	/**
	 * The number of operations of the '<em>Double Series</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_SERIES_OPERATION_COUNT = VALUE_SERIES_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.datavisualization.profile.impl.IntegerSeriesImpl <em>Integer Series</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.impl.IntegerSeriesImpl
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.impl.VisualizationPackageImpl#getIntegerSeries()
	 * @generated
	 */
	int INTEGER_SERIES = 4;

	/**
	 * The feature id for the '<em><b>Binary String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_SERIES__BINARY_STRING = VALUE_SERIES__BINARY_STRING;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_SERIES__BASE_PROPERTY = VALUE_SERIES__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Dependent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_SERIES__DEPENDENT = VALUE_SERIES__DEPENDENT;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_SERIES__VALUES = VALUE_SERIES_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Series</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_SERIES_FEATURE_COUNT = VALUE_SERIES_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Size</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_SERIES___GET_SIZE = VALUE_SERIES___GET_SIZE;

	/**
	 * The operation id for the '<em>Get String Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_SERIES___GET_STRING_VALUE__INT = VALUE_SERIES___GET_STRING_VALUE__INT;

	/**
	 * The number of operations of the '<em>Integer Series</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_SERIES_OPERATION_COUNT = VALUE_SERIES_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.datavisualization.profile.impl.BooleanSeriesImpl <em>Boolean Series</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.impl.BooleanSeriesImpl
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.impl.VisualizationPackageImpl#getBooleanSeries()
	 * @generated
	 */
	int BOOLEAN_SERIES = 5;

	/**
	 * The feature id for the '<em><b>Binary String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_SERIES__BINARY_STRING = VALUE_SERIES__BINARY_STRING;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_SERIES__BASE_PROPERTY = VALUE_SERIES__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Dependent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_SERIES__DEPENDENT = VALUE_SERIES__DEPENDENT;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_SERIES__VALUES = VALUE_SERIES_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Series</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_SERIES_FEATURE_COUNT = VALUE_SERIES_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Size</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_SERIES___GET_SIZE = VALUE_SERIES___GET_SIZE;

	/**
	 * The operation id for the '<em>Get String Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_SERIES___GET_STRING_VALUE__INT = VALUE_SERIES___GET_STRING_VALUE__INT;

	/**
	 * The number of operations of the '<em>Boolean Series</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_SERIES_OPERATION_COUNT = VALUE_SERIES_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.datavisualization.profile.DataSource <em>Data Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Source</em>'.
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.DataSource
	 * @generated
	 */
	EClass getDataSource();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.datavisualization.profile.DataSource#getBase_DataType <em>Base Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Data Type</em>'.
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.DataSource#getBase_DataType()
	 * @see #getDataSource()
	 * @generated
	 */
	EReference getDataSource_Base_DataType();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.moka.datavisualization.profile.DataSource#getSeries <em>Series</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Series</em>'.
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.DataSource#getSeries()
	 * @see #getDataSource()
	 * @generated
	 */
	EReference getDataSource_Series();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.datavisualization.profile.ValueSeries <em>Value Series</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Series</em>'.
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.ValueSeries
	 * @generated
	 */
	EClass getValueSeries();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.datavisualization.profile.ValueSeries#getBinaryString <em>Binary String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Binary String</em>'.
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.ValueSeries#getBinaryString()
	 * @see #getValueSeries()
	 * @generated
	 */
	EAttribute getValueSeries_BinaryString();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.datavisualization.profile.ValueSeries#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.ValueSeries#getBase_Property()
	 * @see #getValueSeries()
	 * @generated
	 */
	EReference getValueSeries_Base_Property();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.datavisualization.profile.ValueSeries#getDependent <em>Dependent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dependent</em>'.
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.ValueSeries#getDependent()
	 * @see #getValueSeries()
	 * @generated
	 */
	EReference getValueSeries_Dependent();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.moka.datavisualization.profile.ValueSeries#getSize() <em>Get Size</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Size</em>' operation.
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.ValueSeries#getSize()
	 * @generated
	 */
	EOperation getValueSeries__GetSize();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.moka.datavisualization.profile.ValueSeries#getStringValue(int) <em>Get String Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get String Value</em>' operation.
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.ValueSeries#getStringValue(int)
	 * @generated
	 */
	EOperation getValueSeries__GetStringValue__int();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.datavisualization.profile.StringSeries <em>String Series</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Series</em>'.
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.StringSeries
	 * @generated
	 */
	EClass getStringSeries();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.moka.datavisualization.profile.StringSeries#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.StringSeries#getValues()
	 * @see #getStringSeries()
	 * @generated
	 */
	EAttribute getStringSeries_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.datavisualization.profile.DoubleSeries <em>Double Series</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Series</em>'.
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.DoubleSeries
	 * @generated
	 */
	EClass getDoubleSeries();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.moka.datavisualization.profile.DoubleSeries#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.DoubleSeries#getValues()
	 * @see #getDoubleSeries()
	 * @generated
	 */
	EAttribute getDoubleSeries_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.datavisualization.profile.IntegerSeries <em>Integer Series</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Series</em>'.
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.IntegerSeries
	 * @generated
	 */
	EClass getIntegerSeries();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.moka.datavisualization.profile.IntegerSeries#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.IntegerSeries#getValues()
	 * @see #getIntegerSeries()
	 * @generated
	 */
	EAttribute getIntegerSeries_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.datavisualization.profile.BooleanSeries <em>Boolean Series</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Series</em>'.
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.BooleanSeries
	 * @generated
	 */
	EClass getBooleanSeries();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.moka.datavisualization.profile.BooleanSeries#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.eclipse.papyrus.moka.datavisualization.profile.BooleanSeries#getValues()
	 * @see #getBooleanSeries()
	 * @generated
	 */
	EAttribute getBooleanSeries_Values();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VisualizationFactory getVisualizationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.datavisualization.profile.impl.DataSourceImpl <em>Data Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.datavisualization.profile.impl.DataSourceImpl
		 * @see org.eclipse.papyrus.moka.datavisualization.profile.impl.VisualizationPackageImpl#getDataSource()
		 * @generated
		 */
		EClass DATA_SOURCE = eINSTANCE.getDataSource();

		/**
		 * The meta object literal for the '<em><b>Base Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_SOURCE__BASE_DATA_TYPE = eINSTANCE.getDataSource_Base_DataType();

		/**
		 * The meta object literal for the '<em><b>Series</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_SOURCE__SERIES = eINSTANCE.getDataSource_Series();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.datavisualization.profile.impl.ValueSeriesImpl <em>Value Series</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.datavisualization.profile.impl.ValueSeriesImpl
		 * @see org.eclipse.papyrus.moka.datavisualization.profile.impl.VisualizationPackageImpl#getValueSeries()
		 * @generated
		 */
		EClass VALUE_SERIES = eINSTANCE.getValueSeries();

		/**
		 * The meta object literal for the '<em><b>Binary String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_SERIES__BINARY_STRING = eINSTANCE.getValueSeries_BinaryString();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_SERIES__BASE_PROPERTY = eINSTANCE.getValueSeries_Base_Property();

		/**
		 * The meta object literal for the '<em><b>Dependent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_SERIES__DEPENDENT = eINSTANCE.getValueSeries_Dependent();

		/**
		 * The meta object literal for the '<em><b>Get Size</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VALUE_SERIES___GET_SIZE = eINSTANCE.getValueSeries__GetSize();

		/**
		 * The meta object literal for the '<em><b>Get String Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VALUE_SERIES___GET_STRING_VALUE__INT = eINSTANCE.getValueSeries__GetStringValue__int();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.datavisualization.profile.impl.StringSeriesImpl <em>String Series</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.datavisualization.profile.impl.StringSeriesImpl
		 * @see org.eclipse.papyrus.moka.datavisualization.profile.impl.VisualizationPackageImpl#getStringSeries()
		 * @generated
		 */
		EClass STRING_SERIES = eINSTANCE.getStringSeries();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_SERIES__VALUES = eINSTANCE.getStringSeries_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.datavisualization.profile.impl.DoubleSeriesImpl <em>Double Series</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.datavisualization.profile.impl.DoubleSeriesImpl
		 * @see org.eclipse.papyrus.moka.datavisualization.profile.impl.VisualizationPackageImpl#getDoubleSeries()
		 * @generated
		 */
		EClass DOUBLE_SERIES = eINSTANCE.getDoubleSeries();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_SERIES__VALUES = eINSTANCE.getDoubleSeries_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.datavisualization.profile.impl.IntegerSeriesImpl <em>Integer Series</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.datavisualization.profile.impl.IntegerSeriesImpl
		 * @see org.eclipse.papyrus.moka.datavisualization.profile.impl.VisualizationPackageImpl#getIntegerSeries()
		 * @generated
		 */
		EClass INTEGER_SERIES = eINSTANCE.getIntegerSeries();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_SERIES__VALUES = eINSTANCE.getIntegerSeries_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.datavisualization.profile.impl.BooleanSeriesImpl <em>Boolean Series</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.datavisualization.profile.impl.BooleanSeriesImpl
		 * @see org.eclipse.papyrus.moka.datavisualization.profile.impl.VisualizationPackageImpl#getBooleanSeries()
		 * @generated
		 */
		EClass BOOLEAN_SERIES = eINSTANCE.getBooleanSeries();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_SERIES__VALUES = eINSTANCE.getBooleanSeries_Values();

	}

} //VisualizationPackage
