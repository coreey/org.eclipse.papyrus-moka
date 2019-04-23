/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.moka.composites.Semantics.impl.Loci.LociL3;

import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_Object;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1.Locus;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;


public class CS_Locus extends Locus {

	@Override
	public IObject_ instantiate(Class type) {
		// Extends fUML semantics by instantiating a CS_Object
		// in the case where type is not a Behavior.
		// Otherwise behaves like in fUML

		IObject_ object = null;

		if (type instanceof Behavior) {
			object = super.instantiate(type);
		} else {
			object = new CS_Object();
			object.addType(type);
			object.createFeatureValues();
			this.add(object);
		}

		return object;
	}
}
