/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
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
 *  Jeremie Tatibouet (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Loci;

import org.eclipse.papyrus.moka.composites.Semantics.impl.Loci.LociL3.CS_Locus;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StructuredClassifiers.SM_Object;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;

public class SM_Locus extends CS_Locus {
	
	public IObject_ instantiate(Class type) {
		// Behaves like in fUML except that type instance are not
		// Object_ but SM_Object.
		IObject_ object = null;
		if (type instanceof Behavior) {
			object = super.instantiate(type);
		} else {
			object = new SM_Object();
			object.addType(type);
			object.createFeatureValues();
			this.add(object);
		}
		return object;
	}

	
}
