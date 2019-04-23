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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.nebula.visualization.xygraph.figures.Axis;
import org.eclipse.nebula.visualization.xygraph.figures.IXYGraph;
import org.eclipse.nebula.visualization.xygraph.figures.Trace;
import org.eclipse.nebula.visualization.xygraph.figures.XYGraph;
import org.eclipse.nebula.visualization.xygraph.linearscale.Range;
import org.eclipse.papyrus.moka.xygraph.mapping.util.BaseAxisListener;
import org.eclipse.papyrus.moka.xygraph.mapping.util.TraceDataBounds;
import org.eclipse.papyrus.moka.xygraph.mapping.writing.ModelWritingStrategyFactory;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage;

public class XYGraphCoordinator{

	protected XYGraphBinder graphMap;
	protected ModelWritingStrategyFactory factory;
	private List<XYGraphListener> listeners = new ArrayList<XYGraphListener>();
	
	public XYGraphCoordinator(XYGraphBinder binder, ModelWritingStrategyFactory factory){
		this.graphMap = binder;
		this.factory = factory;
	}
	
	public void updateDescriptors(XYGraph xy){
		factory.getXYGraphUpdateStrategy().updateXYGraph(xy, graphMap);
		
		for( Axis axis : graphMap.getAxes())
			factory.getAxisUpdateStrategy().updateAxisDescriptor(axis, graphMap);
		
		for( Trace trace: graphMap.getTraces() )
			factory.getTraceUpdateStrategy().updateTraceDescriptor(trace, graphMap);
		
		onXYGraphUpdated();
	}
	
	protected void onXYGraphUpdated() {
		fireXYGraphUpdated(graphMap.getXYGraphDescriptor());
	}

	public IXYGraph buildXYGraph(){
		//1. Axes first (Primary axes are required for the xyGraph)
		factory.getAxisBuildStrategy().rebuildAxes(graphMap);
		
		//2. Build the xyGraph 
		IXYGraph xy = factory.getXYGraphBuildStrategy().buildGraph(graphMap);		
		XYGraphDescriptor gDesc = graphMap.getXYGraphDescriptor(); 
		
		//2.1. The axes need the graph before the traces.
		for( AxisDescriptor aDesc : gDesc.getAxisDescriptors() ){
			Axis axis = graphMap.getAxisFor(aDesc);
			//Listen range changes
			axis.addListener(new BaseAxisListener(){
				@Override
				public void axisRangeChanged(Axis axis, Range old_range, Range new_range) {
					onAxisRangeChanged( axis, old_range, new_range );
				}
			});
			
			if( graphMap.isPrimary(aDesc) )
				continue;

			xy.addAxis(axis);
		}
		
		//3. Build and add the traces
		factory.getTraceBuildStrategy().rebuildTraces(graphMap);
		
		for( TraceDescriptor tDesc : gDesc.getTraceDescriptors() )
			xy.addTrace(graphMap.getTraceFor(tDesc));
		
		onXYGraphBuilt();
		
		return xy;
	}
	
	protected void onXYGraphBuilt(){
		fireXYGraphBuilt(graphMap.getXYGraphDescriptor());
	}
	
	public XYGraphDescriptor getXYGraphDescriptor(){
		return graphMap.getXYGraphDescriptor();
	}
	
	public void addXYGraphListener( XYGraphListener listener ){
		listeners.add(listener);
	}
	
	protected void fireXYGraphUpdated(XYGraphDescriptor xyGraph){
		for( XYGraphListener listener : listeners )
			listener.onXYGraphUpdated(this, xyGraph);
	}
	
	protected void fireXYGraphBuilt(XYGraphDescriptor xyGraph) {
		for( XYGraphListener listener : listeners )
			listener.onXYGraphBuilt(this, xyGraph);
	}
	
	public void synchronizeTracesVisibility(){
		XYGraphDescriptor xyDesc = graphMap.getXYGraphDescriptor();
		List<TraceDescriptor> visibles = xyDesc.getVisibleTraces();
		
		//Make the newly added traces visible?
		factory.getTraceBuildStrategy().rebuildTraces(graphMap);
		
		for( TraceDescriptor tDesc : graphMap.getTraceDescriptors() ){
			if( visibles.contains(tDesc) )
				showTrace(graphMap.getXYGraph(), graphMap.getTraceFor(tDesc));
			else
				hideTrace(graphMap.getXYGraph(), graphMap.getTraceFor(tDesc));
		}
	}
	
	protected void addNewTrace( TraceDescriptor tDesc, boolean visible ){
		XYGraphDescriptor xy = graphMap.getXYGraphDescriptor();		
		//Add the trace descriptor.
		xy.getTraceDescriptors().add(tDesc);
		
		//Rebuild the traces
		factory.getTraceBuildStrategy().rebuildTraces(graphMap);
		
		if( visible ){
			xy.getVisibleTraces().add( tDesc );
			showTrace(graphMap.getXYGraph(), graphMap.getTraceFor(tDesc));
		}
	}
	
	protected void removeTrace( TraceDescriptor tDesc ){
		//Remove it from the visibles
		XYGraphDescriptor xy = graphMap.getXYGraphDescriptor();
		xy.getVisibleTraces().remove(tDesc);
		
		//Unbind it
		Trace trace = graphMap.unbindTrace(tDesc);

		//Hide it
		hideTrace(graphMap.getXYGraph(), trace);
	}

	private void hideTrace(XYGraph graph, Trace trace){
		//Only remove it if contained			
		if( graph.getPlotArea().getChildren().contains(trace) ){ 
			graph.removeTrace(trace);
		}
	}
	
	private void showTrace(XYGraph graph, Trace trace){
		//Only add it if not contained
		if( !graph.getPlotArea().getChildren().contains(trace) ){ 
			graph.addTrace(trace);
		}
	}

	public void onModelUpdate(Notification notification) {
		//System.out.println(notification.getFeature());
		
		if( XYGraphPackage.eINSTANCE.getXYGraphDescriptor_VisibleTraces().equals(notification.getFeature()) ){
			synchronizeTracesVisibility();
		}
		
		//Apply the changes to the XYGraph (Figure)  
		//Currently manual, we might want to change everything later?
		if( XYGraphPackage.eINSTANCE.getXYGraphDescriptor_Title().equals(notification.getFeature()) ){
			graphMap.getXYGraph().setTitle(notification.getNewStringValue());
		}
	}
	
	protected void onAxisRangeChanged(Axis axis, Range old_range, Range new_range) {
		
		AxisDescriptor aDesc = graphMap.getDescriptorFor(axis);
		//aDesc.setRangeLower(new_range.getLower());
		//aDesc.setRangeUpper(new_range.getUpper());
		
		//Update the range in the axis?
		factory.getAxisUpdateStrategy().updateAxisDescriptor(axis, graphMap);
		//System.out.println("Updated axis Range: " + aDesc.getRangeLower() + ", " + aDesc.getRangeUpper());
	}

	public void dispose() {
		graphMap.dispose();
	}
	
	public void rescaleAxesIfNeeded(){
		AxisDescriptor xPrimary = graphMap.getDescriptorFor(graphMap.getXAxisPrimary());
		AxisDescriptor yPrimary = graphMap.getDescriptorFor(graphMap.getYAxisPrimary());
		
		if( xPrimary.getRangeLower() < xPrimary.getRangeUpper() && yPrimary.getRangeLower() < yPrimary.getRangeUpper() )
			return; //not needed.
		
		forceAxesRescale();
		
	}
	
	public void forceAxesRescale(){
		
		//System.out.println("Forcing re-scale");
		
		TraceDataBounds dataBounds = new TraceDataBounds();
		
		for( TraceDescriptor tDesc : graphMap.getTraceDescriptors() )
			dataBounds.union( graphMap.getTraceDataBounds(tDesc) );
		
		graphMap.getXAxisPrimary().setRange(dataBounds.getxMin(), dataBounds.getxMax());
		graphMap.getYAxisPrimary().setRange(dataBounds.getyMin(), dataBounds.getyMax());
		
		factory.getAxisUpdateStrategy().updateAxisDescriptor(graphMap.getXAxisPrimary(), graphMap);
		factory.getAxisUpdateStrategy().updateAxisDescriptor(graphMap.getYAxisPrimary(), graphMap);
		
	}
}
