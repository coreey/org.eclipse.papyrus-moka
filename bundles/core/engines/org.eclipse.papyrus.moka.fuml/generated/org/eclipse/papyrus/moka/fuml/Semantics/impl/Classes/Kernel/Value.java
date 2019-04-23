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
 *  Jeremie Tatibouet (CEA LIST) - Apply fix for FUML12-33 Extensional values should have an unique identifier
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1.SemanticVisitor;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ValueSpecification;

public abstract class Value extends SemanticVisitor implements IValue {

	public abstract ValueSpecification specify();

	public boolean checkAllParents(Classifier type, Classifier classifier) {
		// Check if the given classifier matches any of the direct or indirect
		// ancestors of a given type.
		List<Classifier> directParents = type.getGenerals();
		boolean matched = false;
		int i = 1;
		while (!matched & i <= directParents.size()) {
			Classifier directParent = directParents.get(i - 1);
			if (directParent == classifier) {
				matched = true;
			} else {
				matched = this.checkAllParents(directParent, classifier);
			}
			i = i + 1;
		}
		return matched;
	}

	public boolean isInstanceOf(Classifier classifier) {
		// Check if this value has the given classifier as its type
		// or as an ancestor of one of its types.
		List<Classifier> types = this.getTypes();
		boolean isInstance = this.hasType(classifier);
		int i = 1;
		while (!isInstance & i <= types.size()) {
			isInstance = this.checkAllParents(types.get(i - 1), classifier);
			i = i + 1;
		}
		return isInstance;
	}

	public Boolean equals(IValue otherValue) {
		// Test if this value is equal to otherValue. To be equal, this value
		// must have the same type as otherValue.
		// This operation must be overridden in Value subclasses to check for
		// equality of properties defined in those subclasses.
		List<Classifier> myTypes = this.getTypes();
		List<Classifier> otherTypes = otherValue.getTypes();
		boolean isEqual = true;
		// Debug.println("[equals] Value...");
		// Debug.println("[equals] this has " + myTypes.size() +
		// "types, other has " + otherTypes.size() + ".");
		if (myTypes.size() != otherTypes.size()) {
			isEqual = false;
		} else {
			// Debug.println("[equals] " + myTypes.size() + " type(s).");
			int i = 1;
			while (isEqual & i <= myTypes.size()) {
				// Debug.println("[equals] this type = " +
				// myTypes.get(i-1).name);
				boolean matched = false;
				int j = 1;
				while (!matched & j <= otherTypes.size()) {
					// Debug.println("[equals] other type = " +
					// otherTypes.get(j-1).name);
					matched = (otherTypes.get(j - 1) == myTypes.get(i - 1));
					j = j + 1;
				}
				isEqual = matched;
				i = i + 1;
			}
		}
		return isEqual;
	}

	public IValue copy() {
		// Create a new value that is equal to this value.
		// By default, this operation simply creates a new value with empty
		// properties.
		// It must be overridden in each Value subclass to do the superclass
		// copy and then appropriately set properties defined in the subclass.
		return this.new_();
	}

	public abstract IValue new_();

	public abstract List<Classifier> getTypes();

	public Boolean hasType(Classifier type) {
		// Check if this object has the given classifier as a type.
		List<Classifier> types = this.getTypes();
		boolean found = false;
		int i = 1;
		while (!found & i <= types.size()) {
			found = (types.get(i - 1) == type);
			i = i + 1;
		}
		return found;
	}

	@Override
	public abstract String toString();
}
