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
package org.eclipse.papyrus.moka.datavisualization.ui;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.TraceDescriptor;
import org.eclipse.swt.graphics.Image;

public class XYGraphFilteredLabelProvider implements IFilteredLabelProvider {

	public XYGraphFilteredLabelProvider() {
	}

	@Override
	public Image getImage(Object element) {
		return null;
	}

	@Override
	public String getText(Object element) {
		if( element instanceof TraceDescriptor )
			return ((TraceDescriptor)element).getName();
		return null;
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		
	}

	@Override
	public boolean accept(Object element) {
		if( element instanceof TraceDescriptor )
			return true;
		
		return false;
	}
}
