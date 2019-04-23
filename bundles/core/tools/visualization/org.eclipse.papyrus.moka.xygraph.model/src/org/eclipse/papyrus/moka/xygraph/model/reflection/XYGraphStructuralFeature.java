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

public enum XYGraphStructuralFeature {
	Title(XYGraphPackage.eINSTANCE.getXYGraphDescriptor_Title()),
	ShowLegend(XYGraphPackage.eINSTANCE.getXYGraphDescriptor_ShowLegend()),
	ShowTitle(XYGraphPackage.eINSTANCE.getXYGraphDescriptor_ShowTitle()),
	TitleColor(XYGraphPackage.eINSTANCE.getXYGraphDescriptor_TitleColor()),
	Transparent(XYGraphPackage.eINSTANCE.getXYGraphDescriptor_Transparent()),
	ZoomType(XYGraphPackage.eINSTANCE.getXYGraphDescriptor_ZoomType()),
	
	//Axis and Trace descriptors are not editable
	//AxisDescriptors( XYGraphPackage.eINSTANCE.getXYGraphDescriptor_AxisDescriptors()),
	//TraceDescriptors (XYGraphPackage.eINSTANCE.getXYGraphDescriptor_TraceDescriptors()),
	
	ShowPlotAreaBorder(XYGraphPackage.eINSTANCE.getXYGraphDescriptor_ShowPlotAreaBorder()),
	PlotAreaBackgroundColor(XYGraphPackage.eINSTANCE.getXYGraphDescriptor_PlotAreaBackgroundColor()),
	TitleFont(XYGraphPackage.eINSTANCE.getXYGraphDescriptor_TitleFont()),
	
	//Context and Data source are not editable
	//Context( XYGraphPackage.eINSTANCE.getXYGraphDescriptor_Context()),
	//DataSource( XYGraphPackage.eINSTANCE.getXYGraphDescriptor_DataSource()),
	
	;
	
	private EStructuralFeature feature;
	
	private XYGraphStructuralFeature(EStructuralFeature feature){
		this.feature = feature;
	}
	
	public EStructuralFeature getEStructuralFeature(){
		return feature;
	}
}
