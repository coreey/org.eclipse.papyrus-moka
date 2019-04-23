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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.properties.ui.modelelement.EMFModelElement;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor;

public class XYGraphModelElement extends EMFModelElement{

	public XYGraphModelElement(EObject source, EditingDomain domain) {
		super(source, domain);
	}

	@Override
	public IStaticContentProvider getContentProvider(String propertyPath) {
		if( "visibleTraces".equalsIgnoreCase(propertyPath) )
			return new VisibleTracesContentProvider((XYGraphDescriptor)getSource());

		return super.getContentProvider(propertyPath);
	}
}
