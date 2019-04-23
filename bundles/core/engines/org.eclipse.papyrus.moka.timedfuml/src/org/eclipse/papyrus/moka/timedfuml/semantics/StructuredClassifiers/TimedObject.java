/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
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
 *  CEA LIST Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.moka.timedfuml.semantics.StructuredClassifiers;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StructuredClassifiers.SM_Object;
import org.eclipse.papyrus.moka.timedfuml.semantics.CommonBehaviors.TimedObjectActivation;
import org.eclipse.uml2.uml.Class;

public class TimedObject extends SM_Object{

	@Override
	public void startBehavior(Class classifier, List<IParameterValue> inputs) {
		///The behavior captured here is almost identical to the one provide by SM_Object.
		// Instead of using a simple ObjectActivation we use a TimedObjectActivation.
		// This specialized kind of ObjectActivation allows the registering of time events.
		if (this.objectActivation == null) {
			this.objectActivation = new TimedObjectActivation();
			this.objectActivation.setObject(this);
		}
		this.objectActivation.startBehavior(classifier, inputs);
	}
	
}
