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
package org.eclipse.papyrus.moka.xygraph.modelexplorer.queries;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IImage;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.infra.ui.editorsfactory.AbstractGetEditorIconQuery;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor;
import org.eclipse.papyrus.moka.xygraph.modelexplorer.Activator;

public class GetXYGraphIcon extends AbstractGetEditorIconQuery implements IJavaQuery2<XYGraphDescriptor, IImage> {

	@SuppressWarnings("serial")
	@Override
	public IImage evaluate(XYGraphDescriptor source, IParameterValueList2 parameterValues, IFacetManager facetManager) throws DerivedTypedElementException {
		return new IImage() {
			@Override
			public InputStream getInputStream() {
				try {
					return Activator.getDefault().getBundle().getEntry("/icons/full/obj16/xygraph16.gif").openStream();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
			}
		};
	}
}
