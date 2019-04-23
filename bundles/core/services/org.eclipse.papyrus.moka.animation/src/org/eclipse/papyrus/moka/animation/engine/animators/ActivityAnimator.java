/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.animation.engine.animators;

import org.eclipse.papyrus.moka.animation.engine.rendering.AnimationKind;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.ICallActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.CompleteActions.IAcceptEventActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.IActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.utils.constants.MokaConstants;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.CallAction;
import org.eclipse.uml2.uml.InvocationAction;

public class ActivityAnimator extends Animator {

	@Override
	public void nodeVisited_(ISemanticVisitor nodeVisitor) {
		// When a node is visited by the execution engine, the following animation logic
		// applies:
		// 1] If the visitor is for an activity node then if its an accept event action
		// or a synchronous call action then the representation of this node gets the
		// ANIMATED style applied. If it is any other kind of activity node activation
		// it also gets the ANIMATED style but for a given period of time. After this 
		// period of time the VISITED style gets automatically  applied.
		// 2] If the visitor is for an object flow or a control flow then it gets the
		// ANIMTED style applied.
		if (nodeVisitor instanceof IActivityNodeActivation) {
			IActivityNodeActivation activation = (IActivityNodeActivation) nodeVisitor;
			ActivityNode activityNode = activation.getNode();
			if (activityNode != null) {
				if (activation instanceof IAcceptEventActionActivation) {
					this.engine.renderAs(activityNode, activation.getExecutionContext(), AnimationKind.ANIMATED);
				} else if (activation instanceof ICallActionActivation && ((CallAction) activityNode).isSynchronous()) {
					this.engine.renderAs(activation.getNode(), activation.getExecutionContext(),
							AnimationKind.ANIMATED);
				} else {
					this.engine.renderAs(activityNode, activation.getExecutionContext(), AnimationKind.ANIMATED,
							AnimationKind.VISITED, MokaConstants.MOKA_ANIMATION_DELAY);
				}
				if (activityNode instanceof InvocationAction) {
					this.engine.renderAs(((InvocationAction) activityNode).getOnPort(),
							activation.getExecutionContext(), AnimationKind.ANIMATED, AnimationKind.VISITED,
							MokaConstants.MOKA_ANIMATION_DELAY);
				}
			}
		} else {
			if (nodeVisitor instanceof IActivityEdgeInstance) {
				IActivityEdgeInstance edgeInstance = (IActivityEdgeInstance) nodeVisitor;
				if (edgeInstance.getEdge() != null) {
					this.engine.startRendering(edgeInstance.getEdge(),
							edgeInstance.getGroup().getActivityExecution().getContext(), AnimationKind.ANIMATED);
				}
			}
		}
	}

	@Override
	public void nodeLeft_(ISemanticVisitor nodeVisitor) {
		// When a node is left by the execution engine (i.e., the execution of this node
		// is done), the following animation logic applies:
		// 1] If the visitor is for a node that is either an accept event action or a
		// synchronous call action then the VISITED style gets applied. For any other
		// node the style remain  unchanged.
		// 2] If the visitor is for an object flow or a control flow then the VISITED
		// style gets applied.
		if (nodeVisitor instanceof IActivityNodeActivation) {
			IActivityNodeActivation activation = (IActivityNodeActivation) nodeVisitor;
			ActivityNode activityNode = activation.getNode();
			if (activityNode != null) {
				if (activation instanceof IAcceptEventActionActivation) {
					this.engine.renderAs(activation.getNode(), activation.getExecutionContext(), AnimationKind.VISITED);
				} else if (activation instanceof ICallActionActivation && ((CallAction) activityNode).isSynchronous()) {
					this.engine.renderAs(activation.getNode(), activation.getExecutionContext(), AnimationKind.VISITED);
				}
			}
		} else {
			if (nodeVisitor instanceof IActivityEdgeInstance) {
				IActivityEdgeInstance edgeInstance = (IActivityEdgeInstance) nodeVisitor;
				if (edgeInstance.getEdge() != null) {
					this.engine.renderAs(edgeInstance.getEdge(),
							edgeInstance.getGroup().getActivityExecution().getContext(), AnimationKind.VISITED);
				}
			}
		}
	}

	@Override
	public boolean accept(ISemanticVisitor visitor) {
		// If the visitor are either for activity nodes or activity edges then they can
		// be accepted
		// by this animator to perform animation.
		boolean accept = false;
		if (visitor instanceof IActivityNodeActivation) {
			accept = true;
		} else if (visitor instanceof IActivityEdgeInstance) {
			accept = true;
		}
		return accept;
	}

}
