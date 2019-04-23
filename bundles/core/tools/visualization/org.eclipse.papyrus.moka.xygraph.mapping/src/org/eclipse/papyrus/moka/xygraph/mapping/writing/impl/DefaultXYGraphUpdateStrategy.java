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
package org.eclipse.papyrus.moka.xygraph.mapping.writing.impl;

import org.eclipse.nebula.visualization.xygraph.figures.XYGraph;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor;
import org.eclipse.papyrus.moka.xygraph.mapping.common.XYGraphWidgetBinder;
import org.eclipse.papyrus.moka.xygraph.mapping.common.XYGraphMappingHelper;
import org.eclipse.papyrus.moka.xygraph.mapping.writing.XYGraphUpdateStrategy;

public class DefaultXYGraphUpdateStrategy implements XYGraphUpdateStrategy{

	@Override
	public void updateXYGraph(XYGraph xy, XYGraphWidgetBinder graphMap) {
		
		XYGraphDescriptor gDesc = graphMap.getXYGraphDescriptor();
		
		gDesc.setTitle(xy.getTitle());
		gDesc.setTitleColor(XYGraphMappingHelper.mapColor(xy.getTitleColor()));
		gDesc.setTitleFont(XYGraphMappingHelper.mapFontData(xy.getTitleFontData()));
		gDesc.setZoomType(XYGraphMappingHelper.mapZoomType(xy.getZoomType()));
		gDesc.setShowLegend(xy.isShowLegend());
		gDesc.setShowTitle(xy.isShowTitle());
		gDesc.setTransparent(xy.isTransparent());
		gDesc.setShowPlotAreaBorder( xy.getPlotArea().isShowBorder() );
		gDesc.setPlotAreaBackgroundColor( XYGraphMappingHelper.mapColor(xy.getPlotArea().getBackgroundColor()) );
	}

	@Override
	public void addTrace(XYGraphDescriptor gDesc, TraceDescriptor trace) {
		gDesc.getTraceDescriptors().add(trace);
	}

	@Override
	public void setTraceVisibility(XYGraphDescriptor gDesc, TraceDescriptor tDesc, boolean visible) {
		if( visible )
			gDesc.getVisibleTraces().add(tDesc);
		else
			gDesc.getVisibleTraces().remove(tDesc);
	}
}
