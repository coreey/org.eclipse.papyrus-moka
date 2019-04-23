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
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.ICallEventBehavior;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.CallEventBehavior;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1.SemanticStrategy;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Operation;

public abstract class DispatchStrategy extends SemanticStrategy {

	@Override
	public String getName() {
		// Dispatch strategies are always named "dispatch".
		return "dispatch";
	}

	public IExecution dispatch(IObject_ object, Operation operation) {
		// Get the behavior for the given operation as determined by the type(s)
		// of the given object, compile the behavior at the locus of the object,
		// and return the resulting execution object.
		return object.getLocus().getFactory().createExecution(this.getMethod(object, operation), object);
	}

	public Behavior getMethod(IObject_ object, Operation operation) {
		// Get the method that corresponds to the given operation for the given object.
		// By default, the operation is treated as being called via a call event occurrence,
		// with a call even behavior as its effective method. Concrete dispatch strategy
		// subclasses may override this default to provide other dispatching behavior.
		ICallEventBehavior method = new CallEventBehavior();
		method.setOperation(operation);
		return method;
	}
}
