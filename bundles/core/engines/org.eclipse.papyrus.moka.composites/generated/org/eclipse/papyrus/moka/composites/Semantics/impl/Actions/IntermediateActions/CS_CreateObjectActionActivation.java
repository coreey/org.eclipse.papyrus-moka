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
package org.eclipse.papyrus.moka.composites.Semantics.impl.Actions.IntermediateActions;

import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_Object;
import org.eclipse.papyrus.moka.composites.Semantics.impl.CompositeStructures.StructuredClasses.CS_Reference;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Object;
import org.eclipse.papyrus.moka.composites.interfaces.Semantics.CompositeStructures.StructuredClasses.ICS_Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IObject_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IReference;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions.CreateObjectActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Actions.IntermediateActions.CreateObjectActionStrategy;
import org.eclipse.papyrus.moka.fuml.Semantics.impl.Classes.Kernel.Reference;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.CreateObjectAction;


public class CS_CreateObjectActionActivation extends CreateObjectActionActivation {

	@Override
	public void doAction() {
		// Create an object with the given classifier (which must be a class) as
		// its type, at the same locus as the action activation.
		// Place a reference to the object on the result pin of the action.
		// Extends fUML semantics in the sense that the reference placed
		// on the result pin is a CS_Reference (in the case where the instantiated object
		// is a CS_Object) not a Reference
		// Note that Locus.instantiate(Class) is extended in this specification
		// to produce a CS_Object instead of an Object in the case where the class
		// to be instantiated is not a behavior

		CreateObjectAction action = (CreateObjectAction) (this.node);

		IReference reference;
		IObject_ referent = ((CreateObjectActionStrategy) this.getExecutionLocus().getFactory().getStrategy("CreateObjectActionStrategy")).instantiate((Class) (action.getClassifier()), this.getExecutionLocus());
		if (referent instanceof ICS_Object) {
			reference = new CS_Reference();
			((ICS_Reference) reference).setCompositeReferent((CS_Object) referent);
		} else {
			reference = new Reference();
		}
		reference.setReferent(referent);

		this.putToken(action.getResult(), reference);
	}
}
