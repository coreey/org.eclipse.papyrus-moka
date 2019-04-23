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
package org.eclipse.papyrus.moka.datavisualization.profile.custom;

import org.eclipse.papyrus.moka.datavisualization.profile.BooleanSeries;
import org.eclipse.papyrus.moka.datavisualization.profile.DataSource;
import org.eclipse.papyrus.moka.datavisualization.profile.DoubleSeries;
import org.eclipse.papyrus.moka.datavisualization.profile.IntegerSeries;
import org.eclipse.papyrus.moka.datavisualization.profile.StringSeries;
import org.eclipse.papyrus.moka.datavisualization.profile.impl.VisualizationFactoryImpl;

public class CustomVisualizationPackageFactory extends VisualizationFactoryImpl {
	

	@Override
	public DataSource createDataSource() {
		return new CustomDataSources();
	}
	
	
	
	@Override
	public DoubleSeries createDoubleSeries() {
		
		return new CustomDoubleSeries();
	}
	@Override
	public IntegerSeries createIntegerSeries() {
		
		return new CustomIntegerSeries();
	}
	
	@Override
	public BooleanSeries createBooleanSeries() {
		
		return new CustomBooleanSeries();
	}
	
	@Override
	public StringSeries createStringSeries() {
		
		return new CustomStringSeries();
	}
}
