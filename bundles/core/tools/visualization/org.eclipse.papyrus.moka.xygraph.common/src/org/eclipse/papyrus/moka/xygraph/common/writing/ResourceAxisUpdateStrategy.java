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
package org.eclipse.papyrus.moka.xygraph.common.writing;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.nebula.visualization.xygraph.figures.Axis;
import org.eclipse.papyrus.moka.xygraph.mapping.common.XYGraphWidgetBinder;
import org.eclipse.papyrus.moka.xygraph.mapping.common.XYGraphMappingHelper;
import org.eclipse.papyrus.moka.xygraph.mapping.writing.AxisUpdateStrategy;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.AxisDescriptor;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphPackage;


public class ResourceAxisUpdateStrategy extends ResourceBaseUpdateStrategy implements AxisUpdateStrategy {

	@Override
	public void updateAxisDescriptor(Axis axis, XYGraphWidgetBinder map) {
		
		AxisDescriptor aDesc = map.getDescriptorFor(axis);
		
		TransactionalEditingDomain domain = getTransactionalEditingDomain(map.getXYGraphDescriptor().eResource());
		
		CompoundCommand cc = new CompoundCommand();
		appendSetCommand(cc, domain, aDesc, XYGraphPackage.eINSTANCE.getAxisDescriptor_Title(), axis.getTitle());
		appendSetCommand(cc, domain, aDesc, XYGraphPackage.eINSTANCE.getAxisDescriptor_Orientation(), XYGraphMappingHelper.mapOrientation( axis.getOrientation() ));
		appendSetCommand(cc, domain, aDesc, XYGraphPackage.eINSTANCE.getAxisDescriptor_AutoScale(), axis.isAutoScale() );
		appendSetCommand(cc, domain, aDesc, XYGraphPackage.eINSTANCE.getAxisDescriptor_AutoScaleThreshold(), axis.getAutoScaleThreshold() );
		appendSetCommand(cc, domain, aDesc, XYGraphPackage.eINSTANCE.getAxisDescriptor_ForegroundColor(), XYGraphMappingHelper.mapColor(axis.getForegroundColor()) );
		appendSetCommand(cc, domain, aDesc, XYGraphPackage.eINSTANCE.getAxisDescriptor_BackgroundColor(), XYGraphMappingHelper.mapColor(axis.getBackgroundColor()) );
		appendSetCommand(cc, domain, aDesc, XYGraphPackage.eINSTANCE.getAxisDescriptor_MajorGridColor(), XYGraphMappingHelper.mapColor(axis.getMajorGridColor()) );
		appendSetCommand(cc, domain, aDesc, XYGraphPackage.eINSTANCE.getAxisDescriptor_MinorGridColor(), XYGraphMappingHelper.mapColor(axis.getMinorGridColor()) );
		appendSetCommand(cc, domain, aDesc, XYGraphPackage.eINSTANCE.getAxisDescriptor_RangeUpper(), axis.getRange().getUpper() );
		appendSetCommand(cc, domain, aDesc, XYGraphPackage.eINSTANCE.getAxisDescriptor_RangeLower(), axis.getRange().getLower() );
		
		//** Strangely there's no getZoomType() method.
		//** appendSetCommand(cc, domain, aDesc, XYGraphPackage.eINSTANCE.getAxisDescriptor_ZoomType(), XYGraphManagerHelper.mapZoomType(axis.getZoomType()) );
		
		appendSetCommand(cc, domain, aDesc, XYGraphPackage.eINSTANCE.getAxisDescriptor_DashGridLine(), axis.isDashGridLine() );
		appendSetCommand(cc, domain, aDesc, XYGraphPackage.eINSTANCE.getAxisDescriptor_LogScale(), axis.isLogScaleEnabled() );
		appendSetCommand(cc, domain, aDesc, XYGraphPackage.eINSTANCE.getAxisDescriptor_MinorTicksVisible(), axis.isMinorTicksVisible() );
		appendSetCommand(cc, domain, aDesc, XYGraphPackage.eINSTANCE.getAxisDescriptor_ShowMajorGrid(), axis.isShowMajorGrid() );
		appendSetCommand(cc, domain, aDesc, XYGraphPackage.eINSTANCE.getAxisDescriptor_ShowMinorGrid(), axis.isShowMinorGrid() );
		appendSetCommand(cc, domain, aDesc, XYGraphPackage.eINSTANCE.getAxisDescriptor_PrimarySide(), axis.isOnPrimarySide() );

		appendSetCommand(cc, domain, aDesc, XYGraphPackage.eINSTANCE.getAxisDescriptor_AutoFormat(), axis.isAutoFormat() );
		appendSetCommand(cc, domain, aDesc, XYGraphPackage.eINSTANCE.getAxisDescriptor_DateEnabled(), axis.isDateEnabled() );
		appendSetCommand(cc, domain, aDesc, XYGraphPackage.eINSTANCE.getAxisDescriptor_FormatPattern(), axis.getFormatPattern() );
		
		appendSetCommand(cc, domain, aDesc, XYGraphPackage.eINSTANCE.getAxisDescriptor_Font(), XYGraphMappingHelper.mapFontData(axis.getScaleFontData()) );
		appendSetCommand(cc, domain, aDesc, XYGraphPackage.eINSTANCE.getAxisDescriptor_TitleFont(), XYGraphMappingHelper.mapFontData(axis.getTitleFontData()) );
		
		if( cc.canExecute() )
			domain.getCommandStack().execute(cc);
	}
}
