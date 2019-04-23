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
package org.eclipse.papyrus.moka.xygraph.mapping.writing;

import org.eclipse.nebula.visualization.xygraph.figures.IXYGraph;
import org.eclipse.papyrus.moka.xygraph.mapping.common.XYGraphWidgetBinder;

public interface XYGraphBuildStrategy {
	public IXYGraph buildGraph(XYGraphWidgetBinder map);
}
