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
package org.eclipse.papyrus.moka.xygraph.mapping.common;

import org.eclipse.nebula.visualization.xygraph.figures.Trace.BaseLine;
import org.eclipse.nebula.visualization.xygraph.figures.Trace.ErrorBarType;
import org.eclipse.nebula.visualization.xygraph.figures.Trace.PointStyle;
import org.eclipse.nebula.visualization.xygraph.figures.Trace.TraceType;
import org.eclipse.nebula.visualization.xygraph.figures.XYGraph;
import org.eclipse.nebula.visualization.xygraph.figures.ZoomType;
import org.eclipse.nebula.visualization.xygraph.linearscale.LinearScale.Orientation;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.FontDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.LinearScale_Orientation;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_BaseLine;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_ErrorBarType;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_PointStyle;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_TraceType;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphFactory;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;

public final class XYGraphMappingHelper {
	
	private XYGraphMappingHelper(){
		
	}
	
	public static Color mapColorDescriptor( org.eclipse.papyrus.moka.xygraph.model.xygraph.ColorDescriptor color){
		if( color == null )
			return new Color(Display.getCurrent(), 0, 0, 0);
		
		return new Color(Display.getCurrent(), color.getR(), color.getG(), color.getB());
	}
	
	public static ZoomType mapXYGraphZoomType( org.eclipse.papyrus.moka.xygraph.model.xygraph.ZoomType zoomType){
		return ZoomType.valueOf(zoomType.name());
	}
	
	public static org.eclipse.papyrus.moka.xygraph.model.xygraph.ColorDescriptor mapColor(Color color){
		org.eclipse.papyrus.moka.xygraph.model.xygraph.ColorDescriptor c = XYGraphFactory.eINSTANCE.createColorDescriptor();
		c.setR(color.getRed());
		c.setG(color.getGreen());
		c.setB(color.getBlue());
		
		return c;
	}
	
	public static org.eclipse.papyrus.moka.xygraph.model.xygraph.ZoomType mapZoomType(ZoomType type){
		return org.eclipse.papyrus.moka.xygraph.model.xygraph.ZoomType.valueOf(type.name());
	}
	
	public static FontData mapFontDescriptor(FontDescriptor fDesc){
		return new FontData(fDesc.getName(), fDesc.getSize(), fDesc.getStyle());
	}
	
	public static FontDescriptor mapFontData(FontData data){
		FontDescriptor fDesc = XYGraphFactory.eINSTANCE.createFontDescriptor();
		fDesc.setName(data.getName());
		fDesc.setSize(data.getHeight());
		fDesc.setStyle(data.getStyle());
		
		return fDesc;
	}
	
	public static LinearScale_Orientation mapOrientation( Orientation orientation){
		return LinearScale_Orientation.valueOf(orientation.name());
	}
	
	public static ErrorBarType buildErrorBarType(Trace_ErrorBarType errorBarType) {
		return ErrorBarType.valueOf(errorBarType.getLiteral());
	}
	
	public static Trace_ErrorBarType descErrorBarType(ErrorBarType type){
		return Trace_ErrorBarType.valueOf(type.name());
	}
	
	public static TraceType buildTraceType(Trace_TraceType traceType) {
		return TraceType.valueOf(traceType.getLiteral());
	}
	
	public static Trace_TraceType descTraceType(TraceType type){
		return Trace_TraceType.valueOf(type.name());
	}
	
	public static PointStyle buildPointStyle(Trace_PointStyle pointStyle) {
		return PointStyle.valueOf(pointStyle.getLiteral());
	}
	
	public static Trace_PointStyle descPointStyle(PointStyle style){
		return Trace_PointStyle.valueOf(style.name());
	}

	public static BaseLine buildTraceBaseLine(Trace_BaseLine baseLine) {
		return BaseLine.valueOf(baseLine.getLiteral());
	}
	
	public static Trace_BaseLine descTraceBaseLine(BaseLine baseLine){
		return Trace_BaseLine.valueOf(baseLine.name());
	}
	
	public static void populateXYGraph(XYGraph xy, XYGraphDescriptor gDesc){
		xy.setTitle( gDesc.getTitle() );
		xy.setTitleColor( XYGraphMappingHelper.mapColorDescriptor( gDesc.getTitleColor() ));
		xy.setTitleFont(new Font(Display.getCurrent(), XYGraphMappingHelper.mapFontDescriptor(gDesc.getTitleFont())));
		xy.setZoomType( XYGraphMappingHelper.mapXYGraphZoomType( gDesc.getZoomType() ) );
		xy.setShowLegend(gDesc.isShowLegend());
		xy.setShowTitle(gDesc.isShowTitle());
		xy.setTransparent(gDesc.isTransparent());
		
		xy.getPlotArea().setShowBorder(gDesc.isShowPlotAreaBorder());
		xy.getPlotArea().setBackgroundColor(XYGraphMappingHelper.mapColorDescriptor(gDesc.getPlotAreaBackgroundColor()));
	}
}
