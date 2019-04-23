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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Axis Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getOrientation <em>Orientation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isAutoScale <em>Auto Scale</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getAutoScaleThreshold <em>Auto Scale Threshold</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isDashGridLine <em>Dash Grid Line</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getForegroundColor <em>Foreground Color</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isLogScale <em>Log Scale</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getMajorGridColor <em>Major Grid Color</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getMinorGridColor <em>Minor Grid Color</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isMinorTicksVisible <em>Minor Ticks Visible</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isPrimarySide <em>Primary Side</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getRangeLower <em>Range Lower</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getRangeUpper <em>Range Upper</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isShowMajorGrid <em>Show Major Grid</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isShowMinorGrid <em>Show Minor Grid</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getTitle <em>Title</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getZoomType <em>Zoom Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getTitleFont <em>Title Font</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getFont <em>Font</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isAutoFormat <em>Auto Format</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isDateEnabled <em>Date Enabled</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getFormatPattern <em>Format Pattern</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getAxisDescriptor()
 * @model
 * @generated
 */
public interface AxisDescriptor extends EObject {
	/**
	 * Returns the value of the '<em><b>Orientation</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.moka.xygraph.model.xygraph.LinearScale_Orientation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Orientation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Orientation</em>' attribute.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.LinearScale_Orientation
	 * @see #setOrientation(LinearScale_Orientation)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getAxisDescriptor_Orientation()
	 * @model
	 * @generated
	 */
	LinearScale_Orientation getOrientation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getOrientation <em>Orientation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Orientation</em>' attribute.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.LinearScale_Orientation
	 * @see #getOrientation()
	 * @generated
	 */
	void setOrientation(LinearScale_Orientation value);

	/**
	 * Returns the value of the '<em><b>Auto Scale</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auto Scale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auto Scale</em>' attribute.
	 * @see #setAutoScale(boolean)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getAxisDescriptor_AutoScale()
	 * @model default="true"
	 * @generated
	 */
	boolean isAutoScale();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isAutoScale <em>Auto Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auto Scale</em>' attribute.
	 * @see #isAutoScale()
	 * @generated
	 */
	void setAutoScale(boolean value);

	/**
	 * Returns the value of the '<em><b>Auto Scale Threshold</b></em>' attribute.
	 * The default value is <code>"0.01"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auto Scale Threshold</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auto Scale Threshold</em>' attribute.
	 * @see #setAutoScaleThreshold(double)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getAxisDescriptor_AutoScaleThreshold()
	 * @model default="0.01"
	 * @generated
	 */
	double getAutoScaleThreshold();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getAutoScaleThreshold <em>Auto Scale Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auto Scale Threshold</em>' attribute.
	 * @see #getAutoScaleThreshold()
	 * @generated
	 */
	void setAutoScaleThreshold(double value);

	/**
	 * Returns the value of the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Background Color</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Background Color</em>' containment reference.
	 * @see #setBackgroundColor(ColorDescriptor)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getAxisDescriptor_BackgroundColor()
	 * @model containment="true"
	 * @generated
	 */
	ColorDescriptor getBackgroundColor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getBackgroundColor <em>Background Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Background Color</em>' containment reference.
	 * @see #getBackgroundColor()
	 * @generated
	 */
	void setBackgroundColor(ColorDescriptor value);

	/**
	 * Returns the value of the '<em><b>Dash Grid Line</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dash Grid Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dash Grid Line</em>' attribute.
	 * @see #setDashGridLine(boolean)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getAxisDescriptor_DashGridLine()
	 * @model default="true"
	 * @generated
	 */
	boolean isDashGridLine();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isDashGridLine <em>Dash Grid Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dash Grid Line</em>' attribute.
	 * @see #isDashGridLine()
	 * @generated
	 */
	void setDashGridLine(boolean value);

	/**
	 * Returns the value of the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foreground Color</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foreground Color</em>' containment reference.
	 * @see #setForegroundColor(ColorDescriptor)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getAxisDescriptor_ForegroundColor()
	 * @model containment="true"
	 * @generated
	 */
	ColorDescriptor getForegroundColor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getForegroundColor <em>Foreground Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Foreground Color</em>' containment reference.
	 * @see #getForegroundColor()
	 * @generated
	 */
	void setForegroundColor(ColorDescriptor value);

	/**
	 * Returns the value of the '<em><b>Log Scale</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log Scale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log Scale</em>' attribute.
	 * @see #setLogScale(boolean)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getAxisDescriptor_LogScale()
	 * @model default="false"
	 * @generated
	 */
	boolean isLogScale();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isLogScale <em>Log Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log Scale</em>' attribute.
	 * @see #isLogScale()
	 * @generated
	 */
	void setLogScale(boolean value);

	/**
	 * Returns the value of the '<em><b>Major Grid Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Major Grid Color</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Major Grid Color</em>' containment reference.
	 * @see #setMajorGridColor(ColorDescriptor)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getAxisDescriptor_MajorGridColor()
	 * @model containment="true"
	 * @generated
	 */
	ColorDescriptor getMajorGridColor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getMajorGridColor <em>Major Grid Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Major Grid Color</em>' containment reference.
	 * @see #getMajorGridColor()
	 * @generated
	 */
	void setMajorGridColor(ColorDescriptor value);

	/**
	 * Returns the value of the '<em><b>Minor Grid Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minor Grid Color</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minor Grid Color</em>' containment reference.
	 * @see #setMinorGridColor(ColorDescriptor)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getAxisDescriptor_MinorGridColor()
	 * @model containment="true"
	 * @generated
	 */
	ColorDescriptor getMinorGridColor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getMinorGridColor <em>Minor Grid Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minor Grid Color</em>' containment reference.
	 * @see #getMinorGridColor()
	 * @generated
	 */
	void setMinorGridColor(ColorDescriptor value);

	/**
	 * Returns the value of the '<em><b>Minor Ticks Visible</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minor Ticks Visible</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minor Ticks Visible</em>' attribute.
	 * @see #setMinorTicksVisible(boolean)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getAxisDescriptor_MinorTicksVisible()
	 * @model default="true"
	 * @generated
	 */
	boolean isMinorTicksVisible();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isMinorTicksVisible <em>Minor Ticks Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minor Ticks Visible</em>' attribute.
	 * @see #isMinorTicksVisible()
	 * @generated
	 */
	void setMinorTicksVisible(boolean value);

	/**
	 * Returns the value of the '<em><b>Primary Side</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Side</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Side</em>' attribute.
	 * @see #setPrimarySide(boolean)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getAxisDescriptor_PrimarySide()
	 * @model default="true"
	 * @generated
	 */
	boolean isPrimarySide();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isPrimarySide <em>Primary Side</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Side</em>' attribute.
	 * @see #isPrimarySide()
	 * @generated
	 */
	void setPrimarySide(boolean value);

	/**
	 * Returns the value of the '<em><b>Range Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Range Lower</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Range Lower</em>' attribute.
	 * @see #setRangeLower(double)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getAxisDescriptor_RangeLower()
	 * @model
	 * @generated
	 */
	double getRangeLower();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getRangeLower <em>Range Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range Lower</em>' attribute.
	 * @see #getRangeLower()
	 * @generated
	 */
	void setRangeLower(double value);

	/**
	 * Returns the value of the '<em><b>Range Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Range Upper</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Range Upper</em>' attribute.
	 * @see #setRangeUpper(double)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getAxisDescriptor_RangeUpper()
	 * @model
	 * @generated
	 */
	double getRangeUpper();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getRangeUpper <em>Range Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range Upper</em>' attribute.
	 * @see #getRangeUpper()
	 * @generated
	 */
	void setRangeUpper(double value);

	/**
	 * Returns the value of the '<em><b>Show Major Grid</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Show Major Grid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Show Major Grid</em>' attribute.
	 * @see #setShowMajorGrid(boolean)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getAxisDescriptor_ShowMajorGrid()
	 * @model default="false"
	 * @generated
	 */
	boolean isShowMajorGrid();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isShowMajorGrid <em>Show Major Grid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Show Major Grid</em>' attribute.
	 * @see #isShowMajorGrid()
	 * @generated
	 */
	void setShowMajorGrid(boolean value);

	/**
	 * Returns the value of the '<em><b>Show Minor Grid</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Show Minor Grid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Show Minor Grid</em>' attribute.
	 * @see #setShowMinorGrid(boolean)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getAxisDescriptor_ShowMinorGrid()
	 * @model default="false"
	 * @generated
	 */
	boolean isShowMinorGrid();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isShowMinorGrid <em>Show Minor Grid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Show Minor Grid</em>' attribute.
	 * @see #isShowMinorGrid()
	 * @generated
	 */
	void setShowMinorGrid(boolean value);

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
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getAxisDescriptor_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Zoom Type</b></em>' attribute.
	 * The default value is <code>"NONE"</code>.
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
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getAxisDescriptor_ZoomType()
	 * @model default="NONE"
	 * @generated
	 */
	ZoomType getZoomType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getZoomType <em>Zoom Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Zoom Type</em>' attribute.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.ZoomType
	 * @see #getZoomType()
	 * @generated
	 */
	void setZoomType(ZoomType value);

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
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getAxisDescriptor_TitleFont()
	 * @model containment="true"
	 * @generated
	 */
	FontDescriptor getTitleFont();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getTitleFont <em>Title Font</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title Font</em>' containment reference.
	 * @see #getTitleFont()
	 * @generated
	 */
	void setTitleFont(FontDescriptor value);

	/**
	 * Returns the value of the '<em><b>Font</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font</em>' containment reference.
	 * @see #setFont(FontDescriptor)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getAxisDescriptor_Font()
	 * @model containment="true"
	 * @generated
	 */
	FontDescriptor getFont();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getFont <em>Font</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font</em>' containment reference.
	 * @see #getFont()
	 * @generated
	 */
	void setFont(FontDescriptor value);

	/**
	 * Returns the value of the '<em><b>Auto Format</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auto Format</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auto Format</em>' attribute.
	 * @see #setAutoFormat(boolean)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getAxisDescriptor_AutoFormat()
	 * @model default="true"
	 * @generated
	 */
	boolean isAutoFormat();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isAutoFormat <em>Auto Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auto Format</em>' attribute.
	 * @see #isAutoFormat()
	 * @generated
	 */
	void setAutoFormat(boolean value);

	/**
	 * Returns the value of the '<em><b>Date Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date Enabled</em>' attribute.
	 * @see #setDateEnabled(boolean)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getAxisDescriptor_DateEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isDateEnabled();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#isDateEnabled <em>Date Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date Enabled</em>' attribute.
	 * @see #isDateEnabled()
	 * @generated
	 */
	void setDateEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Format Pattern</b></em>' attribute.
	 * The default value is <code>"############.##"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Format Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Format Pattern</em>' attribute.
	 * @see #setFormatPattern(String)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getAxisDescriptor_FormatPattern()
	 * @model default="############.##"
	 * @generated
	 */
	String getFormatPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor#getFormatPattern <em>Format Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Format Pattern</em>' attribute.
	 * @see #getFormatPattern()
	 * @generated
	 */
	void setFormatPattern(String value);

} // AxisDescriptor
