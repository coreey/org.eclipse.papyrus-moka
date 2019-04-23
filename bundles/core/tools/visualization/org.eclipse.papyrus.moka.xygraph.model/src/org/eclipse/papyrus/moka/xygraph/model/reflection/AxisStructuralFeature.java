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

public enum AxisStructuralFeature {
	
	Title(XYGraphPackage.eINSTANCE.getAxisDescriptor_Title()),
	Orientation(XYGraphPackage.eINSTANCE.getAxisDescriptor_Orientation()),
	AutoScale(XYGraphPackage.eINSTANCE.getAxisDescriptor_AutoScale()),
	AutoScaleThreshold(XYGraphPackage.eINSTANCE.getAxisDescriptor_AutoScaleThreshold()), 
	ForegroundColor(XYGraphPackage.eINSTANCE.getAxisDescriptor_ForegroundColor()),
	BackgroundColor(XYGraphPackage.eINSTANCE.getAxisDescriptor_BackgroundColor()),
	MajorGridColor(XYGraphPackage.eINSTANCE.getAxisDescriptor_MajorGridColor() ),
	MinorGridColor(XYGraphPackage.eINSTANCE.getAxisDescriptor_MinorGridColor() ),
	RangeUpper(XYGraphPackage.eINSTANCE.getAxisDescriptor_RangeUpper()),
	RangeLower(XYGraphPackage.eINSTANCE.getAxisDescriptor_RangeLower()),

	ZoomType(XYGraphPackage.eINSTANCE.getAxisDescriptor_ZoomType()),
	
	DashGridLine(XYGraphPackage.eINSTANCE.getAxisDescriptor_DashGridLine()),
	LogScale(XYGraphPackage.eINSTANCE.getAxisDescriptor_LogScale()),
	MinorTicksVisible(XYGraphPackage.eINSTANCE.getAxisDescriptor_MinorTicksVisible()),
	ShowMajorGrid(XYGraphPackage.eINSTANCE.getAxisDescriptor_ShowMajorGrid()),
	ShowMinorGrid(XYGraphPackage.eINSTANCE.getAxisDescriptor_ShowMinorGrid()),
	PrimarySide(XYGraphPackage.eINSTANCE.getAxisDescriptor_PrimarySide()),

	AutoFormat(XYGraphPackage.eINSTANCE.getAxisDescriptor_AutoFormat()),
	DateEnabled(XYGraphPackage.eINSTANCE.getAxisDescriptor_DateEnabled()),
	FormatPattern(XYGraphPackage.eINSTANCE.getAxisDescriptor_FormatPattern()),
	
	Font(XYGraphPackage.eINSTANCE.getAxisDescriptor_Font()),
	TitleFont(XYGraphPackage.eINSTANCE.getAxisDescriptor_TitleFont());
	
	private EStructuralFeature feature;
	
	private AxisStructuralFeature(EStructuralFeature feature){
		this.feature = feature;
	}
	
	public EStructuralFeature getEStructuralFeature(){
		return feature;
	}
}
