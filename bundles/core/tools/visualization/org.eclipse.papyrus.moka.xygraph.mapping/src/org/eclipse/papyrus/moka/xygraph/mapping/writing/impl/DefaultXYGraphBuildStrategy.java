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

import org.eclipse.nebula.visualization.xygraph.figures.Axis;
import org.eclipse.nebula.visualization.xygraph.figures.IAxesFactory;
import org.eclipse.nebula.visualization.xygraph.figures.IXYGraph;
import org.eclipse.nebula.visualization.xygraph.figures.XYGraph;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor;
import org.eclipse.papyrus.moka.xygraph.mapping.common.XYGraphWidgetBinder;
import org.eclipse.papyrus.moka.xygraph.mapping.common.XYGraphMappingHelper;
import org.eclipse.papyrus.moka.xygraph.mapping.writing.XYGraphBuildStrategy;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

public class DefaultXYGraphBuildStrategy implements XYGraphBuildStrategy {

	@Override
	public IXYGraph buildGraph(XYGraphWidgetBinder map) {
		
		XYGraph xy = new XYGraph(new IAxesFactory() {
			@Override
			public Axis createYAxis() {
				return map.getYAxisPrimary();
			}
			@Override
			public Axis createXAxis() {
				return map.getXAxisPrimary();
			}
		});
		
		setupXYGraph(xy, map.getXYGraphDescriptor());
		
		map.bindXYGraph(xy);
		
		return xy;
	}
	
	private void setupXYGraph(XYGraph xy, XYGraphDescriptor gDesc){
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
