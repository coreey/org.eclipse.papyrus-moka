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

// Imports
import java.util.List;

import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_Object;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_Reference;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Object;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.IParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1.Executor;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.uml2.uml.Class;


public class CS_Executor extends Executor {

	@Override
	public IReference start(Class type, List<IParameterValue> inputs) {
		// Instantiate the given class and start any behavior of the resulting
		// object.
		// (The behavior of an object includes any classifier behaviors for an
		// active object or the class of the object itself, if that is a
		// behavior.)
		// fUML semantics is extended in the sense that when the instantiated object
		// is a CS_Object, a CS_Reference is returned (instead of a Reference)

		Debug.println("[start] Starting " + type.getName() + "...");

		IObject_ object = this.locus.instantiate(type);

		Debug.println("[start] Object = " + object);
		object.startBehavior(type, inputs);

		IReference reference;
		if (object instanceof ICS_Object) {
			reference = new CS_Reference();
			((ICS_Reference) reference).setCompositeReferent((CS_Object) object);
		} else {
			reference = new Reference();
		}
		reference.setReferent(object);

		return reference;
	}
}
