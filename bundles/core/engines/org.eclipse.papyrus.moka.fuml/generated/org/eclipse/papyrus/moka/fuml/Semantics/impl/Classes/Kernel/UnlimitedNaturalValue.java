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

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IUnlimitedNaturalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;

public class UnlimitedNaturalValue extends PrimitiveValue implements IUnlimitedNaturalValue {

	/*
	 * The actual unlimited natural value.
	 */
	public Integer value;

	public Object getUnderlying() {
		return this.value;
	}

	@Override
	public ValueSpecification specify() {
		// Return a literal unlimited natural with the value of this unlimited
		// natural value.
		LiteralUnlimitedNatural literal = UMLFactory.eINSTANCE.createLiteralUnlimitedNatural();
		literal.setType(this.type);
		literal.setValue(this.value);
		return literal;
	}

	@Override
	public Boolean equals(IValue otherValue) {
		// Test if this unlimited natural value is equal to the otherValue.
		// To be equal, the otherValue must have the same value as this
		// unlimited natural value.
		boolean isEqual = false;
		if (otherValue instanceof UnlimitedNaturalValue) {
			isEqual = ((UnlimitedNaturalValue) otherValue).value.equals(this.value); // CHANGED == to equals
		}
		return isEqual;
	}

	@Override
	public IValue copy() {
		// Create a new unlimited natural value with the same value as this
		// value.
		UnlimitedNaturalValue newValue = (UnlimitedNaturalValue) (super.copy());
		newValue.value = this.value;
		return newValue;
	}

	@Override
	public IValue new_() {
		// Create a new unlimited natural value with no value.
		return new UnlimitedNaturalValue();
	}

	@Override
	public String toString() {
		String stringValue = "*";
		if (this.value >= 0) {
			IntegerValue integerValue = new IntegerValue();
			integerValue.value = this.value;
			stringValue = integerValue.toString();
		}
		return stringValue;
	}


	@Override
	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public Integer getValue() {
		return this.value;
	}
}
