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
import org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor;
import org.eclipse.papyrus.moka.xygraph.mapping.common.XYGraphWidgetBinder;
import org.eclipse.papyrus.moka.xygraph.mapping.common.XYGraphMappingHelper;
import org.eclipse.papyrus.moka.xygraph.mapping.writing.AxisUpdateStrategy;

public class DefaultAxisUpdateStrategy implements AxisUpdateStrategy{

	@Override
	public void updateAxisDescriptor(Axis axis, XYGraphWidgetBinder map) {
		AxisDescriptor aDesc = map.getDescriptorFor(axis);
		
		aDesc.setTitle(axis.getTitle());
		aDesc.setOrientation(XYGraphMappingHelper.mapOrientation(axis.getOrientation()));
		
		aDesc.setAutoScale(axis.isAutoScale());
		aDesc.setAutoScaleThreshold(axis.getAutoScaleThreshold());
		aDesc.setForegroundColor(XYGraphMappingHelper.mapColor(axis.getForegroundColor()));
		aDesc.setBackgroundColor(XYGraphMappingHelper.mapColor(axis.getBackgroundColor()));
		aDesc.setMajorGridColor(XYGraphMappingHelper.mapColor(axis.getMajorGridColor()));
		aDesc.setMinorGridColor(XYGraphMappingHelper.mapColor(axis.getMinorGridColor()));
		aDesc.setRangeUpper(axis.getRange().getUpper());
		aDesc.setRangeLower(axis.getRange().getLower());
		
		//** Strangely there's no getZoomType() method.
		//** aDesc.setZoomType(descZoomType(axis.getZoomType())));
		
		aDesc.setDashGridLine(axis.isDashGridLine());
		aDesc.setLogScale(axis.isLogScaleEnabled());
		aDesc.setMinorTicksVisible(axis.isMinorTicksVisible());
		aDesc.setShowMajorGrid(axis.isShowMajorGrid());
		aDesc.setShowMinorGrid(axis.isShowMinorGrid());
		aDesc.setPrimarySide(axis.isOnPrimarySide());
		
		aDesc.setAutoFormat(axis.isAutoFormat());
		aDesc.setDateEnabled(axis.isDateEnabled());
		aDesc.setFormatPattern(axis.getFormatPattern());
		
		aDesc.setFont(XYGraphMappingHelper.mapFontData(axis.getScaleFontData()));
		aDesc.setTitleFont(XYGraphMappingHelper.mapFontData(axis.getTitleFontData()));
	}
}
