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

import org.eclipse.papyrus.moka.xygraph.mapping.writing.AxisUpdateStrategy;
import org.eclipse.papyrus.moka.xygraph.mapping.writing.TraceUpdateStrategy;
import org.eclipse.papyrus.moka.xygraph.mapping.writing.XYGraphUpdateStrategy;
import org.eclipse.papyrus.moka.xygraph.mapping.writing.impl.DefaultModelWritingStrategyFactory;


public class ResourceWriteStrategyFactory extends DefaultModelWritingStrategyFactory{
	
	private ResourceAxisUpdateStrategy axisUpdateStrategy;
	private ResourceTraceUpdateStrategy traceUpdateStrategy;
	private ResourceXYGraphUpdateStrategy xyGraphUpdateStrategy;
	
	public ResourceWriteStrategyFactory() {
	}
	
	@Override
	public AxisUpdateStrategy getAxisUpdateStrategy() {
		if( axisUpdateStrategy == null )
			axisUpdateStrategy = new ResourceAxisUpdateStrategy();
		
		return axisUpdateStrategy;
	}

	@Override
	public TraceUpdateStrategy getTraceUpdateStrategy() {
		if( traceUpdateStrategy == null )
			traceUpdateStrategy = new ResourceTraceUpdateStrategy();
		
		return traceUpdateStrategy;
	}

	@Override
	public XYGraphUpdateStrategy getXYGraphUpdateStrategy() {
		if( xyGraphUpdateStrategy == null )
			xyGraphUpdateStrategy = new ResourceXYGraphUpdateStrategy();
		
		return xyGraphUpdateStrategy;
	}
}
