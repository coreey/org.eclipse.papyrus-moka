/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  David LOPEZ BETANCUR (CEA LIST)
 *  Sebastien REVOL (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.datavisualization.profile.custom;

import org.eclipse.papyrus.moka.datavisualization.profile.impl.IntegerSeriesImpl;
import org.eclipse.papyrus.moka.datavisualization.util.VisualizationUtil;

public class CustomIntegerSeries extends IntegerSeriesImpl {
	
	public CustomIntegerSeries() {
		// we modify the default value in order to force serialization
		binaryString = "";
	}
	
	@Override
	public String getStringValue(int index) {
		return 	getValues().get(index).toString();
	}
	
	@Override
	public int getSize() {
		return getValues().size();
	}
	
	@Override
	public void setBinaryString(String newBinaryString) {
		VisualizationUtil.initValuesFromBinaryString(this, newBinaryString);
	}

	@Override
	public String getBinaryString() {
			return VisualizationUtil.getBinaryString(this);

	}
}
