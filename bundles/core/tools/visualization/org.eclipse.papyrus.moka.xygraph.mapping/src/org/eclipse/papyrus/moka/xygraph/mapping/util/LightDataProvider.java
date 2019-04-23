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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.nebula.visualization.xygraph.dataprovider.AbstractDataProvider;
import org.eclipse.nebula.visualization.xygraph.dataprovider.ISample;
import org.eclipse.nebula.visualization.xygraph.linearscale.Range;

public class LightDataProvider extends AbstractDataProvider {
	
	private List<Double> xValues, yValues;
	private List<LightDataSample> samples = new ArrayList<>();
	
	private TraceDataBounds bounds;
	
	public LightDataProvider(boolean chronological) {
		super(chronological);
		bounds = new TraceDataBounds();
	}

	public void setDataList(List<Double> xl, List<Double> yl) {
		
		if (xl.size() == 0)
			return;
		
		this.xValues = xl;
		this.yValues = yl;
		
		if (samples.size() != 0)
			samples.clear();

		samples = new ArrayList<LightDataSample>();

		bounds.reset();

		for (int i = 0; i < xl.size(); i++) {

			double x = xl.get(i);
			double y = yl.get(i);

			bounds.addSample(x, y);
			samples.add(new LightDataSample(this, i));
		}
		xDataMinMax = new Range(bounds.getxMin(), bounds.getxMax());
		yDataMinMax = new Range(bounds.getyMin(), bounds.getyMax());

		fireDataChange();

	}

	@Override
	public int getSize() {
		return samples.size();
	}

	@Override
	public ISample getSample(int index) {
		return samples.get(index);
	}
	
	//TODO Careful ! The values are supposed to be already inside the 
	//buffers. Only update the ranges and add the sample.
	//This hasn't been tested
	public void addSample(double x, double y) {

		double newLowerX = Math.min(xDataMinMax.getLower(), x);
		double newUpperX = Math.max(xDataMinMax.getUpper(), x);

		double newLowerY = Math.min(yDataMinMax.getLower(), y);
		double newUpperY = Math.max(yDataMinMax.getUpper(), y);

		if (newLowerX != xDataMinMax.getLower() || newUpperX != xDataMinMax.getUpper())
			xDataMinMax = new Range(newLowerX, newUpperX);

		if (newLowerY != yDataMinMax.getLower() || newUpperY != yDataMinMax.getUpper())
			yDataMinMax = new Range(newLowerY, newUpperY);

		int index = getSize();
		samples.add(new LightDataSample(this, index));
		
		fireDataChange();

	}

	public double getXValue(int index) {
		return xValues.get(index);
	}

	public double getYValue(int index) {
		return yValues.get(index);
	}

	public void clear() {
		samples.clear();
		xValues = null;
		yValues = null;
	}

	public TraceDataBounds getBounds() {
		return bounds;
	}

}
