/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
 *  Jeremie Tatibouet (CEA LIST) - Refine service code to avoid deadlocks when model execution starts
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.registry.service.framework;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.NotImplementedException;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Object_;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IExecution;
import org.eclipse.papyrus.moka.fuml.registry.SystemServicesRegistryUtils;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;

public abstract class AbstractService extends Object_ {

	protected HashMap<Operation, IExecution> operationExecution;

	public AbstractService(Class service) {
		super();
		this.types.add(service);
		this.operationExecution = new HashMap<Operation, IExecution>();
		this.doOperationExecutionMapping();
	}

	@Override
	public IExecution dispatch(Operation operation) {
		if (this.operationExecution.containsKey(operation)) {
			return this.operationExecution.get(operation);
		}
		throw new NotImplementedException("Not any ServiceOperationExecution implemented/registered for this operation");
	}

	public abstract void doOperationExecutionMapping();

	public abstract class ServiceOperationExecution extends OpaqueBehaviorExecution {

		protected Operation operation;

		protected Behavior behaviorSignature;

		public ServiceOperationExecution(Operation operation) {
			this.operation = operation;
		}

		@Override
		public Behavior getBehavior() {
			if (behaviorSignature == null) {
				behaviorSignature = SystemServicesRegistryUtils.getInstance().generateOpaqueBehaviorSignature(operation);
			}
			return behaviorSignature;
		}

		@Override
		public abstract void doBody(List<IParameterValue> inputParameters, List<IParameterValue> outputParameters);

		@Override
		public abstract IValue new_();
	}
}
