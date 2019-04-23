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

public class TraceDataBounds {
	private double xMin, yMin, xMax, yMax;
	
	public TraceDataBounds() {
		reset();
	}

	public void reset(){
		yMin = xMin = Double.POSITIVE_INFINITY;
		yMax = xMax = Double.NEGATIVE_INFINITY;
		
	}
	
	public void addSample(double x, double y){
		xMax = Math.max(xMax, x);
		yMax = Math.max(yMax, y);
		xMin = Math.min(xMin, x);
		yMin = Math.min(yMin, y);
	}
	
	public void union( TraceDataBounds o ){
		xMax = Math.max(xMax, o.xMax);
		yMax = Math.max(yMax, o.yMax);
		xMin = Math.min(xMin, o.xMin);
		yMin = Math.min(yMin, o.yMin);
	}
	
	public double getxMin() {
		return xMin;
	}

	public void setxMin(double xMin) {
		this.xMin = xMin;
	}

	public double getyMin() {
		return yMin;
	}

	public void setyMin(double yMin) {
		this.yMin = yMin;
	}

	public double getxMax() {
		return xMax;
	}

	public void setxMax(double xMax) {
		this.xMax = xMax;
	}

	public double getyMax() {
		return yMax;
	}

	public void setyMax(double yMax) {
		this.yMax = yMax;
	}
}
