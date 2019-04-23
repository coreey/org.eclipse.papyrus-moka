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

package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Actions.IntermediateActions;

import org.eclipse.papyrus.moka.composites.Semantics.impl.Actions.IntermediateActions.CS_ReadSelfActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StateMachines.DoActivityContextObject;

public class SM_ReadSelfActionActivation extends CS_ReadSelfActionActivation{

	@Override
	public IObject_ getExecutionContext() {
		// The context object can be a DoActivityContextObject. A DoActivityContextObject
		// is the execution context of a doActivity behavior executed on its own thread of
		// execution. It references the context object from which the doActivity was invoked.
		// This context may contains features (e.g. operations, properties) that may be manipulated
		// by the doActivity. To enable this, in this situation the ReadSelfAction must resolve
		// to the context of the DoActivityContextObject.
		IObject_ context = super.getExecutionContext();
		if(context instanceof DoActivityContextObject){
			context = ((DoActivityContextObject)context).context;
		}
		return context;
	}
}
