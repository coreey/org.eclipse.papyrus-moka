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

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IRealValue;
import org.eclipse.uml2.uml.LiteralReal;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;

public class RealValue extends PrimitiveValue implements IRealValue {

	/*
	 * The actual Real value.
	 */
	public double value;

	@Override
	public ValueSpecification specify() {
		// Return a literal real with the value of this real value.
		LiteralReal literal = UMLFactory.eINSTANCE.createLiteralReal();
		literal.setType(this.type);
		literal.setValue(this.value);
		return literal;
	}

	@Override
	public Boolean equals(IValue otherValue) {
		// Test if this real value is equal to the otherValue.
		// To be equal, the otherValue must have the same value as this real
		// value.
		boolean isEqual = false;
		if (otherValue instanceof RealValue) {
			isEqual = ((RealValue) otherValue).value == this.value;
		}
		return isEqual;
	}

	@Override
	public IValue copy() {
		// Create a new real value with the same value as this real value.
		RealValue newValue = (RealValue) (super.copy());
		newValue.value = this.value;
		return newValue;
	}

	@Override
	public IValue new_() {
		return new RealValue();
	}

	@Override
	public String toString() {
		String stringValue = "";
		if (this.value == 0) {
			stringValue = "0";
		} else {
			double positiveValue = this.value;
			if (positiveValue < 0) {
				positiveValue = -positiveValue;
			}
			int exponent = 0;
			if (positiveValue < .1) {
				while (positiveValue < .1) {
					positiveValue = positiveValue * 10;
					exponent = exponent - 1;
				}
			} else if (positiveValue >= 1) {
				while (positiveValue >= 1) {
					positiveValue = positiveValue / 10;
					exponent = exponent + 1;
				}
			}
			// This gives 9 significant digits in the mantissa.
			for (int i = 0; i < 9; i++) {
				positiveValue = positiveValue * 10;
			}
			IntegerValue integerValue = new IntegerValue();
			integerValue.value = (int) positiveValue;
			stringValue = "0." + integerValue.toString();
			integerValue.value = exponent;
			stringValue = stringValue + "E" + integerValue.toString();
			if (this.value < 0) {
				stringValue = "-" + stringValue;
			}
		}
		return stringValue;
	}


	@Override
	public Double getValue() {
		return this.value;
	}

	@Override
	public void setValue(Double value) {
		this.value = value;
	}
}
