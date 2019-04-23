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
import org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor;

public interface XYGraphWidgetBinder {

	void setGraphDescriptor(XYGraphDescriptor gDesc);
	XYGraphDescriptor getXYGraphDescriptor();

	void bindAxis(AxisDescriptor aDesc, Axis axis);
	void bindTrace(TraceDescriptor tDesc, Trace trace);
	Trace unbindTrace(TraceDescriptor tDesc);

	Axis getAxisFor(AxisDescriptor aDesc);
	AxisDescriptor getDescriptorFor(Axis axis);

	Trace getTraceFor(TraceDescriptor tDesc);
	TraceDescriptor getDescriptorFor(Trace trace);
	boolean isTraceMapped(TraceDescriptor tDesc);
	
	Axis getXAxisPrimary();
	Axis getYAxisPrimary();

	boolean isPrimary(AxisDescriptor aDesc);
	boolean isPrimary(Axis axis);

	Collection<Axis> getAxes();
	Collection<Trace> getTraces();
	
	Collection<TraceDescriptor> getTraceDescriptors();
	Collection<AxisDescriptor> getAxisDescriptors();
	
	void bindXYGraph(XYGraph xy);
	XYGraph getXYGraph();
	
	void dispose();
}