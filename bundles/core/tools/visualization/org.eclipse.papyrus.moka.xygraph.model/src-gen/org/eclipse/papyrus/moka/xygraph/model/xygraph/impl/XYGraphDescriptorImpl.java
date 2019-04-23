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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.ColorDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.FontDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.ZoomType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphDescriptorImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphDescriptorImpl#isShowLegend <em>Show Legend</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphDescriptorImpl#isShowTitle <em>Show Title</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphDescriptorImpl#getTitleColor <em>Title Color</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphDescriptorImpl#isTransparent <em>Transparent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphDescriptorImpl#getZoomType <em>Zoom Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphDescriptorImpl#getAxisDescriptors <em>Axis Descriptors</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphDescriptorImpl#getTraceDescriptors <em>Trace Descriptors</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphDescriptorImpl#isShowPlotAreaBorder <em>Show Plot Area Border</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphDescriptorImpl#getPlotAreaBackgroundColor <em>Plot Area Background Color</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphDescriptorImpl#getTitleFont <em>Title Font</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphDescriptorImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphDescriptorImpl#getDataSource <em>Data Source</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.impl.XYGraphDescriptorImpl#getVisibleTraces <em>Visible Traces</em>}</li>
 * </ul>
 *
 * @generated
 */
public class XYGraphDescriptorImpl extends MinimalEObjectImpl.Container implements XYGraphDescriptor {
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
	 * The default value of the '{@link #isShowLegend() <em>Show Legend</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isShowLegend()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SHOW_LEGEND_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isShowLegend() <em>Show Legend</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isShowLegend()
	 * @generated
	 * @ordered
	 */
	protected boolean showLegend = SHOW_LEGEND_EDEFAULT;

	/**
	 * The default value of the '{@link #isShowTitle() <em>Show Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isShowTitle()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SHOW_TITLE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isShowTitle() <em>Show Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isShowTitle()
	 * @generated
	 * @ordered
	 */
	protected boolean showTitle = SHOW_TITLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTitleColor() <em>Title Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitleColor()
	 * @generated
	 * @ordered
	 */
	protected ColorDescriptor titleColor;

	/**
	 * The default value of the '{@link #isTransparent() <em>Transparent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransparent()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRANSPARENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTransparent() <em>Transparent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransparent()
	 * @generated
	 * @ordered
	 */
	protected boolean transparent = TRANSPARENT_EDEFAULT;

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
	 * The cached value of the '{@link #getAxisDescriptors() <em>Axis Descriptors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAxisDescriptors()
	 * @generated
	 * @ordered
	 */
	protected EList<AxisDescriptor> axisDescriptors;

	/**
	 * The cached value of the '{@link #getTraceDescriptors() <em>Trace Descriptors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceDescriptors()
	 * @generated
	 * @ordered
	 */
	protected EList<TraceDescriptor> traceDescriptors;

	/**
	 * The default value of the '{@link #isShowPlotAreaBorder() <em>Show Plot Area Border</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isShowPlotAreaBorder()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SHOW_PLOT_AREA_BORDER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isShowPlotAreaBorder() <em>Show Plot Area Border</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isShowPlotAreaBorder()
	 * @generated
	 * @ordered
	 */
	protected boolean showPlotAreaBorder = SHOW_PLOT_AREA_BORDER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPlotAreaBackgroundColor() <em>Plot Area Background Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlotAreaBackgroundColor()
	 * @generated
	 * @ordered
	 */
	protected ColorDescriptor plotAreaBackgroundColor;

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
	 * The cached value of the '{@link #getContext() <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected EObject context;

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
	 * The cached value of the '{@link #getVisibleTraces() <em>Visible Traces</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibleTraces()
	 * @generated
	 * @ordered
	 */
	protected EList<TraceDescriptor> visibleTraces;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XYGraphDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XYGraphPackage.Literals.XY_GRAPH_DESCRIPTOR;
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
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.XY_GRAPH_DESCRIPTOR__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isShowLegend() {
		return showLegend;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShowLegend(boolean newShowLegend) {
		boolean oldShowLegend = showLegend;
		showLegend = newShowLegend;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.XY_GRAPH_DESCRIPTOR__SHOW_LEGEND, oldShowLegend, showLegend));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isShowTitle() {
		return showTitle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShowTitle(boolean newShowTitle) {
		boolean oldShowTitle = showTitle;
		showTitle = newShowTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.XY_GRAPH_DESCRIPTOR__SHOW_TITLE, oldShowTitle, showTitle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorDescriptor getTitleColor() {
		return titleColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTitleColor(ColorDescriptor newTitleColor, NotificationChain msgs) {
		ColorDescriptor oldTitleColor = titleColor;
		titleColor = newTitleColor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XYGraphPackage.XY_GRAPH_DESCRIPTOR__TITLE_COLOR, oldTitleColor, newTitleColor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitleColor(ColorDescriptor newTitleColor) {
		if (newTitleColor != titleColor) {
			NotificationChain msgs = null;
			if (titleColor != null)
				msgs = ((InternalEObject)titleColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XYGraphPackage.XY_GRAPH_DESCRIPTOR__TITLE_COLOR, null, msgs);
			if (newTitleColor != null)
				msgs = ((InternalEObject)newTitleColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XYGraphPackage.XY_GRAPH_DESCRIPTOR__TITLE_COLOR, null, msgs);
			msgs = basicSetTitleColor(newTitleColor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.XY_GRAPH_DESCRIPTOR__TITLE_COLOR, newTitleColor, newTitleColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTransparent() {
		return transparent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransparent(boolean newTransparent) {
		boolean oldTransparent = transparent;
		transparent = newTransparent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.XY_GRAPH_DESCRIPTOR__TRANSPARENT, oldTransparent, transparent));
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
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.XY_GRAPH_DESCRIPTOR__ZOOM_TYPE, oldZoomType, zoomType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AxisDescriptor> getAxisDescriptors() {
		if (axisDescriptors == null) {
			axisDescriptors = new EObjectContainmentEList<AxisDescriptor>(AxisDescriptor.class, this, XYGraphPackage.XY_GRAPH_DESCRIPTOR__AXIS_DESCRIPTORS);
		}
		return axisDescriptors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TraceDescriptor> getTraceDescriptors() {
		if (traceDescriptors == null) {
			traceDescriptors = new EObjectContainmentEList<TraceDescriptor>(TraceDescriptor.class, this, XYGraphPackage.XY_GRAPH_DESCRIPTOR__TRACE_DESCRIPTORS);
		}
		return traceDescriptors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isShowPlotAreaBorder() {
		return showPlotAreaBorder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShowPlotAreaBorder(boolean newShowPlotAreaBorder) {
		boolean oldShowPlotAreaBorder = showPlotAreaBorder;
		showPlotAreaBorder = newShowPlotAreaBorder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.XY_GRAPH_DESCRIPTOR__SHOW_PLOT_AREA_BORDER, oldShowPlotAreaBorder, showPlotAreaBorder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorDescriptor getPlotAreaBackgroundColor() {
		return plotAreaBackgroundColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPlotAreaBackgroundColor(ColorDescriptor newPlotAreaBackgroundColor, NotificationChain msgs) {
		ColorDescriptor oldPlotAreaBackgroundColor = plotAreaBackgroundColor;
		plotAreaBackgroundColor = newPlotAreaBackgroundColor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XYGraphPackage.XY_GRAPH_DESCRIPTOR__PLOT_AREA_BACKGROUND_COLOR, oldPlotAreaBackgroundColor, newPlotAreaBackgroundColor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlotAreaBackgroundColor(ColorDescriptor newPlotAreaBackgroundColor) {
		if (newPlotAreaBackgroundColor != plotAreaBackgroundColor) {
			NotificationChain msgs = null;
			if (plotAreaBackgroundColor != null)
				msgs = ((InternalEObject)plotAreaBackgroundColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XYGraphPackage.XY_GRAPH_DESCRIPTOR__PLOT_AREA_BACKGROUND_COLOR, null, msgs);
			if (newPlotAreaBackgroundColor != null)
				msgs = ((InternalEObject)newPlotAreaBackgroundColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XYGraphPackage.XY_GRAPH_DESCRIPTOR__PLOT_AREA_BACKGROUND_COLOR, null, msgs);
			msgs = basicSetPlotAreaBackgroundColor(newPlotAreaBackgroundColor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.XY_GRAPH_DESCRIPTOR__PLOT_AREA_BACKGROUND_COLOR, newPlotAreaBackgroundColor, newPlotAreaBackgroundColor));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XYGraphPackage.XY_GRAPH_DESCRIPTOR__TITLE_FONT, oldTitleFont, newTitleFont);
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
				msgs = ((InternalEObject)titleFont).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XYGraphPackage.XY_GRAPH_DESCRIPTOR__TITLE_FONT, null, msgs);
			if (newTitleFont != null)
				msgs = ((InternalEObject)newTitleFont).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XYGraphPackage.XY_GRAPH_DESCRIPTOR__TITLE_FONT, null, msgs);
			msgs = basicSetTitleFont(newTitleFont, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.XY_GRAPH_DESCRIPTOR__TITLE_FONT, newTitleFont, newTitleFont));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getContext() {
		if (context != null && context.eIsProxy()) {
			InternalEObject oldContext = (InternalEObject)context;
			context = eResolveProxy(oldContext);
			if (context != oldContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XYGraphPackage.XY_GRAPH_DESCRIPTOR__CONTEXT, oldContext, context));
			}
		}
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(EObject newContext) {
		EObject oldContext = context;
		context = newContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.XY_GRAPH_DESCRIPTOR__CONTEXT, oldContext, context));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XYGraphPackage.XY_GRAPH_DESCRIPTOR__DATA_SOURCE, oldDataSource, dataSource));
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
			eNotify(new ENotificationImpl(this, Notification.SET, XYGraphPackage.XY_GRAPH_DESCRIPTOR__DATA_SOURCE, oldDataSource, dataSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TraceDescriptor> getVisibleTraces() {
		if (visibleTraces == null) {
			visibleTraces = new EObjectResolvingEList<TraceDescriptor>(TraceDescriptor.class, this, XYGraphPackage.XY_GRAPH_DESCRIPTOR__VISIBLE_TRACES);
		}
		return visibleTraces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__TITLE_COLOR:
				return basicSetTitleColor(null, msgs);
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__AXIS_DESCRIPTORS:
				return ((InternalEList<?>)getAxisDescriptors()).basicRemove(otherEnd, msgs);
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__TRACE_DESCRIPTORS:
				return ((InternalEList<?>)getTraceDescriptors()).basicRemove(otherEnd, msgs);
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__PLOT_AREA_BACKGROUND_COLOR:
				return basicSetPlotAreaBackgroundColor(null, msgs);
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__TITLE_FONT:
				return basicSetTitleFont(null, msgs);
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
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__TITLE:
				return getTitle();
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__SHOW_LEGEND:
				return isShowLegend();
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__SHOW_TITLE:
				return isShowTitle();
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__TITLE_COLOR:
				return getTitleColor();
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__TRANSPARENT:
				return isTransparent();
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__ZOOM_TYPE:
				return getZoomType();
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__AXIS_DESCRIPTORS:
				return getAxisDescriptors();
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__TRACE_DESCRIPTORS:
				return getTraceDescriptors();
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__SHOW_PLOT_AREA_BORDER:
				return isShowPlotAreaBorder();
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__PLOT_AREA_BACKGROUND_COLOR:
				return getPlotAreaBackgroundColor();
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__TITLE_FONT:
				return getTitleFont();
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__CONTEXT:
				if (resolve) return getContext();
				return basicGetContext();
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__DATA_SOURCE:
				if (resolve) return getDataSource();
				return basicGetDataSource();
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__VISIBLE_TRACES:
				return getVisibleTraces();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__TITLE:
				setTitle((String)newValue);
				return;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__SHOW_LEGEND:
				setShowLegend((Boolean)newValue);
				return;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__SHOW_TITLE:
				setShowTitle((Boolean)newValue);
				return;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__TITLE_COLOR:
				setTitleColor((ColorDescriptor)newValue);
				return;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__TRANSPARENT:
				setTransparent((Boolean)newValue);
				return;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__ZOOM_TYPE:
				setZoomType((ZoomType)newValue);
				return;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__AXIS_DESCRIPTORS:
				getAxisDescriptors().clear();
				getAxisDescriptors().addAll((Collection<? extends AxisDescriptor>)newValue);
				return;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__TRACE_DESCRIPTORS:
				getTraceDescriptors().clear();
				getTraceDescriptors().addAll((Collection<? extends TraceDescriptor>)newValue);
				return;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__SHOW_PLOT_AREA_BORDER:
				setShowPlotAreaBorder((Boolean)newValue);
				return;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__PLOT_AREA_BACKGROUND_COLOR:
				setPlotAreaBackgroundColor((ColorDescriptor)newValue);
				return;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__TITLE_FONT:
				setTitleFont((FontDescriptor)newValue);
				return;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__CONTEXT:
				setContext((EObject)newValue);
				return;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__DATA_SOURCE:
				setDataSource((EObject)newValue);
				return;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__VISIBLE_TRACES:
				getVisibleTraces().clear();
				getVisibleTraces().addAll((Collection<? extends TraceDescriptor>)newValue);
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
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__SHOW_LEGEND:
				setShowLegend(SHOW_LEGEND_EDEFAULT);
				return;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__SHOW_TITLE:
				setShowTitle(SHOW_TITLE_EDEFAULT);
				return;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__TITLE_COLOR:
				setTitleColor((ColorDescriptor)null);
				return;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__TRANSPARENT:
				setTransparent(TRANSPARENT_EDEFAULT);
				return;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__ZOOM_TYPE:
				setZoomType(ZOOM_TYPE_EDEFAULT);
				return;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__AXIS_DESCRIPTORS:
				getAxisDescriptors().clear();
				return;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__TRACE_DESCRIPTORS:
				getTraceDescriptors().clear();
				return;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__SHOW_PLOT_AREA_BORDER:
				setShowPlotAreaBorder(SHOW_PLOT_AREA_BORDER_EDEFAULT);
				return;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__PLOT_AREA_BACKGROUND_COLOR:
				setPlotAreaBackgroundColor((ColorDescriptor)null);
				return;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__TITLE_FONT:
				setTitleFont((FontDescriptor)null);
				return;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__CONTEXT:
				setContext((EObject)null);
				return;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__DATA_SOURCE:
				setDataSource((EObject)null);
				return;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__VISIBLE_TRACES:
				getVisibleTraces().clear();
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
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__SHOW_LEGEND:
				return showLegend != SHOW_LEGEND_EDEFAULT;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__SHOW_TITLE:
				return showTitle != SHOW_TITLE_EDEFAULT;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__TITLE_COLOR:
				return titleColor != null;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__TRANSPARENT:
				return transparent != TRANSPARENT_EDEFAULT;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__ZOOM_TYPE:
				return zoomType != ZOOM_TYPE_EDEFAULT;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__AXIS_DESCRIPTORS:
				return axisDescriptors != null && !axisDescriptors.isEmpty();
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__TRACE_DESCRIPTORS:
				return traceDescriptors != null && !traceDescriptors.isEmpty();
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__SHOW_PLOT_AREA_BORDER:
				return showPlotAreaBorder != SHOW_PLOT_AREA_BORDER_EDEFAULT;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__PLOT_AREA_BACKGROUND_COLOR:
				return plotAreaBackgroundColor != null;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__TITLE_FONT:
				return titleFont != null;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__CONTEXT:
				return context != null;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__DATA_SOURCE:
				return dataSource != null;
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR__VISIBLE_TRACES:
				return visibleTraces != null && !visibleTraces.isEmpty();
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
		result.append(" (title: ");
		result.append(title);
		result.append(", showLegend: ");
		result.append(showLegend);
		result.append(", showTitle: ");
		result.append(showTitle);
		result.append(", transparent: ");
		result.append(transparent);
		result.append(", zoomType: ");
		result.append(zoomType);
		result.append(", showPlotAreaBorder: ");
		result.append(showPlotAreaBorder);
		result.append(')');
		return result.toString();
	}

} //XYGraphDescriptorImpl
