/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.cosimulation.semantics;

import java.util.List;

import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.InvocationActions.CS_DefaultConstructStrategy;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_InteractionPoint;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_Reference;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_InteractionPoint;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Object;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Reference;
import org.eclipse.papyrus.moka.fmi.profile.util.FMIProfileUtil;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;

import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;


public class CosimulationDefaultConstructStrategy extends CS_DefaultConstructStrategy {

	@Override
	public void addStructuralFeatureValue(ICS_Reference context, Property feature, IValue value) {
		// TODO Auto-generated method stub
		IFeatureValue featureValue = context.getFeatureValue(feature);
		if (featureValue != null) {
			List<IValue> values = featureValue.getValues();
			if ((feature instanceof Port) && (FMIProfileUtil.isFMUPort(feature)) ){
				// insert an interaction point
				ICS_InteractionPoint interactionPoint = new CS_InteractionPoint();
				interactionPoint.setDefiningPort((Port) feature);
				interactionPoint.setReferent((ICS_Object) value);
				interactionPoint.setOwner(context);
				values.add(interactionPoint);
			} else if (value instanceof ICS_Object) {
				// insert a reference
				ICS_Reference reference = new CS_Reference();
				reference.setCompositeReferent((ICS_Object) value);
				reference.setReferent((ICS_Object) value);
				values.add(reference);
			} else {
				values.add(value);
			}
		}
	}



}
