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

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;

public class RedefinitionBasedDispatchStrategy extends DispatchStrategy {

	@Override
	public Behavior getMethod(IObject_ object, Operation operation) {
		// Find the member operation of a type of the given object that
		// is the same as or a redefinition of the given operation. Then
		// return the method of that operation, if it has one, otherwise
		// return a CallEventBehavior as the effective method for the
		// matching operation.
		// [If there is more than one type with a matching operation, then
		// the first one is arbitrarily chosen.]
		Behavior method = null;
		int i = 1;
		while (method == null & i <= object.getTypes().size()) {
			Class type = (Class) object.getTypes().get(i - 1);
			List<NamedElement> members = type.getMembers();
			int j = 1;
			while (method == null & j <= members.size()) {
				NamedElement member = members.get(j - 1);
				if (member instanceof Operation) {
					Operation memberOperation = (Operation) member;
					if (this.operationsMatch(memberOperation, operation)) {
						if (memberOperation.getMethods().size() == 0) {
							method = super.getMethod(object, memberOperation);
						} else {
							method = memberOperation.getMethods().get(0);
						}
					}
				}
				j = j + 1;
			}
			i = i + 1;
		}
		return method;
	}

	public Boolean operationsMatch(Operation ownedOperation, Operation baseOperation) {
		// Check if the owned operation is equal to or a redefinition (directly
		// or indirectly) of the base operation.
		boolean matches = false;
		if (ownedOperation == baseOperation) {
			matches = true;
		} else {
			int i = 1;
			while (!matches & i <= ownedOperation.getRedefinedOperations().size()) {
				matches = this.operationsMatch(ownedOperation.getRedefinedOperations().get(i - 1), baseOperation);
				i = i + 1;
			}
		}
		return matches;
	}
}
