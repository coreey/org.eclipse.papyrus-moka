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
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.CompleteActions;

import java.util.ArrayList;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.BasicActions.ActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Reference;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.StartClassifierBehaviorAction;

public class StartClassifierBehaviorActionActivation extends ActionActivation {

	@Override
	public void doAction() {
		// Get the value on the object input pin. If it is not a reference, then
		// do nothing.
		// Start the classifier behavior of the referent object for the
		// classifier given as the type of the object input pin.
		// If the object input pin has no type, then start the classifier
		// behaviors of all types of the referent object. [The required behavior
		// in this case is not clear from the spec.]
		StartClassifierBehaviorAction action = (StartClassifierBehaviorAction) (this.node);
		IValue object = this.takeTokens(action.getObject()).get(0);
		if (object instanceof Reference) {
			((Reference) object).startBehavior((Class) (action.getObject().getType()), new ArrayList<IParameterValue>());
		}
	}
}
