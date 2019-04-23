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
package org.eclipse.papyrus.moka.xygraph.model.xygraph.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.ColorDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.FontDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.LinearScale_Orientation;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_BaseLine;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_ErrorBarType;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_PointStyle;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_TraceType;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphFactory;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.ZoomType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XYGraphPackageImpl extends EPackageImpl implements XYGraphPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xyGraphDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass axisDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fontDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass colorDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum zoomTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum linearScale_OrientationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum trace_BaseLineEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum trace_PointStyleEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum trace_TraceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum trace_ErrorBarTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private XYGraphPackageImpl() {
		super(eNS_URI, XYGraphFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link XYGraphPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static XYGraphPackage init() {
		if (isInited) return (XYGraphPackage)EPackage.Registry.INSTANCE.getEPackage(XYGraphPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredXYGraphPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		XYGraphPackageImpl theXYGraphPackage = registeredXYGraphPackage instanceof XYGraphPackageImpl ? (XYGraphPackageImpl)registeredXYGraphPackage : new XYGraphPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theXYGraphPackage.createPackageContents();

		// Initialize created meta-data
		theXYGraphPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theXYGraphPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(XYGraphPackage.eNS_URI, theXYGraphPackage);
		return theXYGraphPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXYGraphDescriptor() {
		return xyGraphDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXYGraphDescriptor_Title() {
		return (EAttribute)xyGraphDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXYGraphDescriptor_ShowLegend() {
		return (EAttribute)xyGraphDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXYGraphDescriptor_ShowTitle() {
		return (EAttribute)xyGraphDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXYGraphDescriptor_TitleColor() {
		return (EReference)xyGraphDescriptorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXYGraphDescriptor_Transparent() {
		return (EAttribute)xyGraphDescriptorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXYGraphDescriptor_ZoomType() {
		return (EAttribute)xyGraphDescriptorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXYGraphDescriptor_AxisDescriptors() {
		return (EReference)xyGraphDescriptorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXYGraphDescriptor_TraceDescriptors() {
		return (EReference)xyGraphDescriptorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXYGraphDescriptor_ShowPlotAreaBorder() {
		return (EAttribute)xyGraphDescriptorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXYGraphDescriptor_PlotAreaBackgroundColor() {
		return (EReference)xyGraphDescriptorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXYGraphDescriptor_TitleFont() {
		return (EReference)xyGraphDescriptorEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXYGraphDescriptor_Context() {
		return (EReference)xyGraphDescriptorEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXYGraphDescriptor_DataSource() {
		return (EReference)xyGraphDescriptorEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXYGraphDescriptor_VisibleTraces() {
		return (EReference)xyGraphDescriptorEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAxisDescriptor() {
		return axisDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAxisDescriptor_Orientation() {
		return (EAttribute)axisDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAxisDescriptor_AutoScale() {
		return (EAttribute)axisDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAxisDescriptor_AutoScaleThreshold() {
		return (EAttribute)axisDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAxisDescriptor_BackgroundColor() {
		return (EReference)axisDescriptorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAxisDescriptor_DashGridLine() {
		return (EAttribute)axisDescriptorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAxisDescriptor_ForegroundColor() {
		return (EReference)axisDescriptorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAxisDescriptor_LogScale() {
		return (EAttribute)axisDescriptorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAxisDescriptor_MajorGridColor() {
		return (EReference)axisDescriptorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAxisDescriptor_MinorGridColor() {
		return (EReference)axisDescriptorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAxisDescriptor_MinorTicksVisible() {
		return (EAttribute)axisDescriptorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAxisDescriptor_PrimarySide() {
		return (EAttribute)axisDescriptorEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAxisDescriptor_RangeLower() {
		return (EAttribute)axisDescriptorEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAxisDescriptor_RangeUpper() {
		return (EAttribute)axisDescriptorEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAxisDescriptor_ShowMajorGrid() {
		return (EAttribute)axisDescriptorEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAxisDescriptor_ShowMinorGrid() {
		return (EAttribute)axisDescriptorEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAxisDescriptor_Title() {
		return (EAttribute)axisDescriptorEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAxisDescriptor_ZoomType() {
		return (EAttribute)axisDescriptorEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAxisDescriptor_TitleFont() {
		return (EReference)axisDescriptorEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAxisDescriptor_Font() {
		return (EReference)axisDescriptorEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAxisDescriptor_AutoFormat() {
		return (EAttribute)axisDescriptorEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAxisDescriptor_DateEnabled() {
		return (EAttribute)axisDescriptorEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAxisDescriptor_FormatPattern() {
		return (EAttribute)axisDescriptorEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTraceDescriptor() {
		return traceDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceDescriptor_AntiAliasing() {
		return (EAttribute)traceDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceDescriptor_AreaAlpha() {
		return (EAttribute)traceDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceDescriptor_BaseLine() {
		return (EAttribute)traceDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceDescriptor_DrawYErrorInArea() {
		return (EAttribute)traceDescriptorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceDescriptor_ErrorBarCapWidth() {
		return (EAttribute)traceDescriptorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraceDescriptor_ErrorBarColor() {
		return (EReference)traceDescriptorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceDescriptor_ErrorBarEnabled() {
		return (EAttribute)traceDescriptorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceDescriptor_LineWidth() {
		return (EAttribute)traceDescriptorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceDescriptor_Name() {
		return (EAttribute)traceDescriptorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceDescriptor_PointSize() {
		return (EAttribute)traceDescriptorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceDescriptor_PointStyle() {
		return (EAttribute)traceDescriptorEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraceDescriptor_TraceColor() {
		return (EReference)traceDescriptorEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceDescriptor_TraceType() {
		return (EAttribute)traceDescriptorEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraceDescriptor_XAxis() {
		return (EReference)traceDescriptorEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceDescriptor_XErrorBarType() {
		return (EAttribute)traceDescriptorEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraceDescriptor_YAxis() {
		return (EReference)traceDescriptorEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTraceDescriptor_YErrorBarType() {
		return (EAttribute)traceDescriptorEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTraceDescriptor_DataSource() {
		return (EReference)traceDescriptorEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFontDescriptor() {
		return fontDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFontDescriptor_Name() {
		return (EAttribute)fontDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFontDescriptor_Size() {
		return (EAttribute)fontDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFontDescriptor_Style() {
		return (EAttribute)fontDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getColorDescriptor() {
		return colorDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorDescriptor_R() {
		return (EAttribute)colorDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorDescriptor_G() {
		return (EAttribute)colorDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorDescriptor_B() {
		return (EAttribute)colorDescriptorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getZoomType() {
		return zoomTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLinearScale_Orientation() {
		return linearScale_OrientationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTrace_BaseLine() {
		return trace_BaseLineEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTrace_PointStyle() {
		return trace_PointStyleEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTrace_TraceType() {
		return trace_TraceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTrace_ErrorBarType() {
		return trace_ErrorBarTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XYGraphFactory getXYGraphFactory() {
		return (XYGraphFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		xyGraphDescriptorEClass = createEClass(XY_GRAPH_DESCRIPTOR);
		createEAttribute(xyGraphDescriptorEClass, XY_GRAPH_DESCRIPTOR__TITLE);
		createEAttribute(xyGraphDescriptorEClass, XY_GRAPH_DESCRIPTOR__SHOW_LEGEND);
		createEAttribute(xyGraphDescriptorEClass, XY_GRAPH_DESCRIPTOR__SHOW_TITLE);
		createEReference(xyGraphDescriptorEClass, XY_GRAPH_DESCRIPTOR__TITLE_COLOR);
		createEAttribute(xyGraphDescriptorEClass, XY_GRAPH_DESCRIPTOR__TRANSPARENT);
		createEAttribute(xyGraphDescriptorEClass, XY_GRAPH_DESCRIPTOR__ZOOM_TYPE);
		createEReference(xyGraphDescriptorEClass, XY_GRAPH_DESCRIPTOR__AXIS_DESCRIPTORS);
		createEReference(xyGraphDescriptorEClass, XY_GRAPH_DESCRIPTOR__TRACE_DESCRIPTORS);
		createEAttribute(xyGraphDescriptorEClass, XY_GRAPH_DESCRIPTOR__SHOW_PLOT_AREA_BORDER);
		createEReference(xyGraphDescriptorEClass, XY_GRAPH_DESCRIPTOR__PLOT_AREA_BACKGROUND_COLOR);
		createEReference(xyGraphDescriptorEClass, XY_GRAPH_DESCRIPTOR__TITLE_FONT);
		createEReference(xyGraphDescriptorEClass, XY_GRAPH_DESCRIPTOR__CONTEXT);
		createEReference(xyGraphDescriptorEClass, XY_GRAPH_DESCRIPTOR__DATA_SOURCE);
		createEReference(xyGraphDescriptorEClass, XY_GRAPH_DESCRIPTOR__VISIBLE_TRACES);

		axisDescriptorEClass = createEClass(AXIS_DESCRIPTOR);
		createEAttribute(axisDescriptorEClass, AXIS_DESCRIPTOR__ORIENTATION);
		createEAttribute(axisDescriptorEClass, AXIS_DESCRIPTOR__AUTO_SCALE);
		createEAttribute(axisDescriptorEClass, AXIS_DESCRIPTOR__AUTO_SCALE_THRESHOLD);
		createEReference(axisDescriptorEClass, AXIS_DESCRIPTOR__BACKGROUND_COLOR);
		createEAttribute(axisDescriptorEClass, AXIS_DESCRIPTOR__DASH_GRID_LINE);
		createEReference(axisDescriptorEClass, AXIS_DESCRIPTOR__FOREGROUND_COLOR);
		createEAttribute(axisDescriptorEClass, AXIS_DESCRIPTOR__LOG_SCALE);
		createEReference(axisDescriptorEClass, AXIS_DESCRIPTOR__MAJOR_GRID_COLOR);
		createEReference(axisDescriptorEClass, AXIS_DESCRIPTOR__MINOR_GRID_COLOR);
		createEAttribute(axisDescriptorEClass, AXIS_DESCRIPTOR__MINOR_TICKS_VISIBLE);
		createEAttribute(axisDescriptorEClass, AXIS_DESCRIPTOR__PRIMARY_SIDE);
		createEAttribute(axisDescriptorEClass, AXIS_DESCRIPTOR__RANGE_LOWER);
		createEAttribute(axisDescriptorEClass, AXIS_DESCRIPTOR__RANGE_UPPER);
		createEAttribute(axisDescriptorEClass, AXIS_DESCRIPTOR__SHOW_MAJOR_GRID);
		createEAttribute(axisDescriptorEClass, AXIS_DESCRIPTOR__SHOW_MINOR_GRID);
		createEAttribute(axisDescriptorEClass, AXIS_DESCRIPTOR__TITLE);
		createEAttribute(axisDescriptorEClass, AXIS_DESCRIPTOR__ZOOM_TYPE);
		createEReference(axisDescriptorEClass, AXIS_DESCRIPTOR__TITLE_FONT);
		createEReference(axisDescriptorEClass, AXIS_DESCRIPTOR__FONT);
		createEAttribute(axisDescriptorEClass, AXIS_DESCRIPTOR__AUTO_FORMAT);
		createEAttribute(axisDescriptorEClass, AXIS_DESCRIPTOR__DATE_ENABLED);
		createEAttribute(axisDescriptorEClass, AXIS_DESCRIPTOR__FORMAT_PATTERN);

		traceDescriptorEClass = createEClass(TRACE_DESCRIPTOR);
		createEAttribute(traceDescriptorEClass, TRACE_DESCRIPTOR__ANTI_ALIASING);
		createEAttribute(traceDescriptorEClass, TRACE_DESCRIPTOR__AREA_ALPHA);
		createEAttribute(traceDescriptorEClass, TRACE_DESCRIPTOR__BASE_LINE);
		createEAttribute(traceDescriptorEClass, TRACE_DESCRIPTOR__DRAW_YERROR_IN_AREA);
		createEAttribute(traceDescriptorEClass, TRACE_DESCRIPTOR__ERROR_BAR_CAP_WIDTH);
		createEReference(traceDescriptorEClass, TRACE_DESCRIPTOR__ERROR_BAR_COLOR);
		createEAttribute(traceDescriptorEClass, TRACE_DESCRIPTOR__ERROR_BAR_ENABLED);
		createEAttribute(traceDescriptorEClass, TRACE_DESCRIPTOR__LINE_WIDTH);
		createEAttribute(traceDescriptorEClass, TRACE_DESCRIPTOR__NAME);
		createEAttribute(traceDescriptorEClass, TRACE_DESCRIPTOR__POINT_SIZE);
		createEAttribute(traceDescriptorEClass, TRACE_DESCRIPTOR__POINT_STYLE);
		createEReference(traceDescriptorEClass, TRACE_DESCRIPTOR__TRACE_COLOR);
		createEAttribute(traceDescriptorEClass, TRACE_DESCRIPTOR__TRACE_TYPE);
		createEReference(traceDescriptorEClass, TRACE_DESCRIPTOR__XAXIS);
		createEAttribute(traceDescriptorEClass, TRACE_DESCRIPTOR__XERROR_BAR_TYPE);
		createEReference(traceDescriptorEClass, TRACE_DESCRIPTOR__YAXIS);
		createEAttribute(traceDescriptorEClass, TRACE_DESCRIPTOR__YERROR_BAR_TYPE);
		createEReference(traceDescriptorEClass, TRACE_DESCRIPTOR__DATA_SOURCE);

		fontDescriptorEClass = createEClass(FONT_DESCRIPTOR);
		createEAttribute(fontDescriptorEClass, FONT_DESCRIPTOR__NAME);
		createEAttribute(fontDescriptorEClass, FONT_DESCRIPTOR__SIZE);
		createEAttribute(fontDescriptorEClass, FONT_DESCRIPTOR__STYLE);

		colorDescriptorEClass = createEClass(COLOR_DESCRIPTOR);
		createEAttribute(colorDescriptorEClass, COLOR_DESCRIPTOR__R);
		createEAttribute(colorDescriptorEClass, COLOR_DESCRIPTOR__G);
		createEAttribute(colorDescriptorEClass, COLOR_DESCRIPTOR__B);

		// Create enums
		zoomTypeEEnum = createEEnum(ZOOM_TYPE);
		linearScale_OrientationEEnum = createEEnum(LINEAR_SCALE_ORIENTATION);
		trace_BaseLineEEnum = createEEnum(TRACE_BASE_LINE);
		trace_PointStyleEEnum = createEEnum(TRACE_POINT_STYLE);
		trace_TraceTypeEEnum = createEEnum(TRACE_TRACE_TYPE);
		trace_ErrorBarTypeEEnum = createEEnum(TRACE_ERROR_BAR_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(xyGraphDescriptorEClass, XYGraphDescriptor.class, "XYGraphDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXYGraphDescriptor_Title(), ecorePackage.getEString(), "title", null, 0, 1, XYGraphDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXYGraphDescriptor_ShowLegend(), ecorePackage.getEBoolean(), "showLegend", "true", 0, 1, XYGraphDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXYGraphDescriptor_ShowTitle(), ecorePackage.getEBoolean(), "showTitle", "true", 0, 1, XYGraphDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXYGraphDescriptor_TitleColor(), this.getColorDescriptor(), null, "titleColor", null, 0, 1, XYGraphDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXYGraphDescriptor_Transparent(), ecorePackage.getEBoolean(), "transparent", "false", 0, 1, XYGraphDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXYGraphDescriptor_ZoomType(), this.getZoomType(), "zoomType", null, 0, 1, XYGraphDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXYGraphDescriptor_AxisDescriptors(), this.getAxisDescriptor(), null, "axisDescriptors", null, 0, -1, XYGraphDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXYGraphDescriptor_TraceDescriptors(), this.getTraceDescriptor(), null, "traceDescriptors", null, 0, -1, XYGraphDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXYGraphDescriptor_ShowPlotAreaBorder(), ecorePackage.getEBoolean(), "showPlotAreaBorder", "false", 0, 1, XYGraphDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXYGraphDescriptor_PlotAreaBackgroundColor(), this.getColorDescriptor(), null, "plotAreaBackgroundColor", null, 0, 1, XYGraphDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXYGraphDescriptor_TitleFont(), this.getFontDescriptor(), null, "titleFont", null, 0, 1, XYGraphDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXYGraphDescriptor_Context(), ecorePackage.getEObject(), null, "context", null, 1, 1, XYGraphDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXYGraphDescriptor_DataSource(), ecorePackage.getEObject(), null, "dataSource", null, 0, 1, XYGraphDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXYGraphDescriptor_VisibleTraces(), this.getTraceDescriptor(), null, "visibleTraces", null, 0, -1, XYGraphDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(axisDescriptorEClass, AxisDescriptor.class, "AxisDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAxisDescriptor_Orientation(), this.getLinearScale_Orientation(), "orientation", null, 0, 1, AxisDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAxisDescriptor_AutoScale(), ecorePackage.getEBoolean(), "autoScale", "true", 0, 1, AxisDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAxisDescriptor_AutoScaleThreshold(), ecorePackage.getEDouble(), "autoScaleThreshold", "0.01", 0, 1, AxisDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAxisDescriptor_BackgroundColor(), this.getColorDescriptor(), null, "backgroundColor", null, 0, 1, AxisDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAxisDescriptor_DashGridLine(), ecorePackage.getEBoolean(), "dashGridLine", "true", 0, 1, AxisDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAxisDescriptor_ForegroundColor(), this.getColorDescriptor(), null, "foregroundColor", null, 0, 1, AxisDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAxisDescriptor_LogScale(), ecorePackage.getEBoolean(), "logScale", "false", 0, 1, AxisDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAxisDescriptor_MajorGridColor(), this.getColorDescriptor(), null, "majorGridColor", null, 0, 1, AxisDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAxisDescriptor_MinorGridColor(), this.getColorDescriptor(), null, "minorGridColor", null, 0, 1, AxisDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAxisDescriptor_MinorTicksVisible(), ecorePackage.getEBoolean(), "minorTicksVisible", "true", 0, 1, AxisDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAxisDescriptor_PrimarySide(), ecorePackage.getEBoolean(), "primarySide", "true", 0, 1, AxisDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAxisDescriptor_RangeLower(), ecorePackage.getEDouble(), "rangeLower", null, 0, 1, AxisDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAxisDescriptor_RangeUpper(), ecorePackage.getEDouble(), "rangeUpper", null, 0, 1, AxisDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAxisDescriptor_ShowMajorGrid(), ecorePackage.getEBoolean(), "showMajorGrid", "false", 0, 1, AxisDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAxisDescriptor_ShowMinorGrid(), ecorePackage.getEBoolean(), "showMinorGrid", "false", 0, 1, AxisDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAxisDescriptor_Title(), ecorePackage.getEString(), "title", null, 0, 1, AxisDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAxisDescriptor_ZoomType(), this.getZoomType(), "zoomType", "NONE", 0, 1, AxisDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAxisDescriptor_TitleFont(), this.getFontDescriptor(), null, "titleFont", null, 0, 1, AxisDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAxisDescriptor_Font(), this.getFontDescriptor(), null, "font", null, 0, 1, AxisDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAxisDescriptor_AutoFormat(), ecorePackage.getEBoolean(), "autoFormat", "true", 0, 1, AxisDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAxisDescriptor_DateEnabled(), ecorePackage.getEBoolean(), "dateEnabled", "false", 0, 1, AxisDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAxisDescriptor_FormatPattern(), ecorePackage.getEString(), "formatPattern", "############.##", 0, 1, AxisDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(traceDescriptorEClass, TraceDescriptor.class, "TraceDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTraceDescriptor_AntiAliasing(), ecorePackage.getEBoolean(), "antiAliasing", "true", 0, 1, TraceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceDescriptor_AreaAlpha(), ecorePackage.getEInt(), "areaAlpha", "100", 0, 1, TraceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceDescriptor_BaseLine(), this.getTrace_BaseLine(), "baseLine", null, 0, 1, TraceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceDescriptor_DrawYErrorInArea(), ecorePackage.getEBoolean(), "drawYErrorInArea", "false", 0, 1, TraceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceDescriptor_ErrorBarCapWidth(), ecorePackage.getEInt(), "errorBarCapWidth", "4", 0, 1, TraceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTraceDescriptor_ErrorBarColor(), this.getColorDescriptor(), null, "errorBarColor", null, 0, 1, TraceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceDescriptor_ErrorBarEnabled(), ecorePackage.getEBoolean(), "errorBarEnabled", "false", 0, 1, TraceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceDescriptor_LineWidth(), ecorePackage.getEInt(), "lineWidth", "1", 0, 1, TraceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceDescriptor_Name(), ecorePackage.getEString(), "name", null, 0, 1, TraceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceDescriptor_PointSize(), ecorePackage.getEInt(), "pointSize", "4", 0, 1, TraceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceDescriptor_PointStyle(), this.getTrace_PointStyle(), "pointStyle", null, 0, 1, TraceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTraceDescriptor_TraceColor(), this.getColorDescriptor(), null, "traceColor", null, 0, 1, TraceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceDescriptor_TraceType(), this.getTrace_TraceType(), "traceType", null, 0, 1, TraceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTraceDescriptor_XAxis(), this.getAxisDescriptor(), null, "xAxis", null, 0, 1, TraceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceDescriptor_XErrorBarType(), this.getTrace_ErrorBarType(), "xErrorBarType", "BOTH", 0, 1, TraceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTraceDescriptor_YAxis(), this.getAxisDescriptor(), null, "yAxis", null, 0, 1, TraceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceDescriptor_YErrorBarType(), this.getTrace_ErrorBarType(), "yErrorBarType", "BOTH", 0, 1, TraceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTraceDescriptor_DataSource(), ecorePackage.getEObject(), null, "dataSource", null, 0, 1, TraceDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fontDescriptorEClass, FontDescriptor.class, "FontDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFontDescriptor_Name(), ecorePackage.getEString(), "name", "Arial", 0, 1, FontDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFontDescriptor_Size(), ecorePackage.getEInt(), "size", "12", 0, 1, FontDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFontDescriptor_Style(), ecorePackage.getEInt(), "style", "0", 0, 1, FontDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(colorDescriptorEClass, ColorDescriptor.class, "ColorDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getColorDescriptor_R(), ecorePackage.getEInt(), "r", null, 0, 1, ColorDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorDescriptor_G(), ecorePackage.getEInt(), "g", null, 0, 1, ColorDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getColorDescriptor_B(), ecorePackage.getEInt(), "b", null, 0, 1, ColorDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(zoomTypeEEnum, ZoomType.class, "ZoomType");
		addEEnumLiteral(zoomTypeEEnum, ZoomType.NONE);
		addEEnumLiteral(zoomTypeEEnum, ZoomType.RUBBERBAND_ZOOM);
		addEEnumLiteral(zoomTypeEEnum, ZoomType.DYNAMIC_ZOOM);
		addEEnumLiteral(zoomTypeEEnum, ZoomType.HORIZONTAL_ZOOM);
		addEEnumLiteral(zoomTypeEEnum, ZoomType.VERTICAL_ZOOM);
		addEEnumLiteral(zoomTypeEEnum, ZoomType.ZOOM_IN);
		addEEnumLiteral(zoomTypeEEnum, ZoomType.ZOOM_OUT);
		addEEnumLiteral(zoomTypeEEnum, ZoomType.ZOOM_IN_HORIZONTALLY);
		addEEnumLiteral(zoomTypeEEnum, ZoomType.ZOOM_OUT_HORIZONTALLY);
		addEEnumLiteral(zoomTypeEEnum, ZoomType.ZOOM_IN_VERTICALLY);
		addEEnumLiteral(zoomTypeEEnum, ZoomType.ZOOM_OUT_VERTICALLY);
		addEEnumLiteral(zoomTypeEEnum, ZoomType.PANNING);

		initEEnum(linearScale_OrientationEEnum, LinearScale_Orientation.class, "LinearScale_Orientation");
		addEEnumLiteral(linearScale_OrientationEEnum, LinearScale_Orientation.HORIZONTAL);
		addEEnumLiteral(linearScale_OrientationEEnum, LinearScale_Orientation.VERTICAL);

		initEEnum(trace_BaseLineEEnum, Trace_BaseLine.class, "Trace_BaseLine");
		addEEnumLiteral(trace_BaseLineEEnum, Trace_BaseLine.NEGATIVE_INFINITY);
		addEEnumLiteral(trace_BaseLineEEnum, Trace_BaseLine.ZERO);
		addEEnumLiteral(trace_BaseLineEEnum, Trace_BaseLine.POSITIVE_INFINITY);

		initEEnum(trace_PointStyleEEnum, Trace_PointStyle.class, "Trace_PointStyle");
		addEEnumLiteral(trace_PointStyleEEnum, Trace_PointStyle.NONE);
		addEEnumLiteral(trace_PointStyleEEnum, Trace_PointStyle.POINT);
		addEEnumLiteral(trace_PointStyleEEnum, Trace_PointStyle.CIRCLE);
		addEEnumLiteral(trace_PointStyleEEnum, Trace_PointStyle.TRIANGLE);
		addEEnumLiteral(trace_PointStyleEEnum, Trace_PointStyle.FILLED_TRIANGLE);
		addEEnumLiteral(trace_PointStyleEEnum, Trace_PointStyle.SQUARE);
		addEEnumLiteral(trace_PointStyleEEnum, Trace_PointStyle.FILLED_SQUARE);
		addEEnumLiteral(trace_PointStyleEEnum, Trace_PointStyle.DIAMOND);
		addEEnumLiteral(trace_PointStyleEEnum, Trace_PointStyle.FILLED_DIAMOND);
		addEEnumLiteral(trace_PointStyleEEnum, Trace_PointStyle.XCROSS);
		addEEnumLiteral(trace_PointStyleEEnum, Trace_PointStyle.CROSS);
		addEEnumLiteral(trace_PointStyleEEnum, Trace_PointStyle.BAR);

		initEEnum(trace_TraceTypeEEnum, Trace_TraceType.class, "Trace_TraceType");
		addEEnumLiteral(trace_TraceTypeEEnum, Trace_TraceType.SOLID_LINE);
		addEEnumLiteral(trace_TraceTypeEEnum, Trace_TraceType.DASH_LINE);
		addEEnumLiteral(trace_TraceTypeEEnum, Trace_TraceType.POINT);
		addEEnumLiteral(trace_TraceTypeEEnum, Trace_TraceType.BAR);
		addEEnumLiteral(trace_TraceTypeEEnum, Trace_TraceType.AREA);
		addEEnumLiteral(trace_TraceTypeEEnum, Trace_TraceType.LINE_AREA);
		addEEnumLiteral(trace_TraceTypeEEnum, Trace_TraceType.STEP_VERTICALLY);
		addEEnumLiteral(trace_TraceTypeEEnum, Trace_TraceType.STEP_HORIZONTALLY);
		addEEnumLiteral(trace_TraceTypeEEnum, Trace_TraceType.DASHDOT_LINE);
		addEEnumLiteral(trace_TraceTypeEEnum, Trace_TraceType.DASHDOTDOT_LINE);
		addEEnumLiteral(trace_TraceTypeEEnum, Trace_TraceType.DOT_LINE);

		initEEnum(trace_ErrorBarTypeEEnum, Trace_ErrorBarType.class, "Trace_ErrorBarType");
		addEEnumLiteral(trace_ErrorBarTypeEEnum, Trace_ErrorBarType.NONE);
		addEEnumLiteral(trace_ErrorBarTypeEEnum, Trace_ErrorBarType.PLUS);
		addEEnumLiteral(trace_ErrorBarTypeEEnum, Trace_ErrorBarType.MINUS);
		addEEnumLiteral(trace_ErrorBarTypeEEnum, Trace_ErrorBarType.BOTH);

		// Create resource
		createResource(eNS_URI);
	}

} //XYGraphPackageImpl
