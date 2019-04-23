/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  David LOPEZ BETANCUR (CEA LIST)
 *  Sebastien REVOL (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.xygraph.model.reflection;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage;

public enum TraceStructuralFeature {
	AreaAlpha(XYGraphPackage.eINSTANCE.getTraceDescriptor_AreaAlpha()),
	BaseLine(XYGraphPackage.eINSTANCE.getTraceDescriptor_BaseLine()),
	ErrorBarCapWidth(XYGraphPackage.eINSTANCE.getTraceDescriptor_ErrorBarCapWidth()),
	ErrorBarColor(XYGraphPackage.eINSTANCE.getTraceDescriptor_ErrorBarColor()),
	LineWidth(XYGraphPackage.eINSTANCE.getTraceDescriptor_LineWidth()),
	PointSize(XYGraphPackage.eINSTANCE.getTraceDescriptor_PointSize()),
	PointStyle(XYGraphPackage.eINSTANCE.getTraceDescriptor_PointStyle()),
	TraceColor(XYGraphPackage.eINSTANCE.getTraceDescriptor_TraceColor()),
	TraceType(XYGraphPackage.eINSTANCE.getTraceDescriptor_TraceType()),
	XErrorBarType(XYGraphPackage.eINSTANCE.getTraceDescriptor_XErrorBarType()),
	YErrorBarType(XYGraphPackage.eINSTANCE.getTraceDescriptor_YErrorBarType()),
	AntiAliasing(XYGraphPackage.eINSTANCE.getTraceDescriptor_AntiAliasing()),
	DrawYErrorInArea(XYGraphPackage.eINSTANCE.getTraceDescriptor_DrawYErrorInArea()),
	ErrorBarEnabled(XYGraphPackage.eINSTANCE.getTraceDescriptor_ErrorBarEnabled()),
	Name(XYGraphPackage.eINSTANCE.getTraceDescriptor_Name()),
	XAxis(XYGraphPackage.eINSTANCE.getTraceDescriptor_XAxis()),
	YAxis(XYGraphPackage.eINSTANCE.getTraceDescriptor_YAxis()),
	//Visible(XYGraphPackage.eINSTANCE.getTraceDescriptor_Visible());
	;
	private EStructuralFeature feature;
	
	private TraceStructuralFeature( EStructuralFeature feature){
		this.feature = feature;
	}
	
	public EStructuralFeature getEStructuralFeature(){
		return feature;
	}
}
