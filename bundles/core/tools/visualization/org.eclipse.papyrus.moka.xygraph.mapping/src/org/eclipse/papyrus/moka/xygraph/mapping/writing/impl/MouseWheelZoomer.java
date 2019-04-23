/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
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
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.xygraph.mapping.writing.impl;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.nebula.visualization.internal.xygraph.undo.SaveStateCommand;
import org.eclipse.nebula.visualization.internal.xygraph.undo.ZoomCommand;
import org.eclipse.nebula.visualization.xygraph.figures.IXYGraph;
import org.eclipse.nebula.visualization.xygraph.figures.PlotArea;
import org.eclipse.nebula.visualization.xygraph.figures.ZoomType;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseWheelListener;

public class MouseWheelZoomer implements MouseWheelListener{

	private IXYGraph xygraph;
	
	
	private static final ZoomType zoomType = ZoomType.ZOOM_IN;
	
	public MouseWheelZoomer(IXYGraph xygraph) {
		super();
		this.xygraph = xygraph;
	}

	@Override
	public void mouseScrolled(MouseEvent e) {
		//Axis.ZOOM_RATIO = 0.1, but it's not public ! 
		double factor = 0.1 * Math.signum(e.count);

		PlotArea pa = xygraph.getPlotArea();
		Rectangle bounds = pa.getBounds();
		
		pa.zoomInOut(true, true, bounds.width / 2, bounds.height / 2, factor);
		
		//Add it to the operation story so it can be undone
		SaveStateCommand command = new ZoomCommand(zoomType.getDescription(), xygraph.getXAxisList(), xygraph.getYAxisList());
		command.saveState();
		xygraph.getOperationsManager().addCommand(command);
	}

}
