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

package org.eclipse.papyrus.moka.fuml.Semantics.Activities.ExtraStructuredActivities;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IOutputPinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivationGroup;

public interface IExpansionActivationGroup extends IActivityNodeActivationGroup {

	public List<IOutputPinActivation> getRegionInputs();

	public List<IOutputPinActivation> getGroupInputs();

	public List<IOutputPinActivation> getGroupOutputs();

	public void setRegionActivation(IExpansionRegionActivation regionActivation);

	public IExpansionRegionActivation getRegionActivation();

	public void setIndex(Integer index);

	public Integer getIndex();
}
