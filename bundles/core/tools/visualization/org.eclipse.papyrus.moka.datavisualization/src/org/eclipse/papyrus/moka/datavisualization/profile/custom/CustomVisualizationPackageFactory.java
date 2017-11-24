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

import org.eclipse.papyrus.moka.datavisualization.profile.BooleanSeries;
import org.eclipse.papyrus.moka.datavisualization.profile.DataSource;
import org.eclipse.papyrus.moka.datavisualization.profile.DataSourceInstance;
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
	public DataSourceInstance createDataSourceInstance() {
		return new CustomDataSourceInstance();
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
