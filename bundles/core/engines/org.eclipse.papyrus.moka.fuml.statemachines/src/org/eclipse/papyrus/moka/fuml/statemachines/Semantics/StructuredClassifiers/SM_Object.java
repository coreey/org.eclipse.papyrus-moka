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
 *  Jeremie Tatibouet (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StructuredClassifiers;

import java.util.List;

import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_Object;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.CommonBehavior.SM_ObjectActivation;
import org.eclipse.uml2.uml.Class;

public class SM_Object extends CS_Object {
	
	public void startBehavior(Class classifier, List<IParameterValue> inputs){
		// The behavior captured here is almost identical to the one provide by Object_.
		// Instead of using a simple ObjectActivation we use a StateMachineObjectActivation.
		// This specialized kind of ObjectActivation allows the registering of completion events.
		if (this.objectActivation == null) {
			this.objectActivation = new SM_ObjectActivation();
			this.objectActivation.setObject(this);
		}
		this.objectActivation.startBehavior(classifier, inputs);
	}
	
	@Override
	public void destroy() {
		// In addition to realize the normal process of stopping the object activation
		// as well as removing the current object from the locus, this destruction phase
		// also implies removal of all events remaining in the pool. This prevents the
		// dispatch loop to actually get the next event (even if at this step there is no
		// chance to match an accepter) whereas the current object is not anymore registered.
		// in the Locus.
		if(this.objectActivation!=null){
			this.objectActivation.getEvents().clear();
		}
		super.destroy();
	}

}
