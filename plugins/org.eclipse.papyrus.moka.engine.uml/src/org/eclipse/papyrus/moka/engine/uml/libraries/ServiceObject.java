/*****************************************************************************
 * Copyright (c) 2019 CEA LIST and others.
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
package org.eclipse.papyrus.moka.engine.uml.libraries;

import org.eclipse.papyrus.moka.fuml.commonbehavior.IExecution;
import org.eclipse.papyrus.moka.fuml.commonbehavior.OpaqueBehaviorExecution;
import org.eclipse.papyrus.moka.fuml.structuredclassifiers.Object_;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.UMLFactory;

public abstract class ServiceObject extends Object_ {

	public ServiceObject(Class service) {
		super();
		addType(service);
	}

	/**
	 * Return the service operation execution corresponding to the dispatched
	 * operation
	 */
	public abstract IExecution dispatch(Operation operation);

	public abstract class ServiceOperationExecution extends OpaqueBehaviorExecution {

		/**
		 * The operation for which this execution is the implementation
		 */
		protected Operation operation;

		/**
		 * Operation implementation
		 */
		private OpaqueBehavior method;

		public ServiceOperationExecution(Operation op) {
			operation = op;
		}

		@Override
		public Behavior getBehavior() {
			if (operation != null && method == null) {
				method = UMLFactory.eINSTANCE.createOpaqueBehavior();
				method.setName(operation.getName() + "Method");
				for (Parameter p : operation.getOwnedParameters()) {
					Parameter behaviorParameter = method.createOwnedParameter(p.getName(), p.getType());
					behaviorParameter.setDirection(p.getDirection());
					behaviorParameter.setLower(p.getLower());
					behaviorParameter.setUpper(p.getUpper());
				}
			}
			return method;
		}

	}

}
