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
package org.eclipse.papyrus.moka.xygraph.mapping.writing.impl;

import org.eclipse.nebula.visualization.xygraph.figures.Trace;
import org.eclipse.papyrus.moka.xygraph.model.reflection.TraceStructuralFeature;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor;
import org.eclipse.papyrus.moka.xygraph.mapping.common.XYGraphWidgetBinder;
import org.eclipse.papyrus.moka.xygraph.mapping.writing.TraceUpdateStrategy;

public class DefaultTraceUpdateStrategy implements TraceUpdateStrategy{

	@Override
	public void updateTraceDescriptor(Trace trace, XYGraphWidgetBinder map) {
		updateAllFeatures(trace, map);
	}

	@Override
	public <T> void updateTraceFeature(TraceDescriptor tDesc, TraceStructuralFeature field, T newValue) {
		tDesc.eSet(field.getEStructuralFeature(), newValue);
	}

	@Override
	public void commitUpdate() {
		
	}
}
