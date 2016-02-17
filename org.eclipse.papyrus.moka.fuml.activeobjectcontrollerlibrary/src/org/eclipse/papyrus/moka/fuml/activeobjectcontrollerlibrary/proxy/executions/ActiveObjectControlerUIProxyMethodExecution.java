/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.moka.fuml.activeobjectcontrollerlibrary.proxy.executions;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution;
import org.eclipse.uml2.uml.Operation;

public abstract class ActiveObjectControlerUIProxyMethodExecution extends OpaqueBehaviorExecution {

	protected Operation operation;

	public ActiveObjectControlerUIProxyMethodExecution(Operation operation, IObject_ context) {
		this.operation = operation;
		this.context = context;
	}

}
