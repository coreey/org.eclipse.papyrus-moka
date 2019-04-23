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

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IIntegerValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;

public class IntegerValue extends PrimitiveValue implements IIntegerValue {

	/*
	 * The actual Integer value.
	 */
	public Integer value;

	public Object getUnderlying() {
		return this.value;
	}

	@Override
	public ValueSpecification specify() {
		// Return a literal integer with the value of this integer value.
		LiteralInteger literal = UMLFactory.eINSTANCE.createLiteralInteger();
		literal.setType(this.type);
		literal.setValue(this.value);
		return literal;
	}

	@Override
	public Boolean equals(IValue otherValue) {
		// Test if this integer value is equal to the otherValue.
		// To be equal, the otherValue must have the same value as this integer
		// value.
		boolean isEqual = false;
		if (otherValue instanceof IntegerValue) {
			isEqual = ((IntegerValue) otherValue).value.equals(this.value); // CHANGED == to equals
		}
		return isEqual;
	}

	@Override
	public Value copy() {
		// Create a new integer value with the same value as this integer value.
		IntegerValue newValue = (IntegerValue) (super.copy());
		newValue.value = this.value;
		return newValue;
	}

	@Override
	public Value new_() {
		// Create a new integer value with no value.
		return new IntegerValue();
	}

	@Override
	public String toString() {
		String stringValue = "";
		if (this.value == 0) {
			stringValue = "0";
		} else {
			int positiveValue = this.value;
			if (positiveValue < 0) {
				positiveValue = -positiveValue;
			}
			do {
				int digit = positiveValue % 10;
				if (digit == 0) {
					stringValue = "0" + stringValue;
				} else if (digit == 1) {
					stringValue = "1" + stringValue;
				} else if (digit == 2) {
					stringValue = "2" + stringValue;
				} else if (digit == 3) {
					stringValue = "3" + stringValue;
				} else if (digit == 4) {
					stringValue = "4" + stringValue;
				} else if (digit == 5) {
					stringValue = "5" + stringValue;
				} else if (digit == 6) {
					stringValue = "6" + stringValue;
				} else if (digit == 7) {
					stringValue = "7" + stringValue;
				} else if (digit == 8) {
					stringValue = "8" + stringValue;
				} else if (digit == 9) {
					stringValue = "9" + stringValue;
				}
				positiveValue = positiveValue / 10;
			} while (positiveValue > 0);
			if (this.value < 0) {
				stringValue = "-" + stringValue;
			}
		}
		return stringValue;
	}

	@Override
	public Integer getValue() {
		return this.value;
	}
	
	@Override
	public void setValue(Integer value) {
		this.value = value;
	}
}
