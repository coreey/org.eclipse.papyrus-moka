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

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IBooleanValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;

public class BooleanValue extends PrimitiveValue implements IBooleanValue {

	/*
	 * The actual Boolean value.
	 */
	public Boolean value;

	@Override
	public ValueSpecification specify() {
		// Return a literal boolean with the value of this boolean value.
		LiteralBoolean literal = UMLFactory.eINSTANCE.createLiteralBoolean();
		literal.setType(this.type);
		literal.setValue(this.value);
		return literal;
	}

	@Override
	public Boolean equals(IValue otherValue) {
		// Test if this boolean value is equal to the otherValue.
		// To be equal, the otherValue must have the same value as this boolean
		// value.
		boolean isEqual = false;
		if (otherValue instanceof BooleanValue) {
			isEqual = ((BooleanValue) otherValue).value.equals(this.value); // CHANGED == to equals;
		}
		return isEqual;
	}

	@Override
	public Value copy() {
		// Create a new boolean value with the same value as this boolean value.
		BooleanValue newValue = (BooleanValue) (super.copy());
		newValue.value = this.value;
		return newValue;
	}

	@Override
	public Value new_() {
		// Return a new boolean value with no value.
		return new BooleanValue();
	}

	@Override
	public String toString() {
		String stringValue = "false";
		if (this.value) {
			stringValue = "true";
		}
		return stringValue;
	}

	@Override
	public Boolean getValue() {
		return this.value;
	}

	@Override
	public void setValue(Boolean value) {
		this.value = value;
	}

}
