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

package org.eclipse.papyrus.moka.fuml.Semantics.Actions.IntermediateActions;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.ILink;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuralFeature;

public interface IStructuralFeatureActionActivation extends IActionActivation {

	public Association getAssociation(StructuralFeature feature);

	public List<ILink> getMatchingLinks(Association association, StructuralFeature end, IValue oppositeValue);

	public List<ILink> getMatchingLinksForEndValue(Association association, StructuralFeature end, IValue oppositeValue, IValue endValue);

	public Property getOppositeEnd(Association association, StructuralFeature end);
}
