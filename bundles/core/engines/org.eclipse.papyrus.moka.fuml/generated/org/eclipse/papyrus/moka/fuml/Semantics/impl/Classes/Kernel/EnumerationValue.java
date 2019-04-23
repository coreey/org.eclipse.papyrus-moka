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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IEnumerationValue;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;

public class EnumerationValue extends Value implements IEnumerationValue {

	/*
	 * The literal value of this enumeration value.
	 */
	public EnumerationLiteral literal;

	public Enumeration type;

	@Override
	public ValueSpecification specify() {
		// Return an instance value with literal as the instance.
		InstanceValue instanceValue = UMLFactory.eINSTANCE.createInstanceValue();
		// InstanceSpecification instance =
		// UMLFactory.eINSTANCE.createInstanceSpecification();
		instanceValue.setType(this.type);
		instanceValue.setInstance(this.literal);
		return instanceValue;
	}

	@Override
	public Boolean equals(IValue otherValue) {
		// Test if this enumeration value is equal to the otherValue.
		// To be equal, the otherValue must also be an enumeration value with
		// the same literal as this enumeration value.
		boolean isEqual = false;
		if (otherValue instanceof EnumerationValue) {
			isEqual = ((EnumerationValue) otherValue).literal == this.literal;
		}
		return isEqual;
	}

	@Override
	public IValue copy() {
		// Create a new enumeration value with the same literal as this
		// enumeration value.
		EnumerationValue newValue = (EnumerationValue) (super.copy());
		newValue.type = this.type;
		newValue.literal = this.literal;
		return newValue;
	}

	@Override
	public IValue new_() {
		// Create a new enumeration value with no literal.
		return new EnumerationValue();
	}

	@Override
	public List<Classifier> getTypes() {
		// Return the single type of this enumeration value.
		List<Classifier> types = new ArrayList<Classifier>();
		types.add(this.type);
		return types;
	}

	@Override
	public String toString() {
		return literal.getName();
	}

	@Override
	public EnumerationLiteral getLiteral() {
		return literal;
	}

	@Override
	public void setLiteral(EnumerationLiteral literal) {
		this.literal = literal;
	}

	@Override
	public Enumeration getType() {
		return type;
	}

	@Override
	public void setType(Enumeration type) {
		this.type = type;
	}
}
