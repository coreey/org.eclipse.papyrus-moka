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
package org.eclipse.papyrus.moka.xygraph.mapping.writing;

import org.eclipse.nebula.visualization.xygraph.figures.Trace;
import org.eclipse.papyrus.moka.xygraph.model.reflection.TraceStructuralFeature;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor;
import org.eclipse.papyrus.moka.xygraph.mapping.common.XYGraphWidgetBinder;
import org.eclipse.papyrus.moka.xygraph.mapping.common.XYGraphMappingHelper;

public interface TraceUpdateStrategy {
	
	public void commitUpdate();
	
	public void updateTraceDescriptor(Trace trace, XYGraphWidgetBinder map);
	
	public <T> void  updateTraceFeature( TraceDescriptor tDesc, TraceStructuralFeature field, T newValue);
	
	default void updateAllFeatures(Trace trace, XYGraphWidgetBinder map){
		TraceDescriptor tDesc = map.getDescriptorFor(trace);
		
		updateTraceFeature(tDesc, TraceStructuralFeature.AreaAlpha, trace.getAreaAlpha());
		updateTraceFeature(tDesc, TraceStructuralFeature.BaseLine,XYGraphMappingHelper.descTraceBaseLine(trace.getBaseLine()));
		updateTraceFeature(tDesc, TraceStructuralFeature.ErrorBarCapWidth,tDesc.getErrorBarCapWidth());
		updateTraceFeature(tDesc, TraceStructuralFeature.ErrorBarColor,XYGraphMappingHelper.mapColor(trace.getErrorBarColor()));
		updateTraceFeature(tDesc, TraceStructuralFeature.LineWidth,trace.getLineWidth());
		updateTraceFeature(tDesc, TraceStructuralFeature.PointSize,trace.getPointSize());
		updateTraceFeature(tDesc, TraceStructuralFeature.PointStyle,XYGraphMappingHelper.descPointStyle(trace.getPointStyle()));
		updateTraceFeature(tDesc, TraceStructuralFeature.TraceColor,XYGraphMappingHelper.mapColor(trace.getTraceColor()));
		updateTraceFeature(tDesc, TraceStructuralFeature.TraceType,XYGraphMappingHelper.descTraceType(trace.getTraceType()));
		updateTraceFeature(tDesc, TraceStructuralFeature.XErrorBarType,XYGraphMappingHelper.descErrorBarType(trace.getXErrorBarType()));
		updateTraceFeature(tDesc, TraceStructuralFeature.YErrorBarType,XYGraphMappingHelper.descErrorBarType(trace.getYErrorBarType()));
		updateTraceFeature(tDesc, TraceStructuralFeature.AntiAliasing,trace.isAntiAliasing());
		updateTraceFeature(tDesc, TraceStructuralFeature.DrawYErrorInArea,trace.isDrawYErrorInArea());
		updateTraceFeature(tDesc, TraceStructuralFeature.ErrorBarEnabled,trace.isErrorBarEnabled());
		updateTraceFeature(tDesc, TraceStructuralFeature.Name,trace.getName());
		
		//Only 
		updateTraceFeature(tDesc, TraceStructuralFeature.XAxis,map.getDescriptorFor(trace.getXAxis()));
		updateTraceFeature(tDesc, TraceStructuralFeature.YAxis,map.getDescriptorFor(trace.getYAxis()));
	}
}
