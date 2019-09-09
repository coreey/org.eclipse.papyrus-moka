/*****************************************************************************
 * Copyright (c) 2016 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.moka.pscs.actions;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.actions.IStructuralFeatureActionActivation;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IStructuredValue;
import org.eclipse.papyrus.moka.fuml.simpleclassifiers.IValue;
import org.eclipse.papyrus.moka.pscs.structuredclassifiers.ICS_Link;
import org.eclipse.papyrus.moka.pscs.structuredclassifiers.ICS_Reference;
import org.eclipse.uml2.uml.StructuralFeature;

public interface ICS_ClearStructuralFeatureValueActionActivation extends IStructuralFeatureActionActivation {

	public List<ICS_Link> getLinksToDestroy(IStructuredValue value, StructuralFeature feature);

	public List<IValue> getPotentialLinkEnds(ICS_Reference context, StructuralFeature feature);
}
