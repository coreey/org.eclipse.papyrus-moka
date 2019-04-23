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

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IExtensionalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.ILocus;

public abstract class ExtensionalValue extends CompoundValue implements IExtensionalValue {

	/*
	 * Issue FUML12-33 Extensional values should have an unique identifier
	 * identifier (unique IF) of an extensional value
	 */
	public String identifier;

	/*
	 * The locus of the extent of which this value is a member. (If the value
	 * has been destroyed, it has no locus.)
	 */
	public ILocus locus;

	public void destroy() {
		// Remove this value from its locus (if it has not already been
		// destroyed).
		if (this.locus != null) {
			this.locus.remove(this);
		}
	}

	@Override
	public IValue copy() {
		// Create a new extensional value with the same feature values at the
		// same locus as this one.
		ExtensionalValue newValue = (ExtensionalValue) (super.copy());
		if (this.locus != null) {
			this.locus.add(newValue);
		}
		return newValue;
	}

	@Override
	public String toString() {
		// Issue FUML12-33 Extensional values should have an unique identifier
		return this.identifier + super.toString();
	}

	public void setLocus(ILocus locus) {
		this.locus = locus;
	}

	public ILocus getLocus() {
		return this.locus;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getIdentifier() {
		return this.identifier;
	}
}
