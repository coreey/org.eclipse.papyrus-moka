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
package org.eclipse.papyrus.moka.fuml.Semantics.impl.CommonBehaviors.Communications;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.ISignalInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.CompoundValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Value;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Signal;

public class SignalInstance extends CompoundValue implements ISignalInstance {

	public Signal type;

	@Override
	public List<Classifier> getTypes() {
		// Return the single type of this signal instance.
		List<Classifier> types = new ArrayList<Classifier>();
		types.add(this.type);
		return types;
	}

	@Override
	public Value new_() {
		// Create a new signal instance with no type or feature values.
		return new SignalInstance();
	}

	@Override
	public Value copy() {
		// Create a new signal instance with the same type and feature values as
		// this signal instance.
		SignalInstance newValue = (SignalInstance) (super.copy());
		newValue.type = this.type;
		return newValue;
	}

	public void setType(Signal type) {
		this.type = type;
	}

	public Signal getType() {
		return this.type;
	}
}
