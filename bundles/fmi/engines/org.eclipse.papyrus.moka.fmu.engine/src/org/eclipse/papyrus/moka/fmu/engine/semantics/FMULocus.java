/*****************************************************************************
 * 
 * Copyright (c) 2016 CEA LIST.
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
package org.eclipse.papyrus.moka.fmu.engine.semantics;

import org.eclipse.papyrus.moka.fmi.profile.util.FMIProfileUtil;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.timedfuml.semantics.Loci.TimedLocus;
import org.eclipse.uml2.uml.Class;

public class FMULocus extends TimedLocus {

	@Override
	public IObject_ instantiate(Class type) {
		IObject_ object ;
		if (FMIProfileUtil.isCS_FMU(type)) {
			object = new FMUObject() ;
			object.addType(type);
			object.createFeatureValues();
			this.add(object);
		}
		else {
			object = super.instantiate(type) ;
		}
		return object ;
	}

}
