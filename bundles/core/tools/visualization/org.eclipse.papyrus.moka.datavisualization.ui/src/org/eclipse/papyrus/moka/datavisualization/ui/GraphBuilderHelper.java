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
package org.eclipse.papyrus.moka.datavisualization.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.datavisualization.profile.DataSource;
import org.eclipse.papyrus.moka.datavisualization.profile.ValueSeries;
import org.eclipse.papyrus.moka.datavisualization.service.DataSourceVariableID;
import org.eclipse.papyrus.moka.xygraph.mapping.common.Variable.VariableID;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.ColorDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.FontDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.LinearScale_Orientation;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.Trace_TraceType;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphFactory;
import org.eclipse.swt.SWT;

public class GraphBuilderHelper {
	final static int[] colors[] = { 
			{21, 21, 196}, // blue
			{242, 26, 26}, // red
			{33, 179, 33}, // green
			//{0, 0, 0}, // black
			//{128, 0, 255}, // violet
			{255, 170, 0}, // (darkish) yellow
			{255, 0, 240}, // pink
			{243, 132, 132}, // peachy
			{0, 255, 11}, // neon green
			//{0, 214, 255}, // neon blue
			{114, 40, 3}, // brown
			{219, 128, 4}, // orange
	};
	
	final static Trace_TraceType[] types = {
			Trace_TraceType.SOLID_LINE,
			Trace_TraceType.DASHDOT_LINE,
			Trace_TraceType.DOT_LINE
	};
	
	private static ColorDescriptor makeColor(int r, int g, int b) {
		ColorDescriptor color = XYGraphFactory.eINSTANCE.createColorDescriptor();
		
		color.setR(r);
		color.setG(g);
		color.setB(b);
		
		return color;
	}

	private static FontDescriptor makeFontDescriptor(String name, int size, int style){
		FontDescriptor fd = XYGraphFactory.eINSTANCE.createFontDescriptor();
		fd.setName(name);
		fd.setSize(size);
		fd.setStyle(style);
		
		return fd;
	}
	
	public static TraceDescriptor buildTraceFor(XYGraphDescriptor xyDesc, ValueSeries serie){ //String traceName, VariableID traceID){
		
		String traceName = serie.getBase_Property().getLabel();
		VariableID traceID = new DataSourceVariableID(serie);
		
		int added = xyDesc.getTraceDescriptors().size();
		
		TraceDescriptor tDesc = XYGraphFactory.eINSTANCE.createTraceDescriptor();
		tDesc.setXAxis(xyDesc.getAxisDescriptors().get(0));
		tDesc.setYAxis(xyDesc.getAxisDescriptors().get(1));
		tDesc.setName(traceName);
		
		//Only sets dataSource if it comes from a UML Stereotyped value series.
		if( traceID instanceof DataSourceVariableID ){
			tDesc.setDataSource( serie );
		}
		
		tDesc.setTraceColor(makeColor(colors[added % colors.length][0], colors[added % colors.length][1], colors[added % colors.length][2]));
		tDesc.setTraceType(types[(added / colors.length)%types.length]);
		
		return tDesc;
	}
	
	public static void separateValueSeries(List<ValueSeries> series, List<ValueSeries> indep, List<ValueSeries> dep){		
		for( ValueSeries vs : series )
			if( vs.getDependent() == null )
				indep.add(vs);
			else
				dep.add(vs);
		
	}
	
	public static XYGraphDescriptor buildFromSeries(DataSource dataSource, List<ValueSeries> visibles) {
		
		ArrayList<ValueSeries> independent = new ArrayList<>();
		ArrayList<ValueSeries> dependent = new ArrayList<>();
		
		separateValueSeries(dataSource.getSeries(), independent, dependent);
		
		//Check that there's only one independent variable.
		if( independent.size() != 1 )
			throw new UnsupportedOperationException("For the moment there can only be one independent value series");
		
		ValueSeries ind = independent.get(0);
		
		XYGraphDescriptor xy = XYGraphFactory.eINSTANCE.createXYGraphDescriptor();
		xy.setTitle("CSV-Graph");
		xy.setTitleFont(makeFontDescriptor("Segoe UI", 16, SWT.BOLD));
		xy.setPlotAreaBackgroundColor(makeColor(255, 255, 255));
		xy.setDataSource(null);
		
		//The independent variable
		AxisDescriptor xAxis = XYGraphFactory.eINSTANCE.createAxisDescriptor();
		
		xAxis.setAutoScale(false);
		xAxis.setRangeLower(1);
		xAxis.setRangeUpper(-1);
		
		xAxis.setOrientation(LinearScale_Orientation.HORIZONTAL);
		xAxis.setTitle(ind.getBase_Property().getLabel());		
		xAxis.setFont(makeFontDescriptor("Segoe UI", 12, SWT.NORMAL));
		xAxis.setTitleFont(makeFontDescriptor("Segoe UI", 12, SWT.NORMAL));
		
		xy.getAxisDescriptors().add(xAxis);

		AxisDescriptor yAxis = XYGraphFactory.eINSTANCE.createAxisDescriptor();
		
		yAxis.setAutoScale(false);
		yAxis.setRangeLower(1);
		yAxis.setRangeUpper(-1);
		
		yAxis.setOrientation(LinearScale_Orientation.VERTICAL);
		yAxis.setTitle("Values"); //TODO This might be controlled from the dataSource object? dataSource.getBase_DataType().getLabel()
		yAxis.setFont(makeFontDescriptor("Segoe UI", 12, SWT.NORMAL));
		yAxis.setTitleFont(makeFontDescriptor("Segoe UI", 12, SWT.NORMAL));
		
		xy.getAxisDescriptors().add(yAxis);

		//Only for the dependent
		for(ValueSeries serie : dependent){

			TraceDescriptor tDesc = buildTraceFor(xy, serie);
			xy.getTraceDescriptors().add(tDesc);
			
			if( visibles.contains(serie) )
				xy.getVisibleTraces().add(tDesc);
		}
		return xy;
	}
}
