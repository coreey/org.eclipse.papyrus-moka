/*****************************************************************************
 * Copyright (c) 2017, 2019 CEA LIST.
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
 *  CEA LIST - Bug 551906
 *   
 *****************************************************************************/
package org.eclipse.papyrus.moka.engine.uml.animation.animators;

import org.eclipse.papyrus.moka.animation.engine.rendering.AnimationKind;
import org.eclipse.papyrus.moka.fuml.loci.ISemanticVisitor;
import org.eclipse.papyrus.moka.pssm.statemachines.ITransitionActivation;
import org.eclipse.papyrus.moka.pssm.statemachines.IVertexActivation;

public class StateMachineAnimator extends UMLAnimator {

	@Override
	public void nodeVisited_(ISemanticVisitor nodeVisitor) {
		// When the visitor is for a visited state machine model element the following
		// animation logic applies.
		// 1] If the visitor is for a transition then the ANIMATED style gets applied
		// 2] If the visitor is for a vertex then the ANIMATED style gets applied
		if (nodeVisitor instanceof ITransitionActivation) {
			ITransitionActivation transitionActivation = (ITransitionActivation) nodeVisitor;
			if (transitionActivation.getNode() != null) {
				this.engine.renderAs(transitionActivation.getNode(), transitionActivation.getExecutionContext(),
						AnimationKind.ANIMATED);
			}
		} else {
			if (nodeVisitor instanceof IVertexActivation) {
				IVertexActivation vertexActivation = (IVertexActivation) nodeVisitor;
				if (vertexActivation.getNode() != null) {
					this.engine.renderAs(vertexActivation.getNode(), vertexActivation.getExecutionContext(),
							AnimationKind.ANIMATED);
				}
			}
		}
	}

	@Override
	public void nodeLeft_(ISemanticVisitor nodeVisitor) {
		// When the visitor is for a left state machine model element the following
		// animation logic applies.
		// 1] If the visitor is for a transition then the VISITED style gets applied
		// 2] If the visitor is for a vertex then the VISITED style gets applied
		if (nodeVisitor instanceof ITransitionActivation) {
			ITransitionActivation transitionActivation = (ITransitionActivation) nodeVisitor;
			if (transitionActivation.getNode() != null) {
				this.engine.renderAs(transitionActivation.getNode(), transitionActivation.getExecutionContext(),
						AnimationKind.VISITED);
			}
		} else {
			if (nodeVisitor instanceof IVertexActivation) {
				IVertexActivation vertexActivation = (IVertexActivation) nodeVisitor;
				if (vertexActivation.getNode() != null) {
					this.engine.renderAs(vertexActivation.getNode(), vertexActivation.getExecutionContext(),
							AnimationKind.VISITED);
				}
			}
		}
	}

	@Override
	public void nodeSuspended_(ISemanticVisitor nodeVisitor) {
		// When the visitor is for a suspended state machine model element the following
		// animation logic applies.
		// 1] If the visitor is for a transition then the SUSPENDED style gets applied
		// 2] If the visitor is for a vertex then the SUSPENDED style gets applied
		if (nodeVisitor instanceof ITransitionActivation) {
			ITransitionActivation transitionActivation = (ITransitionActivation) nodeVisitor;
			if (transitionActivation.getNode() != null) {
				this.engine.renderAs(transitionActivation.getNode(), transitionActivation.getExecutionContext(),
						AnimationKind.SUSPENDED);
			}
		} else {
			if (nodeVisitor instanceof IVertexActivation) {
				IVertexActivation vertexActivation = (IVertexActivation) nodeVisitor;
				if (vertexActivation.getNode() != null) {
					this.engine.renderAs(vertexActivation.getNode(), vertexActivation.getExecutionContext(),
							AnimationKind.SUSPENDED);
				}
			}
		}
	}

	@Override
	public boolean accept(Object object) {
		// If the visitor is either for a transition or a vertex then it can be accepted
		// by this animator to perform animation.
		if (object instanceof ITransitionActivation || object instanceof IVertexActivation) {
			return true;
		}
		return false;
	}

}
