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
package org.eclipse.papyrus.moka.composites.Semantics.impl.CommonBehaviors.Communications;

// Imports
import java.util.List;

import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Object;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IFeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Loci.LociL1.SemanticStrategy;
import org.eclipse.uml2.uml.StructuralFeature;

public abstract class CS_StructuralFeatureOfInterfaceAccessStrategy extends SemanticStrategy {

	@Override
	public String getName() {
		// StructuralFeatureAccessStrategy are always named "structuralFeature"
		return "structuralFeature";
	}

	public abstract IFeatureValue read(ICS_Object cs_Object, StructuralFeature feature);

	public abstract void write(ICS_Object cs_Object, StructuralFeature feature, List<IValue> values, Integer position);
}
