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

package org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.uml2.uml.ActivityEdge;

public interface IActivityEdgeInstance extends ISemanticVisitor {

	public void sendOffer(List<IToken> tokens);

	public Integer countOfferedValues();

	public List<IToken> takeOfferedTokens();

	public List<IToken> takeOfferedTokens(Integer maxCount);

	public List<IToken> getOfferedTokens();

	public Boolean hasOffer();

	public void setSource(IActivityNodeActivation source);

	public IActivityNodeActivation getSource();

	public void setTarget(IActivityNodeActivation target);

	public IActivityNodeActivation getTarget();

	public void setGroup(IActivityNodeActivationGroup group);

	public IActivityNodeActivationGroup getGroup();

	public void setEdge(ActivityEdge edge);

	public ActivityEdge getEdge();
}
