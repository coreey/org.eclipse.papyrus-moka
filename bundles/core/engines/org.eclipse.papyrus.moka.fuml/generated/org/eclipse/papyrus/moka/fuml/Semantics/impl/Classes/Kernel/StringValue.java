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

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IStringValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;

public class StringValue extends PrimitiveValue implements IStringValue{

	public String value;

	public Object getUnderlying() {
		return this.value;
	}

	@Override
	public ValueSpecification specify() {
		// Return a literal string with the value of this string value.
		LiteralString literal = UMLFactory.eINSTANCE.createLiteralString();
		literal.setType(this.type);
		literal.setValue(this.value);
		return literal;
	}

	@Override
	public Boolean equals(IValue otherValue) {
		// Test if this string value is equal to the otherValue.
		// To be equal, the otherValue must have the same value as this string
		// value.
		boolean isEqual = false;
		if (otherValue instanceof StringValue) {
			isEqual = ((StringValue) otherValue).value.equals(this.value);
		}
		return isEqual;
	}

	@Override
	public IValue copy() {
		// Create a new string value with the same value as this string value.
		StringValue newValue = (StringValue) (super.copy());
		newValue.value = this.value;
		return newValue;
	}

	@Override
	public IValue new_() {
		// Create a new string value with no value.
		return new StringValue();
	}

	@Override
	public String toString() {
		return value;
	}

	@Override
	public String getValue() {
		return this.value;
	}
	
	@Override
	public void setValue(String value) {
		this.value = value;
	}
}
