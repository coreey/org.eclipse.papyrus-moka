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
package org.eclipse.papyrus.moka.xygraph.mapping.util;

import org.eclipse.nebula.visualization.xygraph.figures.Axis;
import org.eclipse.nebula.visualization.xygraph.figures.IAxisListener;
import org.eclipse.nebula.visualization.xygraph.linearscale.Range;
import org.eclipse.swt.graphics.Color;

public class BaseAxisListener implements IAxisListener{

	@Override
	public void axisRangeChanged(Axis axis, Range old_range, Range new_range) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void axisRevalidated(Axis axis) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void axisForegroundColorChanged(Axis axis, Color oldColor, Color newColor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void axisTitleChanged(Axis axis, String oldTitle, String newTitle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void axisAutoScaleChanged(Axis axis, boolean oldAutoScale, boolean newAutoScale) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void axisLogScaleChanged(Axis axis, boolean old, boolean logScale) {
		// TODO Auto-generated method stub
		
	}

}
