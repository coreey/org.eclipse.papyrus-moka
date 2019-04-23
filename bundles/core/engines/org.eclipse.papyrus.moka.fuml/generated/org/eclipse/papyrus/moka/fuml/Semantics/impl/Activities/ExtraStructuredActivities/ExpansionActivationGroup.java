/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.ExtraStructuredActivities;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.IOutputPinActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.ExtraStructuredActivities.IExpansionActivationGroup;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.ExtraStructuredActivities.IExpansionRegionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Activities.IntermediateActivities.ActivityNodeActivationGroup;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ExpansionRegion;

public class ExpansionActivationGroup extends ActivityNodeActivationGroup implements IExpansionActivationGroup {

	/*
	 * Output pin activations corresponding, in order, to the input pins of the
	 * expansion region of this activation group.
	 */
	public List<IOutputPinActivation> regionInputs = new ArrayList<IOutputPinActivation>();

	/*
	 * Output pin activations corresponding, in order, to the input expansion
	 * nodes of the expansion region of this activation group.
	 */
	public List<IOutputPinActivation> groupInputs = new ArrayList<IOutputPinActivation>();

	/*
	 * The expansion region activation this activation group is for.
	 */
	public IExpansionRegionActivation regionActivation;

	/*
	 * Output pin activations corresponding, in order, to the output expansion
	 * nodes of the expansion region of this activation group.
	 */
	public List<IOutputPinActivation> groupOutputs = new ArrayList<IOutputPinActivation>();

	/*
	 * The index (starting at 1) of this activation group in the list held by
	 * the expansion region activation.
	 */
	public Integer index;

	@Override
	public IActivityNodeActivation getNodeActivation(ActivityNode node) {
		// If the given node is an input pin of the expansion region, then
		// return the corresponding region-input output-pin activation.
		// If the given node is an input expansion node of the expansion region,
		// then return the corresponding group-input output-pin activation.
		// If the given node is an output expansion node of the expansion
		// region, then return the corresponding group-output output-pin
		// activation.
		// Otherwise return the node activation from the activation group, as
		// usual.
		ExpansionRegion region = (ExpansionRegion) (this.regionActivation.getNode());
		// List<InputPin> inputs = region.getInputs();
		IActivityNodeActivation activation = null;
		int i = 1;
		while (activation == null & i <= region.getInputs().size()) {
			if (node == region.getInputs().get(i - 1)) {
				activation = this.regionInputs.get(i - 1);
			}
			i = i + 1;
		}
		int j = 1;
		while (activation == null & j <= region.getInputElements().size()) {
			if (node == region.getInputElements().get(j - 1)) {
				activation = this.groupInputs.get(j - 1);
			}
			j = j + 1;
		}
		int k = 1;
		while (activation == null & k <= region.getOutputElements().size()) {
			if (node == region.getOutputElements().get(k - 1)) {
				activation = this.groupOutputs.get(k - 1);
			}
			k = k + 1;
		}
		if (activation == null) {
			activation = super.getNodeActivation(node);
		}
		return activation;
	}

	@Override
	public IActivityExecution getActivityExecution() {
		// Get the activity execution that contains the expansion region
		// activation for this activation group.
		return this.regionActivation.getActivityExecution();
	}

	@Override
	public void suspend(IActivityNodeActivation activation) {
		// Suspend the given activation in this activation group. If this is
		// the only suspended activation, then suspend the associated region
		// activation.
		if (!this.isSuspended()) {
			this.regionActivation.suspend();
		}
		super.suspend(activation);
	}

	@Override
	public void resume(IActivityNodeActivation activation) {
		// Resume the given activation in this activation group. If this is the
		// last suspended activation, then resume the associated region
		// activation.
		super.resume(activation);
		if (!this.isSuspended()) {
			this.regionActivation.resume(this);
		}
	}

	public List<IOutputPinActivation> getRegionInputs() {
		return this.regionInputs;
	}

	public List<IOutputPinActivation> getGroupInputs() {
		return this.groupInputs;
	}

	public List<IOutputPinActivation> getGroupOutputs() {
		return this.groupOutputs;
	}

	public void setRegionActivation(IExpansionRegionActivation regionActivation) {
		this.regionActivation = regionActivation;
	}

	public IExpansionRegionActivation getRegionActivation() {
		return this.regionActivation;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getIndex() {
		return this.index;
	}
}
