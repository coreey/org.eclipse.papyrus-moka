/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.moka.composites.Semantics.impl.CommonBehaviors.Communications;

// Imports
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.RedefinitionBasedDispatchStrategy;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;


public class CS_DispatchOperationOfInterfaceStrategy extends RedefinitionBasedDispatchStrategy {

	@Override
	public Boolean operationsMatch(Operation ownedOperation, Operation baseOperation) {
		// Override operationsMatch, in the case where baseOperation belongs
		// to an Interface.
		// In this case, ownedOperation matches baseOperation if it has the same name and signature
		// Otherwise, behaves like fUML RedefinitionBasedDispatchStrategy
		boolean matches = true;
		if (baseOperation.getNamespace() instanceof Interface) {
			matches = (baseOperation.getName().equals(ownedOperation.getName()));
			matches = matches && (baseOperation.getOwnedParameters().size() == ownedOperation.getOwnedParameters().size());
			List<Parameter> ownedOperationParameters = ownedOperation.getOwnedParameters();
			List<Parameter> baseOperationParameters = baseOperation.getOwnedParameters();
			for (int i = 0; matches == true && i < ownedOperationParameters.size(); i++) {
				Parameter ownedParameter = ownedOperationParameters.get(i);
				Parameter baseParameter = baseOperationParameters.get(i);
				matches = (ownedParameter.getType() == baseParameter.getType());
				matches = matches && (ownedParameter.getLower() == ownedParameter.getLower());
				matches = matches && (ownedParameter.getUpper() == ownedParameter.getUpper());
				matches = matches && (ownedParameter.getDirection() == ownedParameter.getDirection());
			}
		} else {
			matches = super.operationsMatch(ownedOperation, baseOperation);
		}

		return matches;
	}
}
