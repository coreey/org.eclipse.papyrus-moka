/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
 *  Jeremie Tatibouet (CEA LIST)
 *****************************************************************************/
package org.eclipse.papyrus.moka.async.fuml.Semantics.Loci.LociL1;

import org.eclipse.papyrus.moka.async.fuml.Semantics.Classes.Kernel.AsyncObject_;
import org.eclipse.papyrus.moka.composites.Semantics.impl.Loci.LociL3.CS_Locus;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IExtensionalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;

public class AsyncLocus extends CS_Locus {

	/**
	 * Instantiate method now create AsyncObject_ instead of Object_.
	 *
	 * @param type
	 *            the type
	 * @return the object_
	 */
	@Override
	public IObject_ instantiate(Class type) {
		// Instantiate the given class at this locus.
		IObject_ object = null;
		if (type instanceof Behavior) {
			object = this.factory.createExecution((Behavior) type, null);
		} else {
			object = new AsyncObject_();
			object.addType(type);
			object.createFeatureValues();
			this.add(object);
		}
		return object;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.Locus#remove(org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.ExtensionalValue)
	 */
	@Override
	public void remove(IExtensionalValue value) {
		synchronized (this) {
			super.remove(value);
		}
	}

}
