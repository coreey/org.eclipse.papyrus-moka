/*****************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.cosimulation.semantics;

import org.eclipse.papyrus.moka.fmi.master.fmuproxy.Fmu2ProxyService;
import org.eclipse.papyrus.moka.fmi.profile.util.FMIProfileUtil;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.Loci.SM_Locus;
import org.eclipse.papyrus.moka.fuml.statemachines.Semantics.StructuredClassifiers.SM_Object;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;

public class CosimulationLocus extends SM_Locus {

	@Override
	public IObject_ instantiate(Class type) {
		// Instantiate the given class at this locus.

		IObject_ object = null;

		if (type instanceof Behavior) {
			object = super.instantiate(type);
		} else {
			if (FMIProfileUtil.isCS_FMU(type) ) {
				object = new Fmu2ProxyService(type);

			} else {
				object = new SM_Object();
			}
			object.addType(type);
			object.createFeatureValues();
			this.add(object);
		}
		return object;
	}

}
