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
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.ColorDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.FontDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.LinearScale_Orientation;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.ZoomType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Axis Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.AxisDescriptorImpl#getOrientation <em>Orientation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.AxisDescriptorImpl#isAutoScale <em>Auto Scale</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.AxisDescriptorImpl#getAutoScaleThreshold <em>Auto Scale Threshold</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.AxisDescriptorImpl#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.AxisDescriptorImpl#isDashGridLine <em>Dash Grid Line</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.AxisDescriptorImpl#getForegroundColor <em>Foreground Color</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.AxisDescriptorImpl#isLogScale <em>Log Scale</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.AxisDescriptorImpl#getMajorGridColor <em>Major Grid Color</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.AxisDescriptorImpl#getMinorGridColor <em>Minor Grid Color</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.AxisDescriptorImpl#isMinorTicksVisible <em>Minor Ticks Visible</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.AxisDescriptorImpl#isPrimarySide <em>Primary Side</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.AxisDescriptorImpl#getRangeLower <em>Range Lower</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.AxisDescriptorImpl#getRangeUpper <em>Range Upper</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.AxisDescriptorImpl#isShowMajorGrid <em>Show Major Grid</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.AxisDescriptorImpl#isShowMinorGrid <em>Show Minor Grid</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.AxisDescriptorImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.AxisDescriptorImpl#getZoomType <em>Zoom Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.AxisDescriptorImpl#getTitleFont <em>Title Font</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.AxisDescriptorImpl#getFont <em>Font</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.AxisDescriptorImpl#isAutoFormat <em>Auto Format</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.AxisDescriptorImpl#isDateEnabled <em>Date Enabled</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.AxisDescriptorImpl#getFormatPattern <em>Format Pattern</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AxisDescriptorImpl extends MinimalEObjectImpl.Container implements AxisDescriptor {
	/**
	 * The default value of the '{@link #getOrientation() <em>Orientation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrientation()
	 * @generated
	 * @ordered
	 */
	protected static final LinearScale_Orientation ORIENTATION_EDEFAULT = LinearScale_Orientation.HORIZONTAL;

	/**
	 * The cached value of the '{@link #getOrientation() <em>Orientation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrientation()
	 * @generated
	 * @ordered
	 */
	protected LinearScale_Orientation orientation = ORIENTATION_EDEFAULT;

	/**
	 * The default value of the '{@link #isAutoScale() <em>Auto Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAutoScale()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AUTO_SCALE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isAutoScale() <em>Auto Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAutoScale()
	 * @generated
	 * @ordered
	 */
	protected boolean autoScale = AUTO_SCALE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAutoScaleThreshold() <em>Auto Scale Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutoScaleThreshold()
	 * @generated
	 * @ordered
	 */
	protected static final double AUTO_SCALE_THRESHOLD_EDEFAULT = 0.01;

	/**
	 * The cached value of the '{@link #getAutoScaleThreshold() <em>Auto Scale Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutoScaleThreshold()
	 * @generated
	 * @ordered
	 */
	protected double autoScaleThreshold = AUTO_SCALE_THRESHOLD_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBackgroundColor() <em>Background Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackgroundColor()
	 * @generated
	 * @ordered
	 */
	protected ColorDescriptor backgroundColor;

	/**
	 * The default value of the '{@link #isDashGridLine() <em>Dash Grid Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDashGridLine()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DASH_GRID_LINE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isDashGridLine() <em>Dash Grid Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDashGridLine()
	 * @generated
	 * @ordered
	 */
	protected boolean dashGridLine = DASH_GRID_LINE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getForegroundColor() <em>Foreground Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForegroundColor()
	 * @generated
	 * @ordered
	 */
	protected ColorDescriptor foregroundColor;

	/**
	 * The default value of the '{@link #isLogScale() <em>Log Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLogScale()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOG_SCALE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLogScale() <em>Log Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLogScale()
	 * @generated
	 * @ordered
	 */
	protected boolean logScale = LOG_SCALE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMajorGridColor() <em>Major Grid Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMajorGridColor()
	 * @generated
	 * @ordered
	 */
	protected ColorDescriptor majorGridColor;

	/**
	 * The cached value of the '{@link #getMinorGridColor() <em>Minor Grid Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinorGridColor()
	 * @generated
	 * @ordered
	 */
	protected ColorDescriptor minorGridColor;

	/**
	 * The default value of the '{@link #isMinorTicksVisible() <em>Minor Ticks Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMinorTicksVisible()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MINOR_TICKS_VISIBLE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isMinorTicksVisible() <em>Minor Ticks Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMinorTicksVisible()
	 * @generated
	 * @ordered
	 */
	protected boolean minorTicksVisible = MINOR_TICKS_VISIBLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isPrimarySide() <em>Primary Side</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrimarySide()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PRIMARY_SIDE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isPrimarySide() <em>Primary Side</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrimarySide()
	 * @generated
	 * @ordered
	 */
	protected boolean primarySide = PRIMARY_SIDE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRangeLower() <em>Range Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRangeLower()
	 * @generated
	 * @ordered
	 */
	protected static final double RANGE_LOWER_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRangeLower() <em>Range Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRangeLower()
	 * @generated
	 * @ordered
	 */
	protected double rangeLower = RANGE_LOWER_EDEFAULT;

	/**
	 * The default value of the '{@link #getRangeUpper() <em>Range Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRangeUpper()
	 * @generated
	 * @ordered
	 */
	protected static final double RANGE_UPPER_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getRangeUpper() <em>Range Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRangeUpper()
	 * @generated
	 * @ordered
	 */
	protected double rangeUpper = RANGE_UPPER_EDEFAULT;

	/**
	 * The default value of the '{@link #isShowMajorGrid() <em>Show Major Grid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isShowMajorGrid()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SHOW_MAJOR_GRID_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isShowMajorGrid() <em>Show Major Grid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isShowMajorGrid()
	 * @generated
	 * @ordered
	 */
	protected boolean showMajorGrid = SHOW_MAJOR_GRID_EDEFAULT;

	/**
	 * The default value of the '{@link #isShowMinorGrid() <em>Show Minor Grid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isShowMinorGrid()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SHOW_MINOR_GRID_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isShowMinorGrid() <em>Show Minor Grid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isShowMinorGrid()
	 * @generated
	 * @ordered
	 */
	protected boolean showMinorGrid = SHOW_MINOR_GRID_EDEFAULT;

	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getZoomType() <em>Zoom Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZoomType()
	 * @generated
	 * @ordered
	 */
	protected static final ZoomType ZOOM_TYPE_EDEFAULT = ZoomType.NONE;

	/**
	 * The cached value of the '{@link #getZoomType() <em>Zoom Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getZoomType()
	 * @generated
	 * @ordered
	 */
	protected ZoomType zoomType = ZOOM_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTitleFont() <em>Title Font</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitleFont()
	 * @generated
	 * @ordered
	 */
	protected FontDescriptor titleFont;

	/**
	 * The cached value of the '{@link #getFont() <em>Font</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFont()
	 * @generated
	 * @ordered
	 */
	protected FontDescriptor font;

	/**
	 * The default value of the '{@link #isAutoFormat() <em>Auto Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAutoFormat()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AUTO_FORMAT_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isAutoFormat() <em>Auto Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAutoFormat()
	 * @generated
	 * @ordered
	 */
	protected boolean autoFormat = AUTO_FORMAT_EDEFAULT;

	/**
	 * The default value of the '{@link #isDateEnabled() <em>Date Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDateEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DATE_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDateEnabled() <em>Date Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDateEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean dateEnabled = DATE_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getFormatPattern() <em>Format Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormatPattern()
	 * @generated
	 * @ordered
	 */
	protected static final String FORMAT_PATTERN_EDEFAULT = "############.##";

	/**
	 * The cached value of the '{@link #getFormatPattern() <em>Format Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormatPattern()
	 * @generated
	 * @ordered
	 */
	protected String formatPattern = FORMAT_PATTERN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AxisDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XYGraphPackage.Literals.AXIS_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinearScale_Orientation getOrientation() {
		return orientation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrientation(LinearScale_Orientation newOrientation) {
		LinearScale_Orientation oldOrientation = orientation;
		orientation = newOrientation == null ? ORIENTATION_EDEFAULT : newOrientation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.AXIS_DESCRIPTOR__ORIENTATION, oldOrientation, orientation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAutoScale() {
		return autoScale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutoScale(boolean newAutoScale) {
		boolean oldAutoScale = autoScale;
		autoScale = newAutoScale;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.AXIS_DESCRIPTOR__AUTO_SCALE, oldAutoScale, autoScale));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAutoScaleThreshold() {
		return autoScaleThreshold;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutoScaleThreshold(double newAutoScaleThreshold) {
		double oldAutoScaleThreshold = autoScaleThreshold;
		autoScaleThreshold = newAutoScaleThreshold;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.AXIS_DESCRIPTOR__AUTO_SCALE_THRESHOLD, oldAutoScaleThreshold, autoScaleThreshold));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorDescriptor getBackgroundColor() {
		return backgroundColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBackgroundColor(ColorDescriptor newBackgroundColor, NotificationChain msgs) {
		ColorDescriptor oldBackgroundColor = backgroundColor;
		backgroundColor = newBackgroundColor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XYGraphPackage.AXIS_DESCRIPTOR__BACKGROUND_COLOR, oldBackgroundColor, newBackgroundColor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackgroundColor(ColorDescriptor newBackgroundColor) {
		if (newBackgroundColor != backgroundColor) {
			NotificationChain msgs = null;
			if (backgroundColor != null)
				msgs = ((InternalEObject)backgroundColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XYGraphPackage.AXIS_DESCRIPTOR__BACKGROUND_COLOR, null, msgs);
			if (newBackgroundColor != null)
				msgs = ((InternalEObject)newBackgroundColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XYGraphPackage.AXIS_DESCRIPTOR__BACKGROUND_COLOR, null, msgs);
			msgs = basicSetBackgroundColor(newBackgroundColor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.AXIS_DESCRIPTOR__BACKGROUND_COLOR, newBackgroundColor, newBackgroundColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDashGridLine() {
		return dashGridLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDashGridLine(boolean newDashGridLine) {
		boolean oldDashGridLine = dashGridLine;
		dashGridLine = newDashGridLine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.AXIS_DESCRIPTOR__DASH_GRID_LINE, oldDashGridLine, dashGridLine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorDescriptor getForegroundColor() {
		return foregroundColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetForegroundColor(ColorDescriptor newForegroundColor, NotificationChain msgs) {
		ColorDescriptor oldForegroundColor = foregroundColor;
		foregroundColor = newForegroundColor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XYGraphPackage.AXIS_DESCRIPTOR__FOREGROUND_COLOR, oldForegroundColor, newForegroundColor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForegroundColor(ColorDescriptor newForegroundColor) {
		if (newForegroundColor != foregroundColor) {
			NotificationChain msgs = null;
			if (foregroundColor != null)
				msgs = ((InternalEObject)foregroundColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XYGraphPackage.AXIS_DESCRIPTOR__FOREGROUND_COLOR, null, msgs);
			if (newForegroundColor != null)
				msgs = ((InternalEObject)newForegroundColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XYGraphPackage.AXIS_DESCRIPTOR__FOREGROUND_COLOR, null, msgs);
			msgs = basicSetForegroundColor(newForegroundColor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.AXIS_DESCRIPTOR__FOREGROUND_COLOR, newForegroundColor, newForegroundColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLogScale() {
		return logScale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogScale(boolean newLogScale) {
		boolean oldLogScale = logScale;
		logScale = newLogScale;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.AXIS_DESCRIPTOR__LOG_SCALE, oldLogScale, logScale));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorDescriptor getMajorGridColor() {
		return majorGridColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMajorGridColor(ColorDescriptor newMajorGridColor, NotificationChain msgs) {
		ColorDescriptor oldMajorGridColor = majorGridColor;
		majorGridColor = newMajorGridColor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XYGraphPackage.AXIS_DESCRIPTOR__MAJOR_GRID_COLOR, oldMajorGridColor, newMajorGridColor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMajorGridColor(ColorDescriptor newMajorGridColor) {
		if (newMajorGridColor != majorGridColor) {
			NotificationChain msgs = null;
			if (majorGridColor != null)
				msgs = ((InternalEObject)majorGridColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XYGraphPackage.AXIS_DESCRIPTOR__MAJOR_GRID_COLOR, null, msgs);
			if (newMajorGridColor != null)
				msgs = ((InternalEObject)newMajorGridColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XYGraphPackage.AXIS_DESCRIPTOR__MAJOR_GRID_COLOR, null, msgs);
			msgs = basicSetMajorGridColor(newMajorGridColor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.AXIS_DESCRIPTOR__MAJOR_GRID_COLOR, newMajorGridColor, newMajorGridColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorDescriptor getMinorGridColor() {
		return minorGridColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMinorGridColor(ColorDescriptor newMinorGridColor, NotificationChain msgs) {
		ColorDescriptor oldMinorGridColor = minorGridColor;
		minorGridColor = newMinorGridColor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XYGraphPackage.AXIS_DESCRIPTOR__MINOR_GRID_COLOR, oldMinorGridColor, newMinorGridColor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinorGridColor(ColorDescriptor newMinorGridColor) {
		if (newMinorGridColor != minorGridColor) {
			NotificationChain msgs = null;
			if (minorGridColor != null)
				msgs = ((InternalEObject)minorGridColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XYGraphPackage.AXIS_DESCRIPTOR__MINOR_GRID_COLOR, null, msgs);
			if (newMinorGridColor != null)
				msgs = ((InternalEObject)newMinorGridColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XYGraphPackage.AXIS_DESCRIPTOR__MINOR_GRID_COLOR, null, msgs);
			msgs = basicSetMinorGridColor(newMinorGridColor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.AXIS_DESCRIPTOR__MINOR_GRID_COLOR, newMinorGridColor, newMinorGridColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMinorTicksVisible() {
		return minorTicksVisible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinorTicksVisible(boolean newMinorTicksVisible) {
		boolean oldMinorTicksVisible = minorTicksVisible;
		minorTicksVisible = newMinorTicksVisible;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.AXIS_DESCRIPTOR__MINOR_TICKS_VISIBLE, oldMinorTicksVisible, minorTicksVisible));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPrimarySide() {
		return primarySide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimarySide(boolean newPrimarySide) {
		boolean oldPrimarySide = primarySide;
		primarySide = newPrimarySide;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.AXIS_DESCRIPTOR__PRIMARY_SIDE, oldPrimarySide, primarySide));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRangeLower() {
		return rangeLower;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRangeLower(double newRangeLower) {
		double oldRangeLower = rangeLower;
		rangeLower = newRangeLower;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.AXIS_DESCRIPTOR__RANGE_LOWER, oldRangeLower, rangeLower));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRangeUpper() {
		return rangeUpper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRangeUpper(double newRangeUpper) {
		double oldRangeUpper = rangeUpper;
		rangeUpper = newRangeUpper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.AXIS_DESCRIPTOR__RANGE_UPPER, oldRangeUpper, rangeUpper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isShowMajorGrid() {
		return showMajorGrid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShowMajorGrid(boolean newShowMajorGrid) {
		boolean oldShowMajorGrid = showMajorGrid;
		showMajorGrid = newShowMajorGrid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.AXIS_DESCRIPTOR__SHOW_MAJOR_GRID, oldShowMajorGrid, showMajorGrid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isShowMinorGrid() {
		return showMinorGrid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShowMinorGrid(boolean newShowMinorGrid) {
		boolean oldShowMinorGrid = showMinorGrid;
		showMinorGrid = newShowMinorGrid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.AXIS_DESCRIPTOR__SHOW_MINOR_GRID, oldShowMinorGrid, showMinorGrid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.AXIS_DESCRIPTOR__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ZoomType getZoomType() {
		return zoomType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setZoomType(ZoomType newZoomType) {
		ZoomType oldZoomType = zoomType;
		zoomType = newZoomType == null ? ZOOM_TYPE_EDEFAULT : newZoomType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.AXIS_DESCRIPTOR__ZOOM_TYPE, oldZoomType, zoomType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FontDescriptor getTitleFont() {
		return titleFont;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTitleFont(FontDescriptor newTitleFont, NotificationChain msgs) {
		FontDescriptor oldTitleFont = titleFont;
		titleFont = newTitleFont;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XYGraphPackage.AXIS_DESCRIPTOR__TITLE_FONT, oldTitleFont, newTitleFont);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitleFont(FontDescriptor newTitleFont) {
		if (newTitleFont != titleFont) {
			NotificationChain msgs = null;
			if (titleFont != null)
				msgs = ((InternalEObject)titleFont).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XYGraphPackage.AXIS_DESCRIPTOR__TITLE_FONT, null, msgs);
			if (newTitleFont != null)
				msgs = ((InternalEObject)newTitleFont).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XYGraphPackage.AXIS_DESCRIPTOR__TITLE_FONT, null, msgs);
			msgs = basicSetTitleFont(newTitleFont, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.AXIS_DESCRIPTOR__TITLE_FONT, newTitleFont, newTitleFont));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FontDescriptor getFont() {
		return font;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFont(FontDescriptor newFont, NotificationChain msgs) {
		FontDescriptor oldFont = font;
		font = newFont;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XYGraphPackage.AXIS_DESCRIPTOR__FONT, oldFont, newFont);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFont(FontDescriptor newFont) {
		if (newFont != font) {
			NotificationChain msgs = null;
			if (font != null)
				msgs = ((InternalEObject)font).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XYGraphPackage.AXIS_DESCRIPTOR__FONT, null, msgs);
			if (newFont != null)
				msgs = ((InternalEObject)newFont).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XYGraphPackage.AXIS_DESCRIPTOR__FONT, null, msgs);
			msgs = basicSetFont(newFont, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.AXIS_DESCRIPTOR__FONT, newFont, newFont));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAutoFormat() {
		return autoFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutoFormat(boolean newAutoFormat) {
		boolean oldAutoFormat = autoFormat;
		autoFormat = newAutoFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.AXIS_DESCRIPTOR__AUTO_FORMAT, oldAutoFormat, autoFormat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDateEnabled() {
		return dateEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDateEnabled(boolean newDateEnabled) {
		boolean oldDateEnabled = dateEnabled;
		dateEnabled = newDateEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.AXIS_DESCRIPTOR__DATE_ENABLED, oldDateEnabled, dateEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFormatPattern() {
		return formatPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormatPattern(String newFormatPattern) {
		String oldFormatPattern = formatPattern;
		formatPattern = newFormatPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.AXIS_DESCRIPTOR__FORMAT_PATTERN, oldFormatPattern, formatPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XYGraphPackage.AXIS_DESCRIPTOR__BACKGROUND_COLOR:
				return basicSetBackgroundColor(null, msgs);
			case XYGraphPackage.AXIS_DESCRIPTOR__FOREGROUND_COLOR:
				return basicSetForegroundColor(null, msgs);
			case XYGraphPackage.AXIS_DESCRIPTOR__MAJOR_GRID_COLOR:
				return basicSetMajorGridColor(null, msgs);
			case XYGraphPackage.AXIS_DESCRIPTOR__MINOR_GRID_COLOR:
				return basicSetMinorGridColor(null, msgs);
			case XYGraphPackage.AXIS_DESCRIPTOR__TITLE_FONT:
				return basicSetTitleFont(null, msgs);
			case XYGraphPackage.AXIS_DESCRIPTOR__FONT:
				return basicSetFont(null, msgs);
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
			case XYGraphPackage.AXIS_DESCRIPTOR__ORIENTATION:
				return getOrientation();
			case XYGraphPackage.AXIS_DESCRIPTOR__AUTO_SCALE:
				return isAutoScale();
			case XYGraphPackage.AXIS_DESCRIPTOR__AUTO_SCALE_THRESHOLD:
				return getAutoScaleThreshold();
			case XYGraphPackage.AXIS_DESCRIPTOR__BACKGROUND_COLOR:
				return getBackgroundColor();
			case XYGraphPackage.AXIS_DESCRIPTOR__DASH_GRID_LINE:
				return isDashGridLine();
			case XYGraphPackage.AXIS_DESCRIPTOR__FOREGROUND_COLOR:
				return getForegroundColor();
			case XYGraphPackage.AXIS_DESCRIPTOR__LOG_SCALE:
				return isLogScale();
			case XYGraphPackage.AXIS_DESCRIPTOR__MAJOR_GRID_COLOR:
				return getMajorGridColor();
			case XYGraphPackage.AXIS_DESCRIPTOR__MINOR_GRID_COLOR:
				return getMinorGridColor();
			case XYGraphPackage.AXIS_DESCRIPTOR__MINOR_TICKS_VISIBLE:
				return isMinorTicksVisible();
			case XYGraphPackage.AXIS_DESCRIPTOR__PRIMARY_SIDE:
				return isPrimarySide();
			case XYGraphPackage.AXIS_DESCRIPTOR__RANGE_LOWER:
				return getRangeLower();
			case XYGraphPackage.AXIS_DESCRIPTOR__RANGE_UPPER:
				return getRangeUpper();
			case XYGraphPackage.AXIS_DESCRIPTOR__SHOW_MAJOR_GRID:
				return isShowMajorGrid();
			case XYGraphPackage.AXIS_DESCRIPTOR__SHOW_MINOR_GRID:
				return isShowMinorGrid();
			case XYGraphPackage.AXIS_DESCRIPTOR__TITLE:
				return getTitle();
			case XYGraphPackage.AXIS_DESCRIPTOR__ZOOM_TYPE:
				return getZoomType();
			case XYGraphPackage.AXIS_DESCRIPTOR__TITLE_FONT:
				return getTitleFont();
			case XYGraphPackage.AXIS_DESCRIPTOR__FONT:
				return getFont();
			case XYGraphPackage.AXIS_DESCRIPTOR__AUTO_FORMAT:
				return isAutoFormat();
			case XYGraphPackage.AXIS_DESCRIPTOR__DATE_ENABLED:
				return isDateEnabled();
			case XYGraphPackage.AXIS_DESCRIPTOR__FORMAT_PATTERN:
				return getFormatPattern();
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
			case XYGraphPackage.AXIS_DESCRIPTOR__ORIENTATION:
				setOrientation((LinearScale_Orientation)newValue);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__AUTO_SCALE:
				setAutoScale((Boolean)newValue);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__AUTO_SCALE_THRESHOLD:
				setAutoScaleThreshold((Double)newValue);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__BACKGROUND_COLOR:
				setBackgroundColor((ColorDescriptor)newValue);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__DASH_GRID_LINE:
				setDashGridLine((Boolean)newValue);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__FOREGROUND_COLOR:
				setForegroundColor((ColorDescriptor)newValue);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__LOG_SCALE:
				setLogScale((Boolean)newValue);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__MAJOR_GRID_COLOR:
				setMajorGridColor((ColorDescriptor)newValue);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__MINOR_GRID_COLOR:
				setMinorGridColor((ColorDescriptor)newValue);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__MINOR_TICKS_VISIBLE:
				setMinorTicksVisible((Boolean)newValue);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__PRIMARY_SIDE:
				setPrimarySide((Boolean)newValue);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__RANGE_LOWER:
				setRangeLower((Double)newValue);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__RANGE_UPPER:
				setRangeUpper((Double)newValue);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__SHOW_MAJOR_GRID:
				setShowMajorGrid((Boolean)newValue);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__SHOW_MINOR_GRID:
				setShowMinorGrid((Boolean)newValue);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__TITLE:
				setTitle((String)newValue);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__ZOOM_TYPE:
				setZoomType((ZoomType)newValue);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__TITLE_FONT:
				setTitleFont((FontDescriptor)newValue);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__FONT:
				setFont((FontDescriptor)newValue);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__AUTO_FORMAT:
				setAutoFormat((Boolean)newValue);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__DATE_ENABLED:
				setDateEnabled((Boolean)newValue);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__FORMAT_PATTERN:
				setFormatPattern((String)newValue);
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
			case XYGraphPackage.AXIS_DESCRIPTOR__ORIENTATION:
				setOrientation(ORIENTATION_EDEFAULT);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__AUTO_SCALE:
				setAutoScale(AUTO_SCALE_EDEFAULT);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__AUTO_SCALE_THRESHOLD:
				setAutoScaleThreshold(AUTO_SCALE_THRESHOLD_EDEFAULT);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__BACKGROUND_COLOR:
				setBackgroundColor((ColorDescriptor)null);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__DASH_GRID_LINE:
				setDashGridLine(DASH_GRID_LINE_EDEFAULT);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__FOREGROUND_COLOR:
				setForegroundColor((ColorDescriptor)null);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__LOG_SCALE:
				setLogScale(LOG_SCALE_EDEFAULT);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__MAJOR_GRID_COLOR:
				setMajorGridColor((ColorDescriptor)null);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__MINOR_GRID_COLOR:
				setMinorGridColor((ColorDescriptor)null);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__MINOR_TICKS_VISIBLE:
				setMinorTicksVisible(MINOR_TICKS_VISIBLE_EDEFAULT);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__PRIMARY_SIDE:
				setPrimarySide(PRIMARY_SIDE_EDEFAULT);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__RANGE_LOWER:
				setRangeLower(RANGE_LOWER_EDEFAULT);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__RANGE_UPPER:
				setRangeUpper(RANGE_UPPER_EDEFAULT);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__SHOW_MAJOR_GRID:
				setShowMajorGrid(SHOW_MAJOR_GRID_EDEFAULT);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__SHOW_MINOR_GRID:
				setShowMinorGrid(SHOW_MINOR_GRID_EDEFAULT);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__ZOOM_TYPE:
				setZoomType(ZOOM_TYPE_EDEFAULT);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__TITLE_FONT:
				setTitleFont((FontDescriptor)null);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__FONT:
				setFont((FontDescriptor)null);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__AUTO_FORMAT:
				setAutoFormat(AUTO_FORMAT_EDEFAULT);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__DATE_ENABLED:
				setDateEnabled(DATE_ENABLED_EDEFAULT);
				return;
			case XYGraphPackage.AXIS_DESCRIPTOR__FORMAT_PATTERN:
				setFormatPattern(FORMAT_PATTERN_EDEFAULT);
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
			case XYGraphPackage.AXIS_DESCRIPTOR__ORIENTATION:
				return orientation != ORIENTATION_EDEFAULT;
			case XYGraphPackage.AXIS_DESCRIPTOR__AUTO_SCALE:
				return autoScale != AUTO_SCALE_EDEFAULT;
			case XYGraphPackage.AXIS_DESCRIPTOR__AUTO_SCALE_THRESHOLD:
				return autoScaleThreshold != AUTO_SCALE_THRESHOLD_EDEFAULT;
			case XYGraphPackage.AXIS_DESCRIPTOR__BACKGROUND_COLOR:
				return backgroundColor != null;
			case XYGraphPackage.AXIS_DESCRIPTOR__DASH_GRID_LINE:
				return dashGridLine != DASH_GRID_LINE_EDEFAULT;
			case XYGraphPackage.AXIS_DESCRIPTOR__FOREGROUND_COLOR:
				return foregroundColor != null;
			case XYGraphPackage.AXIS_DESCRIPTOR__LOG_SCALE:
				return logScale != LOG_SCALE_EDEFAULT;
			case XYGraphPackage.AXIS_DESCRIPTOR__MAJOR_GRID_COLOR:
				return majorGridColor != null;
			case XYGraphPackage.AXIS_DESCRIPTOR__MINOR_GRID_COLOR:
				return minorGridColor != null;
			case XYGraphPackage.AXIS_DESCRIPTOR__MINOR_TICKS_VISIBLE:
				return minorTicksVisible != MINOR_TICKS_VISIBLE_EDEFAULT;
			case XYGraphPackage.AXIS_DESCRIPTOR__PRIMARY_SIDE:
				return primarySide != PRIMARY_SIDE_EDEFAULT;
			case XYGraphPackage.AXIS_DESCRIPTOR__RANGE_LOWER:
				return rangeLower != RANGE_LOWER_EDEFAULT;
			case XYGraphPackage.AXIS_DESCRIPTOR__RANGE_UPPER:
				return rangeUpper != RANGE_UPPER_EDEFAULT;
			case XYGraphPackage.AXIS_DESCRIPTOR__SHOW_MAJOR_GRID:
				return showMajorGrid != SHOW_MAJOR_GRID_EDEFAULT;
			case XYGraphPackage.AXIS_DESCRIPTOR__SHOW_MINOR_GRID:
				return showMinorGrid != SHOW_MINOR_GRID_EDEFAULT;
			case XYGraphPackage.AXIS_DESCRIPTOR__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case XYGraphPackage.AXIS_DESCRIPTOR__ZOOM_TYPE:
				return zoomType != ZOOM_TYPE_EDEFAULT;
			case XYGraphPackage.AXIS_DESCRIPTOR__TITLE_FONT:
				return titleFont != null;
			case XYGraphPackage.AXIS_DESCRIPTOR__FONT:
				return font != null;
			case XYGraphPackage.AXIS_DESCRIPTOR__AUTO_FORMAT:
				return autoFormat != AUTO_FORMAT_EDEFAULT;
			case XYGraphPackage.AXIS_DESCRIPTOR__DATE_ENABLED:
				return dateEnabled != DATE_ENABLED_EDEFAULT;
			case XYGraphPackage.AXIS_DESCRIPTOR__FORMAT_PATTERN:
				return FORMAT_PATTERN_EDEFAULT == null ? formatPattern != null : !FORMAT_PATTERN_EDEFAULT.equals(formatPattern);
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
		result.append(" (orientation: ");
		result.append(orientation);
		result.append(", autoScale: ");
		result.append(autoScale);
		result.append(", autoScaleThreshold: ");
		result.append(autoScaleThreshold);
		result.append(", dashGridLine: ");
		result.append(dashGridLine);
		result.append(", logScale: ");
		result.append(logScale);
		result.append(", minorTicksVisible: ");
		result.append(minorTicksVisible);
		result.append(", primarySide: ");
		result.append(primarySide);
		result.append(", rangeLower: ");
		result.append(rangeLower);
		result.append(", rangeUpper: ");
		result.append(rangeUpper);
		result.append(", showMajorGrid: ");
		result.append(showMajorGrid);
		result.append(", showMinorGrid: ");
		result.append(showMinorGrid);
		result.append(", title: ");
		result.append(title);
		result.append(", zoomType: ");
		result.append(zoomType);
		result.append(", autoFormat: ");
		result.append(autoFormat);
		result.append(", dateEnabled: ");
		result.append(dateEnabled);
		result.append(", formatPattern: ");
		result.append(formatPattern);
		result.append(')');
		return result.toString();
	}

} //AxisDescriptorImpl
