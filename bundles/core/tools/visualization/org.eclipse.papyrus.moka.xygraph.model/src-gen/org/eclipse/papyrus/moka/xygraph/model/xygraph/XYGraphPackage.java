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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphFactory
 * @model kind="package"
 * @generated
 */
public interface XYGraphPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xygraph";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/xygraph/model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "xygraph";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XYGraphPackage eINSTANCE = org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphDescriptorImpl <em>Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphDescriptorImpl
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphPackageImpl#getXYGraphDescriptor()
	 * @generated
	 */
	int XY_GRAPH_DESCRIPTOR = 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XY_GRAPH_DESCRIPTOR__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Show Legend</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XY_GRAPH_DESCRIPTOR__SHOW_LEGEND = 1;

	/**
	 * The feature id for the '<em><b>Show Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XY_GRAPH_DESCRIPTOR__SHOW_TITLE = 2;

	/**
	 * The feature id for the '<em><b>Title Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XY_GRAPH_DESCRIPTOR__TITLE_COLOR = 3;

	/**
	 * The feature id for the '<em><b>Transparent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XY_GRAPH_DESCRIPTOR__TRANSPARENT = 4;

	/**
	 * The feature id for the '<em><b>Zoom Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XY_GRAPH_DESCRIPTOR__ZOOM_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Axis Descriptors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XY_GRAPH_DESCRIPTOR__AXIS_DESCRIPTORS = 6;

	/**
	 * The feature id for the '<em><b>Trace Descriptors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XY_GRAPH_DESCRIPTOR__TRACE_DESCRIPTORS = 7;

	/**
	 * The feature id for the '<em><b>Show Plot Area Border</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XY_GRAPH_DESCRIPTOR__SHOW_PLOT_AREA_BORDER = 8;

	/**
	 * The feature id for the '<em><b>Plot Area Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XY_GRAPH_DESCRIPTOR__PLOT_AREA_BACKGROUND_COLOR = 9;

	/**
	 * The feature id for the '<em><b>Title Font</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XY_GRAPH_DESCRIPTOR__TITLE_FONT = 10;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XY_GRAPH_DESCRIPTOR__CONTEXT = 11;

	/**
	 * The feature id for the '<em><b>Data Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XY_GRAPH_DESCRIPTOR__DATA_SOURCE = 12;

	/**
	 * The feature id for the '<em><b>Visible Traces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XY_GRAPH_DESCRIPTOR__VISIBLE_TRACES = 13;

	/**
	 * The number of structural features of the '<em>Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XY_GRAPH_DESCRIPTOR_FEATURE_COUNT = 14;

	/**
	 * The number of operations of the '<em>Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XY_GRAPH_DESCRIPTOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.AxisDescriptorImpl <em>Axis Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.AxisDescriptorImpl
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphPackageImpl#getAxisDescriptor()
	 * @generated
	 */
	int AXIS_DESCRIPTOR = 1;

	/**
	 * The feature id for the '<em><b>Orientation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_DESCRIPTOR__ORIENTATION = 0;

	/**
	 * The feature id for the '<em><b>Auto Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_DESCRIPTOR__AUTO_SCALE = 1;

	/**
	 * The feature id for the '<em><b>Auto Scale Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_DESCRIPTOR__AUTO_SCALE_THRESHOLD = 2;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_DESCRIPTOR__BACKGROUND_COLOR = 3;

	/**
	 * The feature id for the '<em><b>Dash Grid Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_DESCRIPTOR__DASH_GRID_LINE = 4;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_DESCRIPTOR__FOREGROUND_COLOR = 5;

	/**
	 * The feature id for the '<em><b>Log Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_DESCRIPTOR__LOG_SCALE = 6;

	/**
	 * The feature id for the '<em><b>Major Grid Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_DESCRIPTOR__MAJOR_GRID_COLOR = 7;

	/**
	 * The feature id for the '<em><b>Minor Grid Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_DESCRIPTOR__MINOR_GRID_COLOR = 8;

	/**
	 * The feature id for the '<em><b>Minor Ticks Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_DESCRIPTOR__MINOR_TICKS_VISIBLE = 9;

	/**
	 * The feature id for the '<em><b>Primary Side</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_DESCRIPTOR__PRIMARY_SIDE = 10;

	/**
	 * The feature id for the '<em><b>Range Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_DESCRIPTOR__RANGE_LOWER = 11;

	/**
	 * The feature id for the '<em><b>Range Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_DESCRIPTOR__RANGE_UPPER = 12;

	/**
	 * The feature id for the '<em><b>Show Major Grid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_DESCRIPTOR__SHOW_MAJOR_GRID = 13;

	/**
	 * The feature id for the '<em><b>Show Minor Grid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_DESCRIPTOR__SHOW_MINOR_GRID = 14;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_DESCRIPTOR__TITLE = 15;

	/**
	 * The feature id for the '<em><b>Zoom Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_DESCRIPTOR__ZOOM_TYPE = 16;

	/**
	 * The feature id for the '<em><b>Title Font</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_DESCRIPTOR__TITLE_FONT = 17;

	/**
	 * The feature id for the '<em><b>Font</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_DESCRIPTOR__FONT = 18;

	/**
	 * The feature id for the '<em><b>Auto Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_DESCRIPTOR__AUTO_FORMAT = 19;

	/**
	 * The feature id for the '<em><b>Date Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_DESCRIPTOR__DATE_ENABLED = 20;

	/**
	 * The feature id for the '<em><b>Format Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_DESCRIPTOR__FORMAT_PATTERN = 21;

	/**
	 * The number of structural features of the '<em>Axis Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_DESCRIPTOR_FEATURE_COUNT = 22;

	/**
	 * The number of operations of the '<em>Axis Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AXIS_DESCRIPTOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.TraceDescriptorImpl <em>Trace Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.TraceDescriptorImpl
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphPackageImpl#getTraceDescriptor()
	 * @generated
	 */
	int TRACE_DESCRIPTOR = 2;

	/**
	 * The feature id for the '<em><b>Anti Aliasing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_DESCRIPTOR__ANTI_ALIASING = 0;

	/**
	 * The feature id for the '<em><b>Area Alpha</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_DESCRIPTOR__AREA_ALPHA = 1;

	/**
	 * The feature id for the '<em><b>Base Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_DESCRIPTOR__BASE_LINE = 2;

	/**
	 * The feature id for the '<em><b>Draw YError In Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_DESCRIPTOR__DRAW_YERROR_IN_AREA = 3;

	/**
	 * The feature id for the '<em><b>Error Bar Cap Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_DESCRIPTOR__ERROR_BAR_CAP_WIDTH = 4;

	/**
	 * The feature id for the '<em><b>Error Bar Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_DESCRIPTOR__ERROR_BAR_COLOR = 5;

	/**
	 * The feature id for the '<em><b>Error Bar Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_DESCRIPTOR__ERROR_BAR_ENABLED = 6;

	/**
	 * The feature id for the '<em><b>Line Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_DESCRIPTOR__LINE_WIDTH = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_DESCRIPTOR__NAME = 8;

	/**
	 * The feature id for the '<em><b>Point Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_DESCRIPTOR__POINT_SIZE = 9;

	/**
	 * The feature id for the '<em><b>Point Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_DESCRIPTOR__POINT_STYLE = 10;

	/**
	 * The feature id for the '<em><b>Trace Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_DESCRIPTOR__TRACE_COLOR = 11;

	/**
	 * The feature id for the '<em><b>Trace Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_DESCRIPTOR__TRACE_TYPE = 12;

	/**
	 * The feature id for the '<em><b>XAxis</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_DESCRIPTOR__XAXIS = 13;

	/**
	 * The feature id for the '<em><b>XError Bar Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_DESCRIPTOR__XERROR_BAR_TYPE = 14;

	/**
	 * The feature id for the '<em><b>YAxis</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_DESCRIPTOR__YAXIS = 15;

	/**
	 * The feature id for the '<em><b>YError Bar Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_DESCRIPTOR__YERROR_BAR_TYPE = 16;

	/**
	 * The feature id for the '<em><b>Data Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_DESCRIPTOR__DATA_SOURCE = 17;

	/**
	 * The number of structural features of the '<em>Trace Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_DESCRIPTOR_FEATURE_COUNT = 18;

	/**
	 * The number of operations of the '<em>Trace Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_DESCRIPTOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.FontDescriptorImpl <em>Font Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.FontDescriptorImpl
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphPackageImpl#getFontDescriptor()
	 * @generated
	 */
	int FONT_DESCRIPTOR = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_DESCRIPTOR__NAME = 0;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_DESCRIPTOR__SIZE = 1;

	/**
	 * The feature id for the '<em><b>Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_DESCRIPTOR__STYLE = 2;

	/**
	 * The number of structural features of the '<em>Font Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_DESCRIPTOR_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Font Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_DESCRIPTOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.ColorDescriptorImpl <em>Color Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.ColorDescriptorImpl
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphPackageImpl#getColorDescriptor()
	 * @generated
	 */
	int COLOR_DESCRIPTOR = 4;

	/**
	 * The feature id for the '<em><b>R</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_DESCRIPTOR__R = 0;

	/**
	 * The feature id for the '<em><b>G</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_DESCRIPTOR__G = 1;

	/**
	 * The feature id for the '<em><b>B</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_DESCRIPTOR__B = 2;

	/**
	 * The number of structural features of the '<em>Color Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_DESCRIPTOR_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Color Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_DESCRIPTOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.ZoomType <em>Zoom Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.ZoomType
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphPackageImpl#getZoomType()
	 * @generated
	 */
	int ZOOM_TYPE = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.LinearScale_Orientation <em>Linear Scale Orientation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.LinearScale_Orientation
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphPackageImpl#getLinearScale_Orientation()
	 * @generated
	 */
	int LINEAR_SCALE_ORIENTATION = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_BaseLine <em>Trace Base Line</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_BaseLine
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphPackageImpl#getTrace_BaseLine()
	 * @generated
	 */
	int TRACE_BASE_LINE = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_PointStyle <em>Trace Point Style</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_PointStyle
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphPackageImpl#getTrace_PointStyle()
	 * @generated
	 */
	int TRACE_POINT_STYLE = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_TraceType <em>Trace Trace Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_TraceType
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphPackageImpl#getTrace_TraceType()
	 * @generated
	 */
	int TRACE_TRACE_TYPE = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_ErrorBarType <em>Trace Error Bar Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_ErrorBarType
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphPackageImpl#getTrace_ErrorBarType()
	 * @generated
	 */
	int TRACE_ERROR_BAR_TYPE = 10;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor <em>Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Descriptor</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor
	 * @generated
	 */
	EClass getXYGraphDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getTitle()
	 * @see #getXYGraphDescriptor()
	 * @generated
	 */
	EAttribute getXYGraphDescriptor_Title();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#isShowLegend <em>Show Legend</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Show Legend</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#isShowLegend()
	 * @see #getXYGraphDescriptor()
	 * @generated
	 */
	EAttribute getXYGraphDescriptor_ShowLegend();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#isShowTitle <em>Show Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Show Title</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#isShowTitle()
	 * @see #getXYGraphDescriptor()
	 * @generated
	 */
	EAttribute getXYGraphDescriptor_ShowTitle();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getTitleColor <em>Title Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Title Color</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getTitleColor()
	 * @see #getXYGraphDescriptor()
	 * @generated
	 */
	EReference getXYGraphDescriptor_TitleColor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#isTransparent <em>Transparent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transparent</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#isTransparent()
	 * @see #getXYGraphDescriptor()
	 * @generated
	 */
	EAttribute getXYGraphDescriptor_Transparent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getZoomType <em>Zoom Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Zoom Type</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getZoomType()
	 * @see #getXYGraphDescriptor()
	 * @generated
	 */
	EAttribute getXYGraphDescriptor_ZoomType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getAxisDescriptors <em>Axis Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Axis Descriptors</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getAxisDescriptors()
	 * @see #getXYGraphDescriptor()
	 * @generated
	 */
	EReference getXYGraphDescriptor_AxisDescriptors();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getTraceDescriptors <em>Trace Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Trace Descriptors</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getTraceDescriptors()
	 * @see #getXYGraphDescriptor()
	 * @generated
	 */
	EReference getXYGraphDescriptor_TraceDescriptors();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#isShowPlotAreaBorder <em>Show Plot Area Border</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Show Plot Area Border</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#isShowPlotAreaBorder()
	 * @see #getXYGraphDescriptor()
	 * @generated
	 */
	EAttribute getXYGraphDescriptor_ShowPlotAreaBorder();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getPlotAreaBackgroundColor <em>Plot Area Background Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Plot Area Background Color</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getPlotAreaBackgroundColor()
	 * @see #getXYGraphDescriptor()
	 * @generated
	 */
	EReference getXYGraphDescriptor_PlotAreaBackgroundColor();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getTitleFont <em>Title Font</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Title Font</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getTitleFont()
	 * @see #getXYGraphDescriptor()
	 * @generated
	 */
	EReference getXYGraphDescriptor_TitleFont();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getContext()
	 * @see #getXYGraphDescriptor()
	 * @generated
	 */
	EReference getXYGraphDescriptor_Context();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getDataSource <em>Data Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Source</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getDataSource()
	 * @see #getXYGraphDescriptor()
	 * @generated
	 */
	EReference getXYGraphDescriptor_DataSource();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getVisibleTraces <em>Visible Traces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Visible Traces</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getVisibleTraces()
	 * @see #getXYGraphDescriptor()
	 * @generated
	 */
	EReference getXYGraphDescriptor_VisibleTraces();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor <em>Axis Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Axis Descriptor</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor
	 * @generated
	 */
	EClass getAxisDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getOrientation <em>Orientation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Orientation</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getOrientation()
	 * @see #getAxisDescriptor()
	 * @generated
	 */
	EAttribute getAxisDescriptor_Orientation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isAutoScale <em>Auto Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Auto Scale</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isAutoScale()
	 * @see #getAxisDescriptor()
	 * @generated
	 */
	EAttribute getAxisDescriptor_AutoScale();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getAutoScaleThreshold <em>Auto Scale Threshold</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Auto Scale Threshold</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getAutoScaleThreshold()
	 * @see #getAxisDescriptor()
	 * @generated
	 */
	EAttribute getAxisDescriptor_AutoScaleThreshold();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getBackgroundColor <em>Background Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Background Color</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getBackgroundColor()
	 * @see #getAxisDescriptor()
	 * @generated
	 */
	EReference getAxisDescriptor_BackgroundColor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isDashGridLine <em>Dash Grid Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dash Grid Line</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isDashGridLine()
	 * @see #getAxisDescriptor()
	 * @generated
	 */
	EAttribute getAxisDescriptor_DashGridLine();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getForegroundColor <em>Foreground Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Foreground Color</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getForegroundColor()
	 * @see #getAxisDescriptor()
	 * @generated
	 */
	EReference getAxisDescriptor_ForegroundColor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isLogScale <em>Log Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Log Scale</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isLogScale()
	 * @see #getAxisDescriptor()
	 * @generated
	 */
	EAttribute getAxisDescriptor_LogScale();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getMajorGridColor <em>Major Grid Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Major Grid Color</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getMajorGridColor()
	 * @see #getAxisDescriptor()
	 * @generated
	 */
	EReference getAxisDescriptor_MajorGridColor();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getMinorGridColor <em>Minor Grid Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Minor Grid Color</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getMinorGridColor()
	 * @see #getAxisDescriptor()
	 * @generated
	 */
	EReference getAxisDescriptor_MinorGridColor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isMinorTicksVisible <em>Minor Ticks Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minor Ticks Visible</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isMinorTicksVisible()
	 * @see #getAxisDescriptor()
	 * @generated
	 */
	EAttribute getAxisDescriptor_MinorTicksVisible();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isPrimarySide <em>Primary Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primary Side</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isPrimarySide()
	 * @see #getAxisDescriptor()
	 * @generated
	 */
	EAttribute getAxisDescriptor_PrimarySide();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getRangeLower <em>Range Lower</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Range Lower</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getRangeLower()
	 * @see #getAxisDescriptor()
	 * @generated
	 */
	EAttribute getAxisDescriptor_RangeLower();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getRangeUpper <em>Range Upper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Range Upper</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getRangeUpper()
	 * @see #getAxisDescriptor()
	 * @generated
	 */
	EAttribute getAxisDescriptor_RangeUpper();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isShowMajorGrid <em>Show Major Grid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Show Major Grid</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isShowMajorGrid()
	 * @see #getAxisDescriptor()
	 * @generated
	 */
	EAttribute getAxisDescriptor_ShowMajorGrid();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isShowMinorGrid <em>Show Minor Grid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Show Minor Grid</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isShowMinorGrid()
	 * @see #getAxisDescriptor()
	 * @generated
	 */
	EAttribute getAxisDescriptor_ShowMinorGrid();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getTitle()
	 * @see #getAxisDescriptor()
	 * @generated
	 */
	EAttribute getAxisDescriptor_Title();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getZoomType <em>Zoom Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Zoom Type</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getZoomType()
	 * @see #getAxisDescriptor()
	 * @generated
	 */
	EAttribute getAxisDescriptor_ZoomType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getTitleFont <em>Title Font</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Title Font</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getTitleFont()
	 * @see #getAxisDescriptor()
	 * @generated
	 */
	EReference getAxisDescriptor_TitleFont();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getFont <em>Font</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Font</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getFont()
	 * @see #getAxisDescriptor()
	 * @generated
	 */
	EReference getAxisDescriptor_Font();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isAutoFormat <em>Auto Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Auto Format</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isAutoFormat()
	 * @see #getAxisDescriptor()
	 * @generated
	 */
	EAttribute getAxisDescriptor_AutoFormat();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isDateEnabled <em>Date Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date Enabled</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isDateEnabled()
	 * @see #getAxisDescriptor()
	 * @generated
	 */
	EAttribute getAxisDescriptor_DateEnabled();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getFormatPattern <em>Format Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format Pattern</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getFormatPattern()
	 * @see #getAxisDescriptor()
	 * @generated
	 */
	EAttribute getAxisDescriptor_FormatPattern();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor <em>Trace Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Descriptor</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor
	 * @generated
	 */
	EClass getTraceDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#isAntiAliasing <em>Anti Aliasing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Anti Aliasing</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#isAntiAliasing()
	 * @see #getTraceDescriptor()
	 * @generated
	 */
	EAttribute getTraceDescriptor_AntiAliasing();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getAreaAlpha <em>Area Alpha</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Area Alpha</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getAreaAlpha()
	 * @see #getTraceDescriptor()
	 * @generated
	 */
	EAttribute getTraceDescriptor_AreaAlpha();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getBaseLine <em>Base Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base Line</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getBaseLine()
	 * @see #getTraceDescriptor()
	 * @generated
	 */
	EAttribute getTraceDescriptor_BaseLine();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#isDrawYErrorInArea <em>Draw YError In Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Draw YError In Area</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#isDrawYErrorInArea()
	 * @see #getTraceDescriptor()
	 * @generated
	 */
	EAttribute getTraceDescriptor_DrawYErrorInArea();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getErrorBarCapWidth <em>Error Bar Cap Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Error Bar Cap Width</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getErrorBarCapWidth()
	 * @see #getTraceDescriptor()
	 * @generated
	 */
	EAttribute getTraceDescriptor_ErrorBarCapWidth();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getErrorBarColor <em>Error Bar Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Error Bar Color</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getErrorBarColor()
	 * @see #getTraceDescriptor()
	 * @generated
	 */
	EReference getTraceDescriptor_ErrorBarColor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#isErrorBarEnabled <em>Error Bar Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Error Bar Enabled</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#isErrorBarEnabled()
	 * @see #getTraceDescriptor()
	 * @generated
	 */
	EAttribute getTraceDescriptor_ErrorBarEnabled();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getLineWidth <em>Line Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Width</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getLineWidth()
	 * @see #getTraceDescriptor()
	 * @generated
	 */
	EAttribute getTraceDescriptor_LineWidth();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getName()
	 * @see #getTraceDescriptor()
	 * @generated
	 */
	EAttribute getTraceDescriptor_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getPointSize <em>Point Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Point Size</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getPointSize()
	 * @see #getTraceDescriptor()
	 * @generated
	 */
	EAttribute getTraceDescriptor_PointSize();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getPointStyle <em>Point Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Point Style</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getPointStyle()
	 * @see #getTraceDescriptor()
	 * @generated
	 */
	EAttribute getTraceDescriptor_PointStyle();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getTraceColor <em>Trace Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Trace Color</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getTraceColor()
	 * @see #getTraceDescriptor()
	 * @generated
	 */
	EReference getTraceDescriptor_TraceColor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getTraceType <em>Trace Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trace Type</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getTraceType()
	 * @see #getTraceDescriptor()
	 * @generated
	 */
	EAttribute getTraceDescriptor_TraceType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getXAxis <em>XAxis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>XAxis</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getXAxis()
	 * @see #getTraceDescriptor()
	 * @generated
	 */
	EReference getTraceDescriptor_XAxis();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getXErrorBarType <em>XError Bar Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>XError Bar Type</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getXErrorBarType()
	 * @see #getTraceDescriptor()
	 * @generated
	 */
	EAttribute getTraceDescriptor_XErrorBarType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getYAxis <em>YAxis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>YAxis</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getYAxis()
	 * @see #getTraceDescriptor()
	 * @generated
	 */
	EReference getTraceDescriptor_YAxis();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getYErrorBarType <em>YError Bar Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>YError Bar Type</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getYErrorBarType()
	 * @see #getTraceDescriptor()
	 * @generated
	 */
	EAttribute getTraceDescriptor_YErrorBarType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getDataSource <em>Data Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Source</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getDataSource()
	 * @see #getTraceDescriptor()
	 * @generated
	 */
	EReference getTraceDescriptor_DataSource();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.FontDescriptor <em>Font Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Font Descriptor</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.FontDescriptor
	 * @generated
	 */
	EClass getFontDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.FontDescriptor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.FontDescriptor#getName()
	 * @see #getFontDescriptor()
	 * @generated
	 */
	EAttribute getFontDescriptor_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.FontDescriptor#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.FontDescriptor#getSize()
	 * @see #getFontDescriptor()
	 * @generated
	 */
	EAttribute getFontDescriptor_Size();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.FontDescriptor#getStyle <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Style</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.FontDescriptor#getStyle()
	 * @see #getFontDescriptor()
	 * @generated
	 */
	EAttribute getFontDescriptor_Style();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.ColorDescriptor <em>Color Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Color Descriptor</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.ColorDescriptor
	 * @generated
	 */
	EClass getColorDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.ColorDescriptor#getR <em>R</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>R</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.ColorDescriptor#getR()
	 * @see #getColorDescriptor()
	 * @generated
	 */
	EAttribute getColorDescriptor_R();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.ColorDescriptor#getG <em>G</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>G</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.ColorDescriptor#getG()
	 * @see #getColorDescriptor()
	 * @generated
	 */
	EAttribute getColorDescriptor_G();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.ColorDescriptor#getB <em>B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>B</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.ColorDescriptor#getB()
	 * @see #getColorDescriptor()
	 * @generated
	 */
	EAttribute getColorDescriptor_B();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.ZoomType <em>Zoom Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Zoom Type</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.ZoomType
	 * @generated
	 */
	EEnum getZoomType();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.LinearScale_Orientation <em>Linear Scale Orientation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Linear Scale Orientation</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.LinearScale_Orientation
	 * @generated
	 */
	EEnum getLinearScale_Orientation();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_BaseLine <em>Trace Base Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Trace Base Line</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_BaseLine
	 * @generated
	 */
	EEnum getTrace_BaseLine();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_PointStyle <em>Trace Point Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Trace Point Style</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_PointStyle
	 * @generated
	 */
	EEnum getTrace_PointStyle();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_TraceType <em>Trace Trace Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Trace Trace Type</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_TraceType
	 * @generated
	 */
	EEnum getTrace_TraceType();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_ErrorBarType <em>Trace Error Bar Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Trace Error Bar Type</em>'.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_ErrorBarType
	 * @generated
	 */
	EEnum getTrace_ErrorBarType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	XYGraphFactory getXYGraphFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphDescriptorImpl <em>Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphDescriptorImpl
		 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphPackageImpl#getXYGraphDescriptor()
		 * @generated
		 */
		EClass XY_GRAPH_DESCRIPTOR = eINSTANCE.getXYGraphDescriptor();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XY_GRAPH_DESCRIPTOR__TITLE = eINSTANCE.getXYGraphDescriptor_Title();

		/**
		 * The meta object literal for the '<em><b>Show Legend</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XY_GRAPH_DESCRIPTOR__SHOW_LEGEND = eINSTANCE.getXYGraphDescriptor_ShowLegend();

		/**
		 * The meta object literal for the '<em><b>Show Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XY_GRAPH_DESCRIPTOR__SHOW_TITLE = eINSTANCE.getXYGraphDescriptor_ShowTitle();

		/**
		 * The meta object literal for the '<em><b>Title Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XY_GRAPH_DESCRIPTOR__TITLE_COLOR = eINSTANCE.getXYGraphDescriptor_TitleColor();

		/**
		 * The meta object literal for the '<em><b>Transparent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XY_GRAPH_DESCRIPTOR__TRANSPARENT = eINSTANCE.getXYGraphDescriptor_Transparent();

		/**
		 * The meta object literal for the '<em><b>Zoom Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XY_GRAPH_DESCRIPTOR__ZOOM_TYPE = eINSTANCE.getXYGraphDescriptor_ZoomType();

		/**
		 * The meta object literal for the '<em><b>Axis Descriptors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XY_GRAPH_DESCRIPTOR__AXIS_DESCRIPTORS = eINSTANCE.getXYGraphDescriptor_AxisDescriptors();

		/**
		 * The meta object literal for the '<em><b>Trace Descriptors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XY_GRAPH_DESCRIPTOR__TRACE_DESCRIPTORS = eINSTANCE.getXYGraphDescriptor_TraceDescriptors();

		/**
		 * The meta object literal for the '<em><b>Show Plot Area Border</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XY_GRAPH_DESCRIPTOR__SHOW_PLOT_AREA_BORDER = eINSTANCE.getXYGraphDescriptor_ShowPlotAreaBorder();

		/**
		 * The meta object literal for the '<em><b>Plot Area Background Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XY_GRAPH_DESCRIPTOR__PLOT_AREA_BACKGROUND_COLOR = eINSTANCE.getXYGraphDescriptor_PlotAreaBackgroundColor();

		/**
		 * The meta object literal for the '<em><b>Title Font</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XY_GRAPH_DESCRIPTOR__TITLE_FONT = eINSTANCE.getXYGraphDescriptor_TitleFont();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XY_GRAPH_DESCRIPTOR__CONTEXT = eINSTANCE.getXYGraphDescriptor_Context();

		/**
		 * The meta object literal for the '<em><b>Data Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XY_GRAPH_DESCRIPTOR__DATA_SOURCE = eINSTANCE.getXYGraphDescriptor_DataSource();

		/**
		 * The meta object literal for the '<em><b>Visible Traces</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XY_GRAPH_DESCRIPTOR__VISIBLE_TRACES = eINSTANCE.getXYGraphDescriptor_VisibleTraces();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.AxisDescriptorImpl <em>Axis Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.AxisDescriptorImpl
		 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphPackageImpl#getAxisDescriptor()
		 * @generated
		 */
		EClass AXIS_DESCRIPTOR = eINSTANCE.getAxisDescriptor();

		/**
		 * The meta object literal for the '<em><b>Orientation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AXIS_DESCRIPTOR__ORIENTATION = eINSTANCE.getAxisDescriptor_Orientation();

		/**
		 * The meta object literal for the '<em><b>Auto Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AXIS_DESCRIPTOR__AUTO_SCALE = eINSTANCE.getAxisDescriptor_AutoScale();

		/**
		 * The meta object literal for the '<em><b>Auto Scale Threshold</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AXIS_DESCRIPTOR__AUTO_SCALE_THRESHOLD = eINSTANCE.getAxisDescriptor_AutoScaleThreshold();

		/**
		 * The meta object literal for the '<em><b>Background Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AXIS_DESCRIPTOR__BACKGROUND_COLOR = eINSTANCE.getAxisDescriptor_BackgroundColor();

		/**
		 * The meta object literal for the '<em><b>Dash Grid Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AXIS_DESCRIPTOR__DASH_GRID_LINE = eINSTANCE.getAxisDescriptor_DashGridLine();

		/**
		 * The meta object literal for the '<em><b>Foreground Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AXIS_DESCRIPTOR__FOREGROUND_COLOR = eINSTANCE.getAxisDescriptor_ForegroundColor();

		/**
		 * The meta object literal for the '<em><b>Log Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AXIS_DESCRIPTOR__LOG_SCALE = eINSTANCE.getAxisDescriptor_LogScale();

		/**
		 * The meta object literal for the '<em><b>Major Grid Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AXIS_DESCRIPTOR__MAJOR_GRID_COLOR = eINSTANCE.getAxisDescriptor_MajorGridColor();

		/**
		 * The meta object literal for the '<em><b>Minor Grid Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AXIS_DESCRIPTOR__MINOR_GRID_COLOR = eINSTANCE.getAxisDescriptor_MinorGridColor();

		/**
		 * The meta object literal for the '<em><b>Minor Ticks Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AXIS_DESCRIPTOR__MINOR_TICKS_VISIBLE = eINSTANCE.getAxisDescriptor_MinorTicksVisible();

		/**
		 * The meta object literal for the '<em><b>Primary Side</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AXIS_DESCRIPTOR__PRIMARY_SIDE = eINSTANCE.getAxisDescriptor_PrimarySide();

		/**
		 * The meta object literal for the '<em><b>Range Lower</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AXIS_DESCRIPTOR__RANGE_LOWER = eINSTANCE.getAxisDescriptor_RangeLower();

		/**
		 * The meta object literal for the '<em><b>Range Upper</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AXIS_DESCRIPTOR__RANGE_UPPER = eINSTANCE.getAxisDescriptor_RangeUpper();

		/**
		 * The meta object literal for the '<em><b>Show Major Grid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AXIS_DESCRIPTOR__SHOW_MAJOR_GRID = eINSTANCE.getAxisDescriptor_ShowMajorGrid();

		/**
		 * The meta object literal for the '<em><b>Show Minor Grid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AXIS_DESCRIPTOR__SHOW_MINOR_GRID = eINSTANCE.getAxisDescriptor_ShowMinorGrid();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AXIS_DESCRIPTOR__TITLE = eINSTANCE.getAxisDescriptor_Title();

		/**
		 * The meta object literal for the '<em><b>Zoom Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AXIS_DESCRIPTOR__ZOOM_TYPE = eINSTANCE.getAxisDescriptor_ZoomType();

		/**
		 * The meta object literal for the '<em><b>Title Font</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AXIS_DESCRIPTOR__TITLE_FONT = eINSTANCE.getAxisDescriptor_TitleFont();

		/**
		 * The meta object literal for the '<em><b>Font</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AXIS_DESCRIPTOR__FONT = eINSTANCE.getAxisDescriptor_Font();

		/**
		 * The meta object literal for the '<em><b>Auto Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AXIS_DESCRIPTOR__AUTO_FORMAT = eINSTANCE.getAxisDescriptor_AutoFormat();

		/**
		 * The meta object literal for the '<em><b>Date Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AXIS_DESCRIPTOR__DATE_ENABLED = eINSTANCE.getAxisDescriptor_DateEnabled();

		/**
		 * The meta object literal for the '<em><b>Format Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AXIS_DESCRIPTOR__FORMAT_PATTERN = eINSTANCE.getAxisDescriptor_FormatPattern();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.TraceDescriptorImpl <em>Trace Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.TraceDescriptorImpl
		 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphPackageImpl#getTraceDescriptor()
		 * @generated
		 */
		EClass TRACE_DESCRIPTOR = eINSTANCE.getTraceDescriptor();

		/**
		 * The meta object literal for the '<em><b>Anti Aliasing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_DESCRIPTOR__ANTI_ALIASING = eINSTANCE.getTraceDescriptor_AntiAliasing();

		/**
		 * The meta object literal for the '<em><b>Area Alpha</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_DESCRIPTOR__AREA_ALPHA = eINSTANCE.getTraceDescriptor_AreaAlpha();

		/**
		 * The meta object literal for the '<em><b>Base Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_DESCRIPTOR__BASE_LINE = eINSTANCE.getTraceDescriptor_BaseLine();

		/**
		 * The meta object literal for the '<em><b>Draw YError In Area</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_DESCRIPTOR__DRAW_YERROR_IN_AREA = eINSTANCE.getTraceDescriptor_DrawYErrorInArea();

		/**
		 * The meta object literal for the '<em><b>Error Bar Cap Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_DESCRIPTOR__ERROR_BAR_CAP_WIDTH = eINSTANCE.getTraceDescriptor_ErrorBarCapWidth();

		/**
		 * The meta object literal for the '<em><b>Error Bar Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_DESCRIPTOR__ERROR_BAR_COLOR = eINSTANCE.getTraceDescriptor_ErrorBarColor();

		/**
		 * The meta object literal for the '<em><b>Error Bar Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_DESCRIPTOR__ERROR_BAR_ENABLED = eINSTANCE.getTraceDescriptor_ErrorBarEnabled();

		/**
		 * The meta object literal for the '<em><b>Line Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_DESCRIPTOR__LINE_WIDTH = eINSTANCE.getTraceDescriptor_LineWidth();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_DESCRIPTOR__NAME = eINSTANCE.getTraceDescriptor_Name();

		/**
		 * The meta object literal for the '<em><b>Point Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_DESCRIPTOR__POINT_SIZE = eINSTANCE.getTraceDescriptor_PointSize();

		/**
		 * The meta object literal for the '<em><b>Point Style</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_DESCRIPTOR__POINT_STYLE = eINSTANCE.getTraceDescriptor_PointStyle();

		/**
		 * The meta object literal for the '<em><b>Trace Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_DESCRIPTOR__TRACE_COLOR = eINSTANCE.getTraceDescriptor_TraceColor();

		/**
		 * The meta object literal for the '<em><b>Trace Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_DESCRIPTOR__TRACE_TYPE = eINSTANCE.getTraceDescriptor_TraceType();

		/**
		 * The meta object literal for the '<em><b>XAxis</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_DESCRIPTOR__XAXIS = eINSTANCE.getTraceDescriptor_XAxis();

		/**
		 * The meta object literal for the '<em><b>XError Bar Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_DESCRIPTOR__XERROR_BAR_TYPE = eINSTANCE.getTraceDescriptor_XErrorBarType();

		/**
		 * The meta object literal for the '<em><b>YAxis</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_DESCRIPTOR__YAXIS = eINSTANCE.getTraceDescriptor_YAxis();

		/**
		 * The meta object literal for the '<em><b>YError Bar Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_DESCRIPTOR__YERROR_BAR_TYPE = eINSTANCE.getTraceDescriptor_YErrorBarType();

		/**
		 * The meta object literal for the '<em><b>Data Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_DESCRIPTOR__DATA_SOURCE = eINSTANCE.getTraceDescriptor_DataSource();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.FontDescriptorImpl <em>Font Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.FontDescriptorImpl
		 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphPackageImpl#getFontDescriptor()
		 * @generated
		 */
		EClass FONT_DESCRIPTOR = eINSTANCE.getFontDescriptor();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FONT_DESCRIPTOR__NAME = eINSTANCE.getFontDescriptor_Name();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FONT_DESCRIPTOR__SIZE = eINSTANCE.getFontDescriptor_Size();

		/**
		 * The meta object literal for the '<em><b>Style</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FONT_DESCRIPTOR__STYLE = eINSTANCE.getFontDescriptor_Style();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.ColorDescriptorImpl <em>Color Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.ColorDescriptorImpl
		 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphPackageImpl#getColorDescriptor()
		 * @generated
		 */
		EClass COLOR_DESCRIPTOR = eINSTANCE.getColorDescriptor();

		/**
		 * The meta object literal for the '<em><b>R</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_DESCRIPTOR__R = eINSTANCE.getColorDescriptor_R();

		/**
		 * The meta object literal for the '<em><b>G</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_DESCRIPTOR__G = eINSTANCE.getColorDescriptor_G();

		/**
		 * The meta object literal for the '<em><b>B</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR_DESCRIPTOR__B = eINSTANCE.getColorDescriptor_B();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.ZoomType <em>Zoom Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.ZoomType
		 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphPackageImpl#getZoomType()
		 * @generated
		 */
		EEnum ZOOM_TYPE = eINSTANCE.getZoomType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.LinearScale_Orientation <em>Linear Scale Orientation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.LinearScale_Orientation
		 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphPackageImpl#getLinearScale_Orientation()
		 * @generated
		 */
		EEnum LINEAR_SCALE_ORIENTATION = eINSTANCE.getLinearScale_Orientation();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_BaseLine <em>Trace Base Line</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_BaseLine
		 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphPackageImpl#getTrace_BaseLine()
		 * @generated
		 */
		EEnum TRACE_BASE_LINE = eINSTANCE.getTrace_BaseLine();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_PointStyle <em>Trace Point Style</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_PointStyle
		 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphPackageImpl#getTrace_PointStyle()
		 * @generated
		 */
		EEnum TRACE_POINT_STYLE = eINSTANCE.getTrace_PointStyle();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_TraceType <em>Trace Trace Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_TraceType
		 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphPackageImpl#getTrace_TraceType()
		 * @generated
		 */
		EEnum TRACE_TRACE_TYPE = eINSTANCE.getTrace_TraceType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_ErrorBarType <em>Trace Error Bar Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_ErrorBarType
		 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphPackageImpl#getTrace_ErrorBarType()
		 * @generated
		 */
		EEnum TRACE_ERROR_BAR_TYPE = eINSTANCE.getTrace_ErrorBarType();

	}

} //XYGraphPackage
