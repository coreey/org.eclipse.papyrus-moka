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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.moka.xygraph.model.xygraph.XYGraphDescriptor;

public class GetContainedXYGraphs implements IJavaQuery2<EObject, Collection<XYGraphDescriptor>>{

	@Override
	public Collection<XYGraphDescriptor> evaluate(EObject source, IParameterValueList2 parameterValues,	IFacetManager facetManager) throws DerivedTypedElementException {
		List<XYGraphDescriptor> result = new ArrayList<XYGraphDescriptor>();
			
		Collection<Setting> settings = EMFHelper.getUsages(source);
		if (settings != null) {
			for (Setting setting : settings) {
				EObject usingElement = setting.getEObject();
				if (usingElement instanceof XYGraphDescriptor) {
					XYGraphDescriptor xyGraph = (XYGraphDescriptor) usingElement;
					EObject parent = xyGraph.getContext();
					if (parent == source) {
						result.add(xyGraph);
					}
				}
			}
		}
		return result;
	}
}
