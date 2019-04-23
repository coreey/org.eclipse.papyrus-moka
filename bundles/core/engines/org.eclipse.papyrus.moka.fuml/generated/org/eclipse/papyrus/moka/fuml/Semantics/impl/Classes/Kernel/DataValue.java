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
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IDataValue;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;

public class DataValue extends CompoundValue implements IDataValue {

	/*
	 * The type of this data value. This must not be a primitive or an
	 * enumeration.
	 */
	public DataType type;

	@Override
	public DataType getType() {
		return type;
	}

	@Override
	public void setType(DataType type) {
		this.type = type;
	}

	@Override
	public List<Classifier> getTypes() {
		// Return the single type of this data value.
		List<Classifier> types = new ArrayList<Classifier>();
		types.add(this.type);
		return types;
	}

	@Override
	public IValue copy() {
		// Create a new data value with the same type and feature values as this
		// data value.
		DataValue newValue = (DataValue) (super.copy());
		newValue.type = this.type;
		return newValue;
	}

	@Override
	public Value new_() {
		// Create a new data value with no type or feature values.
		return new DataValue();
	}
}
