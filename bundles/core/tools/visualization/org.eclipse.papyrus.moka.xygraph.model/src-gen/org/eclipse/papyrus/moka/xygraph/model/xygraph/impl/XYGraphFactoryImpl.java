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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.moka.xygraph.model.xygraph.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XYGraphFactoryImpl extends EFactoryImpl implements XYGraphFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static XYGraphFactory init() {
		try {
			XYGraphFactory theXYGraphFactory = (XYGraphFactory)EPackage.Registry.INSTANCE.getEFactory(XYGraphPackage.eNS_URI);
			if (theXYGraphFactory != null) {
				return theXYGraphFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new XYGraphFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XYGraphFactoryImpl() {
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
			case XYGraphPackage.XY_GRAPH_DESCRIPTOR: return createXYGraphDescriptor();
			case XYGraphPackage.AXIS_DESCRIPTOR: return createAxisDescriptor();
			case XYGraphPackage.TRACE_DESCRIPTOR: return createTraceDescriptor();
			case XYGraphPackage.FONT_DESCRIPTOR: return createFontDescriptor();
			case XYGraphPackage.COLOR_DESCRIPTOR: return createColorDescriptor();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case XYGraphPackage.ZOOM_TYPE:
				return createZoomTypeFromString(eDataType, initialValue);
			case XYGraphPackage.LINEAR_SCALE_ORIENTATION:
				return createLinearScale_OrientationFromString(eDataType, initialValue);
			case XYGraphPackage.TRACE_BASE_LINE:
				return createTrace_BaseLineFromString(eDataType, initialValue);
			case XYGraphPackage.TRACE_POINT_STYLE:
				return createTrace_PointStyleFromString(eDataType, initialValue);
			case XYGraphPackage.TRACE_TRACE_TYPE:
				return createTrace_TraceTypeFromString(eDataType, initialValue);
			case XYGraphPackage.TRACE_ERROR_BAR_TYPE:
				return createTrace_ErrorBarTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case XYGraphPackage.ZOOM_TYPE:
				return convertZoomTypeToString(eDataType, instanceValue);
			case XYGraphPackage.LINEAR_SCALE_ORIENTATION:
				return convertLinearScale_OrientationToString(eDataType, instanceValue);
			case XYGraphPackage.TRACE_BASE_LINE:
				return convertTrace_BaseLineToString(eDataType, instanceValue);
			case XYGraphPackage.TRACE_POINT_STYLE:
				return convertTrace_PointStyleToString(eDataType, instanceValue);
			case XYGraphPackage.TRACE_TRACE_TYPE:
				return convertTrace_TraceTypeToString(eDataType, instanceValue);
			case XYGraphPackage.TRACE_ERROR_BAR_TYPE:
				return convertTrace_ErrorBarTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XYGraphDescriptor createXYGraphDescriptor() {
		XYGraphDescriptorImpl xyGraphDescriptor = new XYGraphDescriptorImpl();
		return xyGraphDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AxisDescriptor createAxisDescriptor() {
		AxisDescriptorImpl axisDescriptor = new AxisDescriptorImpl();
		return axisDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceDescriptor createTraceDescriptor() {
		TraceDescriptorImpl traceDescriptor = new TraceDescriptorImpl();
		return traceDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FontDescriptor createFontDescriptor() {
		FontDescriptorImpl fontDescriptor = new FontDescriptorImpl();
		return fontDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorDescriptor createColorDescriptor() {
		ColorDescriptorImpl colorDescriptor = new ColorDescriptorImpl();
		return colorDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ZoomType createZoomTypeFromString(EDataType eDataType, String initialValue) {
		ZoomType result = ZoomType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertZoomTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinearScale_Orientation createLinearScale_OrientationFromString(EDataType eDataType, String initialValue) {
		LinearScale_Orientation result = LinearScale_Orientation.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLinearScale_OrientationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trace_BaseLine createTrace_BaseLineFromString(EDataType eDataType, String initialValue) {
		Trace_BaseLine result = Trace_BaseLine.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTrace_BaseLineToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trace_PointStyle createTrace_PointStyleFromString(EDataType eDataType, String initialValue) {
		Trace_PointStyle result = Trace_PointStyle.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTrace_PointStyleToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trace_TraceType createTrace_TraceTypeFromString(EDataType eDataType, String initialValue) {
		Trace_TraceType result = Trace_TraceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTrace_TraceTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trace_ErrorBarType createTrace_ErrorBarTypeFromString(EDataType eDataType, String initialValue) {
		Trace_ErrorBarType result = Trace_ErrorBarType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTrace_ErrorBarTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XYGraphPackage getXYGraphPackage() {
		return (XYGraphPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static XYGraphPackage getPackage() {
		return XYGraphPackage.eINSTANCE;
	}

} //XYGraphFactoryImpl
