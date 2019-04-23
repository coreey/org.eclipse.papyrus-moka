/*****************************************************************************
 * Copyright (c) 2017 CEA LIST and others.
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

package org.eclipse.papyrus.moka.animation.engine.animators;

import java.util.Iterator;

import org.eclipse.papyrus.moka.animation.engine.rendering.AnimationKind;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_InteractionPoint;
import org.eclipse.papyrus.moka.composites.interfaces.extensions.Semantics.CompositeStructures.StructuredClasses.ICS_ConnectorLink;
import org.eclipse.papyrus.moka.fuml.Profiling.Semantics.Kernel.Classes.IFeatureValueWrapper;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IExtensionalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ISemanticVisitor;
import org.eclipse.papyrus.moka.utils.constants.MokaConstants;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Type;

public class StructuralAnimator extends Animator {

	@Override
	public void nodeVisited_(ISemanticVisitor nodeVisitor) {
		if (nodeVisitor instanceof ICS_InteractionPoint) {
			// The visitor is for a port. A port is visited when a event occurrence
			// or an operation call flows in or out of the port
			this.engine.renderAs(((ICS_InteractionPoint) nodeVisitor).getDefiningPort(),
					((ICS_InteractionPoint) nodeVisitor).getOwner().getReferent(), AnimationKind.ANIMATED,
					AnimationKind.VISITED, MokaConstants.MOKA_ANIMATION_DELAY);
		} else if (nodeVisitor instanceof ICS_ConnectorLink) {
			// The visitor is for a connector. A connector is visited when an event
			// occurrence or an operation call flows on the connector
			this.engine.renderAs(((ICS_ConnectorLink) nodeVisitor).getConnector(), null, AnimationKind.ANIMATED,
					AnimationKind.VISITED, MokaConstants.MOKA_ANIMATION_DELAY);
		} else if (nodeVisitor instanceof IFeatureValueWrapper) {
			// The visitor is for a feature value. A feature value is visited when
			// a value is added in its set of value through the PSCS default construct
			// strategy.
			IFeatureValueWrapper featureValue = (IFeatureValueWrapper) nodeVisitor;
			this.engine.renderAs(featureValue.getFeature(), featureValue.getContext(), AnimationKind.VISITED);
		}
	}

	@Override
	public void stepStart(IReference context) {
		// This method is triggered by the beginning of a RTC step in an active
		// object. It ensures that upon the beginning of the step, active classes
		// typing this object are animated. It also make sure that any feature
		// of other object referencing the object performing the step are animated.
		IObject_ referent = context.getReferent();
		if (referent != null) {
			for (Type type : referent.getTypes()) {
				if (type instanceof Class && ((Class) type).isActive()) {
					this.engine.renderAs(type, referent, AnimationKind.ANIMATED);
				}
			}
			ILocus locus = referent.getLocus();
			if (locus != null) {
				Iterator<IExtensionalValue> extensionalValueIterator = locus.getExtensionalValues().iterator();
				while (extensionalValueIterator.hasNext()) {
					IExtensionalValue extensionalValue = extensionalValueIterator.next();
					if (extensionalValue instanceof IObject_ && !referent.getFeatureValues().isEmpty()) {
						for (IFeatureValue featureValue : (((IObject_) extensionalValue).getFeatureValues())) {
							Iterator<IValue> valueIterator = featureValue.getValues().iterator();
							boolean found = false;
							while (!found && valueIterator.hasNext()) {
								found = valueIterator.next().equals(context);
							}
							if (found) {
								this.engine.renderAs(featureValue.getFeature(), (IObject_) extensionalValue,
										AnimationKind.ANIMATED);
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void stepEnd(IReference context) {
		// This method is triggered by the end of a RTC step in an active object.
		// It ensures that when the step end, any active class typing the object
		// is marked as being visited. In addition, it makes sure that any feature
		// referencing the object performing the step is marked as being visited.
		IObject_ referent = context.getReferent();
		if (referent != null) {
			for (Type type : referent.getTypes()) {
				if (type instanceof Class && ((Class) type).isActive()) {
					this.engine.renderAs(type, referent, AnimationKind.VISITED);
				}
			}
			ILocus locus = referent.getLocus();
			if (locus != null) {
				Iterator<IExtensionalValue> extensionalValueIterator = locus.getExtensionalValues().iterator();
				while (extensionalValueIterator.hasNext()) {
					IExtensionalValue extensionalValue = extensionalValueIterator.next();
					if (extensionalValue instanceof IObject_ && !referent.getFeatureValues().isEmpty()) {
						for (IFeatureValue featureValue : ((IObject_) extensionalValue).getFeatureValues()) {
							Iterator<IValue> valueIterator = featureValue.getValues().iterator();
							boolean found = false;
							while (!found && valueIterator.hasNext()) {
								found = valueIterator.next().equals(context);
							}
							if (found) {
								this.engine.renderAs(featureValue.getFeature(), (IObject_) extensionalValue,
										AnimationKind.VISITED);
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void valueCreated(IValue value) {
		// When a value is created and this value is an object then all
		// classifiers typing this object are marked as being visited
		if(value instanceof IObject_) {
			for(Classifier classifier : ((IObject_)value).getTypes()) {
				this.engine.renderAs(classifier, (IObject_)value, AnimationKind.VISITED);
			}
		}
	}

	@Override
	public void valueDestroyed(IValue value) {
		// When a value is destroyed and this value is an object then all
		// classifiers typing this object are freed from any rendering
		// constraints (i.e., any ongoing animation gets stopped). This only
		// apply if no instance of the classifier can be found at the locus.
		if(value instanceof IObject_) {
			for(Classifier classifier : ((IObject_)value).getTypes()) {
				ILocus locus = ((IObject_)value).getLocus();
				if(locus != null && locus.getExtent(classifier).isEmpty()) {
					this.engine.removeRenderingRules(classifier);
				}
			}
		}
	}

	@Override
	public void nodeLeft_(ISemanticVisitor nodeVisitor) {
		// Do nothing
	}

	@Override
	public boolean accept(ISemanticVisitor visitor) {
		// The composite animator enables the following nodes to be animated:
		// any feature value with newly associated value, connector and send signal
		// action with the 'onPort' property specified.
		if (visitor instanceof ICS_InteractionPoint) {
			return true;
		} else if (visitor instanceof ICS_ConnectorLink) {
			return true;
		} else if (visitor instanceof IFeatureValue) {
			return true;
		} else if (visitor instanceof IObject_) {
			return true;
		} else if (visitor instanceof IReference) {
			return true;
		}
		return false;
	}

}
