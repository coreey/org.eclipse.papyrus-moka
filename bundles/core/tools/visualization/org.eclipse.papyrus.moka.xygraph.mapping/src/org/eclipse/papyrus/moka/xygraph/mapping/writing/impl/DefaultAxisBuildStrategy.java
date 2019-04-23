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
import org.eclipse.papyrus.moka.xygraph.mapping.common.XYGraphMappingHelper;
import org.eclipse.papyrus.moka.xygraph.mapping.common.XYGraphWidgetBinder;
import org.eclipse.papyrus.moka.xygraph.mapping.writing.AxisBuildStrategy;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.LinearScale_Orientation;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

public class DefaultAxisBuildStrategy implements AxisBuildStrategy {

	@Override
	public void rebuildAxes(XYGraphWidgetBinder map) {
		for (AxisDescriptor aDesc : map.getXYGraphDescriptor().getAxisDescriptors() )
			map.bindAxis(aDesc, buildAxis(aDesc));
	}

	protected Axis buildAxis(AxisDescriptor aDesc) {
		Axis axis = new Axis(aDesc.getTitle(), aDesc.getOrientation() == LinearScale_Orientation.VERTICAL);
		
		axis.setAutoScale(aDesc.isAutoScale());
		axis.setAutoScaleThreshold( aDesc.getAutoScaleThreshold() );
		axis.setBackgroundColor( XYGraphMappingHelper.mapColorDescriptor(aDesc.getBackgroundColor()) );
		axis.setForegroundColor( XYGraphMappingHelper.mapColorDescriptor(aDesc.getForegroundColor()) );
		axis.setMajorGridColor( XYGraphMappingHelper.mapColorDescriptor(aDesc.getMajorGridColor()) );
		axis.setMinorGridColor( XYGraphMappingHelper.mapColorDescriptor(aDesc.getMinorGridColor()) );
		axis.setRange( aDesc.getRangeLower(),  aDesc.getRangeUpper() );
		axis.setZoomType( XYGraphMappingHelper.mapXYGraphZoomType( aDesc.getZoomType() ) );
		
		axis.setDashGridLine( aDesc.isDashGridLine() );
		axis.setLogScale( aDesc.isLogScale() );
		axis.setMinorTicksVisible( aDesc.isMinorTicksVisible() );
		axis.setShowMajorGrid( aDesc.isShowMajorGrid() );
		axis.setShowMinorGrid( aDesc.isShowMinorGrid() );
		axis.setPrimarySide( aDesc.isPrimarySide() );
		
		axis.setAutoFormat(aDesc.isAutoFormat());
		axis.setDateEnabled(aDesc.isDateEnabled());
		axis.setFormatPattern(aDesc.getFormatPattern());
		
		
		axis.setFont(new Font(Display.getCurrent(), XYGraphMappingHelper.mapFontDescriptor(aDesc.getFont())));
		axis.setTitleFont(new Font(Display.getCurrent(), XYGraphMappingHelper.mapFontDescriptor(aDesc.getTitleFont())));
		
		return axis;
	}
}
