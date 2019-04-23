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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.ColorDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_BaseLine;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_ErrorBarType;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_PointStyle;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_TraceType;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.TraceDescriptorImpl#isAntiAliasing <em>Anti Aliasing</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.TraceDescriptorImpl#getAreaAlpha <em>Area Alpha</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.TraceDescriptorImpl#getBaseLine <em>Base Line</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.TraceDescriptorImpl#isDrawYErrorInArea <em>Draw YError In Area</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.TraceDescriptorImpl#getErrorBarCapWidth <em>Error Bar Cap Width</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.TraceDescriptorImpl#getErrorBarColor <em>Error Bar Color</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.TraceDescriptorImpl#isErrorBarEnabled <em>Error Bar Enabled</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.TraceDescriptorImpl#getLineWidth <em>Line Width</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.TraceDescriptorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.TraceDescriptorImpl#getPointSize <em>Point Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.TraceDescriptorImpl#getPointStyle <em>Point Style</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.TraceDescriptorImpl#getTraceColor <em>Trace Color</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.TraceDescriptorImpl#getTraceType <em>Trace Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.TraceDescriptorImpl#getXAxis <em>XAxis</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.TraceDescriptorImpl#getXErrorBarType <em>XError Bar Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.TraceDescriptorImpl#getYAxis <em>YAxis</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.TraceDescriptorImpl#getYErrorBarType <em>YError Bar Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.TraceDescriptorImpl#getDataSource <em>Data Source</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TraceDescriptorImpl extends MinimalEObjectImpl.Container implements TraceDescriptor {
	/**
	 * The default value of the '{@link #isAntiAliasing() <em>Anti Aliasing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAntiAliasing()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ANTI_ALIASING_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isAntiAliasing() <em>Anti Aliasing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAntiAliasing()
	 * @generated
	 * @ordered
	 */
	protected boolean antiAliasing = ANTI_ALIASING_EDEFAULT;

	/**
	 * The default value of the '{@link #getAreaAlpha() <em>Area Alpha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAreaAlpha()
	 * @generated
	 * @ordered
	 */
	protected static final int AREA_ALPHA_EDEFAULT = 100;

	/**
	 * The cached value of the '{@link #getAreaAlpha() <em>Area Alpha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAreaAlpha()
	 * @generated
	 * @ordered
	 */
	protected int areaAlpha = AREA_ALPHA_EDEFAULT;

	/**
	 * The default value of the '{@link #getBaseLine() <em>Base Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseLine()
	 * @generated
	 * @ordered
	 */
	protected static final Trace_BaseLine BASE_LINE_EDEFAULT = Trace_BaseLine.NEGATIVE_INFINITY;

	/**
	 * The cached value of the '{@link #getBaseLine() <em>Base Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseLine()
	 * @generated
	 * @ordered
	 */
	protected Trace_BaseLine baseLine = BASE_LINE_EDEFAULT;

	/**
	 * The default value of the '{@link #isDrawYErrorInArea() <em>Draw YError In Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDrawYErrorInArea()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DRAW_YERROR_IN_AREA_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDrawYErrorInArea() <em>Draw YError In Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDrawYErrorInArea()
	 * @generated
	 * @ordered
	 */
	protected boolean drawYErrorInArea = DRAW_YERROR_IN_AREA_EDEFAULT;

	/**
	 * The default value of the '{@link #getErrorBarCapWidth() <em>Error Bar Cap Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorBarCapWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int ERROR_BAR_CAP_WIDTH_EDEFAULT = 4;

	/**
	 * The cached value of the '{@link #getErrorBarCapWidth() <em>Error Bar Cap Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorBarCapWidth()
	 * @generated
	 * @ordered
	 */
	protected int errorBarCapWidth = ERROR_BAR_CAP_WIDTH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getErrorBarColor() <em>Error Bar Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorBarColor()
	 * @generated
	 * @ordered
	 */
	protected ColorDescriptor errorBarColor;

	/**
	 * The default value of the '{@link #isErrorBarEnabled() <em>Error Bar Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isErrorBarEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ERROR_BAR_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isErrorBarEnabled() <em>Error Bar Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isErrorBarEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean errorBarEnabled = ERROR_BAR_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getLineWidth() <em>Line Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int LINE_WIDTH_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getLineWidth() <em>Line Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineWidth()
	 * @generated
	 * @ordered
	 */
	protected int lineWidth = LINE_WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPointSize() <em>Point Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPointSize()
	 * @generated
	 * @ordered
	 */
	protected static final int POINT_SIZE_EDEFAULT = 4;

	/**
	 * The cached value of the '{@link #getPointSize() <em>Point Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPointSize()
	 * @generated
	 * @ordered
	 */
	protected int pointSize = POINT_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPointStyle() <em>Point Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPointStyle()
	 * @generated
	 * @ordered
	 */
	protected static final Trace_PointStyle POINT_STYLE_EDEFAULT = Trace_PointStyle.NONE;

	/**
	 * The cached value of the '{@link #getPointStyle() <em>Point Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPointStyle()
	 * @generated
	 * @ordered
	 */
	protected Trace_PointStyle pointStyle = POINT_STYLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTraceColor() <em>Trace Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceColor()
	 * @generated
	 * @ordered
	 */
	protected ColorDescriptor traceColor;

	/**
	 * The default value of the '{@link #getTraceType() <em>Trace Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceType()
	 * @generated
	 * @ordered
	 */
	protected static final Trace_TraceType TRACE_TYPE_EDEFAULT = Trace_TraceType.SOLID_LINE;

	/**
	 * The cached value of the '{@link #getTraceType() <em>Trace Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceType()
	 * @generated
	 * @ordered
	 */
	protected Trace_TraceType traceType = TRACE_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getXAxis() <em>XAxis</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXAxis()
	 * @generated
	 * @ordered
	 */
	protected AxisDescriptor xAxis;

	/**
	 * The default value of the '{@link #getXErrorBarType() <em>XError Bar Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXErrorBarType()
	 * @generated
	 * @ordered
	 */
	protected static final Trace_ErrorBarType XERROR_BAR_TYPE_EDEFAULT = Trace_ErrorBarType.BOTH;

	/**
	 * The cached value of the '{@link #getXErrorBarType() <em>XError Bar Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXErrorBarType()
	 * @generated
	 * @ordered
	 */
	protected Trace_ErrorBarType xErrorBarType = XERROR_BAR_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getYAxis() <em>YAxis</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYAxis()
	 * @generated
	 * @ordered
	 */
	protected AxisDescriptor yAxis;

	/**
	 * The default value of the '{@link #getYErrorBarType() <em>YError Bar Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYErrorBarType()
	 * @generated
	 * @ordered
	 */
	protected static final Trace_ErrorBarType YERROR_BAR_TYPE_EDEFAULT = Trace_ErrorBarType.BOTH;

	/**
	 * The cached value of the '{@link #getYErrorBarType() <em>YError Bar Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYErrorBarType()
	 * @generated
	 * @ordered
	 */
	protected Trace_ErrorBarType yErrorBarType = YERROR_BAR_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDataSource() <em>Data Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSource()
	 * @generated
	 * @ordered
	 */
	protected EObject dataSource;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XYGraphPackage.Literals.TRACE_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAntiAliasing() {
		return antiAliasing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAntiAliasing(boolean newAntiAliasing) {
		boolean oldAntiAliasing = antiAliasing;
		antiAliasing = newAntiAliasing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.TRACE_DESCRIPTOR__ANTI_ALIASING, oldAntiAliasing, antiAliasing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAreaAlpha() {
		return areaAlpha;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAreaAlpha(int newAreaAlpha) {
		int oldAreaAlpha = areaAlpha;
		areaAlpha = newAreaAlpha;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.TRACE_DESCRIPTOR__AREA_ALPHA, oldAreaAlpha, areaAlpha));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trace_BaseLine getBaseLine() {
		return baseLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseLine(Trace_BaseLine newBaseLine) {
		Trace_BaseLine oldBaseLine = baseLine;
		baseLine = newBaseLine == null ? BASE_LINE_EDEFAULT : newBaseLine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.TRACE_DESCRIPTOR__BASE_LINE, oldBaseLine, baseLine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDrawYErrorInArea() {
		return drawYErrorInArea;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDrawYErrorInArea(boolean newDrawYErrorInArea) {
		boolean oldDrawYErrorInArea = drawYErrorInArea;
		drawYErrorInArea = newDrawYErrorInArea;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.TRACE_DESCRIPTOR__DRAW_YERROR_IN_AREA, oldDrawYErrorInArea, drawYErrorInArea));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getErrorBarCapWidth() {
		return errorBarCapWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setErrorBarCapWidth(int newErrorBarCapWidth) {
		int oldErrorBarCapWidth = errorBarCapWidth;
		errorBarCapWidth = newErrorBarCapWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.TRACE_DESCRIPTOR__ERROR_BAR_CAP_WIDTH, oldErrorBarCapWidth, errorBarCapWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorDescriptor getErrorBarColor() {
		return errorBarColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetErrorBarColor(ColorDescriptor newErrorBarColor, NotificationChain msgs) {
		ColorDescriptor oldErrorBarColor = errorBarColor;
		errorBarColor = newErrorBarColor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XYGraphPackage.TRACE_DESCRIPTOR__ERROR_BAR_COLOR, oldErrorBarColor, newErrorBarColor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setErrorBarColor(ColorDescriptor newErrorBarColor) {
		if (newErrorBarColor != errorBarColor) {
			NotificationChain msgs = null;
			if (errorBarColor != null)
				msgs = ((InternalEObject)errorBarColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XYGraphPackage.TRACE_DESCRIPTOR__ERROR_BAR_COLOR, null, msgs);
			if (newErrorBarColor != null)
				msgs = ((InternalEObject)newErrorBarColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XYGraphPackage.TRACE_DESCRIPTOR__ERROR_BAR_COLOR, null, msgs);
			msgs = basicSetErrorBarColor(newErrorBarColor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.TRACE_DESCRIPTOR__ERROR_BAR_COLOR, newErrorBarColor, newErrorBarColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isErrorBarEnabled() {
		return errorBarEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setErrorBarEnabled(boolean newErrorBarEnabled) {
		boolean oldErrorBarEnabled = errorBarEnabled;
		errorBarEnabled = newErrorBarEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.TRACE_DESCRIPTOR__ERROR_BAR_ENABLED, oldErrorBarEnabled, errorBarEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLineWidth() {
		return lineWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLineWidth(int newLineWidth) {
		int oldLineWidth = lineWidth;
		lineWidth = newLineWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.TRACE_DESCRIPTOR__LINE_WIDTH, oldLineWidth, lineWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.TRACE_DESCRIPTOR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPointSize() {
		return pointSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPointSize(int newPointSize) {
		int oldPointSize = pointSize;
		pointSize = newPointSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.TRACE_DESCRIPTOR__POINT_SIZE, oldPointSize, pointSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trace_PointStyle getPointStyle() {
		return pointStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPointStyle(Trace_PointStyle newPointStyle) {
		Trace_PointStyle oldPointStyle = pointStyle;
		pointStyle = newPointStyle == null ? POINT_STYLE_EDEFAULT : newPointStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.TRACE_DESCRIPTOR__POINT_STYLE, oldPointStyle, pointStyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorDescriptor getTraceColor() {
		return traceColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTraceColor(ColorDescriptor newTraceColor, NotificationChain msgs) {
		ColorDescriptor oldTraceColor = traceColor;
		traceColor = newTraceColor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XYGraphPackage.TRACE_DESCRIPTOR__TRACE_COLOR, oldTraceColor, newTraceColor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTraceColor(ColorDescriptor newTraceColor) {
		if (newTraceColor != traceColor) {
			NotificationChain msgs = null;
			if (traceColor != null)
				msgs = ((InternalEObject)traceColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XYGraphPackage.TRACE_DESCRIPTOR__TRACE_COLOR, null, msgs);
			if (newTraceColor != null)
				msgs = ((InternalEObject)newTraceColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XYGraphPackage.TRACE_DESCRIPTOR__TRACE_COLOR, null, msgs);
			msgs = basicSetTraceColor(newTraceColor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.TRACE_DESCRIPTOR__TRACE_COLOR, newTraceColor, newTraceColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trace_TraceType getTraceType() {
		return traceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTraceType(Trace_TraceType newTraceType) {
		Trace_TraceType oldTraceType = traceType;
		traceType = newTraceType == null ? TRACE_TYPE_EDEFAULT : newTraceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.TRACE_DESCRIPTOR__TRACE_TYPE, oldTraceType, traceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AxisDescriptor getXAxis() {
		if (xAxis != null && xAxis.eIsProxy()) {
			InternalEObject oldXAxis = (InternalEObject)xAxis;
			xAxis = (AxisDescriptor)eResolveProxy(oldXAxis);
			if (xAxis != oldXAxis) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XYGraphPackage.TRACE_DESCRIPTOR__XAXIS, oldXAxis, xAxis));
			}
		}
		return xAxis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AxisDescriptor basicGetXAxis() {
		return xAxis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXAxis(AxisDescriptor newXAxis) {
		AxisDescriptor oldXAxis = xAxis;
		xAxis = newXAxis;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.TRACE_DESCRIPTOR__XAXIS, oldXAxis, xAxis));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trace_ErrorBarType getXErrorBarType() {
		return xErrorBarType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXErrorBarType(Trace_ErrorBarType newXErrorBarType) {
		Trace_ErrorBarType oldXErrorBarType = xErrorBarType;
		xErrorBarType = newXErrorBarType == null ? XERROR_BAR_TYPE_EDEFAULT : newXErrorBarType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.TRACE_DESCRIPTOR__XERROR_BAR_TYPE, oldXErrorBarType, xErrorBarType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AxisDescriptor getYAxis() {
		if (yAxis != null && yAxis.eIsProxy()) {
			InternalEObject oldYAxis = (InternalEObject)yAxis;
			yAxis = (AxisDescriptor)eResolveProxy(oldYAxis);
			if (yAxis != oldYAxis) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XYGraphPackage.TRACE_DESCRIPTOR__YAXIS, oldYAxis, yAxis));
			}
		}
		return yAxis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AxisDescriptor basicGetYAxis() {
		return yAxis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYAxis(AxisDescriptor newYAxis) {
		AxisDescriptor oldYAxis = yAxis;
		yAxis = newYAxis;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.TRACE_DESCRIPTOR__YAXIS, oldYAxis, yAxis));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trace_ErrorBarType getYErrorBarType() {
		return yErrorBarType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYErrorBarType(Trace_ErrorBarType newYErrorBarType) {
		Trace_ErrorBarType oldYErrorBarType = yErrorBarType;
		yErrorBarType = newYErrorBarType == null ? YERROR_BAR_TYPE_EDEFAULT : newYErrorBarType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.TRACE_DESCRIPTOR__YERROR_BAR_TYPE, oldYErrorBarType, yErrorBarType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getDataSource() {
		if (dataSource != null && dataSource.eIsProxy()) {
			InternalEObject oldDataSource = (InternalEObject)dataSource;
			dataSource = eResolveProxy(oldDataSource);
			if (dataSource != oldDataSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XYGraphPackage.TRACE_DESCRIPTOR__DATA_SOURCE, oldDataSource, dataSource));
			}
		}
		return dataSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetDataSource() {
		return dataSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataSource(EObject newDataSource) {
		EObject oldDataSource = dataSource;
		dataSource = newDataSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.TRACE_DESCRIPTOR__DATA_SOURCE, oldDataSource, dataSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XYGraphPackage.TRACE_DESCRIPTOR__ERROR_BAR_COLOR:
				return basicSetErrorBarColor(null, msgs);
			case XYGraphPackage.TRACE_DESCRIPTOR__TRACE_COLOR:
				return basicSetTraceColor(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XYGraphPackage.TRACE_DESCRIPTOR__ANTI_ALIASING:
				return isAntiAliasing();
			case XYGraphPackage.TRACE_DESCRIPTOR__AREA_ALPHA:
				return getAreaAlpha();
			case XYGraphPackage.TRACE_DESCRIPTOR__BASE_LINE:
				return getBaseLine();
			case XYGraphPackage.TRACE_DESCRIPTOR__DRAW_YERROR_IN_AREA:
				return isDrawYErrorInArea();
			case XYGraphPackage.TRACE_DESCRIPTOR__ERROR_BAR_CAP_WIDTH:
				return getErrorBarCapWidth();
			case XYGraphPackage.TRACE_DESCRIPTOR__ERROR_BAR_COLOR:
				return getErrorBarColor();
			case XYGraphPackage.TRACE_DESCRIPTOR__ERROR_BAR_ENABLED:
				return isErrorBarEnabled();
			case XYGraphPackage.TRACE_DESCRIPTOR__LINE_WIDTH:
				return getLineWidth();
			case XYGraphPackage.TRACE_DESCRIPTOR__NAME:
				return getName();
			case XYGraphPackage.TRACE_DESCRIPTOR__POINT_SIZE:
				return getPointSize();
			case XYGraphPackage.TRACE_DESCRIPTOR__POINT_STYLE:
				return getPointStyle();
			case XYGraphPackage.TRACE_DESCRIPTOR__TRACE_COLOR:
				return getTraceColor();
			case XYGraphPackage.TRACE_DESCRIPTOR__TRACE_TYPE:
				return getTraceType();
			case XYGraphPackage.TRACE_DESCRIPTOR__XAXIS:
				if (resolve) return getXAxis();
				return basicGetXAxis();
			case XYGraphPackage.TRACE_DESCRIPTOR__XERROR_BAR_TYPE:
				return getXErrorBarType();
			case XYGraphPackage.TRACE_DESCRIPTOR__YAXIS:
				if (resolve) return getYAxis();
				return basicGetYAxis();
			case XYGraphPackage.TRACE_DESCRIPTOR__YERROR_BAR_TYPE:
				return getYErrorBarType();
			case XYGraphPackage.TRACE_DESCRIPTOR__DATA_SOURCE:
				if (resolve) return getDataSource();
				return basicGetDataSource();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case XYGraphPackage.TRACE_DESCRIPTOR__ANTI_ALIASING:
				setAntiAliasing((Boolean)newValue);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__AREA_ALPHA:
				setAreaAlpha((Integer)newValue);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__BASE_LINE:
				setBaseLine((Trace_BaseLine)newValue);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__DRAW_YERROR_IN_AREA:
				setDrawYErrorInArea((Boolean)newValue);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__ERROR_BAR_CAP_WIDTH:
				setErrorBarCapWidth((Integer)newValue);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__ERROR_BAR_COLOR:
				setErrorBarColor((ColorDescriptor)newValue);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__ERROR_BAR_ENABLED:
				setErrorBarEnabled((Boolean)newValue);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__LINE_WIDTH:
				setLineWidth((Integer)newValue);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__NAME:
				setName((String)newValue);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__POINT_SIZE:
				setPointSize((Integer)newValue);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__POINT_STYLE:
				setPointStyle((Trace_PointStyle)newValue);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__TRACE_COLOR:
				setTraceColor((ColorDescriptor)newValue);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__TRACE_TYPE:
				setTraceType((Trace_TraceType)newValue);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__XAXIS:
				setXAxis((AxisDescriptor)newValue);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__XERROR_BAR_TYPE:
				setXErrorBarType((Trace_ErrorBarType)newValue);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__YAXIS:
				setYAxis((AxisDescriptor)newValue);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__YERROR_BAR_TYPE:
				setYErrorBarType((Trace_ErrorBarType)newValue);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__DATA_SOURCE:
				setDataSource((EObject)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case XYGraphPackage.TRACE_DESCRIPTOR__ANTI_ALIASING:
				setAntiAliasing(ANTI_ALIASING_EDEFAULT);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__AREA_ALPHA:
				setAreaAlpha(AREA_ALPHA_EDEFAULT);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__BASE_LINE:
				setBaseLine(BASE_LINE_EDEFAULT);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__DRAW_YERROR_IN_AREA:
				setDrawYErrorInArea(DRAW_YERROR_IN_AREA_EDEFAULT);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__ERROR_BAR_CAP_WIDTH:
				setErrorBarCapWidth(ERROR_BAR_CAP_WIDTH_EDEFAULT);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__ERROR_BAR_COLOR:
				setErrorBarColor((ColorDescriptor)null);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__ERROR_BAR_ENABLED:
				setErrorBarEnabled(ERROR_BAR_ENABLED_EDEFAULT);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__LINE_WIDTH:
				setLineWidth(LINE_WIDTH_EDEFAULT);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__POINT_SIZE:
				setPointSize(POINT_SIZE_EDEFAULT);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__POINT_STYLE:
				setPointStyle(POINT_STYLE_EDEFAULT);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__TRACE_COLOR:
				setTraceColor((ColorDescriptor)null);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__TRACE_TYPE:
				setTraceType(TRACE_TYPE_EDEFAULT);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__XAXIS:
				setXAxis((AxisDescriptor)null);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__XERROR_BAR_TYPE:
				setXErrorBarType(XERROR_BAR_TYPE_EDEFAULT);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__YAXIS:
				setYAxis((AxisDescriptor)null);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__YERROR_BAR_TYPE:
				setYErrorBarType(YERROR_BAR_TYPE_EDEFAULT);
				return;
			case XYGraphPackage.TRACE_DESCRIPTOR__DATA_SOURCE:
				setDataSource((EObject)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case XYGraphPackage.TRACE_DESCRIPTOR__ANTI_ALIASING:
				return antiAliasing != ANTI_ALIASING_EDEFAULT;
			case XYGraphPackage.TRACE_DESCRIPTOR__AREA_ALPHA:
				return areaAlpha != AREA_ALPHA_EDEFAULT;
			case XYGraphPackage.TRACE_DESCRIPTOR__BASE_LINE:
				return baseLine != BASE_LINE_EDEFAULT;
			case XYGraphPackage.TRACE_DESCRIPTOR__DRAW_YERROR_IN_AREA:
				return drawYErrorInArea != DRAW_YERROR_IN_AREA_EDEFAULT;
			case XYGraphPackage.TRACE_DESCRIPTOR__ERROR_BAR_CAP_WIDTH:
				return errorBarCapWidth != ERROR_BAR_CAP_WIDTH_EDEFAULT;
			case XYGraphPackage.TRACE_DESCRIPTOR__ERROR_BAR_COLOR:
				return errorBarColor != null;
			case XYGraphPackage.TRACE_DESCRIPTOR__ERROR_BAR_ENABLED:
				return errorBarEnabled != ERROR_BAR_ENABLED_EDEFAULT;
			case XYGraphPackage.TRACE_DESCRIPTOR__LINE_WIDTH:
				return lineWidth != LINE_WIDTH_EDEFAULT;
			case XYGraphPackage.TRACE_DESCRIPTOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case XYGraphPackage.TRACE_DESCRIPTOR__POINT_SIZE:
				return pointSize != POINT_SIZE_EDEFAULT;
			case XYGraphPackage.TRACE_DESCRIPTOR__POINT_STYLE:
				return pointStyle != POINT_STYLE_EDEFAULT;
			case XYGraphPackage.TRACE_DESCRIPTOR__TRACE_COLOR:
				return traceColor != null;
			case XYGraphPackage.TRACE_DESCRIPTOR__TRACE_TYPE:
				return traceType != TRACE_TYPE_EDEFAULT;
			case XYGraphPackage.TRACE_DESCRIPTOR__XAXIS:
				return xAxis != null;
			case XYGraphPackage.TRACE_DESCRIPTOR__XERROR_BAR_TYPE:
				return xErrorBarType != XERROR_BAR_TYPE_EDEFAULT;
			case XYGraphPackage.TRACE_DESCRIPTOR__YAXIS:
				return yAxis != null;
			case XYGraphPackage.TRACE_DESCRIPTOR__YERROR_BAR_TYPE:
				return yErrorBarType != YERROR_BAR_TYPE_EDEFAULT;
			case XYGraphPackage.TRACE_DESCRIPTOR__DATA_SOURCE:
				return dataSource != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (antiAliasing: ");
		result.append(antiAliasing);
		result.append(", areaAlpha: ");
		result.append(areaAlpha);
		result.append(", baseLine: ");
		result.append(baseLine);
		result.append(", drawYErrorInArea: ");
		result.append(drawYErrorInArea);
		result.append(", errorBarCapWidth: ");
		result.append(errorBarCapWidth);
		result.append(", errorBarEnabled: ");
		result.append(errorBarEnabled);
		result.append(", lineWidth: ");
		result.append(lineWidth);
		result.append(", name: ");
		result.append(name);
		result.append(", pointSize: ");
		result.append(pointSize);
		result.append(", pointStyle: ");
		result.append(pointStyle);
		result.append(", traceType: ");
		result.append(traceType);
		result.append(", xErrorBarType: ");
		result.append(xErrorBarType);
		result.append(", yErrorBarType: ");
		result.append(yErrorBarType);
		result.append(')');
		return result.toString();
	}

} //TraceDescriptorImpl
