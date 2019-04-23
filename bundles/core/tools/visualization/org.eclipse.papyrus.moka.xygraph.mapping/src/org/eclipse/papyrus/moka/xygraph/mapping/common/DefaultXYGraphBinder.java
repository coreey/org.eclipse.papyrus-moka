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

import java.util.Collection;

import org.eclipse.nebula.visualization.xygraph.figures.Axis;
import org.eclipse.nebula.visualization.xygraph.figures.Trace;
import org.eclipse.nebula.visualization.xygraph.figures.XYGraph;
import org.eclipse.papyrus.moka.xygraph.mapping.util.DataBatch;
import org.eclipse.papyrus.moka.xygraph.mapping.util.LUT;
import org.eclipse.papyrus.moka.xygraph.mapping.util.LightDataProvider;
import org.eclipse.papyrus.moka.xygraph.mapping.util.TraceDataBounds;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.LinearScale_Orientation;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor;

public class DefaultXYGraphBinder implements XYGraphBinder {
	
	private XYGraphDescriptor gDesc;
	private XYGraph xyGraph;
	private Axis xAxisPrimary = null, yAxisPrimary = null;
	private LUT<AxisDescriptor, Axis> axisMap;
	private LUT<TraceDescriptor, Trace> traceMap;
	
	public DefaultXYGraphBinder() {
		axisMap = new LUT<>();
		traceMap = new LUT<>();
	}
	
	public DefaultXYGraphBinder(XYGraphDescriptor graphDescriptor){
		this();
		gDesc = graphDescriptor;
	}

	@Override
	public XYGraphDescriptor getXYGraphDescriptor() {
		return gDesc;
	}
	
	@Override
	public void bindAxis(AxisDescriptor aDesc, Axis axis){
		if( aDesc.getOrientation() == LinearScale_Orientation.HORIZONTAL && xAxisPrimary == null )
			xAxisPrimary = axis;
		
		if( aDesc.getOrientation() == LinearScale_Orientation.VERTICAL && yAxisPrimary == null )
			yAxisPrimary = axis;
		
		axisMap.put(aDesc, axis);
	}
	
	@Override
	public void bindTrace(TraceDescriptor tDesc, Trace trace){
		traceMap.put(tDesc, trace);
	}
	
	@Override
	public Trace unbindTrace(TraceDescriptor tDesc) {	
		return traceMap.remove(tDesc);
	}

	@Override
	public Axis getAxisFor(AxisDescriptor aDesc){
		return axisMap.getValueOf(aDesc);
	}
	
	@Override
	public AxisDescriptor getDescriptorFor(Axis axis){
		return axisMap.getKeyOf(axis);
	}
	
	@Override
	public Trace getTraceFor(TraceDescriptor tDesc){
		return traceMap.getValueOf(tDesc);
	}
	
	@Override
	public boolean isTraceMapped(TraceDescriptor tDesc){
		return traceMap.keySet().contains(tDesc);
	}
	
	@Override
	public TraceDescriptor getDescriptorFor(Trace trace){
		return traceMap.getKeyOf(trace);
	}
	
	@Override
	public Axis getXAxisPrimary() {
		return xAxisPrimary;
	}
	
	@Override
	public Axis getYAxisPrimary() {
		return yAxisPrimary;
	}
	
	@Override
	public boolean isPrimary(AxisDescriptor aDesc){
		return isPrimary(axisMap.getValueOf(aDesc));
	}
	
	@Override
	public boolean isPrimary(Axis axis) {
		return axis == xAxisPrimary || axis == yAxisPrimary;
	}

	@Override
	public Collection<Axis> getAxes() {
		return axisMap.valueSet();
	}
	
	@Override
	public Collection<Trace> getTraces(){
		return traceMap.valueSet();
	}

	@Override
	public void setGraphDescriptor(XYGraphDescriptor gDesc) {
		this.gDesc = gDesc;		
	}

	@Override
	public Collection<TraceDescriptor> getTraceDescriptors() {
		return traceMap.keySet();
	}

	@Override
	public Collection<AxisDescriptor> getAxisDescriptors() {
		return axisMap.keySet();
	}
	
	private LightDataProvider getProviderOf( TraceDescriptor tDesc ){
		Trace trace = getTraceFor(tDesc);
		return (LightDataProvider) trace.getDataProvider();
	}
	
	@Override
	public void addTraceSample(TraceDescriptor tDesc, double x, double y) {
		getProviderOf(tDesc).addSample(x, y);
	}

	@Override
	public void setTraceData(TraceDescriptor tDesc, DataBatch x, DataBatch y) {
		getProviderOf(tDesc).setDataList(x.getValues(), y.getValues());		
	}
	
	@Override
	public void bindXYGraph(XYGraph xy) {
		this.xyGraph = xy;
	}
	
	public XYGraph getXYGraph(){
		return xyGraph;
	}

	@Override
	public void dispose() {
		for( TraceDescriptor tDesc : gDesc.getTraceDescriptors() ){
			getProviderOf(tDesc).clear();
			
			//Manually clean the trace. Why is this not being cleaned automatically by the widget?
			getTraceFor(tDesc).getHotSampleList().clear();
		}
		
		axisMap.dispose();
		traceMap.dispose();
	}

	@Override
	public TraceDataBounds getTraceDataBounds(TraceDescriptor tDesc) {
		return getProviderOf(tDesc).getBounds();
	}

}
