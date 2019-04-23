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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getTitle <em>Title</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#isShowLegend <em>Show Legend</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#isShowTitle <em>Show Title</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getTitleColor <em>Title Color</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#isTransparent <em>Transparent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getZoomType <em>Zoom Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getAxisDescriptors <em>Axis Descriptors</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getTraceDescriptors <em>Trace Descriptors</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#isShowPlotAreaBorder <em>Show Plot Area Border</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getPlotAreaBackgroundColor <em>Plot Area Background Color</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getTitleFont <em>Title Font</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getDataSource <em>Data Source</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getVisibleTraces <em>Visible Traces</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getXYGraphDescriptor()
 * @model
 * @generated
 */
public interface XYGraphDescriptor extends EObject {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getXYGraphDescriptor_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Show Legend</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Show Legend</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Show Legend</em>' attribute.
	 * @see #setShowLegend(boolean)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getXYGraphDescriptor_ShowLegend()
	 * @model default="true"
	 * @generated
	 */
	boolean isShowLegend();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#isShowLegend <em>Show Legend</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Show Legend</em>' attribute.
	 * @see #isShowLegend()
	 * @generated
	 */
	void setShowLegend(boolean value);

	/**
	 * Returns the value of the '<em><b>Show Title</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Show Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Show Title</em>' attribute.
	 * @see #setShowTitle(boolean)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getXYGraphDescriptor_ShowTitle()
	 * @model default="true"
	 * @generated
	 */
	boolean isShowTitle();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#isShowTitle <em>Show Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Show Title</em>' attribute.
	 * @see #isShowTitle()
	 * @generated
	 */
	void setShowTitle(boolean value);

	/**
	 * Returns the value of the '<em><b>Title Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title Color</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title Color</em>' containment reference.
	 * @see #setTitleColor(ColorDescriptor)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getXYGraphDescriptor_TitleColor()
	 * @model containment="true"
	 * @generated
	 */
	ColorDescriptor getTitleColor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getTitleColor <em>Title Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title Color</em>' containment reference.
	 * @see #getTitleColor()
	 * @generated
	 */
	void setTitleColor(ColorDescriptor value);

	/**
	 * Returns the value of the '<em><b>Transparent</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transparent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transparent</em>' attribute.
	 * @see #setTransparent(boolean)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getXYGraphDescriptor_Transparent()
	 * @model default="false"
	 * @generated
	 */
	boolean isTransparent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#isTransparent <em>Transparent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transparent</em>' attribute.
	 * @see #isTransparent()
	 * @generated
	 */
	void setTransparent(boolean value);

	/**
	 * Returns the value of the '<em><b>Zoom Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.moka.xygraph.model.xygraph.ZoomType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Zoom Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Zoom Type</em>' attribute.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.ZoomType
	 * @see #setZoomType(ZoomType)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getXYGraphDescriptor_ZoomType()
	 * @model
	 * @generated
	 */
	ZoomType getZoomType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getZoomType <em>Zoom Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Zoom Type</em>' attribute.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.ZoomType
	 * @see #getZoomType()
	 * @generated
	 */
	void setZoomType(ZoomType value);

	/**
	 * Returns the value of the '<em><b>Axis Descriptors</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Axis Descriptors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Axis Descriptors</em>' containment reference list.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getXYGraphDescriptor_AxisDescriptors()
	 * @model containment="true"
	 * @generated
	 */
	EList<AxisDescriptor> getAxisDescriptors();

	/**
	 * Returns the value of the '<em><b>Trace Descriptors</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace Descriptors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace Descriptors</em>' containment reference list.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getXYGraphDescriptor_TraceDescriptors()
	 * @model containment="true"
	 * @generated
	 */
	EList<TraceDescriptor> getTraceDescriptors();

	/**
	 * Returns the value of the '<em><b>Show Plot Area Border</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Show Plot Area Border</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Show Plot Area Border</em>' attribute.
	 * @see #setShowPlotAreaBorder(boolean)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getXYGraphDescriptor_ShowPlotAreaBorder()
	 * @model default="false"
	 * @generated
	 */
	boolean isShowPlotAreaBorder();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#isShowPlotAreaBorder <em>Show Plot Area Border</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Show Plot Area Border</em>' attribute.
	 * @see #isShowPlotAreaBorder()
	 * @generated
	 */
	void setShowPlotAreaBorder(boolean value);

	/**
	 * Returns the value of the '<em><b>Plot Area Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plot Area Background Color</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plot Area Background Color</em>' containment reference.
	 * @see #setPlotAreaBackgroundColor(ColorDescriptor)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getXYGraphDescriptor_PlotAreaBackgroundColor()
	 * @model containment="true"
	 * @generated
	 */
	ColorDescriptor getPlotAreaBackgroundColor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getPlotAreaBackgroundColor <em>Plot Area Background Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plot Area Background Color</em>' containment reference.
	 * @see #getPlotAreaBackgroundColor()
	 * @generated
	 */
	void setPlotAreaBackgroundColor(ColorDescriptor value);

	/**
	 * Returns the value of the '<em><b>Title Font</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title Font</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title Font</em>' containment reference.
	 * @see #setTitleFont(FontDescriptor)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getXYGraphDescriptor_TitleFont()
	 * @model containment="true"
	 * @generated
	 */
	FontDescriptor getTitleFont();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getTitleFont <em>Title Font</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title Font</em>' containment reference.
	 * @see #getTitleFont()
	 * @generated
	 */
	void setTitleFont(FontDescriptor value);

	/**
	 * Returns the value of the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' reference.
	 * @see #setContext(EObject)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getXYGraphDescriptor_Context()
	 * @model required="true"
	 * @generated
	 */
	EObject getContext();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getContext <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(EObject value);

	/**
	 * Returns the value of the '<em><b>Data Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Source</em>' reference.
	 * @see #setDataSource(EObject)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getXYGraphDescriptor_DataSource()
	 * @model
	 * @generated
	 */
	EObject getDataSource();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor#getDataSource <em>Data Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Source</em>' reference.
	 * @see #getDataSource()
	 * @generated
	 */
	void setDataSource(EObject value);

	/**
	 * Returns the value of the '<em><b>Visible Traces</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visible Traces</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visible Traces</em>' reference list.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getXYGraphDescriptor_VisibleTraces()
	 * @model
	 * @generated
	 */
	EList<TraceDescriptor> getVisibleTraces();

} // XYGraphDescriptor
