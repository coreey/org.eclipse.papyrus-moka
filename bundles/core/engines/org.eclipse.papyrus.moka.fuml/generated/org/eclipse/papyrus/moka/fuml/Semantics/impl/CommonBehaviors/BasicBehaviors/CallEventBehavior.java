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

package org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.BasicBehaviors;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.ICallEventBehavior;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.internal.impl.BehaviorImpl;

@SuppressWarnings("restriction")
public class CallEventBehavior extends BehaviorImpl implements ICallEventBehavior{

	public Operation operation;
	
	public void setOperation(Operation operation){
		// Set the operation for this call event behavior and construct
		// the behavior signature based on the operation signature.
		this.operation = operation;
		for(int i = 0; i < operation.getOwnedParameters().size(); i++){
			Parameter operationParameter = operation.getOwnedParameters().get(i);
			Parameter parameter = UMLFactory.eINSTANCE.createParameter();
			parameter.setName(operationParameter.getName());
			parameter.setType(operationParameter.getType());
			parameter.setLower(operationParameter.getLower());
			parameter.setUpper(operationParameter.getUpper());
			parameter.setDirection(operationParameter.getDirection());
			this.getOwnedParameters().add(parameter);
		}
		this.setIsReentrant(true);
	}

	@Override
	public Operation getOperation() {
		return this.operation;
	}
	
}