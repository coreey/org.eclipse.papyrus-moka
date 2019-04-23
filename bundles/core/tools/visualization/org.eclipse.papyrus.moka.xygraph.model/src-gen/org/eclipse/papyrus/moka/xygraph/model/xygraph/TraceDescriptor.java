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
 * A representation of the model object '<em><b>Trace Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#isAntiAliasing <em>Anti Aliasing</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getAreaAlpha <em>Area Alpha</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getBaseLine <em>Base Line</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#isDrawYErrorInArea <em>Draw YError In Area</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getErrorBarCapWidth <em>Error Bar Cap Width</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getErrorBarColor <em>Error Bar Color</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#isErrorBarEnabled <em>Error Bar Enabled</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getLineWidth <em>Line Width</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getPointSize <em>Point Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getPointStyle <em>Point Style</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getTraceColor <em>Trace Color</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getTraceType <em>Trace Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getXAxis <em>XAxis</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getXErrorBarType <em>XError Bar Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getYAxis <em>YAxis</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getYErrorBarType <em>YError Bar Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getDataSource <em>Data Source</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getTraceDescriptor()
 * @model
 * @generated
 */
public interface TraceDescriptor extends EObject {
	/**
	 * Returns the value of the '<em><b>Anti Aliasing</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Anti Aliasing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Anti Aliasing</em>' attribute.
	 * @see #setAntiAliasing(boolean)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getTraceDescriptor_AntiAliasing()
	 * @model default="true"
	 * @generated
	 */
	boolean isAntiAliasing();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#isAntiAliasing <em>Anti Aliasing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Anti Aliasing</em>' attribute.
	 * @see #isAntiAliasing()
	 * @generated
	 */
	void setAntiAliasing(boolean value);

	/**
	 * Returns the value of the '<em><b>Area Alpha</b></em>' attribute.
	 * The default value is <code>"100"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Area Alpha</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Area Alpha</em>' attribute.
	 * @see #setAreaAlpha(int)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getTraceDescriptor_AreaAlpha()
	 * @model default="100"
	 * @generated
	 */
	int getAreaAlpha();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getAreaAlpha <em>Area Alpha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Area Alpha</em>' attribute.
	 * @see #getAreaAlpha()
	 * @generated
	 */
	void setAreaAlpha(int value);

	/**
	 * Returns the value of the '<em><b>Base Line</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_BaseLine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Line</em>' attribute.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_BaseLine
	 * @see #setBaseLine(Trace_BaseLine)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getTraceDescriptor_BaseLine()
	 * @model
	 * @generated
	 */
	Trace_BaseLine getBaseLine();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getBaseLine <em>Base Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Line</em>' attribute.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_BaseLine
	 * @see #getBaseLine()
	 * @generated
	 */
	void setBaseLine(Trace_BaseLine value);

	/**
	 * Returns the value of the '<em><b>Draw YError In Area</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Draw YError In Area</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Draw YError In Area</em>' attribute.
	 * @see #setDrawYErrorInArea(boolean)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getTraceDescriptor_DrawYErrorInArea()
	 * @model default="false"
	 * @generated
	 */
	boolean isDrawYErrorInArea();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#isDrawYErrorInArea <em>Draw YError In Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Draw YError In Area</em>' attribute.
	 * @see #isDrawYErrorInArea()
	 * @generated
	 */
	void setDrawYErrorInArea(boolean value);

	/**
	 * Returns the value of the '<em><b>Error Bar Cap Width</b></em>' attribute.
	 * The default value is <code>"4"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Bar Cap Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Bar Cap Width</em>' attribute.
	 * @see #setErrorBarCapWidth(int)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getTraceDescriptor_ErrorBarCapWidth()
	 * @model default="4"
	 * @generated
	 */
	int getErrorBarCapWidth();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getErrorBarCapWidth <em>Error Bar Cap Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Bar Cap Width</em>' attribute.
	 * @see #getErrorBarCapWidth()
	 * @generated
	 */
	void setErrorBarCapWidth(int value);

	/**
	 * Returns the value of the '<em><b>Error Bar Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Bar Color</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Bar Color</em>' containment reference.
	 * @see #setErrorBarColor(ColorDescriptor)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getTraceDescriptor_ErrorBarColor()
	 * @model containment="true"
	 * @generated
	 */
	ColorDescriptor getErrorBarColor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getErrorBarColor <em>Error Bar Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Bar Color</em>' containment reference.
	 * @see #getErrorBarColor()
	 * @generated
	 */
	void setErrorBarColor(ColorDescriptor value);

	/**
	 * Returns the value of the '<em><b>Error Bar Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Bar Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Bar Enabled</em>' attribute.
	 * @see #setErrorBarEnabled(boolean)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getTraceDescriptor_ErrorBarEnabled()
	 * @model default="false"
	 * @generated
	 */
	boolean isErrorBarEnabled();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#isErrorBarEnabled <em>Error Bar Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Bar Enabled</em>' attribute.
	 * @see #isErrorBarEnabled()
	 * @generated
	 */
	void setErrorBarEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Line Width</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line Width</em>' attribute.
	 * @see #setLineWidth(int)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getTraceDescriptor_LineWidth()
	 * @model default="1"
	 * @generated
	 */
	int getLineWidth();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getLineWidth <em>Line Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Width</em>' attribute.
	 * @see #getLineWidth()
	 * @generated
	 */
	void setLineWidth(int value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getTraceDescriptor_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Point Size</b></em>' attribute.
	 * The default value is <code>"4"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Point Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Point Size</em>' attribute.
	 * @see #setPointSize(int)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getTraceDescriptor_PointSize()
	 * @model default="4"
	 * @generated
	 */
	int getPointSize();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getPointSize <em>Point Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Point Size</em>' attribute.
	 * @see #getPointSize()
	 * @generated
	 */
	void setPointSize(int value);

	/**
	 * Returns the value of the '<em><b>Point Style</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_PointStyle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Point Style</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Point Style</em>' attribute.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_PointStyle
	 * @see #setPointStyle(Trace_PointStyle)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getTraceDescriptor_PointStyle()
	 * @model
	 * @generated
	 */
	Trace_PointStyle getPointStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getPointStyle <em>Point Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Point Style</em>' attribute.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_PointStyle
	 * @see #getPointStyle()
	 * @generated
	 */
	void setPointStyle(Trace_PointStyle value);

	/**
	 * Returns the value of the '<em><b>Trace Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace Color</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace Color</em>' containment reference.
	 * @see #setTraceColor(ColorDescriptor)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getTraceDescriptor_TraceColor()
	 * @model containment="true"
	 * @generated
	 */
	ColorDescriptor getTraceColor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getTraceColor <em>Trace Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace Color</em>' containment reference.
	 * @see #getTraceColor()
	 * @generated
	 */
	void setTraceColor(ColorDescriptor value);

	/**
	 * Returns the value of the '<em><b>Trace Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_TraceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace Type</em>' attribute.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_TraceType
	 * @see #setTraceType(Trace_TraceType)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getTraceDescriptor_TraceType()
	 * @model
	 * @generated
	 */
	Trace_TraceType getTraceType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getTraceType <em>Trace Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace Type</em>' attribute.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_TraceType
	 * @see #getTraceType()
	 * @generated
	 */
	void setTraceType(Trace_TraceType value);

	/**
	 * Returns the value of the '<em><b>XAxis</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XAxis</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XAxis</em>' reference.
	 * @see #setXAxis(AxisDescriptor)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getTraceDescriptor_XAxis()
	 * @model
	 * @generated
	 */
	AxisDescriptor getXAxis();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getXAxis <em>XAxis</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XAxis</em>' reference.
	 * @see #getXAxis()
	 * @generated
	 */
	void setXAxis(AxisDescriptor value);

	/**
	 * Returns the value of the '<em><b>XError Bar Type</b></em>' attribute.
	 * The default value is <code>"BOTH"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_ErrorBarType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XError Bar Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XError Bar Type</em>' attribute.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_ErrorBarType
	 * @see #setXErrorBarType(Trace_ErrorBarType)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getTraceDescriptor_XErrorBarType()
	 * @model default="BOTH"
	 * @generated
	 */
	Trace_ErrorBarType getXErrorBarType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getXErrorBarType <em>XError Bar Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XError Bar Type</em>' attribute.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_ErrorBarType
	 * @see #getXErrorBarType()
	 * @generated
	 */
	void setXErrorBarType(Trace_ErrorBarType value);

	/**
	 * Returns the value of the '<em><b>YAxis</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>YAxis</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>YAxis</em>' reference.
	 * @see #setYAxis(AxisDescriptor)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getTraceDescriptor_YAxis()
	 * @model
	 * @generated
	 */
	AxisDescriptor getYAxis();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getYAxis <em>YAxis</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>YAxis</em>' reference.
	 * @see #getYAxis()
	 * @generated
	 */
	void setYAxis(AxisDescriptor value);

	/**
	 * Returns the value of the '<em><b>YError Bar Type</b></em>' attribute.
	 * The default value is <code>"BOTH"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_ErrorBarType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>YError Bar Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>YError Bar Type</em>' attribute.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_ErrorBarType
	 * @see #setYErrorBarType(Trace_ErrorBarType)
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getTraceDescriptor_YErrorBarType()
	 * @model default="BOTH"
	 * @generated
	 */
	Trace_ErrorBarType getYErrorBarType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getYErrorBarType <em>YError Bar Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>YError Bar Type</em>' attribute.
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_ErrorBarType
	 * @see #getYErrorBarType()
	 * @generated
	 */
	void setYErrorBarType(Trace_ErrorBarType value);

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
	 * @see org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage#getTraceDescriptor_DataSource()
	 * @model
	 * @generated
	 */
	EObject getDataSource();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor#getDataSource <em>Data Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Source</em>' reference.
	 * @see #getDataSource()
	 * @generated
	 */
	void setDataSource(EObject value);

} // TraceDescriptor
