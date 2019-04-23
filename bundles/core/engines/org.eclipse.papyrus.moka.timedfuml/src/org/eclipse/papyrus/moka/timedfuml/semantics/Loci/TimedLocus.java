/*****************************************************************************
 * Copyright (c) 2017 CEA LIST.
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
 *  CEA LIST Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.moka.timedfuml.semantics.Loci;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Loci.SM_Locus;
import org.eclipse.papyrus.moka.timedfuml.semantics.StructuredClassifiers.TimedObject;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;

public class TimedLocus extends SM_Locus {

	public IObject_ instantiate(Class type) {
		// Behaves like in fUML except that type instance are not
		// Object_ but TimedObject.
		IObject_ object = null;
		if (type instanceof Behavior) {
			object = super.instantiate(type);
		} else {
			object = new TimedObject();
			object.addType(type);
			object.createFeatureValues();
			this.add(object);
		}
		return object;
	}
	
}
