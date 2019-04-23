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
package org.eclipse.papyrus.moka.xygraph.properties.modelelement;

import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.papyrus.infra.widgets.providers.IGraphicalContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class VisibleTracesContentProvider implements IStaticContentProvider, IGraphicalContentProvider{
	
	private XYGraphDescriptor xyDesc;
	
	public VisibleTracesContentProvider(XYGraphDescriptor xyDesc) {
		super();
		this.xyDesc = xyDesc;
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return getElements();
	}

	@Override
	public Object[] getElements() {
		return xyDesc.getTraceDescriptors().toArray();
	}

	@Override
	public void createBefore(Composite parent) {
		Label label = new Label(parent, SWT.NONE);
		FontDescriptor boldDescriptor = FontDescriptor.createFrom(label.getFont()).setStyle(SWT.BOLD);
		Font boldFont = boldDescriptor.createFont(label.getDisplay());
		label.setFont( boldFont );
		label.setText("Hidden");
	}

	@Override
	public void createAfter(Composite parent) {
		
	}
}
